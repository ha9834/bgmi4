package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Map;

/* loaded from: classes2.dex */
final class lm implements zzaho<zzbgz> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ lk f2320a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public lm(lk lkVar) {
        this.f2320a = lkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaho
    public final /* synthetic */ void zza(zzbgz zzbgzVar, Map map) {
        int i;
        if (map != null) {
            String str = (String) map.get(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                int parseInt = Integer.parseInt(str);
                synchronized (this.f2320a) {
                    i = this.f2320a.D;
                    if (i != parseInt) {
                        this.f2320a.D = parseInt;
                        this.f2320a.requestLayout();
                    }
                }
            } catch (Exception e) {
                zzawz.zzd("Exception occurred while getting webview content height", e);
            }
        }
    }
}
