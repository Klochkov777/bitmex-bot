package pers.klochkov.bitmexBot.model;

import pers.klochkov.bitmexBot.constants.OrderSide;
import pers.klochkov.bitmexBot.constants.OrderType;
import pers.klochkov.bitmexBot.constants.Symbol;

public class Order {
    private Symbol symbol;
    private OrderSide side;
    private OrderType ordType = OrderType.LIMIT;
    private Double price;
    private Double orderQty;

    public Order(Symbol symbol, OrderSide side, Double price, Double orderQty) {
        this.symbol = symbol;
        this.side = side;
        this.price = price;
        this.orderQty = orderQty;
    }

    public String getSide() {
        return side.toString();
    }

    public void setSide(OrderSide side) {
        this.side = side;
    }

    public String getOrdType() {
        return ordType.toString();
    }

    public void setOrdType(OrderType ordType) {
        this.ordType = ordType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(Double orderQty) {
        this.orderQty = orderQty;
    }



    public String getSymbol() {
        return symbol.toString();
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
}
