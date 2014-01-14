package com.homework.jaffr;

import java.util.Random;

import com.homework.jaffr.domain.Cashier;
import com.homework.jaffr.domain.Client;
import com.homework.jaffr.domain.RestaurantMediator;

public class Main {
    public static void main(String[] args) {
        RestaurantMediator restaurant = new RestaurantMediator();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            Cashier cashier = new Cashier(restaurant);
            restaurant.addCashier(cashier);
            new Thread(cashier, "cashier" + i).start();
        }
        for (int i = 0; i < 10; i++) {
            Client client = new Client(restaurant);
            restaurant.addClient(client);
            new Thread(client, "client" + i).start();
            try {
                Thread.sleep(random.nextInt(100) + 100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


    }
}
