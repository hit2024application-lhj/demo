package org.example.myapp.controller;

import com.alibaba.fastjson2.JSON;
import org.example.myapp.service.CategoryService;
import org.example.myapp.utils.ResponseJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @ResponseBody
    @RequestMapping("/getList")
    public String getCategoryList(){
        return JSON.toJSONString(ResponseJSON.getOK(categoryService.getCategories()));
    }

}
