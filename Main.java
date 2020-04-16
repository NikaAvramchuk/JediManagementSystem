package cschool.projekt.jedi;

import cschool.gui.mini.login.form.Window2;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                cschool.projekt.jedi.Window window = new Window();
                window.setVisible(true);
            }
        });

    }
}
