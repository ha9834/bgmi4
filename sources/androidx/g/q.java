package androidx.g;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import androidx.g.m;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class q extends m {
    int h;
    private ArrayList<m> j = new ArrayList<>();
    private boolean k = true;
    boolean i = false;
    private int l = 0;

    public q a(int i) {
        switch (i) {
            case 0:
                this.k = true;
                return this;
            case 1:
                this.k = false;
                return this;
            default:
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i);
        }
    }

    public q a(m mVar) {
        this.j.add(mVar);
        mVar.d = this;
        if (this.f730a >= 0) {
            mVar.a(this.f730a);
        }
        if ((this.l & 1) != 0) {
            mVar.a(d());
        }
        if ((this.l & 2) != 0) {
            mVar.a(n());
        }
        if ((this.l & 4) != 0) {
            mVar.a(l());
        }
        if ((this.l & 8) != 0) {
            mVar.a(m());
        }
        return this;
    }

    public int q() {
        return this.j.size();
    }

    public m b(int i) {
        if (i < 0 || i >= this.j.size()) {
            return null;
        }
        return this.j.get(i);
    }

    @Override // androidx.g.m
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public q a(long j) {
        super.a(j);
        if (this.f730a >= 0) {
            int size = this.j.size();
            for (int i = 0; i < size; i++) {
                this.j.get(i).a(j);
            }
        }
        return this;
    }

    @Override // androidx.g.m
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public q b(long j) {
        return (q) super.b(j);
    }

    @Override // androidx.g.m
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public q a(TimeInterpolator timeInterpolator) {
        this.l |= 1;
        ArrayList<m> arrayList = this.j;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.j.get(i).a(timeInterpolator);
            }
        }
        return (q) super.a(timeInterpolator);
    }

    @Override // androidx.g.m
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public q b(View view) {
        for (int i = 0; i < this.j.size(); i++) {
            this.j.get(i).b(view);
        }
        return (q) super.b(view);
    }

    @Override // androidx.g.m
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public q a(m.c cVar) {
        return (q) super.a(cVar);
    }

    @Override // androidx.g.m
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public q c(View view) {
        for (int i = 0; i < this.j.size(); i++) {
            this.j.get(i).c(view);
        }
        return (q) super.c(view);
    }

    @Override // androidx.g.m
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public q b(m.c cVar) {
        return (q) super.b(cVar);
    }

    @Override // androidx.g.m
    public void a(g gVar) {
        super.a(gVar);
        this.l |= 4;
        for (int i = 0; i < this.j.size(); i++) {
            this.j.get(i).a(gVar);
        }
    }

    private void r() {
        a aVar = new a(this);
        Iterator<m> it = this.j.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
        this.h = this.j.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends n {

        /* renamed from: a, reason: collision with root package name */
        q f738a;

        a(q qVar) {
            this.f738a = qVar;
        }

        @Override // androidx.g.n, androidx.g.m.c
        public void d(m mVar) {
            if (this.f738a.i) {
                return;
            }
            this.f738a.j();
            this.f738a.i = true;
        }

        @Override // androidx.g.n, androidx.g.m.c
        public void a(m mVar) {
            q qVar = this.f738a;
            qVar.h--;
            if (this.f738a.h == 0) {
                q qVar2 = this.f738a;
                qVar2.i = false;
                qVar2.k();
            }
            mVar.b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.g.m
    public void a(ViewGroup viewGroup, t tVar, t tVar2, ArrayList<s> arrayList, ArrayList<s> arrayList2) {
        long c = c();
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            m mVar = this.j.get(i);
            if (c > 0 && (this.k || i == 0)) {
                long c2 = mVar.c();
                if (c2 > 0) {
                    mVar.b(c2 + c);
                } else {
                    mVar.b(c);
                }
            }
            mVar.a(viewGroup, tVar, tVar2, arrayList, arrayList2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.g.m
    public void e() {
        if (this.j.isEmpty()) {
            j();
            k();
            return;
        }
        r();
        if (!this.k) {
            for (int i = 1; i < this.j.size(); i++) {
                m mVar = this.j.get(i - 1);
                final m mVar2 = this.j.get(i);
                mVar.a(new n() { // from class: androidx.g.q.1
                    @Override // androidx.g.n, androidx.g.m.c
                    public void a(m mVar3) {
                        mVar2.e();
                        mVar3.b(this);
                    }
                });
            }
            m mVar3 = this.j.get(0);
            if (mVar3 != null) {
                mVar3.e();
                return;
            }
            return;
        }
        Iterator<m> it = this.j.iterator();
        while (it.hasNext()) {
            it.next().e();
        }
    }

    @Override // androidx.g.m
    public void a(s sVar) {
        if (a(sVar.b)) {
            Iterator<m> it = this.j.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next.a(sVar.b)) {
                    next.a(sVar);
                    sVar.c.add(next);
                }
            }
        }
    }

    @Override // androidx.g.m
    public void b(s sVar) {
        if (a(sVar.b)) {
            Iterator<m> it = this.j.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next.a(sVar.b)) {
                    next.b(sVar);
                    sVar.c.add(next);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.g.m
    public void c(s sVar) {
        super.c(sVar);
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            this.j.get(i).c(sVar);
        }
    }

    @Override // androidx.g.m
    public void d(View view) {
        super.d(view);
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            this.j.get(i).d(view);
        }
    }

    @Override // androidx.g.m
    public void e(View view) {
        super.e(view);
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            this.j.get(i).e(view);
        }
    }

    @Override // androidx.g.m
    public void a(p pVar) {
        super.a(pVar);
        this.l |= 2;
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            this.j.get(i).a(pVar);
        }
    }

    @Override // androidx.g.m
    public void a(m.b bVar) {
        super.a(bVar);
        this.l |= 8;
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            this.j.get(i).a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.g.m
    public String a(String str) {
        String a2 = super.a(str);
        for (int i = 0; i < this.j.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(a2);
            sb.append("\n");
            sb.append(this.j.get(i).a(str + "  "));
            a2 = sb.toString();
        }
        return a2;
    }

    @Override // androidx.g.m
    /* renamed from: o */
    public m clone() {
        q qVar = (q) super.clone();
        qVar.j = new ArrayList<>();
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            qVar.a(this.j.get(i).clone());
        }
        return qVar;
    }
}
