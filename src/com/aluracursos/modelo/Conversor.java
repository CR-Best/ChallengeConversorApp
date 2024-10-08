package com.aluracursos.modelo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Conversor {
    private final String API_KEY = "43d0222c120dfad97edefcab";
    private final String URL_API = "https://api.exchangerate-api.com/v4/latest/";

    //metodo para obtener la tasa de cambio
    private double obtenerTasaCambio(String monedaDesde, String monedaHacia) throws Exception {
        String urlString = URL_API + monedaDesde;
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Authorization", "Bearer " + API_KEY); // Incluir API Key en la cabecera si es necesario

        //verificar la respuesta de la API
        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Error en la conexión: " + conn.getResponseCode());
        }

        //leer la respuesta de la API
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder respuesta = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            respuesta.append(inputLine);
        }
        in.close();

        //procesar el JSON y obtener la tasa de cambio
        String jsonResponse = respuesta.toString();
        String tasaCambioStr = jsonResponse.split("\"" + monedaHacia + "\":")[1].split(",")[0];
        return Double.parseDouble(tasaCambioStr);
    }

    //metodo para convertir una cantidad de moneda
    public double convertir(String monedaDesde, String monedaHacia, double cantidad) throws Exception {
        double tasaCambio = obtenerTasaCambio(monedaDesde, monedaHacia);
        return cantidad * tasaCambio; //convertir la cantidad
    }
}
