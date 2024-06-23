package org.example.myapp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.myapp.bean.LendList;
import org.example.myapp.service.LendListService;
import org.example.myapp.mapper.LendListMapper;
import org.springframework.stereotype.Service;

/**
* @author 75654
* @description 针对表【lend_list】的数据库操作Service实现
* @createDate 2024-06-23 10:02:06
*/
@Service
public class LendListServiceImpl extends ServiceImpl<LendListMapper, LendList>
    implements LendListService{

}




