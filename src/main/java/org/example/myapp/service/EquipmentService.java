package org.example.myapp.service;

import org.example.myapp.bean.Equipment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 75654
* @description 针对表【equipment】的数据库操作Service
* @createDate 2024-06-04 20:57:32
*/
public interface EquipmentService extends IService<Equipment> {
    List<Equipment> getEquipments();

    Equipment getEquipmentById(int id);

    /**
     * 根据用户id操作可以操作的设备（只能管理自己属下的设备）
     * @param user_id
     * @return 一个设备对象的列表
     */
    List<Equipment> getEquipmentsByUserId(Integer user_id);

    int addEquipment(Equipment equipment);

    int deleteEquipmentById(int id);

    int scrapEquipmentById(int id);

    //借出
    int lendEquipmentById(int id);

    //借出后收回
    int recoveryEquipmentById(int id);
}
