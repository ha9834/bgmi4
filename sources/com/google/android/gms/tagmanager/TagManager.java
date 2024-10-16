package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@VisibleForTesting
/* loaded from: classes2.dex */
public class TagManager {
    private static TagManager g;

    /* renamed from: a, reason: collision with root package name */
    private final zza f5066a;
    private final Context b;
    private final DataLayer c;
    private final zzfm d;
    private final ConcurrentMap<String, em> e;
    private final k f;

    @VisibleForTesting
    /* loaded from: classes2.dex */
    public interface zza {
        zzy zza(Context context, TagManager tagManager, Looper looper, String str, int i, k kVar);
    }

    @VisibleForTesting
    private TagManager(Context context, zza zzaVar, DataLayer dataLayer, zzfm zzfmVar) {
        if (context == null) {
            throw new NullPointerException("context cannot be null");
        }
        this.b = context.getApplicationContext();
        this.d = zzfmVar;
        this.f5066a = zzaVar;
        this.e = new ConcurrentHashMap();
        this.c = dataLayer;
        this.c.a(new dr(this));
        this.c.a(new dq(this.b));
        this.f = new k();
        this.b.registerComponentCallbacks(new dt(this));
        com.google.android.gms.tagmanager.zza.zzf(this.b);
    }

    public static TagManager getInstance(Context context) {
        TagManager tagManager;
        synchronized (TagManager.class) {
            if (g == null) {
                if (context == null) {
                    zzdi.zzav("TagManager.getInstance requires non-null context.");
                    throw new NullPointerException();
                }
                g = new TagManager(context, new ds(), new DataLayer(new q(context)), df.a());
            }
            tagManager = g;
        }
        return tagManager;
    }

    public DataLayer getDataLayer() {
        return this.c;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String str, int i) {
        zzy zza2 = this.f5066a.zza(this.b, this, null, str, i, this.f);
        zza2.zzhf();
        return zza2;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String str, int i, Handler handler) {
        zzy zza2 = this.f5066a.zza(this.b, this, handler.getLooper(), str, i, this.f);
        zza2.zzhf();
        return zza2;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String str, int i) {
        zzy zza2 = this.f5066a.zza(this.b, this, null, str, i, this.f);
        zza2.zzhg();
        return zza2;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String str, int i, Handler handler) {
        zzy zza2 = this.f5066a.zza(this.b, this, handler.getLooper(), str, i, this.f);
        zza2.zzhg();
        return zza2;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String str, int i) {
        zzy zza2 = this.f5066a.zza(this.b, this, null, str, i, this.f);
        zza2.zzhh();
        return zza2;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String str, int i, Handler handler) {
        zzy zza2 = this.f5066a.zza(this.b, this, handler.getLooper(), str, i, this.f);
        zza2.zzhh();
        return zza2;
    }

    public void dispatch() {
        this.d.dispatch();
    }

    public void setVerboseLoggingEnabled(boolean z) {
        zzdi.setLogLevel(z ? 2 : 5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized boolean a(Uri uri) {
        zzeh a2 = zzeh.a();
        if (!a2.a(uri)) {
            return false;
        }
        String d = a2.d();
        switch (du.f5128a[a2.b().ordinal()]) {
            case 1:
                em emVar = this.e.get(d);
                if (emVar != null) {
                    emVar.b(null);
                    emVar.refresh();
                    break;
                }
                break;
            case 2:
            case 3:
                for (String str : this.e.keySet()) {
                    em emVar2 = this.e.get(str);
                    if (str.equals(d)) {
                        emVar2.b(a2.c());
                        emVar2.refresh();
                    } else if (emVar2.b() != null) {
                        emVar2.b(null);
                        emVar2.refresh();
                    }
                }
                break;
        }
        return true;
    }

    @VisibleForTesting
    public final int zza(em emVar) {
        this.e.put(emVar.a(), emVar);
        return this.e.size();
    }

    @VisibleForTesting
    public final boolean zzb(em emVar) {
        return this.e.remove(emVar.a()) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str) {
        Iterator<em> it = this.e.values().iterator();
        while (it.hasNext()) {
            it.next().a(str);
        }
    }
}
