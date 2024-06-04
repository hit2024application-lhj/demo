package org.example.myapp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.myapp.bean.Equipment;
import org.example.myapp.service.EquipmentService;
import org.example.myapp.mapper.EquipmentMapper;
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
        return null;
    }

    @Override
    public List<Equipment> getEquipmentsByUserId(Integer user_id) {
        QueryWrapper<Equipment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", user_id);
        return equipmentMapper.selectList(queryWrapper);
    }

    @Override
    public int addEquipment(Equipment equipment) {
        return equipmentMapper.insert(equipment);
    }
}




