package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ax implements av {

    /* renamed from: a, reason: collision with root package name */
    static ax f4481a;
    private final Context b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ax a(Context context) {
        ax axVar;
        synchronized (ax.class) {
            if (f4481a == null) {
                f4481a = androidx.core.content.b.a(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new ax(context) : new ax();
            }
            axVar = f4481a;
        }
        return axVar;
    }

    private ax(Context context) {
        this.b = context;
        this.b.getContentResolver().registerContentObserver(zzbz.CONTENT_URI, true, new ay(this, null));
    }

    private ax() {
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.measurement.av
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final String zzdd(final String str) {
        if (this.b == null) {
            return null;
        }
        try {
            return (String) zzch.zza(new zzcg(this, str) { // from class: com.google.android.gms.internal.measurement.aw

                /* renamed from: a, reason: collision with root package name */
                private final ax f4480a;
                private final String b;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f4480a = this;
                    this.b = str;
                }

                @Override // com.google.android.gms.internal.measurement.zzcg
                public final Object zzrj() {
                    return this.f4480a.a(this.b);
                }
            });
        } catch (SecurityException e) {
            String valueOf = String.valueOf(str);
            Log.e("GservicesLoader", valueOf.length() != 0 ? "Unable to read GServices for: ".concat(valueOf) : new String("Unable to read GServices for: "), e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ String a(String str) {
        return zzbz.zza(this.b.getContentResolver(), str, null);
    }
}
