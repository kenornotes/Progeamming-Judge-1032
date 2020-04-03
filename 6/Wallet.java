import java.util.Scanner;
public class Wallet {
    String name;
    int mymoney, classmoney;
    static int allclassmoney;
    public Wallet(String name, int mymoney) {
        this.name = name;                //名字 
        this.mymoney = mymoney;          //我的錢包現在有多少錢
    }
    public void earnMoney(int amount) { //賺 or 拿到錢
        mymoney += amount;
    }
    public void spendMoney(int amount) { //花錢
        mymoney -= amount;
    }
    public static void donateMoney(int amount) { //付班費 
        allclassmoney += amount;
    }
    public void print() {
        System.out.println(name +" 錢包裡有 "+ mymoney + " 塊"); 
    }
    public static void main(String[] argv ) {
        Wallet[] allWallets = new Wallet[50];    
        int numWallet = 0;                        //計算目前有多少個錢包
        Scanner input = new Scanner(System.in);
        while (true) {
            String command = input.next();
            if (command.equals("new")) {   
                allWallets[numWallet++] = new Wallet(input.next(), input.nextInt()); //輸入「名字」, 「目前錢包有多少錢」
            } else if (command.equals("end")) {
                break;
            } else {
                String name = input.next();
                int i;
		for (i = 0; i < numWallet; i++) { 
                    if (allWallets[i].name.equals(name))
                        break;
                }
                if (command.equals("donateMoney")) {
                    int paymoney = input.nextInt();
		    if (allWallets[i].mymoney - paymoney < 0) { 
                        System.out.println( allWallets[i].name + " 的錢包裡的錢不夠捐錢"); 
                    } else {
                        allWallets[i].spendMoney(paymoney);
                        allWallets[i].donateMoney(paymoney);
                    }
                } else if (command.equals("earnMoney")) { 
                    allWallets[i].earnMoney(input.nextInt());
                } else if (command.equals("spendMoney")) {
                    int paymoney = input.nextInt();
		    if (allWallets[i].mymoney - paymoney < 0) { 
                        System.out.println( allWallets[i].name + " 的錢包裡沒錢了"); 
                    } else {
                        allWallets[i].spendMoney(paymoney);
                    }
                } else {
                    System.out.println("輸入錯誤！！"); 
                }
            }
        }
        for (int i = 0; i < numWallet; i++) {
            allWallets[i].print();
        }
        System.out.println("現在募資總共有 " + allclassmoney + " 塊");
    }
}
