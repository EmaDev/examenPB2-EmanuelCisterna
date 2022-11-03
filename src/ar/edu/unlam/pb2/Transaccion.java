package ar.edu.unlam.pb2;

import java.util.Objects;

public abstract class Transaccion implements Monitoreable{
	
	private String idTransaccion;
	private Cliente cliente;
	private Dispositivo dispositivo;
	private Integer score;
	private EstadoTransaccion estado;
	
	public Transaccion(String idTransaccion, Cliente cliente, Dispositivo dispositivo) {
		this.idTransaccion = idTransaccion;
		this.cliente = cliente;
		this.dispositivo = dispositivo;
		this.estado = EstadoTransaccion.PENDIENTE;
		this.score = 0;
	}
	
	public String getIdTransaccion() {
		return idTransaccion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Dispositivo getDispositivo() {
		return dispositivo;
	}
	
	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score += score;
	}

	public void setEstado(EstadoTransaccion estado) {
		this.estado = estado;
	}

	public EstadoTransaccion getEstado() {
		return estado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idTransaccion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaccion other = (Transaccion) obj;
		return Objects.equals(idTransaccion, other.idTransaccion);
	}
	
}
