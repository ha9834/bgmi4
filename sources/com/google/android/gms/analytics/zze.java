package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import android.util.LogPrinter;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;

@VisibleForTesting
/* loaded from: classes.dex */
public final class zze implements zzo {

    /* renamed from: a, reason: collision with root package name */
    private static final Uri f1205a;
    private final LogPrinter b = new LogPrinter(4, "GA/LogCatTransport");

    @Override // com.google.android.gms.analytics.zzo
    public final Uri zzae() {
        return f1205a;
    }

    @Override // com.google.android.gms.analytics.zzo
    public final void zzb(zzg zzgVar) {
        ArrayList arrayList = new ArrayList(zzgVar.zzaj());
        Collections.sort(arrayList, new b(this));
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            String obj2 = ((zzi) obj).toString();
            if (!TextUtils.isEmpty(obj2)) {
                if (sb.length() != 0) {
                    sb.append(", ");
                }
                sb.append(obj2);
            }
        }
        this.b.println(sb.toString());
    }

    static {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(ShareConstants.MEDIA_URI);
        builder.authority("local");
        f1205a = builder.build();
    }
}
