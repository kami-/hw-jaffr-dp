package com.homework.jaffr.domain.cashier.state;

import com.homework.jaffr.domain.cashier.Cashier;
import com.homework.jaffr.domain.cashier.CashierState;

public class WaitingForOrderState implements CashierState {

    public void exec(Cashier cashier) {
        while (!cashier.isOrderPrepared()) {
        }
        cashier.serveOrder();
        cashier.setState(new WaitingForClientState());
        cashier.doExec();
    }

}
