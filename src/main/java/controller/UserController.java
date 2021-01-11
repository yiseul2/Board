package controller;

import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public ResponseEntity<String> join(@ModelAttribute("User") @RequestBody User user) {
        return userService.register(user) ? new ResponseEntity<>("success", HttpStatus.OK) :
                new ResponseEntity<>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> login(String account_id, String password) {
        if(userService.login(account_id, password) != null)
            return new ResponseEntity<>("success", HttpStatus.OK);
        else
            return new ResponseEntity<>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
