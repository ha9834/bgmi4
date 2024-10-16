package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.video.Videos;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ax extends zze.bd<Videos.CaptureOverlayStateListener> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(ListenerHolder listenerHolder) {
        super(listenerHolder);
    }

    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
    public final void onCaptureOverlayStateChanged(final int i) {
        a(new zze.q(i) { // from class: com.google.android.gms.games.internal.ay

            /* renamed from: a, reason: collision with root package name */
            private final int f1659a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f1659a = i;
            }

            @Override // com.google.android.gms.games.internal.zze.q
            public final void a(Object obj) {
                ((Videos.CaptureOverlayStateListener) obj).onCaptureOverlayStateChanged(this.f1659a);
            }
        });
    }
}
