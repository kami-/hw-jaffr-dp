package com.homework.jaffr.domain;

public class WaitingForOrderSate implements ClientState {

    public void doStuff(Client client) {
        System.out.println("WAITINGFORORDER");
        while (!client.hasReceivedOrder()) {
        }
        System.out.println("Client received order!");
        client.setState(new LeaveRestaurantState());
        client.doStuff();
    }

}
