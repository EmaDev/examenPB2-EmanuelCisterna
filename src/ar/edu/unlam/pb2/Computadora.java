package ar.edu.unlam.pb2;

public class Computadora extends Dispositivo{
	
	private String ip;
	private String so;
	private String localidad;
	
	public Computadora(String ip, String so, String localidad) {
		super();
		this.ip = ip;
		this.so = so;
		this.localidad = localidad;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getSo() {
		return so;
	}

	public void setSo(String so) {
		this.so = so;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	@Override
	public String getIdentificador() {
	   return this.ip;
	}

	@Override
	public void Denunciar(Integer identificador) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
