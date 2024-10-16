package com.google.android.gms.plus.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.plus.PlusOneDummyView;

/* loaded from: classes2.dex */
public final class zzm extends RemoteCreator<zzd> {

    /* renamed from: a, reason: collision with root package name */
    private static final zzm f5049a = new zzm();

    private zzm() {
        super("com.google.android.gms.plus.plusone.PlusOneButtonCreatorImpl");
    }

    public static View zza(Context context, int i, int i2, String str, int i3) {
        try {
            if (str != null) {
                return (View) ObjectWrapper.unwrap(f5049a.a(context).zza(ObjectWrapper.wrap(context), i, i2, str, i3));
            }
            throw new NullPointerException();
        } catch (Exception unused) {
            return new PlusOneDummyView(context, i);
        }
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ zzd getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
        return queryLocalInterface instanceof zzd ? (zzd) queryLocalInterface : new zze(iBinder);
    }
}
