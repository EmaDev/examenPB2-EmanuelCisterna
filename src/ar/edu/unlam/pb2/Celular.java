package ar.edu.unlam.pb2;

public class Celular extends Dispositivo{
	
	private String imei;
	private Boolean biometrico;
	
	public Celular(String imei, Boolean biometrico) {
		super();
		this.imei = imei;
		this.biometrico = biometrico;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public Boolean getBiometrico() {
		return biometrico;
	}
	public void setBiometrico(Boolean biometrico) {
		this.biometrico = biometrico;
	}
	@Override
	public String getIdentificador() {
		return this.imei;
	}
	@Override
	public void Denunciar(Integer identificador) {
		// TODO Auto-generated method stub
		
	}
	
	

}
