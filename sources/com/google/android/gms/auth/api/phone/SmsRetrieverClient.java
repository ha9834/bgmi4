package com.google.android.gms.auth.api.phone;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.internal.p001authapiphone.zzi;
import com.google.android.gms.tasks.Task;

/* loaded from: classes.dex */
public abstract class SmsRetrieverClient extends GoogleApi<Api.ApiOptions.NoOptions> implements SmsRetrieverApi {
    private static final Api.ClientKey<zzi> b = new Api.ClientKey<>();
    private static final Api.AbstractClientBuilder<zzi, Api.ApiOptions.NoOptions> c = new a();
    private static final Api<Api.ApiOptions.NoOptions> d = new Api<>("SmsRetriever.API", c, b);

    public SmsRetrieverClient(Activity activity) {
        super(activity, (Api<Api.ApiOptions>) d, (Api.ApiOptions) null, (StatusExceptionMapper) new ApiExceptionMapper());
    }

    public SmsRetrieverClient(Context context) {
        super(context, d, (Api.ApiOptions) null, new ApiExceptionMapper());
    }

    @Override // com.google.android.gms.auth.api.phone.SmsRetrieverApi
    public abstract Task<Void> startSmsRetriever();
}
