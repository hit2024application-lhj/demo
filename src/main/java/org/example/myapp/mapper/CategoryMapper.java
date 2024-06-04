package org.example.myapp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.myapp.bean.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 75654
* @description 针对表【category】的数据库操作Mapper
* @createDate 2024-06-04 20:57:27
* @Entity org.example.myapp.bean.Category
*/
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

}




