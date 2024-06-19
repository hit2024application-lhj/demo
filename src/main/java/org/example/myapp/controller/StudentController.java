package org.example.myapp.controller;

import com.alibaba.fastjson.JSON;
import org.example.myapp.Vo.StudentVo;
import org.example.myapp.bean.Student;
import org.example.myapp.service.StudentService;
import org.example.myapp.utils.ResponseJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/student")
public class StudentController {


    @Autowired
    private StudentService studentService;
    /**
     * 学生登录
     * @param username
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        Student sv=studentService.getStudentByName(username);
        if(sv==null) {
            return JSON.toJSONString(ResponseJSON.getERROR("错误的账号或密码"));
        }
        else return JSON.toJSONString(ResponseJSON.getOK(new StudentVo(sv)));
    }


    /**
     * 学生注册
     * @param username
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password) {
        int r=studentService.addStudent(new Student(username,password));
        if (r<=0){
            return JSON.toJSONString(ResponseJSON.getERROR());
        }
        else {
            return JSON.toJSONString(ResponseJSON.getOK());
        }
    }
}
