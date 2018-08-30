package com.mcc.galleryapp.broadcastreceiver;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.mcc.galleryapp.BaseApplication;
import com.mcc.galleryapp.listener.NetworkChangedListener;


/**
 * Created by MD Sahidul Islam on 12/2/2018.
 */
public class InternetConnectivityReceiver extends BroadcastReceiver {

    public static NetworkChangedListener networkChangedListener;

    public static void setNetworkChangedListener(NetworkChangedListener listener) {
        networkChangedListener = listener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;

        boolean isConnected = networkInfo != null && networkInfo.isConnected();


/*        final ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        final android.net.NetworkInfo wifi = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        final android.net.NetworkInfo mobile = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        boolean isConnected = wifi.isConnectedOrConnecting() || mobile.isConnectedOrConnecting();*/
//        networkChangedListener.onNetworkConnectionChanged(isConnected);
    }

    public static boolean isInternetConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) BaseApplication.getInstance()
                .getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;

        return networkInfo != null && networkInfo.isConnected();
    }
}
