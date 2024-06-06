package org.example.myapp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.myapp.bean.Category;
import org.example.myapp.service.CategoryService;
import org.example.myapp.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 75654
* {@code @description} 针对表【category】的数据库操作Service实现
* {@code @createDate} 2024-06-04 20:57:27
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
    implements CategoryService{

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public int addCategory(Category category) {
        return categoryMapper.insert(category);
    }

    @Override
    public List<Category> getCategories() {
        return categoryMapper.selectList(null);
    }
}




