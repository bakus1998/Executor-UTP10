package zad1;

import java.util.concurrent.Callable;

public class callTask implements Callable<Integer> {
    int number=0;
    int inNumber=0;
    int limit;


    public callTask(int number){
        this.number=number;
        limit=number*1000;
    }


    @Override
    public Integer call() throws Exception {
        while(inNumber<limit) {
            synchronized (this){
                while ((Main.tButtons.get(number-1).statusThread==false)){
                    wait(300);
                }
            }
            int rand = (int)(Math.random()*100);
            inNumber+=rand;
            String show = "Thread " + number + " limit = "+limit+": " +rand+", sum = " + inNumber;
            Main.setLabel(show);
            Thread.sleep(300);

        }
        return number;
    }


}
