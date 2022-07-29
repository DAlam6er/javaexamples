package com.specialist.sedykh.fxml_demo;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author student
 */
public class GridPaneController implements Initializable
{
    @FXML private TextField pathId;
    @FXML private TextField endId;
    @FXML private ProgressBar barId;
    @FXML private ListView<String> listId;

    private Task<Void> task = null;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        JavaFXApp.items.addListener(new ListChangeListener()
        {
            @Override
            public void onChanged(ListChangeListener.Change change)
            {
                listId.setItems(change.getList());
                listId.refresh();
            }
        });
    }

    @FXML
    public void btnFindClick(ActionEvent event)
    {
        String path = pathId.getText();
        String end = endId.getText();

        JavaFXApp.items.clear();
        //barId.setProgress(-1);

        task = new FindTask(JavaFXApp.items, path, end);

        barId.progressProperty().bind(task.progressProperty());

        //new FindTask(JavaFXApp.items, path, end).doWork;

        // run async Task in concurrent version
        Thread thread = new Thread(task);

        // превращаем поток в фоновый процесс, никак не связанный с консолью
        // или внешними средствами управления
        // Демон - чисто вспомогательный процесс, который решает свою задачу
        // в данном случае - поиск файлов
        thread.setDaemon(true);
        thread.start();

        // Свойство progressProperty теперь привязано,
        // а следовательно нельзя вызывать на нём метод setProgress()
        // barId.setProgress(1);
    }

    @FXML
    public void btnCancelClick(ActionEvent event)
    {
        System.out.println("Try to Cancel!");
        if (task != null) task.cancel();
    }

}
