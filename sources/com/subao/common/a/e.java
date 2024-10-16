package com.subao.common.a;

import android.content.Context;
import android.net.VpnService;

/* loaded from: classes2.dex */
public abstract class e extends VpnService {

    /* loaded from: classes2.dex */
    public interface a {
        e a();

        boolean a(Context context);
    }

    public abstract int a(Iterable<String> iterable);

    public abstract void a();

    public abstract boolean b();
}
