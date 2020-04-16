package cschool.projekt.jedi;

import java.util.ArrayList;

public class Jedi {
    private String name;
    private String swordColor;
    private int power;
    private String powerSide;
    private JediOrders jediOrders;
    static ArrayList<Jedi> jediArrayList = SQL.downloadDataJedi();

    public Jedi(String name, String swordColor, int power, String powerSide) {
        this.name = name;
        this.swordColor = swordColor;
        this.power = power;
        this.powerSide = powerSide;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSwordColor() {
        return swordColor;
    }

    public void setSwordColor(String swordColor) {
        this.swordColor = swordColor;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getPowerSide() {
        return powerSide;
    }

    public void setPowerSide(String powerSide) {
        this.powerSide = powerSide;
    }

    public JediOrders getJediOrders() {
        return jediOrders;
    }

    public void setJediOrders(JediOrders jediOrders) {
        this.jediOrders = jediOrders;
    }

    @Override
    public String toString() {
        return name + ", " + powerSide + ", power: " + power + ", " + swordColor + " sword.";
    }

    public String toString1() {
        return name + "," + swordColor + "," + power + "," + powerSide + ";";
    }

    public String toString2() {
        return name + " " + swordColor + " " + power + " " + powerSide;
    }

//        public static void importNewJedi (Jedi jedi) {
//        SQL.polacz();
//        ArrayList<String> jediArrayList = downloadDataJedi();
//        try {
//            SQL.getStatement().executeUpdate("INSERT INTO JEDI (IdJedi, Name, SwordColor, Power, PowerSide) VALUES (" + (jediArrayList.size()+1) + ", '" + jedi.getName() + "', '" + jedi.getSwordColor() + "', " + jedi.getPower() + ", '" + jedi.getPowerSide() + "');");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
}
