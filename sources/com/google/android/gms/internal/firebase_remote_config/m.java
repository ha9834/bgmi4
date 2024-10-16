package com.google.android.gms.internal.firebase_remote_config;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class m implements Iterator<Map.Entry<String, Object>> {

    /* renamed from: a, reason: collision with root package name */
    private int f4102a = -1;
    private zzbz b;
    private Object c;
    private boolean d;
    private boolean e;
    private zzbz f;
    private final /* synthetic */ l g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.g = lVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (!this.e) {
            this.e = true;
            this.c = null;
            while (this.c == null) {
                int i = this.f4102a + 1;
                this.f4102a = i;
                if (i >= this.g.b.f4136a.size()) {
                    break;
                }
                this.b = this.g.b.zzae(this.g.b.f4136a.get(this.f4102a));
                this.c = this.b.zzh(this.g.f4101a);
            }
        }
        return this.c != null;
    }

    @Override // java.util.Iterator
    public final void remove() {
        zzdt.checkState((this.f == null || this.d) ? false : true);
        this.d = true;
        this.f.zzb(this.g.f4101a, null);
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Map.Entry<String, Object> next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f = this.b;
        Object obj = this.c;
        this.e = false;
        this.d = false;
        this.b = null;
        this.c = null;
        return new n(this.g, this.f, obj);
    }
}
