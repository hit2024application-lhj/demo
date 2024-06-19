package org.example.myapp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.myapp.bean.Equipment;
import org.example.myapp.bean.PageResult;
import org.example.myapp.service.EquipmentService;
import org.example.myapp.mapper.EquipmentMapper;
import org.example.myapp.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 75654
* {@code @description} 针对表【equipment】的数据库操作Service实现
* &#064;createDate  2024-06-04 20:57:32
 */
@Service
public class EquipmentServiceImpl extends ServiceImpl<EquipmentMapper, Equipment>
    implements EquipmentService{

    //分页大小
    static final int pageSize=4;

    @Autowired
    private EquipmentMapper equipmentMapper;

    @Override
    public List<Equipment> getEquipments() {
        try {
            return equipmentMapper.selectList(null);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Equipment getEquipmentById(int id) {
        return equipmentMapper.selectById(id);
    }

    @Override
    public List<Equipment> getEquipmentsByUserId(Integer user_id) {
        QueryWrapper<Equipment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", user_id);
        return equipmentMapper.selectList(queryWrapper);
    }

    @Override
    public PageResult getEquipmentsByEquipmentWithPage(Integer user_id, int pageId) {


        QueryWrapper<Equipment> queryWrapper = new QueryWrapper<>();
        if(user_id!=-1){
            queryWrapper.eq("user_id", user_id);
        }
        List<Equipment> lists=equipmentMapper.selectList(queryWrapper);
        MyPageHelper<Equipment> pageHelper=new MyPageHelper<>(lists);

        return pageHelper.getPageResult(pageId,pageSize);
    }

    @Override
    public PageResult getEquipmentsBySubName(Integer user_id, String subname, int pageId) {
        List<Equipment> lists=equipmentMapper.findEquipmentByName(subname,user_id);
        MyPageHelper<Equipment> pageHelper=new MyPageHelper<>(lists);
        return pageHelper.getPageResult(pageId,pageSize);
    }




    @Override
    public int addEquipment(Equipment equipment) {
        return equipmentMapper.insert(equipment);
    }



    @Override
    public int deleteEquipmentById(int id) {
        return equipmentMapper.deleteById(id);
    }

    @Override
    public int scrapEquipmentById(int id) {
        UpdateWrapper<Equipment> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("is_scrap",1);
        updateWrapper.eq("id", id);
        return equipmentMapper.update(updateWrapper);
    }

    @Override
    public int lendEquipmentById(int id) {
        UpdateWrapper<Equipment> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("is_lend",1);
        updateWrapper.eq("id", id);
        return equipmentMapper.update(updateWrapper);
    }

    @Override
    public int recoveryEquipmentById(int id) {
        UpdateWrapper<Equipment> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("is_lend",0);
        updateWrapper.eq("id", id);
        return equipmentMapper.update(updateWrapper);
    }
}




