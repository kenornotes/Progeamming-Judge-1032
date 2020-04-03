public class DrawMoreCircle {
    public static void main(String[] argv){
        int x = 400, y = 300;
        int r = 250;
        for(;r>0;r-=50){
            (new NewThread(x, y, r, r-50)).start();
        }
    }
}
class DrawAction {
    static Pen p=new Pen();
    public synchronized static void paint(int x1, int y1, int x2, int y2){//critical section
        p.flyTo(x1,y1);
        p.runTo(x2,y2);
        try{
            Thread.sleep(1);
        } catch(Exception err) {
            System.out.println("Error");
        }
    }
    public static void draw(int x,int y,int r,int degree){
        for(int j = r; j > degree ; j -= 10) {
            for(int i = 0; i <= 360;i += 1) {//砞﹚计
                int x1 = (int)(j * Math.cos(Math.PI/180*i)+ x);
                int y1 = (int)(j * Math.sin(Math.PI/180*i)+ y);          
                int x2 = (int)(j * Math.cos(Math.PI/180*(i+1))+ x);
                int y2 = (int)(j * Math.sin(Math.PI/180*(i+1))+ y);
                paint(x1,y1,x2,y2);//礶絬
            }
        }
    }
}
class NewThread extends Thread{
    int x, y, degree, r;
    public NewThread(int x, int y, int r,int degree){
        this.x = x;
        this.y = y;
        this.r = r;
        this.degree = degree;
    }
    public void run(){
        DrawAction.draw(x , y, r, degree);
    }
}