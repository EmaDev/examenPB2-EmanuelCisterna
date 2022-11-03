package ar.edu.unlam.pb2;

import java.util.Set;

public interface Rechazable {
	
	public Boolean monitorear(Monitoreador monitoreador) throws FraudeException;
	
}
