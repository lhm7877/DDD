package com.hoomin.myshop;

/**
 * @author : lhm0805
 * @date : 2019-02-20
 */
public class Order {
    private OrderState state;
    private ShippingInfo shippingInfo;

    public void changeShippingInfo(ShippingInfo newShippingInfo){
        if (!isShippingChangeable()) {
            throw new IllegalStateException("can't change shipping in" + state);
        }
        this.shippingInfo = newShippingInfo;
    }

    // 배송지 정보 변경 가능 여부를 판단하는 로직이 Order 도메인에 있다.
    private boolean isShippingChangeable() {
        return state == OrderState.PAYMENT_WAITING || state == OrderState.PREPARING;
    }
}
