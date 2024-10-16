package com.subao.common.k;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import com.subao.common.k.m;
import java.net.DatagramSocket;

/* loaded from: classes2.dex */
public class p implements m.b {

    /* renamed from: a, reason: collision with root package name */
    private final Network f6116a;

    public p(Network network) {
        this.f6116a = network;
    }

    @Override // com.subao.common.k.m.b
    public void a(DatagramSocket datagramSocket) {
        r.a(datagramSocket, this.f6116a);
    }

    @Override // com.subao.common.k.m.b
    @TargetApi(21)
    public NetworkInfo a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return null;
        }
        return connectivityManager.getNetworkInfo(this.f6116a);
    }

    @TargetApi(21)
    public String toString() {
        return this.f6116a.toString();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof p) {
            return com.subao.common.e.a(this.f6116a, ((p) obj).f6116a);
        }
        return false;
    }

    public int hashCode() {
        return this.f6116a.hashCode();
    }
}
