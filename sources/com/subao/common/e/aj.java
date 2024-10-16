package com.subao.common.e;

import android.util.Log;
import com.subao.common.e.ad;
import com.subao.common.j.b;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes2.dex */
class aj extends ad {

    /* renamed from: a, reason: collision with root package name */
    private final int f5965a;

    aj(ad.a aVar, int i) {
        super(aVar);
        this.f5965a = i;
    }

    public static ae a(ad.a aVar, int i) {
        aj ajVar = new aj(aVar, i);
        ae k = ajVar.k();
        ae aeVar = null;
        if (k != null) {
            if (!b(k)) {
                if (!ajVar.f(k)) {
                    ajVar.l();
                    k = null;
                }
            }
            ajVar.e(k);
            return aeVar;
        }
        aeVar = k;
        ajVar.e(k);
        return aeVar;
    }

    static boolean b(ae aeVar) {
        byte[] a2;
        return aeVar == null || (a2 = aeVar.a()) == null || a2.length <= 4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.subao.common.e.ad
    public boolean c(ae aeVar) {
        if (super.c(aeVar)) {
            return b(aeVar) || f(aeVar);
        }
        return false;
    }

    @Override // com.subao.common.e.ad
    protected String b() {
        return "scripts_" + this.f5965a;
    }

    @Override // com.subao.common.e.ad
    protected String a() {
        return String.format(r.f6001a, "scripts/%d/%s", Integer.valueOf(this.f5965a), m().b);
    }

    @Override // com.subao.common.e.ad
    protected String j() {
        return b.a.ANY.e;
    }

    boolean f(ae aeVar) {
        boolean a2 = com.subao.common.d.a("SubaoData");
        if (aeVar == null) {
            if (a2) {
                Log.d("SubaoData", "PortalData of script is null");
            }
            return false;
        }
        if (!d(aeVar)) {
            if (a2) {
                Log.d("SubaoData", "Invalid script version");
            }
            return false;
        }
        byte[] a3 = aeVar.a();
        if (a3 == null) {
            if (a2) {
                Log.d("SubaoData", "Script is null");
            }
            return false;
        }
        String c = aeVar.c();
        if (c == null || c.length() != 34) {
            if (a2) {
                Log.d("SubaoData", "Invalid script digest");
            }
            return false;
        }
        try {
            boolean equalsIgnoreCase = c.substring(1, c.length() - 1).equalsIgnoreCase(com.subao.common.n.h.a(com.subao.common.n.b.a(a3), false));
            if (a2) {
                if (equalsIgnoreCase) {
                    Log.d("SubaoData", "Script check ok");
                } else {
                    Log.d("SubaoData", "Script digest is not expected");
                }
            }
            return equalsIgnoreCase;
        } catch (NoSuchAlgorithmException unused) {
            if (a2) {
                Log.d("SubaoData", "Digest calc failed");
            }
            return false;
        }
    }
}
