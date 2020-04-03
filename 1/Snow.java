import javax.swing.JOptionPane;
public class Snow extends Thread{
    static Pen p;
    double x1,y1,x2,y2;
    int degree;
    public Snow(double x1,double y1,double x2,double y2,int degree){
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
        this.degree=degree;
    }
    public static void main(String[] argv){
        //middle(x,y)
        double x=400,y=300,r=250;
        java.util.Scanner input=new java.util.Scanner(System.in);
        System.out.print("請輸入頂點數量：");
        int num=input.nextInt();
        p=new Pen();
        draw(x,y,r,num);
    }
    public static void draw(double x,double y,double r,int num){
        for(int i=0;i<num;i++){
            double x1=x+r*Math.cos(Math.PI/180*(360*i/num));
            double y1=y+r*Math.sin(Math.PI/180*(360*i/num));
            double x2=x+r*Math.cos(Math.PI/180*(360*(i+1)/num));
            double y2=y+r*Math.sin(Math.PI/180*(360*(i+1)/num));
            (new Snow(x1,y1,x2,y2,(180-360/num)/2+360*(i+1)/num)).start();//num=3,30+60;num=4,45+90
        }
    }
    public static void draw(double x1,double y1,double x2,double y2,int degree){
        if(Math.sqrt(Math.pow(y2-y1,2)+Math.pow(x2-x1,2))<0.1){//too small than draw
            draw(x1,y1,x2,y2);
            return;
        }
        double x3=(2*x1+x2)/3,y3=(2*y1+y2)/3;//1/3 point
        double x4=(2*x2+x1)/3,y4=(2*y2+y1)/3;//2/3 point
        double len=Math.sqrt(Math.pow(y4-y3,2)+Math.pow(x4-x3,2));
        double x5=x3+len*Math.cos(Math.PI/180*(degree-60));//top point
        double y5=y3+len*Math.sin(Math.PI/180*(degree-60));
        draw(x1,y1,x3,y3,degree);
        draw(x3,y3,x5,y5,degree-60);
        draw(x5,y5,x4,y4,degree+60);
        draw(x4,y4,x2,y2,degree);
    }
    public synchronized static void draw(double x1,double y1,double x2,double y2){//critical section
        p.flyTo((int)x1,(int)y1);
        p.runTo((int)x2,(int)y2);
    }
    public void run(){
        draw(x1,y1,x2,y2,degree);
    }
}