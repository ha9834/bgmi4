package androidx.g;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class o {
    private static m b = new b();
    private static ThreadLocal<WeakReference<androidx.b.a<ViewGroup, ArrayList<m>>>> c = new ThreadLocal<>();

    /* renamed from: a, reason: collision with root package name */
    static ArrayList<ViewGroup> f734a = new ArrayList<>();

    static androidx.b.a<ViewGroup, ArrayList<m>> a() {
        androidx.b.a<ViewGroup, ArrayList<m>> aVar;
        WeakReference<androidx.b.a<ViewGroup, ArrayList<m>>> weakReference = c.get();
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            return aVar;
        }
        androidx.b.a<ViewGroup, ArrayList<m>> aVar2 = new androidx.b.a<>();
        c.set(new WeakReference<>(aVar2));
        return aVar2;
    }

    private static void b(ViewGroup viewGroup, m mVar) {
        if (mVar == null || viewGroup == null) {
            return;
        }
        a aVar = new a(mVar, viewGroup);
        viewGroup.addOnAttachStateChangeListener(aVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a, reason: collision with root package name */
        m f735a;
        ViewGroup b;

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        a(m mVar, ViewGroup viewGroup) {
            this.f735a = mVar;
            this.b = viewGroup;
        }

        private void a() {
            this.b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a();
            o.f734a.remove(this.b);
            ArrayList<m> arrayList = o.a().get(this.b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<m> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().e(this.b);
                }
            }
            this.f735a.a(true);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (!o.f734a.remove(this.b)) {
                return true;
            }
            final androidx.b.a<ViewGroup, ArrayList<m>> a2 = o.a();
            ArrayList<m> arrayList = a2.get(this.b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                a2.put(this.b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f735a);
            this.f735a.a(new n() { // from class: androidx.g.o.a.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // androidx.g.n, androidx.g.m.c
                public void a(m mVar) {
                    ((ArrayList) a2.get(a.this.b)).remove(mVar);
                }
            });
            this.f735a.a(this.b, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((m) it.next()).e(this.b);
                }
            }
            this.f735a.a(this.b);
            return true;
        }
    }

    private static void c(ViewGroup viewGroup, m mVar) {
        ArrayList<m> arrayList = a().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<m> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().d(viewGroup);
            }
        }
        if (mVar != null) {
            mVar.a(viewGroup, true);
        }
        l a2 = l.a(viewGroup);
        if (a2 != null) {
            a2.a();
        }
    }

    public static void a(ViewGroup viewGroup, m mVar) {
        if (f734a.contains(viewGroup) || !androidx.core.f.v.x(viewGroup)) {
            return;
        }
        f734a.add(viewGroup);
        if (mVar == null) {
            mVar = b;
        }
        m clone = mVar.clone();
        c(viewGroup, clone);
        l.a(viewGroup, null);
        b(viewGroup, clone);
    }
}
