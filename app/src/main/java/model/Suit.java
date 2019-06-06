package model;

public enum Suit {
    SPADES("spades",0),//      spades   (♠)
    DIAMONDS("diamonds",1), // diamonds (♦)
    CLUBS  ("clubs",2), //     clubs    (♣)
    HEARTS ("hearts",3); //    hearts   (♥)

    String name;
    int value;

    Suit(String name, int value) {
        this.name = name;
        this.value = value;
    }
}

