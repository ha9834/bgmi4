package com.shieldtunnel.svpn.common.f;

import android.util.Log;
import com.shieldtunnel.svpn.common.LogTag;
import com.shieldtunnel.svpn.common.f.k;
import com.shieldtunnel.svpn.common.i.a;
import com.shieldtunnel.svpn.common.k.b;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

/* loaded from: classes2.dex */
class o extends k {
    private final int f;

    o(k.b bVar, int i) {
        super(bVar);
        this.f = i;
    }

    public static l a(k.b bVar, int i) {
        o oVar = new o(bVar, i);
        l n = oVar.n();
        l lVar = null;
        if (n != null) {
            if (!e(n)) {
                if (!oVar.f(n)) {
                    oVar.d();
                    n = null;
                }
            }
            oVar.b(n);
            return lVar;
        }
        lVar = n;
        oVar.b(n);
        return lVar;
    }

    private static boolean c(l lVar, boolean z) {
        byte[] b = lVar.b();
        if (b == null) {
            if (z) {
                Log.d(LogTag.DATA, "Script is null");
            }
            return false;
        }
        String a2 = lVar.a();
        if (a2 == null || a2.length() != 66) {
            if (z) {
                Locale locale = f.f5810a;
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(a2 == null ? -1 : a2.length());
                Log.d(LogTag.DATA, String.format(locale, "Invalid script digest (len=%d)", objArr));
            }
            return false;
        }
        try {
            byte[] a3 = com.shieldtunnel.svpn.common.k.b.a(b.a.SHA_256, b);
            boolean regionMatches = a2.regionMatches(true, 1, com.shieldtunnel.svpn.common.k.e.a(a3, false), 0, a3.length);
            if (z) {
                if (regionMatches) {
                    Log.d(LogTag.DATA, "Script check ok");
                } else {
                    Log.d(LogTag.DATA, "Script digest is not expected");
                }
            }
            return regionMatches;
        } catch (NoSuchAlgorithmException unused) {
            if (z) {
                Log.d(LogTag.DATA, "Digest calc failed");
            }
            return false;
        }
    }

    static boolean e(l lVar) {
        byte[] b;
        return lVar == null || (b = lVar.b()) == null || b.length <= 4;
    }

    @Override // com.shieldtunnel.svpn.common.f.k
    protected String e() {
        return "v2";
    }

    boolean f(l lVar) {
        boolean a2 = com.shieldtunnel.svpn.common.b.a(LogTag.DATA);
        if (lVar == null) {
            if (a2) {
                Log.d(LogTag.DATA, "PortalData of script is null");
            }
            return false;
        }
        if (c(lVar)) {
            return c(lVar, a2);
        }
        if (a2) {
            Log.d(LogTag.DATA, "Invalid script version");
        }
        return false;
    }

    @Override // com.shieldtunnel.svpn.common.f.k
    protected String g() {
        return a.EnumC0156a.ANY.f5839a;
    }

    @Override // com.shieldtunnel.svpn.common.f.k
    protected String i() {
        return "scripts_" + this.f;
    }

    @Override // com.shieldtunnel.svpn.common.f.k
    protected String l() {
        return String.format(f.b, "scripts/%d/%s", Integer.valueOf(this.f), f().b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.shieldtunnel.svpn.common.f.k
    public boolean a(l lVar) {
        if (super.a(lVar)) {
            return e(lVar) || f(lVar);
        }
        return false;
    }
}
