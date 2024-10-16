package com.google.android.gms.tagmanager;

import java.util.Arrays;

/* loaded from: classes2.dex */
final class v {

    /* renamed from: a, reason: collision with root package name */
    final String f5154a;
    final byte[] b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(String str, byte[] bArr) {
        this.f5154a = str;
        this.b = bArr;
    }

    public final String toString() {
        String str = this.f5154a;
        int hashCode = Arrays.hashCode(this.b);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 54);
        sb.append("KeyAndSerialized: key = ");
        sb.append(str);
        sb.append(" serialized hash = ");
        sb.append(hashCode);
        return sb.toString();
    }
}
