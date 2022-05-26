package teoria.utiles;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Ficheros {
	public static List<String> leeLineas(String ruta){
		List<String> result = new ArrayList<>();
		
		try {
			result = Files.readAllLines(Paths.get(ruta));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return result;
	}

	public static void escribeFichero(String nombreFichero, 
			Set<String> companyias) {
		Path path = Paths.get(nombreFichero);
		try {
			Files.write(path, companyias);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
