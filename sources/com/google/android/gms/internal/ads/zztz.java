package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;
import java.util.WeakHashMap;
import javax.annotation.ParametersAreNonnullByDefault;

@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zztz {

    /* renamed from: a, reason: collision with root package name */
    private final Object f3747a = new Object();
    private final WeakHashMap<Object, Object> b = new WeakHashMap<>();
    private final ArrayList<Object> c = new ArrayList<>();
    private final Context d;
    private final zzbai e;
    private final zzakh f;

    public zztz(Context context, zzbai zzbaiVar) {
        this.d = context.getApplicationContext();
        this.e = zzbaiVar;
        this.f = new zzakh(context.getApplicationContext(), zzbaiVar, (String) zzyt.zzpe().zzd(zzacu.zzckw));
    }
}
