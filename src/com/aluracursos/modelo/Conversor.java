package com.aluracursos.modelo;

import java.net.URL;

public class Conversor {
    private final String API_KEY = "43d0222c120dfad97edefcab"; // Reemplaza con tu API Key
    private final String URL_API = "https://api.exchangerate-api.com/v4/latest/";

    //metodo para obtener la tasa de cambio
    private double obtenerTasaCambio(String monedaDesde, String monedaHacia) throws Exception{
        String urlString = URL_API + monedaDesde;
        URL urlString = new (urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Authorization", "Bearer " + API_KEY);

        //verificar la respuesta de la API
        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Error en la conexión: " + conn.getResponseCode());
        }

        // Leer la respuesta de la API
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder respuesta = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            respuesta.append(inputLine);
        }

        in.close();

        // Procesar el JSON y obtener la tasa de cambio
        String jsonResponse = respuesta.toString();
        String tasaCambioStr = jsonResponse.split("\"" + monedaHacia + "\":")[1].split(",")[0];
        return Double.parseDouble(tasaCambioStr);
    }
    }
}
