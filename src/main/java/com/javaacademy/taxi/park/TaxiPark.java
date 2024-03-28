package com.javaacademy.taxi.park;

import com.javaacademy.taxi.client.Client;
import com.javaacademy.taxi.park.enums.TimeOfDay;
import com.javaacademy.taxi.taxi.Taxi;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Slf4j
@Component
@ToString
public class TaxiPark {
    @Value("${spring.application.name}")
    private String name;
    private BigDecimal totalEarnedMoney = new BigDecimal(BigInteger.ZERO);
    private Queue<Taxi> taxis;

    public TaxiPark(List<Taxi> taxis) {
        this.taxis = new LinkedList<>(taxis);
    }

    @PostConstruct
    private void init() {
        log.info("Запускаем Яндекс такси");
    }

    @PreDestroy
    private void destroy() {
        printSummary();
    }

    public void acceptOrder(Client client, TimeOfDay timeOfDay) {
        Taxi taxi = taxis.poll();
        assert taxi != null;
        totalEarnedMoney = totalEarnedMoney.add(taxi.acceptOrder(client, timeOfDay));
        taxis.add(taxi);
    }

    private void printSummary() {
        System.out.printf("""
                %s
                Заработано: %s
                """, name, totalEarnedMoney);
        taxis.forEach(taxi -> System.out.printf("Водитель машины %s заработал: %s\n",
                taxi.getCarNumber(), taxi.getEarnedMoney()));
    }
}
