package com.subao.common.f;

import android.content.Context;
import com.subao.common.e.r;
import java.io.File;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static File f6016a;

    public static File a(Context context, r.a aVar) {
        if (aVar == r.a.SDK || aVar == r.a.ROM) {
            f6016a = context.getDir("cn.wsds.sdk.game.data", 0);
        } else {
            f6016a = context.getFilesDir();
        }
        return f6016a;
    }

    public static File a() {
        return f6016a;
    }

    public static File a(String str) {
        return new File(f6016a, str);
    }
}
