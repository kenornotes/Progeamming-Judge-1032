import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class Queue {
    int[] data = new int[10];
    int head, tail, size;
    public void add(int x) {
        data[tail++] = x;
        tail %= data.length;
        size++;
    }  
    public void remove() {
        data[head++] = -1;
        head %= data.length;
        size--;
    }  
}

public class GUI_Queue extends JFrame implements ActionListener {
    JLabel[] label = new JLabel[10];
    JTextField input;
    Queue q = new Queue();
    //set Label
    public void CreateJLabel() {
        for (int i = 0; i < 10; i++) {
            q.data[i] = -1; //讓Queue data 初始值為 -1
            label[i] = new JLabel("空", JLabel.CENTER);
            label[i].setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
            this.add(label[i]); 
        }
    }

    //設定輸入後所執行的動作，如果是remove則刪除Queue，其他則加入Queue
    public void actionPerformed(ActionEvent e) {
        String token = e.getActionCommand();
        if(token.equals("remove")) {
            if(q.data[q.head] == -1) 
                JOptionPane.showMessageDialog(null, "現在是空值唷 (⊙◞౪◟⊙)");
            else
                q.remove();
        } else {
            try {
                if (Integer.parseInt(token) >= 0)
                    q.add(Integer.parseInt(token));
                else
                    JOptionPane.showMessageDialog(null, "嗚嗚 請輸入正整數 QAQ");
            } catch(Exception err){
                JOptionPane.showMessageDialog(null, "輸入錯誤惹 ヽ(｀Д´)ﾉ");
            }
        }
        SetJLabelResult();
        input.setText("");
    }

    //把 Queue 內容設定到Label
    public void SetJLabelResult() {
        for (int i = 0; i < 10; i++)
            if(q.data[i] == -1) {
                label[i].setText("空");
            } else {
                label[i].setText(Integer.toString(q.data[i]));
            }
    }

    public GUI_Queue() {
        //set layout size
        this.setSize(800,300);
        this.setLayout(new GridLayout(1, 12));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set Labels
        CreateJLabel();
        //set text input field
        input = new JTextField();
        input.addActionListener(this);
        this.add(input);
        //set remove button
        JButton remove = new JButton("remove");
        remove.addActionListener(this);
        this.add(remove);
        this.setVisible(true);
    }

    public static void main(String[] argv) {
        new GUI_Queue();
    }
}