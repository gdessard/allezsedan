package com.allezsedan.sedanfootball;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.xml.sax.SAXException;
import org.w3c.dom.Document;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.action_refresh) {
            refrech();
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Read http://www.allezsedan.com/sedanRss.xml
     */
    private void refrech() {

        TextView accueilView =(TextView) findViewById(R.id.text_view_accueil);
        accueilView.setText("fsdf");


        /**


         String uri = "http://www.allezsedan.com/sedanRss.xml";

         URL url = null;
         try {
         url = new URL(uri);

         HttpURLConnection connection =
         (HttpURLConnection) url.openConnection();
         connection.setRequestMethod("GET");
         connection.setRequestProperty("Accept", "application/xml");

         InputStream xml = connection.getInputStream();

         DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
         DocumentBuilder db = dbf.newDocumentBuilder();
         Document doc = db.parse(xml);
         } catch (MalformedURLException e) {
         e.printStackTrace();
         } catch (IOException e) {
         e.printStackTrace();
         } catch (ParserConfigurationException e) {
         e.printStackTrace();
         } catch (SAXException e) {
         e.printStackTrace();
         }

         */
    }

}
