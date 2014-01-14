package com.homework.jaffr.domain;

public class LeaveRestaurantState implements ClientState {

    public void doStuff(Client client) {
        System.out.println("LEAVERRESTAURANT");
        client.leave();
    }

}
