package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* loaded from: classes2.dex */
public final class zzl {

    /* renamed from: a, reason: collision with root package name */
    private final String f3677a;
    private final String b;

    public zzl(String str, String str2) {
        this.f3677a = str;
        this.b = str2;
    }

    public final String getName() {
        return this.f3677a;
    }

    public final String getValue() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzl zzlVar = (zzl) obj;
        return TextUtils.equals(this.f3677a, zzlVar.f3677a) && TextUtils.equals(this.b, zzlVar.b);
    }

    public final int hashCode() {
        return (this.f3677a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        String str = this.f3677a;
        String str2 = this.b;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 20 + String.valueOf(str2).length());
        sb.append("Header[name=");
        sb.append(str);
        sb.append(",value=");
        sb.append(str2);
        sb.append("]");
        return sb.toString();
    }
}
