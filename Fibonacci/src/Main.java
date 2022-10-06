class recursive extends Thread {
    public int fibo(int n) {
        if(n==0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibo(n - 1) + fibo(n - 2);
    }
    @Override
    public void run() {
        long t = System.nanoTime();
        Integer n = fibo(10);
        t = System.nanoTime() - t;
        System.out.println("Recursion Thread Answer is " + n +" "+ t + "ns" );

    }

}

class dynamic extends Thread{
    public int fibo(int n) {
        int v1=0,v2=1,v3=0;
        for (int i = 2; i <= n; i++) {
            v3 = v1 + v2;
            v1 = v2;
            v2 = v3;
        }
        return v3;
    }
    @Override
    public void run() {

        long t = System.nanoTime();
        Integer n = fibo(10);
        t = System.nanoTime() - t;
        System.out.println("Dynamic Thread Answer is " + n +" "+ t +"ns");

    }
}
public class Main {
    public static void main(String[] args) {
        recursive r = new recursive();
        r.start();
        dynamic d = new dynamic();
        d.start();
    }
}