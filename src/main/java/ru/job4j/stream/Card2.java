package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Card2 {
    private Suit suit;
    private Value value;

    public Card2(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(v -> Stream.of(Value.values())
                        .map(rsl -> new Card2(v, rsl)))
                .toList();
    }
}