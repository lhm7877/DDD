package com.hoomin.myshop;

/**
 * @author : lhm0805
 * @date : 2019-02-20
 */
public class ShopApplication {
    public static void main(String... args){
        Order order = new Order();
        ShippingInfo shippingInfo = new ShippingInfo();
        order.changeShippingInfo(shippingInfo);

    }
}