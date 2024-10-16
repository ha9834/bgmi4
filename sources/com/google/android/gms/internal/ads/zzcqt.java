package com.google.android.gms.internal.ads;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes2.dex */
public class zzcqt {

    /* renamed from: a, reason: collision with root package name */
    private String f3381a;

    /* loaded from: classes2.dex */
    public static class zza {

        /* renamed from: a, reason: collision with root package name */
        private String f3382a;

        public final zza zzfs(String str) {
            this.f3382a = str;
            return this;
        }
    }

    private zzcqt(zza zzaVar) {
        this.f3381a = zzaVar.f3382a;
    }

    public final Set<String> zzalj() {
        HashSet hashSet = new HashSet();
        hashSet.add(this.f3381a.toLowerCase(Locale.ROOT));
        return hashSet;
    }

    public final String zzalk() {
        return this.f3381a.toLowerCase(Locale.ROOT);
    }

    public final int zzall() {
        char c;
        String str = this.f3381a;
        int hashCode = str.hashCode();
        if (hashCode == -1999289321) {
            if (str.equals("NATIVE")) {
                c = 2;
            }
            c = 65535;
        } else if (hashCode == -1372958932) {
            if (str.equals("INTERSTITIAL")) {
                c = 1;
            }
            c = 65535;
        } else if (hashCode != 543046670) {
            if (hashCode == 1951953708 && str.equals("BANNER")) {
                c = 0;
            }
            c = 65535;
        } else {
            if (str.equals("REWARDED")) {
                c = 3;
            }
            c = 65535;
        }
        switch (c) {
            case 0:
                return 1;
            case 1:
                return 3;
            case 2:
                return 6;
            case 3:
                return 7;
            default:
                return 0;
        }
    }
}
