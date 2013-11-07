/**
 * 
 */
package validaciones;

import java.io.InputStream;
import java.util.Properties;

import android.content.Context;

/**
 * @author user
 *
 */
public class ValidacionesSeguridad {

	/**
	 *  Este archivo mira un archivo de propiedades donde 
	 *  estan los usuarios y sus contraseñas
	 */
	public static boolean verifyPassword(Context context, String usuario, String contrasena)
	{
		//-- La validación de la excepcion DEBERÍA ser responsabilidad de otra clase.
		InputStream in;
		try{
		// create and load default properties
		Properties defaultProps = new Properties();
		in = (InputStream) context.getAssets().open("Guess.properties");
		defaultProps.load(in);
		
		if (defaultProps.containsKey(usuario) && defaultProps.contains(contrasena))
			if (defaultProps.get(usuario).equals(contrasena)){
				in.close();
				return true;
			}
		
		in.close();
		return false;
		
		}catch (Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	
	public static boolean ingresarUsuario(Context context, String usuario, String contrasena)
	{
		//-- La validación de la excepcion DEBERÍA ser responsabilidad de otra clase.
		InputStream in;
		try{
		// create and load default properties
		Properties defaultProps = new Properties();
		in = (InputStream) context.getAssets().open("Guess.properties");
		defaultProps.load(in);
		
		if (defaultProps.containsKey(usuario) && defaultProps.contains(contrasena))
			if (defaultProps.get(usuario).equals(contrasena)){
				in.close();
				return false;
			}
		
		defaultProps.setProperty(usuario, contrasena);
		in.close();
		return true;
		
		}catch (Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}

}
