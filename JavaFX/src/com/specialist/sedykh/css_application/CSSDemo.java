package com.specialist.sedykh.css_application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.Random;
// add this to run configuration:
// --module-path ${PATH_TO_FX} --add-modules javafx.controls,javafx.fxml
public class CSSDemo extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        // Коллекция JavaFX со встроенным наблюдателем
        // Наблюдатель работает в отдельном потоке (в т.ч. анимация)
        ObservableList<PieChart.Data> data = FXCollections.observableArrayList();

        Button btn = new Button("Add data");
        // Сама диаграмма - безымянный объект
        btn.setOnAction(event -> data.add(
            new PieChart.Data(
                "Data " + (data.size() + 1),
                new Random().nextInt(40) + 10)));

        Button btn2 = new Button("Remove data");
        btn2.setOnAction(event -> {
            if (!data.isEmpty())
                data.remove(new Random().nextInt(data.size()));
        });

        // Диаграмма появляется в самом конце - в интерфейсе, у нее даже имени нет.
        // Связь осуществляется через data - наблюдаемая коллекция,
        // которая автоматически оповещает диаграмму об изменениях
        FlowPane root = new FlowPane();
        root.getChildren().add(btn);
        root.getChildren().add(btn2);
        root.getChildren().add(new Label("I love CSS!"));
        // Строим круговую диаграмму на основе данных
        root.getChildren().add(new PieChart(data));

        Scene scene = new Scene(root, 450, 500);
        /*
        Файл CSS привязан к сцене. Он описывает её внешний вид.
        У приложения может быть несколько вариантов оформления.
        Эти варианты оформления хранятся в Stylesheets().
        Добавляем оформление в новую коллекцию:
            Подгрузка внешнего ресурса возможна только через код класса.
            Т.к. это д.б. привязано к логике битовых действий,
            т.е. событий, связанных с логикой кода.
            Берём класс - getClass() - инструмент рефлексии.
            Обращаемся к параметру класса - Resource -
            т.е. ресурсам, которые можно добавить к классу.
            Преобразуем полученный URL объект в строковую запись,
            т.к. чтобы CSS сформировалась, его нужно загрузить как текст.
            То есть преобразовать содержимое файла в текст - toExternalForm()
            Т.о. ресурсный файл будет открыть как текст.
         */
        scene.getStylesheets().add(
            getClass().getResource("CascadeSS.css").toExternalForm());

        primaryStage.setTitle("JavaFX CSS demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
