package com.homework.jaffr.domain.client;

import com.homework.jaffr.domain.RestaurantMediator;
import com.homework.jaffr.domain.cashier.Cashier;
import com.homework.jaffr.domain.client.state.LookigForCashierState;
import com.homework.jaffr.domain.order.OrderItem;


public class Client implements Runnable {
    private RestaurantMediator restaurant;
    private Cashier myCashier;
    private int happiness = 1;
    private ClientState state;

    public Client(RestaurantMediator restaurant) {
        super();
        this.restaurant = restaurant;
        this.state = new LookigForCashierState();
    }

    public Cashier getCashier() {
        return myCashier;
    }

    public void setCashier(Cashier Cashier) {
        this.myCashier = Cashier;
    }

    public void setState(ClientState state) {
        this.state = state;
    }

    public void run() {
        System.out.println("Client started");
        doExec();
        System.out.println("Cashier found!");
    }

    public void lookForFreeCashier() {
        restaurant.lookForFreeCashier(this);
    }

    public void leave() {
        myCashier.setClient(null);
        restaurant.leave(this);
        System.out.println("Client left");
    }
    
    public boolean hasFoundCashier() {
        return myCashier != null;
    }

    public void doExec() {
        state.exec(this);
    }

    public void orderItem(OrderItem item) {
        myCashier.order(item);
    }

    public void setDiscount() {
        System.out.println("Client discount!");
    }

    public void payOrder() {
        myCashier.payOrder();
    }

    public boolean hasReceivedOrder() {
        return true;
    }

    public void finishOrder() {
        myCashier.finishOrder();
    }

}
