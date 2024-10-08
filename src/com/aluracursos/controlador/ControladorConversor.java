package com.aluracursos.controlador;

import com.aluracursos.modelo.Conversor;
import java.util.Scanner;

public class ControladorConversor {
    private final Conversor conversor;
    private final Scanner scanner;

    public ControladorConversor() {
        conversor = new Conversor();
        scanner = new Scanner(System.in);
    }

    //metodo para mostrar el menu
    public void mostrarMenu() {
        while (true) {
            System.out.println("*********************************************************************");
            System.out.println("Bienvenidos al Conversor de monedas de Alura Latam - CR-Best");
            System.out.println("*********************************************************************");
            System.out.println("1) Dólar ==> Peso colombiano");
            System.out.println("2) Peso colombiano ==> Dólar");
            System.out.println("3) Dólar ==> Peso Mexicano");
            System.out.println("4) Peso Mexicano ==> Dólar");
            System.out.println("5) Dólar ==> Euro");
            System.out.println("6) Euro ==> Dólar");
            System.out.println("7) Salir");
            System.out.print("Selecciona una opción: ");

            int opcion = scanner.nextInt();
            if (opcion == 7) {
                System.out.println("Saliendo de la aplicacion...");
                break; //salir del bucle
            }

            System.out.print("Ingresa la cantidad a convertir: ");
            double cantidad = scanner.nextDouble();
            try {
                switch (opcion) {
                    case 1:
                        double resultadoCOP = conversor.convertir("USD", "COP", cantidad);
                        System.out.printf("El valor de %.2f [USD] corresponde a ==> %.2f [COP].\n\n", cantidad, resultadoCOP);
                        break;
                    case 2:
                        double resultadoUSD1 = conversor.convertir("COP", "USD", cantidad);
                        System.out.printf("El valor de %.2f [COP] corresponde a ==> %.2f [USD].\n\n", cantidad, resultadoUSD1);
                        break;
                    case 3:
                        double resultadoMXN = conversor.convertir("USD", "MXN", cantidad);
                        System.out.printf("El valor de %.2f [USD] corresponde a ==> %.2f [MXN].\n\n", cantidad, resultadoMXN);
                        break;
                    case 4:
                        double resultadoUSD2 = conversor.convertir("MXN", "USD", cantidad);
                        System.out.printf("El valor de %.2f [MXN] corresponde a ==> %.2f [USD].\n\n", cantidad, resultadoUSD2);
                        break;
                    case 5:
                        double resultadoEUR = conversor.convertir("USD", "EUR", cantidad);
                        System.out.printf("El valor de %.2f [USD] corresponde a ==> %.2f [EUR].\n\n", cantidad, resultadoEUR);
                        break;
                    case 6:
                        double resultadoUSD3 = conversor.convertir("EUR", "USD", cantidad);
                        System.out.printf("El valor de %.2f [EUR] corresponde a ==> %.2f [USD].\n\n", cantidad, resultadoUSD3);
                        break;
                    default:
                        System.out.println("Opción no válida. Intenta de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
