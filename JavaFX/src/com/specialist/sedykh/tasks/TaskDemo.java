package com.specialist.sedykh.tasks;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.concurrent.Task;
import javafx.stage.Stage;

// add this to run configuration:
// --module-path ${PATH_TO_FX} --add-modules javafx.controls,javafx.fxml

// За исполнение таска отвечает JavaFX-платформа, поэтому наследуемся от класса Application
// превращаем в JavaFX приложение
public class TaskDemo extends Application
{
    public static void main(String[] args)
    {
        MyTask task = new MyTask();

        // таск управляется обычным java-приложением
        // следить будем за таском, а не за потоком, поэтому ссылка на поток не нужна
        // В реальной жизни Thread уже не нужен после того как task запущен
        // нужен только для команды start()
        new Thread(task).start();

        // status будет хранить информацию о том,
        // до какого момента дошел прогресс в таске
        DoubleProperty status = new SimpleDoubleProperty();
        status.bind(task.progressProperty());

        try {
            // цикл следит за состоянием таска
            // task.isRunning() НЕЛЬЗЯ, т.к. на момент вызова этой команды,
            // может оказаться так, что поток еще пока в состоянии NEW,
            // и не успел дойти до состояния RUNNABLE (создан, но не запущен)
            // Можно использовать только для внутренних проверок, иначе словим ошибку
            // Task must only be used from the FX Application Thread

            // т.е следим за состоянием потока до тех пор, пока таск не завершился!
            while (!task.isDone()) {
                // Вывод начинается с -1, т.к. всё зависит от того,
                // с какого момента был получен ответ
                // -1 - статус незапущенного потока
                System.out.println(status.get());
                // Будем раз в секунду опрашивать, чаще не нужно
                // не всегда известно сколько выполняется один шаг потока
                // (там может быть сложная математика)
                Thread.sleep(1000);
                // Не будет exception, цикл нормально завершится,
                // несмотря на то, что в заголовке цикла написано (!task.isDone())
                // Это связано с тем, что cancel() продуцирует isDone().
                // То есть в нормальных условиях, сначала вызывается cancel,
                // приводящий к состоянию isDone()
                // task.cancel();
            }
        } catch (InterruptedException exception) {
            System.out.println("Interrupted exception was caught!");
        }

        // Управляющий поток будет висеть, пока мы его не завершим
        // Вариант 1
        // System.exit(0);

        // Завершение платформы JavaFX - более мягкое и безопасное
        // завершение работы JavaFX-приложения

        // Платформу нельзя завершить, пока таск работает в РАБОЧЕМ ПОТОКЕ
        // Этот класс хорош тем, что позволяет пользоваться фишками JavaFX там,
        // где обычная Java работает
        Platform.exit();
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        // код написан в main
        // приложение будет без оконного интерфейса, а у нас оно не оконное
    }
}

// Task - это callable thread JavaFX,
// у него есть возвращаемое значение в угловых скобках
class MyTask extends Task<Void>
{

    @Override
    protected Void call() throws Exception
    {
        // Номер не нулевой, т.к.
        // Application сам запускает потоки (управляющий и рабочий) для оконного интерфейса
        // System.out.println("Hello from " + Thread.currentThread().getName());

        // Задача, решаемая таском, имитация работы программы (5 секунд)
        for (int i = 0; i < 10; i++) {
            // воспользуемся изменением состояния, т.е. самого прогресса.
            // число 10 в реальной жизни неизвестно
            // - это предельное значение прогресса
            updateProgress(i+1, 10);
            Thread.sleep(500);
        }
        return null;
    }

    // Метод вызывается в случае окончания работы таска
    // Раньше мы не видели эту надпись, т.к. платформа завершала работу раньше,
    // и println не успевал отработать
    @Override
    protected void succeeded()
    {
        System.out.println("Task completed");
    }

    // Мы можем на уровне таска узнать, что с таском происходит
    @Override
    protected void cancelled()
    {
        System.out.println("Task was cancelled!");
    }
}
