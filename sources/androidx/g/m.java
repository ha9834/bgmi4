package androidx.g;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.imsdk.android.IR;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class m implements Cloneable {
    private b H;
    private androidx.b.a<String, String> I;
    p g;
    private ArrayList<s> y;
    private ArrayList<s> z;
    private static final int[] h = {2, 1, 3, 4};
    private static final g i = new g() { // from class: androidx.g.m.1
        @Override // androidx.g.g
        public Path a(float f, float f2, float f3, float f4) {
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }
    };
    private static ThreadLocal<androidx.b.a<Animator, a>> A = new ThreadLocal<>();
    private String j = getClass().getName();
    private long k = -1;

    /* renamed from: a, reason: collision with root package name */
    long f730a = -1;
    private TimeInterpolator l = null;
    ArrayList<Integer> b = new ArrayList<>();
    ArrayList<View> c = new ArrayList<>();
    private ArrayList<String> m = null;
    private ArrayList<Class> n = null;
    private ArrayList<Integer> o = null;
    private ArrayList<View> p = null;
    private ArrayList<Class> q = null;
    private ArrayList<String> r = null;
    private ArrayList<Integer> s = null;
    private ArrayList<View> t = null;
    private ArrayList<Class> u = null;
    private t v = new t();
    private t w = new t();
    q d = null;
    private int[] x = h;
    private ViewGroup B = null;
    boolean e = false;
    ArrayList<Animator> f = new ArrayList<>();
    private int C = 0;
    private boolean D = false;
    private boolean E = false;
    private ArrayList<c> F = null;
    private ArrayList<Animator> G = new ArrayList<>();
    private g J = i;

    /* loaded from: classes.dex */
    public static abstract class b {
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(m mVar);

        void b(m mVar);

        void c(m mVar);

        void d(m mVar);
    }

    public Animator a(ViewGroup viewGroup, s sVar, s sVar2) {
        return null;
    }

    public abstract void a(s sVar);

    public String[] a() {
        return null;
    }

    public abstract void b(s sVar);

    public m a(long j) {
        this.f730a = j;
        return this;
    }

    public long b() {
        return this.f730a;
    }

    public m b(long j) {
        this.k = j;
        return this;
    }

    public long c() {
        return this.k;
    }

    public m a(TimeInterpolator timeInterpolator) {
        this.l = timeInterpolator;
        return this;
    }

    public TimeInterpolator d() {
        return this.l;
    }

    private void a(androidx.b.a<View, s> aVar, androidx.b.a<View, s> aVar2) {
        s remove;
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View b2 = aVar.b(size);
            if (b2 != null && a(b2) && (remove = aVar2.remove(b2)) != null && remove.b != null && a(remove.b)) {
                this.y.add(aVar.d(size));
                this.z.add(remove);
            }
        }
    }

    private void a(androidx.b.a<View, s> aVar, androidx.b.a<View, s> aVar2, androidx.b.d<View> dVar, androidx.b.d<View> dVar2) {
        View a2;
        int b2 = dVar.b();
        for (int i2 = 0; i2 < b2; i2++) {
            View c2 = dVar.c(i2);
            if (c2 != null && a(c2) && (a2 = dVar2.a(dVar.b(i2))) != null && a(a2)) {
                s sVar = aVar.get(c2);
                s sVar2 = aVar2.get(a2);
                if (sVar != null && sVar2 != null) {
                    this.y.add(sVar);
                    this.z.add(sVar2);
                    aVar.remove(c2);
                    aVar2.remove(a2);
                }
            }
        }
    }

    private void a(androidx.b.a<View, s> aVar, androidx.b.a<View, s> aVar2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            View valueAt = sparseArray.valueAt(i2);
            if (valueAt != null && a(valueAt) && (view = sparseArray2.get(sparseArray.keyAt(i2))) != null && a(view)) {
                s sVar = aVar.get(valueAt);
                s sVar2 = aVar2.get(view);
                if (sVar != null && sVar2 != null) {
                    this.y.add(sVar);
                    this.z.add(sVar2);
                    aVar.remove(valueAt);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void a(androidx.b.a<View, s> aVar, androidx.b.a<View, s> aVar2, androidx.b.a<String, View> aVar3, androidx.b.a<String, View> aVar4) {
        View view;
        int size = aVar3.size();
        for (int i2 = 0; i2 < size; i2++) {
            View c2 = aVar3.c(i2);
            if (c2 != null && a(c2) && (view = aVar4.get(aVar3.b(i2))) != null && a(view)) {
                s sVar = aVar.get(c2);
                s sVar2 = aVar2.get(view);
                if (sVar != null && sVar2 != null) {
                    this.y.add(sVar);
                    this.z.add(sVar2);
                    aVar.remove(c2);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void b(androidx.b.a<View, s> aVar, androidx.b.a<View, s> aVar2) {
        for (int i2 = 0; i2 < aVar.size(); i2++) {
            s c2 = aVar.c(i2);
            if (a(c2.b)) {
                this.y.add(c2);
                this.z.add(null);
            }
        }
        for (int i3 = 0; i3 < aVar2.size(); i3++) {
            s c3 = aVar2.c(i3);
            if (a(c3.b)) {
                this.z.add(c3);
                this.y.add(null);
            }
        }
    }

    private void a(t tVar, t tVar2) {
        androidx.b.a<View, s> aVar = new androidx.b.a<>(tVar.f741a);
        androidx.b.a<View, s> aVar2 = new androidx.b.a<>(tVar2.f741a);
        int i2 = 0;
        while (true) {
            int[] iArr = this.x;
            if (i2 < iArr.length) {
                switch (iArr[i2]) {
                    case 1:
                        a(aVar, aVar2);
                        break;
                    case 2:
                        a(aVar, aVar2, tVar.d, tVar2.d);
                        break;
                    case 3:
                        a(aVar, aVar2, tVar.b, tVar2.b);
                        break;
                    case 4:
                        a(aVar, aVar2, tVar.c, tVar2.c);
                        break;
                }
                i2++;
            } else {
                b(aVar, aVar2);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ViewGroup viewGroup, t tVar, t tVar2, ArrayList<s> arrayList, ArrayList<s> arrayList2) {
        int i2;
        int i3;
        View view;
        Animator animator;
        s sVar;
        long j;
        Animator animator2;
        s sVar2;
        androidx.b.a<Animator, a> q = q();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long j2 = Long.MAX_VALUE;
        int i4 = 0;
        while (i4 < size) {
            s sVar3 = arrayList.get(i4);
            s sVar4 = arrayList2.get(i4);
            if (sVar3 != null && !sVar3.c.contains(this)) {
                sVar3 = null;
            }
            if (sVar4 != null && !sVar4.c.contains(this)) {
                sVar4 = null;
            }
            if (sVar3 == null && sVar4 == null) {
                i2 = size;
                i3 = i4;
            } else if (sVar3 == null || sVar4 == null || a(sVar3, sVar4)) {
                Animator a2 = a(viewGroup, sVar3, sVar4);
                if (a2 != null) {
                    if (sVar4 != null) {
                        view = sVar4.b;
                        String[] a3 = a();
                        if (view == null || a3 == null || a3.length <= 0) {
                            i2 = size;
                            i3 = i4;
                            animator2 = a2;
                            sVar2 = null;
                        } else {
                            sVar2 = new s();
                            sVar2.b = view;
                            i2 = size;
                            s sVar5 = tVar2.f741a.get(view);
                            if (sVar5 != null) {
                                int i5 = 0;
                                while (i5 < a3.length) {
                                    sVar2.f740a.put(a3[i5], sVar5.f740a.get(a3[i5]));
                                    i5++;
                                    i4 = i4;
                                    sVar5 = sVar5;
                                }
                                i3 = i4;
                            } else {
                                i3 = i4;
                            }
                            int size2 = q.size();
                            int i6 = 0;
                            while (true) {
                                if (i6 >= size2) {
                                    animator2 = a2;
                                    break;
                                }
                                a aVar = q.get(q.b(i6));
                                if (aVar.c != null && aVar.f733a == view && aVar.b.equals(p()) && aVar.c.equals(sVar2)) {
                                    animator2 = null;
                                    break;
                                }
                                i6++;
                            }
                        }
                        animator = animator2;
                        sVar = sVar2;
                    } else {
                        i2 = size;
                        i3 = i4;
                        view = sVar3.b;
                        animator = a2;
                        sVar = null;
                    }
                    if (animator != null) {
                        p pVar = this.g;
                        if (pVar != null) {
                            long a4 = pVar.a(viewGroup, this, sVar3, sVar4);
                            sparseIntArray.put(this.G.size(), (int) a4);
                            j = Math.min(a4, j2);
                        } else {
                            j = j2;
                        }
                        q.put(animator, new a(view, p(), this, ad.b(viewGroup), sVar));
                        this.G.add(animator);
                        j2 = j;
                    }
                } else {
                    i2 = size;
                    i3 = i4;
                }
            } else {
                i2 = size;
                i3 = i4;
            }
            i4 = i3 + 1;
            size = i2;
        }
        if (j2 != 0) {
            for (int i7 = 0; i7 < sparseIntArray.size(); i7++) {
                Animator animator3 = this.G.get(sparseIntArray.keyAt(i7));
                animator3.setStartDelay((sparseIntArray.valueAt(i7) - j2) + animator3.getStartDelay());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(View view) {
        ArrayList<Class> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.o;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.p;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class> arrayList5 = this.q;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.q.get(i2).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.r != null && androidx.core.f.v.n(view) != null && this.r.contains(androidx.core.f.v.n(view))) {
            return false;
        }
        if ((this.b.size() == 0 && this.c.size() == 0 && (((arrayList = this.n) == null || arrayList.isEmpty()) && ((arrayList2 = this.m) == null || arrayList2.isEmpty()))) || this.b.contains(Integer.valueOf(id)) || this.c.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.m;
        if (arrayList6 != null && arrayList6.contains(androidx.core.f.v.n(view))) {
            return true;
        }
        if (this.n != null) {
            for (int i3 = 0; i3 < this.n.size(); i3++) {
                if (this.n.get(i3).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static androidx.b.a<Animator, a> q() {
        androidx.b.a<Animator, a> aVar = A.get();
        if (aVar != null) {
            return aVar;
        }
        androidx.b.a<Animator, a> aVar2 = new androidx.b.a<>();
        A.set(aVar2);
        return aVar2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        j();
        androidx.b.a<Animator, a> q = q();
        Iterator<Animator> it = this.G.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (q.containsKey(next)) {
                j();
                a(next, q);
            }
        }
        this.G.clear();
        k();
    }

    private void a(Animator animator, final androidx.b.a<Animator, a> aVar) {
        if (animator != null) {
            animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.g.m.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator2) {
                    m.this.f.add(animator2);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    aVar.remove(animator2);
                    m.this.f.remove(animator2);
                }
            });
            a(animator);
        }
    }

    public m b(View view) {
        this.c.add(view);
        return this;
    }

    public m c(View view) {
        this.c.remove(view);
        return this;
    }

    public List<Integer> f() {
        return this.b;
    }

    public List<View> g() {
        return this.c;
    }

    public List<String> h() {
        return this.m;
    }

    public List<Class> i() {
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ViewGroup viewGroup, boolean z) {
        ArrayList<String> arrayList;
        ArrayList<Class> arrayList2;
        androidx.b.a<String, String> aVar;
        a(z);
        if ((this.b.size() > 0 || this.c.size() > 0) && (((arrayList = this.m) == null || arrayList.isEmpty()) && ((arrayList2 = this.n) == null || arrayList2.isEmpty()))) {
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                View findViewById = viewGroup.findViewById(this.b.get(i2).intValue());
                if (findViewById != null) {
                    s sVar = new s();
                    sVar.b = findViewById;
                    if (z) {
                        a(sVar);
                    } else {
                        b(sVar);
                    }
                    sVar.c.add(this);
                    c(sVar);
                    if (z) {
                        a(this.v, findViewById, sVar);
                    } else {
                        a(this.w, findViewById, sVar);
                    }
                }
            }
            for (int i3 = 0; i3 < this.c.size(); i3++) {
                View view = this.c.get(i3);
                s sVar2 = new s();
                sVar2.b = view;
                if (z) {
                    a(sVar2);
                } else {
                    b(sVar2);
                }
                sVar2.c.add(this);
                c(sVar2);
                if (z) {
                    a(this.v, view, sVar2);
                } else {
                    a(this.w, view, sVar2);
                }
            }
        } else {
            c(viewGroup, z);
        }
        if (z || (aVar = this.I) == null) {
            return;
        }
        int size = aVar.size();
        ArrayList arrayList3 = new ArrayList(size);
        for (int i4 = 0; i4 < size; i4++) {
            arrayList3.add(this.v.d.remove(this.I.b(i4)));
        }
        for (int i5 = 0; i5 < size; i5++) {
            View view2 = (View) arrayList3.get(i5);
            if (view2 != null) {
                this.v.d.put(this.I.c(i5), view2);
            }
        }
    }

    private static void a(t tVar, View view, s sVar) {
        tVar.f741a.put(view, sVar);
        int id = view.getId();
        if (id >= 0) {
            if (tVar.b.indexOfKey(id) >= 0) {
                tVar.b.put(id, null);
            } else {
                tVar.b.put(id, view);
            }
        }
        String n = androidx.core.f.v.n(view);
        if (n != null) {
            if (tVar.d.containsKey(n)) {
                tVar.d.put(n, null);
            } else {
                tVar.d.put(n, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (tVar.c.d(itemIdAtPosition) >= 0) {
                    View a2 = tVar.c.a(itemIdAtPosition);
                    if (a2 != null) {
                        androidx.core.f.v.a(a2, false);
                        tVar.c.b(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                androidx.core.f.v.a(view, true);
                tVar.c.b(itemIdAtPosition, view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        if (z) {
            this.v.f741a.clear();
            this.v.b.clear();
            this.v.c.c();
        } else {
            this.w.f741a.clear();
            this.w.b.clear();
            this.w.c.c();
        }
    }

    private void c(View view, boolean z) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        ArrayList<Integer> arrayList = this.o;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
            ArrayList<View> arrayList2 = this.p;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList<Class> arrayList3 = this.q;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        if (this.q.get(i2).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    s sVar = new s();
                    sVar.b = view;
                    if (z) {
                        a(sVar);
                    } else {
                        b(sVar);
                    }
                    sVar.c.add(this);
                    c(sVar);
                    if (z) {
                        a(this.v, view, sVar);
                    } else {
                        a(this.w, view, sVar);
                    }
                }
                if (view instanceof ViewGroup) {
                    ArrayList<Integer> arrayList4 = this.s;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                        ArrayList<View> arrayList5 = this.t;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList<Class> arrayList6 = this.u;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i3 = 0; i3 < size2; i3++) {
                                    if (this.u.get(i3).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                                c(viewGroup.getChildAt(i4), z);
                            }
                        }
                    }
                }
            }
        }
    }

    public s a(View view, boolean z) {
        q qVar = this.d;
        if (qVar != null) {
            return qVar.a(view, z);
        }
        return (z ? this.v : this.w).f741a.get(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s b(View view, boolean z) {
        q qVar = this.d;
        if (qVar != null) {
            return qVar.b(view, z);
        }
        ArrayList<s> arrayList = z ? this.y : this.z;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            s sVar = arrayList.get(i3);
            if (sVar == null) {
                return null;
            }
            if (sVar.b == view) {
                i2 = i3;
                break;
            }
            i3++;
        }
        if (i2 >= 0) {
            return (z ? this.z : this.y).get(i2);
        }
        return null;
    }

    public void d(View view) {
        if (this.E) {
            return;
        }
        androidx.b.a<Animator, a> q = q();
        int size = q.size();
        al b2 = ad.b(view);
        for (int i2 = size - 1; i2 >= 0; i2--) {
            a c2 = q.c(i2);
            if (c2.f733a != null && b2.equals(c2.d)) {
                androidx.g.a.a(q.b(i2));
            }
        }
        ArrayList<c> arrayList = this.F;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.F.clone();
            int size2 = arrayList2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                ((c) arrayList2.get(i3)).b(this);
            }
        }
        this.D = true;
    }

    public void e(View view) {
        if (this.D) {
            if (!this.E) {
                androidx.b.a<Animator, a> q = q();
                int size = q.size();
                al b2 = ad.b(view);
                for (int i2 = size - 1; i2 >= 0; i2--) {
                    a c2 = q.c(i2);
                    if (c2.f733a != null && b2.equals(c2.d)) {
                        androidx.g.a.b(q.b(i2));
                    }
                }
                ArrayList<c> arrayList = this.F;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.F.clone();
                    int size2 = arrayList2.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        ((c) arrayList2.get(i3)).c(this);
                    }
                }
            }
            this.D = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ViewGroup viewGroup) {
        a aVar;
        this.y = new ArrayList<>();
        this.z = new ArrayList<>();
        a(this.v, this.w);
        androidx.b.a<Animator, a> q = q();
        int size = q.size();
        al b2 = ad.b(viewGroup);
        for (int i2 = size - 1; i2 >= 0; i2--) {
            Animator b3 = q.b(i2);
            if (b3 != null && (aVar = q.get(b3)) != null && aVar.f733a != null && b2.equals(aVar.d)) {
                s sVar = aVar.c;
                View view = aVar.f733a;
                s a2 = a(view, true);
                s b4 = b(view, true);
                if (!(a2 == null && b4 == null) && aVar.e.a(sVar, b4)) {
                    if (b3.isRunning() || b3.isStarted()) {
                        b3.cancel();
                    } else {
                        q.remove(b3);
                    }
                }
            }
        }
        a(viewGroup, this.v, this.w, this.y, this.z);
        e();
    }

    public boolean a(s sVar, s sVar2) {
        if (sVar == null || sVar2 == null) {
            return false;
        }
        String[] a2 = a();
        if (a2 != null) {
            for (String str : a2) {
                if (a(sVar, sVar2, str)) {
                    return true;
                }
            }
            return false;
        }
        Iterator<String> it = sVar.f740a.keySet().iterator();
        while (it.hasNext()) {
            if (a(sVar, sVar2, it.next())) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(s sVar, s sVar2, String str) {
        Object obj = sVar.f740a.get(str);
        Object obj2 = sVar2.f740a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    protected void a(Animator animator) {
        if (animator == null) {
            k();
            return;
        }
        if (b() >= 0) {
            animator.setDuration(b());
        }
        if (c() >= 0) {
            animator.setStartDelay(c());
        }
        if (d() != null) {
            animator.setInterpolator(d());
        }
        animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.g.m.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                m.this.k();
                animator2.removeListener(this);
            }
        });
        animator.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j() {
        if (this.C == 0) {
            ArrayList<c> arrayList = this.F;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.F.clone();
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((c) arrayList2.get(i2)).d(this);
                }
            }
            this.E = false;
        }
        this.C++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k() {
        this.C--;
        if (this.C == 0) {
            ArrayList<c> arrayList = this.F;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.F.clone();
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((c) arrayList2.get(i2)).a(this);
                }
            }
            for (int i3 = 0; i3 < this.v.c.b(); i3++) {
                View c2 = this.v.c.c(i3);
                if (c2 != null) {
                    androidx.core.f.v.a(c2, false);
                }
            }
            for (int i4 = 0; i4 < this.w.c.b(); i4++) {
                View c3 = this.w.c.c(i4);
                if (c3 != null) {
                    androidx.core.f.v.a(c3, false);
                }
            }
            this.E = true;
        }
    }

    public m a(c cVar) {
        if (this.F == null) {
            this.F = new ArrayList<>();
        }
        this.F.add(cVar);
        return this;
    }

    public m b(c cVar) {
        ArrayList<c> arrayList = this.F;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(cVar);
        if (this.F.size() == 0) {
            this.F = null;
        }
        return this;
    }

    public void a(g gVar) {
        if (gVar == null) {
            this.J = i;
        } else {
            this.J = gVar;
        }
    }

    public g l() {
        return this.J;
    }

    public void a(b bVar) {
        this.H = bVar;
    }

    public b m() {
        return this.H;
    }

    public void a(p pVar) {
        this.g = pVar;
    }

    public p n() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(s sVar) {
        String[] a2;
        if (this.g == null || sVar.f740a.isEmpty() || (a2 = this.g.a()) == null) {
            return;
        }
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= a2.length) {
                z = true;
                break;
            } else if (!sVar.f740a.containsKey(a2[i2])) {
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            return;
        }
        this.g.a(sVar);
    }

    public String toString() {
        return a("");
    }

    @Override // 
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public m clone() {
        try {
            m mVar = (m) super.clone();
            mVar.G = new ArrayList<>();
            mVar.v = new t();
            mVar.w = new t();
            mVar.y = null;
            mVar.z = null;
            return mVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public String p() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(String str) {
        String str2 = str + getClass().getSimpleName() + IR.account.EMAIL_TAG + Integer.toHexString(hashCode()) + ": ";
        if (this.f730a != -1) {
            str2 = str2 + "dur(" + this.f730a + ") ";
        }
        if (this.k != -1) {
            str2 = str2 + "dly(" + this.k + ") ";
        }
        if (this.l != null) {
            str2 = str2 + "interp(" + this.l + ") ";
        }
        if (this.b.size() <= 0 && this.c.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.b.size() > 0) {
            String str4 = str3;
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                if (i2 > 0) {
                    str4 = str4 + ", ";
                }
                str4 = str4 + this.b.get(i2);
            }
            str3 = str4;
        }
        if (this.c.size() > 0) {
            for (int i3 = 0; i3 < this.c.size(); i3++) {
                if (i3 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.c.get(i3);
            }
        }
        return str3 + ")";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        View f733a;
        String b;
        s c;
        al d;
        m e;

        a(View view, String str, m mVar, al alVar, s sVar) {
            this.f733a = view;
            this.b = str;
            this.c = sVar;
            this.d = alVar;
            this.e = mVar;
        }
    }
}
