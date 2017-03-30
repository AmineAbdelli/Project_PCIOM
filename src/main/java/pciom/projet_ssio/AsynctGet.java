package pciom.projet_ssio;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by pro on 21/03/2017.
 */

 // Class with extends AsyncTask class
    public class AsynctGet  extends AsyncTask<Void, Void, Void> {

    private final HttpClient Client = new DefaultHttpClient();
    private String Content;
    private String Error = null;


    @Override
    protected Void doInBackground(Void... params) {
        try {

            // Call long running operations here (perform background computation)
            // NOTE: Don't call UI Element here.

            // Server url call by GET method
            HttpGet httpget = new HttpGet("http://192.168.43.61:8080/circles");
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            Content = Client.execute(httpget, responseHandler);
            Log.e("out put reception",Content);

            String delims = ",";
            String delims2 = ":";
             Content= Content.substring(0,Content.length()-2);

            String[] tokens = Content.split(delims);

            String[] cach ;
            Double[] lati  = new Double[100];
            Double[] longi = new Double[100] ;
            String[] Mac = new String[100];
            Integer d=0 , a=0, b=0;


             for (int i = 0; i < tokens.length; i++){
                if (i%8 == 1){
                    cach = tokens[i].split(":",2);
                    Mac[d] =  cach[1];
                    d++;

                }
                 if (i%8 == 6){
                    cach = tokens[i].split(":");
                    longi[b] = Double.parseDouble(cach[1]);
                    b++;
                }
                if (i%8 == 7){
                    cach = tokens[i].split(":");
                    lati[a] = Double.parseDouble(cach[1].substring(0,cach[1].length()-1));
                    a++;
                }
            }



            Log.e("d", d + "");
            Log.e("MAC", Mac[d - 1]);
            Log.e("lati", lati[a - 1]+"");
            Log.e("longi", longi[b - 1] + "");


        } catch (ClientProtocolException e) {
            Error = e.getMessage();
            cancel(true);
        } catch (IOException e) {
            Error = e.getMessage();
            cancel(true);
        }

        return null;
    }


}




