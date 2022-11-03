package ar.edu.unlam.pb2;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Cliente implements Denunciable{
	private Integer cuit;
	private String nombre;
	private Double fondos;
	private Set<Dispositivo> dispositivosHabituales;
	
	public Cliente(Integer cuit, String nombre, Double fondos) {
		this.cuit = cuit;
		this.nombre = nombre;
		this.fondos = fondos;
		this.dispositivosHabituales = new HashSet<Dispositivo>();
	}

	public Integer getCuit() {
		return cuit;
	}

	public void setCuit(Integer cuit) {
		this.cuit = cuit;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public Double getFondos() {
		return fondos;
	}

	public Set<Dispositivo> getDispositivosHabituales() {
		return dispositivosHabituales;
	}

	public void AgregarDispositivoConfiable(Dispositivo dispo) {
		this.dispositivosHabituales.add(dispo);
	}
	
	public Boolean buscarDispositivoHabitual(Dispositivo dispositivo) {
		Boolean esHabitual = false;
		
		for( Dispositivo dispo : this.dispositivosHabituales) {
			if(dispo.getIdentificador().equals(dispositivo.getIdentificador())) {
				esHabitual = true;
			}
		}
		return esHabitual;
	}
	
	@Override
	public void Denunciar(Integer identificador) {
		
	}
	
	
	
	
	
	
}
