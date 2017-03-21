package pciom.projet_ssio;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;

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
            HttpGet httpget = new HttpGet("http://192.168.1.50:8080/circles");
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            Content = Client.execute(httpget, responseHandler);
            Log.e("out put reception",Content);

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




