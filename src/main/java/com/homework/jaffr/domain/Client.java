package com.homework.jaffr.domain;



public class Client implements Runnable {
    private RestaurantMediator restaurant;
    private Cashier myCashier;
    private int happiness = 1;
    private ClientState state;

    public Client(RestaurantMediator restaurant) {
        super();
        this.restaurant = restaurant;
    }

    public Cashier getCashier() {
        return myCashier;
    }

    public void setCashier(Cashier Cashier) {
        this.myCashier = Cashier;
    }

    public void run() {
        System.out.println("Client started");
        while (myCashier == null) {
            try {
                restaurant.lookForFreeCashier(this);
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("Cashier found!");
    }

    public void clientLeft() {
        myCashier.clientLeft();
        restaurant.leave(this);
    }

}
