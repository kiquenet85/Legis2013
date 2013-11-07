/**
 * 
 */
package com.enterprise.app;

import main.Contexto;
import system.persona.Persona;
import system.persona.Recurso;
import validaciones.ValidacionesSeguridad;
import validaciones.ValidacionesTexto;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.enterprise.android.EnterpriseActivity;
import com.enterprise.android.Notificacion;
import com.enterprise.android.R;

/**
 * @author Nestor
 *
 */
public class Dashboard extends EnterpriseActivity {

	//-- Layout
	private Button botonIngresar;
	private EditText nombreUsuario;
	private EditText contrasenaUsuario;
	private TextView labelContrasenaUsuario;
	private TextView lablNombreUsuario;
	//-- Notification
	private int notificationID = 1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// FIXME Revisar Action bar y navegación hacía atrás.
		// FIXME Los botones del menu se agregan mal en actividades sin Action Bar
		// -- This enable parent object  to do his job.
		super.onCreate(savedInstanceState);
		// -- Binding Layout 
		setContentView(R.layout.app_home);
		// --Changing title Activity
		this.setTitle(getResources().getString(R.string.home));

		// -- 1. Brings ViewGroups and Views from layout.
		botonIngresar = (Button) findViewById(R.id.app_home_button1);
		botonIngresar.setText(getString(R.string.home_ingresar));
		nombreUsuario = (EditText) findViewById(R.id.app_home_editText1);
		lablNombreUsuario = (TextView) findViewById(R.id.app_home_textView1);
		lablNombreUsuario.setText(getString(R.string.home_nombre_usuario));
		contrasenaUsuario = (EditText) findViewById(R.id.app_home_editText2);
		labelContrasenaUsuario = (TextView) findViewById(R.id.app_home_textView2);
		labelContrasenaUsuario.setText(getString(R.string.home_contrasena_usuario));

		botonIngresar.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// -- Esté código se ejecuta al dar click sobre botonIngresar

				// --1. Se hacen las validaciones respectivas (En el
				// controlador)
				if (ValidacionesTexto.isNotEmpty(nombreUsuario.getText()
						.toString())
						&& ValidacionesTexto.isNotEmpty(contrasenaUsuario
								.getText().toString())) {

					// --1. Simulando entrada. (El USUARIO VALIDO es:Sandra con
					// contraseña:12)
					if (ValidacionesSeguridad.verifyPassword(v.getContext(),
							nombreUsuario.getText().toString(),
							contrasenaUsuario.getText().toString())) {

						// --2. Se setea el contexto
						Persona p = new Recurso();
						p.setNombre(nombreUsuario.getText().toString());
						Contexto.usuario = p;

						// --3. Si la validación pasa, se llama la siguiente
						// pantalla
						//Intent i = new Intent("com.enterprise.app.Perfil");
						Intent i = new Intent(v.getContext(),Perfil.class);
						v.getContext().startActivity(i);
					} else {
						// 4. -- Si no pasa la validación informa al usuario.
						usuarioIncorrecto();
					}
				} else {
					// 4. -- Si no pasa la validación informa al usuario.
					Toast.makeText(v.getContext(), "Datos incorrectos!",
							Toast.LENGTH_LONG).show();
				}
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return true;
	}
	
	public void usuarioIncorrecto() {
		Notificacion.notificar(this, notificationID);
	}
}
