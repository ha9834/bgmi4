package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.common.internal.ShowFirstParty;

@ShowFirstParty
/* loaded from: classes2.dex */
public final class zzgf {

    /* renamed from: a, reason: collision with root package name */
    private GoogleAnalytics f5171a;
    private Context b;
    private Tracker c;

    public zzgf(Context context) {
        this.b = context;
    }

    public final Tracker zzbm(String str) {
        a(str);
        return this.c;
    }

    private final synchronized void a(String str) {
        if (this.f5171a == null) {
            this.f5171a = GoogleAnalytics.getInstance(this.b);
            this.f5171a.setLogger(new dw());
            this.c = this.f5171a.newTracker(str);
        }
    }
}
