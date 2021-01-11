package util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.security.spec.KeySpec;
import java.sql.Timestamp;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secretKey;
    private Key key;

    @PostConstruct
    void jwtUtil() {
        this.key = Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    // jwt 생성
    public String createJwt(Long id) {

        Map<String,Object> headers = new HashMap<>();
        headers.put("typ","JWT");
        headers.put("alg", "HS256");

        Map<String,Object> payloads = new HashMap<>();
        payloads.put("sub", id);
        payloads.put("exp", new Timestamp(System.currentTimeMillis() + (1000*60*60)));

        String jwt = Jwts.builder()
                .setHeader(headers)
                .setClaims(payloads)
                .signWith(key)
                .compact();

        return jwt;
    }

    // 토큰에서 user id 알아내기
    // 토큰 만료 확인
}
