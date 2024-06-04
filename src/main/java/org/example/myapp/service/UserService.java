package org.example.myapp.service;

import org.example.myapp.bean.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 75654
* @description 针对表【user】的数据库操作Service
* @createDate 2024-06-03 21:17:46
*/
public interface UserService extends IService<User> {
    public User findUserByUsername(String username);
    public int insertUser(User user);
    public int updateUser(User user,String new_password);
}
