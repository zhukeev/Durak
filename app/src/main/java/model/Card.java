package model;

import androidx.annotation.NonNull;

public class Card {

    Suit suit;
    Pip pip;

    public Card(Suit suit, Pip pip) {
        this.suit = suit;
        this.pip = pip;
    }

    public void Card(){}

    @NonNull
    @Override
    public String toString() {
        return suit.name +" " +pip.value;
    }
}
