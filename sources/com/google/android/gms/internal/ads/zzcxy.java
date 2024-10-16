package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdSize;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzcxy {
    public static zzyd zza(Context context, List<zzcxn> list) {
        ArrayList arrayList = new ArrayList();
        for (zzcxn zzcxnVar : list) {
            if (zzcxnVar.zzgkq) {
                arrayList.add(AdSize.FLUID);
            } else {
                arrayList.add(new AdSize(zzcxnVar.width, zzcxnVar.height));
            }
        }
        return new zzyd(context, (AdSize[]) arrayList.toArray(new AdSize[arrayList.size()]));
    }
}
