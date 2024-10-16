package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@zzard
@ParametersAreNonnullByDefault
@TargetApi(21)
/* loaded from: classes.dex */
final class el {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, String> f2149a;
    private final Context b;
    private final List<String> c;
    private final zzauq d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public el(Context context, List<String> list, zzauq zzauqVar) {
        this.b = context;
        this.c = list;
        this.d = zzauqVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<String> a(String[] strArr) {
        boolean z;
        boolean z2;
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            Iterator<String> it = this.c.iterator();
            while (true) {
                z = true;
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                String next = it.next();
                if (next.equals(str)) {
                    z2 = true;
                    break;
                }
                String valueOf = String.valueOf("android.webkit.resource.");
                String valueOf2 = String.valueOf(next);
                if ((valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).equals(str)) {
                    z2 = true;
                    break;
                }
            }
            if (z2) {
                if (f2149a.containsKey(str)) {
                    zzk.zzlg();
                    if (!zzaxi.zzp(this.b, f2149a.get(str))) {
                        z = false;
                    }
                }
                if (z) {
                    arrayList.add(str);
                } else {
                    this.d.b(str);
                }
            } else {
                this.d.a(str);
            }
        }
        return arrayList;
    }

    static {
        HashMap hashMap = new HashMap();
        if (PlatformVersion.isAtLeastLollipop()) {
            hashMap.put("android.webkit.resource.AUDIO_CAPTURE", "android.permission.RECORD_AUDIO");
            hashMap.put("android.webkit.resource.VIDEO_CAPTURE", "android.permission.CAMERA");
        }
        f2149a = hashMap;
    }
}
