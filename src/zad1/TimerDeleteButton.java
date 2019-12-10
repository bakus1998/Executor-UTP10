package zad1;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class TimerDeleteButton extends Thread {
    static int sec=0;
    int whichButton;

    public TimerDeleteButton(int whichButton){
        this.whichButton=whichButton;
    }

    Timeline timel = new Timeline(new KeyFrame(Duration.millis(1000), ev ->{
        sec++;
        if(sec==3) {
            if (Main.tButtons.get(whichButton-1).deleteButton == true) {
                Main.hb.getChildren().remove(Main.tButtons.get(whichButton-1));
                this.stop();
            }
            sec=0;
        }
    }));
    @Override
    public void run() {
        while (!isInterrupted()) {
            timel.play();
        }
    }
}
