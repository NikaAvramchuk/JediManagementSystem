package cschool.projekt.jedi;

import cschool.gui.mini.login.form.Panel3;

import javax.swing.*;

public class Window extends JFrame{
    public Window() {
        setSize(800,680);
        setLocation(100,20);
        setTitle("Jedi management system");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);//nie moge zmienic wielkosci okna

        Panel panel = new Panel();
        add(panel);
        panel.setVisible(true);

    }
}
