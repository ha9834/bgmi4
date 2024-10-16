package androidx.recyclerview.widget;

import androidx.core.e.d;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    final androidx.b.a<RecyclerView.w, a> f907a = new androidx.b.a<>();
    final androidx.b.d<RecyclerView.w> b = new androidx.b.d<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b {
        void a(RecyclerView.w wVar);

        void a(RecyclerView.w wVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2);

        void b(RecyclerView.w wVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2);

        void c(RecyclerView.w wVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f907a.clear();
        this.b.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RecyclerView.w wVar, RecyclerView.f.c cVar) {
        a aVar = this.f907a.get(wVar);
        if (aVar == null) {
            aVar = a.a();
            this.f907a.put(wVar, aVar);
        }
        aVar.b = cVar;
        aVar.f908a |= 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(RecyclerView.w wVar) {
        a aVar = this.f907a.get(wVar);
        return (aVar == null || (aVar.f908a & 1) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.f.c b(RecyclerView.w wVar) {
        return a(wVar, 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.f.c c(RecyclerView.w wVar) {
        return a(wVar, 8);
    }

    private RecyclerView.f.c a(RecyclerView.w wVar, int i) {
        a c;
        RecyclerView.f.c cVar;
        int a2 = this.f907a.a(wVar);
        if (a2 < 0 || (c = this.f907a.c(a2)) == null || (c.f908a & i) == 0) {
            return null;
        }
        c.f908a &= i ^ (-1);
        if (i == 4) {
            cVar = c.b;
        } else if (i == 8) {
            cVar = c.c;
        } else {
            throw new IllegalArgumentException("Must provide flag PRE or POST");
        }
        if ((c.f908a & 12) == 0) {
            this.f907a.d(a2);
            a.a(c);
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j, RecyclerView.w wVar) {
        this.b.b(j, wVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(RecyclerView.w wVar, RecyclerView.f.c cVar) {
        a aVar = this.f907a.get(wVar);
        if (aVar == null) {
            aVar = a.a();
            this.f907a.put(wVar, aVar);
        }
        aVar.f908a |= 2;
        aVar.b = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(RecyclerView.w wVar) {
        a aVar = this.f907a.get(wVar);
        return (aVar == null || (aVar.f908a & 4) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.w a(long j) {
        return this.b.a(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(RecyclerView.w wVar, RecyclerView.f.c cVar) {
        a aVar = this.f907a.get(wVar);
        if (aVar == null) {
            aVar = a.a();
            this.f907a.put(wVar, aVar);
        }
        aVar.c = cVar;
        aVar.f908a |= 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(RecyclerView.w wVar) {
        a aVar = this.f907a.get(wVar);
        if (aVar == null) {
            aVar = a.a();
            this.f907a.put(wVar, aVar);
        }
        aVar.f908a |= 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(RecyclerView.w wVar) {
        a aVar = this.f907a.get(wVar);
        if (aVar == null) {
            return;
        }
        aVar.f908a &= -2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        for (int size = this.f907a.size() - 1; size >= 0; size--) {
            RecyclerView.w b2 = this.f907a.b(size);
            a d = this.f907a.d(size);
            if ((d.f908a & 3) == 3) {
                bVar.a(b2);
            } else if ((d.f908a & 1) != 0) {
                if (d.b == null) {
                    bVar.a(b2);
                } else {
                    bVar.a(b2, d.b, d.c);
                }
            } else if ((d.f908a & 14) == 14) {
                bVar.b(b2, d.b, d.c);
            } else if ((d.f908a & 12) == 12) {
                bVar.c(b2, d.b, d.c);
            } else if ((d.f908a & 4) != 0) {
                bVar.a(b2, d.b, null);
            } else if ((d.f908a & 8) != 0) {
                bVar.b(b2, d.b, d.c);
            } else {
                int i = d.f908a;
            }
            a.a(d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(RecyclerView.w wVar) {
        int b2 = this.b.b() - 1;
        while (true) {
            if (b2 < 0) {
                break;
            }
            if (wVar == this.b.c(b2)) {
                this.b.a(b2);
                break;
            }
            b2--;
        }
        a remove = this.f907a.remove(wVar);
        if (remove != null) {
            a.a(remove);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        a.b();
    }

    public void h(RecyclerView.w wVar) {
        f(wVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        static d.a<a> d = new d.b(20);

        /* renamed from: a, reason: collision with root package name */
        int f908a;
        RecyclerView.f.c b;
        RecyclerView.f.c c;

        private a() {
        }

        static a a() {
            a a2 = d.a();
            return a2 == null ? new a() : a2;
        }

        static void a(a aVar) {
            aVar.f908a = 0;
            aVar.b = null;
            aVar.c = null;
            d.a(aVar);
        }

        static void b() {
            do {
            } while (d.a() != null);
        }
    }
}
