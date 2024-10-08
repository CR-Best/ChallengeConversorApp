package com.aluracursos.controlador;

import com.aluracursos.modelo.Conversor;

public class ControladorConversor {
    private final Conversor conversor;
    private final Scanner scanner;

    public ControladorConversor() {
        conversor = new Conversor();
        scanner = new Scanner(System.in);
    }

    // Método para mostrar el menú
    public void mostrarMenu() {
        while (true) {
            System.out.println("*********************************************************************");
            System.out.println("Bienvenidos al Conversor de monedas de Carlos Rosales");
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
                System.out.println("Saliendo...");
                break; // Salir del bucle
            }

            System.out.print("Ingresa la cantidad a convertir: ");
            double cantidad = scanner.nextDouble();
            try {
                switch (opcion) {
                    case 1:
                        System.out.println("Resultado: " + conversor.convertir("USD", "COP", cantidad) + "\n");
                        break;
                    case 2:
                        System.out.println("Resultado: " + conversor.convertir("COP", "USD", cantidad) + "\n");
                        break;
                    case 3:
                        System.out.println("Resultado: " + conversor.convertir("USD", "MXN", cantidad) + "\n");
                        break;
                    case 4:
                        System.out.println("Resultado: " + conversor.convertir("MXN", "USD", cantidad) + "\n");
                        break;
                    case 5:
                        System.out.println("Resultado: " + conversor.convertir("USD", "EUR", cantidad) + "\n");
                        break;
                    case 6:
                        System.out.println("Resultado: " + conversor.convertir("EUR", "USD" , cantidad) + "\n");
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

