package com.hoomin.myshop;

import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * @author : lhm0805
 * @date : 2019-02-20
 */
public class Order {
    private OrderState state;
    private ShippingInfo shippingInfo;
    private List<OrderLine> orderLines;
    private Money totalAmounts;

    public Order(List<OrderLine> orderLines) {
        setOrderLines(orderLines);
    }

    private void setOrderLines(List<OrderLine> orderLines) {
        verifyAtLeastOneOrMoreOrderLines(orderLines);
        this.orderLines = orderLines;
        calculateTotalAmounts();
    }

    private void verifyAtLeastOneOrMoreOrderLines(List<OrderLine> orderLines) {
        if (CollectionUtils.isEmpty(orderLines)) {
            throw new IllegalArgumentException("no OrderLine");
        }
    }

    private void calculateTotalAmounts(){
        this.totalAmounts = new Money(orderLines.stream()
                .mapToInt(OrderLine::getAmounts).sum());
    }

    public void changeShippingInfo(ShippingInfo newShippingInfo) {
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
