package ar.edu.unlam.pb2;

public class AltaUsuario extends Transaccion{

	public AltaUsuario(String idTransaccion, Cliente cliente, Dispositivo dispositivo) {
		super(idTransaccion, cliente, dispositivo);
	}

	@Override
	public Boolean monitorear() {
		return true;
	}

}
