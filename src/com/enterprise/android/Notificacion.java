package com.enterprise.android;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class Notificacion extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notificacion);

		NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

		nm.cancel(getIntent().getExtras().getInt("notificationID"));
	}
	
	public static void notificar(Context ctx, Integer notificationID) {
		//-- PendingIntent to launch activity if the user selects this notification.
	 	Intent i = new Intent(ctx, Notificacion.class);
		i.putExtra("notificationID", notificationID);

		PendingIntent pIntent = PendingIntent.getActivity(ctx, 0, i, 0);
		
		//-- build notification
		//-- the addAction re-use the same intent to keep the example short
		Notification n  = new Notification.Builder(ctx)
		        .setContentTitle("USUARIO INCORRECTO")
		        .setContentText("Subject")
		        .setSmallIcon(R.drawable.ic_launcher)
		        .setContentIntent(pIntent)
		        .setAutoCancel(true)
		        .addAction(R.drawable.ic_launcher, "Acción1", pIntent)
		        .addAction(R.drawable.ic_launcher, "Acción2", pIntent)
		        .addAction(R.drawable.ic_launcher, "Acción3", pIntent).build();
		
		//100ms delay, vibrate for 250ms, pause for 100 ms and then vibrate for 500ms---
		n.vibrate=new long[] { 1000, 2500, 1000, 5000 };
		NotificationManager nm = (NotificationManager) ctx.getSystemService(NOTIFICATION_SERVICE);
		nm.notify(notificationID, n);
		nm.cancel(notificationID);
	}
}
