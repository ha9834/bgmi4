package com.google.android.gms.auth.account;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.auth.zzh;
import com.google.android.gms.internal.auth.zzr;

/* loaded from: classes.dex */
public class WorkAccount {

    /* renamed from: a, reason: collision with root package name */
    private static final Api.ClientKey<zzr> f1217a = new Api.ClientKey<>();
    private static final Api.AbstractClientBuilder<zzr, Api.ApiOptions.NoOptions> b = new a();
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>("WorkAccount.API", b, f1217a);

    @Deprecated
    public static final WorkAccountApi WorkAccountApi = new zzh();

    public static WorkAccountClient getClient(Activity activity) {
        return new WorkAccountClient(activity);
    }

    public static WorkAccountClient getClient(Context context) {
        return new WorkAccountClient(context);
    }

    private WorkAccount() {
    }
}
