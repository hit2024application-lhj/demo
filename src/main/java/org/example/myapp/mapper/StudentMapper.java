package org.example.myapp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.myapp.bean.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 75654
* @description 针对表【student】的数据库操作Mapper
* @createDate 2024-06-19 15:10:39
* @Entity org.example.myapp.bean.Student
*/
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}




