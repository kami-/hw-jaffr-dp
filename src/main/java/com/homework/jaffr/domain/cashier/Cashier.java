package com.homework.jaffr.domain.cashier;

import com.homework.jaffr.domain.RestaurantMediator;
import com.homework.jaffr.domain.cashier.state.WaitingForClientState;
import com.homework.jaffr.domain.client.Client;

public class Cashier implements Runnable {
    private RestaurantMediator restaurant;
    private Client myClient;
    private CashierState state;

    public Cashier(RestaurantMediator restaurant) {
        super();
        this.restaurant = restaurant;
        this.state = new WaitingForClientState();
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

    public boolean isOrderFinished() {
        return true;
    }

    public void sendOrder() {
        // TODO Auto-generated method stub

    }

    public boolean isOrderPrepared() {
        return true;
    }

    public void serveOrder() {
        // TODO Auto-generated method stub
        
    }

}
