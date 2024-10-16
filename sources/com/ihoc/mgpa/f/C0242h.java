package com.ihoc.mgpa.f;

import java.util.ArrayList;
import java.util.Comparator;

/* renamed from: com.ihoc.mgpa.f.h, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C0242h {

    /* renamed from: a, reason: collision with root package name */
    private static volatile C0242h f5531a;
    public static Comparator<a> b = new C0241g();
    private com.ihoc.mgpa.g.B c;
    private int d;
    private int e;
    private ArrayList<Integer> f = new ArrayList<>();
    private ArrayList<Integer> g = new ArrayList<>();
    private ArrayList<Integer> h = new ArrayList<>();
    private ArrayList<Integer> i = new ArrayList<>();
    private ArrayList<Integer> j = new ArrayList<>();

    /* renamed from: com.ihoc.mgpa.f.h$a */
    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public int f5532a;
    }

    private C0242h() {
    }

    public static C0242h a() {
        if (f5531a == null) {
            synchronized (C0242h.class) {
                if (f5531a == null) {
                    f5531a = new C0242h();
                }
            }
        }
        return f5531a;
    }

    private void a(int i) {
        ArrayList<Integer> arrayList;
        int a2 = this.c.a(i);
        int b2 = this.c.b(a2);
        com.ihoc.mgpa.n.m.a("TGPA", "SceneTypeControler:deleteStartActionSceneInArray: startSceneID: " + a2 + ", stopSceneID: " + i + ", level: " + b2);
        if (b2 == 5) {
            arrayList = this.j;
        } else if (b2 == 4) {
            arrayList = this.i;
        } else if (b2 == 3) {
            arrayList = this.h;
        } else if (b2 == 2) {
            arrayList = this.g;
        } else {
            if (b2 != 1) {
                com.ihoc.mgpa.n.m.a("TGPA", "SceneTypeControler: can not find scene in action Array. ");
                return;
            }
            arrayList = this.f;
        }
        a(a2, arrayList);
    }

    private void a(int i, ArrayList<Integer> arrayList) {
        if (arrayList != null) {
            int indexOf = arrayList.indexOf(Integer.valueOf(i));
            if (indexOf != -1) {
                arrayList.remove(indexOf);
                return;
            }
            com.ihoc.mgpa.n.m.a("TGPA", "SceneTypeControler:deleteValueInArray: can not find sceneID: " + i);
        }
    }

    private void b() {
        this.f.clear();
        this.g.clear();
        this.h.clear();
        this.i.clear();
        this.j.clear();
    }

    private void b(int i) {
        int b2 = this.c.b(i);
        b(i, b2 == 5 ? this.j : b2 == 4 ? this.i : b2 == 3 ? this.h : b2 == 2 ? this.g : this.f);
    }

    private void b(int i, ArrayList<Integer> arrayList) {
        com.ihoc.mgpa.n.m.a("TGPA", "SceneTypeControler:saveStartActionSceneToArray: sceneID: " + i);
        com.ihoc.mgpa.n.m.a("TGPA", "SceneTypeControler:saveStartActionSceneToArray: arrayList: " + arrayList.toString());
        if (arrayList.contains(Integer.valueOf(i))) {
            return;
        }
        arrayList.add(Integer.valueOf(i));
    }

    private void c() {
        int i;
        ArrayList<Integer> arrayList;
        if (this.j.size() > 0) {
            arrayList = this.j;
        } else if (this.i.size() > 0) {
            arrayList = this.i;
        } else if (this.h.size() > 0) {
            arrayList = this.h;
        } else if (this.g.size() > 0) {
            arrayList = this.g;
        } else {
            if (this.f.size() <= 0) {
                i = -1;
                this.e = i;
            }
            arrayList = this.f;
        }
        i = arrayList.get(arrayList.size() - 1).intValue();
        this.e = i;
    }

    public int a(String str) {
        if (this.c == null) {
            return -2;
        }
        int parseInt = Integer.parseInt(str);
        if (this.c.c(parseInt)) {
            this.d = parseInt;
            if (this.c.d(parseInt)) {
                b();
                this.e = -1;
                return parseInt;
            }
            if (this.e == -1) {
                return parseInt;
            }
            return -1;
        }
        if (this.c.e(parseInt)) {
            if (this.e == -1) {
                this.e = parseInt;
                b(parseInt);
                return parseInt;
            }
            if (this.c.b(parseInt) < this.c.b(this.e)) {
                b(parseInt);
                return -1;
            }
            this.e = parseInt;
            b(parseInt);
            return parseInt;
        }
        if (!this.c.f(parseInt)) {
            return parseInt;
        }
        a(parseInt);
        c();
        com.ihoc.mgpa.n.m.a("TGPA", "SceneTypeControler:  stop action scene, now doing scene: " + this.e);
        int i = this.e;
        return i == -1 ? this.d : i;
    }

    public void a(com.ihoc.mgpa.g.B b2) {
        this.c = b2;
    }
}
