package com.tencent.midas.oversea.comm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class NetWorkChangeReceiver extends BroadcastReceiver {
    public static final String NETWORK_CHANGE_ACTION = "android.net.conn.CONNECTIVITY_CHANGE";
    public static final String TAG = "NetWorkChangeReceiver";
    private final long NETWORK_CHANGE_DURATION = 500;
    private long lastWifiConnectedTime = 0;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (NETWORK_CHANGE_ACTION.equals(intent.getAction())) {
            boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (booleanExtra) {
                return;
            }
            if (activeNetworkInfo != null && activeNetworkInfo.getType() == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.lastWifiConnectedTime > 500) {
                    this.lastWifiConnectedTime = currentTimeMillis;
                    pingReport();
                    return;
                }
                return;
            }
            pingReport();
        }
    }

    public static void pingReport() {
        new Thread(new Runnable() { // from class: com.tencent.midas.oversea.comm.NetWorkChangeReceiver.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ArrayList<String> iPList = GlobalData.singleton().IPManager().getIPList();
                    APDataReportManager.instance().insertData("sdk.oversea.ping.start", "");
                    Iterator<String> it = iPList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("ping -c 4 " + next).getInputStream()));
                        String str = "";
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                if (readLine.contains("packet loss")) {
                                    String substring = readLine.substring(readLine.indexOf("received") + 10, readLine.indexOf("%"));
                                    GlobalData.singleton().NetTimeout().setIpLossRate(next, Integer.valueOf(substring).intValue());
                                    str = str + "lost_rate=" + substring;
                                    String readLine2 = bufferedReader.readLine();
                                    if (readLine2.contains("avg")) {
                                        int indexOf = readLine2.indexOf("/", 20);
                                        String substring2 = readLine2.substring(indexOf + 1, readLine2.indexOf(".", indexOf));
                                        GlobalData.singleton().NetTimeout().setRTT(next, Integer.valueOf(substring2).intValue());
                                        str = str + "&rtt=" + substring2;
                                    }
                                }
                                if (!TextUtils.isEmpty(str)) {
                                    APLog.d(NetWorkChangeReceiver.TAG, Thread.currentThread().getName() + " ip=" + next + "&" + str);
                                }
                            }
                        }
                        bufferedReader.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
