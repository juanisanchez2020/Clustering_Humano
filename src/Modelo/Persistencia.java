package Modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import Negocio.ConjuntoDePersonas;

public class Persistencia {

	public void guardar(ConjuntoDePersonas array) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try {
			FileWriter writer = new FileWriter("jsonPretty.json");
			writer.write(gson.toJson(array));
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ConjuntoDePersonas cargar() {
		Gson gson = new Gson();
		ConjuntoDePersonas lista = new ConjuntoDePersonas();
		try {
			BufferedReader reader = new BufferedReader(new FileReader("jsonPretty.json"));
			lista = gson.fromJson(reader, ConjuntoDePersonas.class);
			return lista;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
