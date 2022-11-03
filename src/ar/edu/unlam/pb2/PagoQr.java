package ar.edu.unlam.pb2;

public class PagoQr extends Transaccion implements Rechazable, Alertable {

	public PagoQr(String idTransaccion, Cliente cliente, Dispositivo dispositivo) {
		super(idTransaccion, cliente, dispositivo);
		// TODO Auto-generated constructor stub
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
		if (monitoreador.buscarClienteEnListaNegra(this.getCliente())) {
			this.setScore(80);
		}
		if (monitoreador.buscarDispositivoEnListaNegra(this.getDispositivo())) {
			this.setScore(80);
		}
		if (!this.getCliente().buscarDispositivoHabitual(this.getDispositivo())) {
			setScore(20);
		}
		// TODO: CAMBIO DE CONTRASENA

		// Verifica si es para analizar
		monitoreador.agregarAListaDeTransaccionesBajoAnalisis(this);
		if (getScore() > 80) {
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
