package com.avidas.reach;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

 
public class TopRatedFragment extends ListFragment {
 
	//private FeedDbAdapter dbHelper;
	//private SimpleCursorAdapter dataAdapter;
	  @Override
	  public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    String[] values = new String[] { "HIGH ALERT : 72 out of 300 mothers at stage childbirth in Bangladesh have not responded to level 3 messages.", "INFO : MaryAnn sent new information about vaccine IBP1 for Malaria to South Africa.", "SUCCESS : 40 out of 93 mothers with one year old child are giving vaccines to child.", 
	    		"ALERT : 19 out of 50 mothers with year old child have.",
	    		"INFO : Jamie created new sms workflow for expecting mothers in India. View/Edit",
	    		"INFO : Jamie created new sms workflow for expecting mothers in Bangladesh. View/Edit"
	    		};
	    
	    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
	        android.R.layout.simple_list_item_1, values);
	    
	    setListAdapter(adapter);
	  }
	  
	  @Override
	  public void onListItemClick(ListView l, View v, int position, long id) {
	    // do something with the data

	  }
    //@Override
    //public View onCreateView(LayoutInflater inflater, ViewGroup container,
    //        Bundle savedInstanceState) {
 
        //View rootView = inflater.inflate(R.layout.fragment_top_rated, container, false);
        
        //ListView listView = (ListView) getView().findViewById(R.id.listView1);
        /*
        dbHelper = new FeedDbAdapter(getActivity());
        dbHelper.open();
        dbHelper.deleteAllCountries();
        dbHelper.insertSomeFeeds();
        
        
        Cursor cursor = dbHelper.fetchAllCountries();
        
        String[] columns = new String[] {
        		FeedDbAdapter.KEY_TYPE,
        		FeedDbAdapter.KEY_DESC
        };
        
        int[] to = new int[] {
        	R.id.textView2,
        	R.id.feed_entry,
        	
        };
        
        dataAdapter = new SimpleCursorAdapter(
        		getActivity(), R.layout.feed_entry,
        		cursor,
        		columns,
        		to,
        		0);
        ListView listView = (ListView) getView().findViewById(R.id.listView1);
        listView.setAdapter(dataAdapter);
        
        
        */
     //   return rootView;
    //}
    
    
}