package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public abstract class zzbft implements Releasable {

    /* renamed from: a, reason: collision with root package name */
    protected Context f2870a;
    protected String b;
    protected WeakReference<zzbdf> c;

    public zzbft(zzbdf zzbdfVar) {
        this.f2870a = zzbdfVar.getContext();
        this.b = zzk.zzlg().zzq(this.f2870a, zzbdfVar.zzyh().zzbsx);
        this.c = new WeakReference<>(zzbdfVar);
    }

    public abstract void abort();

    @Override // com.google.android.gms.common.api.Releasable
    public void release() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzcy(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzcz(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzda(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzdb(int i) {
    }

    public abstract boolean zzex(String str);

    public boolean zze(String str, String[] strArr) {
        return zzex(str);
    }

    @VisibleForTesting
    public final void zza(String str, String str2, int i, int i2, boolean z, int i3, int i4) {
        zzazt.zzyr.post(new kj(this, str, str2, i, 0, z, i3, i4));
    }

    @VisibleForTesting
    public final void zza(String str, String str2, long j, long j2, boolean z) {
        zzazt.zzyr.post(new kk(this, str, str2, j, j2, z));
    }

    @VisibleForTesting
    public final void zza(String str, String str2, long j, long j2, boolean z, int i, int i2) {
        zzazt.zzyr.post(new kl(this, str, str2, j, j2, z, i, i2));
    }

    @VisibleForTesting
    public final void zza(String str, String str2, int i, int i2, long j, long j2, boolean z, int i3, int i4) {
        zzazt.zzyr.post(new km(this, str, str2, i, i2, j, j2, z, i3, i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(String str, String str2, int i) {
        zzazt.zzyr.post(new kn(this, str, str2, i));
    }

    @VisibleForTesting
    public final void zzb(String str, String str2, long j) {
        zzazt.zzyr.post(new ko(this, str, str2, j));
    }

    @VisibleForTesting
    public final void zza(String str, String str2, String str3, String str4) {
        zzazt.zzyr.post(new kp(this, str, str2, str3, str4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String a(String str) {
        zzyt.zzpa();
        return zzazt.zzei(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String b(String str) {
        char c;
        switch (str.hashCode()) {
            case -1947652542:
                if (str.equals("interrupted")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1396664534:
                if (str.equals("badUrl")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -1347010958:
                if (str.equals("inProgress")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -918817863:
                if (str.equals("downloadTimeout")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -659376217:
                if (str.equals("contentLengthMissing")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -642208130:
                if (str.equals("playerFailed")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -354048396:
                if (str.equals("sizeExceeded")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case -32082395:
                if (str.equals("externalAbort")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 3387234:
                if (str.equals("noop")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 96784904:
                if (str.equals("error")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 580119100:
                if (str.equals("expireFailed")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 725497484:
                if (str.equals("noCacheDir")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return "internal";
            case 6:
            case 7:
                return "io";
            case '\b':
            case '\t':
                return "network";
            case '\n':
            case 11:
                return "policy";
            default:
                return "internal";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str, Map<String, String> map) {
        zzbdf zzbdfVar = this.c.get();
        if (zzbdfVar != null) {
            zzbdfVar.zza(str, map);
        }
    }
}
