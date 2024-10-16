package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Collections;
import java.util.Set;

/* loaded from: classes2.dex */
public class zzbvz {

    /* renamed from: a, reason: collision with root package name */
    private final zzbwz f3075a;
    private final zzbgz b;

    public zzbvz(zzbwz zzbwzVar) {
        this(zzbwzVar, null);
    }

    public zzbvz(zzbwz zzbwzVar, zzbgz zzbgzVar) {
        this.f3075a = zzbwzVar;
        this.b = zzbgzVar;
    }

    public final zzbwz zzaha() {
        return this.f3075a;
    }

    public final zzbgz zzafn() {
        return this.b;
    }

    public final View zzahb() {
        zzbgz zzbgzVar = this.b;
        if (zzbgzVar == null) {
            return null;
        }
        return zzbgzVar.getWebView();
    }

    public Set<zzbuz<zzbrl>> zza(zzbxc zzbxcVar) {
        return Collections.singleton(zzbuz.zzb(zzbxcVar, zzbbm.zzeaf));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a() {
        if (this.b.zzaae() != null) {
            this.b.zzaae().close();
        }
    }
}
