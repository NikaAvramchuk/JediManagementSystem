package cschool.projekt.jedi;

//import com.sun.javafx.scene.control.skin.ColorPalette;
//import javafx.geometry.Orientation;
//import javafx.scene.control.ComboBox;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.Character;

public class Panel extends JPanel {
    static DefaultListModel<String> jediOrdersModel;
    static JList<String> jediOrders;

    static DefaultListModel<String> jediModel;
    static JList<String> jedi;

    static DefaultListModel<String> noOrderJediModel;
    static JList<String> noOrderJedi;
    static ArrayList<Jedi> noOrderJediArray = new ArrayList<> ();

    static DefaultListModel<String> jediInOrderModel;
    static JList<String> jediInOrder;


    JButton choose;
    JButton importOrder;
    JButton exportOrder;
    JButton importJedi;
    JButton exportJedi;
    JButton registrationLeft;
    JButton clearLeft;
    JButton registrationRight;
    JButton clearRight;
    JButton showJediinOrder;
    JButton hideJediOrder;

    JComboBox swordColor;

    JSlider power;

    JRadioButton sidePowerDark;
    JRadioButton sidePowerLight;

    JTextField orderNameField;
    JTextField orderSymbolField;

    JTextField fileWay;
    JTextField fileWay1;


    public Panel() {
        setLayout(null);


        Font font = new Font("base",Font.BOLD, 16);
        Font font1 = new Font("base1",Font.BOLD, 14);
        Font font2 = new Font("base1",Font.BOLD, 12);
        Font font3 = new Font("base2", Font.PLAIN, 10);

        getExistedJedisInOrder();

        JSeparator separator = new JSeparator();
        separator.setBounds(400, 10, 780, 700);
        separator.setOrientation(SwingConstants.VERTICAL);
        add(separator);

        JLabel jediOdrersLabel = new JLabel("Jedi Orders");
        jediOdrersLabel.setBounds(150, 20, 100, 30);
        jediOdrersLabel.setFont(font);
        add (jediOdrersLabel);

        JLabel jediLabel = new JLabel("Jedi");
        jediLabel.setBounds(590, 20, 100, 30);
        jediLabel.setFont(font);
        add (jediLabel);

        jediOrdersModel = new DefaultListModel<String>();
        arrayToModelOrders(jediOrdersModel,JediOrders.jediOrdersArrayList);
        jediOrders = new JList<String>(jediOrdersModel);
        add (jediOrders);
        jediOrders.setBounds(20,60,200, 220);
        jediOrders.setBorder(new LineBorder(Color.black));
        jediOrders.setSelectionBackground(Color.pink);

        showJediinOrder = new JButton("Show");
        showJediinOrder.setBounds(230,60,80,20);
        showJediinOrder.setFont(font2);
        add(showJediinOrder);
        showJediinOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                ArrayList<Jedi> jediFromSQL = new ArrayList<>(SQL.downloadJediInOrders(JediOrders.jediOrdersArrayList.get (jediOrders.getSelectedIndex())));
//                for (Jedi j: jediFromSQL)
//                    JediOrders.jediOrdersArrayList.get(jediOrders.getSelectedIndex()).getJedis().add(j);
                jediInOrderModel.removeAllElements();
                arrayToModel(jediInOrderModel,JediOrders.jediOrdersArrayList.get(jediOrders.getSelectedIndex()).getJedis());
                jediInOrder.setVisible(true);
            }
        });

        hideJediOrder = new JButton("Hide");
        hideJediOrder.setFont(font2);
        hideJediOrder.setBounds(315,60,80,20);
        add(hideJediOrder);
        hideJediOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jediInOrder.setVisible(false);
            }
        });

        jediInOrderModel = new DefaultListModel<>();
        jediInOrder = new JList<>(jediInOrderModel);
        jediInOrder.setBounds(230,95,160,185);
        jediInOrder.setSelectionBackground(Color.pink);
        jediInOrder.setBorder(new LineBorder(Color.black));
        jediInOrder.setVisible(false);
        add(jediInOrder);

        jediModel = new DefaultListModel<String>();
        arrayToModel(jediModel,Jedi.jediArrayList);
        jedi = new JList<String>(jediModel);
        add(jedi);
        jedi.setBounds(430,60,350,220);
        jedi.setBorder(new LineBorder(Color.black));
        jedi.setSelectionBackground(Color.pink);

        noOrderJediModel = new DefaultListModel<String>();
        noOrderJedi = new JList<String>(noOrderJediModel);
        noOrderJedi.setBounds(130,380,220, 130);
        noOrderJedi.setBorder(new LineBorder(Color.black));
        noOrderJedi.setSelectionBackground(Color.pink);
        add(noOrderJedi);

//        SQL.downloadDataJedi();
//        arrayToModel(jediModel,Jedi.jediArrayList);
//
//        for(Jedi j: Jedi.jediArrayList)
//            if(j.getJediOrders()==null) {
//                noOrderJediArray.add(j);
//                noOrderJediModel.removeAllElements();
//                arrayToModel(noOrderJediModel,noOrderJediArray);
//            }


        JLabel ordersRegistrationLabel = new JLabel("Jedi orders registration");
        ordersRegistrationLabel.setFont(font);
        ordersRegistrationLabel.setBounds(90,300,200,30);
        add(ordersRegistrationLabel);

        JLabel jediRegistrationLabel = new JLabel("Jedi registration");
        jediRegistrationLabel.setFont(font);
        jediRegistrationLabel.setBounds(540,300,200,30);
        add(jediRegistrationLabel);

        JLabel orderName = new JLabel("Name:");
        orderName.setFont(font1);
        orderName.setBounds(30,340, 50, 20);
        add(orderName);

        JLabel jediName = new JLabel("Name:");
        jediName.setFont(font1);
        jediName.setBounds(430,340, 50, 20);
        add(jediName);

        orderNameField = new JTextField();
        orderNameField.setBounds(90,340, 130, 25);
        add(orderNameField);

        JLabel orderSymbolLabel = new JLabel("Symbol: ");
        orderSymbolLabel.setFont(font1);
        orderSymbolLabel.setBounds(230, 340,65,20);
        add(orderSymbolLabel);

        orderSymbolField = new JTextField();
        orderSymbolField.setBounds(290, 340,100,25);
        add(orderSymbolField);


        JTextField jediNameField = new JTextField();
        jediNameField.setBounds(530,340, 220, 25);
        add(jediNameField);

        choose = new JButton("Choose");
        choose.setFont(font2);
        choose.setBounds(30, 370,80,25);
        add(choose);
        choose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Jedi jedi = noOrderJediArray.get(noOrderJedi.getSelectedIndex());
                joinOrder(jedi,JediOrders.jediOrdersArrayList.get(jediOrders.getSelectedIndex()));
                addJediOrdertoJedi(jedi.getName(),JediOrders.jediOrdersArrayList.get(jediOrders.getSelectedIndex()).getName());
                noOrderJediArray.remove(noOrderJedi.getSelectedIndex());
                noOrderJediModel.removeAllElements();
                arrayToModel(noOrderJediModel, noOrderJediArray);
            }
        });

        fileWay = new JTextField();
        fileWay.setEditable(false);
        fileWay.setBounds(130,520,220,25);
        fileWay.setFont(font3);
        add(fileWay);


        importOrder = new JButton("Import");
        importOrder.setFont(font2);
        importOrder.setBounds(30,500,80,25);
        add(importOrder);
        importOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JFileChooser chooseFile = new JFileChooser();
                    int i = chooseFile.showOpenDialog(null);
                    if (i==JFileChooser.APPROVE_OPTION) {
                        File f = chooseFile.getSelectedFile();
                        String filePath = f.getPath();
                        fileWay.setText(filePath);
                        importJediOrders(filePath);
                        jediOrdersModel.removeAllElements();
                        arrayToModelOrders(jediOrdersModel, JediOrders.jediOrdersArrayList);
                    }
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });

        exportOrder = new JButton("Export");
        exportOrder.setFont(font2);
        exportOrder.setBounds(30,545,80,25);
        add(exportOrder);
        exportOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<JediOrders> jediOrdersfromSQL = new ArrayList<JediOrders>();
                try {
                    JFileChooser chooseFile = new JFileChooser();
                    int i = chooseFile.showOpenDialog(null);
                    if (i==JFileChooser.APPROVE_OPTION) {
                        File f = chooseFile.getSelectedFile();
                        String filePath = f.getPath();
                        fileWay.setText(filePath);
                        exportJediOrders(SQL.downloadDataJediOrders(),filePath);
                    }
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });


        registrationLeft = new JButton("Register");
        registrationLeft.setFont(font2);
        registrationLeft.setBounds(140,600,100,25);
        add(registrationLeft);
        registrationLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JediOrders jediOrders = new JediOrders(orderNameField.getText(),orderSymbolField.getText());
                registerJediOrder(jediOrders);
                JediOrders.jediOrdersArrayList.add(jediOrders);
                jediOrdersModel.removeAllElements();
                arrayToModelOrders(jediOrdersModel, JediOrders.jediOrdersArrayList);
            }
        });


        clearLeft = new JButton("Clear");
        clearLeft.setFont(font2);
        clearLeft.setBounds(250,600,100,25);
        add(clearLeft);
        clearLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                orderNameField.setText("");
                orderSymbolField.setText("");
            }
        });

        JLabel swordColorLabel = new JLabel("Sword color: ");
        swordColorLabel.setBounds(430,380,100,25);
        swordColorLabel.setFont(font1);
        add(swordColorLabel);

        String[] items = {
                "Green",
                "Black",
                "Red",
                "Yellow",
                "Pink"
        };

        swordColor = new JComboBox(items);
        swordColor.setBounds(530,380, 220, 25);
        add (swordColor);

        JLabel powerLabel = new JLabel("Power: ");
        powerLabel.setFont(font1);
        powerLabel.setBounds(430,425,100,25);
        add(powerLabel);

        power = new JSlider();
        power.setBounds(530,425, 220, 40);
        power.setMinimum(0);
        power.setMaximum(100);
        power.setMajorTickSpacing(100);
        power.setMinorTickSpacing(10);
        power.setPaintTicks(true);
        power.setPaintLabels(true);
        add(power);

        JLabel powerSide = new JLabel("Power side: ");
        powerSide.setFont(font1);
        powerSide.setBounds(530,480,90, 25);
        add(powerSide);

        sidePowerDark = new JRadioButton("dark");
        sidePowerDark.setBounds(630,480,60, 25);
        add(sidePowerDark);

        sidePowerLight = new JRadioButton("light");
        sidePowerLight.setBounds(700,480,60, 25);
        add(sidePowerLight);

        fileWay1 = new JTextField();
        fileWay1.setEditable(false);
        fileWay1.setBounds(530,520,220,25);
        add(fileWay1);
        fileWay1.setFont(font3);


        importJedi = new JButton("Import");
        importJedi.setFont(font2);
        importJedi.setBounds(430,500,80,25);
        add(importJedi);
        importJedi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JFileChooser chooseFile = new JFileChooser();
                    int i = chooseFile.showOpenDialog(null);
                    if (i==JFileChooser.APPROVE_OPTION) {
                        File f = chooseFile.getSelectedFile();
                        String filePath = f.getPath();
                        fileWay1.setText(filePath);
                        importJedi(filePath);
                        jediModel.removeAllElements();
                        arrayToModel(jediModel,Jedi.jediArrayList);
                    }

                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });

        exportJedi = new JButton("Export");
        exportJedi.setFont(font2);
        exportJedi.setBounds(430,545,80,25);
        add(exportJedi);
        exportJedi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Jedi> jedifromSQL = new ArrayList<Jedi>();
                try {
                    JFileChooser chooseFile = new JFileChooser();
                    int i = chooseFile.showOpenDialog(null);
                    if (i==JFileChooser.APPROVE_OPTION) {
                        File f = chooseFile.getSelectedFile();
                        String filePath = f.getPath();
                        fileWay1.setText(filePath);
                        exportJedi(SQL.downloadDataJedi(),filePath);
                    }
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });



        registrationRight = new JButton("Register");
        registrationRight.setFont(font2);
        registrationRight.setBounds(540,600,100,25);
        add(registrationRight);
        registrationRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Jedi jedi;
                if (sidePowerDark.isSelected())
                    jedi = new Jedi(jediNameField.getText(),swordColor.getSelectedItem().toString(),power.getValue(),"dark side");
                else
                    jedi = new Jedi(jediNameField.getText(),swordColor.getSelectedItem().toString(),power.getValue(),"light side");
                registerJedi(jedi);
                Jedi.jediArrayList.add(jedi);
                noOrderJediArray.add(jedi);
                jediModel.removeAllElements();
                noOrderJediModel.removeAllElements();
                arrayToModel(jediModel,Jedi.jediArrayList);
                arrayToModel(noOrderJediModel, noOrderJediArray);
            }
        });

        clearRight = new JButton("Clear");
        clearRight.setFont(font2);
        clearRight.setBounds(650,600,100,25);
        add(clearRight);
        clearRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jediNameField.setText("");
                sidePowerDark.setSelected(false);
                sidePowerLight.setSelected(false);
                power.setValue(50);
            }
        });

    }

    static void arrayToModel (DefaultListModel<String> listModel, ArrayList<Jedi> jediList) {
        for (int i=0; i<jediList.size(); i++)
            listModel.addElement((i+1)+ ". " + jediList.get(i).toString());
    }

    static void arrayToModelOrders (DefaultListModel<String> listModel, ArrayList<JediOrders> jediList) {
        for (int i=0; i<jediList.size(); i++)
            listModel.addElement(i+1+ ". " + jediList.get(i).toString());
    }

    static void joinOrder (Jedi jedi, JediOrders jediOrder) {
        jedi.setJediOrders(jediOrder);
        jediOrder.getJedis().add(jedi);
    }

    void registerJedi (Jedi jedi)  {
        SQL.polacz();
        try {
            SQL.getStatement().executeUpdate("INSERT INTO JEDI (IdJedi, Name, SwordColor, Power, PowerSide) VALUES (" + (Jedi.jediArrayList.size()+1) + ", '" + jedi.getName() + "', '" + jedi.getSwordColor() + "', " + jedi.getPower() + ", '" + jedi.getPowerSide() + "');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void registerJediOrder (JediOrders jediOrders) {
        SQL.polacz();
        try {
            SQL.getStatement().executeUpdate("INSERT INTO JEDIORDER VALUES (" + (JediOrders.jediOrdersArrayList.size()+1) + ", '" + jediOrders.getName() + "', '" + jediOrders.getSymbol() + "');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void addJediOrdertoJedi(String jedi, String jediorder) {
        SQL.polacz();
        try {
            SQL.getStatement().executeUpdate("UPDATE JEDI SET JEDIORDER = '" + jediorder + "' WHERE Jedi.name = '" + jedi + "';");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SQL.rozlacz();
    }

    void exportJedi (ArrayList<Jedi> jediFromSQL, String pathname) throws FileNotFoundException {
        jediFromSQL = SQL.downloadDataJedi();
        File file = new File(pathname);

        PrintWriter pw = new PrintWriter(file);
        for (Jedi j: jediFromSQL)
            pw.println(dataCodeExport(j.toString2()));

        pw.close();
    }

    void exportJediOrders (ArrayList<JediOrders> jediOrdersFromSQL, String pathname) throws FileNotFoundException {
        jediOrdersFromSQL = SQL.downloadDataJediOrders();
        ArrayList<Jedi> jediInOrder = new ArrayList<>();

        File file = new File(pathname);

        PrintWriter pw = new PrintWriter(file);
        for (JediOrders j: jediOrdersFromSQL) {
            jediInOrder = SQL.downloadJediInOrders(j);
            pw.print((dataCodeExport(j.toString1() + "/")));
            for (Jedi o:jediInOrder) {
                j.getJedis().add(o);
                pw.print(dataCodeExport(o.toString1()));
            }
            pw.println();
        }


        pw.close();
    }

    static void importJedi (String pathname) throws FileNotFoundException {
        ArrayList<String> dane = new ArrayList<>();
        File file = new File(pathname);
        Scanner sc = new Scanner(file);
        String [] table = new String[4];

        while(sc.hasNextLine())
            dane.add(dataCodeImport(sc.nextLine()));
        sc.close();

        for (String s:dane) {
            table = s.split(" ");
            Jedi.jediArrayList.add(new Jedi(table[0],table[1], Integer.parseInt(table[2]), table[3]));
        }

    }

    static void importJediOrders (String pathname) throws FileNotFoundException {
        ArrayList<String> dane = new ArrayList<>();
        File file = new File(pathname);
        Scanner sc = new Scanner(file);
        String [] table = new String[3];
        String allJedisinOrder;
        String[] table2;


        while(sc.hasNextLine())
            dane.add(dataCodeImport(sc.nextLine()));
        sc.close();


        for (String s:dane) {
            table = s.split("/");
            JediOrders nowy = new JediOrders(table[0],table[1]);
            JediOrders.jediOrdersArrayList.add(nowy);
            allJedisinOrder = table[2];
            table2 = jedisInTable(allJedisinOrder);
            konkretnyJediinOrder(table2,nowy);
        }
    }
    static int iloscwystapien (String s) {
        int licznik = 0;
        for (char znak : s.toCharArray()) {
            if (znak == ';') {
                licznik++;
            }
        }
        return licznik;
    }

    static String dataCodeExport (String info) {
        String infonew = "";

        for (int i=0; i<info.length(); i++)
            infonew = infonew + (char)(info.codePointAt(i) +1);

        return infonew;
    }

    static String dataCodeImport (String info) {
        String infonew = "";

        for (int i=0; i<info.length(); i++)
            infonew = infonew + (char)(info.codePointAt(i) -1);

        return infonew;
    }
    static String [] jedisInTable (String s) {
        String [] table = new String[iloscwystapien(s)];
        table = s.split(";");

        return table;
    }

    static void konkretnyJediinOrder (String [] jedis, JediOrders jediOrders ) {
        String[] jedi = new String[4];
        for (String s: jedis) {
            jedi = s.split(",");
            jediOrders.getJedis().add((new Jedi(jedi[0],jedi[1], Integer.parseInt(jedi[2]), jedi[3])));
        }
    }



    static void getExistedData (ArrayList<Jedi> jedi, ArrayList<JediOrders> jediOrders, DefaultListModel<String> jediModel, DefaultListModel<String> jediOrderModel) {
        SQL.polacz();
        jedi = SQL.downloadDataJedi();
        jediOrders = SQL.downloadDataJediOrders();
        arrayToModelOrders(jediOrderModel,jediOrders);
        arrayToModel(jediModel, jedi);

    }

    static void getExistedJedisInOrder () {
        for (JediOrders jediOrders: JediOrders.jediOrdersArrayList)
            jediOrders.setJedis(SQL.downloadJediInOrders(jediOrders));
    }


}
