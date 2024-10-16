package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzz;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class u extends zzz.b {
    private final /* synthetic */ com.google.android.gms.measurement.internal.zzgn c;
    private final /* synthetic */ zzz d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(zzz zzzVar, com.google.android.gms.measurement.internal.zzgn zzgnVar) {
        super(zzzVar);
        this.d = zzzVar;
        this.c = zzgnVar;
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x000b */
    @Override // com.google.android.gms.internal.measurement.zzz.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final void a() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 0
        L1:
            com.google.android.gms.internal.measurement.zzz r1 = r4.d
            java.util.List r1 = com.google.android.gms.internal.measurement.zzz.d(r1)
            int r1 = r1.size()
            if (r0 >= r1) goto L32
            com.google.android.gms.measurement.internal.zzgn r1 = r4.c
            com.google.android.gms.internal.measurement.zzz r2 = r4.d
            java.util.List r2 = com.google.android.gms.internal.measurement.zzz.d(r2)
            java.lang.Object r2 = r2.get(r0)
            android.util.Pair r2 = (android.util.Pair) r2
            java.lang.Object r2 = r2.first
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L2f
            com.google.android.gms.internal.measurement.zzz r0 = r4.d
            java.lang.String r0 = com.google.android.gms.internal.measurement.zzz.b(r0)
            java.lang.String r1 = "OnEventListener already registered."
            android.util.Log.w(r0, r1)
            return
        L2f:
            int r0 = r0 + 1
            goto L1
        L32:
            com.google.android.gms.internal.measurement.zzz$d r0 = new com.google.android.gms.internal.measurement.zzz$d
            com.google.android.gms.measurement.internal.zzgn r1 = r4.c
            r0.<init>(r1)
            com.google.android.gms.internal.measurement.zzz r1 = r4.d
            java.util.List r1 = com.google.android.gms.internal.measurement.zzz.d(r1)
            android.util.Pair r2 = new android.util.Pair
            com.google.android.gms.measurement.internal.zzgn r3 = r4.c
            r2.<init>(r3, r0)
            r1.add(r2)
            com.google.android.gms.internal.measurement.zzz r1 = r4.d
            com.google.android.gms.internal.measurement.zzk r1 = com.google.android.gms.internal.measurement.zzz.c(r1)
            r1.registerOnMeasurementEventListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.u.a():void");
    }
}
