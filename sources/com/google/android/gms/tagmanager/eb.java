package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.internal.gtm.zzb;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class eb extends ag {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5132a = com.google.android.gms.internal.gtm.zza.ADWORDS_CLICK_REFERRER.toString();
    private static final String b = zzb.COMPONENT.toString();
    private static final String c = zzb.CONVERSION_ID.toString();
    private final Context d;

    public eb(Context context) {
        super(f5132a, c);
        this.d = context;
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final boolean zzgw() {
        return true;
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final zzl zzb(Map<String, zzl> map) {
        zzl zzlVar = map.get(c);
        if (zzlVar == null) {
            return zzgj.zzkc();
        }
        String zzc = zzgj.zzc(zzlVar);
        zzl zzlVar2 = map.get(b);
        String zzc2 = zzlVar2 != null ? zzgj.zzc(zzlVar2) : null;
        Context context = this.d;
        String str = zzcw.f5164a.get(zzc);
        if (str == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("gtm_click_referrers", 0);
            str = sharedPreferences != null ? sharedPreferences.getString(zzc, "") : "";
            zzcw.f5164a.put(zzc, str);
        }
        String zze = zzcw.zze(str, zzc2);
        return zze != null ? zzgj.zzi(zze) : zzgj.zzkc();
    }
}
