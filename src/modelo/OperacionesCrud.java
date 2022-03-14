package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Scanner;

public class OperacionesCrud {

    public static boolean pregunta1(Connection conexion) {
        boolean bandera = true;
        try {
            Statement sql = conexion.createStatement();
            String query = "SELECT idVendedor, AVG(importe) AS mediaImporte FROM `pedido` GROUP BY idVendedor ";
            ResultSet rs = sql.executeQuery(query);
            System.out.printf("%-12s %-10s\n", "idVendedor", "mediaImporte");
            while (rs.next()) {

                System.out.printf("%-12s %-10s\n", rs.getString(1), rs.getString(2));
            }
        } catch (SQLException e) {
            bandera = false;
        }
        return bandera;
    }

    public static boolean pregunta2(Connection conexion) {
        boolean bandera = true;
        try {
            Statement sql = conexion.createStatement();
            String query = "SELECT idOficina, MIN(CUOTA), max(cuota) FROM `vendedor` GROUP BY IDOficina";
            ResultSet rs = sql.executeQuery(query);
            System.out.printf("%-12s %-10s %-10s\n", "idOficina", "minCuota", "maxCuota");
            while (rs.next()) {
                System.out.printf("%-12s %-10s %-10s\n", rs.getString(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException e) {
            bandera = false;
        }
        return bandera;
    }

    public static boolean pregunta3(Connection conexion) {
        boolean bandera = true;
        try {
            Statement sql = conexion.createStatement();
            String query = "SELECT idOficina, COUNT(idVendedor) FROM `vendedor` GROUP BY IdOficina";
            ResultSet rs = sql.executeQuery(query);
            System.out.printf("%-12s %-10s\n", "idOficina", "totalVendedores");
            while (rs.next()) {
                System.out.printf("%-12s %-10s\n", rs.getString(1), rs.getString(2));
            }
        } catch (SQLException e) {
            bandera = false;
        }
        return bandera;
    }

    public static boolean pregunta4(Connection conexion) {
        boolean bandera = true;
        try {
            Statement sql = conexion.createStatement();
            String query = "SELECT idVendedor, COUNT(DISTINCT(idCliente)) FROM `pedido` GROUP BY idVendedor";
            ResultSet rs = sql.executeQuery(query);
            System.out.printf("%-12s %-10s\n", "idVendedor", "Clientes por representante de ventas");
            while (rs.next()) {
                System.out.printf("%-12s %-10s\n", rs.getString(1), rs.getString(2));
            }
        } catch (SQLException e) {
            bandera = false;
        }
        return bandera;
    }

    public static boolean pregunta5(Connection conexion) {
        boolean bandera = true;
        try {
            Statement sql = conexion.createStatement();
            String query = "SELECT idCliente, idVendedor, SUM(importe) FROM `pedido` GROUP BY idVendedor, idCliente ORDER BY `pedido`.`idCliente`";
            ResultSet rs = sql.executeQuery(query);
            System.out.printf("%-12s %-10s %-10s\n", "idCliente", "idVendedor", "importeTotal");
            while (rs.next()) {
                System.out.printf("%-12s %-10s %-10s\n", rs.getString(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException e) {
            bandera = false;
        }
        return bandera;
    }

    public static boolean pregunta6(Connection conexion) {
        boolean bandera = true;
        try {
            Statement sql = conexion.createStatement();

            String query = "SELECT pedido.idVendedor, nombre, SUM(importe) as TOTAL FROM `pedido` INNER JOIN vendedor on pedido.idVendedor = vendedor.idVendedor GROUP BY idVendedor;";
            ResultSet rs = sql.executeQuery(query);
            System.out.printf("%-12s %-10s %15s\n", "idVendedor", "nombre", "importeTotal");
            while (rs.next()) {
                System.out.printf("%-12s %-10s %15s\n", rs.getString(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException e) {
            bandera = false;
        }
        return bandera;
    }

    public static boolean pregunta7(Connection conexion) {
        boolean bandera = true;
        try {
            Statement sql = conexion.createStatement();
            String query = "SELECT idVendedor, AVG(importe) as MEDIA FROM `pedido`  GROUP BY idVendedor having SUM(importe) > 30000;";
            ResultSet rs = sql.executeQuery(query);
            System.out.printf("%-12s %-10s\n", "idVendedor", "mediaImporte");
            while (rs.next()) {
                System.out.printf("%-12s %-10s\n", rs.getString(1), rs.getString(2));
            }
        } catch (SQLException e) {
            bandera = false;
        }
        return bandera;
    }

    public static boolean pregunta8(Connection conexion) {
        boolean bandera = true;
        try {

            Statement sql = conexion.createStatement();
            String query = "select ciudad, vendedor.idOficina, SUM(cuota) AS totalCuota, SUM(vendedor.VENTAS) as totalVentas FROM vendedor INNER JOIN oficina ON oficina.idOficina= vendedor.idOficina GROUP BY idOficina HAVING COUNT(vendedor.idOficina) > 1 ORDER BY totalCuota desc";
            ResultSet rs = sql.executeQuery(query);
            System.out.printf("%-12s %-10s %-10s %-10s\n", "ciudad", "idOficina", "cuotaTotal", "ventasTotal");
            while (rs.next()) {
                System.out.printf("%-12s %-10s %-10s %-10s\n", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
        } catch (SQLException e) {
            bandera = false;
        }
        return bandera;
    }

    public static boolean pregunta9(Connection conexion) {
        boolean bandera = true;
        try {
            Statement sql = conexion.createStatement();
            String query = "SELECT prod.descripcion, ped.idPedido, prod.idProducto, prod.idFabrica, prod.precio, prod.existencia, ped.cantidad,SUM(cantidad) as cantidadTotal FROM pedido as ped inner join producto as prod on ped.idProducto=prod.idProducto AND ped.idFabrica = prod.idFabrica GROUP by ped.idProducto, prod.idFabrica having cantidadTotal > prod.existencia *0.75";
            ResultSet rs = sql.executeQuery(query);
            System.out.printf("%-20s %-10s %-10s %-10s %-10s %-10s %-10s\n", "descripción", "idPedido", "idProducto", "idFabrica", "precio", "existencia", "cantidadTotal");
            while (rs.next()) {
                System.out.printf("%-20s %-10s %-10s %-10s %-10s %-10s %-10s\n", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
            }
        } catch (SQLException e) {
            bandera = false;
        }
        return bandera;
    }

    public static boolean pregunta10(Connection conexion) {
        boolean bandera = true;
        try {
            Statement sql = conexion.createStatement();
            String query = "select a.idVendedor, a.nombre, a.idOficina, d.ciudad, b.idVendedor, b.nombre, b.idOficina, c.ciudad FROM vendedor as a inner join oficina as d on a.idOficina = d.idOficina INNER JOIN vendedor as b on a.idVendedorJefe = b.idVendedor inner join oficina as c on b.idOficina = c.idOficina WHERE a.idOficina != b.idOficina;";
            ResultSet rs = sql.executeQuery(query);
            System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", "idVendedor", "nombre", "idOficina", "ciudadEmpleado", "idVendedorJefe", "nombreJefe", "idOficinaJefe", "ciudadJefe");
            while (rs.next()) {
                System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
            }
        } catch (SQLException e) {
            bandera = false;
        }
        return bandera;
    }

    public static boolean pregunta11(Connection conexion) {

        boolean bandera = true;
        try {

            System.out.println("Introduzca el id del vendedor:");

            Scanner s = new Scanner(System.in);
            String scCodigo = s.nextLine();

            CallableStatement sp = conexion.prepareCall("CALL obtener_nombre_jefe(?,?)");
            sp.setString("idVendedorI", scCodigo);
            sp.registerOutParameter("nombreJefeO", Types.VARCHAR);
            sp.execute();
            String resultado = sp.getString("nombreJefeO");
            System.out.println("Nombre del vendedor jefe: " + resultado);

        } catch (SQLException e) {
            bandera = false;
        }
        return bandera;
    }

    public static boolean pregunta12(Connection conexion) {
        System.out.println("Introduzca el nombre del vendedor:");

        Scanner s = new Scanner(System.in);
        String scNombre = s.nextLine();

        boolean bandera = true;
        try {

            CallableStatement sp = conexion.prepareCall("CALL obtener_cantidad_clientes(?,?)");
            sp.setString("nombreVendedorI", scNombre);
            sp.registerOutParameter("cantidadClientes", Types.INTEGER);
            sp.execute();
            int resultado = sp.getInt("cantidadClientes");
            System.out.println("Cantidad de clientes distintos atendidos por el vendedor: " + resultado);

        } catch (SQLException e) {
            bandera = false;
        }
        return bandera;
    }

    public static boolean pregunta13(Connection conexion) {
        Scanner s = new Scanner(System.in);

        System.out.println("Introduzca el id de la fábrica:");
        String scFabrica = s.nextLine();

        System.out.println("Introduzca el id del producto:");
        String scProducto = s.nextLine();

        boolean bandera = true;
        try {

            CallableStatement sp = conexion.prepareCall("CALL obtener_precio_producto(?,?,?)");
            sp.setString("idFabricaIn", scFabrica);
            sp.setString("idProductoIn", scProducto);
            sp.registerOutParameter("precioOut", Types.DOUBLE);
            sp.execute();
            double resultado = sp.getDouble("precioOut");
            System.out.println("Precio del producto: " + resultado);

        } catch (SQLException e) {
            bandera = false;
        }
        return bandera;
    }

    public static boolean pregunta14(Connection conexion) {

        Scanner s = new Scanner(System.in);

        System.out.println("Introduzca el id del cliente:");
        String scCliente = s.nextLine();

        boolean bandera = true;
        try {

            CallableStatement sp = conexion.prepareCall("CALL obtener_cantidad_pedidos_cliente(?,?)");
            sp.setString("idClienteI", scCliente);

            sp.registerOutParameter("cantidad", Types.INTEGER);
            sp.execute();
            int resultado = sp.getInt("cantidad");
            System.out.println("Cantidad de pedidos del cliente: " + resultado);

        } catch (SQLException e) {
            bandera = false;
        }
        return bandera;
    }

    public static boolean pregunta15(Connection conexion) {
        boolean bandera = true;
        try {

            CallableStatement cs = conexion.prepareCall("CALL vendedor_jefe_distinta_oficina()");

            ResultSet rs = cs.executeQuery();
            System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", "idVendedor", "nombre", "idOficina", "ciudadEmpleado", "idVendedorJefe", "nombreJefe", "idOficinaJefe", "ciudadJefe");

            while (rs.next()) {

                System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
            }

        } catch (SQLException e) {
            bandera = false;
        }
        return bandera;
    }

}
