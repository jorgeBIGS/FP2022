package teoria.examen.junio;

import java.time.Duration;
import java.util.Objects;

public record CanalTwitch(String nombre, Duration tiempoVisionado, Duration duracionContenido,
		Integer numeroEspectadoresPicoMax, Integer mediaEspectadores, Integer numFollowers, Integer numFollowersGanados,
		Integer numEspectadoresGanados, Boolean socioTwitch, Boolean contenidoAdulto, String idioma) implements Comparable<CanalTwitch> {

	public Double getPorcentajeRetencion() {
		Double result;
		if (numEspectadoresGanados() > 0) {
			result = 100.0 * numFollowers.doubleValue() / numEspectadoresGanados();
		} else {
			result = 0.0;
		}
		return result;
	}
	
	public Double getRatioEfectividad() {
		return 1.0 * tiempoVisionado().toSeconds()/duracionContenido().toSeconds();
	}
	
	public Integer getNumEspectadoresOcasionales() {
		return numeroEspectadoresPicoMax()-mediaEspectadores();
	}

	public int hashCode() {
		return Objects.hash(nombre);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CanalTwitch other = (CanalTwitch) obj;
		return Objects.equals(nombre, other.nombre);
	}

	
	public int compareTo(CanalTwitch o) {
		return nombre().compareTo(o.nombre());
	}
	


//	nombre: nombre del canal, de tipo String.
//	� tiempoVisionado: tiempo total de visionado del contenido del canal, de tipo Duration.
//	� duracionContenido: duraci�n total del contenido emitido en el canal, de tipo Duration.
//	� numEspectadoresPicoMax: n�mero de espectadores que ve�an el canal en el momento en el que lo 
//	estaban viendo m�s espectadores, es decir, el momento en el que hab�a un mayor pico de 
//	espectadores, de tipo Integer.
//	� mediaEspectadores: n�mero medio de espectadores que tiene el canal, de tipo Integer.
//	� numFollowers: n�mero de seguidores del canal, de tipo Integer.
//	� numFollowersGanados: n�mero de seguidores que el canal ha ganado en el �ltimo a�o, de tipo 
//	Integer.
//	� numEspectadoresGanados: n�mero de espectadores que el canal ha ganado en el �ltimo a�o, de tipo 
//	Integer.
//	� socioTwitch: indica si el canal es socio de Twitch, de tipo Boolean.
//	� contenidoAdulto: indica si el contenido del canal es para adultos, de tipo Boolean.
//	� idioma: idioma del contenido publicado en el canal, de tipo String.
//	� porcentajeRetencion: es la proporci�n, en tanto por ciento, entre el n�mero de seguidores y el 
//	n�mero de espectadores ganados en el �ltimo a�o, de tipo Double. Si no se han ganado espectadores 
//	en el �ltimo a�o, el porcentaje debe ser del 0%. 
//	� ratioEfectividad: se calcula como la ratio o cociente entre el tiempo total de visionado del contenido 
//	emitido en el canal y la duraci�n del contenido emitido en el mismo, de tipo Double.
//	� numEspectadoresOcasionales: se calcula como la diferencia entre el n�mero de espectadores 
//	obtenidos en e
}
