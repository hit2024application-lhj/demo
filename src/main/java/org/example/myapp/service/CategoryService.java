package org.example.myapp.service;

import org.example.myapp.bean.Category;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 75654
* @description 针对表【category】的数据库操作Service
* @createDate 2024-06-04 20:57:27
*/
public interface CategoryService extends IService<Category> {

    int addCategory(Category category);

    List<Category> getCategories();
}
