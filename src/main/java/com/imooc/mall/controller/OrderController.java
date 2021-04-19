package com.imooc.mall.controller;

import com.imooc.mall.common.ApiRestResponse;
import com.imooc.mall.filter.UserFilter;
import com.imooc.mall.model.request.CreateOrderRequest;
import com.imooc.mall.model.vo.CartVO;
import com.imooc.mall.model.vo.OrderVO;
import com.imooc.mall.service.OrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 订单controller
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @ApiOperation("创建订单")
    @PostMapping("/order/create")
    public ApiRestResponse create(@RequestBody CreateOrderRequest createOrderRequest) {
        String orderNo = orderService.create(createOrderRequest);
        return ApiRestResponse.success(orderNo);
    }

    @ApiOperation("前台订单详情")
    @PostMapping("/order/detail")
    public ApiRestResponse detail(@RequestParam String orderNo) {
        OrderVO orderVO = orderService.detail(orderNo);
        return ApiRestResponse.success(orderVO);
    }
}
