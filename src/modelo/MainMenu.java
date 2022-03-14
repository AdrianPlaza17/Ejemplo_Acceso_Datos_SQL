package modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) throws SQLException {

        ConexionMariadb cm = new ConexionMariadb(true);
        Connection conexion = cm.getConexion();

        if (conexion != null) {
            System.out.println("OK: CONEXIÓN CON LA BASE DE DATOS");

        } else {
            System.out.println("ERROR: CONEXIÓN CON LA BASE DE DATOS");
        }
        try {

            Scanner sc = new Scanner(System.in);
            String s;
            String sPatron = "[0-15]+";
            int opcion;

            do {
                do {

                    MetodosMenu.menu();
                    s = sc.next();

                } while ((s.matches(sPatron) && Integer.parseInt(s) < 0 && Integer.parseInt(s) <= 15));

                opcion = Integer.parseInt(s);

                switch (opcion) {

                    case 0:

                        MetodosMenu.cls();
                        System.exit(0);
                        break;

                    case 1:

                        MetodosMenu.cls();
                        OperacionesCrud.pregunta1(conexion);
                        MetodosMenu.pause();
                        MetodosMenu.cls();

                        break;

                    case 2:

                        MetodosMenu.cls();
                        OperacionesCrud.pregunta2(conexion);
                        MetodosMenu.pause();
                        MetodosMenu.cls();

                        break;

                    case 3:

                        MetodosMenu.cls();
                        OperacionesCrud.pregunta3(conexion);
                        MetodosMenu.pause();
                        MetodosMenu.cls();

                        break;
                    case 4:

                        MetodosMenu.cls();
                        OperacionesCrud.pregunta4(conexion);
                        MetodosMenu.pause();
                        MetodosMenu.cls();

                        break;

                    case 5:

                        MetodosMenu.cls();
                        OperacionesCrud.pregunta5(conexion);
                        MetodosMenu.pause();
                        MetodosMenu.cls();
                        break;

                    case 6:

                        MetodosMenu.cls();
                        OperacionesCrud.pregunta6(conexion);
                        MetodosMenu.pause();
                        MetodosMenu.cls();

                        break;
                    case 7:

                        MetodosMenu.cls();
                        OperacionesCrud.pregunta7(conexion);
                        MetodosMenu.pause();
                        MetodosMenu.cls();

                        break;

                    case 8:

                        MetodosMenu.cls();
                        OperacionesCrud.pregunta8(conexion);
                        MetodosMenu.pause();
                        MetodosMenu.cls();

                        break;

                    case 9:

                        MetodosMenu.cls();
                        OperacionesCrud.pregunta9(conexion);
                        MetodosMenu.pause();
                        MetodosMenu.cls();

                        break;

                    case 10:

                        MetodosMenu.cls();
                        OperacionesCrud.pregunta10(conexion);
                        MetodosMenu.pause();
                        MetodosMenu.cls();

                        break;
                    case 11:

                        MetodosMenu.cls();
                        OperacionesCrud.pregunta11(conexion);
                        MetodosMenu.pause();
                        MetodosMenu.cls();

                        break;

                    case 12:

                        MetodosMenu.cls();
                        OperacionesCrud.pregunta12(conexion);
                        MetodosMenu.pause();
                        MetodosMenu.cls();

                        break;
                    case 13:

                        MetodosMenu.cls();
                        OperacionesCrud.pregunta13(conexion);
                        MetodosMenu.pause();
                        MetodosMenu.cls();

                        break;
                    case 14:

                        MetodosMenu.cls();
                        OperacionesCrud.pregunta14(conexion);
                        MetodosMenu.pause();
                        MetodosMenu.cls();
                        MetodosMenu.cls();

                        break;
                    case 15:

                        MetodosMenu.cls();
                        OperacionesCrud.pregunta15(conexion);
                        MetodosMenu.pause();
                        MetodosMenu.cls();

                        break;

                    default:

                        System.out.println("Por favor, introduce un numero del 1 al 15 (el 0 es para salir).");
                        MetodosMenu.pause();

                        break;

                }

            } while (true);

        } catch (NumberFormatException e) {

            System.out.println("Por favor, introduce un numero del 1 al 15 (el 0 es para salir).");
            MetodosMenu.pause();
            MainMenu.main(args);

        }

    }

}
