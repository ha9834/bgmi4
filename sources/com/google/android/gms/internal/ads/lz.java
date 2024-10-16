package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Map;

/* loaded from: classes2.dex */
final class lz implements zzaho<zzbgz> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ lx f2333a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public lz(lx lxVar) {
        this.f2333a = lxVar;
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
                synchronized (this.f2333a) {
                    i = this.f2333a.y;
                    if (i != parseInt) {
                        this.f2333a.y = parseInt;
                        this.f2333a.requestLayout();
                    }
                }
            } catch (Exception e) {
                zzawz.zzd("Exception occurred while getting webview content height", e);
            }
        }
    }
}
