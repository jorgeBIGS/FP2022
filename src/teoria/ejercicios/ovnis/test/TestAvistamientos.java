package teoria.ejercicios.ovnis.test;

import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import teoria.ejercicios.ovnis.Avistamientos;
import teoria.ejercicios.ovnis.FactoriaAvistamientos;

public class TestAvistamientos {

	public static void main(String[] args) {
		Avistamientos av = FactoriaAvistamientos.leerAvistamientos("data/ovnis.csv", true);
		SortedMap<Integer, Long> avistamientosPorAnyo = new TreeMap<Integer, Long>(av.getNumeroAvistamientosPorAnyo());
		muestraMap(avistamientosPorAnyo);
	}
	public static void muestraMap2(SortedMap<Integer, Long> avistamientosPorAnyo) {
		Set<Integer> aux = 
				avistamientosPorAnyo.keySet();
		for (Integer key : aux) {
			System.out.println(
					key + " -> " 
						+ avistamientosPorAnyo.get(key));
		}
	}

	public static void muestraMap(SortedMap<Integer, Long> avistamientosPorAnyo) {
		Set<Entry<Integer, Long>> aux = 
				avistamientosPorAnyo.entrySet();
		for (Entry<Integer, Long> par : aux) {
			System.out.println(
					par.getKey() + " -> " 
							+ par.getValue());
		}
	}

}
