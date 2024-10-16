package com.google.android.gms.measurement.internal;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.common.util.Clock;
import com.helpshift.util.ErrorReportProvider;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class zzac extends ee {

    /* renamed from: a, reason: collision with root package name */
    private long f4923a;
    private String b;
    private Boolean c;
    private AccountManager d;
    private Boolean e;
    private long f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzac(zzfj zzfjVar) {
        super(zzfjVar);
    }

    @Override // com.google.android.gms.measurement.internal.ee
    protected final boolean a() {
        Calendar calendar = Calendar.getInstance();
        this.f4923a = TimeUnit.MINUTES.convert(calendar.get(15) + calendar.get(16), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String lowerCase = locale.getLanguage().toLowerCase(Locale.ENGLISH);
        String lowerCase2 = locale.getCountry().toLowerCase(Locale.ENGLISH);
        StringBuilder sb = new StringBuilder(String.valueOf(lowerCase).length() + 1 + String.valueOf(lowerCase2).length());
        sb.append(lowerCase);
        sb.append("-");
        sb.append(lowerCase2);
        this.b = sb.toString();
        return false;
    }

    public final long zzcq() {
        l();
        return this.f4923a;
    }

    public final String zzcr() {
        l();
        return this.b;
    }

    public final boolean zzj(Context context) {
        if (this.c == null) {
            zzae();
            this.c = false;
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    packageManager.getPackageInfo("com.google.android.gms", 128);
                    this.c = true;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return this.c.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long e_() {
        zzo();
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c() {
        zzo();
        this.e = null;
        this.f = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean d() {
        Account[] result;
        zzo();
        long currentTimeMillis = zzx().currentTimeMillis();
        if (currentTimeMillis - this.f > ErrorReportProvider.BATCH_TIME) {
            this.e = null;
        }
        Boolean bool = this.e;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (androidx.core.content.a.b(getContext(), "android.permission.GET_ACCOUNTS") != 0) {
            zzab().zzgo().zzao("Permission error checking for dasher/unicorn accounts");
            this.f = currentTimeMillis;
            this.e = false;
            return false;
        }
        if (this.d == null) {
            this.d = AccountManager.get(getContext());
        }
        try {
            result = this.d.getAccountsByTypeAndFeatures("com.google", new String[]{"service_HOSTED"}, null, null).getResult();
        } catch (AuthenticatorException | OperationCanceledException | IOException e) {
            zzab().zzgl().zza("Exception checking account types", e);
        }
        if (result != null && result.length > 0) {
            this.e = true;
            this.f = currentTimeMillis;
            return true;
        }
        Account[] result2 = this.d.getAccountsByTypeAndFeatures("com.google", new String[]{"service_uca"}, null, null).getResult();
        if (result2 != null && result2.length > 0) {
            this.e = true;
            this.f = currentTimeMillis;
            return true;
        }
        this.f = currentTimeMillis;
        this.e = false;
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzl() {
        super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzm() {
        super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzn() {
        super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzo() {
        super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ zzac zzw() {
        return super.zzw();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ Clock zzx() {
        return super.zzx();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ zzed zzy() {
        return super.zzy();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ zzjs zzz() {
        return super.zzz();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ zzfc zzaa() {
        return super.zzaa();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ zzef zzab() {
        return super.zzab();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ cz zzac() {
        return super.zzac();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ zzs zzad() {
        return super.zzad();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ zzr zzae() {
        return super.zzae();
    }
}
