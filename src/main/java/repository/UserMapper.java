package repository;

import domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int createUser(User user); // insert 성공 시 1 반환
    User getUserByAccountId(String account_id);
}
