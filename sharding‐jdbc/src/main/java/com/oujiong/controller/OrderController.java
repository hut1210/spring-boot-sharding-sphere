package com.oujiong.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.oujiong.entity.Order;
import com.oujiong.mapper.OrderMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author huteng5
 * @version 1.0
 * @date 2022/1/14 15:21
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Resource
    private OrderMapper orderMapper;

    @PostMapping("save")
    public Object save() {
        for(int i=1;i<20;i++){
            //orderMapper.insertOrder(new BigDecimal(i),1L,"SUCCESS");
            Order order = new Order();
            order.setPrice(new BigDecimal(i));
            order.setUserId(Long.valueOf(i));
            order.setStatus("SUCCESS");
            orderMapper.insert(order);
        }
        return "SUCCESS";
    }
    @GetMapping("list")
    public Object list() {
        List<Long> ids = new ArrayList<>();
        ids.add(688774316598231041L);
        ids.add(688774319181922305L);
        return orderMapper.selectOrderbyIds(ids);
    }

    @GetMapping("listAll1")
    public Object listAll1() {
        return orderMapper.selectOrders();
    }

    @GetMapping("listAll2")
    public Object listAll2() {
        return orderMapper.selectList(new QueryWrapper()).stream().sorted(Comparator.comparing(Order::getUserId));
    }
}
