package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;

/* loaded from: classes2.dex */
final class x implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ PublisherAdView f2602a;
    private final /* synthetic */ zzzk b;
    private final /* synthetic */ zzagq c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(zzagq zzagqVar, PublisherAdView publisherAdView, zzzk zzzkVar) {
        this.c = zzagqVar;
        this.f2602a = publisherAdView;
        this.b = zzzkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OnPublisherAdViewLoadedListener onPublisherAdViewLoadedListener;
        if (!this.f2602a.zza(this.b)) {
            zzbad.zzep("Could not bind.");
        } else {
            onPublisherAdViewLoadedListener = this.c.f2726a;
            onPublisherAdViewLoadedListener.onPublisherAdViewLoaded(this.f2602a);
        }
    }
}
