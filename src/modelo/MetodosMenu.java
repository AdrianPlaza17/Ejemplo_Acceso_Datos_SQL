package modelo;

import java.io.IOException;

public class MetodosMenu {

    public static void menu() {
        System.out.println("MENU");
        System.out.println("====");

        System.out.println("1. Cual es el pedido medio de cada vendedor.");
        System.out.println("2. Cual es el rango de cuotas asignadas en cada oficina.");
        System.out.println("3. Cuantos vendedores estan asignados a cada oficina.");
        System.out.println("4. Cuantos clientes diferentes son atendidos por cada vendedor.");
        System.out.println("5. Calcular los pedidos totales por cada cliente y por cada vendedor, ordenados por cliente y dentro de cada cliente por vendedor.");
        System.out.println("6. Calcular los pedidos totales para cada vendedor.");
        System.out.println("7. Cual es el tamano de pedido promedio para cada vendedor cuyo pedidos totalizan mas de 30000.");
        System.out.println("8. Por cada oficina con dos o mas personas, calcular la cuota total y las ventas totales para todos los vendedores que trabajan en la oficina.");
        System.out.println("9. Mostrar el precio, las existencias y la cantidad total de los pedidos de cada producto para los cuales la cantidad total pedida es superior al 75 por 100 de las existencias.");
        System.out.println("10. Lista los vendedores que trabajan en diferentes  oficinas que sus vendedores jefes mostrando el nombre y la oficina en donde trabaja cada uno.");
        System.out.println("11. Diseñar un procedure que tendrá un parametro de entrada el idVendedor y el procedure responde con un parametro de salida cual es el nombre de su vendedor jefe.");
        System.out.println("12. Diseñar un procedure que tendrá como parametro de entrada el nombre vendedor y el procedure retorna en un parametro de salida cuantos clientes distintos fueron atendidos por dicho vendedor.");
        System.out.println("13. Diseñar un procedure que reciba un parametro de entrada el idFabrica y el idProducto y retorne en un parametro de salida su precio.");
        System.out.println("14. Diseñar un procedure que reciba un parametro de entrada el idCliente y retorne en un parametro de salida cuantos pedidos ha realizado dicho cliente.");
        System.out.println("15. Diseñar un procedure que implemente la pregunta 10 de consultas.");

        System.out.print("\nSalir 0\n\n");
        System.out.print("Introduzca su opción: ");
    }

    public static void cls() {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public static void pause() {
        try {

            System.out.print("\nPresiona una tecla para continuar...");
            System.in.read();
        } catch (IOException e) {

        }
    }

}
