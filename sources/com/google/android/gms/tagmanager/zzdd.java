package com.google.android.gms.tagmanager;

import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

@ShowFirstParty
@VisibleForTesting
/* loaded from: classes2.dex */
public final class zzdd extends ag {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5166a = com.google.android.gms.internal.gtm.zza.LANGUAGE.toString();

    public zzdd() {
        super(f5166a, new String[0]);
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final boolean zzgw() {
        return false;
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final zzl zzb(Map<String, zzl> map) {
        Locale locale = Locale.getDefault();
        if (locale == null) {
            return zzgj.zzkc();
        }
        String language = locale.getLanguage();
        if (language == null) {
            return zzgj.zzkc();
        }
        return zzgj.zzi(language.toLowerCase());
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final /* bridge */ /* synthetic */ Set zzig() {
        return super.zzig();
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final /* bridge */ /* synthetic */ String zzif() {
        return super.zzif();
    }
}
