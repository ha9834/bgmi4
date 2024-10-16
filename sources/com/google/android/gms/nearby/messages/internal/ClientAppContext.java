package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class ClientAppContext extends zzbgl implements ReflectedParcelable {
    public static final Parcelable.Creator<ClientAppContext> CREATOR = new zzd();

    /* renamed from: a, reason: collision with root package name */
    private int f4991a;
    private String b;
    private String c;
    private boolean d;
    private String e;

    @Deprecated
    public final int zzkcv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ClientAppContext(int i, String str, String str2, boolean z, int i2, String str3) {
        this.f4991a = i;
        this.b = (String) zzbq.checkNotNull(str);
        if (str2 != null && !str2.isEmpty() && !str2.startsWith("0p:")) {
            Log.w("NearbyMessages", String.format(Locale.US, "ClientAppContext: 0P identifier(%s) without 0P prefix(%s)", str2, "0p:"));
            String valueOf = String.valueOf("0p:");
            String valueOf2 = String.valueOf(str2);
            str2 = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        }
        this.c = str2;
        this.d = z;
        this.zzkcv = i2;
        this.e = str3;
    }

    public ClientAppContext(String str, String str2, boolean z, String str3, int i) {
        this(1, str, str2, z, i, str3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final ClientAppContext a(ClientAppContext clientAppContext, String str, String str2, boolean z) {
        if (clientAppContext != null) {
            return clientAppContext;
        }
        if (str == null && str2 == null) {
            return null;
        }
        return new ClientAppContext(str, str2, z, null, 0);
    }

    private static boolean a(String str, String str2) {
        return TextUtils.isEmpty(str) ? TextUtils.isEmpty(str2) : str.equals(str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClientAppContext)) {
            return false;
        }
        ClientAppContext clientAppContext = (ClientAppContext) obj;
        return a(this.b, clientAppContext.b) && a(this.c, clientAppContext.c) && this.d == clientAppContext.d && a(this.e, clientAppContext.e) && this.zzkcv == clientAppContext.zzkcv;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c, Boolean.valueOf(this.d), this.e, Integer.valueOf(this.zzkcv)});
    }

    public final String toString() {
        return String.format(Locale.US, "{realClientPackageName: %s, zeroPartyIdentifier: %s, useRealClientApiKey: %b, apiKey: %s, callingContext: %d}", this.b, this.c, Boolean.valueOf(this.d), this.e, Integer.valueOf(this.zzkcv));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zzc(parcel, 1, this.f4991a);
        zzbgo.zza(parcel, 2, this.b, false);
        zzbgo.zza(parcel, 3, this.c, false);
        zzbgo.zza(parcel, 4, this.d);
        zzbgo.zzc(parcel, 5, this.zzkcv);
        zzbgo.zza(parcel, 6, this.e, false);
        zzbgo.zzai(parcel, zze);
    }
}
