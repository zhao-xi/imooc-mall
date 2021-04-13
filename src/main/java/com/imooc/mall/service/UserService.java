package com.imooc.mall.service;

import com.imooc.mall.exception.ImoocMallException;
import com.imooc.mall.model.pojo.User;

/**
 * UserService
 */
public interface UserService {
    public User getUser(Integer id);
    public void register(String userName, String password) throws ImoocMallException;
}
