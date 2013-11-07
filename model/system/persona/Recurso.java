package system.persona;
import utileria.RecursoEnum;

/**
 * @author Nestor
 * @version 1.0
 * @created 24-oct-2012 23:32:53
 */
public class Recurso extends Persona {

	private Long id;
	public RecursoEnum tipo;

	public Recurso(){

	}

	public RecursoEnum getTipo() {
		return tipo;
	}

	public void setTipo(RecursoEnum m_RecursoEnum) {
		this.tipo = m_RecursoEnum;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}