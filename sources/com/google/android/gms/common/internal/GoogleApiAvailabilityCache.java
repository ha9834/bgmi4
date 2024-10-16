package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;

/* loaded from: classes.dex */
public class GoogleApiAvailabilityCache {

    /* renamed from: a, reason: collision with root package name */
    private final SparseIntArray f1454a;
    private GoogleApiAvailabilityLight b;

    public GoogleApiAvailabilityCache() {
        this(GoogleApiAvailability.getInstance());
    }

    public GoogleApiAvailabilityCache(GoogleApiAvailabilityLight googleApiAvailabilityLight) {
        this.f1454a = new SparseIntArray();
        Preconditions.checkNotNull(googleApiAvailabilityLight);
        this.b = googleApiAvailabilityLight;
    }

    public int getClientAvailability(Context context, Api.Client client) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(client);
        if (!client.requiresGooglePlayServices()) {
            return 0;
        }
        int minApkVersion = client.getMinApkVersion();
        int i = this.f1454a.get(minApkVersion, -1);
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        while (true) {
            if (i2 < this.f1454a.size()) {
                int keyAt = this.f1454a.keyAt(i2);
                if (keyAt > minApkVersion && this.f1454a.get(keyAt) == 0) {
                    i = 0;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        if (i == -1) {
            i = this.b.isGooglePlayServicesAvailable(context, minApkVersion);
        }
        this.f1454a.put(minApkVersion, i);
        return i;
    }

    public void flush() {
        this.f1454a.clear();
    }
}
