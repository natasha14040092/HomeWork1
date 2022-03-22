package ru.nstu.stud.koroleva2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
    private static final Deck INSTANCE = new Deck();
    private static final ArrayList<CardB> deck = new ArrayList<>();

    private Deck() {
    }

    private static void createDeck() {
        for(int rank = 2; rank < 15; rank++)
            for(int suit = 0; suit < 4; suit++)
                deck.add(new CardB(rank, suit));
    }

    public static Deck createDeck52(){
        deck.clear();
        createDeck();
        return INSTANCE;
    }

    public static Deck createDeck54(){
        deck.clear();
        createDeck();
        deck.add(new CardB(15, Suits.blackJoker));
        deck.add(new CardB(15, Suits.redJoker));
        return INSTANCE;
    }

    public static void printDeck(){
        System.out.println(deck);
    }

    public static CardB randomCard(){
        if (deck.isEmpty()){
            System.err.println("randomCard(): Deck is empty.");
        }
        return deck.get(new Random().nextInt(deck.size()));
    }

    public static void shuffleDeck(){
        Collections.shuffle(deck);
    }

    public static void sortingDeck(){
        Collections.sort(deck);
    }

    public static boolean isEmpty(){
        return deck.isEmpty();
    }

    public static CardB popCard(){
        if (deck.isEmpty()){
            System.err.println("popCard(): Deck is empty.");
        }
        CardB card = deck.get(deck.size() - 1);
        deck.remove(deck.size() - 1);
        return card;
    }

    public static void pushCard(CardB card){
        if (!deck.contains(card))
            deck.add(0, card);
        else
            System.out.println("Deck contains card: " + card );
    }

    public String toString(){
        return deck.toString();
    }
}