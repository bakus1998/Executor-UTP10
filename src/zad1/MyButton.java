package zad1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.util.concurrent.*;

public class MyButton extends Button {
    int number;
    boolean startStatus=false;
    boolean firstStart = true;
    FutureTask<Integer> ft;
    ExecutorService exec;
    boolean deleteButton = false;
    boolean isRunning = false;
    boolean statusThread  = true;
    KeyCombination kc = new KeyCodeCombination(KeyCode.C);


    public MyButton(int i) {
        setText("Thread " + i);
        this.number=i;

        setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(firstStart){
                    Callable<Integer> callab = new callTask(number);
                    ft = new fTask(callab);
                    exec = Executors.newSingleThreadExecutor();
                    exec.submit(ft);
                    isRunning=true;
                    firstStart=false;
                }
                if(!startStatus){
                    startStatus=true; //DZIALA WĄTEK
                    setText("Suspend T"+number);
                    statusThread=true;
                    //System.out.println(statusThread);

                }else{
                    startStatus=false; //Wątek wstrzymany
                    setText("Continue T" + number);
                    isRunning=false;
                    statusThread=false;

                    //System.out.println(statusThread);
                }

            }
        });

        setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(isPressed()) {
                    if (kc.match(event)) {
                        setDisable(true);
                        setText("T" + i + " Canceled!");
                        if(isRunning) {
                            Main.setLabel("Thread " + i +": Cancelled!");
                            ft.cancel(true);
                        }

                    }
                }
            }
        });

    }



}
