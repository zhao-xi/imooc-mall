package com.imooc.mall.service;

import com.imooc.mall.model.request.CreateOrderRequest;
import com.imooc.mall.model.vo.CartVO;
import com.imooc.mall.model.vo.OrderVO;

import java.util.List;

/**
 * OrderService
 */
public interface OrderService {

    String create(CreateOrderRequest createOrderRequest);

    OrderVO detail(String orderNo);
}
