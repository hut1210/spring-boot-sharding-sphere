package com.oujiong.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oujiong.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author huteng5
 * @version 1.0
 * @date 2022/1/14 15:21
 */
@Repository
public interface OrderMapper extends BaseMapper<Order> {
    /**
     * 插入订单
     * application.yml中 type: SNOWFLAKE #3.指定t_order表的主键生成策略为SNOWFLAKE，SNOWFLAKE是一种分布式自增算法，保证id全局唯一 ,所以这里不需要插入id，会由Sharding-JDBC来生成
     * @param price
     * @param userId
     * @param status
     * @return
     */
    /*@Insert("insert into t_order(price,user_id,status)values(#{price},#{userId},#{status})")
    int insertOrder(@Param("price") BigDecimal price, @Param("userId")Long userId, @Param("status")String status);*/

    /**
     * 根据id列表查询订单
     * @param orderIds
     * @return
     */
    @Select("<script>" +
            "select" +
            " * " +
            " from t_order t " +
            " where t.order_id in " +
            " <foreach collection='orderIds' open='(' separator=',' close=')' item='id'>" +
            " #{id} " +
            " </foreach>" +
            "</script>")
    List<Map> selectOrderbyIds(@Param("orderIds") List<Long> orderIds);

    @Select("<script>" +
            "select" +
            " * " +
            " from t_order t "+
            "</script>")
    List<Map> selectOrders();
}
