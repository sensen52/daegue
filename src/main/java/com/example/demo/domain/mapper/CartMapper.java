package com.example.demo.domain.mapper;

import com.example.demo.domain.daeguyo.CartDto;
import com.example.demo.domain.daeguyo.MenuDto;
import com.example.demo.domain.daeguyo.OrderDto;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface CartMapper {


    @Select("select * from tbl_cart  ")
    List<CartDto> CartList( );


    @Update("UPDATE tbl_cart SET count = #{count} WHERE cart_id = #{cart_id}")
    public void updateOrder(CartDto dto);

    @Insert("INSERT INTO tbl_order VALUES (#{order_id}, #{u_email}, #{menu_id}, #{res_id}, #{select_option}, #{order_amount}, #{total_price})")
    public int insertOrder(OrderDto orderData);


    @Delete("DELETE FROM tbl_cart WHERE cart_id = #{cart_id}")
    public int deleteOrder(String cart_id);



    @Select("select * from tbl_cart where cart_id =#{cart_id}")
    public CartDto selectOne(String cart_id);

    @Select("SELECT * FROM tbl_cart WHERE u_email = #{u_email} AND menu_id = #{menu_id} AND selected_option = #{selected_option}")
    public CartDto  ExistOrNot(@Param("u_email") String u_email, @Param("menu_id") String menu_id, @Param("selected_option") String selected_option);

    @Update("UPDATE tbl_cart SET count = #{count} WHERE cart_id = #{cart_id}")
    void updateCount(@Param("cart_id") String cart_id, @Param("count") int count);

    @Select("SELECT menu_id FROM tbl_cart WHERE u_email = #{u_email} LIMIT 1")
    String findMenuIdByUEmail(String u_email);

    @Delete("DELETE FROM tbl_cart WHERE u_email = #{u_email}")
    void deleteByUEmail(String u_email);

}
