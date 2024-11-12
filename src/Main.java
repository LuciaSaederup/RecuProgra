import Modelos.JsonUtiles;
import Modelos.Jugador;
import Servicios.Servicio;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws JSONException {
        JsonUtiles jsonUtiles = new JsonUtiles();
        Servicio servicio = new Servicio();
        String buffer = JsonUtiles.leer("jugadores");
        ArrayList<JSONObject> listaJugadores = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(buffer);
        JSONArray jsonArray = new JSONArray(buffer);

        for(int i = 0; i < jsonArray.length(); i++) {
            listaJugadores.add(jsonArray.getJSONObject(i));
        }

        servicio.agregarPorColorDeOjos("brown", jsonObject);
        servicio.agregarPorPosicion("tanque", jsonObject);


    }
}