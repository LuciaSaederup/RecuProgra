package Modelos;

import org.json.JSONArray;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonUtiles {

    public JsonUtiles() {
    }

    public static void grabar(JSONArray array) {
            try {
                FileWriter file = new FileWriter("test.json");
                file.write(array.toString());
                file.flush();
                file.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static String leer(String archivo)
        {
            String contenido = "";
            try
            {
                contenido = new String(Files.readAllBytes(Paths.get(archivo+".json")));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return contenido;
        }
}

