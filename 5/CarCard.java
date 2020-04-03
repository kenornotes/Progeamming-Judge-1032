import java.util.Scanner;
public class CarCard{
    static String[] englishs;
    static String[] numbers;
    public static void main(String[] argv){
        Scanner input=new Scanner(System.in);
        //set characters
        System.out.print("Please input English characters:");
        String english=input.next();//input english
        englishs=english.split("");//split to array
        //set numbers
        System.out.print("Please input numbers:");
        String number=input.next();
        numbers=number.split("");
        //do permutation
        permEnglish(0);
    }
    public static void permEnglish(int from){
        if(from==englishs.length-1){//最後一個不用做
            permNumber(0);
            return;
        }
        for(int i=from;i<englishs.length;i++){
            String tmp=englishs[i];
            englishs[i]=englishs[from];
            englishs[from]=tmp;
            permEnglish(from+1);
            //資料還原
            tmp=englishs[i];
            englishs[i]=englishs[from];
            englishs[from]=tmp;
        }
    }
    public static void permNumber(int from){
        if(from==numbers.length-1){//最後一個不用做
            for(int i=0;i<englishs.length;i++)
                System.out.print(englishs[i]);
            System.out.print("-");
            for(int i=0;i<numbers.length;i++)
                System.out.print(numbers[i]);
            System.out.println();
            return;
        }
        for(int i=from;i<numbers.length;i++){
            String tmp=numbers[i];
            numbers[i]=numbers[from];
            numbers[from]=tmp;
            permNumber(from+1);
            //資料還原
            tmp=numbers[i];
            numbers[i]=numbers[from];
            numbers[from]=tmp;
        }
    }
}