package kotlin.d;

import java.util.NoSuchElementException;
import kotlin.collections.v;

/* loaded from: classes3.dex */
public final class b extends v {

    /* renamed from: a, reason: collision with root package name */
    private final int f6958a;
    private boolean b;
    private int c;
    private final int d;

    public b(int i, int i2, int i3) {
        this.d = i3;
        this.f6958a = i2;
        boolean z = true;
        if (this.d <= 0 ? i < i2 : i > i2) {
            z = false;
        }
        this.b = z;
        this.c = this.b ? i : this.f6958a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b;
    }

    @Override // kotlin.collections.v
    public int b() {
        int i = this.c;
        if (i == this.f6958a) {
            if (!this.b) {
                throw new NoSuchElementException();
            }
            this.b = false;
        } else {
            this.c = this.d + i;
        }
        return i;
    }
}
