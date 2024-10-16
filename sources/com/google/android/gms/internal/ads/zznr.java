package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzpo;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class zznr {

    /* renamed from: a, reason: collision with root package name */
    private static final zzpu f3695a = new alu();
    private static final Pattern b = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int zzaty = -1;
    public int zzatz = -1;

    public final boolean zzb(zzpo zzpoVar) {
        for (int i = 0; i < zzpoVar.length(); i++) {
            zzpo.zza zzbc = zzpoVar.zzbc(i);
            if (zzbc instanceof zzps) {
                zzps zzpsVar = (zzps) zzbc;
                if (a(zzpsVar.description, zzpsVar.zzbhy)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean a(String str, String str2) {
        if (!"iTunSMPB".equals(str)) {
            return false;
        }
        Matcher matcher = b.matcher(str2);
        if (matcher.find()) {
            try {
                int parseInt = Integer.parseInt(matcher.group(1), 16);
                int parseInt2 = Integer.parseInt(matcher.group(2), 16);
                if (parseInt > 0 || parseInt2 > 0) {
                    this.zzaty = parseInt;
                    this.zzatz = parseInt2;
                    return true;
                }
            } catch (NumberFormatException unused) {
            }
        }
        return false;
    }

    public final boolean zzii() {
        return (this.zzaty == -1 || this.zzatz == -1) ? false : true;
    }
}
