package cschool.projekt.jedi;

import java.util.ArrayList;

public class JediOrders {
    private String name;
    private String symbol;
    static ArrayList <JediOrders> jediOrdersArrayList = SQL.downloadDataJediOrders();
    private ArrayList<Jedi> jedis = new ArrayList<>();

    public static ArrayList<JediOrders> getJediOrdersArrayList() {
        return jediOrdersArrayList;
    }

    public static void setJediOrdersArrayList(ArrayList<JediOrders> jediOrdersArrayList) {
        JediOrders.jediOrdersArrayList = jediOrdersArrayList;
    }

    public ArrayList<Jedi> getJedis() {
        return jedis;
    }

    public void setJedis(ArrayList<Jedi> jedis) {
        this.jedis = jedis;
    }

    public JediOrders(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return name + ", symbol: " + symbol;
    }

    public String toString1() {
        return name + "/" + symbol;
    }
}
