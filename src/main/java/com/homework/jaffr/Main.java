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
            new Thread(cashier).start();
        }
        for (int i = 0; i < 1000; i++) {
            if (random.nextInt(3) == 0) {
                Client client = new Client(restaurant);
                restaurant.addClient(client);
                new Thread(client).start();
            }
            try {
                Thread.sleep(random.nextInt(100) + 100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


    }
}
