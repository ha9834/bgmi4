package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class d extends zzj {

    /* renamed from: a, reason: collision with root package name */
    private int f1412a;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(byte[] bArr) {
        Preconditions.checkArgument(bArr.length == 25);
        this.f1412a = Arrays.hashCode(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte[] a();

    public int hashCode() {
        return this.f1412a;
    }

    public boolean equals(Object obj) {
        IObjectWrapper zzb;
        if (obj == null || !(obj instanceof zzi)) {
            return false;
        }
        try {
            zzi zziVar = (zzi) obj;
            if (zziVar.zzc() == hashCode() && (zzb = zziVar.zzb()) != null) {
                return Arrays.equals(a(), (byte[]) ObjectWrapper.unwrap(zzb));
            }
            return false;
        } catch (RemoteException e) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            return false;
        }
    }

    @Override // com.google.android.gms.common.internal.zzi
    public final IObjectWrapper zzb() {
        return ObjectWrapper.wrap(a());
    }

    @Override // com.google.android.gms.common.internal.zzi
    public final int zzc() {
        return hashCode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static byte[] a(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
