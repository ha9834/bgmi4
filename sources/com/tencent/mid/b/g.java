package com.tencent.mid.b;

import android.content.Context;
import com.tencent.mid.api.MidEntity;
import com.tencent.mid.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class g {
    private static g h;
    private Map<Integer, f> e;
    private Context f;
    private com.tencent.mid.util.d g = Util.getLogger();

    /* renamed from: a, reason: collision with root package name */
    Map<Integer, f> f6263a = null;
    MidEntity b = null;
    Map<Integer, f> c = null;
    private MidEntity i = null;
    boolean d = true;

    private g(Context context) {
        this.e = null;
        this.f = null;
        this.f = context.getApplicationContext();
        this.e = new HashMap(3);
        this.e.put(1, new e(context, 3));
        this.e.put(2, new c(context, 3));
        this.e.put(4, new d(context, 3));
    }

    public static synchronized g a(Context context) {
        g gVar;
        synchronized (g.class) {
            if (h == null) {
                h = new g(context);
            }
            gVar = h;
        }
        return gVar;
    }

    private Map<Integer, f> m() {
        if (this.f6263a == null) {
            this.f6263a = new HashMap(3);
            this.f6263a.put(1, new e(this.f, 1000001));
            this.f6263a.put(2, new c(this.f, 1000001));
            this.f6263a.put(4, new d(this.f, 1000001));
        }
        return this.f6263a;
    }

    public MidEntity a() {
        m();
        if (!Util.isMidValid(this.b)) {
            this.b = a(new ArrayList(Arrays.asList(4, 1, 2)), this.f6263a);
        }
        this.g.h("readNewVersionMidEntity:" + this.b);
        return this.b;
    }

    public String b() {
        a();
        return Util.isMidValid(this.b) ? this.b.getMid() : "";
    }

    public void a(MidEntity midEntity) {
        a(midEntity, true);
    }

    public void a(MidEntity midEntity, boolean z) {
        Context context;
        if (midEntity.getTimestamps() <= 0) {
            midEntity.setTimestamps(System.currentTimeMillis());
        }
        this.g.h("writeNewVersionMidEntity midEntity:" + midEntity);
        Iterator<Map.Entry<Integer, f>> it = m().entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().a(midEntity);
        }
        if (!z || (context = this.f) == null) {
            return;
        }
        Util.insertMid2Provider(context, context.getPackageName(), midEntity.toString());
    }

    public MidEntity c() {
        return a(4, m());
    }

    public MidEntity d() {
        return a(1, m());
    }

    public MidEntity e() {
        return a(2, m());
    }

    public void b(MidEntity midEntity) {
        m();
        f fVar = this.f6263a.get(4);
        if (fVar != null) {
            fVar.a(midEntity);
        }
    }

    public void c(MidEntity midEntity) {
        m();
        f fVar = this.f6263a.get(1);
        if (fVar != null) {
            fVar.a(midEntity);
        }
        f fVar2 = this.f6263a.get(2);
        if (fVar2 != null) {
            fVar2.a(midEntity);
        }
    }

    private Map<Integer, f> n() {
        if (this.c == null) {
            this.c = new HashMap(3);
            this.c.put(1, new e(this.f, 0));
            this.c.put(2, new c(this.f, 0));
            this.c.put(4, new d(this.f, 0));
        }
        return this.c;
    }

    public String f() {
        try {
            h();
            return this.i != null ? this.i.getMid() : "0";
        } catch (Throwable th) {
            this.g.f("readMidString " + th);
            return "0";
        }
    }

    public long g() {
        try {
            h();
            if (this.i != null) {
                return this.i.getGuid();
            }
            return 0L;
        } catch (Throwable th) {
            this.g.f("readMidString " + th);
            return 0L;
        }
    }

    public MidEntity h() {
        if (!Util.isMidValid(this.i)) {
            this.g.h("read the new one");
            this.i = a(new ArrayList(Arrays.asList(4)), this.e);
        }
        if (!Util.isMidValid(this.i)) {
            this.g.h("load from the old one");
            MidEntity a2 = a(new ArrayList(Arrays.asList(4)), n());
            if (Util.isMidValid(a2)) {
                this.g.d("copy old mid:" + a2.getMid() + " to new version.");
                this.i = a2;
                f(this.i);
            }
        }
        if (!Util.isMidValid(this.i)) {
            this.g.h("mid query other app");
            Map<String, MidEntity> midsByApps = Util.getMidsByApps(this.f, 2);
            if (midsByApps != null && midsByApps.size() > 0) {
                Iterator<Map.Entry<String, MidEntity>> it = midsByApps.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    MidEntity value = it.next().getValue();
                    if (value != null && value.isMidValid()) {
                        this.i = value;
                        break;
                    }
                }
            }
        }
        if (!Util.isMidValid(this.i)) {
            this.g.h("read the new one");
            this.i = a(new ArrayList(Arrays.asList(4, 1, 2)), this.e);
        }
        if (!Util.isMidValid(this.i)) {
            this.g.h("load from the old one");
            MidEntity a3 = a(new ArrayList(Arrays.asList(1, 2, 4)), n());
            if (Util.isMidValid(a3)) {
                this.g.d("copy old mid:" + a3.getMid() + " to new version.");
                this.i = a3;
                f(this.i);
            }
        }
        if (this.d) {
            this.g.h("firstRead");
            MidEntity i = i();
            if (i == null || !i.isMidValid()) {
                d(this.i);
            }
            this.d = false;
        }
        MidEntity midEntity = this.i;
        return midEntity != null ? midEntity : new MidEntity();
    }

    public MidEntity a(List<Integer> list) {
        return a(list, this.e);
    }

    public void d(MidEntity midEntity) {
        f fVar = this.e.get(4);
        if (fVar != null) {
            fVar.a(midEntity);
        }
    }

    public void e(MidEntity midEntity) {
        f fVar = this.e.get(1);
        if (fVar != null) {
            fVar.a(midEntity);
        }
        f fVar2 = this.e.get(2);
        if (fVar2 != null) {
            fVar2.a(midEntity);
        }
    }

    public MidEntity i() {
        return a(4, this.e);
    }

    public MidEntity j() {
        return a(1, this.e);
    }

    public MidEntity k() {
        return a(2, this.e);
    }

    private MidEntity a(int i, Map<Integer, f> map) {
        f fVar;
        if (this.e == null || (fVar = map.get(Integer.valueOf(i))) == null) {
            return null;
        }
        return fVar.i();
    }

    public MidEntity a(List<Integer> list, Map<Integer, f> map) {
        MidEntity i;
        if (list == null || list.size() == 0 || map == null || map.size() == 0) {
            return null;
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            f fVar = map.get(it.next());
            if (fVar != null && (i = fVar.i()) != null && i.isMidValid()) {
                return i;
            }
        }
        return null;
    }

    public void a(int i, int i2) {
        a l = l();
        if (i > 0) {
            l.c(i);
        }
        if (i2 > 0) {
            l.a(i2);
        }
        l.a(System.currentTimeMillis());
        l.b(0);
        a(l);
    }

    public a l() {
        return b(new ArrayList(Arrays.asList(1, 4)));
    }

    public a b(List<Integer> list) {
        a j;
        if (list == null || list.size() == 0) {
            return null;
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            f fVar = this.e.get(it.next());
            if (fVar != null && (j = fVar.j()) != null) {
                return j;
            }
        }
        return null;
    }

    public void a(a aVar) {
        if (aVar.b() <= 0) {
            aVar.a(System.currentTimeMillis());
        }
        Iterator<Map.Entry<Integer, f>> it = this.e.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().b(aVar);
        }
    }

    public void f(MidEntity midEntity) {
        if (midEntity.getTimestamps() <= 0) {
            midEntity.setTimestamps(System.currentTimeMillis());
        }
        Iterator<Map.Entry<Integer, f>> it = this.e.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().a(midEntity);
        }
    }

    public void b(MidEntity midEntity, boolean z) {
        Context context;
        if (midEntity.getTimestamps() <= 0) {
            midEntity.setTimestamps(System.currentTimeMillis());
        }
        Iterator<Map.Entry<Integer, f>> it = this.e.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().a(midEntity);
        }
        if (!z || (context = this.f) == null) {
            return;
        }
        Util.insertMid2OldProvider(context, context.getPackageName(), midEntity.toString());
    }

    public void g(MidEntity midEntity) {
        if (midEntity.getTimestamps() <= 0) {
            midEntity.setTimestamps(System.currentTimeMillis());
        }
        Iterator<Map.Entry<Integer, f>> it = n().entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().a(midEntity);
        }
    }
}
