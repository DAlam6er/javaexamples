package com.headfirstjava.chap18.RMIBrowser;

import javax.swing.*;
import java.io.Serializable;

// Описывает метод, которым должен обладать любой универсальный сервис.
// Любой реализующий его класс можно сериализовать
public interface Service extends Serializable
{
    JPanel getGuiPanel();
}
