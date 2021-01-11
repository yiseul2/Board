package service;

import domain.User;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserMapper;
import util.JwtUtil;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    JwtUtil jwtUtil;

    @Override
    public boolean register(User user) {
        // 계정 중복 체크
        if(userMapper.getUserByAccountId(user.getAccount_id()) != null)
            return false;

        // bcrypt 를 이용한 password 암호화
        String hashed_pw = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed_pw);

        // DB에 유저 정보 저장
        return userMapper.createUser(user) == 1;
    }

    @Override
    public String login(String account_id, String password) {
        // 계정 찾기
        User user = userMapper.getUserByAccountId(account_id);

        // 계정 유무 & 비밀번호 일치여부 확인 => 비밀번호 일치하면 토큰 생성
        if(user != null && (BCrypt.checkpw(password, user.getPassword()) == true))
           return jwtUtil.createJwt(user.getId());
        else
            return null;
    }
}
