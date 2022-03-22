package ru.nstu.stud.koroleva2019;

public class CardC {
    private final int rank;
    private static int currentMaxRank = 0;
    private static final int MAX_RANK = 15;
    private final Suits suit;

    CardC() {
        rank = 2;
        fixCurrentMaxRank(this.rank);

        suit = Suits.clubs;
    }

    CardC(int rank, int suit) {
        this.suit = enterSuit(suit);
        if((this.suit == Suits.blackJoker) || (this.suit == Suits.redJoker))
            this.rank = 15;
        else this.rank = enterRank(rank);

        fixCurrentMaxRank(this.rank);
    }

    CardC(int rank, Suits suit) {
        this.suit = suit;
        if((this.suit == Suits.blackJoker) || (this.suit == Suits.redJoker))
            this.rank = 15;
        else this.rank = enterRank(rank);

        fixCurrentMaxRank(this.rank);
    }

    CardC(int suit) {
        if (currentMaxRank < MAX_RANK) rank = currentMaxRank + 1;
        else rank = MAX_RANK;
        fixCurrentMaxRank(rank);

        this.suit = enterSuit(suit);
    }

    CardC(Suits suit) {
        if (currentMaxRank < MAX_RANK) rank = currentMaxRank + 1;
        else rank = MAX_RANK;
        fixCurrentMaxRank(rank);

        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public static int getCurrentMaxRank(){
        return currentMaxRank;
    }

    public int getSuitsInt() {
        return suit.ordinal();
    }

    public Suits getSuits() {
        return suit;
    }

    public void printCard() {
        System.out.println(rank + " " + suit);
    }

    private int enterRank(int rank) {
        int enterRank = rank;

        if ((rank < 2) || (rank > MAX_RANK)) {
            System.out.format("\nYour rank number: %d,\n" +
                    "The entered rank number is not included in the 1-14 interval.\n" +
                    "Rank 2 is selected.\n", rank);
            enterRank = 2;
        }

        return enterRank;
    }

    private Suits enterSuit(int suit) {
        Suits enterSuit;
        switch (suit) {
            case 0:
                enterSuit = Suits.clubs;
                break;
            case 1:
                enterSuit = Suits.diamonds;
                break;
            case 2:
                enterSuit = Suits.spades;
                break;
            case 3:
                enterSuit = Suits.hearts;
                break;
            case 4:
                enterSuit = Suits.blackJoker;
                break;
            case 5:
                enterSuit = Suits.redJoker;
                break;
            default:
                System.out.format("\nYour suit number: %d,\n" +
                        "The entered suit number is not included in the 0-5 interval.\n" +
                        "Suit 1 (diamonds) is selected.\n", suit);
                enterSuit = Suits.diamonds;
        }

        return enterSuit;
    }

    private void fixCurrentMaxRank(int rank) {
        if (rank > currentMaxRank) currentMaxRank = rank;
    }

}