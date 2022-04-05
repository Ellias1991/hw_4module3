package lesson4;

public class ThreeLetters {
    static Object mon=new Object();
    static volatile char currentLetter="C";

    public static void main(String[] args) {
        new Thread(()->{
            try{
                for (int i=0;i<5;i++){
                 synchronized (mon){
                    while (currentLetter !='A'){
                        mon.wait();
                    }

                     System.out.println("A");
                    currentLetter='B';
                    mon.notifyAll();
                 }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        
    }
}
