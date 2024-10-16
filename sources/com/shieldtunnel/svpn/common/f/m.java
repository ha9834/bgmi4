package com.shieldtunnel.svpn.common.f;

import android.text.TextUtils;
import com.shieldtunnel.svpn.common.f.k;

/* loaded from: classes2.dex */
public class m extends n {
    private final com.shieldtunnel.svpn.common.jni.b f;

    m(k.b bVar, com.shieldtunnel.svpn.common.jni.b bVar2) {
        super(bVar);
        this.f = bVar2;
    }

    public static void a(k.b bVar, com.shieldtunnel.svpn.common.jni.b bVar2) {
        n.a((n) new m(bVar, bVar2));
    }

    private void d(String str) {
        for (String str2 : str.split(",")) {
            String trim = str2.trim();
            if (trim.length() > 0) {
                this.f.a(trim);
            }
        }
    }

    @Override // com.shieldtunnel.svpn.common.f.k
    protected String i() {
        return "general";
    }

    @Override // com.shieldtunnel.svpn.common.f.k
    protected String l() {
        return "configs/general";
    }

    @Override // com.shieldtunnel.svpn.common.f.n
    protected void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if ("__direct_domain".equals(str)) {
            d(str2);
        } else {
            this.f.a(str, str2);
        }
    }
}
