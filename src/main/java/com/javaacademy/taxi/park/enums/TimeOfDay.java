package com.javaacademy.taxi.park.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum TimeOfDay {
    DAY("День"),
    NIGHT("Ночь");
    private final String timeOfDay;
}
