package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class zzcsd implements zzcva<zzcsc> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbbl f3406a;
    private final Context b;

    public zzcsd(zzbbl zzbblVar, Context context) {
        this.f3406a = zzbblVar;
        this.b = context;
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcsc> zzalm() {
        return this.f3406a.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.yh

            /* renamed from: a, reason: collision with root package name */
            private final zzcsd f2635a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2635a = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f2635a.a();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzcsc a() throws Exception {
        AudioManager audioManager = (AudioManager) this.b.getSystemService("audio");
        return new zzcsc(audioManager.getMode(), audioManager.isMusicActive(), audioManager.isSpeakerphoneOn(), audioManager.getStreamVolume(3), audioManager.getRingerMode(), audioManager.getStreamVolume(2), zzk.zzll().zzpq(), zzk.zzll().zzpr());
    }
}
