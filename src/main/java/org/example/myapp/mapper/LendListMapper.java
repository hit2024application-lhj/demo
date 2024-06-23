package org.example.myapp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.myapp.bean.LendList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author 75654
* @description 针对表【lend_list】的数据库操作Mapper
* @createDate 2024-06-23 10:02:06
* @Entity org.example.myapp.bean.LendList
*/
@Mapper
public interface LendListMapper extends BaseMapper<LendList> {
    List<LendList> selectLendListByStudentId(int s_id,int e_id);
}




