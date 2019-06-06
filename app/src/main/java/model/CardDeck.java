package model;

import android.util.Log;

import java.util.Random;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class CardDeck {

    private final int MAX_SUITS = 4;
    private final int MAX_PIP = 13;
//    ArrayList<Card> cards;


    private final Card[][] cards;// = new Card[Suit.values().length][Pip.values().length];


    public CardDeck() {
        cards = new Card[MAX_SUITS][MAX_PIP];

        for (Suit suit : Suit.values()) {
            for (Pip pip : Pip.values()) {
                Log.e(TAG, "CardDeck: SUIT " + suit.value + " Pip val " + pip.value);
                cards[suit.value][pip.index] = new Card(suit, pip);
            }
        }
    }

    public Card getCard(Suit suit, Pip pip) {
        return cards[suit.value][pip.index];
    }

    public Card getCardPic(Suit suit, Pip pip) {

        // [0] spades   (♠)
        // [1] diamonds (♦)
        // [2] clubs    (♣)
        // [3] hearts   (♥)

        switch (suit.name){
            case "spades":
                switch (pip.value){
//                    case ""
                }
        }


            return cards[suit.value][pip.index];
    }


    public Card[][] getShuffledDeck() {

        Random random = new Random();
        int numberOfValues = cards.length * cards[0].length;
        for (int i = numberOfValues - 1; i > 0; i--) {
            int index = random.nextInt(i);
            int row = i / cards[0].length;
            int column = i - row * cards[0].length;
            int randomRow = index / cards[0].length;
            int randomColumn = index - randomRow * cards[0].length;
            Card temp = cards[row][column];
            cards[row][column] = cards[randomRow][randomColumn];
            cards[randomRow][randomColumn] = temp;
        }

//        List<Card[]> shuffCard = Arrays.asList(cards);
//         shuffle(shuffCard);
        return cards;
    }
}
