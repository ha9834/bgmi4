package androidx.recyclerview.widget;

import androidx.core.e.d;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.helpshift.analytics.AnalyticsEventKey;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements h.a {

    /* renamed from: a, reason: collision with root package name */
    final ArrayList<b> f876a;
    final ArrayList<b> b;
    final InterfaceC0065a c;
    Runnable d;
    final boolean e;
    final h f;
    private d.a<b> g;
    private int h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.recyclerview.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0065a {
        RecyclerView.w a(int i);

        void a(int i, int i2);

        void a(int i, int i2, Object obj);

        void a(b bVar);

        void b(int i, int i2);

        void b(b bVar);

        void c(int i, int i2);

        void d(int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(InterfaceC0065a interfaceC0065a) {
        this(interfaceC0065a, false);
    }

    a(InterfaceC0065a interfaceC0065a, boolean z) {
        this.g = new d.b(30);
        this.f876a = new ArrayList<>();
        this.b = new ArrayList<>();
        this.h = 0;
        this.c = interfaceC0065a;
        this.e = z;
        this.f = new h(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        a(this.f876a);
        a(this.b);
        this.h = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0021. Please report as an issue. */
    public void b() {
        this.f.a(this.f876a);
        int size = this.f876a.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.f876a.get(i);
            int i2 = bVar.f877a;
            if (i2 == 4) {
                d(bVar);
            } else if (i2 != 8) {
                switch (i2) {
                    case 1:
                        f(bVar);
                        break;
                    case 2:
                        c(bVar);
                        break;
                }
            } else {
                b(bVar);
            }
            Runnable runnable = this.d;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f876a.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            this.c.b(this.b.get(i));
        }
        a(this.b);
        this.h = 0;
    }

    private void b(b bVar) {
        g(bVar);
    }

    private void c(b bVar) {
        boolean z;
        char c;
        int i = bVar.b;
        int i2 = bVar.b + bVar.d;
        int i3 = bVar.b;
        int i4 = 0;
        char c2 = 65535;
        while (i3 < i2) {
            if (this.c.a(i3) != null || d(i3)) {
                if (c2 == 0) {
                    e(a(2, i, i4, null));
                    z = true;
                } else {
                    z = false;
                }
                c = 1;
            } else {
                if (c2 == 1) {
                    g(a(2, i, i4, null));
                    z = true;
                } else {
                    z = false;
                }
                c = 0;
            }
            if (z) {
                i3 -= i4;
                i2 -= i4;
                i4 = 1;
            } else {
                i4++;
            }
            i3++;
            c2 = c;
        }
        if (i4 != bVar.d) {
            a(bVar);
            bVar = a(2, i, i4, null);
        }
        if (c2 == 0) {
            e(bVar);
        } else {
            g(bVar);
        }
    }

    private void d(b bVar) {
        int i = bVar.b;
        int i2 = bVar.b + bVar.d;
        int i3 = i;
        int i4 = 0;
        char c = 65535;
        for (int i5 = bVar.b; i5 < i2; i5++) {
            if (this.c.a(i5) != null || d(i5)) {
                if (c == 0) {
                    e(a(4, i3, i4, bVar.c));
                    i3 = i5;
                    i4 = 0;
                }
                c = 1;
            } else {
                if (c == 1) {
                    g(a(4, i3, i4, bVar.c));
                    i3 = i5;
                    i4 = 0;
                }
                c = 0;
            }
            i4++;
        }
        if (i4 != bVar.d) {
            Object obj = bVar.c;
            a(bVar);
            bVar = a(4, i3, i4, obj);
        }
        if (c == 0) {
            e(bVar);
        } else {
            g(bVar);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void e(b bVar) {
        int i;
        if (bVar.f877a == 1 || bVar.f877a == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int d = d(bVar.b, bVar.f877a);
        int i2 = bVar.b;
        int i3 = bVar.f877a;
        if (i3 == 2) {
            i = 0;
        } else {
            if (i3 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + bVar);
            }
            i = 1;
        }
        int i4 = d;
        int i5 = i2;
        int i6 = 1;
        for (int i7 = 1; i7 < bVar.d; i7++) {
            int d2 = d(bVar.b + (i * i7), bVar.f877a);
            int i8 = bVar.f877a;
            if (i8 != 2 ? i8 != 4 ? false : d2 == i4 + 1 : d2 == i4) {
                i6++;
            } else {
                b a2 = a(bVar.f877a, i4, i6, bVar.c);
                a(a2, i5);
                a(a2);
                if (bVar.f877a == 4) {
                    i5 += i6;
                }
                i4 = d2;
                i6 = 1;
            }
        }
        Object obj = bVar.c;
        a(bVar);
        if (i6 > 0) {
            b a3 = a(bVar.f877a, i4, i6, obj);
            a(a3, i5);
            a(a3);
        }
    }

    void a(b bVar, int i) {
        this.c.a(bVar);
        int i2 = bVar.f877a;
        if (i2 == 2) {
            this.c.a(i, bVar.d);
        } else {
            if (i2 == 4) {
                this.c.a(i, bVar.d, bVar.c);
                return;
            }
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    private int d(int i, int i2) {
        int i3;
        int i4;
        for (int size = this.b.size() - 1; size >= 0; size--) {
            b bVar = this.b.get(size);
            if (bVar.f877a == 8) {
                if (bVar.b < bVar.d) {
                    i3 = bVar.b;
                    i4 = bVar.d;
                } else {
                    i3 = bVar.d;
                    i4 = bVar.b;
                }
                if (i >= i3 && i <= i4) {
                    if (i3 == bVar.b) {
                        if (i2 == 1) {
                            bVar.d++;
                        } else if (i2 == 2) {
                            bVar.d--;
                        }
                        i++;
                    } else {
                        if (i2 == 1) {
                            bVar.b++;
                        } else if (i2 == 2) {
                            bVar.b--;
                        }
                        i--;
                    }
                } else if (i < bVar.b) {
                    if (i2 == 1) {
                        bVar.b++;
                        bVar.d++;
                    } else if (i2 == 2) {
                        bVar.b--;
                        bVar.d--;
                    }
                }
            } else if (bVar.b <= i) {
                if (bVar.f877a == 1) {
                    i -= bVar.d;
                } else if (bVar.f877a == 2) {
                    i += bVar.d;
                }
            } else if (i2 == 1) {
                bVar.b++;
            } else if (i2 == 2) {
                bVar.b--;
            }
        }
        for (int size2 = this.b.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.b.get(size2);
            if (bVar2.f877a == 8) {
                if (bVar2.d == bVar2.b || bVar2.d < 0) {
                    this.b.remove(size2);
                    a(bVar2);
                }
            } else if (bVar2.d <= 0) {
                this.b.remove(size2);
                a(bVar2);
            }
        }
        return i;
    }

    private boolean d(int i) {
        int size = this.b.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.b.get(i2);
            if (bVar.f877a == 8) {
                if (a(bVar.d, i2 + 1) == i) {
                    return true;
                }
            } else if (bVar.f877a == 1) {
                int i3 = bVar.b + bVar.d;
                for (int i4 = bVar.b; i4 < i3; i4++) {
                    if (a(i4, i2 + 1) == i) {
                        return true;
                    }
                }
            } else {
                continue;
            }
        }
        return false;
    }

    private void f(b bVar) {
        g(bVar);
    }

    private void g(b bVar) {
        this.b.add(bVar);
        int i = bVar.f877a;
        if (i == 4) {
            this.c.a(bVar.b, bVar.d, bVar.c);
            return;
        }
        if (i != 8) {
            switch (i) {
                case 1:
                    this.c.c(bVar.b, bVar.d);
                    return;
                case 2:
                    this.c.b(bVar.b, bVar.d);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown update op type for " + bVar);
            }
        }
        this.c.d(bVar.b, bVar.d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return this.f876a.size() > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i) {
        return (i & this.h) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i) {
        return a(i, 0);
    }

    int a(int i, int i2) {
        int size = this.b.size();
        while (i2 < size) {
            b bVar = this.b.get(i2);
            if (bVar.f877a == 8) {
                if (bVar.b == i) {
                    i = bVar.d;
                } else {
                    if (bVar.b < i) {
                        i--;
                    }
                    if (bVar.d <= i) {
                        i++;
                    }
                }
            } else if (bVar.b > i) {
                continue;
            } else if (bVar.f877a == 2) {
                if (i < bVar.b + bVar.d) {
                    return -1;
                }
                i -= bVar.d;
            } else if (bVar.f877a == 1) {
                i += bVar.d;
            }
            i2++;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i, int i2, Object obj) {
        if (i2 < 1) {
            return false;
        }
        this.f876a.add(a(4, i, i2, obj));
        this.h |= 4;
        return this.f876a.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(int i, int i2) {
        if (i2 < 1) {
            return false;
        }
        this.f876a.add(a(1, i, i2, null));
        this.h |= 1;
        return this.f876a.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(int i, int i2) {
        if (i2 < 1) {
            return false;
        }
        this.f876a.add(a(2, i, i2, null));
        this.h |= 2;
        return this.f876a.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i, int i2, int i3) {
        if (i == i2) {
            return false;
        }
        if (i3 != 1) {
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        this.f876a.add(a(8, i, i2, null));
        this.h |= 8;
        return this.f876a.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x001e. Please report as an issue. */
    public void e() {
        c();
        int size = this.f876a.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.f876a.get(i);
            int i2 = bVar.f877a;
            if (i2 == 4) {
                this.c.b(bVar);
                this.c.a(bVar.b, bVar.d, bVar.c);
            } else if (i2 != 8) {
                switch (i2) {
                    case 1:
                        this.c.b(bVar);
                        this.c.c(bVar.b, bVar.d);
                        break;
                    case 2:
                        this.c.b(bVar);
                        this.c.a(bVar.b, bVar.d);
                        break;
                }
            } else {
                this.c.b(bVar);
                this.c.d(bVar.b, bVar.d);
            }
            Runnable runnable = this.d;
            if (runnable != null) {
                runnable.run();
            }
        }
        a(this.f876a);
        this.h = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0047, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int c(int r6) {
        /*
            r5 = this;
            java.util.ArrayList<androidx.recyclerview.widget.a$b> r0 = r5.f876a
            int r0 = r0.size()
            r1 = 0
        L7:
            if (r1 >= r0) goto L4a
            java.util.ArrayList<androidx.recyclerview.widget.a$b> r2 = r5.f876a
            java.lang.Object r2 = r2.get(r1)
            androidx.recyclerview.widget.a$b r2 = (androidx.recyclerview.widget.a.b) r2
            int r3 = r2.f877a
            r4 = 8
            if (r3 == r4) goto L34
            switch(r3) {
                case 1: goto L2c;
                case 2: goto L1b;
                default: goto L1a;
            }
        L1a:
            goto L47
        L1b:
            int r3 = r2.b
            if (r3 > r6) goto L47
            int r3 = r2.b
            int r4 = r2.d
            int r3 = r3 + r4
            if (r3 <= r6) goto L28
            r6 = -1
            return r6
        L28:
            int r2 = r2.d
            int r6 = r6 - r2
            goto L47
        L2c:
            int r3 = r2.b
            if (r3 > r6) goto L47
            int r2 = r2.d
            int r6 = r6 + r2
            goto L47
        L34:
            int r3 = r2.b
            if (r3 != r6) goto L3b
            int r6 = r2.d
            goto L47
        L3b:
            int r3 = r2.b
            if (r3 >= r6) goto L41
            int r6 = r6 + (-1)
        L41:
            int r2 = r2.d
            if (r2 > r6) goto L47
            int r6 = r6 + 1
        L47:
            int r1 = r1 + 1
            goto L7
        L4a:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.a.c(int):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        return (this.b.isEmpty() || this.f876a.isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        int f877a;
        int b;
        Object c;
        int d;

        b(int i, int i2, int i3, Object obj) {
            this.f877a = i;
            this.b = i2;
            this.d = i3;
            this.c = obj;
        }

        String a() {
            int i = this.f877a;
            if (i == 4) {
                return "up";
            }
            if (i == 8) {
                return AnalyticsEventKey.SMART_INTENT_MODEL_VERSION;
            }
            switch (i) {
                case 1:
                    return ProductAction.ACTION_ADD;
                case 2:
                    return "rm";
                default:
                    return "??";
            }
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.b + "c:" + this.d + ",p:" + this.c + "]";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            int i = this.f877a;
            if (i != bVar.f877a) {
                return false;
            }
            if (i == 8 && Math.abs(this.d - this.b) == 1 && this.d == bVar.b && this.b == bVar.d) {
                return true;
            }
            if (this.d != bVar.d || this.b != bVar.b) {
                return false;
            }
            Object obj2 = this.c;
            if (obj2 != null) {
                if (!obj2.equals(bVar.c)) {
                    return false;
                }
            } else if (bVar.c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f877a * 31) + this.b) * 31) + this.d;
        }
    }

    @Override // androidx.recyclerview.widget.h.a
    public b a(int i, int i2, int i3, Object obj) {
        b a2 = this.g.a();
        if (a2 == null) {
            return new b(i, i2, i3, obj);
        }
        a2.f877a = i;
        a2.b = i2;
        a2.d = i3;
        a2.c = obj;
        return a2;
    }

    @Override // androidx.recyclerview.widget.h.a
    public void a(b bVar) {
        if (this.e) {
            return;
        }
        bVar.c = null;
        this.g.a(bVar);
    }

    void a(List<b> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            a(list.get(i));
        }
        list.clear();
    }
}
