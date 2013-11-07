package com.enterprise.app;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Conf_KiqueFragment extends ListFragment{
	
    /** An array of items to display in ArrayList */
	 String kique_versions[] = new String[]{
             "Android",
             "Mongo DB",
             "Salesforce",
             "JEE6",
             "Python",
             "C++",
             "SQL",
             "HTML5 and CSS3"
     };

   	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		/** Creating array adapter to set data in listview */
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getBaseContext(), android.R.layout.simple_list_item_multiple_choice, kique_versions);

        /** Setting the array adapter to the listview */
        setListAdapter(adapter);

		
		return super.onCreateView(inflater, container, savedInstanceState);
	}
	
	@Override
    public void onStart() {
            super.onStart();

            /** Setting the multiselect choice mode for the listview */
            getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }
}
