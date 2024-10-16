package com.google.android.gms.tagmanager;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.gtm.zzdj;
import com.google.android.gms.tagmanager.ContainerHolder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class en extends zzdj {

    /* renamed from: a, reason: collision with root package name */
    private final ContainerHolder.ContainerAvailableListener f5141a;
    private final /* synthetic */ em b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public en(em emVar, ContainerHolder.ContainerAvailableListener containerAvailableListener, Looper looper) {
        super(looper);
        this.b = emVar;
        this.f5141a = containerAvailableListener;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (message.what == 1) {
            this.f5141a.onContainerAvailable(this.b, (String) message.obj);
        } else {
            zzdi.zzav("Don't know how to handle this message.");
        }
    }
}
