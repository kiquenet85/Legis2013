package system.persona;
import utileria.NotiEnum;

/**
 * @author Nestor
 * @version 1.0
 * @created 24-oct-2012 23:32:53
 */
public class Recurso extends Persona {

	private Long id;
	public NotiEnum tipo;

	public Recurso(){

	}

	public NotiEnum getTipo() {
		return tipo;
	}

	public void setTipo(NotiEnum m_RecursoEnum) {
		this.tipo = m_RecursoEnum;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}