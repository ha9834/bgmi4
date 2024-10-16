package androidx.g;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.g.m;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class e extends androidx.fragment.app.v {
    @Override // androidx.fragment.app.v
    public boolean a(Object obj) {
        return obj instanceof m;
    }

    @Override // androidx.fragment.app.v
    public Object b(Object obj) {
        if (obj != null) {
            return ((m) obj).clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.v
    public Object c(Object obj) {
        if (obj == null) {
            return null;
        }
        q qVar = new q();
        qVar.a((m) obj);
        return qVar;
    }

    @Override // androidx.fragment.app.v
    public void a(Object obj, View view, ArrayList<View> arrayList) {
        q qVar = (q) obj;
        List<View> g = qVar.g();
        g.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            a(g, arrayList.get(i));
        }
        g.add(view);
        arrayList.add(view);
        a(qVar, arrayList);
    }

    @Override // androidx.fragment.app.v
    public void a(Object obj, View view) {
        if (view != null) {
            final Rect rect = new Rect();
            a(view, rect);
            ((m) obj).a(new m.b() { // from class: androidx.g.e.1
            });
        }
    }

    @Override // androidx.fragment.app.v
    public void a(Object obj, ArrayList<View> arrayList) {
        m mVar = (m) obj;
        if (mVar == null) {
            return;
        }
        int i = 0;
        if (mVar instanceof q) {
            q qVar = (q) mVar;
            int q = qVar.q();
            while (i < q) {
                a(qVar.b(i), arrayList);
                i++;
            }
            return;
        }
        if (a(mVar) || !a((List) mVar.g())) {
            return;
        }
        int size = arrayList.size();
        while (i < size) {
            mVar.b(arrayList.get(i));
            i++;
        }
    }

    private static boolean a(m mVar) {
        return (a((List) mVar.f()) && a((List) mVar.h()) && a((List) mVar.i())) ? false : true;
    }

    @Override // androidx.fragment.app.v
    public Object a(Object obj, Object obj2, Object obj3) {
        q qVar = new q();
        if (obj != null) {
            qVar.a((m) obj);
        }
        if (obj2 != null) {
            qVar.a((m) obj2);
        }
        if (obj3 != null) {
            qVar.a((m) obj3);
        }
        return qVar;
    }

    @Override // androidx.fragment.app.v
    public void b(Object obj, final View view, final ArrayList<View> arrayList) {
        ((m) obj).a(new m.c() { // from class: androidx.g.e.2
            @Override // androidx.g.m.c
            public void b(m mVar) {
            }

            @Override // androidx.g.m.c
            public void c(m mVar) {
            }

            @Override // androidx.g.m.c
            public void d(m mVar) {
            }

            @Override // androidx.g.m.c
            public void a(m mVar) {
                mVar.b(this);
                view.setVisibility(8);
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((View) arrayList.get(i)).setVisibility(0);
                }
            }
        });
    }

    @Override // androidx.fragment.app.v
    public Object b(Object obj, Object obj2, Object obj3) {
        m mVar = (m) obj;
        m mVar2 = (m) obj2;
        m mVar3 = (m) obj3;
        if (mVar != null && mVar2 != null) {
            mVar = new q().a(mVar).a(mVar2).a(1);
        } else if (mVar == null) {
            mVar = mVar2 != null ? mVar2 : null;
        }
        if (mVar3 == null) {
            return mVar;
        }
        q qVar = new q();
        if (mVar != null) {
            qVar.a(mVar);
        }
        qVar.a(mVar3);
        return qVar;
    }

    @Override // androidx.fragment.app.v
    public void a(ViewGroup viewGroup, Object obj) {
        o.a(viewGroup, (m) obj);
    }

    @Override // androidx.fragment.app.v
    public void a(Object obj, final Object obj2, final ArrayList<View> arrayList, final Object obj3, final ArrayList<View> arrayList2, final Object obj4, final ArrayList<View> arrayList3) {
        ((m) obj).a(new m.c() { // from class: androidx.g.e.3
            @Override // androidx.g.m.c
            public void a(m mVar) {
            }

            @Override // androidx.g.m.c
            public void b(m mVar) {
            }

            @Override // androidx.g.m.c
            public void c(m mVar) {
            }

            @Override // androidx.g.m.c
            public void d(m mVar) {
                Object obj5 = obj2;
                if (obj5 != null) {
                    e.this.b(obj5, arrayList, (ArrayList<View>) null);
                }
                Object obj6 = obj3;
                if (obj6 != null) {
                    e.this.b(obj6, arrayList2, (ArrayList<View>) null);
                }
                Object obj7 = obj4;
                if (obj7 != null) {
                    e.this.b(obj7, arrayList3, (ArrayList<View>) null);
                }
            }
        });
    }

    @Override // androidx.fragment.app.v
    public void a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        q qVar = (q) obj;
        if (qVar != null) {
            qVar.g().clear();
            qVar.g().addAll(arrayList2);
            b((Object) qVar, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.v
    public void b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        m mVar = (m) obj;
        int i = 0;
        if (mVar instanceof q) {
            q qVar = (q) mVar;
            int q = qVar.q();
            while (i < q) {
                b((Object) qVar.b(i), arrayList, arrayList2);
                i++;
            }
            return;
        }
        if (a(mVar)) {
            return;
        }
        List<View> g = mVar.g();
        if (g.size() == arrayList.size() && g.containsAll(arrayList)) {
            int size = arrayList2 == null ? 0 : arrayList2.size();
            while (i < size) {
                mVar.b(arrayList2.get(i));
                i++;
            }
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                mVar.c(arrayList.get(size2));
            }
        }
    }

    @Override // androidx.fragment.app.v
    public void b(Object obj, View view) {
        if (obj != null) {
            ((m) obj).b(view);
        }
    }

    @Override // androidx.fragment.app.v
    public void c(Object obj, View view) {
        if (obj != null) {
            ((m) obj).c(view);
        }
    }

    @Override // androidx.fragment.app.v
    public void a(Object obj, final Rect rect) {
        if (obj != null) {
            ((m) obj).a(new m.b() { // from class: androidx.g.e.4
            });
        }
    }
}
