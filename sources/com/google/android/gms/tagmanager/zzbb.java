package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;

/* loaded from: classes2.dex */
public final class zzbb implements zzbx {

    /* renamed from: a, reason: collision with root package name */
    private static zzbb f5162a;
    private static final Object b = new Object();
    private cb c;
    private an d;

    private zzbb(Context context) {
        this(ao.a(context), new de());
    }

    @VisibleForTesting
    private zzbb(an anVar, cb cbVar) {
        this.d = anVar;
        this.c = cbVar;
    }

    public static zzbx zzg(Context context) {
        zzbb zzbbVar;
        synchronized (b) {
            if (f5162a == null) {
                f5162a = new zzbb(context);
            }
            zzbbVar = f5162a;
        }
        return zzbbVar;
    }

    @Override // com.google.android.gms.tagmanager.zzbx
    public final boolean zzay(String str) {
        if (!this.c.a()) {
            zzdi.zzac("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
            return false;
        }
        this.d.a(str);
        return true;
    }
}
