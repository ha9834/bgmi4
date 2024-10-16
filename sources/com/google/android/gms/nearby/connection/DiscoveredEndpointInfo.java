package com.google.android.gms.nearby.connection;

import android.bluetooth.BluetoothDevice;
import com.google.android.gms.common.internal.Hide;

/* loaded from: classes2.dex */
public final class DiscoveredEndpointInfo {

    /* renamed from: a, reason: collision with root package name */
    private final String f4968a;
    private final String b;
    private final BluetoothDevice c;

    @Hide
    public DiscoveredEndpointInfo(String str, BluetoothDevice bluetoothDevice) {
        this.f4968a = str;
        this.b = "__UNRECOGNIZED_BLUETOOTH_DEVICE__";
        this.c = bluetoothDevice;
    }

    public DiscoveredEndpointInfo(String str, String str2) {
        this.f4968a = str;
        this.b = str2;
        this.c = null;
    }

    public final String getEndpointName() {
        return this.b;
    }

    public final String getServiceId() {
        return this.f4968a;
    }
}
