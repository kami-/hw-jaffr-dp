package com.homework.jaffr.domain.cashier;

import com.homework.jaffr.domain.RestaurantMediator;
import com.homework.jaffr.domain.cashier.state.WaitingForClientState;
import com.homework.jaffr.domain.client.Client;
import com.homework.jaffr.domain.order.Order;
import com.homework.jaffr.domain.order.OrderItem;

public class Cashier implements Runnable {
    private RestaurantMediator restaurant;
    private Client myClient;
    private CashierState state;
    private Order order;
    private boolean orderPayed;

    public Cashier(RestaurantMediator restaurant) {
        super();
        this.restaurant = restaurant;
        this.state = new WaitingForClientState();
        this.order = new Order();
    }

    public Client getMyClient() {
        return myClient;
    }

    public void setClient(Client myClient) {
        this.myClient = myClient;
    }

    public boolean isFree() {
        return myClient == null;
    }

    public void run() {
        System.out.println("Cashier started");
        doExec();
        System.out.println("Client found!");
    }

    public void doExec() {
        state.exec(this);
    }

    public void clientLeft() {
        myClient = null;
    }

    public void setState(CashierState state) {
        this.state = state;
    }

    public boolean isOrderPayed() {
        return order.isFinished() && orderPayed;
    }

    public void sendOrder() {
        restaurant.sendOrder(order);
    }

    public boolean isOrderPrepared() {
        return true;
    }

    public void serveOrder() {
        // TODO Auto-generated method stub
        
    }

    public void order(OrderItem item) {
        order.addItem(item);
    }

    public void finishOrder() {
        order.setFinished(true);
    }

    public void cleanUp() {
        order = new Order();
        orderPayed = false;
    }

    public void payOrder() {
        orderPayed = true;
    }

}
