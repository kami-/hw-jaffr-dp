package com.homework.jaffr.domain;



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
        doStuff();
        System.out.println("Cashier found!");
    }

    public void lookForFreeCashier() {
        restaurant.lookForFreeCashier(this);
    }

    public void clientLeft() {
        restaurant.leave(this);
    }
    
    public boolean hasFoundCashier() {
        return myCashier != null;
    }

    public void doStuff() {
        state.doStuff(this);
    }

}
