/**
 * 
 */
package com.enterprise.android;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.enterprise.app.Dashboard;
import com.enterprise.app.Perfil;

/**
 * @author Nestor
 * 
 */
public class EnterpriseActivity extends Activity{
	//-- Layout
	protected  ActionBar actionBar;
	//-- Custom Variables
	private String tag = "EnterpriseLog";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		//actionBar();
		super.onCreate(savedInstanceState);
		// Initialize Activity and inflate the UI.
		Log.d(tag, "In the onCreate() event");
	}

	// Called after onCreate has finished, use to restore UI state
	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		// Restore UI state from the savedInstanceState.
		// This bundle has also been passed to onCreate.
		// Will only be called if the Activity has been
		// killed by the system since it was last visible.
		Log.d(tag, "In the onRestoreInstanceState() event");
	}

	// Called before subsequent visible lifetimes
	// for an Activity process.
	@Override
	public void onRestart() {
		super.onRestart();
		// Load changes knowing that the Activity has already
		// been visible within this process.
		Log.d(tag, "In the onRestart() event");
	}

	// Called at the start of the visible lifetime.
	@Override
	public void onStart() {
		super.onStart();
		// Apply any required UI change now that the Activity is visible.
		Log.d(tag, "In the onStart() event");
	}

	// Called at the start of the active lifetime.
	@Override
	public void onResume() {
		super.onResume();
		// Resume any paused UI updates, threads, or processes required
		// by the Activity but suspended when it was inactive.
		Log.d(tag, "In the onResume() event");
	}

	// Called to save UI state changes at the
	// end of the active lifecycle.
	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		// Save UI state changes to the savedInstanceState.
		// This bundle will be passed to onCreate and
		// onRestoreInstanceState if the process is
		// killed and restarted by the run time.
		super.onSaveInstanceState(savedInstanceState);
		Log.d(tag, "In the onSaveInstanceState() event");
	}

	// Called at the end of the active lifetime.
	@Override
	public void onPause() {
		// Suspend UI updates, threads, or CPU intensive processes
		// that don’t need to be updated when the Activity isn’t
		// the active foreground Activity.
		super.onPause();
		Log.d(tag, "In the onPause() event");
	}

	// Called at the end of the visible lifetime.
	@Override
	public void onStop() {
		// Suspend remaining UI updates, threads, or processing
		// that aren’t required when the Activity isn’t visible.
		// Persist all edits or state changes
		// as after this call the process is likely to be killed.
		super.onStop();
		Log.d(tag, "In the onStop() event");
	}

	// Sometimes called at the end of the full lifetime.
	@Override
	public void onDestroy() {
		// Clean up any resources including ending threads,
		// closing database connections etc.
		super.onDestroy();
		Log.d(tag, "In the onDestroy() event");
	}

	public void actionBar()
	{
		actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        //actionBar.setDisplayShowHomeEnabled(true);
        //actionBar.hide();
        //actionBar.show(); //---show it again---
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		CreateMenu(menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return MenuChoice(item);
	}

	private void CreateMenu(Menu menu) {
		MenuItem mnu1 = menu.add(0, 0, 0, "Item 1");
		{
			mnu1.setIcon(R.drawable.ic_launcher);
			mnu1.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM
					| MenuItem.SHOW_AS_ACTION_WITH_TEXT);
		}
		MenuItem mnu2 = menu.add(0, 1, 1, "Item 2");
		{
			mnu2.setIcon(R.drawable.ic_launcher);
			mnu2.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM
					| MenuItem.SHOW_AS_ACTION_WITH_TEXT);
		}
		MenuItem mnu3 = menu.add(0, 2, 2, "Item 3");
		{
			mnu3.setIcon(R.drawable.ic_launcher);
			mnu3.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM
					| MenuItem.SHOW_AS_ACTION_WITH_TEXT);
		}
		MenuItem mnu4 = menu.add(0, 3, 3, "Item 4");
		{
			mnu4.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM
					| MenuItem.SHOW_AS_ACTION_WITH_TEXT);
		}
		MenuItem mnu5 = menu.add(0, 4, 4, "Item 5");
		{
			mnu5.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM
					| MenuItem.SHOW_AS_ACTION_WITH_TEXT);
		}
	}

	/**
	 * This is a private method to manage context or non context menus
	 * */
	private boolean MenuChoice(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			Toast.makeText(this, "You clicked on the Application icon",
					Toast.LENGTH_LONG).show();

			/* The Intent.FLAG_ACTIVITY_CLEAR_TOP flag ensures that the series of activities in the back stack is
			cleared when the user clicks the application icon on the Action Bar. This way, if the user clicks the
			back button, the other activities in the application do not appear again.*/
			Intent i=null;
			if (this instanceof Perfil){
				i = new Intent(this, Dashboard.class);
				i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			}else{
				i = new Intent(this, Perfil.class);
				i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			}
			startActivity(i);
			return true;
		case 0:
			Toast.makeText(this, "You clicked on Item 1", Toast.LENGTH_LONG)
					.show();
			return true;
		case 1:
			Toast.makeText(this, "You clicked on Item 2", Toast.LENGTH_LONG)
					.show();
			return true;
		case 2:
			Toast.makeText(this, "You clicked on Item 3", Toast.LENGTH_LONG)
					.show();
			return true;
		case 3:
			Toast.makeText(this, "You clicked on Item 4", Toast.LENGTH_LONG)
					.show();
			return true;
		case 4:
			Toast.makeText(this, "You clicked on Item 5", Toast.LENGTH_LONG)
					.show();
			return true;
		}
		return false;
	}

}
