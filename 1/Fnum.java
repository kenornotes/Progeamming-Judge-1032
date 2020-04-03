
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.math.BigInteger;
public class Fnum extends JFrame implements ActionListener{
    int count=1;
    JLabel which=new JLabel("",JLabel.CENTER);
    JLabel result=new JLabel("",JLabel.CENTER);
    public Fnum(){
        //JFrame setting
        this.setTitle("Fnum Search");
        this.setSize(1000,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(4,1));
        //Menu Bar
        JMenuBar mb=new JMenuBar();
        this.setJMenuBar(mb);
        JMenu m=new JMenu("操作");
        mb.add(m);
        JMenuItem mi=new JMenuItem("重設");
        mi.addActionListener(this);
        m.add(mi);
        //set JLabel
        setJLabelResult();
        which.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));
        this.add(which);
        result.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));
        this.add(result);
        //set JButton
        JButton plusOne=new JButton("+1");
        plusOne.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));
        plusOne.addActionListener(this);
        this.add(plusOne);
        JButton plusHundred=new JButton("+10");
        plusHundred.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));
        plusHundred.addActionListener(this);
        this.add(plusHundred);
        //set visible
        this.setVisible(true);
    }
    public static void main(String[] argv){
        new Fnum();
    }
    public void actionPerformed(ActionEvent e){
        String s=e.getActionCommand();
        if(s.equals("+1"))
            count++;
        else if(s.equals("+10"))
            count+=10;
        else if(s.equals("重設"))
            count=1;
        setJLabelResult();
    }
    public void setJLabelResult(){
        which.setText("No."+count+" F-number is:");
        result.setText((fRun(count).toString()));
    }
    //f(n)=f(n-1)+f(n-2)
    public BigInteger fRun(int n){
        BigInteger f_1=new BigInteger("1"),f_2=new BigInteger("-1");
        for(int i=0;i<=n;i++){
            BigInteger tmp=f_1;
            f_1=f_1.add(f_2);
            f_2=tmp;
        }
        return f_1;
    }
}