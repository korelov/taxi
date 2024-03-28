package com.javaacademy.taxi.client;

import lombok.NonNull;
import lombok.Value;

@Value
public class Client {
    @NonNull
    String address;
}
