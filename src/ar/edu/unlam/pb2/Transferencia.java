package ar.edu.unlam.pb2;

public class Transferencia extends Transaccion implements Rechazable, Alertable{

	private Double monto;
	
	public Transferencia(String idTransaccion, Cliente cliente, Dispositivo dispositivo, Double monto) {
		super(idTransaccion, cliente, dispositivo);
		this.monto = monto;
	}

	@Override
	public void marcarComoCasoSospechoso() {
        this.setEstado(EstadoTransaccion.SOSPECHOSA);
	}

	@Override
	public void confirmarSiFueFraude(Monitoreador monitoreador) {
		if(monitoreador.confirmarFraude(this.getIdTransaccion())) {
			this.setEstado(EstadoTransaccion.FRAUDULENTA);
		}else {
			this.setEstado(EstadoTransaccion.APROBADA);
		}
	}

	@Override
	public Boolean monitorear(Monitoreador monitoreador) throws FraudeException {
		
		if(monitoreador.buscarClienteEnListaNegra(this.getCliente())) {
			this.setScore(80);
		}
		if(monitoreador.buscarDispositivoEnListaNegra(this.getDispositivo())) {
			this.setScore(80);
		}
		if(!this.getCliente().buscarDispositivoHabitual(this.getDispositivo())) {
			setScore(20);
		}
		//TODO: CAMBIO DE CONTRASENA
		
		if(this.getCliente().getFondos().equals(this.monto)) {
			setScore(40);
		}
		
		//Verifica si es para analizar
		monitoreador.agregarAListaDeTransaccionesBajoAnalisis(this);
		
		if(getScore() > 80) {
			throw new FraudeException("Esta transferencia es fraudulenta");
		}
		return true;
	}

	@Override
	public Boolean monitorear() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
