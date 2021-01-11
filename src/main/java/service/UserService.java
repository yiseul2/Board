package service;

import domain.User;

public interface UserService {
    boolean register(User user);
    String login(String account_id, String password);
}
