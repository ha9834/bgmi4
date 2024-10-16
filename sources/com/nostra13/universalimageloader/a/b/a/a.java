package com.nostra13.universalimageloader.a.b.a;

import android.graphics.Bitmap;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class a implements com.nostra13.universalimageloader.a.b.a {

    /* renamed from: a, reason: collision with root package name */
    private final com.nostra13.universalimageloader.a.b.a f5714a;
    private final Comparator<String> b;

    public a(com.nostra13.universalimageloader.a.b.a aVar, Comparator<String> comparator) {
        this.f5714a = aVar;
        this.b = comparator;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.a.b.a
    public boolean a(String str, Bitmap bitmap) {
        synchronized (this.f5714a) {
            String str2 = null;
            Iterator<String> it = this.f5714a.a().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (this.b.compare(str, next) == 0) {
                    str2 = next;
                    break;
                }
            }
            if (str2 != null) {
                this.f5714a.b(str2);
            }
        }
        return this.f5714a.a(str, bitmap);
    }

    @Override // com.nostra13.universalimageloader.a.b.a
    public Bitmap a(String str) {
        return this.f5714a.a(str);
    }

    @Override // com.nostra13.universalimageloader.a.b.a
    public Bitmap b(String str) {
        return this.f5714a.b(str);
    }

    @Override // com.nostra13.universalimageloader.a.b.a
    public void b() {
        this.f5714a.b();
    }

    @Override // com.nostra13.universalimageloader.a.b.a
    public Collection<String> a() {
        return this.f5714a.a();
    }
}
