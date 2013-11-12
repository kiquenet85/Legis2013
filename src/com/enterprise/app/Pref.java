package com.enterprise.app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.enterprise.android.DatePickerEnterprise;
import com.enterprise.android.DialogEnterprise;
import com.enterprise.android.EnterpriseActivity;
import com.enterprise.android.R;

public class Pref extends EnterpriseActivity {

	private ProgressBar progressBar;
	private Button btnBirthayDate, btnSave;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.app_pref);
		getActionBar();

		progressBar = (ProgressBar) findViewById(R.id.progressbar);
		showProgressBar(progressBar);
		
		btnBirthayDate= (Button)findViewById(R.id.app_pref_button1);
		btnBirthayDate.setText("Registrar fecha de Cumpleaños");
		btnBirthayDate.setTextColor(getResources().getColor(R.color.black));
		btnSave=(Button)findViewById(R.id.app_pref_button2);
		btnSave.setText("Salvar");
		
		btnBirthayDate.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 DatePickerEnterprise newFragment = new DatePickerEnterprise();
				    newFragment.show(getFragmentManager(), "datePicker");
			}
		});

		btnSave.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				DialogEnterprise dialogFragment = DialogEnterprise.newInstance(
		                "Are you sure you want to do this?");
		            dialogFragment.show(getFragmentManager(), "dialog");   
			}
		});
		
	   
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			Toast.makeText(this, "You clicked on the Application icon",
					Toast.LENGTH_LONG).show();

			Intent i = null;
			i = new Intent(this, Perfil.class);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);
			return true;
		}
		return true;
	}

	public void doPositiveClick() {
		// ---perform steps when user clicks on OK---
		Log.d("DialogFragmentExample", "User clicks on OK");
	}

	public void doNegativeClick() {
		// ---perform steps when user clicks on Cancel---
		Log.d("DialogFragmentExample", "User clicks on Cancel");
	}

}
