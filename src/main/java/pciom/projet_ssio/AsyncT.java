package pciom.projet_ssio;

import android.location.Location;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by pro on 17/03/2017.
 */
public class AsyncT extends AsyncTask<Void,Void,Void> {

    public static String email="";
    public static Double lang;
    public static Double lati;

    public String type="N";
    public String batteryLevel="";
    public static String roles="";
    public String mobility="";
    private static boolean first=false;
    private static AsyncT instance;
    public static AsyncT getInstance() {
        if (null == instance || first) { // Premier appel
            instance = new AsyncT();
            first=false;
        }
        return instance;
    }
    @Override
    protected Void doInBackground(Void... params) {


        InputStream inputStream = null;
        String result = "";
        try {
            URL url = new URL("http://192.168.43.61:8080/circles"); //Enter URL here

            HttpClient httpclient = new DefaultHttpClient();

            // 2. make POST request to the given URL
            HttpPost httpPost = new HttpPost("http://192.168.43.61:8080/circles");

            String json = "";



            // 3. build jsonObject
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("email",email) ;
            jsonObject.put("longitude",lang);
            jsonObject.put("latitude", lati);
            jsonObject.put("type", type);
            jsonObject.put("batteryLevel", batteryLevel);
            jsonObject.put("roles", roles);
            jsonObject.put("mobility", mobility);


            // 4. convert JSONObject to JSON to String
            json = jsonObject.toString();

            // 5. set json to StringEntity
            StringEntity se = new StringEntity(json);

            // 6. set httpPost Entity
            httpPost.setEntity(se);

            // 7. Set some headers to inform server about the type of the content
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");

            // 8. Execute POST request to the given URL
            HttpResponse httpResponse = httpclient.execute(httpPost);


            first=true;

            Log.e("sdafsad",jsonObject.toString());
            getInstance();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }


}