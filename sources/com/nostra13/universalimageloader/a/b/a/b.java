package com.nostra13.universalimageloader.a.b.a;

import android.graphics.Bitmap;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;

/* loaded from: classes2.dex */
public class b implements com.nostra13.universalimageloader.a.b.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinkedHashMap<String, Bitmap> f5715a;
    private final int b;
    private int c;

    public b(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.b = i;
        this.f5715a = new LinkedHashMap<>(0, 0.75f, true);
    }

    @Override // com.nostra13.universalimageloader.a.b.a
    public final Bitmap a(String str) {
        Bitmap bitmap;
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            bitmap = this.f5715a.get(str);
        }
        return bitmap;
    }

    @Override // com.nostra13.universalimageloader.a.b.a
    public final boolean a(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.c += b(str, bitmap);
            Bitmap put = this.f5715a.put(str, bitmap);
            if (put != null) {
                this.c -= b(str, put);
            }
        }
        a(this.b);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x006e, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(int r4) {
        /*
            r3 = this;
        L0:
            monitor-enter(r3)
            int r0 = r3.c     // Catch: java.lang.Throwable -> L6f
            if (r0 < 0) goto L50
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.f5715a     // Catch: java.lang.Throwable -> L6f
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L6f
            if (r0 == 0) goto L11
            int r0 = r3.c     // Catch: java.lang.Throwable -> L6f
            if (r0 != 0) goto L50
        L11:
            int r0 = r3.c     // Catch: java.lang.Throwable -> L6f
            if (r0 <= r4) goto L4e
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.f5715a     // Catch: java.lang.Throwable -> L6f
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L6f
            if (r0 == 0) goto L1e
            goto L4e
        L1e:
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.f5715a     // Catch: java.lang.Throwable -> L6f
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L6f
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L6f
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L6f
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L6f
            if (r0 != 0) goto L32
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L6f
            goto L4f
        L32:
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L6f
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L6f
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L6f
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0     // Catch: java.lang.Throwable -> L6f
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r2 = r3.f5715a     // Catch: java.lang.Throwable -> L6f
            r2.remove(r1)     // Catch: java.lang.Throwable -> L6f
            int r2 = r3.c     // Catch: java.lang.Throwable -> L6f
            int r0 = r3.b(r1, r0)     // Catch: java.lang.Throwable -> L6f
            int r2 = r2 - r0
            r3.c = r2     // Catch: java.lang.Throwable -> L6f
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L6f
            goto L0
        L4e:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L6f
        L4f:
            return
        L50:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L6f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6f
            r0.<init>()     // Catch: java.lang.Throwable -> L6f
            java.lang.Class r1 = r3.getClass()     // Catch: java.lang.Throwable -> L6f
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L6f
            r0.append(r1)     // Catch: java.lang.Throwable -> L6f
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            r0.append(r1)     // Catch: java.lang.Throwable -> L6f
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L6f
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L6f
            throw r4     // Catch: java.lang.Throwable -> L6f
        L6f:
            r4 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L6f
            throw r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nostra13.universalimageloader.a.b.a.b.a(int):void");
    }

    @Override // com.nostra13.universalimageloader.a.b.a
    public final Bitmap b(String str) {
        Bitmap remove;
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            remove = this.f5715a.remove(str);
            if (remove != null) {
                this.c -= b(str, remove);
            }
        }
        return remove;
    }

    @Override // com.nostra13.universalimageloader.a.b.a
    public Collection<String> a() {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.f5715a.keySet());
        }
        return hashSet;
    }

    @Override // com.nostra13.universalimageloader.a.b.a
    public void b() {
        a(-1);
    }

    private int b(String str, Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    public final synchronized String toString() {
        return String.format("LruCache[maxSize=%d]", Integer.valueOf(this.b));
    }
}
