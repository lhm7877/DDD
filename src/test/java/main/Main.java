package main;

import org.junit.Test;


/**
 * @author : lhm0805
 * @date : 2019-03-15
 */
public class Main {

    @Test
    public void mutableTest(){

        Money price = new Money(3);
        OrderLine orderLine = new OrderLine(1, price);
        price.setValue(4);
        System.out.println(orderLine.getAmounts());
        System.out.println();
    }
    class OrderLine{
        private int quantity;
        private Money amounts;

        public OrderLine(int quantity, Money amounts) {
            this.quantity = quantity;
            this.amounts = new Money(amounts.value);
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public Money getAmounts() {
            return amounts;
        }

        public void setAmounts(Money amounts) {
            this.amounts = amounts;
        }
    }

    class Money{
        private int value;

        public Money(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Money add(Money money){
            return new Money(this.value + money.value);
        }
    }
}
