package org.example.myapp.controller;


import com.alibaba.fastjson.JSON;
import org.example.myapp.service.EquipmentService;
import org.example.myapp.utils.ImageUtil;
import org.example.myapp.utils.ResponseJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @RequestMapping("/getEquipmetByUserId")
    @ResponseBody
    public String getEquipmetByUserId(@RequestParam int user_id) {
        return JSON.toJSONString(ResponseJSON.getOK(equipmentService.getEquipmentsByUserId(user_id)));
    }

    @ResponseBody
    @PostMapping("/upload")
    public String upload(@RequestParam String ImageUrl) {
        ImageUtil.WriteBase64ToFile("czw.jpg",ImageUrl);
        return JSON.toJSONString(ResponseJSON.getOK());
    }

}
