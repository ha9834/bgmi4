package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.ConditionVariable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class alh extends Thread {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AudioTrack f1952a;
    private final /* synthetic */ zzmh b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public alh(zzmh zzmhVar, AudioTrack audioTrack) {
        this.b = zzmhVar;
        this.f1952a = audioTrack;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        ConditionVariable conditionVariable;
        try {
            this.f1952a.flush();
            this.f1952a.release();
        } finally {
            conditionVariable = this.b.h;
            conditionVariable.open();
        }
    }
}
