package ar.edu.unlam.pb2;

import java.util.HashSet;
import java.util.Set;

public class Monitoreador {
	
	private Set<Cliente> listaNegraCliente;
	private Set<Dispositivo> listaNegraDispositivo;
	private Set<Transaccion> listaTransaccionesBajoAnalisis;
	
	public Monitoreador() {
		this.listaNegraCliente = new HashSet<Cliente>();
		this.listaNegraDispositivo = new HashSet<Dispositivo>();
		this.listaTransaccionesBajoAnalisis = new HashSet<Transaccion>();
	}
		
	public Boolean buscarClienteEnListaNegra(Cliente cliente) {
		Boolean esFraudulento = false;
		for(Cliente clienteFor : this.listaNegraCliente) {
			if(cliente.getCuit().equals(cliente.getCuit())) {
				esFraudulento = true;
				break;
			}
		}
		return esFraudulento;
	}
	
	public Boolean buscarDispositivoEnListaNegra(Dispositivo dispositivo) {
		Boolean esFraudulento = false;
		for(Dispositivo dispo : this.listaNegraDispositivo) {
			if(dispo.getIdentificador().equals(dispositivo)) {
				esFraudulento = true;
				break;
			}
		}
		return esFraudulento;
	}
	
	public void agregarClienteALaListaNegra(Cliente cliente) {
		this.listaNegraCliente.add(cliente);
	}
	public void agregarDispositivoALaListaNegra(Dispositivo dispo) {
		this.listaNegraDispositivo.add(dispo);
	}
	
	public void agregarAListaDeTransaccionesBajoAnalisis(Transaccion transac) {
		if(transac.getScore() > 60 && transac.getScore() < 79) {
			this.listaTransaccionesBajoAnalisis.add(transac);
		}
	}
	
	public Boolean confirmarFraude (String transcId) {
		Transaccion transaccion = null;
		Boolean fueFraude = false;
		for( Transaccion transacFor : this.listaTransaccionesBajoAnalisis) {
			if(transacFor.getIdTransaccion().equals(transcId)) {
				transaccion = transacFor;
			}
		}
		if(transaccion != null) {
			if(transaccion.getScore() > 80) {
				fueFraude = true;
				agregarClienteALaListaNegra(transaccion.getCliente());
				agregarDispositivoALaListaNegra(transaccion.getDispositivo());
			}
		}
		
		return fueFraude;
	}
	
}
