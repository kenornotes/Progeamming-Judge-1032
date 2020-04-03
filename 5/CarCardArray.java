import java.util.Scanner;
public class CarCardArray{
    static String[] englishs;
    static String[] numbers;
    static String[] englishPerm;
    static String[] numberPerm;
    static int englishPermIndex=0;
    static int numberPermIndex=0;
    public static void main(String[] argv){
        Scanner input=new Scanner(System.in);
        //set characters
        System.out.print("Please input English characters:");
        String english=input.next();//input english
        englishs=english.split("");//split to array
        englishPerm=new String[perm(englishs.length)];//set result data array
        //set numbers
        System.out.print("Please input numbers:");
        String number=input.next();
        numbers=number.split("");
        numberPerm=new String[perm(numbers.length)];
        //do permutation
        permEnglish(englishs,0);
        permNumber(numbers,0);
        int count=0;
        for(int i=0;i<englishPerm.length;i++)//n characters
            for(int j=0;j<numberPerm.length;j++)//m numbers
                System.out.println(englishPerm[i]+"-"+numberPerm[j]);//total n*m results
    }
    public static void permEnglish(String[] data,int from){
        if(from==data.length-1){//最後一個不用做
            String result="";
            for(int i=0;i<data.length;i++)
                result+=data[i];
            englishPerm[englishPermIndex++]=result;//put it into array
            return;
        }
        for(int i=from;i<data.length;i++){
            String tmp=data[i];
            data[i]=data[from];
            data[from]=tmp;
            permEnglish(data,from+1);
            //資料還原
            tmp=data[i];
            data[i]=data[from];
            data[from]=tmp;
        }
    }
    public static void permNumber(String[] data,int from){
        if(from==data.length-1){//最後一個不用做
            String result="";
            for(int i=0;i<data.length;i++)
                result+=data[i];
            numberPerm[numberPermIndex++]=result;//put it into array
            return;
        }
        for(int i=from;i<data.length;i++){
            String tmp=data[i];
            data[i]=data[from];
            data[from]=tmp;
            permNumber(data,from+1);
            //資料還原
            tmp=data[i];
            data[i]=data[from];
            data[from]=tmp;
        }
    }
    public static int perm(int n){//count how many permutation result there are(P(n)=n!)
        if(n==1)
            return 1;
        return n*perm(n-1);
    }
}