package pciom.projet_ssio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by pro on 16/03/2017.
 */
public class OnBootReceiver extends BroadcastReceiver {



    @Override
    public void onReceive(Context context, Intent intent) {
        if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) {
            //int batteryLevel = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
            Intent serviceLauncher = new Intent(context, ServiceBatteryLevel.class);

            context.startService(serviceLauncher);
        }
    }

}
