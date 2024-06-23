package org.example.myapp.service;

import org.example.myapp.bean.Equipment;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.myapp.bean.PageResult;

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

    /**
     * 分页查找
     * @param user_id
     * @param page
     * @return
     */
    PageResult getEquipmentsByEquipmentWithPage(Integer user_id, int page);
    int addEquipment(Equipment equipment);

    /**
     * 字符串匹配模糊查找
     * @param user_id
     * @param subname
     * @param page
     * @return
     */
    PageResult getEquipmentsBySubName(Integer user_id,String subname ,int page);

    int deleteEquipmentById(int id);

    int scrapEquipmentById(int id);

    //借出
    int lendEquipmentById(int id);

    int lendEquipmentById_s(int id,int s_id);
    //借出后收回
    int recoveryEquipmentById(int id);

    int recoveryEquipmentById_s(int id,int s_id);


}
