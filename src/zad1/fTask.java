package zad1;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class fTask extends FutureTask<Integer> {
    Callable c;
    public fTask(Callable<Integer> callable) {
        super(callable);
        c=callable;
    }

    public void done(){
        if(Main.infoStat) {
            try {
                Main.setLabel("Thread " + get() + ": Done!");
                Main.tButtons.get(get()-1).deleteButton=true;
                Main.disableButton(get());
                System.out.println("Thread " + get() + ": Done!");
                TimerDeleteButton tdb = new TimerDeleteButton(get());
                tdb.start();
            } catch (Exception e) {

            }
        }
    }


}
