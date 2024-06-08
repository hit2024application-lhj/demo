package org.example.myapp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.myapp.bean.Equipment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author 75654
* @description 针对表【equipment】的数据库操作Mapper
* @createDate 2024-06-04 20:57:32
* @Entity org.example.myapp.bean.Equipment
*/
@Mapper
public interface EquipmentMapper extends BaseMapper<Equipment> {
    // 模糊查询方法声明
    List<Equipment> findEquipmentByName(String subname,Integer userId);
}




