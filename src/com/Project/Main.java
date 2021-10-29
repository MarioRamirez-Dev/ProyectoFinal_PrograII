package com.Project;
import java.sql.*;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {


        Connection conexion = null;

        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver" ;
        String url = "jdbc:sqlserver://MARIORAMIREZ:1433;database=DB_GestionHotel;user= MarioR;password=123;loginTimeout = 30 ";


        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url);
            Statement sql  = conexion.createStatement();
            String query = "select*from DB_GestionHotel.dbo.tbl_huesped";
            ResultSet resultado = sql.executeQuery(query);

            if(!conexion.isClosed()){
                System.out.println("Datos extraidos de la tabla Huesped: ");
                System.out.println("ID|NOMBRES|APELLIDOS|TELEFONO|EDAD|DPI|EMAIL ");
                while(resultado.next()){
                    System.out.println(resultado.getInt(1)+ " " +resultado.getString(2) + " " +resultado.getString(3)+ " "+resultado.getInt(4)+
                                            " "+resultado.getInt(5)+" "+resultado.getInt(6)+" "+resultado.getString(7));
                }
            }

            conexion.close();
        }catch(ClassNotFoundException e){
            System.out.println("El controlador no esta presente");
        }catch (SQLException e){
            System.out.println("ERROR AL CONECTARSE A LA BASE DE DATOS");
            System.out.println(e.getMessage());
        }



        //Scanner opcMenu = new Scanner(System.in);

        //System.out.println("Bienvenido al sistema");
        //System.out.println("Ingrese en que tabla desea registrar datos: ");
        //System.out.println("1. Tabla Huesped");
        //System.out.println("2. Tabla empleados");
        //System.out.println("3. Tabla de Habitaciones");

        //int opcionMenu = opcMenu.nextInt();
        //menu(opcionMenu);



    }

    public static void menu(int opc){
        int opcion = opc;
        do {
            switch (opcion) {
                case 1:
                    opc = 4;
                    System.out.println("1");
                    break;
                case 2:
                    opc = 4;
                    System.out.println("2");
                    break;
                case 3:
                    opc = 4;
                    System.out.println("3");
                    break;
                default:
                    System.out.println("¡OPCION INCORRECTA!");
                    opc = 4;
            }
        }while(opc != 4);
    }
}
