package org.example.myapp.service;

import org.example.myapp.bean.Student;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 75654
* @description 针对表【student】的数据库操作Service
* @createDate 2024-06-19 15:10:39
*/
public interface StudentService extends IService<Student> {

    Student getStudentByName(String name);

    int addStudent(Student student);
}
