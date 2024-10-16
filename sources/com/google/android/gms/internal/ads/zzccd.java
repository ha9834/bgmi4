package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzccd extends zzaff {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3176a;
    private final zzbyt b;
    private final zzbzl c;
    private final zzbyn d;

    public zzccd(Context context, zzbyt zzbytVar, zzbzl zzbzlVar, zzbyn zzbynVar) {
        this.f3176a = context;
        this.b = zzbytVar;
        this.c = zzbzlVar;
        this.d = zzbynVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafe
    public final IObjectWrapper zzrh() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzafe
    public final String zzcj(String str) {
        return this.b.zzaid().get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzafe
    public final zzaei zzck(String str) {
        return this.b.zzaic().get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzafe
    public final List<String> getAvailableAssetNames() {
        androidx.b.g<String, zzadw> zzaic = this.b.zzaic();
        androidx.b.g<String, String> zzaid = this.b.zzaid();
        String[] strArr = new String[zzaic.size() + zzaid.size()];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i2 < zzaic.size()) {
            strArr[i3] = zzaic.b(i2);
            i2++;
            i3++;
        }
        while (i < zzaid.size()) {
            strArr[i3] = zzaid.b(i);
            i++;
            i3++;
        }
        return Arrays.asList(strArr);
    }

    @Override // com.google.android.gms.internal.ads.zzafe
    public final String getCustomTemplateId() {
        return this.b.getCustomTemplateId();
    }

    @Override // com.google.android.gms.internal.ads.zzafe
    public final void performClick(String str) {
        this.d.zzfi(str);
    }

    @Override // com.google.android.gms.internal.ads.zzafe
    public final void recordImpression() {
        this.d.zzahk();
    }

    @Override // com.google.android.gms.internal.ads.zzafe
    public final zzaar getVideoController() {
        return this.b.getVideoController();
    }

    @Override // com.google.android.gms.internal.ads.zzafe
    public final void destroy() {
        this.d.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzafe
    public final IObjectWrapper zzrm() {
        return ObjectWrapper.wrap(this.f3176a);
    }

    @Override // com.google.android.gms.internal.ads.zzafe
    public final boolean zzp(IObjectWrapper iObjectWrapper) {
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(unwrap instanceof ViewGroup) || !this.c.zza((ViewGroup) unwrap)) {
            return false;
        }
        this.b.zzahz().zza(new rr(this));
        return true;
    }
}
