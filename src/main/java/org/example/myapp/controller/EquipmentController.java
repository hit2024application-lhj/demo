package org.example.myapp.controller;


import com.alibaba.fastjson.JSON;
import org.example.myapp.bean.Equipment;
import org.example.myapp.service.EquipmentService;
import org.example.myapp.utils.AppInfo;
import org.example.myapp.utils.ImageUtil;
import org.example.myapp.utils.ResponseJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    /**
     * 这是字符串搜索匹配
     * @param keyword
     * @param user_id
     * @param pageId
     * @return
     */
    @ResponseBody
    @RequestMapping("/search")
    public String search(@RequestParam String keyword,@RequestParam String user_id,@RequestParam(name = "pageId",defaultValue = "1")String pageId) {
        System.out.println("!!-------------"+keyword+"--------------!!!");
        if(keyword.equals("undefined")){
            return JSON.toJSONString(
                    ResponseJSON.getOK(
                            equipmentService.getEquipmentsByEquipmentWithPage(Integer.parseInt(user_id),Integer.parseInt(pageId)
                            )
                    )
            );
        }
        else {
            return JSON.toJSONString(
                    ResponseJSON.getOK(
                            equipmentService.getEquipmentsBySubName(Integer.parseInt(user_id),keyword,Integer.parseInt(pageId)
                            )
                    )
            );
        }

    }

    /**
     * 上传数据
     * @param ImageUrl
     * @param name
     * @param user_id
     * @param category_id
     * @param description
     * @return
     */
    @ResponseBody
    @RequestMapping("/upload")
    public String upload(String ImageUrl,@RequestParam String name,@RequestParam String user_id,@RequestParam String category_id,@RequestParam String description)
    {
        if(ImageUrl==null){
            return JSON.toJSONString(ResponseJSON.getERROR("图片过大！请压缩图片"));
        }
        String filename=category_id+"_"+user_id+"_"+name+".jpg";
        String Url= AppInfo.WebRootPath+category_id+"_"+user_id+"_"+name+".jpg";
        System.out.println(filename);
        ImageUtil.WriteBase64ToFile(filename,ImageUrl);
        System.out.println("图片保存完毕！！");
        long currentTimeMillis = System.currentTimeMillis();

        // 将毫秒数转化为Date对象
        Date currentDate = new Date(currentTimeMillis);

        // 打印Date对象
        System.out.println("当前时间: " + currentDate);
        Equipment e=new Equipment(name,Integer.valueOf(category_id),Url,currentDate,0,0,Integer.valueOf(user_id),description);

        int r=equipmentService.addEquipment(e);
        if (r>0){
            return JSON.toJSONString(ResponseJSON.getOK("添加成功"));
        }
        else {
            return JSON.toJSONString(ResponseJSON.getERROR("添加失败"));
        }
    }


    /**
     * 测试
     * @return
     */
    @ResponseBody
    @RequestMapping("/test")
    public String test() {
        return JSON.toJSONString(ResponseJSON.getOK(
                "ok",equipmentService.getEquipmentsBySubName(1,"电脑",1)
            )
        );
    }

}
