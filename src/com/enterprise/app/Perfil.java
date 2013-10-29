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
	private Button botonSi;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.app_perfil);

		nombreUsuario = (TextView) findViewById(R.id.app_perfil_textView1);
		nombreUsuario.setText(ValidarHora.hora(getApplicationContext()) + ","+getString(R.string.perfil_saludo)
				+"! "+Contexto.usuario.getNombre());
		nombreUsuario.setGravity(Gravity.FILL_HORIZONTAL);

		botonSi = (Button) findViewById(R.id.app_perfil_button1);
		botonSi.setText(getString(R.string.perfil_conf));
		botonSi.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent i = new Intent(Perfil.this,Conf.class);
				v.getContext().startActivity(i);

			}
		});

	}

}
