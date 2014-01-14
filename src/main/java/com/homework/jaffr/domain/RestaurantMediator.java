package com.homework.jaffr.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RestaurantMediator {
    private List<Cashier> cashiers = Collections.synchronizedList(new ArrayList<Cashier>());
    private List<Client> clients = Collections.synchronizedList(new ArrayList<Client>());

    public RestaurantMediator() {
        super();
    }

    public List<Cashier> getCashiers() {
        return cashiers;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void addCashier(Cashier cashier) {
        cashiers.add(cashier);
    }

    public void addClient(Client client) {
        clients.add(client);
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


}
