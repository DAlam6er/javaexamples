package com.specialist.sedykh.hello_world;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

// add this to run configuration:
// --module-path ${PATH_TO_FX} --add-modules javafx.controls,javafx.fxml
public class HelloWorld extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Button btn = new Button();
        btn.setText("Say \"Hello World\"");
        btn.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                System.out.println("Hello World!");
            }
        });

        StackPane root = new StackPane();
        // getChildren() - обращается к коллекции элементов управления, размещенной в StackPane
        // у самого Pane есть возможность размещения объектов, но она сложная, ей нужно управлять.
        // а работая сразу с коллекцией мы можем её разом выключить/включить - это удобно.
        // добавляем актёра (в данном случае они будут располагаться друг над другом)
        root.getChildren().add(btn);

        // Размеры окна, где будет происходить спектакль: 300x250
        Scene scene = new Scene(root, 300, 250);

        // primaryStage - сам театр
        // Вывешиваем афишу
        primaryStage.setTitle("Hello World!");
        // Настроили подмостки театра для работы
        primaryStage.setScene(scene);
        // Представление начинается!
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
