package kotlin.text;

import com.tencent.grobot.lite.model.local.EvaluateItemInfo;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Pair;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class e implements kotlin.f.b<kotlin.d.c> {

    /* renamed from: a, reason: collision with root package name */
    private final CharSequence f6981a;
    private final int b;
    private final int c;
    private final kotlin.jvm.a.m<CharSequence, Integer, Pair<Integer, Integer>> d;

    /* JADX WARN: Multi-variable type inference failed */
    public e(CharSequence charSequence, int i, int i2, kotlin.jvm.a.m<? super CharSequence, ? super Integer, Pair<Integer, Integer>> mVar) {
        kotlin.jvm.internal.h.b(charSequence, EvaluateItemInfo.ACTIONTYPE_INPUT);
        kotlin.jvm.internal.h.b(mVar, "getNextMatch");
        this.f6981a = charSequence;
        this.b = i;
        this.c = i2;
        this.d = mVar;
    }

    /* loaded from: classes3.dex */
    public static final class a implements Iterator<kotlin.d.c> {
        private int b = -1;
        private int c;
        private int d;
        private kotlin.d.c e;
        private int f;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        a() {
            this.c = kotlin.d.d.a(e.this.b, 0, e.this.f6981a.length());
            this.d = this.c;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
        
            if (r6.f < r6.f6982a.c) goto L9;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final void b() {
            /*
                r6 = this;
                int r0 = r6.d
                r1 = 0
                if (r0 >= 0) goto Le
                r6.b = r1
                r0 = 0
                kotlin.d.c r0 = (kotlin.d.c) r0
                r6.e = r0
                goto La4
            Le:
                kotlin.text.e r0 = kotlin.text.e.this
                int r0 = kotlin.text.e.a(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L27
                int r0 = r6.f
                int r0 = r0 + r3
                r6.f = r0
                int r0 = r6.f
                kotlin.text.e r4 = kotlin.text.e.this
                int r4 = kotlin.text.e.a(r4)
                if (r0 >= r4) goto L35
            L27:
                int r0 = r6.d
                kotlin.text.e r4 = kotlin.text.e.this
                java.lang.CharSequence r4 = kotlin.text.e.b(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L4b
            L35:
                int r0 = r6.c
                kotlin.d.c r1 = new kotlin.d.c
                kotlin.text.e r4 = kotlin.text.e.this
                java.lang.CharSequence r4 = kotlin.text.e.b(r4)
                int r4 = kotlin.text.l.d(r4)
                r1.<init>(r0, r4)
                r6.e = r1
                r6.d = r2
                goto La2
            L4b:
                kotlin.text.e r0 = kotlin.text.e.this
                kotlin.jvm.a.m r0 = kotlin.text.e.c(r0)
                kotlin.text.e r4 = kotlin.text.e.this
                java.lang.CharSequence r4 = kotlin.text.e.b(r4)
                int r5 = r6.d
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.a(r4, r5)
                kotlin.Pair r0 = (kotlin.Pair) r0
                if (r0 != 0) goto L7b
                int r0 = r6.c
                kotlin.d.c r1 = new kotlin.d.c
                kotlin.text.e r4 = kotlin.text.e.this
                java.lang.CharSequence r4 = kotlin.text.e.b(r4)
                int r4 = kotlin.text.l.d(r4)
                r1.<init>(r0, r4)
                r6.e = r1
                r6.d = r2
                goto La2
            L7b:
                java.lang.Object r2 = r0.c()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.d()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.c
                kotlin.d.c r4 = kotlin.d.d.b(r4, r2)
                r6.e = r4
                int r2 = r2 + r0
                r6.c = r2
                int r2 = r6.c
                if (r0 != 0) goto L9f
                r1 = 1
            L9f:
                int r2 = r2 + r1
                r6.d = r2
            La2:
                r6.b = r3
            La4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.text.e.a.b():void");
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public kotlin.d.c next() {
            if (this.b == -1) {
                b();
            }
            if (this.b == 0) {
                throw new NoSuchElementException();
            }
            kotlin.d.c cVar = this.e;
            if (cVar == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            this.e = (kotlin.d.c) null;
            this.b = -1;
            return cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.b == -1) {
                b();
            }
            return this.b == 1;
        }
    }

    @Override // kotlin.f.b
    public Iterator<kotlin.d.c> a() {
        return new a();
    }
}
