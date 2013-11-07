package system.persona;

/**
 * <font color="#000000">Define los detalles de comunes de cualquier persona en el
 * sistema.</font>
 * @author Nestor
 * @version 1.0
 * @created 24-oct-2012 23:32:53
 */
public abstract class Persona {

	private String contraseña;
	private int edad;
	private String email;
	private boolean hombre;
	private Long id;
	private String nombre;
	private String segundoNombre;

	public Persona(){

	}

	public void finalize() throws Throwable {

	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public boolean isHombre() {
		return hombre;
	}

	public void setHombre(boolean hombre) {
		this.hombre = hombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}