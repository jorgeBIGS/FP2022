package teoria.examen.junio;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EstadisticasTwitch {
	private List<CanalTwitch> canales;

//	Un m�todo que dada una cadena de caracteres que representa un idioma, devuelve el nombre del canal 
//	de ese idioma que ha tenido un mayor porcentaje de retenci�n. Si idioma es null, entonces devuelve el 
//	canal con mayor porcentaje de retenci�n de todos los canales, independientemente del idioma. Si no se 
//	puede calcular un resultado, devuelve una cadena vac�a. (1 punto)

	public List<CanalTwitch> getCanales() {
		return canales;
	}

	public void setCanales(List<CanalTwitch> canales) {
		this.canales = canales;
	}

	public String getNombreCanalMayorPorcentajeRetencion(String idioma) {
		Comparator<CanalTwitch> cmp = Comparator.comparing(CanalTwitch::getPorcentajeRetencion)
				.thenComparing(Comparator.naturalOrder());
		Stream<CanalTwitch> aux;
		if (idioma == null) {
			aux = getCanales().stream();
		} else {
			aux = getCanales().stream().filter(c -> c.idioma().equals(idioma));
		}
		return aux.max(cmp).map(CanalTwitch::nombre).orElse("");
	}

//	3. Un m�todo que dado un booleano, devuelve un objeto de tipo Duration con la duraci�n total del contenido 
//	publicado por los canales que son socios de Twitch, si el booleano es true, o la duraci�n total del contenido 
//	publicado por los canales que no son socios de Twitch, si el booleano es false. (1 punto)
//	4. Un m�todo que devuelve un Integer con el n�mero de canales que tienen un n�mero de espectadores 
//	ocasionales por encima de la media de espectadores ocasionales de todos los canales. (1,5 puntos)
//	5. Un m�todo que dado un n�mero entero n, devuelve el porcentaje de canales con contenido adulto entre 
//	los n con m�s tiempo de visionado. El n�mero entero n debe ser positivo, si no es as� se lanzar� una 
//	excepci�n de tipo IllegalArgumentException. (1,5 puntos)
//	6. Un m�todo que devuelve un SortedMap<String, CanalTwitch> en el que las claves son los distintos idiomas 
//	de los canales y los valores, el objeto de tipo CanalTwitch m�s efectivo que publica contenidos en ese 
//	idioma. El canal m�s efectivo es el que tiene una mayor ratio de efectividad. (1,5 puntos)

	// 7. Un m�todo que devuelve una lista con los idiomas ordenados por presencia
	// del idioma. La presencia de
//	un idioma se calcula como el porcentaje de tiempo total del contenido de los canales en ese idioma con 
//	respecto al tiempo total del contenido de todos los canales. Por ejemplo, si tenemos 2 canales que han 
//	emitido contenido en espa�ol con una duraci�n total de 300 horas y 2 canales que han emitido contenido 
//	en ingl�s con una duraci�n total de 100 horas, entonces el espa�ol ser� el primer idioma del ranking, con 
//	una presencia del 75% = 300 / (300 + 100), y el ingl�s el segundo, con el 25% = 100 / (300 + 100).
//	Para resolver este ejercicio defina una funci�n auxiliar que devuelva un Map<String, Double> en el que las 
//	claves son los idiomas y los valores el porcentaje de presencia de ese idioma. (2,5 puntos

	public List<String> getListaIdiomasOrdenadaPorPresencia() {
		Map<String, Double> aux = getPresenciasPorIdioma();

		Comparator<String> cmp = Comparator.comparing(idioma -> aux.get(idioma));
		cmp = cmp.thenComparing(Comparator.naturalOrder()).reversed();
		return aux.keySet().stream().sorted(cmp).toList();
	}

	private Map<String, Double> getPresenciasPorIdioma() {
		Long totalTime = getCanales().stream().mapToLong(c -> c.duracionContenido().toHours()).sum();
		return getCanales().stream().
				collect(Collectors.groupingBy(CanalTwitch::idioma, 
						Collectors.
						collectingAndThen(
								Collectors.summingLong(
								(CanalTwitch c) -> c.duracionContenido().toHours())
								, totalIdioma->100.0 * totalIdioma/totalTime)));

	}

}
