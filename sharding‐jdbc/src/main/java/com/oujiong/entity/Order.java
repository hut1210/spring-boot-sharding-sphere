package com.oujiong.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author huteng5
 * @version 1.0
 * @date 2022/1/14 15:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_order")
public class Order {

    private Long orderId;
    private BigDecimal price;
    private Long userId;
    private String status;
}
