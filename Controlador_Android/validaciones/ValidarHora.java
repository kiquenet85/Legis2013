package validaciones;

import java.util.Calendar;

import android.content.Context;

import com.enterprise.android.R;

public class ValidarHora {

	public static String hora(Context ctx) {
		Calendar ahora = Calendar.getInstance();
		int hora = ahora.get(Calendar.HOUR_OF_DAY);
		String saludo = "";

			if (hora < 12) {
				saludo = (ctx.getResources().getString(R.string.validation_hora_manana));
			} else if (hora < 18) {
				saludo = (ctx.getResources().getString(R.string.validation_hora_tarde));
			} else {
				saludo = (ctx.getResources().getString(R.string.validation_hora_noche));
			}
		return saludo;
	}

}
