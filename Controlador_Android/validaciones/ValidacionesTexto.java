package validaciones;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * 
 */

/**
 * Esta clase se encarga de hacer validaciones
 * @author Nestor
 *
 */
public  class ValidacionesTexto {

	/**
	 * 
	 */
	public static boolean isNotEmpty (String campo)
	{
		//-- Aquí se pueden hacer varias validaciones.
		if (campo==null)
			return false;
		if (campo.length()==0)
			return false;
			
		return true;
		
	}

}
