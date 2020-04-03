import java.util.*;

class 公公 implements Runnable {
    private int[] a;
    
    public 公公(int[] a) {
        this.a = a;
    }
    
    public void run() {
        選妃.公公選妃(a);
    }
}

public class 選妃 {

    public static void main(String[] args) throws Throwable {
        int length = Integer.parseInt(args[0]);
        int[] a = createRandomArray(length);

        long startTime1 = System.currentTimeMillis();
        平行選妃(a);
        long endTime1 = System.currentTimeMillis();

        if (!isSorted(a)) {
            throw new RuntimeException("造反啊！妃子順序亂了！: " + Arrays.toString(a));
        }
        System.out.println(length + " 個妃子來選共花了 " + (endTime1 - startTime1) + " 毫秒 ");
        System.out.println("辛苦李公公、王公公了！");
    }

    // for thread
    public static void 平行選妃(int[] a) {
        // split array in half
        int[] 西六宮 = ArrayCopy(a, 0, a.length / 2);
        int[] 東六宮 = ArrayCopy(a, a.length / 2, a.length);

        Thread 李公公 = new Thread(new 公公(西六宮));
        Thread 王公公 = new Thread(new 公公(東六宮));
        李公公.start();
        王公公.start();

        try {
            李公公.join();
            王公公.join();
        } catch (InterruptedException ie) {}

        // merge them back together
        merge(西六宮, 東六宮, a);
    }

    public static void 公公選妃(int[] 妃子們) {
        if (妃子們.length >= 2) {
            // split array in half
            int[] left  = ArrayCopy(妃子們, 0, 妃子們.length / 2);
            int[] right = ArrayCopy(妃子們, 妃子們.length / 2, 妃子們.length);

            // sort the halves
            公公選妃(left);
            公公選妃(right);

            // merge them back together
            merge(left, right, 妃子們);
        }
    }
    
    public static void merge(int[] left, int[] right, int[] a) {
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < a.length; i++) {
            if (i2 >= right.length || (i1 < left.length && left[i1] < right[i2])) {
                a[i] = left[i1];
                i1++;
            } else {
                a[i] = right[i2];
                i2++;
            }
        }
    }

    public static void swap(int[] a, int i, int j) {
        if (i != j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }
    
    public static boolean isSorted(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static int[] createRandomArray(int length) {
        int[] a = new int[length];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int)(Math.random()*60+39);
        }
        return a;
    }
    public static int[] ArrayCopy(int[] a, int start, int end) {
        int[] result = new int[end-start];
        for (int i = 0; i < (end-start); i++) {
            result[i] = a[start + i];
        }
        return result;
    }
}
