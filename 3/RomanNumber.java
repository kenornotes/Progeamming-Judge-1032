/*
*Author:龍志雄
*Since:2014/02/24
*Toolkit:Notepad++
*/
import java.util.*;
public class RomanNumber{
    public static int[] rule={1,5,10,50,100,500,1000};
    public static char[] rrule={'I','V','X','L','C','D','M'};
    public static void main(String[] argv){
        Scanner input=new Scanner(System.in);
        for(;;){
            if(input.hasNextInt()){
                int x=input.nextInt();
                if(x<4000&&x>0)
                    System.out.println("轉換結果："+trans(x));
                else
                    System.out.println("數值需介於0~4000之間");
            }
            else{
                String x=input.next();
                int ans=trans(x);
                if(ans<4000&&ans>0)
                    System.out.println("轉換結果："+ans);
                else
                    System.out.println("數值需介於0~4000之間");
            }
        }
    }
    //函數同名，傳入數值不同，叫做overloading
    public static String trans(int x){//阿拉伯轉羅馬
        int count=0;
        String sum=new String();
        while(x!=0){//加總的時候在中間加入 +""+ 防止某些特例會讓文字轉成數字，尤其在9的情況會出問題
            if(x%10==4)//4的情況
                sum=rrule[count]+""+rrule[count+1]+""+sum;
            else if(x%10==9)//9的情況
                sum=rrule[count]+""+rrule[count+2]+""+sum;
            else if(x%10<4)//0~3的情況
                for(int i=0;i<x%10;i++)
                    sum=rrule[count]+""+sum;
            else{
                for(int i=0;i<x%10-5;i++)//5~8的情況
                    sum=rrule[count]+""+sum;
                sum=rrule[count+1]+""+sum;
            }
            count+=2;//位數每次跳兩位，根據rule的數字，一位數 0~1 二位數 2~3 三位數 4~5 四位數 6
            x/=10;
        }
        return sum;
    }
    public static int trans(String s){//羅馬轉阿拉伯
        int[] data=new int[s.length()];
        for(int i=0;i<s.length();i++){//將字母轉換成數字儲存進陣列
            for(int j=0;j<rrule.length;j++)//判斷字母跟數字的相對位置
                if(s.charAt(i)==rrule[j])
                    data[i]=rule[j];
        }
        int sum=0;
        int count=0;//計算現在在第幾個字母
        while(count<data.length){//計算總和
            sum+=data[count];
            if(count>0&&data[count]>data[count-1])
                sum-=data[count-1]*2;
            count++;
        }
        return sum;
    }
}