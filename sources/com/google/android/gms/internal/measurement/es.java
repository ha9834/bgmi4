package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzz;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class es extends zzz.b {
    private final /* synthetic */ String c;
    private final /* synthetic */ String d;
    private final /* synthetic */ Context e;
    private final /* synthetic */ Bundle f;
    private final /* synthetic */ zzz g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public es(zzz zzzVar, String str, String str2, Context context, Bundle bundle) {
        super(zzzVar);
        this.g = zzzVar;
        this.c = str;
        this.d = str2;
        this.e = context;
        this.f = bundle;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0054 A[Catch: RemoteException -> 0x00a1, TryCatch #0 {RemoteException -> 0x00a1, blocks: (B:3:0x0002, B:5:0x0019, B:6:0x002a, B:11:0x003f, B:13:0x0054, B:16:0x0060, B:18:0x006e, B:22:0x0084), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0060 A[Catch: RemoteException -> 0x00a1, TryCatch #0 {RemoteException -> 0x00a1, blocks: (B:3:0x0002, B:5:0x0019, B:6:0x002a, B:11:0x003f, B:13:0x0054, B:16:0x0060, B:18:0x006e, B:22:0x0084), top: B:2:0x0002 }] */
    @Override // com.google.android.gms.internal.measurement.zzz.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            r14 = this;
            r0 = 0
            r1 = 1
            com.google.android.gms.internal.measurement.zzz r2 = r14.g     // Catch: android.os.RemoteException -> La1
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: android.os.RemoteException -> La1
            r3.<init>()     // Catch: android.os.RemoteException -> La1
            com.google.android.gms.internal.measurement.zzz.a(r2, r3)     // Catch: android.os.RemoteException -> La1
            com.google.android.gms.internal.measurement.zzz r2 = r14.g     // Catch: android.os.RemoteException -> La1
            java.lang.String r3 = r14.c     // Catch: android.os.RemoteException -> La1
            java.lang.String r4 = r14.d     // Catch: android.os.RemoteException -> La1
            boolean r2 = com.google.android.gms.internal.measurement.zzz.a(r2, r3, r4)     // Catch: android.os.RemoteException -> La1
            r3 = 0
            if (r2 == 0) goto L27
            java.lang.String r3 = r14.d     // Catch: android.os.RemoteException -> La1
            java.lang.String r2 = r14.c     // Catch: android.os.RemoteException -> La1
            com.google.android.gms.internal.measurement.zzz r4 = r14.g     // Catch: android.os.RemoteException -> La1
            java.lang.String r4 = com.google.android.gms.internal.measurement.zzz.b(r4)     // Catch: android.os.RemoteException -> La1
            r10 = r2
            r11 = r3
            r9 = r4
            goto L2a
        L27:
            r9 = r3
            r10 = r9
            r11 = r10
        L2a:
            android.content.Context r2 = r14.e     // Catch: android.os.RemoteException -> La1
            com.google.android.gms.internal.measurement.zzz.a(r2)     // Catch: android.os.RemoteException -> La1
            java.lang.Boolean r2 = com.google.android.gms.internal.measurement.zzz.a()     // Catch: android.os.RemoteException -> La1
            boolean r2 = r2.booleanValue()     // Catch: android.os.RemoteException -> La1
            if (r2 != 0) goto L3e
            if (r10 == 0) goto L3c
            goto L3e
        L3c:
            r2 = 0
            goto L3f
        L3e:
            r2 = 1
        L3f:
            com.google.android.gms.internal.measurement.zzz r3 = r14.g     // Catch: android.os.RemoteException -> La1
            com.google.android.gms.internal.measurement.zzz r4 = r14.g     // Catch: android.os.RemoteException -> La1
            android.content.Context r5 = r14.e     // Catch: android.os.RemoteException -> La1
            com.google.android.gms.internal.measurement.zzk r4 = r4.a(r5, r2)     // Catch: android.os.RemoteException -> La1
            com.google.android.gms.internal.measurement.zzz.a(r3, r4)     // Catch: android.os.RemoteException -> La1
            com.google.android.gms.internal.measurement.zzz r3 = r14.g     // Catch: android.os.RemoteException -> La1
            com.google.android.gms.internal.measurement.zzk r3 = com.google.android.gms.internal.measurement.zzz.c(r3)     // Catch: android.os.RemoteException -> La1
            if (r3 != 0) goto L60
            com.google.android.gms.internal.measurement.zzz r2 = r14.g     // Catch: android.os.RemoteException -> La1
            java.lang.String r2 = com.google.android.gms.internal.measurement.zzz.b(r2)     // Catch: android.os.RemoteException -> La1
            java.lang.String r3 = "Failed to connect to measurement client."
            android.util.Log.w(r2, r3)     // Catch: android.os.RemoteException -> La1
            return
        L60:
            android.content.Context r3 = r14.e     // Catch: android.os.RemoteException -> La1
            int r3 = com.google.android.gms.internal.measurement.zzz.b(r3)     // Catch: android.os.RemoteException -> La1
            android.content.Context r4 = r14.e     // Catch: android.os.RemoteException -> La1
            int r4 = com.google.android.gms.internal.measurement.zzz.c(r4)     // Catch: android.os.RemoteException -> La1
            if (r2 == 0) goto L79
            int r2 = java.lang.Math.max(r3, r4)     // Catch: android.os.RemoteException -> La1
            if (r4 >= r3) goto L76
            r3 = 1
            goto L77
        L76:
            r3 = 0
        L77:
            r8 = r3
            goto L84
        L79:
            if (r3 <= 0) goto L7d
            r2 = r3
            goto L7e
        L7d:
            r2 = r4
        L7e:
            if (r3 <= 0) goto L82
            r3 = 1
            goto L83
        L82:
            r3 = 0
        L83:
            r8 = r3
        L84:
            com.google.android.gms.internal.measurement.zzx r13 = new com.google.android.gms.internal.measurement.zzx     // Catch: android.os.RemoteException -> La1
            r4 = 16250(0x3f7a, double:8.0286E-320)
            long r6 = (long) r2     // Catch: android.os.RemoteException -> La1
            android.os.Bundle r12 = r14.f     // Catch: android.os.RemoteException -> La1
            r3 = r13
            r3.<init>(r4, r6, r8, r9, r10, r11, r12)     // Catch: android.os.RemoteException -> La1
            com.google.android.gms.internal.measurement.zzz r2 = r14.g     // Catch: android.os.RemoteException -> La1
            com.google.android.gms.internal.measurement.zzk r2 = com.google.android.gms.internal.measurement.zzz.c(r2)     // Catch: android.os.RemoteException -> La1
            android.content.Context r3 = r14.e     // Catch: android.os.RemoteException -> La1
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r3)     // Catch: android.os.RemoteException -> La1
            long r4 = r14.f4645a     // Catch: android.os.RemoteException -> La1
            r2.initialize(r3, r13, r4)     // Catch: android.os.RemoteException -> La1
            return
        La1:
            r2 = move-exception
            com.google.android.gms.internal.measurement.zzz r3 = r14.g
            com.google.android.gms.internal.measurement.zzz.a(r3, r2, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.es.a():void");
    }
}
