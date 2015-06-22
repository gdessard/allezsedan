package com.allezsedan.sedanfootball;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.allezsedan.sedanfootball.bean.news.Channel;
import com.allezsedan.sedanfootball.bean.news.Item;
import com.allezsedan.sedanfootball.persistance.Rss2Parser;

import org.xmlpull.v1.XmlPullParserException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        refrech();

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
        LinearLayout gridLayoutItemRss = (LinearLayout) findViewById(R.id.linearLayout_item_list);
        gridLayoutItemRss.removeAllViewsInLayout();
        TextView titreRssTextView = (TextView) findViewById(R.id.titre_rss);

        Rss2Parser rss2Parser = new Rss2Parser();
        // convert String into InputStream
        InputStream in = new ByteArrayInputStream(rssString.getBytes());
        Channel channel;
        try {
            channel = rss2Parser.parse(in);
        } catch (XmlPullParserException e) {
            Log.e(TAG, "Erreur lecture RSS (XmlPullParserException)", e);
            titreRssTextView.setText("Erreur lecture RSS");
            return;
        } catch (IOException e) {
            Log.e(TAG, "Erreur lecture RSS (IOException)", e);
            titreRssTextView.setText("Erreur lecture RSS");
            return;
        }

        //Entete RSS
        titreRssTextView.setText(channel.getTitle());

        //Gestion items
        List<Item> itemList = channel.getItemList();
        for (Item item : itemList) {
            //Récupération du gridLayout d'un item du RSS
            LayoutInflater inflater = this.getLayoutInflater();
            View itemView = inflater.inflate(R.layout.item_rss, null);

            TextView titreItemRss = (TextView) itemView.findViewById(R.id.titre_item_rss);
            titreItemRss.setText(item.getTitle());

            //Ajout description
            TextView textViewDescription = (TextView) itemView.findViewById(R.id.description_item_rss);
            textViewDescription.setText(item.getDescription());
            //Ajout date
            TextView textViewDate = (TextView) itemView.findViewById(R.id.date_item_rss);
            DateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy HH:mm");
            String pubDateFormat = formatter.format(item.getPubDate());
            textViewDate.setText(pubDateFormat);

            gridLayoutItemRss.addView(itemView);

        }


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

    /**
     * Just for test parsing. Replace by call to http://www.allezsedan.com/sedanRss.xml
     * FIXME to delete, juste for test
     */
    public final String rssString =
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "\t<rss version=\"2.0\" xmlns:atom=\"http://www.w3.org/2005/Atom\">\n" +
                    "    <channel>\n" +

                    "      <link>http://www.allezsedan.com</link>\n" +

                    "      <description>allezSedan.com site non officiel du cssa :: site des supporters !</description>\n" +
                    "      <language>fr-fr</language>\n" +
                    "\t  <copyright>Copyright 2005 AllezSedan.com </copyright>\n" +
                    "\t  <ttl>1</ttl>\n" +
                    "\t  <image>\n" +
                    "\t\t<title>www.AllezSedan.com : premier site RSS Sedanais du net</title>\n" +
                    "\t\t<url>http://www.allezsedan.com/images/logoAllezSedan.gif</url>\n" +
                    "        <link>http://www.allezsedan.com</link>\n" +
                    "      </image>\n" +
                    "      <lastBuildDate>Mon, 01 Jun 2015 18:45:34 +0200</lastBuildDate>\n" +
                    "\t\t  \n" +
                    "\t<item>\n" +
                    "\t\t<title>AAAAAU17 DH, Reims - Sedan, les photos</title>\n" +
                    "\t\t<pubDate>Mon, 01 Jun 2015 18:41:41 +0200</pubDate>\n" +
                    "\t\t<description>Les photos de la rencontre sont en ligne sur le site, espace multimédia. </description>\n" +
                    "\t\t<link>http://www.allezsedan.com/article5958_U17_DH_Reims_-_Sedan_les_photos.html</link>\n" +
                    "\t\t<guid>http://www.allezsedan.com/article5958_U17_DH_Reims_-_Sedan_les_photos.html</guid>\n" +
                    "\t\t<enclosure url='http://www.allezsedan.com/images/logoAllezSedan.jpg' length='26204' type='image/jpeg' />\n" +
                    "\t</item>\n" +
                    "\t<item>\n" +
                    "\t\t<title>Sedan - Lille B, les images du match</title>\n" +
                    "\t\t<pubDate>Mon, 25 May 2015 10:14:48 +0200</pubDate>\n" +
                    "\t\t<description>description sdmlfjsdml fjsdml fjmlsdfj mlsdfj mlsdj fmlsdqfjsq</description>\n" +
                    "\t\t<link>http://www.allezsedan.com/article5957_Sedan_-_Lille_B_les_images_du_match.html</link>\n" +
                    "\t\t<guid>http://www.allezsedan.com/article5957_Sedan_-_Lille_B_les_images_du_match.html</guid>\n" +
                    "\t\t<enclosure url='http://www.allezsedan.com/ftp/article/mini/DSC_8973.jpg' length='11574' type='image/jpeg' />\n" +
                    "\t</item>\n" +

                    "\t</channel>\n" +
                    "    </rss>";

}
