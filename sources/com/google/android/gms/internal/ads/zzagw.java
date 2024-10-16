package com.google.android.gms.internal.ads;

import com.tencent.midas.oversea.newnetwork.http.NetworkManager;
import java.util.Map;

@zzard
/* loaded from: classes2.dex */
public final class zzagw implements zzaho<Object> {

    /* renamed from: a, reason: collision with root package name */
    private final zzagx f2730a;

    public zzagw(zzagx zzagxVar) {
        this.f2730a = zzagxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaho
    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get("name");
        if (str == null) {
            zzawz.zzep("App event with no name parameter.");
        } else {
            this.f2730a.onAppEvent(str, map.get(NetworkManager.CMD_INFO));
        }
    }
}
