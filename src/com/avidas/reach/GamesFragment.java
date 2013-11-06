package com.avidas.reach;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.w3c.dom.Document;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
 
public class GamesFragment extends Fragment {
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
       View rootView = inflater.inflate(R.layout.fragment_games, container, false);
       //Document doc = getDocument();
        
        //String str = doc.toString(); 
        //TextView dash = (TextView) getView().findViewById(R.id.dashboard);
        //dash.setText(str);
       //WebView myWebView = (WebView) getActivity().findViewById(R.id.results_chart);
       
        
        
        
        
        
         
        return rootView;
    }
    
    public void onClickResults(View view) {
        Intent intent = new Intent();
        getActivity().startActivity(intent);
    }
    
    public Document getDocument() {
    	String url = "http://198.74.60.200:5000/subscribers/";
        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpContext localContext = new BasicHttpContext();
            HttpPost httpPost = new HttpPost(url);
            HttpResponse response = httpClient.execute(httpPost, localContext);
            InputStream in = response.getEntity().getContent();
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(in);
            return doc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
}
