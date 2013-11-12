package com.enterprise.android;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import com.enterprise.app.Pref;

public class DialogEnterprise extends DialogFragment{

	public static DialogEnterprise newInstance(String title) {
		DialogEnterprise fragment = new DialogEnterprise();
		Bundle args = new Bundle();
		args.putString("title", title);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO The Pref class should not be burned
		String title = getArguments().getString("title");
		return new AlertDialog.Builder(getActivity())
		.setIcon(R.drawable.ic_launcher)
		.setTitle(title)
		.setPositiveButton("OK",
				new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, 
					int whichButton) {
				((Pref)
						getActivity()).doPositiveClick();
			}
		})
		.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, 
					int whichButton) {
				((Pref)
						getActivity()).doPositiveClick();
			}
		}).create();
	}        

}
