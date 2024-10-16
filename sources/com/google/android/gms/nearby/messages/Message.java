package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;
import com.google.android.gms.internal.zzcux;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class Message extends zzbgl implements ReflectedParcelable {
    public static final int MAX_CONTENT_SIZE_BYTES = 102400;
    public static final int MAX_TYPE_LENGTH = 32;
    public static final String MESSAGE_NAMESPACE_RESERVED = "__reserved_namespace";
    public static final String MESSAGE_TYPE_AUDIO_BYTES = "__audio_bytes";
    public static final String MESSAGE_TYPE_EDDYSTONE_UID = "__eddystone_uid";
    public static final String MESSAGE_TYPE_I_BEACON_ID = "__i_beacon_id";
    private int b;
    private final byte[] c;
    private final String d;
    private final String e;

    @Deprecated
    private zzcux[] f;
    private final long g;
    public static final Parcelable.Creator<Message> CREATOR = new zza();

    /* renamed from: a, reason: collision with root package name */
    private static final zzcux[] f4980a = {zzcux.zzkck};

    /* JADX INFO: Access modifiers changed from: package-private */
    public Message(int i, byte[] bArr, String str, String str2, zzcux[] zzcuxVarArr, long j) {
        this.b = i;
        this.d = (String) zzbq.checkNotNull(str2);
        this.e = str == null ? "" : str;
        this.g = j;
        zzbq.checkNotNull(bArr);
        zzbq.zzb(bArr.length <= 102400, "Content length(%d) must not exceed MAX_CONTENT_SIZE_BYTES(%d)", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(MAX_CONTENT_SIZE_BYTES)});
        this.c = bArr;
        this.f = (zzcuxVarArr == null || zzcuxVarArr.length == 0) ? f4980a : zzcuxVarArr;
        zzbq.zzb(str2.length() <= 32, "Type length(%d) must not exceed MAX_TYPE_LENGTH(%d)", new Object[]{Integer.valueOf(str2.length()), 32});
    }

    public Message(byte[] bArr) {
        this(bArr, "", "");
    }

    public Message(byte[] bArr, String str) {
        this(bArr, "", str);
    }

    @Hide
    public Message(byte[] bArr, String str, String str2) {
        this(bArr, str, str2, f4980a);
    }

    @Hide
    private Message(byte[] bArr, String str, String str2, zzcux[] zzcuxVarArr) {
        this(bArr, str, str2, zzcuxVarArr, 0L);
    }

    @Hide
    private Message(byte[] bArr, String str, String str2, zzcux[] zzcuxVarArr, long j) {
        this(2, bArr, str, str2, zzcuxVarArr, 0L);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Message)) {
            return false;
        }
        Message message = (Message) obj;
        return TextUtils.equals(this.e, message.e) && TextUtils.equals(this.d, message.d) && Arrays.equals(this.c, message.c) && this.g == message.g;
    }

    public byte[] getContent() {
        return this.c;
    }

    public String getNamespace() {
        return this.e;
    }

    public String getType() {
        return this.d;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.e, this.d, Integer.valueOf(Arrays.hashCode(this.c)), Long.valueOf(this.g)});
    }

    public String toString() {
        String str = this.e;
        String str2 = this.d;
        byte[] bArr = this.c;
        int length = bArr == null ? 0 : bArr.length;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 59 + String.valueOf(str2).length());
        sb.append("Message{namespace='");
        sb.append(str);
        sb.append("', type='");
        sb.append(str2);
        sb.append("', content=[");
        sb.append(length);
        sb.append(" bytes]}");
        return sb.toString();
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [android.os.Parcelable[], com.google.android.gms.internal.zzcux[]] */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zza(parcel, 1, getContent(), false);
        zzbgo.zza(parcel, 2, getType(), false);
        zzbgo.zza(parcel, 3, getNamespace(), false);
        zzbgo.zza(parcel, 4, (Parcelable[]) this.f, i, false);
        zzbgo.zza(parcel, 5, this.g);
        zzbgo.zzc(parcel, 1000, this.b);
        zzbgo.zzai(parcel, zze);
    }

    @Hide
    public final boolean zzkx(String str) {
        return MESSAGE_NAMESPACE_RESERVED.equals(getNamespace()) && str.equals(getType());
    }
}
