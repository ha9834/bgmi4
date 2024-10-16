package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzbtp extends zzbts<AppEventListener> implements zzagx {
    public zzbtp(Set<zzbuz<AppEventListener>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzagx
    public final synchronized void onAppEvent(final String str, final String str2) {
        a(new zzbtu(str, str2) { // from class: com.google.android.gms.internal.ads.pb

            /* renamed from: a, reason: collision with root package name */
            private final String f2409a;
            private final String b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2409a = str;
                this.b = str2;
            }

            @Override // com.google.android.gms.internal.ads.zzbtu
            public final void zzr(Object obj) {
                ((AppEventListener) obj).onAppEvent(this.f2409a, this.b);
            }
        });
    }
}
