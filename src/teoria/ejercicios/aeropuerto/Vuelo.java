package teoria.ejercicios.aeropuerto;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class Vuelo implements Comparable<Vuelo>{
	private LocalDate fecha;
	private LocalTime horaPlanificada;
	private String codigo, ciudad;
	private String codigoAeropuerto, companyia, modeloAvion, id;
	private EstadoVuelo estado;
	private LocalTime horaEfectiva;
	private DireccionVuelo direccion;
	
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public LocalTime getHoraPlanificada() {
		return horaPlanificada;
	}
	public String getCodigo() {
		return codigo;
	}
	public String getCodigoAeropuerto() {
		return codigoAeropuerto;
	}
	public String getCompanyia() {
		return companyia;
	}
	public String getModeloAvion() {
		return modeloAvion;
	}
	public String getId() {
		return id;
	}
	public EstadoVuelo getEstado() {
		return estado;
	}
	public LocalTime getHoraEfectiva() {
		return horaEfectiva;
	}
	public DireccionVuelo getDireccion() {
		return direccion;
	}
	
	public Long getDiferenciaMinutos() {
		Long result = null;
		if(!getEstado().equals(EstadoVuelo.CANCELED)) {
			result = 
					Duration.between(getHoraPlanificada(), 
							getHoraEfectiva()).toMinutes();
		}
		return result;
	}
	@Override
	public int compareTo(Vuelo o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
