package com.imooc.mall.controller;

import com.imooc.mall.common.ApiRestResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartController {
    public ApiRestResponse add(@RequestParam Integer productId, @RequestParam Integer count) {

    }
}
