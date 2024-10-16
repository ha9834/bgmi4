package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzca implements av {

    /* renamed from: a, reason: collision with root package name */
    static final Map<Uri, zzca> f4542a = new androidx.b.a();
    private static final String[] g = {"key", "value"};
    private final ContentResolver b;
    private final Uri c;
    private volatile Map<String, String> e;
    private final Object d = new Object();
    private final List<zzcf> f = new ArrayList();

    private zzca(ContentResolver contentResolver, Uri uri) {
        this.b = contentResolver;
        this.c = uri;
        this.b.registerContentObserver(uri, false, new at(this, null));
    }

    public static zzca zza(ContentResolver contentResolver, Uri uri) {
        zzca zzcaVar;
        synchronized (zzca.class) {
            zzcaVar = f4542a.get(uri);
            if (zzcaVar == null) {
                try {
                    zzca zzcaVar2 = new zzca(contentResolver, uri);
                    try {
                        f4542a.put(uri, zzcaVar2);
                        zzcaVar = zzcaVar2;
                    } catch (SecurityException unused) {
                        zzcaVar = zzcaVar2;
                    }
                } catch (SecurityException unused2) {
                }
            }
        }
        return zzcaVar;
    }

    public final Map<String, String> zzre() {
        Map<String, String> map = this.e;
        if (map == null) {
            synchronized (this.d) {
                map = this.e;
                if (map == null) {
                    map = b();
                    this.e = map;
                }
            }
        }
        return map != null ? map : Collections.emptyMap();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzrf() {
        synchronized (this.d) {
            this.e = null;
            zzcm.a();
        }
        synchronized (this) {
            Iterator<zzcf> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().zzrk();
            }
        }
    }

    private final Map<String, String> b() {
        try {
            return (Map) zzch.zza(new zzcg(this) { // from class: com.google.android.gms.internal.measurement.au

                /* renamed from: a, reason: collision with root package name */
                private final zzca f4479a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f4479a = this;
                }

                @Override // com.google.android.gms.internal.measurement.zzcg
                public final Object zzrj() {
                    return this.f4479a.a();
                }
            });
        } catch (SQLiteException | IllegalStateException | SecurityException unused) {
            Log.e("ConfigurationContentLoader", "PhenotypeFlag unable to load ContentProvider, using default values");
            return null;
        }
    }

    @Override // com.google.android.gms.internal.measurement.av
    public final /* synthetic */ Object zzdd(String str) {
        return zzre().get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final /* synthetic */ Map a() {
        Map hashMap;
        Cursor query = this.b.query(this.c, g, null, null, null);
        if (query == null) {
            return Collections.emptyMap();
        }
        try {
            int count = query.getCount();
            if (count == 0) {
                return Collections.emptyMap();
            }
            if (count <= 256) {
                hashMap = new androidx.b.a(count);
            } else {
                hashMap = new HashMap(count, 1.0f);
            }
            while (query.moveToNext()) {
                hashMap.put(query.getString(0), query.getString(1));
            }
            return hashMap;
        } finally {
            query.close();
        }
    }
}
