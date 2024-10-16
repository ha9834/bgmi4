package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b implements c {

    /* renamed from: a, reason: collision with root package name */
    private Long f5086a;
    private final /* synthetic */ boolean b;
    private final /* synthetic */ zzy c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(zzy zzyVar, boolean z) {
        this.c = zzyVar;
        this.b = z;
    }

    @Override // com.google.android.gms.tagmanager.c
    public final boolean a(Container container) {
        Clock clock;
        zzai zzaiVar;
        if (!this.b) {
            return !container.isDefault();
        }
        long lastRefreshTime = container.getLastRefreshTime();
        if (this.f5086a == null) {
            zzaiVar = this.c.j;
            this.f5086a = Long.valueOf(zzaiVar.zzhl());
        }
        long longValue = lastRefreshTime + this.f5086a.longValue();
        clock = this.c.f5175a;
        return longValue >= clock.currentTimeMillis();
    }
}
