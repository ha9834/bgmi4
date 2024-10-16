package com.tencent.midas.oversea.newnetwork.http;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.midas.comm.APLog;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class DnsManager {
    public static final String TAG = "DnsManager";
    private static volatile DnsManager instance;
    private HashMap<String, String> netMap = new HashMap<>();
    private List<String> defaultHostList = new ArrayList(4);

    private DnsManager() {
        this.defaultHostList.add("www.midasbuy.com");
    }

    public static DnsManager singleton() {
        if (instance == null) {
            synchronized (DnsManager.class) {
                if (instance == null) {
                    instance = new DnsManager();
                }
            }
        }
        return instance;
    }

    public String queryIp(String str) {
        String str2 = "";
        HashMap<String, String> hashMap = this.netMap;
        if (hashMap != null && !hashMap.isEmpty()) {
            str2 = this.netMap.get(str);
        }
        return TextUtils.isEmpty(str2) ? "" : str2;
    }

    public void ipWithHost(final List<String> list) {
        APLog.d(TAG, "ipWithHost");
        if (list == null || list.isEmpty()) {
            return;
        }
        new Thread(new Runnable() { // from class: com.tencent.midas.oversea.newnetwork.http.DnsManager.1
            @Override // java.lang.Runnable
            public void run() {
                for (int i = 0; i < list.size(); i++) {
                    try {
                        InetAddress[] allByName = InetAddress.getAllByName((String) list.get(i));
                        if (allByName != null && allByName.length > 0) {
                            DnsManager.this.netMap.put(list.get(i), allByName[0].getHostAddress());
                        }
                    } catch (UnknownHostException unused) {
                        Log.e(DnsManager.TAG, "ipWithHost exception.");
                        return;
                    }
                }
            }
        }, "thread-dns-ipWithHost").start();
    }

    public void ipWithUrl(final String str) {
        APLog.d(TAG, "ipWithUrl");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        new Thread(new Runnable() { // from class: com.tencent.midas.oversea.newnetwork.http.DnsManager.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    InetAddress byName = InetAddress.getByName(Uri.parse(str).getHost());
                    if (byName != null) {
                        DnsManager.this.netMap.put(str, byName.getHostAddress());
                    }
                } catch (UnknownHostException unused) {
                    Log.e(DnsManager.TAG, "ipWithUrl exception.");
                }
            }
        }, "thread-dns-ipWithUrl").start();
    }

    public void prefetchDns(final String str) {
        APLog.d(TAG, "prefetchDns");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        new Thread(new Runnable() { // from class: com.tencent.midas.oversea.newnetwork.http.DnsManager.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    InetAddress.getAllByName(str);
                } catch (UnknownHostException unused) {
                    Log.e(DnsManager.TAG, "prefetchDns exception.");
                }
            }
        }, "thread-dns-prefetchDns1").start();
    }

    public void prefetchDns(final List<String> list) {
        APLog.d(TAG, "prefetchDns with hostList");
        if (list == null || list.isEmpty()) {
            return;
        }
        new Thread(new Runnable() { // from class: com.tencent.midas.oversea.newnetwork.http.DnsManager.4
            @Override // java.lang.Runnable
            public void run() {
                for (int i = 0; i < list.size(); i++) {
                    try {
                        InetAddress.getAllByName((String) list.get(i));
                    } catch (UnknownHostException unused) {
                        Log.e(DnsManager.TAG, "prefetchDns exception.");
                        return;
                    }
                }
            }
        }, "thread-dns-prefetchDns2").start();
    }

    public void prefetchDnsDefault() {
        APLog.d(TAG, "prefetchDnsDefault");
        List<String> list = this.defaultHostList;
        if (list == null || list.isEmpty()) {
            return;
        }
        new Thread(new Runnable() { // from class: com.tencent.midas.oversea.newnetwork.http.DnsManager.5
            @Override // java.lang.Runnable
            public void run() {
                for (int i = 0; i < DnsManager.this.defaultHostList.size(); i++) {
                    try {
                        InetAddress.getAllByName((String) DnsManager.this.defaultHostList.get(i));
                    } catch (UnknownHostException unused) {
                        Log.e(DnsManager.TAG, "prefetchDns exception.");
                        return;
                    }
                }
            }
        }, "thread-dns-prefetchDnsDefault").start();
    }

    public void clearJavaDnsCache() {
        APLog.d(TAG, "clearJavaDnsCache");
        try {
            InetAddress.class.getMethod("clearDnsCache", new Class[0]).invoke(null, new Object[0]);
        } catch (IllegalAccessException unused) {
            Log.e(TAG, "clearJavaDnsCache IllegalAccessException.");
        } catch (NoSuchMethodException unused2) {
            Log.e(TAG, "clearJavaDnsCache NoSuchMethodException.");
        } catch (InvocationTargetException unused3) {
            Log.e(TAG, "clearJavaDnsCache InvocationTargetException.");
        }
    }
}
