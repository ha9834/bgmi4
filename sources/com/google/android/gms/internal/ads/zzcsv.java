package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class zzcsv implements zzcva<zzcsu> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3418a;
    private final zzbbl b;

    public zzcsv(Context context, zzbbl zzbblVar) {
        this.f3418a = context;
        this.b = zzbblVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcsu> zzalm() {
        return this.b.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.yn

            /* renamed from: a, reason: collision with root package name */
            private final zzcsv f2640a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2640a = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                String zzvm;
                String zzvo;
                String str;
                zzcsv zzcsvVar = this.f2640a;
                zzk.zzlg();
                zzuu zzvk = zzk.zzlk().zzvc().zzvk();
                Bundle bundle = null;
                if (zzvk != null && zzvk != null && (!zzk.zzlk().zzvc().zzvl() || !zzk.zzlk().zzvc().zzvn())) {
                    if (zzvk.zzmz()) {
                        zzvk.wakeup();
                    }
                    zzuo zzmx = zzvk.zzmx();
                    if (zzmx != null) {
                        zzvm = zzmx.zzmm();
                        str = zzmx.zzmn();
                        zzvo = zzmx.zzmo();
                        if (zzvm != null) {
                            zzk.zzlk().zzvc().zzdt(zzvm);
                        }
                        if (zzvo != null) {
                            zzk.zzlk().zzvc().zzdu(zzvo);
                        }
                    } else {
                        zzvm = zzk.zzlk().zzvc().zzvm();
                        zzvo = zzk.zzlk().zzvc().zzvo();
                        str = null;
                    }
                    Bundle bundle2 = new Bundle(1);
                    if (zzvo != null && !zzk.zzlk().zzvc().zzvn()) {
                        bundle2.putString("v_fp_vertical", zzvo);
                    }
                    if (zzvm != null && !zzk.zzlk().zzvc().zzvl()) {
                        bundle2.putString("fingerprint", zzvm);
                        if (!zzvm.equals(str)) {
                            bundle2.putString("v_fp", str);
                        }
                    }
                    if (!bundle2.isEmpty()) {
                        bundle = bundle2;
                    }
                }
                return new zzcsu(bundle);
            }
        });
    }
}
