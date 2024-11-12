package Servicios;

import Modelos.Excepcion;
import Modelos.Jugador;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.util.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Servicio {

    private TreeMap<String, JSONArray> jugadoresPorColorDeOjos = new TreeMap<>();

    private TreeMap<String, JSONArray> jugadoresPorPosicion = new TreeMap<>();


    public void agregarPorColorDeOjos(String color, JSONObject jugador) {
        jugadoresPorColorDeOjos.computeIfAbsent(color, k -> new JSONArray()).put(jugador);
    }

    public void agregarPorPosicion(String posicion, JSONObject jugador) {
        jugadoresPorPosicion.computeIfAbsent(posicion, k -> new JSONArray()).put(jugador);
    }

    public JSONArray obtenerPorColorDeOjos(String color) {
        return jugadoresPorColorDeOjos.getOrDefault(color, new JSONArray());
    }


    public JSONArray obtenerPorPosicion(String posicion) {
        return jugadoresPorPosicion.getOrDefault(posicion, new JSONArray());
    }

    public void listarPorColorDeOjos() {
        for (Map.Entry<String, JSONArray> entry : jugadoresPorColorDeOjos.entrySet()) {
            System.out.println("Color de ojos: " + entry.getKey() + " - Jugadores: " + entry.getValue());
        }
    }


    public void listarPorPosicion() {
        for (Map.Entry<String, JSONArray> entry : jugadoresPorPosicion.entrySet()) {
            System.out.println("Posición: " + entry.getKey() + " - Jugadores: " + entry.getValue());
        }
    }

    public int contarPorColorDeOjos(String color) {
        return jugadoresPorColorDeOjos.getOrDefault(color, new JSONArray()).length();
    }

    public int contarPorPosicion(String posicion) {
        return jugadoresPorPosicion.getOrDefault(posicion, new JSONArray()).length();
    }


    public static int contarElementosConClave(Collection<JSONObject> coleccion, String clave, String valorBuscado, int limite) throws Excepcion, JSONException {
        int contador = 0;
        for (JSONObject item : coleccion) {
            if (item.has(clave) && valorBuscado.equals(item.getString(clave))) {
                contador++;
            }
        }

        if (contador > limite) {
            int diferencia = contador - limite;
            throw new Excepcion( coleccion.getClass().getSimpleName(),clave , diferencia );
        }

        return contador;
    }


    public void guardarJugadoresConSueldoMayor(List<Jugador> jugadores, double sueldoMinimo, String nombreArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            for (Jugador jugador : jugadores) {
                if (Double.parseDouble(jugador.getBalance()) > sueldoMinimo) {
                    oos.writeObject(jugador);
                }
            }
            System.out.println("Jugadores guardados exitosamente en " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al guardar jugadores: " + e.getMessage());
        }
    }
}
