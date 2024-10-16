package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.DataLayer;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class n implements zzaq {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ DataLayer f5147a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(DataLayer dataLayer) {
        this.f5147a = dataLayer;
    }

    @Override // com.google.android.gms.tagmanager.zzaq
    public final void zzc(List<DataLayer.a> list) {
        CountDownLatch countDownLatch;
        for (DataLayer.a aVar : list) {
            this.f5147a.a((Map<String, Object>) DataLayer.a(aVar.f5065a, aVar.b));
        }
        countDownLatch = this.f5147a.h;
        countDownLatch.countDown();
    }
}
