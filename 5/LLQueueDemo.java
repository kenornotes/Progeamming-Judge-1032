import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
public class LLQueueDemo extends JFrame implements ActionListener{
    JLabel[] labels;
    JTextField textField;
    Font font=new Font(Font.MONOSPACED,Font.BOLD,30);
    Queue queue;
    public void actionPerformed(ActionEvent e){
        String command=e.getActionCommand();
        if(command.equals("Remove")){
            Node tmp=queue.remove();
            if(tmp==null)
                JOptionPane.showMessageDialog(this,"Empty Queue");
        }
        else{
            try{
                int data=Integer.parseInt(command);
                queue.add(data);
            }catch(Exception err){
                JOptionPane.showMessageDialog(this,"Wrong Input");
            }
        }
        textField.setText("");
        setQueueLabels();
    }
    public LLQueueDemo(){
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize().width,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(1,12));
        initComponents();
        setQueueLabels();
        this.setVisible(true);
    }
    public void initComponents(){
        queue=new Queue();
        labels=new JLabel[10];
        for(int i=0;i<labels.length;i++){
            labels[i]=new JLabel("",JLabel.CENTER);
            labels[i].setFont(font);
            this.add(labels[i]);
        }
        textField=new JTextField();
        textField.addActionListener(this);
        this.add(textField);
        JButton removeButton=new JButton("Remove");
        removeButton.addActionListener(this);
        this.add(removeButton);
    }
    public void setQueueLabels(){
        Node tmp=queue.head;
        for(int i=0;i<labels.length-1;i++){
            if(tmp!=null){
                labels[i].setText(tmp.data+"");
                tmp=tmp.next;
            }
            else
                labels[i].setText("Empty");
        }
        if(queue.size>10)
            labels[9].setText((queue.size-9)+" more");
        else if(queue.size==10)
            labels[9].setText(tmp.data+"");
        else
            labels[9].setText("Empty");
    }
    public static void main(String[] argv){
        new LLQueueDemo();
    }
}
class Node{
    int data;
    Node next;
}
class Queue{
    Node head,tail;
    int size;
    public void add(int data){
        Node tmp=new Node();
        tmp.data=data;
        if(head==null)
            head=tail=tmp;
        else{
            tail.next=tmp;
            tail=tmp;
        }
        size++;
    }
    public Node remove(){
        Node tmp=head;
        if(head!=null){
            head=head.next;
            size--;
        }
        if(head==null)
            tail=null;
        return tmp;
    }
}