package com.google.android.gms.internal.ads;

import com.google.android.gms.nearby.messages.BleSignal;

/* loaded from: classes2.dex */
public class zzmy {

    /* renamed from: a, reason: collision with root package name */
    private int f3687a;

    public void clear() {
        this.f3687a = 0;
    }

    public final boolean zzib() {
        return a(BleSignal.UNKNOWN_TX_POWER);
    }

    public final boolean zzic() {
        return a(4);
    }

    public final boolean zzid() {
        return a(1);
    }

    public final void setFlags(int i) {
        this.f3687a = i;
    }

    public final void zzal(int i) {
        this.f3687a |= BleSignal.UNKNOWN_TX_POWER;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean a(int i) {
        return (this.f3687a & i) == i;
    }
}
