package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.common.R;
import com.google.android.gms.common.annotation.KeepForSdk;
import javax.annotation.Nullable;

@KeepForSdk
/* loaded from: classes.dex */
public class StringResourceValueReader {

    /* renamed from: a, reason: collision with root package name */
    private final Resources f1464a;
    private final String b;

    public StringResourceValueReader(Context context) {
        Preconditions.checkNotNull(context);
        this.f1464a = context.getResources();
        this.b = this.f1464a.getResourcePackageName(R.string.common_google_play_services_unknown_issue);
    }

    @KeepForSdk
    @Nullable
    public String getString(String str) {
        int identifier = this.f1464a.getIdentifier(str, "string", this.b);
        if (identifier == 0) {
            return null;
        }
        return this.f1464a.getString(identifier);
    }
}
