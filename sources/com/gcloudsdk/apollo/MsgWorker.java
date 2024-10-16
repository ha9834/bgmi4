package com.gcloudsdk.apollo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Build;
import android.util.Log;
import androidx.core.content.a;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/* loaded from: classes.dex */
class MsgWorker implements Runnable {
    private static String LOGTAG = "NetInterfaceHelper";
    private Context mContext;
    private boolean mPermissionGranted = false;
    private HashMap<String, Network> mNetworks = new HashMap<>();
    private Vector<EventMsg> mMsgQueue = new Vector<>(128);
    private Vector<String> mDomains = new Vector<>(128);

    private String ifname(int i) {
        switch (i) {
            case 0:
                return "cellular";
            case 1:
                return "wifi";
            case 2:
            default:
                return "unknown";
            case 3:
                return "ethernet";
            case 4:
                return "vpn";
        }
    }

    public native void bindCallback(String str, int i, int i2, int i3);

    public native void dnsQueryCallback(String str, String str2, String str3, int i);

    public MsgWorker(Context context) {
        this.mContext = context;
    }

    public boolean checkManifestPermission() {
        if (this.mContext == null) {
            Log.i(LOGTAG, "checkManifestPermission mContext == null");
            return false;
        }
        try {
            String[] strArr = {"android.permission.INTERNET", "android.permission.CHANGE_NETWORK_STATE", "android.permission.ACCESS_NETWORK_STATE"};
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < strArr.length; i++) {
                if (a.b(this.mContext, strArr[i]) != 0) {
                    arrayList.add(strArr[i]);
                    Log.i(LOGTAG, "checkManifestPermission:" + strArr[i] + " has no permission");
                }
            }
            if (arrayList.isEmpty()) {
                this.mPermissionGranted = true;
            } else {
                this.mPermissionGranted = false;
            }
            return false;
        } catch (Exception unused) {
            this.mPermissionGranted = false;
            return false;
        }
    }

    public void sendMessage(EventMsg eventMsg) {
        this.mMsgQueue.add(eventMsg);
    }

    public void initCM() {
        Log.i(LOGTAG, "initCM");
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        checkManifestPermission();
        if (!this.mPermissionGranted) {
            Log.e(LOGTAG, "mPermissionGranted is false");
            return;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
        NetworkRequest build = new NetworkRequest.Builder().addTransportType(1).addCapability(12).build();
        ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.gcloudsdk.apollo.MsgWorker.1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                MsgWorker.this.setNetwork(1, network);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLosing(Network network, int i) {
                MsgWorker.this.setNetwork(1, null);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                MsgWorker.this.setNetwork(1, null);
            }
        };
        NetworkRequest build2 = new NetworkRequest.Builder().addTransportType(0).addCapability(12).build();
        ConnectivityManager.NetworkCallback networkCallback2 = new ConnectivityManager.NetworkCallback() { // from class: com.gcloudsdk.apollo.MsgWorker.2
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                MsgWorker.this.setNetwork(0, network);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLosing(Network network, int i) {
                MsgWorker.this.setNetwork(0, null);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                MsgWorker.this.setNetwork(0, null);
            }
        };
        NetworkRequest build3 = new NetworkRequest.Builder().addTransportType(3).addCapability(12).build();
        ConnectivityManager.NetworkCallback networkCallback3 = new ConnectivityManager.NetworkCallback() { // from class: com.gcloudsdk.apollo.MsgWorker.3
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                MsgWorker.this.setNetwork(3, network);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLosing(Network network, int i) {
                MsgWorker.this.setNetwork(3, null);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                MsgWorker.this.setNetwork(3, null);
            }
        };
        NetworkRequest build4 = new NetworkRequest.Builder().addTransportType(4).addCapability(12).build();
        ConnectivityManager.NetworkCallback networkCallback4 = new ConnectivityManager.NetworkCallback() { // from class: com.gcloudsdk.apollo.MsgWorker.4
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                MsgWorker.this.setNetwork(4, network);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLosing(Network network, int i) {
                MsgWorker.this.setNetwork(4, null);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                MsgWorker.this.setNetwork(4, null);
            }
        };
        connectivityManager.requestNetwork(build, networkCallback);
        connectivityManager.requestNetwork(build2, networkCallback2);
        connectivityManager.requestNetwork(build3, networkCallback3);
        connectivityManager.requestNetwork(build4, networkCallback4);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setNetwork(int i, Network network) {
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        String ifname = ifname(i);
        synchronized (this) {
            if (network == null) {
                Log.i(LOGTAG, "remove net:" + i);
                this.mNetworks.remove(ifname);
                return;
            }
            Log.i(LOGTAG, "setNetwork  net:" + i + " network:" + network.toString());
            this.mNetworks.put(ifname, network);
            Object[] array = this.mDomains.toArray();
            if (network != null) {
                for (Object obj : array) {
                    String str = (String) obj;
                    try {
                        dnsQueryCallback(str, ifname, network.getByName(str).getHostAddress(), 4);
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void dealWarm(String str) {
        HashMap hashMap;
        Log.i(LOGTAG, "dealWarm:" + str);
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        if (!this.mPermissionGranted) {
            Log.e(LOGTAG, "mPermissionGranted is false");
            return;
        }
        synchronized (this) {
            this.mDomains.add(str);
            hashMap = (HashMap) this.mNetworks.clone();
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            try {
                dnsQueryCallback(str, (String) entry.getKey(), ((Network) entry.getValue()).getByName(str).getHostAddress(), 4);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
    }

    private void dealBind(int i, String str, int i2) {
        Network network;
        Log.i(LOGTAG, "dealBind:" + str + " for " + i);
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        if (!this.mPermissionGranted) {
            Log.e(LOGTAG, "mPermissionGranted is false");
            return;
        }
        FileDescriptor fileDescriptor = new FileDescriptor();
        try {
            Field declaredField = FileDescriptor.class.getDeclaredField("descriptor");
            declaredField.setAccessible(true);
            try {
                declaredField.setInt(fileDescriptor, i);
                synchronized (this) {
                    network = this.mNetworks.get(str);
                }
                if (network == null) {
                    bindCallback(str, i, 1, i2);
                    return;
                }
                if (Build.VERSION.SDK_INT >= 23) {
                    try {
                        network.bindSocket(fileDescriptor);
                        bindCallback(str, i, 0, i2);
                        return;
                    } catch (IOException e) {
                        e.printStackTrace();
                        bindCallback(str, i, -2, i2);
                        return;
                    }
                }
                bindCallback(str, i, -3, i2);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                bindCallback(str, i, -1, i2);
            }
        } catch (NoSuchFieldException e3) {
            e3.printStackTrace();
            bindCallback(str, i, -1, i2);
        }
    }

    /*  JADX ERROR: NullPointerException in pass: RegionMakerVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "block" is null
        	at jadx.core.dex.nodes.MethodNode.isPreExitBlock(MethodNode.java:398)
        	at jadx.core.dex.visitors.regions.RegionMaker.calcSwitchOut(RegionMaker.java:908)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:797)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:157)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:740)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:411)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:201)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:135)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    /* JADX INFO: Infinite loop detected, blocks: 33, insns: 0 */
    @Override // java.lang.Runnable
    public void run() {
        /*
            r3 = this;
        L0:
            java.util.Vector<com.gcloudsdk.apollo.EventMsg> r0 = r3.mMsgQueue
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L13
            r0 = 20
            java.lang.Thread.sleep(r0)     // Catch: java.lang.Exception -> Le
            goto L0
        Le:
            r0 = move-exception
            r0.printStackTrace()
            goto L0
        L13:
            java.util.Vector<com.gcloudsdk.apollo.EventMsg> r0 = r3.mMsgQueue     // Catch: java.lang.Exception -> L3f
            java.lang.Object r0 = r0.firstElement()     // Catch: java.lang.Exception -> L3f
            com.gcloudsdk.apollo.EventMsg r0 = (com.gcloudsdk.apollo.EventMsg) r0     // Catch: java.lang.Exception -> L3f
            java.util.Vector<com.gcloudsdk.apollo.EventMsg> r1 = r3.mMsgQueue     // Catch: java.lang.Exception -> L3f
            r2 = 0
            r1.remove(r2)     // Catch: java.lang.Exception -> L3f
            int r1 = r0.cmd
            r2 = 255(0xff, float:3.57E-43)
            if (r1 == r2) goto L3b
            switch(r1) {
                case 1: goto L35;
                case 2: goto L2b;
                default: goto L2a;
            }
        L2a:
            goto L0
        L2b:
            int r1 = r0.arg1
            java.lang.String r2 = r0.strarg
            int r0 = r0.arg2
            r3.dealBind(r1, r2, r0)
            goto L0
        L35:
            java.lang.String r0 = r0.strarg
            r3.dealWarm(r0)
            goto L0
        L3b:
            r3.initCM()
            goto L0
        L3f:
            r0 = move-exception
            r0.printStackTrace()
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gcloudsdk.apollo.MsgWorker.run():void");
    }
}
