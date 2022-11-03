package ar.edu.unlam.pb2;

public class CambioContrasena extends Transaccion{

	public CambioContrasena(String idTransaccion, Cliente cliente, Dispositivo dispositivo) {
		super(idTransaccion, cliente, dispositivo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean monitorear() {
		
		return false;
	}

}
