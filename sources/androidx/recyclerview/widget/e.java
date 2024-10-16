package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    static final ThreadLocal<e> f896a = new ThreadLocal<>();
    static Comparator<b> e = new Comparator<b>() { // from class: androidx.recyclerview.widget.e.1
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(b bVar, b bVar2) {
            if ((bVar.d == null) != (bVar2.d == null)) {
                return bVar.d == null ? 1 : -1;
            }
            if (bVar.f898a != bVar2.f898a) {
                return bVar.f898a ? -1 : 1;
            }
            int i = bVar2.b - bVar.b;
            if (i != 0) {
                return i;
            }
            int i2 = bVar.c - bVar2.c;
            if (i2 != 0) {
                return i2;
            }
            return 0;
        }
    };
    long c;
    long d;
    ArrayList<RecyclerView> b = new ArrayList<>();
    private ArrayList<b> f = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public boolean f898a;
        public int b;
        public int c;
        public RecyclerView d;
        public int e;

        b() {
        }

        public void a() {
            this.f898a = false;
            this.b = 0;
            this.c = 0;
            this.d = null;
            this.e = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements RecyclerView.i.a {

        /* renamed from: a, reason: collision with root package name */
        int f897a;
        int b;
        int[] c;
        int d;

        void a(int i, int i2) {
            this.f897a = i;
            this.b = i2;
        }

        void a(RecyclerView recyclerView, boolean z) {
            this.d = 0;
            int[] iArr = this.c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.i iVar = recyclerView.mLayout;
            if (recyclerView.mAdapter == null || iVar == null || !iVar.s()) {
                return;
            }
            if (z) {
                if (!recyclerView.mAdapterHelper.d()) {
                    iVar.a(recyclerView.mAdapter.getItemCount(), this);
                }
            } else if (!recyclerView.hasPendingAdapterUpdates()) {
                iVar.a(this.f897a, this.b, recyclerView.mState, this);
            }
            if (this.d > iVar.x) {
                iVar.x = this.d;
                iVar.y = z;
                recyclerView.mRecycler.b();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i.a
        public void b(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i2 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i3 = this.d * 2;
            int[] iArr = this.c;
            if (iArr == null) {
                this.c = new int[4];
                Arrays.fill(this.c, -1);
            } else if (i3 >= iArr.length) {
                this.c = new int[i3 * 2];
                System.arraycopy(iArr, 0, this.c, 0, iArr.length);
            }
            int[] iArr2 = this.c;
            iArr2[i3] = i;
            iArr2[i3 + 1] = i2;
            this.d++;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a(int i) {
            if (this.c != null) {
                int i2 = this.d * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.c[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() {
            int[] iArr = this.c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.d = 0;
        }
    }

    public void a(RecyclerView recyclerView) {
        this.b.add(recyclerView);
    }

    public void b(RecyclerView recyclerView) {
        this.b.remove(recyclerView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.c == 0) {
            this.c = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.mPrefetchRegistry.a(i, i2);
    }

    private void a() {
        b bVar;
        int size = this.b.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView = this.b.get(i2);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.mPrefetchRegistry.a(recyclerView, false);
                i += recyclerView.mPrefetchRegistry.d;
            }
        }
        this.f.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView2 = this.b.get(i4);
            if (recyclerView2.getWindowVisibility() == 0) {
                a aVar = recyclerView2.mPrefetchRegistry;
                int abs = Math.abs(aVar.f897a) + Math.abs(aVar.b);
                int i5 = i3;
                for (int i6 = 0; i6 < aVar.d * 2; i6 += 2) {
                    if (i5 >= this.f.size()) {
                        bVar = new b();
                        this.f.add(bVar);
                    } else {
                        bVar = this.f.get(i5);
                    }
                    int i7 = aVar.c[i6 + 1];
                    bVar.f898a = i7 <= abs;
                    bVar.b = abs;
                    bVar.c = i7;
                    bVar.d = recyclerView2;
                    bVar.e = aVar.c[i6];
                    i5++;
                }
                i3 = i5;
            }
        }
        Collections.sort(this.f, e);
    }

    static boolean a(RecyclerView recyclerView, int i) {
        int c = recyclerView.mChildHelper.c();
        for (int i2 = 0; i2 < c; i2++) {
            RecyclerView.w childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.d(i2));
            if (childViewHolderInt.mPosition == i && !childViewHolderInt.isInvalid()) {
                return true;
            }
        }
        return false;
    }

    private RecyclerView.w a(RecyclerView recyclerView, int i, long j) {
        if (a(recyclerView, i)) {
            return null;
        }
        RecyclerView.p pVar = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            RecyclerView.w a2 = pVar.a(i, false, j);
            if (a2 != null) {
                if (a2.isBound() && !a2.isInvalid()) {
                    pVar.a(a2.itemView);
                } else {
                    pVar.a(a2, false);
                }
            }
            return a2;
        } finally {
            recyclerView.onExitLayoutOrScroll(false);
        }
    }

    private void a(RecyclerView recyclerView, long j) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.mDataSetHasChangedAfterLayout && recyclerView.mChildHelper.c() != 0) {
            recyclerView.removeAndRecycleViews();
        }
        a aVar = recyclerView.mPrefetchRegistry;
        aVar.a(recyclerView, true);
        if (aVar.d != 0) {
            try {
                androidx.core.os.c.a("RV Nested Prefetch");
                recyclerView.mState.a(recyclerView.mAdapter);
                for (int i = 0; i < aVar.d * 2; i += 2) {
                    a(recyclerView, aVar.c[i], j);
                }
            } finally {
                androidx.core.os.c.a();
            }
        }
    }

    private void a(b bVar, long j) {
        RecyclerView.w a2 = a(bVar.d, bVar.e, bVar.f898a ? Long.MAX_VALUE : j);
        if (a2 == null || a2.mNestedRecyclerView == null || !a2.isBound() || a2.isInvalid()) {
            return;
        }
        a(a2.mNestedRecyclerView.get(), j);
    }

    private void b(long j) {
        for (int i = 0; i < this.f.size(); i++) {
            b bVar = this.f.get(i);
            if (bVar.d == null) {
                return;
            }
            a(bVar, j);
            bVar.a();
        }
    }

    void a(long j) {
        a();
        b(j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public void run() {
        try {
            androidx.core.os.c.a("RV Prefetch");
            if (this.b.isEmpty()) {
                return;
            }
            int size = this.b.size();
            long j = 0;
            for (int i = 0; i < size; i++) {
                RecyclerView recyclerView = this.b.get(i);
                if (recyclerView.getWindowVisibility() == 0) {
                    j = Math.max(recyclerView.getDrawingTime(), j);
                }
            }
            if (j == 0) {
                return;
            }
            a(TimeUnit.MILLISECONDS.toNanos(j) + this.d);
        } finally {
            this.c = 0L;
            androidx.core.os.c.a();
        }
    }
}
