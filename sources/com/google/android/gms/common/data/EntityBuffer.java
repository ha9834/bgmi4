package com.google.android.gms.common.data;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.ArrayList;

@KeepForSdk
/* loaded from: classes.dex */
public abstract class EntityBuffer<T> extends AbstractDataBuffer<T> {
    private boolean b;
    private ArrayList<Integer> c;

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public EntityBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.b = false;
    }

    @KeepForSdk
    protected abstract T a(int i, int i2);

    @KeepForSdk
    protected abstract String a();

    @KeepForSdk
    protected String b() {
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0064, code lost:
    
        if (r6.f1413a.getString(r4, r7, r3) == null) goto L18;
     */
    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    @com.google.android.gms.common.annotation.KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final T get(int r7) {
        /*
            r6 = this;
            r6.c()
            int r0 = r6.a(r7)
            r1 = 0
            if (r7 < 0) goto L68
            java.util.ArrayList<java.lang.Integer> r2 = r6.c
            int r2 = r2.size()
            if (r7 != r2) goto L13
            goto L68
        L13:
            java.util.ArrayList<java.lang.Integer> r2 = r6.c
            int r2 = r2.size()
            r3 = 1
            int r2 = r2 - r3
            if (r7 != r2) goto L31
            com.google.android.gms.common.data.DataHolder r2 = r6.f1413a
            int r2 = r2.getCount()
            java.util.ArrayList<java.lang.Integer> r4 = r6.c
            java.lang.Object r4 = r4.get(r7)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            int r2 = r2 - r4
            goto L4c
        L31:
            java.util.ArrayList<java.lang.Integer> r2 = r6.c
            int r4 = r7 + 1
            java.lang.Object r2 = r2.get(r4)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            java.util.ArrayList<java.lang.Integer> r4 = r6.c
            java.lang.Object r4 = r4.get(r7)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            int r2 = r2 - r4
        L4c:
            if (r2 != r3) goto L67
            int r7 = r6.a(r7)
            com.google.android.gms.common.data.DataHolder r3 = r6.f1413a
            int r3 = r3.getWindowIndex(r7)
            java.lang.String r4 = r6.b()
            if (r4 == 0) goto L67
            com.google.android.gms.common.data.DataHolder r5 = r6.f1413a
            java.lang.String r7 = r5.getString(r4, r7, r3)
            if (r7 != 0) goto L67
            goto L68
        L67:
            r1 = r2
        L68:
            java.lang.Object r7 = r6.a(r0, r1)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.data.EntityBuffer.get(int):java.lang.Object");
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    @KeepForSdk
    public int getCount() {
        c();
        return this.c.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void c() {
        synchronized (this) {
            if (!this.b) {
                int count = this.f1413a.getCount();
                this.c = new ArrayList<>();
                if (count > 0) {
                    this.c.add(0);
                    String a2 = a();
                    String string = this.f1413a.getString(a2, 0, this.f1413a.getWindowIndex(0));
                    for (int i = 1; i < count; i++) {
                        int windowIndex = this.f1413a.getWindowIndex(i);
                        String string2 = this.f1413a.getString(a2, i, windowIndex);
                        if (string2 == null) {
                            StringBuilder sb = new StringBuilder(String.valueOf(a2).length() + 78);
                            sb.append("Missing value for markerColumn: ");
                            sb.append(a2);
                            sb.append(", at row: ");
                            sb.append(i);
                            sb.append(", for window: ");
                            sb.append(windowIndex);
                            throw new NullPointerException(sb.toString());
                        }
                        if (!string2.equals(string)) {
                            this.c.add(Integer.valueOf(i));
                            string = string2;
                        }
                    }
                }
                this.b = true;
            }
        }
    }

    private final int a(int i) {
        if (i < 0 || i >= this.c.size()) {
            StringBuilder sb = new StringBuilder(53);
            sb.append("Position ");
            sb.append(i);
            sb.append(" is out of bounds for this buffer");
            throw new IllegalArgumentException(sb.toString());
        }
        return this.c.get(i).intValue();
    }
}
