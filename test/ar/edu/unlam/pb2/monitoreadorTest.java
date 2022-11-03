package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class monitoreadorTest {

	@Test
	public void queSePuedaCrearUnCliente() {
		Cliente user = new Cliente(423405555, "Emanuel", 500.0);
		
		Integer esperado = 423405555;
		
		assertEquals(esperado, user.getCuit());
	}
	
	@Test
    public void queSePuedaCrearUnDispositivo() {
		Dispositivo celu = new Celular("ver8v282cd28ee", true);
		
		assertEquals("ver8v282cd28ee", celu.getIdentificador());
	}
	
	@Test
	public void queSePuedaMonitorearUnaExtraccion() throws FraudeException {
		Monitoreador controlador = new Monitoreador(); 
		Cliente user = new Cliente(423405555, "Emanuel", 500.0);
		Dispositivo dis = new Celular("erverver", true);
		Extraccion extrac = new Extraccion("828vrv828", user, dis);
		
		assertEquals(true, extrac.monitorear(controlador));
	}
	
	@Test(expected = FraudeException.class)
	public void queSePuedaMonitorearUnaTransferencia() throws FraudeException {
		Monitoreador controlador = new Monitoreador(); 
		Cliente user = new Cliente(423405555, "Emanuel", 500.0);
		Dispositivo dis = new Celular("erverver", true);
		
        controlador.agregarClienteALaListaNegra(user);
        
		Transferencia trns = new Transferencia("471v1cd", user, dis, 500.0);
		trns.monitorear(controlador);
	}
	
	@Test
	public void queSePuedaMonitorearUnPagoConQR() throws FraudeException {
		Monitoreador controlador = new Monitoreador(); 
		Cliente user = new Cliente(423405555, "Emanuel", 500.0);
		Dispositivo dis = new Celular("erverver", true);
        
		PagoQr qr = new PagoQr("471v1cd", user, dis);
		
		assertTrue(qr.monitorear(controlador));
	}
	
	@Test 
	public void queSePuedaMonitorearUnPagoDeServicio() {
		Monitoreador controlador = new Monitoreador(); 
		Cliente user = new Cliente(423405555, "Emanuel", 500.0);
		Dispositivo dis = new Celular("erverver", true);
		
		PagoServicio pagoServ = new PagoServicio("verokvo5", user, dis);
		
		assertTrue(pagoServ.monitorear());
	}
	
	@Test
	public void queElScoreDeUnaTransaccionRechazableSinAntecedentesDeCero() throws FraudeException {
		
		Monitoreador controlador = new Monitoreador(); 
		Cliente user = new Cliente(423405555, "Emanuel", 500.0);
		Dispositivo dis = new Celular("erverver", true);
	        
		user.AgregarDispositivoConfiable(dis);
		Transferencia trns = new Transferencia("000001", user, dis, 300.0);
		trns.monitorear(controlador);
		
		Integer esperado = 0;
		assertEquals(esperado, trns.getScore());
	}
	
	@Test
	public void queElScoreDeUnaTransaccionRechazableConNuevoDispositivoDe20Puntos() throws FraudeException {
		Monitoreador controlador = new Monitoreador(); 
		Cliente user = new Cliente(423405555, "Emanuel", 500.0);
		Dispositivo dis = new Celular("erverver", true);
		;
		Transferencia trns = new Transferencia("000001", user, dis, 300.0);
		trns.monitorear(controlador);
		
		Integer esperado = 20;
		assertEquals(esperado, trns.getScore());
	}
	@Test
	public void queUnaTransaccionAlertablePuedaSerMarcadaComoFraudulenta() {
		
	}
	
	@Test
	public void QueUnaTransaccionDeMasDe60PuntosYMenosDeOchentaSeaAlertadaPeroAprobada() throws FraudeException {
		Monitoreador controlador = new Monitoreador(); 
		Cliente user = new Cliente(423405555, "Emanuel", 500.0);
		Dispositivo dis = new Celular("erverver", true);
		;
		Transferencia trns = new Transferencia("000001", user, dis, 500.0);
		trns.monitorear(controlador);
		
		trns.confirmarSiFueFraude(controlador);

		assertEquals(EstadoTransaccion.APROBADA, trns.getEstado());
	}
	
	@Test
	public void queSePuedaMonitorearUnAltaDeUsuario() {
		Monitoreador controlador = new Monitoreador(); 
		Cliente user = new Cliente(423405555, "Emanuel", 500.0);
		Dispositivo dis = new Celular("erverver", true);
		
		AltaUsuario altaUser = new AltaUsuario("cew82c8e", user, dis);
		
		assertEquals("cew82c8e", altaUser.getIdTransaccion());
	}
	
	@Test
	public void queUnaTransaccionDeMasDe80PuntosLanceLaExcepcionFraudeException() {
		
	}
	
	@Test 
	public void queSePuedaMonitorearUnCambioDeContraseña() {
		
	}
}


















