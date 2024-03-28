package com.javaacademy.taxi.park.enums;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum TariffRate {
    BEREZOVAYA_ROSHA("Березовая роща", 10),
    KANDIKYULA("Кандикюля", 4),
    STROITEL("Строитель", 12);
    private final String address;
    private final int distance;
}
