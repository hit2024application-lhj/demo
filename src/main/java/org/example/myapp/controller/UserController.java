package org.example.myapp.controller;


import com.alibaba.fastjson.JSON;
import org.example.myapp.bean.User;
import org.example.myapp.service.UserService;
import org.example.myapp.utils.ResponseJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public String login(String username, String password) {
        User u=userService.findUserByUsername(username);
        if(password.equals(u.getUserKey())){
            return JSON.toJSONString(ResponseJSON.getOK("OK",u));
        }
        else return JSON.toJSONString(ResponseJSON.getERROR());
    }

    @ResponseBody
    @RequestMapping("/register")
    public String register(String username, String password) {
        User u=new User(username,password);
        //注册
        int r=userService.insertUser(u);
        if (r==0){
            return JSON.toJSONString(ResponseJSON.getERROR());
        }
        return JSON.toJSONString(ResponseJSON.getOK("OK"));
    }

    @ResponseBody
    @RequestMapping("/update")
    public String change(String username, String password,String new_password) {
        User u=userService.findUserByUsername(username);
        if(password.equals(u.getUserKey())){
            int r=userService.updateUser(u,new_password);
            if (r==0){
                return JSON.toJSONString(ResponseJSON.getERROR("修改失败"));
            }
            return JSON.toJSONString(ResponseJSON.getOK("OK"));
        }
        else return JSON.toJSONString(ResponseJSON.getERROR("密码错误"));
    }


}
