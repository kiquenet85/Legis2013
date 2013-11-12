package com.enterprise.app;

import main.Contexto;
import validaciones.ValidarHora;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.enterprise.android.EnterpriseActivity;
import com.enterprise.android.R;

public class Perfil extends EnterpriseActivity {

	private TextView nombreUsuario;
	private Button botonConf;
	private Button botonPref;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		actionBar();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.app_perfil);

		// Call getDrawable to get the image
		nombreUsuario = (TextView) findViewById(R.id.app_perfil_textView1);
		nombreUsuario.setText(ValidarHora.hora(getApplicationContext()) + ","
				+ getString(R.string.perfil_saludo) + "! "
				+ Contexto.usuario.getNombre());
		// You can use the drawable then to set the background
		nombreUsuario
				.setBackgroundResource(R.drawable.shape_perfil_my_rounded_rectangle);
		nombreUsuario.setGravity(Gravity.FILL_HORIZONTAL);

		botonConf = (Button) findViewById(R.id.app_perfil_button1);
		botonConf.setText(getString(R.string.perfil_conf));
		botonPref = (Button) findViewById(R.id.app_perfil_button2);
		botonPref.setText(getString(R.string.perfil_pref));
		botonConf.setOnClickListener(myListener);
		botonPref.setOnClickListener(myListener);
	}

	private OnClickListener myListener = new OnClickListener() {
		public void onClick(View v) {
			if (v.getId() == botonConf.getId()) {
				Intent i = new Intent(Perfil.this, Conf.class);
				v.getContext().startActivity(i);
			} else if (v.getId() == botonPref.getId()) {
				Intent i = new Intent(Perfil.this, Pref.class);
				v.getContext().startActivity(i);
			}
		}
	};

}
