package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.util.concurrent.NumberedThreadFactory;
import com.google.android.gms.internal.base.zam;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public final class zabh {

    /* renamed from: a, reason: collision with root package name */
    private static final ExecutorService f1391a = zam.zacv().zaa(2, new NumberedThreadFactory("GAC_Executor"), 9);

    public static ExecutorService zabb() {
        return f1391a;
    }
}
