package cschool.projekt.jedi;
import java.sql.*;
import java.util.ArrayList;

public class SQL {
    private static Connection connection;
    private static Statement statement;

    public static Connection getConnection() {
        return connection;
    }

    public static Statement getStatement() {
        return statement;
    }

    public static void polacz () {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/JediManagementSystem", "postgres", "*********");

            statement = connection.createStatement(); /// select - execute query; create, drop - execute; insertInto, delete, set - executeUpdated

        } catch (ClassNotFoundException | SQLException e ) {
            e.printStackTrace();
        }
    }


    public static void rozlacz() {
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    public static ArrayList<Jedi> downloadDataJedi ()  {
        polacz();
        ArrayList<Jedi> jediFromSQL = new ArrayList<Jedi>();

        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery("SELECT * FROM JEDI;");
            while (resultSet.next()) {
                jediFromSQL.add(new Jedi(resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getString(5)));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return jediFromSQL;

    }

    public static ArrayList<JediOrders> downloadDataJediOrders ()  {
        polacz();
        ArrayList<JediOrders> ordersFromSQL = new ArrayList<JediOrders>();

        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery("SELECT * FROM JEDIORDER;");
            while (resultSet.next()) {
                ordersFromSQL.add(new JediOrders(resultSet.getString(2), resultSet.getString(3)));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return ordersFromSQL;

    }

    static ArrayList<Jedi> downloadJediInOrders (JediOrders jediOrders) {
        polacz();
        ArrayList<Jedi> jediInordersFromSQL = new ArrayList<Jedi>();

        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery("SELECT jedi.name, jedi.swordcolor, jedi.power, jedi.powerside FROM JEDI, Jediorder WHERE jedi.jediorder = jediorder.nazwa and jediorder.nazwa = '" + jediOrders.getName() + "';");
            while (resultSet.next()) {
                jediInordersFromSQL.add(new Jedi(resultSet.getString(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getString(4)));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return jediInordersFromSQL;

    }




    }

