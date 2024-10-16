package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;
import javax.annotation.ParametersAreNonnullByDefault;

@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzuo {

    /* renamed from: a, reason: collision with root package name */
    private final int f3751a;
    private final int b;
    private final int c;
    private final boolean d;
    private final zzvb e;
    private final zzvk f;
    private int n;
    private final Object g = new Object();
    private ArrayList<String> h = new ArrayList<>();
    private ArrayList<String> i = new ArrayList<>();
    private ArrayList<zzuz> j = new ArrayList<>();
    private int k = 0;
    private int l = 0;
    private int m = 0;
    private String o = "";
    private String p = "";
    private String q = "";

    public zzuo(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        this.f3751a = i;
        this.b = i2;
        this.c = i3;
        this.d = z;
        this.e = new zzvb(i4);
        this.f = new zzvk(i5, i6, i7);
    }

    public final boolean zzml() {
        boolean z;
        synchronized (this.g) {
            z = this.m == 0;
        }
        return z;
    }

    public final String zzmm() {
        return this.o;
    }

    public final String zzmn() {
        return this.p;
    }

    public final String zzmo() {
        return this.q;
    }

    public final void zzmp() {
        synchronized (this.g) {
            this.n -= 100;
        }
    }

    public final void zzmq() {
        synchronized (this.g) {
            this.m--;
        }
    }

    public final void zzmr() {
        synchronized (this.g) {
            this.m++;
        }
    }

    public final void zza(String str, boolean z, float f, float f2, float f3, float f4) {
        a(str, z, f, f2, f3, f4);
        synchronized (this.g) {
            if (this.m < 0) {
                zzawz.zzdp("ActivityContent: negative number of WebViews.");
            }
            zzmt();
        }
    }

    public final void zzb(String str, boolean z, float f, float f2, float f3, float f4) {
        a(str, z, f, f2, f3, f4);
    }

    private final void a(String str, boolean z, float f, float f2, float f3, float f4) {
        if (str == null || str.length() < this.c) {
            return;
        }
        synchronized (this.g) {
            this.h.add(str);
            this.k += str.length();
            if (z) {
                this.i.add(str);
                this.j.add(new zzuz(f, f2, f3, f4, this.i.size() - 1));
            }
        }
    }

    public final void zzms() {
        synchronized (this.g) {
            int a2 = a(this.k, this.l);
            if (a2 > this.n) {
                this.n = a2;
            }
        }
    }

    public final void zzmt() {
        synchronized (this.g) {
            int a2 = a(this.k, this.l);
            if (a2 > this.n) {
                this.n = a2;
                if (!zzk.zzlk().zzvc().zzvl()) {
                    this.o = this.e.zza(this.h);
                    this.p = this.e.zza(this.i);
                }
                if (!zzk.zzlk().zzvc().zzvn()) {
                    this.q = this.f.zza(this.i, this.j);
                }
            }
        }
    }

    @VisibleForTesting
    private final int a(int i, int i2) {
        if (this.d) {
            return this.b;
        }
        return (i * this.f3751a) + (i2 * this.b);
    }

    public final int getScore() {
        return this.n;
    }

    public final void zzbw(int i) {
        this.l = i;
    }

    private static String a(ArrayList<String> arrayList, int i) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        ArrayList<String> arrayList2 = arrayList;
        int size = arrayList2.size();
        int i2 = 0;
        while (i2 < size) {
            String str = arrayList2.get(i2);
            i2++;
            sb.append(str);
            sb.append(' ');
            if (sb.length() > 100) {
                break;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        String sb2 = sb.toString();
        return sb2.length() < 100 ? sb2 : sb2.substring(0, 100);
    }

    public final String toString() {
        int i = this.l;
        int i2 = this.n;
        int i3 = this.k;
        String a2 = a(this.h, 100);
        String a3 = a(this.i, 100);
        String str = this.o;
        String str2 = this.p;
        String str3 = this.q;
        StringBuilder sb = new StringBuilder(String.valueOf(a2).length() + TbsListener.ErrorCode.STARTDOWNLOAD_6 + String.valueOf(a3).length() + String.valueOf(str).length() + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append("ActivityContent fetchId: ");
        sb.append(i);
        sb.append(" score:");
        sb.append(i2);
        sb.append(" total_length:");
        sb.append(i3);
        sb.append("\n text: ");
        sb.append(a2);
        sb.append("\n viewableText");
        sb.append(a3);
        sb.append("\n signture: ");
        sb.append(str);
        sb.append("\n viewableSignture: ");
        sb.append(str2);
        sb.append("\n viewableSignatureForVertical: ");
        sb.append(str3);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final int a() {
        return this.k;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzuo)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        String str = ((zzuo) obj).o;
        return str != null && str.equals(this.o);
    }

    public final int hashCode() {
        return this.o.hashCode();
    }
}
