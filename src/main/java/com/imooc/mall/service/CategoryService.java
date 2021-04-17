package com.imooc.mall.service;

import com.github.pagehelper.PageInfo;
import com.imooc.mall.model.pojo.Category;
import com.imooc.mall.model.request.AddCategoryRequest;
import com.imooc.mall.model.vo.CategoryVO;

import java.util.List;

public interface CategoryService {

    void addCategory(AddCategoryRequest addCategoryRequest);

    void updateCategory(Category updateCategory);

    void delete(Integer id);

    PageInfo listForAdmin(Integer pageNum, Integer pageSize);

    List<CategoryVO> listForCustomer(Integer parentId);
}
