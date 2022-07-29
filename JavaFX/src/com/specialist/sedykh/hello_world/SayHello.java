package com.specialist.sedykh.hello_world;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

// add this to run configuration:
// --module-path ${PATH_TO_FX} --add-modules javafx.controls,javafx.fxml
public class SayHello extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        // ** View **
        Button btn = new Button("Скажи \"Привет\"!");
        Label lbl1 = new Label("Введите Ваше имя:");
        TextField txt = new TextField();
        Label lbl2 = new Label();

        GridPane root = new GridPane();
        // сначала столбец, потом строка
        root.add(lbl1, 0, 0);
        root.add(txt, 1, 0);
        root.add(btn, 1, 1);
        root.add(lbl2, 1, 2);

        Scene scene = new Scene(root, 300, 250);

        // ** Controller **
        btn.setOnAction(e -> {
            // ** Model **
            if (txt.getText().isEmpty())
                lbl2.setText("Привет, незнакомец!");
            else
                lbl2.setText("Привет, " + txt.getText() + "!");
        });

        primaryStage.setTitle("Say Hello");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }

}
