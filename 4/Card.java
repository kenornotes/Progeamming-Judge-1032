class Player {
    int[] hands;
    String name;
    private String[] suit = {"S", "H", "D", "C"}; // 花色
    public Player(int n, String name) {
        this.name = name;
        this.hands = new int[n];
    }

    public void print() {
        System.out.println(this.name + ":");
        for (int i = 0; i < this.hands.length; i++)
            if (hands[i] > 0)
                System.out.print(suit[hands[i]/13] + (hands[i]%13+1) + " ");
        System.out.println();
    }
    public void findPair() {
        int count = 0;
        for (int i = 0 ;i < hands.length-1; i++) {
            for (int j = i+1; j < hands.length; j++) {
                if (hands[i] > 0 && hands[j] > 0 && hands[j]%13 == hands[i]%13) {
                    if (count == 0)
                        System.out.print(this.name + " has pair ");
                    if (count > 0)
                        System.out.print(", ");
                    System.out.print(" " +suit[hands[j]/13] + (hands[j]%13+1) + " & ");
                    System.out.print(suit[hands[i]/13] + (hands[i]%13+1));
                    hands[i] = -1; // flag, means no card
                    hands[j] = -1;
                    count++;
                }
            }
        }
        System.out.println();
        this.sort();
    }
    public void sort() {
        for (int i = 0; i < this.hands.length-1; i++) {
            for (int j = i + 1; j < this.hands.length; j++) {
                if (hands[j] < hands[i]) {
                    int tmp = hands[j];
                    hands[j] = hands[i];
                    hands[i] = tmp;
                }
            }
        }
    }
}

public class Card {
    int[] cards;

    public Card() {
        this.cards = new int[52];
        for (int i = 0; i < this.cards.length; i++) {
            cards[i] = i;
        }
    }

    public void shuffle() {
        for (int i = 0; i < this.cards.length; i++) {
            int r = (int)(Math.random()*52);
            int tmp = this.cards[r];
            this.cards[r] = this.cards[i];
            this.cards[i] = tmp;
        }
    }

    public void deal(Player[] p) {
        int i = 0, count = 0;
        while (i < 52) {
            // 發牌
            for(int k = 0; k < p.length; k++) {
                p[k].hands[count] = this.cards[i];
                i++;
                System.out.println("把第" + i + "張牌[" + this.cards[i-1]  + "]發到 p" + k + "的第" + count + "張牌");
            }
            count++;
        }
    }

    public void print() {
        for(int i = 0 ;i < cards.length; i++) {
            System.out.print(cards[i] + " " );
        }
    }

    public static void main(String[] args) {
        int number = 4;
        Player[] player = new Player[number];
        for (int i = 0; i < number; i++)
            player[i] = new Player(52/number, "p"+i);

        Card game = new Card();
        game.shuffle(); // 洗牌
        game.deal(player); // 發牌
        for (int i = 0; i < player.length; i++) {
            player[i].sort();
            player[i].print();
            player[i].findPair();
            player[i].print();
        }
    }
}
