package com.enterprise.app;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;

import com.enterprise.android.DummyTabContent;
import com.enterprise.android.R;

public class Conf extends Activity {
	TabHost tHost;
	List<TabHost.TabSpec> allTabs = new ArrayList<TabHost.TabSpec>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.conf);

		tHost = (TabHost) findViewById(android.R.id.tabhost);
		tHost.setup();

		/**
		 * Defining Tab Change Listener event. This is invoked when tab is
		 * changed
		 */
		TabHost.OnTabChangeListener tabChangeListener = new TabHost.OnTabChangeListener() {

			@Override
			public void onTabChanged(String tabId) {
				FragmentManager fm = getFragmentManager();
				Conf_AndroidFragment conf_AndroidFragment = (Conf_AndroidFragment) fm
						.findFragmentByTag("android");
				Conf_AppleFragment conf_AppleFragment = (Conf_AppleFragment) fm
						.findFragmentByTag("apple");
				Conf_KiqueFragment conf_KiqueFragment = (Conf_KiqueFragment) fm
						.findFragmentByTag("kique");
				FragmentTransaction ft = fm.beginTransaction();

				/** Detaches the androidfragment if exists */
				if (conf_AndroidFragment != null)
					ft.detach(conf_AndroidFragment);

				/** Detaches the applefragment if exists */
				if (conf_AppleFragment != null)
					ft.detach(conf_AppleFragment);

				/** Detaches the applefragment if exists */
				if (conf_KiqueFragment != null)
					ft.detach(conf_KiqueFragment);

				/** If current tab is android */
				if (tabId.equalsIgnoreCase("android")) {

					if (conf_AndroidFragment == null) {
						/**
						 * Create Conf_AndroidFragment and adding to
						 * fragmenttransaction
						 */
						ft.add(R.id.realtabcontent, new Conf_AndroidFragment(),
								"android");
					} else {
						/**
						 * Bring to the front, if already exists in the
						 * fragmenttransaction
						 */
						ft.attach(conf_AndroidFragment);
					}

				} else if (tabId.equalsIgnoreCase("apple")) {
					if (conf_AppleFragment == null) {
						/**
						 * Create Conf_AppleFragment and adding to
						 * fragmenttransaction
						 */
						ft.add(R.id.realtabcontent, new Conf_AppleFragment(),
								"apple");
					} else {
						/**
						 * Bring to the front, if already exists in the
						 * fragmenttransaction
						 */
						ft.attach(conf_AppleFragment);
					}
				} else if (tabId.equalsIgnoreCase("kique")) {
					if (conf_KiqueFragment == null) {
						/**
						 * Create Conf_AppleFragment and adding to
						 * fragmenttransaction
						 */
						ft.add(R.id.realtabcontent, new Conf_KiqueFragment(),
								"kique");
					} else {
						/**
						 * Bring to the front, if already exists in the
						 * fragmenttransaction
						 */
						ft.attach(conf_KiqueFragment);
					}
				}

				ft.commit();
			}
		};

		/** Setting tabchangelistener for the tab */
		tHost.setOnTabChangedListener(tabChangeListener);

		/** Defining tab builder for Andriod tab */
		TabHost.TabSpec tSpecAndroid = tHost.newTabSpec("android");
		tSpecAndroid.setIndicator("Android",
				getResources().getDrawable(R.drawable.android));
		tSpecAndroid.setContent(new DummyTabContent(getBaseContext()));
		tHost.addTab(tSpecAndroid);
		allTabs.add(tSpecAndroid);

		/** Defining tab builder for Apple tab */
		TabHost.TabSpec tSpecApple = tHost.newTabSpec("apple");
		tSpecApple.setIndicator("Apple",
				getResources().getDrawable(R.drawable.apple));
		tSpecApple.setContent(new DummyTabContent(getBaseContext()));
		tHost.addTab(tSpecApple);
		allTabs.add(tSpecApple);

		/** Defining tab builder for kique tab */
		TabHost.TabSpec tSpecKique = tHost.newTabSpec("kique");
		tSpecKique.setIndicator("Kique");
		tSpecKique.setContent(new DummyTabContent(getBaseContext()));
		tHost.addTab(tSpecKique);
		allTabs.add(tSpecKique);

		// --Close a tab generates a problem when is not the last one! :P
		// tHost.getTabWidget().removeView(tHost.getTabWidget().getChildTabViewAt(1));

	}

	public void removeTab(View view) {
		String TagName = tHost.getCurrentTabTag();

		tHost.clearAllTabs();
		// --Delete the current one
		int pos = -1;
		for (int i = 0; i < allTabs.size(); i++) {
			if (TagName.equals(allTabs.get(i).getTag()))
			pos = i;
		}
		if (pos != -1)
			allTabs.remove(pos);
		// -- Managing available tabs
		if (allTabs.size() > 0) {
			for (TabHost.TabSpec t : allTabs) {
				if (TagName.equals(t.getTag()))
					continue;
				tHost.addTab(t);
			}
		} else {
			this.finish();
		}

	}

}
