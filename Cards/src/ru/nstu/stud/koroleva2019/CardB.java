package ru.nstu.stud.koroleva2019;

public class CardB implements Comparable<CardB> {
    private static final int MAX_STANDARD_RANK = 15;
    private final int rank;
    private final Suits suit;

    CardB() {
        rank = 2;
        suit = Suits.clubs;
    }

    CardB(int rank, Suits suit) {
        this.suit = suit;
        this.rank = getValidRank(rank);
    }

    CardB(int rank, int suit) {
        this(rank, enterSuit(suit));
    }

    private int getValidRank(int rank) {
        if ((this.suit == Suits.blackJoker) || (this.suit == Suits.redJoker)) return 15;
        else return enterRank(rank);
    }

    public int getRankInt() {
        return rank;
    }

    public String getStringRank() {
        return toStringRank();
    }


    public int getSuitsInt() {
        return suit.ordinal();
    }

    public Suits getSuits() {
        return suit;
    }


    public String toString() {
        return getStringRank() + suit;
    }


    public void printCard() {
        System.out.println(getStringRank() + suit);
    }


    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        CardB card = (CardB) obj;

        return (this.rank == card.rank) && (this.suit == card.suit);
    }


    public int hashCode() {
        return (rank * 10) + suit.ordinal();
    }


    public static boolean isStandardDeck(CardB card) {
        return (card != null) && (card.rank >= 2) && (card.rank <= MAX_STANDARD_RANK);
    }

    public boolean isStronger(CardB card) {
        return (card != null) && (this.suit == card.suit) && (this.rank > card.rank);
    }

    @Override
    public int compareTo(CardB o) {
        //clubs < diamonds < spades < hearts
        if (o == null) return -1;
        return (rank - o.rank == 0) ? (suit.ordinal() - o.suit.ordinal()) : (rank - o.rank);
    }

    public static int compare(CardB card1, CardB card2) {
        if ((card1 == null) || (card2 == null)) return -1;
        return (card1.rank - card2.rank == 0) ?
                (card1.suit.ordinal() - card2.suit.ordinal()) : (card1.rank - card2.rank);
    }


    private int enterRank(int rank) {
        int enterRank = rank;

        // не буду сюда все-таки добавлять проверку на MAX_RANK = 15,
        // потому што не понимаю, в чем тогда смысл метода isStandartDeck()....
        if (rank <= 0) {
            System.out.format("\nYour rank number: %d,\n" + "The entered rank number must be > 0.\n" + "Rank 2 is selected.\n", rank);
            enterRank = 2;
        }
        return enterRank;
    }

    private static Suits enterSuit(int suit) {
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

    private String toStringRank() {
        String strRank;

        switch (rank) {
            case 11:
                strRank = "Jack ";
                break;
            case 12:
                strRank = "Queen ";
                break;
            case 13:
                strRank = "King ";
                break;
            case 14:
                strRank = "Ace ";
                break;
            case 15:
                strRank = "";
                break;
            default:
                strRank = rank + " ";
        }
        return strRank;
    }
}