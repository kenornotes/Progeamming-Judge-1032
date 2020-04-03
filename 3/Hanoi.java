/*
*Author:龍志雄
*Since:2014/02/24
*Toolkit:Notepad++
*/
import java.util.Scanner;
public class Hanoi{
    public static void main(String[] argv){
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        move(n);
    }
    public static void move(int n){
        move(n,'A','B','C');
    }
    public static void move(int n,char from,char by,char to){
        if(n==0)
            System.out.println("No plate.");
        else if(n==1)
            System.out.println("Move plate "+n+" to "+to);
        else{
            move(n-1,from,to,by);
            System.out.println("Move plate "+n+" to "+to);
            move(n-1,by,from,to);
        }
    }
}