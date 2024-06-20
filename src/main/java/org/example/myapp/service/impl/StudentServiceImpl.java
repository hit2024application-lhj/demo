package org.example.myapp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.myapp.bean.Student;
import org.example.myapp.service.StudentService;
import org.example.myapp.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author 75654
* @description 针对表【student】的数据库操作Service实现
* @createDate 2024-06-19 15:10:39
*/
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
    implements StudentService{

    @Autowired
    StudentMapper studentMapper;
    @Override
    public Student getStudentByName(String name) {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name);
        return studentMapper.selectOne(queryWrapper);
    }

    @Override
    public int addStudent(Student student) {
        return studentMapper.insert(student);
    }
}




