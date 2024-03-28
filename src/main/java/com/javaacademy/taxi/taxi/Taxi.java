package com.javaacademy.taxi.taxi;

import com.javaacademy.taxi.client.Client;
import com.javaacademy.taxi.park.enums.TimeOfDay;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.math.BigInteger;

@ToString
@Getter
@RequiredArgsConstructor
public class Taxi {
    @Value("${taxi.nightRate}")
    private double nightRate;
    @Value("${taxi.dayRate}")
    private double dayRate;
    private BigDecimal earnedMoney = new BigDecimal(BigInteger.ZERO);
    @NonNull
    private final String carNumber;

    public BigDecimal acceptOrder(Client client, TimeOfDay timeOfDay) {
        int distance = checkClientAddress(client);
        if (distance == 0) {
            return new BigDecimal(BigInteger.ZERO);
        }
        switch (timeOfDay) {
            case DAY -> earnedMoney = new BigDecimal(distance * dayRate);
            case NIGHT -> earnedMoney = new BigDecimal(distance * nightRate);
        }
        earnedMoney = earnedMoney.multiply(new BigDecimal("0.5"));
        return earnedMoney;
    }

    private int checkClientAddress(Client client) {
        switch (client.getAddress()) {
            case "Березовая роща" -> {
                return 10;
            }
            case "Кандикюля" -> {
                return 4;
            }
            case "Строитель" -> {
                return 12;
            }
        }
        return 0;
    }
}
