package ru.nstu.stud.koroleva2019;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void playCards() {
        Deck deck = Deck.createDeck54();
        System.out.println("\nDeck:");
        Deck.printDeck();

        ArrayList<CardB> cards = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            cards.add(Deck.popCard());
        }

        System.out.println("\nCard draw: " + cards);

        System.out.println("\nDeck after card draw:");
        Deck.printDeck();

        System.out.println("\nDeck after pushing cards:");
        for (int i = 0; i < 6; i++) {
            Deck.pushCard(cards.get(i));
        }
        Deck.printDeck();

        System.out.println("\nRepeat pushing cards:");
        for (int i = 0; i < 6; i++) {
            Deck.pushCard(cards.get(i));
        }
        System.out.println("\nDeck after pushing cards:");
        Deck.printDeck();

        System.out.println("\nDeck after shuffling:");
        Deck.shuffleDeck();
        Deck.printDeck();

        System.out.println("\nDeck after sorting:");
        Deck.sortingDeck();
        Deck.printDeck();

        System.out.println("\nPopping all cards from deck:");
        while (!Deck.isEmpty()) {
            Deck.popCard();
        }
        Deck.printDeck();
    }

    public static void main(String[] args) {

        System.out.println("Suits:");
        Suits[] suits = {Suits.clubs, Suits.diamonds, Suits.spades, Suits.hearts, Suits.blackJoker, Suits.redJoker};
        for (Suits s : suits) {
            System.out.println(s.ordinal() + " " + s);
        }

        playCards();

        //testingCardC();
        //testingCardB();
        //testingDeck();
    }

    public static void testingCardC() {
        System.out.println("\nTesting class Cards C:");

        CardC card1 = new CardC(Suits.spades.ordinal());
        System.out.print("\ncard1: ");
        card1.printCard();

        CardC card2 = new CardC(Suits.hearts.ordinal());
        System.out.print("\ncard2: ");
        card2.printCard();

        CardC card3 = new CardC(13, Suits.hearts);
        System.out.print("\ncard3: ");
        card3.printCard();

        System.out.format("\nCurrent max rank: %d\n", CardC.getCurrentMaxRank());

        CardC card4 = new CardC(Suits.diamonds.ordinal());
        System.out.print("\ncard4: ");
        card4.printCard();

        System.out.format("\nCurrent max rank: %d\n", CardC.getCurrentMaxRank());

        CardC card5 = new CardC(15, 20);
        System.out.print("\ncard5: ");
        card5.printCard();

        CardC card6 = new CardC(Suits.clubs);
        System.out.print("\ncard6: ");
        card6.printCard();

        CardC card7 = new CardC(-100, Suits.blackJoker);
        System.out.print("\ncard7: ");
        card7.printCard();

    }

    public static void testingCardB() {
        System.out.println("\nTesting class Cards B:");

        //Тестирование создание и вывода карт
        System.out.println("\nTesting creating cards:");
        CardB card = new CardB(14, 14);
        System.out.print("\ncard0: ");
        card.printCard();

        CardB card1 = new CardB(13, Suits.hearts);
        System.out.print("\ncard1: ");
        card1.printCard();
        System.out.format("hash code: %d\n", card1.hashCode());

        CardB card2 = new CardB(12, 3);
        System.out.print("\ncard2: ");
        card2.printCard();
        System.out.format("hash code: %d\n", card2.hashCode());

        CardB card3 = new CardB(16, Suits.spades);
        System.out.print("\ncard3: ");
        card3.printCard();
        System.out.format("hash code: %d\n", card3.hashCode());

        CardB card4 = new CardB(13, 2);
        System.out.print("\ncard4: ");
        card4.printCard();
        System.out.format("hash code: %d\n", card4.hashCode());

        CardB card5 = new CardB(-10, 2);
        System.out.print("\ncard5: ");
        card5.printCard();
        System.out.format("hash code: %d\n", card5.hashCode());

        CardB card6 = new CardB(-10, 5);
        System.out.print("\ncard6: ");
        card6.printCard();
        System.out.format("hash code: %d\n", card6.hashCode());


        //Тестирование equals()
        System.out.println("\nTesting equals():");

        System.out.format("\ncard1 (%s) == card2 (%s)?\n", card1, card2);
        System.out.println(card1.equals(card2));

        System.out.format("card1 (%s) == card4 (%s)?\n", card1, card4);
        System.out.println(card1.equals(card4));

        System.out.format("card1 (%s) == card1 (%s)?\n", card1, card1);
        System.out.println(card1.equals(card1));

        CardB card0 = new CardB(13, Suits.hearts);
        System.out.format("card1 (%s) == card (%s)?\n", card1, card0);
        System.out.println(card1.equals(card0));

        System.out.println();


        //Тестирование isStandardDeck()
        System.out.println("Testing isStandardDeck():\n");

        System.out.format("Is card5 (%s) from standard deck?: %b\n", card5, CardB.isStandardDeck(card5));
        System.out.format("Is card0 (%s) from standard deck?: %b\n", card, CardB.isStandardDeck(card));
        System.out.format("Is card6 (%s) from standard deck?: %b\n", card6, CardB.isStandardDeck(card6));
        System.out.format("Is card3 (%s) from standard deck?: %b\n", card3, CardB.isStandardDeck(card3));

        //Тестирование isStronger()
        System.out.println("\nTesting isStronger():");
        System.out.format("\nIs card4 (%s) stronger than card5 (%s)?: %b\n", card4, card5, card4.isStronger(card5));
        System.out.format("Is card5 (%s) stronger than card4 (%s)?: %b\n", card5, card4, card5.isStronger(card4));
        System.out.format("Is card0 (%s) stronger than card4 (%s)?: %b\n", card, card4, card.isStronger(card4));

        System.out.println();


        //Тестирование compareTo()
        System.out.println("Testing compareTo():");
        System.out.println("//clubs < diamonds < spades < hearts.\n");

        ArrayList<CardB> cards = new ArrayList<>();
        cards.add(new CardB(1, Suits.blackJoker));
        cards.add(new CardB(5, Suits.diamonds));
        cards.add(new CardB(10, Suits.hearts));
        cards.add(new CardB(14, Suits.spades));
        cards.add(new CardB(2, Suits.spades));
        cards.add(new CardB(5, Suits.hearts));
        cards.add(new CardB(1, Suits.redJoker));
        cards.add(new CardB(14, Suits.diamonds));
        cards.add(new CardB(7, Suits.diamonds));

        for (int i = 0; i < 3; i++) {
            System.out.println(cards.get(i) + " compareTo() " + cards.get(i + 1) +
                    " = " + cards.get(i).compareTo(cards.get(i + 1)));
        }
        System.out.println(cards.get(1) + " compareTo() " + cards.get(1) +
                " = " + cards.get(1).compareTo(cards.get(1)));

        System.out.println("\nSorting card array with Collections.sort(cards):");
        System.out.println(cards);
        Collections.sort(cards);
        System.out.println(cards);

        System.out.println();

        System.out.println(cards.get(1) + " static compare " + cards.get(2) +
                " = " + CardB.compare(cards.get(1), cards.get(2)));

        System.out.println(cards.get(2) + " static compare " + cards.get(1) +
                " = " + CardB.compare(cards.get(2), cards.get(1)));

        System.out.println(cards.get(1) + " static compare " + cards.get(1) +
                " = " + CardB.compare(cards.get(1), cards.get(1)));
    }

    public static void testingDeck() {
        System.out.println("\nTesting create deck:");

        Deck.createDeck54();
        Deck.printDeck();

        Deck.createDeck52();
        Deck.printDeck();

        System.out.println("\nTesting random card:");

        System.out.println(Deck.randomCard());
        System.out.println(Deck.randomCard());
        System.out.println(Deck.randomCard());

        System.out.println("\nTesting shuffle and sorting:");

        Deck.printDeck();
        System.out.println("Shuffle deck:");
        Deck.shuffleDeck();
        Deck.printDeck();
        System.out.println("Sorting deck:");
        Deck.sortingDeck();
        Deck.printDeck();

        System.out.println("\nTesting pop card:");

        CardB popCard = Deck.popCard();
        System.out.println(popCard);
        Deck.printDeck();

        System.out.println("\nTesting push card:");
        Deck.printDeck();
        System.out.println(popCard);
        Deck.pushCard(popCard);
        Deck.printDeck();

        CardB pushCard = new CardB(2, Suits.hearts);
        System.out.println(pushCard);
        Deck.pushCard(pushCard);
        Deck.printDeck();
    }
}