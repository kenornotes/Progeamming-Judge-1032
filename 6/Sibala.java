public class Sibala {
    int[] dice;  // 骰子
    int score;   // 分數
    String name; // 玩家名字
    public Sibala(String pname) {
        this.dice = new int[3];
        this.name = pname;
        // 骰出隨機點數( 1~6 )
        for (int i = 0; i< dice.length; i++) {
            dice[i] = (int)(Math.random()*6+1);
        }
    }
    // 判斷點數的大小及牌面
    public String check() {
        if (dice[0] + dice[1] + dice[2] == 3) {
            this.score = 0;
            return "BG";
        } else if (dice[0] == dice[1] && dice[1] == dice[2]) {
            this.score = 100;
            return "十八拉";
        } else {
            this.score = dice[0] + dice[1] + dice[2];
            return Integer.toString(this.score) + "點";
        }
    }
    public static void main(String[] args) {
        Sibala 香腸伯 = new Sibala("香腸伯");
        Sibala ssyu = new Sibala("ssyu");
        // 印出骰子點數及牌面
        System.out.println(香腸伯.name + "擲出：" + 
                香腸伯.dice[0] + ", " + 
                香腸伯.dice[1] + ", " + 
                香腸伯.dice[2] + " ");
        System.out.println(香腸伯.check());
        System.out.println(ssyu.name + "擲出：" + 
                ssyu.dice[0] + ", " +
                ssyu.dice[1] + ", " +
                ssyu.dice[2] + " ");
        System.out.println(ssyu.check());
        // 判斷輸贏
        if(香腸伯.score > ssyu.score)
            System.out.println(香腸伯.name + " win!!");
        else if(ssyu.score > 香腸伯.score)
            System.out.println(ssyu.name + " win!!");
        else
            System.out.println("平手，重來一次");
    }
}
