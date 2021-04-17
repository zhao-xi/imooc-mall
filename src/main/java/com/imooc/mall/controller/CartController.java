package com.imooc.mall.controller;

import com.imooc.mall.common.ApiRestResponse;
import com.imooc.mall.filter.UserFilter;
import com.imooc.mall.model.pojo.User;
import com.imooc.mall.model.vo.CartVO;
import com.imooc.mall.service.CartService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @ApiOperation("添加商品到购物车")
    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse add(@RequestParam Integer productId, @RequestParam Integer count) {
        cartService.add(UserFilter.currentUser.getId(), productId, count);
        return ApiRestResponse.success();
    }

    @ApiOperation("购物车列表")
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse list() {
        // 内部获取用户ID，防止横向越权
        List<CartVO> cartList = cartService.list(UserFilter.currentUser.getId());
        return ApiRestResponse.success(cartList);
    }

    @ApiOperation("更新购物车")
    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse update(@RequestParam Integer productId, @RequestParam Integer count) {
        List<CartVO> cartVOList = cartService.update(UserFilter.currentUser.getId(), productId, count);
        return ApiRestResponse.success(cartVOList);
    }

    @ApiOperation("删除购物车")
    @PostMapping("/delete")
    @ResponseBody
    public ApiRestResponse delete(@RequestParam Integer productId) {
        List<CartVO> cartVOList = cartService.delete(UserFilter.currentUser.getId(), productId);
        return ApiRestResponse.success(cartVOList);
    }

    @ApiOperation("选中/取消选中购物车中的某商品")
    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse select(@RequestParam Integer productId, @RequestParam Integer selected) {
        List<CartVO> cartVOList = cartService.selectOrNot(UserFilter.currentUser.getId(), productId, selected);
        return ApiRestResponse.success(cartVOList);
    }

    @ApiOperation("全选/全不选购物车中的某商品")
    @PostMapping("/selectAll")
    @ResponseBody
    public ApiRestResponse selectAll(@RequestParam Integer selected) {
        List<CartVO> cartVOList = cartService.selectAllOrNot(UserFilter.currentUser.getId(), selected);
        return ApiRestResponse.success(cartVOList);
    }
}
