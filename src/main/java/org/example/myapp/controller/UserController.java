package org.example.myapp.controller;


import com.alibaba.fastjson.JSON;
import org.example.myapp.Vo.UserVo;
import org.example.myapp.bean.User;
import org.example.myapp.service.UserService;
import org.example.myapp.utils.ResponseJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public String login(String username, String password) {
        User u=userService.findUserByUsername(username);
        if(u==null){
            return JSON.toJSONString(ResponseJSON.getERROR("账号或密码错误"));
        }
        if(password.equals(u.getUserKey())){
            return JSON.toJSONString(ResponseJSON.getOK("OK",new UserVo(u)));
        }
        else return JSON.toJSONString(ResponseJSON.getERROR("账号或密码错误"));
    }

    /**
     * 注册
     * @param username
     * @param password
     * @return
     */
    @ResponseBody
    @PostMapping("/register")
    public String register(String username, String password) {
        User u=new User(username,password);
        //注册
        int r=userService.insertUser(u);
        if (r==0){
            return JSON.toJSONString(ResponseJSON.getERROR());
        }
        return JSON.toJSONString(ResponseJSON.getOK("OK"));
    }

    /**
     * 更新用户数据
     * @param username
     * @param password
     * @param new_password
     * @return
     */
    @ResponseBody
    @PostMapping("/update")
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

    @RequestMapping("")
    public String start(){
        return "/res/html/login.html";
    }


}
