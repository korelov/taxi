package com.javaacademy.taxi;

import com.javaacademy.taxi.client.Client;
import com.javaacademy.taxi.park.TaxiPark;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import static com.javaacademy.taxi.park.enums.TimeOfDay.DAY;
import static com.javaacademy.taxi.park.enums.TimeOfDay.NIGHT;

@SpringBootApplication
public class Runner {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Runner.class, args);
        TaxiPark taxiPark = context.getBean(TaxiPark.class);
        Client client1 = new Client("Кандикюля");
        Client client2 = new Client("Строитель");
        Client client3 = new Client("Березовая роща");
        Client client4 = new Client("Ломоносов");

        taxiPark.acceptOrder(client1, DAY);
        taxiPark.acceptOrder(client2, DAY);
        taxiPark.acceptOrder(client3, NIGHT);
        taxiPark.acceptOrder(client4, NIGHT);
    }
}
