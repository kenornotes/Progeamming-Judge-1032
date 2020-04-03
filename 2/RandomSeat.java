import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class RandomSeat extends JFrame implements ActionListener{
    // 準備 label 陣列及座位陣列
    JLabel[] labels = new JLabel[45];
    int[] seat = new int[45];
    // 隨機換位
    public void randomSeat() {
        for (int i = 0; i < seat.length; i++) {
            int randnum = (int)(Math.random()*seat.length);
            int temp = seat[i];
            seat[i] = seat[randnum];
            seat[randnum] = temp;
        }
    }
    // 監聽反應
    public void actionPerformed(ActionEvent e){
        String s = e.getActionCommand();
        if (s.equals("講桌")) {
            // 隨機換位
            randomSeat();
            // 依序坐到位置上（放到 label 上）
            for (int i = 0; i < seat.length; i++) {
                labels[i].setText(Integer.toString(seat[i]));
            }
        }
    }
    public RandomSeat() {
        // 準備初始座位（1號坐在位置1）
        for (int i = 0; i < seat.length; i++) {
            seat[i] = i+1;
        }
        this.setSize(500,500);
        setLayout(new GridLayout(10,5));
        // 準備四個空白 label，擺在講座兩側
        JLabel[] blankLabels = new JLabel[4];
        for (int i = 0; i < blankLabels.length; i++) {
            blankLabels[i] = new JLabel(" ");
        }
        // 設定會觸動奇妙開關的神秘講桌
        JButton randomButton = new JButton("講桌");
        randomButton.addActionListener(this);
        this.add(blankLabels[0]);
        this.add(blankLabels[1]);
        this.add(randomButton);
        this.add(blankLabels[2]);
        this.add(blankLabels[3]);
        // 排好桌子、依序先坐上去
        for (int i = 0; i < seat.length; i++) {
            labels[i] = new JLabel(Integer.toString(i+1), JLabel.CENTER);
            this.add(labels[i]);
        }
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] argv) {
        new RandomSeat();
    }
}
