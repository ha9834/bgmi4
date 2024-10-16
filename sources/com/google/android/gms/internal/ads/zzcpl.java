package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.tencent.connect.common.Constants;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzcpl extends zzaoz {

    /* renamed from: a, reason: collision with root package name */
    private final zzcpk f3362a;
    private zzbbr<JSONObject> b;
    private final JSONObject c = new JSONObject();

    @GuardedBy("this")
    private boolean d = false;

    public zzcpl(zzcpk zzcpkVar, zzbbr<JSONObject> zzbbrVar) {
        this.b = zzbbrVar;
        this.f3362a = zzcpkVar;
        try {
            this.c.put("adapter_version", this.f3362a.zzgdj.zzsx().toString());
            this.c.put(Constants.JumpUrlConstants.URL_KEY_SDK_VERSION, this.f3362a.zzgdj.zzsy().toString());
            this.c.put("name", this.f3362a.zzfis);
        } catch (RemoteException | NullPointerException | JSONException unused) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaoy
    public final synchronized void zzdc(String str) throws RemoteException {
        if (this.d) {
            return;
        }
        if (str == null) {
            onFailure("Adapter returned null signals");
            return;
        }
        try {
            this.c.put("signals", str);
        } catch (JSONException unused) {
        }
        this.b.set(this.c);
        this.d = true;
    }

    @Override // com.google.android.gms.internal.ads.zzaoy
    public final synchronized void onFailure(String str) throws RemoteException {
        if (this.d) {
            return;
        }
        try {
            this.c.put("signal_error", str);
        } catch (JSONException unused) {
        }
        this.b.set(this.c);
        this.d = true;
    }
}
