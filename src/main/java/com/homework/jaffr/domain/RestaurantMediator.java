package com.homework.jaffr.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.homework.jaffr.domain.cashier.Cashier;
import com.homework.jaffr.domain.client.Client;
import com.homework.jaffr.domain.order.Order;
import com.homework.jaffr.domain.robot.RobotChef2000;

public class RestaurantMediator {
    private List<Cashier> cashiers = Collections.synchronizedList(new ArrayList<Cashier>());
    private List<Client> clients = Collections.synchronizedList(new ArrayList<Client>());
    private RobotChef2000 chef;

    public RestaurantMediator() {
        super();
    }

    public void addCashier(Cashier cashier) {
        cashiers.add(cashier);
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public void setChef(RobotChef2000 chef) {
        this.chef = chef;
    }

    public void lookForFreeCashier(Client client) {
        synchronized (cashiers) {
            for (Cashier cashier : cashiers) {
                if (cashier.isFree()) {
                    cashier.setClient(client);
                    client.setCashier(cashier);
                    break;
                }
            }
        }
    }

    public void leave(Client client) {
        clients.remove(client);
    }

    public void sendOrder(Order order) {
        // TODO Auto-generated method stub

    }

}
