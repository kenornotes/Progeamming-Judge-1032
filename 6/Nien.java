import java.util.Scanner;
public class Nien {
    public static void main (String[] argv) {
        單字本 粘粘的單字本 = new 單字本();
        Scanner input = new Scanner(System.in);
        int count = 0; // 用以計算輸入個數

        while (true) {
            String cmd = input.next();
            if ( cmd.equals("break") ) {
                break;
            }
            粘粘的單字本.add( new 單字( cmd, input.next() ) );
            count++;
        }

        for (int i = 0; i < count; i++) {
            單字 temp = 粘粘的單字本.display(i);
            System.out.print(temp.原文 + " ");
        }
        System.out.println();
        for (int i = 0; i < count; i++) {
            單字 temp = 粘粘的單字本.display(i);
            System.out.print(temp.解釋 + " ");
        }
    }
}

class 單字 {
    String 原文;
    String 解釋;

    單字 (String 原文, String 解釋) {
        this.原文 = 原文;
        this.解釋 = 解釋;
    }
}

class 單字本 {
    單字[] 單字群 = new 單字[100];
    int size;

    void add (單字 temp) {
        單字群[size++] = temp;
    }

    單字 display (int n) {
        return 單字群[n];
    }
}


