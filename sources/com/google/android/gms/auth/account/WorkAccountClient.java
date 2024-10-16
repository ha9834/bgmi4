package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.internal.auth.zzh;
import com.google.android.gms.tasks.Task;

/* loaded from: classes.dex */
public class WorkAccountClient extends GoogleApi<Api.ApiOptions.NoOptions> {
    private final WorkAccountApi b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WorkAccountClient(Context context) {
        super(context, WorkAccount.API, (Api.ApiOptions) null, GoogleApi.Settings.DEFAULT_SETTINGS);
        this.b = new zzh();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WorkAccountClient(Activity activity) {
        super(activity, (Api<Api.ApiOptions>) WorkAccount.API, (Api.ApiOptions) null, GoogleApi.Settings.DEFAULT_SETTINGS);
        this.b = new zzh();
    }

    public Task<Void> setWorkAuthenticatorEnabled(boolean z) {
        return PendingResultUtil.toVoidTask(this.b.setWorkAuthenticatorEnabledWithResult(asGoogleApiClient(), z));
    }

    public Task<Account> addWorkAccount(String str) {
        return PendingResultUtil.toTask(this.b.addWorkAccount(asGoogleApiClient(), str), new b(this));
    }

    public Task<Void> removeWorkAccount(Account account) {
        return PendingResultUtil.toVoidTask(this.b.removeWorkAccount(asGoogleApiClient(), account));
    }
}
