package com.google.android.gms.tagmanager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.helpshift.util.ErrorReportProvider;
import java.util.Random;

@ShowFirstParty
/* loaded from: classes2.dex */
public final class zzai {

    /* renamed from: a, reason: collision with root package name */
    private final Context f5160a;
    private final Random b;
    private final String c;

    public zzai(Context context, String str) {
        this(context, str, new Random());
    }

    private zzai(Context context, String str, Random random) {
        this.f5160a = (Context) Preconditions.checkNotNull(context);
        this.c = (String) Preconditions.checkNotNull(str);
        this.b = random;
    }

    public final long zzhl() {
        return a(7200000L, 259200000L) + 43200000;
    }

    public final long zzhm() {
        return a(600000L, ErrorReportProvider.BATCH_TIME) + 3600000;
    }

    private final long a(long j, long j2) {
        long max = Math.max(0L, a().getLong("FORBIDDEN_COUNT", 0L));
        return this.b.nextFloat() * ((float) (j + ((((float) max) / ((float) ((max + Math.max(0L, r0.getLong("SUCCESSFUL_COUNT", 0L))) + 1))) * ((float) (j2 - j)))));
    }

    @SuppressLint({"CommitPrefEdits"})
    public final void zzhn() {
        SharedPreferences a2 = a();
        long j = a2.getLong("FORBIDDEN_COUNT", 0L);
        long j2 = a2.getLong("SUCCESSFUL_COUNT", 0L);
        SharedPreferences.Editor edit = a2.edit();
        long min = j == 0 ? 3L : Math.min(10L, j + 1);
        long max = Math.max(0L, Math.min(j2, 10 - min));
        edit.putLong("FORBIDDEN_COUNT", min);
        edit.putLong("SUCCESSFUL_COUNT", max);
        edit.apply();
    }

    @SuppressLint({"CommitPrefEdits"})
    public final void zzho() {
        SharedPreferences a2 = a();
        long j = a2.getLong("SUCCESSFUL_COUNT", 0L);
        long j2 = a2.getLong("FORBIDDEN_COUNT", 0L);
        long min = Math.min(10L, j + 1);
        long max = Math.max(0L, Math.min(j2, 10 - min));
        SharedPreferences.Editor edit = a2.edit();
        edit.putLong("SUCCESSFUL_COUNT", min);
        edit.putLong("FORBIDDEN_COUNT", max);
        edit.apply();
    }

    private final SharedPreferences a() {
        Context context = this.f5160a;
        String valueOf = String.valueOf("_gtmContainerRefreshPolicy_");
        String valueOf2 = String.valueOf(this.c);
        return context.getSharedPreferences(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), 0);
    }
}
