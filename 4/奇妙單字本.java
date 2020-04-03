import java.util.Scanner;
public class 奇妙單字本 {
    public static void main(String[] argv) {
        單字本 我的單字本 = new 單字本();
        Scanner input = new Scanner(System.in);
        System.out.println("請輸入指令");
        System.out.println(" - 新增單字：add [單字] [解釋]");
        System.out.println(" - 測驗：quiz [題數]");
        System.out.println(" - 闔上單字本：quit");
        while ( input.hasNext() ) {
            String command = input.next();
            if ( command.equals("add") ) {
                我的單字本.add( input.next(), input.next() );
            } else if ( command.equals("quiz") ) {
                int 題數 = input.nextInt();
                int 分數 = 0;
                for (int i = 1; i <= 題數; i++) {
                    單字 題目 = 我的單字本.get();
                    System.out.print(題目.解釋 + " ");
                    String 答案 = input.next();
                    if ( 答案.equals(題目.title) ) {
                        分數++;
                        System.out.println("答對！");
                    } else {
                        System.out.println("答錯！");
                    }
                }
                System.out.println("共獲得： " + 分數);
            } else if ( command.equals("quit") ) {
                break;
            }
        }
    }
}

class 單字 {
    String title;
    String 解釋;
    單字 next;
}

class 單字本 {
    單字 head, tail;
    int size;
    void add(String 單字, String 解釋) {
        單字 tmp = new 單字();
        tmp.title = 單字;
        tmp.解釋 = 解釋;
        if (tail != null) {
            tail.next = tmp;
            tail = tmp;
        } else {
            head = tail = tmp;
        }
        size++;
    }
    單字 get() {
        int randNum = (int)(Math.random()*size + 1);
        單字 tmp = head;
        for (int i = 1; i < randNum; i++) {
            tmp = tmp.next;
        }
        return tmp;
    }
}
