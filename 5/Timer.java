import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.util.Scanner;
public class Timer extends JFrame{
    public Timer(String input){
        this.setSize(340,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        JLabel label=new JLabel("",JLabel.CENTER);
        label.setFont(new Font(Font.MONOSPACED,Font.BOLD,80));
        this.add(label);
        (new CountTime(label,input)).start();
        this.setVisible(true);
    }
    public static void main(String[] argv){
        System.out.println("Set your alarm(hr:min:sec):");
        String input=(new Scanner(System.in)).next();
        new Timer(input);
    }
}
class CountTime extends Thread{
    JLabel label;
    long hr,min,sec;
    long hrL,minL,secL;
    long start=System.currentTimeMillis();
    public CountTime(JLabel label,String input){;
        this.label=label;
        String[] separateTime=input.split(":");
        hr=hrL=Integer.parseInt(separateTime[0]);
        min=minL=Integer.parseInt(separateTime[1]);
        sec=secL=Integer.parseInt(separateTime[2]);
    }
    public void run(){
        while(true){
            label.setText(hrL+":"+minL+":"+secL);
            if(hrL==0&&minL==0&&secL==0){
                JOptionPane.showMessageDialog(null,"Time's Up!");
                System.exit(0);
            }
            checkTime();
        }
    }
    public void checkTime(){
        //Because of the time waste while the code is running, so I don't use Thread.sleep method
        //Thus, I choose to compare the difference between the beginning and now
        long now=System.currentTimeMillis();
        long timeLeft=(now-start)/1000;
        long hrLeft=timeLeft/3600;
        long minLeft=(timeLeft-3600*hrLeft)/60;
        long secLeft=timeLeft-3600*hrLeft-60*minLeft;
        hrL=hr-hrLeft;
        minL=min-minLeft;
        secL=sec-secLeft;
        if(secL<0){
            minL--;
            secL+=60;
        }
        if(minL<0){
            hrL--;
            minL+=60;
        }
    }
}

