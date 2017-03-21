package pciom.projet_ssio;



import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public class PrefActivity extends PreferenceActivity {

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        Boolean relayeur = prefs.getBoolean("switch_preference_relayeur",false);
        Boolean user = prefs.getBoolean("switch_preference_user",false);
        Boolean controleur = prefs.getBoolean("switch_preference_controleur",false);


        String roles="000";

        if(controleur){
            roles="100";
        }
        if(relayeur){
            roles="010";
        }
        if(user){
            roles="001";
        }
        if(controleur & relayeur){
            roles="110";
        }
        if(controleur & user){
            roles="101";
        }
        if(user & relayeur){
            roles="011";
        }
        if(controleur & relayeur & user){
            roles="111";
        }




        AsyncT.roles=roles;
        Log.e("Roles in backbone",  roles);

        LinearLayout root = (LinearLayout)findViewById(android.R.id.list).getParent().getParent().getParent();
        Toolbar bar = (Toolbar) LayoutInflater.from(this).inflate(R.layout.app_bar_pref, root, false);
        root.addView(bar, 0); // insert at top
        bar.setTitle(R.string.config_name);


        bar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}