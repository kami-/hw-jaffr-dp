package com.homework.jaffr.domain;

public class Cashier implements Runnable {
    private RestaurantMediator restaurant;
    private Client myClient;

    public Cashier(RestaurantMediator restaurant) {
        super();
        this.restaurant = restaurant;
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
        while (myClient == null) {

        }
        System.out.println("Client found!");
    }

    public void clientLeft() {
        myClient = null;
    }

}
