package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: Access modifiers changed from: package-private */
@zzard
/* loaded from: classes2.dex */
public final class fd {

    /* renamed from: a, reason: collision with root package name */
    private long f2166a = -1;
    private long b = -1;
    private final /* synthetic */ zzawj c;

    public fd(zzawj zzawjVar) {
        this.c = zzawjVar;
    }

    public final long a() {
        return this.b;
    }

    public final void b() {
        Clock clock;
        clock = this.c.f2814a;
        this.b = clock.elapsedRealtime();
    }

    public final void c() {
        Clock clock;
        clock = this.c.f2814a;
        this.f2166a = clock.elapsedRealtime();
    }

    public final Bundle d() {
        Bundle bundle = new Bundle();
        bundle.putLong("topen", this.f2166a);
        bundle.putLong("tclose", this.b);
        return bundle;
    }
}
