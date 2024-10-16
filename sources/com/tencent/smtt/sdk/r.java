package com.tencent.smtt.sdk;

import android.content.Context;
import java.nio.channels.FileLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    private static r f6533a;
    private static FileLock b;

    public static boolean b() {
        return false;
    }

    public s a(boolean z) {
        return null;
    }

    public s c() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return true;
    }

    private r() {
    }

    public static r a() {
        if (f6533a == null) {
            synchronized (r.class) {
                if (f6533a == null) {
                    f6533a = new r();
                }
            }
        }
        return f6533a;
    }

    public synchronized void a(Context context, i iVar) {
    }
}
