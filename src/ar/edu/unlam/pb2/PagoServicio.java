package ar.edu.unlam.pb2;

public class PagoServicio extends Transaccion implements Alertable{

	
	public PagoServicio(String idTransaccion, Cliente cliente, Dispositivo dispositivo) {
		super(idTransaccion, cliente, dispositivo);
	}

	@Override
	public void marcarComoCasoSospechoso() {
        this.setEstado(EstadoTransaccion.SOSPECHOSA);
	}

	@Override
	public void confirmarSiFueFraude( Monitoreador monitoreador) {
		if(monitoreador.confirmarFraude(this.getIdTransaccion())) {
			this.setEstado(EstadoTransaccion.FRAUDULENTA);
		}else {
			this.setEstado(EstadoTransaccion.APROBADA);
		}
	}

	@Override
	public Boolean monitorear() {
		// TODO Auto-generated method stub
		return true;
	}


 
}
