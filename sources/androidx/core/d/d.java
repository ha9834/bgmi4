package androidx.core.d;

import java.util.Locale;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final androidx.core.d.c f507a = new e(null, false);
    public static final androidx.core.d.c b = new e(null, true);
    public static final androidx.core.d.c c = new e(b.f509a, false);
    public static final androidx.core.d.c d = new e(b.f509a, true);
    public static final androidx.core.d.c e = new e(a.f508a, false);
    public static final androidx.core.d.c f = f.f512a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface c {
        int a(CharSequence charSequence, int i, int i2);
    }

    static int a(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
            case 2:
                return 0;
            default:
                return 2;
        }
    }

    static int b(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
            case 2:
                return 0;
            default:
                switch (i) {
                    case 14:
                    case 15:
                        return 1;
                    case 16:
                    case 17:
                        return 0;
                    default:
                        return 2;
                }
        }
    }

    /* renamed from: androidx.core.d.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static abstract class AbstractC0046d implements androidx.core.d.c {

        /* renamed from: a, reason: collision with root package name */
        private final c f510a;

        protected abstract boolean a();

        AbstractC0046d(c cVar) {
            this.f510a = cVar;
        }

        @Override // androidx.core.d.c
        public boolean a(CharSequence charSequence, int i, int i2) {
            if (charSequence == null || i < 0 || i2 < 0 || charSequence.length() - i2 < i) {
                throw new IllegalArgumentException();
            }
            if (this.f510a == null) {
                return a();
            }
            return b(charSequence, i, i2);
        }

        private boolean b(CharSequence charSequence, int i, int i2) {
            switch (this.f510a.a(charSequence, i, i2)) {
                case 0:
                    return true;
                case 1:
                    return false;
                default:
                    return a();
            }
        }
    }

    /* loaded from: classes.dex */
    private static class e extends AbstractC0046d {

        /* renamed from: a, reason: collision with root package name */
        private final boolean f511a;

        e(c cVar, boolean z) {
            super(cVar);
            this.f511a = z;
        }

        @Override // androidx.core.d.d.AbstractC0046d
        protected boolean a() {
            return this.f511a;
        }
    }

    /* loaded from: classes.dex */
    private static class b implements c {

        /* renamed from: a, reason: collision with root package name */
        static final b f509a = new b();

        @Override // androidx.core.d.d.c
        public int a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            int i4 = 2;
            while (i < i3 && i4 == 2) {
                i4 = d.b(Character.getDirectionality(charSequence.charAt(i)));
                i++;
            }
            return i4;
        }

        private b() {
        }
    }

    /* loaded from: classes.dex */
    private static class a implements c {

        /* renamed from: a, reason: collision with root package name */
        static final a f508a = new a(true);
        private final boolean b;

        @Override // androidx.core.d.d.c
        public int a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            boolean z = false;
            while (i < i3) {
                switch (d.a(Character.getDirectionality(charSequence.charAt(i)))) {
                    case 0:
                        if (!this.b) {
                            z = true;
                            break;
                        } else {
                            return 0;
                        }
                    case 1:
                        if (!this.b) {
                            return 1;
                        }
                        z = true;
                        break;
                }
                i++;
            }
            if (z) {
                return this.b ? 1 : 0;
            }
            return 2;
        }

        private a(boolean z) {
            this.b = z;
        }
    }

    /* loaded from: classes.dex */
    private static class f extends AbstractC0046d {

        /* renamed from: a, reason: collision with root package name */
        static final f f512a = new f();

        f() {
            super(null);
        }

        @Override // androidx.core.d.d.AbstractC0046d
        protected boolean a() {
            return androidx.core.d.e.a(Locale.getDefault()) == 1;
        }
    }
}
