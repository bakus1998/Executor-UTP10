package zad1;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    public Scene myScene;
    static int counterT = 1;
    static List<MyButton> tButtons = new ArrayList<>();
    static boolean program_status = true;
    static TextArea ta = new TextArea();
    static String txt="";
    static HBox hb = new HBox(); //threads buttons
    static boolean infoStat=true;
    static Label label = new Label();


    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane bp = new BorderPane();
        VBox vb = new VBox();

        vb.setAlignment(Pos.CENTER);
        vb.setPadding(new Insets(5,5,5,5));
        vb.setSpacing(10);

        Button stop = new Button("Stop");
        Button CreateNew = new Button("Create new");

        stop.setMaxWidth(Double.MAX_VALUE);
        CreateNew.setMaxWidth(Double.MAX_VALUE);

        ScrollPane sp = new ScrollPane();


        sp.setContent(label);
        ta.setEditable(false);
        ta.setWrapText(true);

        KeyCombination kc = new KeyCodeCombination(KeyCode.C);

        CreateNew.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(program_status) {
                    tButtons.add(new MyButton(counterT++));
                    hb.getChildren().add(tButtons.get(tButtons.size() - 1));
                }
            }
        });


        stop.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for (int i = 0; i < tButtons.size(); i++) {
                    infoStat=false;
                    tButtons.get(i).setDisable(true);
                    if(tButtons.get(i).isRunning)
                    tButtons.get(i).ft.cancel(true);
                }
                setLabel("Program stopped!");
                program_status=false;
            }
        });


        vb.getChildren().addAll(stop,CreateNew);
        bp.setTop(vb);
        bp.setCenter(sp);
        bp.setBottom(hb);
        bp.setPrefSize(700,700);
        ta.setPrefSize(bp.getPrefWidth()-2,bp.getPrefHeight()-100);

        myScene = new Scene(bp);

        primaryStage.setScene(myScene);
        primaryStage.show();
        primaryStage.setTitle("Thread pool in FX by Krzysztof Baka s16696");
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.exit(0);
            }
        });


    }

    public static void setLabel(String s){
       //System.out.println(s);
        txt += s + "\n";
        setter();
    }
    public static void disableButton(int i){
        Platform.runLater(()->
        tButtons.get(i-1).setText("T"+i+" done!"));
        tButtons.get(i-1).setDisable(true);
    }

    public static void setter(){
        Platform.runLater(()->label.setText(txt));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
