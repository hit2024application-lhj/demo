package org.example.myapp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.myapp.bean.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 75654
* @description 针对表【user】的数据库操作Mapper
* @createDate 2024-06-03 21:17:46
* @Entity org.example.myapp.bean.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




