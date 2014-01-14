package com.homework.jaffr.domain;

public class LookigForCashierState implements ClientState {

    public void doStuff(Client client) {
        while (!client.hasFoundCashier()) {
            client.lookForFreeCashier();
        }
        client.setState(new OrderingState());
        client.doStuff();
    }

}
