package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzp {

    /* renamed from: a, reason: collision with root package name */
    private final long f3699a;
    public final List<zzl> allHeaders;
    public final byte[] data;
    public final int statusCode;
    public final Map<String, String> zzab;
    public final boolean zzac;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzp(int r9, byte[] r10, java.util.Map<java.lang.String, java.lang.String> r11, boolean r12, long r13) {
        /*
            r8 = this;
            if (r11 != 0) goto L5
            r0 = 0
            r4 = r0
            goto L44
        L5:
            boolean r0 = r11.isEmpty()
            if (r0 == 0) goto L11
            java.util.List r0 = java.util.Collections.emptyList()
            r4 = r0
            goto L44
        L11:
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r11.size()
            r0.<init>(r1)
            java.util.Set r1 = r11.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L22:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L43
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            com.google.android.gms.internal.ads.zzl r3 = new com.google.android.gms.internal.ads.zzl
            java.lang.Object r4 = r2.getKey()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r2 = r2.getValue()
            java.lang.String r2 = (java.lang.String) r2
            r3.<init>(r4, r2)
            r0.add(r3)
            goto L22
        L43:
            r4 = r0
        L44:
            r0 = r8
            r1 = r9
            r2 = r10
            r3 = r11
            r5 = r12
            r6 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzp.<init>(int, byte[], java.util.Map, boolean, long):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.Map] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzp(int r9, byte[] r10, boolean r11, long r12, java.util.List<com.google.android.gms.internal.ads.zzl> r14) {
        /*
            r8 = this;
            if (r14 != 0) goto L5
            r0 = 0
            r3 = r0
            goto L35
        L5:
            boolean r0 = r14.isEmpty()
            if (r0 == 0) goto L11
            java.util.Map r0 = java.util.Collections.emptyMap()
            r3 = r0
            goto L35
        L11:
            java.util.TreeMap r0 = new java.util.TreeMap
            java.util.Comparator r1 = java.lang.String.CASE_INSENSITIVE_ORDER
            r0.<init>(r1)
            java.util.Iterator r1 = r14.iterator()
        L1c:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L34
            java.lang.Object r2 = r1.next()
            com.google.android.gms.internal.ads.zzl r2 = (com.google.android.gms.internal.ads.zzl) r2
            java.lang.String r3 = r2.getName()
            java.lang.String r2 = r2.getValue()
            r0.put(r3, r2)
            goto L1c
        L34:
            r3 = r0
        L35:
            r0 = r8
            r1 = r9
            r2 = r10
            r4 = r14
            r5 = r11
            r6 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzp.<init>(int, byte[], boolean, long, java.util.List):void");
    }

    @Deprecated
    public zzp(byte[] bArr, Map<String, String> map) {
        this(200, bArr, map, false, 0L);
    }

    private zzp(int i, byte[] bArr, Map<String, String> map, List<zzl> list, boolean z, long j) {
        this.statusCode = i;
        this.data = bArr;
        this.zzab = map;
        if (list == null) {
            this.allHeaders = null;
        } else {
            this.allHeaders = Collections.unmodifiableList(list);
        }
        this.zzac = z;
        this.f3699a = j;
    }
}
