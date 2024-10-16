package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import java.util.ArrayList;
import java.util.List;

@zzard
/* loaded from: classes2.dex */
public final class zzaed extends NativeAd.AdChoicesInfo {

    /* renamed from: a, reason: collision with root package name */
    private final zzaea f2713a;
    private final List<NativeAd.Image> b = new ArrayList();
    private String c;

    public zzaed(zzaea zzaeaVar) {
        zzaei zzaeiVar;
        IBinder iBinder;
        this.f2713a = zzaeaVar;
        try {
            this.c = this.f2713a.getText();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            this.c = "";
        }
        try {
            for (zzaei zzaeiVar2 : zzaeaVar.zzra()) {
                if (!(zzaeiVar2 instanceof IBinder) || (iBinder = (IBinder) zzaeiVar2) == null) {
                    zzaeiVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    if (queryLocalInterface instanceof zzaei) {
                        zzaeiVar = (zzaei) queryLocalInterface;
                    } else {
                        zzaeiVar = new zzaek(iBinder);
                    }
                }
                if (zzaeiVar != null) {
                    this.b.add(new zzael(zzaeiVar));
                }
            }
        } catch (RemoteException e2) {
            zzbad.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo
    public final CharSequence getText() {
        return this.c;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo
    public final List<NativeAd.Image> getImages() {
        return this.b;
    }
}
