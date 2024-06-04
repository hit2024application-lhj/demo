package org.example.myapp.controller;


import com.alibaba.fastjson.JSON;
import org.example.myapp.service.EquipmentService;
import org.example.myapp.utils.ResponseJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @RequestMapping("/getEquipmetByUserId")
    public String getEquipmetByUserId(@RequestParam int user_id) {
        return JSON.toJSONString(ResponseJSON.getOK(equipmentService.getEquipmentsByUserId(user_id)));
    }

}
