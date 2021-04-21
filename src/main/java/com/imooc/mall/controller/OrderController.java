package com.imooc.mall.controller;

import com.github.pagehelper.PageInfo;
import com.imooc.mall.common.ApiRestResponse;
import com.imooc.mall.filter.UserFilter;
import com.imooc.mall.model.request.CreateOrderRequest;
import com.imooc.mall.model.vo.CartVO;
import com.imooc.mall.model.vo.OrderVO;
import com.imooc.mall.service.OrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/order/detail")
    public ApiRestResponse detail(@RequestParam String orderNo) {
        OrderVO orderVO = orderService.detail(orderNo);
        return ApiRestResponse.success(orderVO);
    }

    @ApiOperation("前台订单列表")
    @GetMapping("/order/list")
    public ApiRestResponse list(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        PageInfo pageInfo = orderService.listForCustomer(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }

    @ApiOperation("前台取消订单")
    @PostMapping("/order/cancel")
    public ApiRestResponse cancel(@RequestParam String orderNo) {
        orderService.cancel(orderNo);
        return ApiRestResponse.success();
    }

    @ApiOperation("生成二维码")
    @GetMapping("/order/qrcode")
    public ApiRestResponse qrcode(@RequestParam String orderNo) {
        String pngAddr = orderService.qrcode(orderNo);
        return ApiRestResponse.success(pngAddr);
    }

    @ApiOperation("支付接口")
    @GetMapping("/pay")
    public ApiRestResponse pay(@RequestParam String orderNo) {
        orderService.pay(orderNo);
        return ApiRestResponse.success();
    }
}
