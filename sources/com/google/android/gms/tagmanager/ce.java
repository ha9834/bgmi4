package com.google.android.gms.tagmanager;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

/* loaded from: classes2.dex */
final class ce extends ag {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5102a = com.google.android.gms.internal.gtm.zza.RESOLUTION.toString();
    private final Context b;

    public ce(Context context) {
        super(f5102a, new String[0]);
        this.b = context;
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final boolean zzgw() {
        return true;
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final zzl zzb(Map<String, zzl> map) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.b.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        StringBuilder sb = new StringBuilder(23);
        sb.append(i);
        sb.append("x");
        sb.append(i2);
        return zzgj.zzi(sb.toString());
    }
}
