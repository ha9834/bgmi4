package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzcmu {

    /* renamed from: a, reason: collision with root package name */
    private final Clock f3329a;
    private final List<String> b = Collections.synchronizedList(new ArrayList());

    public zzcmu(Clock clock) {
        this.f3329a = clock;
    }

    public final <T> zzbbh<T> zza(zzcxm zzcxmVar, zzbbh<T> zzbbhVar) {
        long elapsedRealtime = this.f3329a.elapsedRealtime();
        String str = zzcxmVar.zzdej;
        if (str != null) {
            zzbar.zza(zzbbhVar, new vw(this, str, elapsedRealtime), zzbbm.zzeaf);
        }
        return zzbbhVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str, int i, long j) {
        List<String> list = this.b;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 33);
        sb.append(str);
        sb.append(".");
        sb.append(i);
        sb.append(".");
        sb.append(j);
        list.add(sb.toString());
    }

    public final String zzaku() {
        return TextUtils.join(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR, this.b);
    }
}
