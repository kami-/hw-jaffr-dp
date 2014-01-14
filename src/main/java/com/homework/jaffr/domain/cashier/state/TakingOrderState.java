package com.homework.jaffr.domain.cashier.state;

import com.homework.jaffr.domain.cashier.Cashier;
import com.homework.jaffr.domain.cashier.CashierState;

public class TakingOrderState implements CashierState {

    public void exec(Cashier cashier) {
        while (!cashier.isOrderFinished()) {
        }
        cashier.sendOrder();
        cashier.setState(new WaitingForOrderState());
        cashier.doExec();
    }

}
