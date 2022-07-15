package com.example.demo.Controller;

import com.example.demo.Entity.LoginEntity;
import com.example.demo.Repository.LoginRepository;
import com.example.demo.Request.CreateLogInRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/login")
public class LoginController {

    @Autowired
    private LoginRepository loginRepository;

    @PostMapping(path="/create")
    public @ResponseBody String create (@RequestBody CreateLogInRequest createLogInRequest) {

        LoginEntity le = new LoginEntity();
        le.setUserId(createLogInRequest.getUserId());
        le.setPassword(createLogInRequest.getPassword());
        Iterable<LoginEntity> all = loginRepository.findAll();
        for(LoginEntity login: all){
            if(login.getUserId().equals(le.getUserId()) &&
            login.getPassword().equals(le.getPassword())){
                return "User Already Present";
            }
        }
        loginRepository.save(le);
        return "User Credentials Added";
    }

    @PostMapping(path="/")
    public @ResponseBody String login (@RequestBody CreateLogInRequest createLogInRequest) {
        Iterable<LoginEntity> loginEntity = loginRepository.findAll();
        for(LoginEntity login: loginEntity){
            if(login.getUserId().equals(createLogInRequest.getUserId()) &&
                    login.getPassword().equals(createLogInRequest.getPassword())){
                return "LogIn Successful...";
            }
        }
        return "Invalid credentials...";
    }

    @GetMapping(path="/get")
    public @ResponseBody Iterable<LoginEntity> get() {
        return loginRepository.findAll();
    }

}
