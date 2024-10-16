package androidx.appcompat.widget;

import com.google.android.gms.nearby.messages.BleSignal;

/* loaded from: classes.dex */
class am {

    /* renamed from: a, reason: collision with root package name */
    private int f326a = 0;
    private int b = 0;
    private int c = BleSignal.UNKNOWN_TX_POWER;
    private int d = BleSignal.UNKNOWN_TX_POWER;
    private int e = 0;
    private int f = 0;
    private boolean g = false;
    private boolean h = false;

    public int a() {
        return this.f326a;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.g ? this.b : this.f326a;
    }

    public int d() {
        return this.g ? this.f326a : this.b;
    }

    public void a(int i, int i2) {
        this.c = i;
        this.d = i2;
        this.h = true;
        if (this.g) {
            if (i2 != Integer.MIN_VALUE) {
                this.f326a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f326a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.b = i2;
        }
    }

    public void b(int i, int i2) {
        this.h = false;
        if (i != Integer.MIN_VALUE) {
            this.e = i;
            this.f326a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f = i2;
            this.b = i2;
        }
    }

    public void a(boolean z) {
        if (z == this.g) {
            return;
        }
        this.g = z;
        if (!this.h) {
            this.f326a = this.e;
            this.b = this.f;
            return;
        }
        if (z) {
            int i = this.d;
            if (i == Integer.MIN_VALUE) {
                i = this.e;
            }
            this.f326a = i;
            int i2 = this.c;
            if (i2 == Integer.MIN_VALUE) {
                i2 = this.f;
            }
            this.b = i2;
            return;
        }
        int i3 = this.c;
        if (i3 == Integer.MIN_VALUE) {
            i3 = this.e;
        }
        this.f326a = i3;
        int i4 = this.d;
        if (i4 == Integer.MIN_VALUE) {
            i4 = this.f;
        }
        this.b = i4;
    }
}
