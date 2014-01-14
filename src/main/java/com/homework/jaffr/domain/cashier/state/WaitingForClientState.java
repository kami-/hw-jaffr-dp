package com.homework.jaffr.domain.cashier.state;

import com.homework.jaffr.domain.cashier.Cashier;
import com.homework.jaffr.domain.cashier.CashierState;

public class WaitingForClientState implements CashierState {

    public void exec(Cashier cashier) {
        cashier.cleanUp();
        while (cashier.isFree()) {
        }
        cashier.setState(new TakingOrderState());
        cashier.doExec();
    }

}
