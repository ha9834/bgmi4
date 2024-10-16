package com.google.android.gms.auth.api.accounttransfer;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;

/* loaded from: classes.dex */
public final class AccountTransfer {
    public static final String ACTION_ACCOUNT_EXPORT_DATA_AVAILABLE = "com.google.android.gms.auth.ACCOUNT_EXPORT_DATA_AVAILABLE";
    public static final String ACTION_ACCOUNT_IMPORT_DATA_AVAILABLE = "com.google.android.gms.auth.ACCOUNT_IMPORT_DATA_AVAILABLE";
    public static final String ACTION_START_ACCOUNT_EXPORT = "com.google.android.gms.auth.START_ACCOUNT_EXPORT";
    public static final String KEY_EXTRA_ACCOUNT_TYPE = "key_extra_account_type";

    /* renamed from: a, reason: collision with root package name */
    private static final Api.ClientKey<com.google.android.gms.internal.auth.zzu> f1222a = new Api.ClientKey<>();
    private static final Api.AbstractClientBuilder<com.google.android.gms.internal.auth.zzu, zzn> b = new a();
    private static final Api<zzn> c = new Api<>("AccountTransfer.ACCOUNT_TRANSFER_API", b, f1222a);

    @Deprecated
    private static final zzb d = new com.google.android.gms.internal.auth.zzt();
    private static final zzq e = new com.google.android.gms.internal.auth.zzt();

    public static AccountTransferClient getAccountTransferClient(Activity activity) {
        return new AccountTransferClient(activity);
    }

    public static AccountTransferClient getAccountTransferClient(Context context) {
        return new AccountTransferClient(context);
    }

    private AccountTransfer() {
    }
}
