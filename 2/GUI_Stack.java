import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class Stack {
    int[] data;
    int top;
    public Stack(int length) {
        data = new int[length];
    }
    public void push(int x) {
        data[top++] = x;
    }
    public int pop() {
        int temp = data[--top];
        data[top] = 0;
        return temp;
    }
    public boolean isFull() {
        return top == data.length;
    }
    public int stackSize() {
        return top;
    }
}

public class GUI_Stack extends JFrame implements ActionListener {
    int stackLength = 10;
    JLabel[] label = new JLabel[stackLength];
    JTextField input;
    Stack s = new Stack(stackLength);
    //set Label
    public void CreateJLabel() {
        for (int i = stackLength-1; i >= 0; i--) {
            label[i] = new JLabel("空", JLabel.CENTER);
            label[i].setFont(new Font(Font.MONOSPACED, Font.BOLD, 50));
            this.add(label[i]); 
        }
    }
    //設定輸入後所執行的動作
    public void actionPerformed(ActionEvent e) {
        String token = e.getActionCommand();
        CountPostFix(token);
        SetJLabelResult();
        input.setText("");
    }
    //把 Stack 內容設定到Label
    public void SetJLabelResult() {
        for (int i = 0; i < stackLength; i++) {
            if (i < s.stackSize())
                label[i].setText(Integer.toString(s.data[i]));
            else
                label[i].setText("空");
            
        }
    }
    
    //後置式計算
    public void CountPostFix(String token) {
        int tmp;
        if (token.equals("+") && s.stackSize() >= 2) {
            s.push(s.pop() + s.pop());
        } else if (token.equals("-") && s.stackSize() >= 2) {
            tmp = s.pop();
            s.push(s.pop() - tmp);
        } else if (token.equals("*") && s.stackSize() >= 2) {
            s.push(s.pop() * s.pop());
        } else if (token.equals("/") && s.stackSize() >= 2) {
            tmp = s.pop();
            s.push(s.pop() / tmp);
        } else if (token.equals("%") && s.stackSize() >= 2) {
            tmp = s.pop();
            s.push(s.pop() % tmp);
        } else if (token.equals("^") && s.stackSize() >= 2) {
            tmp = s.pop();
            s.push((int)Math.pow(s.pop(), tmp));
        } else {
            int val;
            try {
                val = Integer.parseInt(token);
                if (!s.isFull()) {
                    s.push(val);
                } else {
                    JOptionPane.showMessageDialog(null, "滿惹，放不下惹！");;
                }
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, "嗚嗚 輸入錯誤惹QAQ");
            }
        }   
    }
    public GUI_Stack() {
        //set layout size
        this.setSize(500, 800);
        this.setLayout(new GridLayout(stackLength+1,1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set Labels
        CreateJLabel();
        //set text input
        input = new JTextField();
        input.addActionListener(this);
        this.add(input);
        this.setVisible(true);
        
    }
    public static void main(String[] argv) {
        new GUI_Stack();
    }
}
