package androidx.recyclerview.widget;

import android.view.View;

/* loaded from: classes.dex */
class m {

    /* renamed from: a, reason: collision with root package name */
    final b f905a;
    a b = new a();

    /* loaded from: classes.dex */
    interface b {
        int a();

        int a(View view);

        View a(int i);

        int b();

        int b(View view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(b bVar) {
        this.f905a = bVar;
    }

    /* loaded from: classes.dex */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        int f906a = 0;
        int b;
        int c;
        int d;
        int e;

        int a(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }

        a() {
        }

        void a(int i, int i2, int i3, int i4) {
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }

        void a(int i) {
            this.f906a = i | this.f906a;
        }

        void a() {
            this.f906a = 0;
        }

        boolean b() {
            int i = this.f906a;
            if ((i & 7) != 0 && (i & (a(this.d, this.b) << 0)) == 0) {
                return false;
            }
            int i2 = this.f906a;
            if ((i2 & 112) != 0 && (i2 & (a(this.d, this.c) << 4)) == 0) {
                return false;
            }
            int i3 = this.f906a;
            if ((i3 & 1792) != 0 && (i3 & (a(this.e, this.b) << 8)) == 0) {
                return false;
            }
            int i4 = this.f906a;
            return (i4 & 28672) == 0 || (i4 & (a(this.e, this.c) << 12)) != 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View a(int i, int i2, int i3, int i4) {
        int a2 = this.f905a.a();
        int b2 = this.f905a.b();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View a3 = this.f905a.a(i);
            this.b.a(a2, b2, this.f905a.a(a3), this.f905a.b(a3));
            if (i3 != 0) {
                this.b.a();
                this.b.a(i3);
                if (this.b.b()) {
                    return a3;
                }
            }
            if (i4 != 0) {
                this.b.a();
                this.b.a(i4);
                if (this.b.b()) {
                    view = a3;
                }
            }
            i += i5;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(View view, int i) {
        this.b.a(this.f905a.a(), this.f905a.b(), this.f905a.a(view), this.f905a.b(view));
        if (i == 0) {
            return false;
        }
        this.b.a();
        this.b.a(i);
        return this.b.b();
    }
}
