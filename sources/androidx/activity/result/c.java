package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.result.c;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.i;
import androidx.lifecycle.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private Random f132a = new Random();
    private final Map<Integer, String> g = new HashMap();
    final Map<String, Integer> b = new HashMap();
    private final Map<String, b> h = new HashMap();
    ArrayList<String> c = new ArrayList<>();
    final transient Map<String, a<?>> d = new HashMap();
    final Map<String, Object> e = new HashMap();
    final Bundle f = new Bundle();

    public abstract <I, O> void a(int i, androidx.activity.result.a.a<I, O> aVar, @SuppressLint({"UnknownNullness"}) I i2, androidx.core.app.b bVar);

    public final <I, O> androidx.activity.result.b<I> a(final String str, k kVar, final androidx.activity.result.a.a<I, O> aVar, final androidx.activity.result.a<O> aVar2) {
        Lifecycle lifecycle = kVar.getLifecycle();
        if (lifecycle.a().a(Lifecycle.State.STARTED)) {
            throw new IllegalStateException("LifecycleOwner " + kVar + " is attempting to register while current state is " + lifecycle.a() + ". LifecycleOwners must call register before they are STARTED.");
        }
        final int b2 = b(str);
        b bVar = this.h.get(str);
        if (bVar == null) {
            bVar = new b(lifecycle);
        }
        bVar.a(new i() { // from class: androidx.activity.result.ActivityResultRegistry$1
            @Override // androidx.lifecycle.i
            public void a(k kVar2, Lifecycle.Event event) {
                if (Lifecycle.Event.ON_START.equals(event)) {
                    c.this.d.put(str, new c.a<>(aVar2, aVar));
                    if (c.this.e.containsKey(str)) {
                        Object obj = c.this.e.get(str);
                        c.this.e.remove(str);
                        aVar2.a(obj);
                    }
                    ActivityResult activityResult = (ActivityResult) c.this.f.getParcelable(str);
                    if (activityResult != null) {
                        c.this.f.remove(str);
                        aVar2.a(aVar.a(activityResult.a(), activityResult.b()));
                        return;
                    }
                    return;
                }
                if (Lifecycle.Event.ON_STOP.equals(event)) {
                    c.this.d.remove(str);
                } else if (Lifecycle.Event.ON_DESTROY.equals(event)) {
                    c.this.a(str);
                }
            }
        });
        this.h.put(str, bVar);
        return new androidx.activity.result.b<I>() { // from class: androidx.activity.result.c.1
            @Override // androidx.activity.result.b
            public void a(I i, androidx.core.app.b bVar2) {
                c.this.c.add(str);
                Integer num = c.this.b.get(str);
                c.this.a(num != null ? num.intValue() : b2, (androidx.activity.result.a.a<androidx.activity.result.a.a, O>) aVar, (androidx.activity.result.a.a) i, bVar2);
            }

            @Override // androidx.activity.result.b
            public void a() {
                c.this.a(str);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <I, O> androidx.activity.result.b<I> a(final String str, final androidx.activity.result.a.a<I, O> aVar, androidx.activity.result.a<O> aVar2) {
        final int b2 = b(str);
        this.d.put(str, new a<>(aVar2, aVar));
        if (this.e.containsKey(str)) {
            Object obj = this.e.get(str);
            this.e.remove(str);
            aVar2.a(obj);
        }
        ActivityResult activityResult = (ActivityResult) this.f.getParcelable(str);
        if (activityResult != null) {
            this.f.remove(str);
            aVar2.a(aVar.a(activityResult.a(), activityResult.b()));
        }
        return new androidx.activity.result.b<I>() { // from class: androidx.activity.result.c.2
            @Override // androidx.activity.result.b
            public void a(I i, androidx.core.app.b bVar) {
                c.this.c.add(str);
                Integer num = c.this.b.get(str);
                c.this.a(num != null ? num.intValue() : b2, (androidx.activity.result.a.a<androidx.activity.result.a.a, O>) aVar, (androidx.activity.result.a.a) i, bVar);
            }

            @Override // androidx.activity.result.b
            public void a() {
                c.this.a(str);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str) {
        Integer remove;
        if (!this.c.contains(str) && (remove = this.b.remove(str)) != null) {
            this.g.remove(remove);
        }
        this.d.remove(str);
        if (this.e.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.e.get(str));
            this.e.remove(str);
        }
        if (this.f.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f.getParcelable(str));
            this.f.remove(str);
        }
        b bVar = this.h.get(str);
        if (bVar != null) {
            bVar.a();
            this.h.remove(str);
        }
    }

    public final void a(Bundle bundle) {
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(this.b.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(this.b.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(this.c));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) this.f.clone());
        bundle.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", this.f132a);
    }

    public final void b(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (stringArrayList == null || integerArrayList == null) {
            return;
        }
        this.c = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
        this.f132a = (Random) bundle.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
        this.f.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
        for (int i = 0; i < stringArrayList.size(); i++) {
            String str = stringArrayList.get(i);
            if (this.b.containsKey(str)) {
                Integer remove = this.b.remove(str);
                if (!this.f.containsKey(str)) {
                    this.g.remove(remove);
                }
            }
            a(integerArrayList.get(i).intValue(), stringArrayList.get(i));
        }
    }

    public final boolean a(int i, int i2, Intent intent) {
        String str = this.g.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        this.c.remove(str);
        a(str, i2, intent, this.d.get(str));
        return true;
    }

    public final <O> boolean a(int i, @SuppressLint({"UnknownNullness"}) O o) {
        String str = this.g.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        this.c.remove(str);
        a<?> aVar = this.d.get(str);
        if (aVar == null || aVar.f135a == null) {
            this.f.remove(str);
            this.e.put(str, o);
            return true;
        }
        aVar.f135a.a(o);
        return true;
    }

    private <O> void a(String str, int i, Intent intent, a<O> aVar) {
        if (aVar != null && aVar.f135a != null) {
            aVar.f135a.a(aVar.b.a(i, intent));
        } else {
            this.e.remove(str);
            this.f.putParcelable(str, new ActivityResult(i, intent));
        }
    }

    private int b(String str) {
        Integer num = this.b.get(str);
        if (num != null) {
            return num.intValue();
        }
        int a2 = a();
        a(a2, str);
        return a2;
    }

    private int a() {
        int nextInt = this.f132a.nextInt(2147418112);
        while (true) {
            int i = nextInt + 65536;
            if (!this.g.containsKey(Integer.valueOf(i))) {
                return i;
            }
            nextInt = this.f132a.nextInt(2147418112);
        }
    }

    private void a(int i, String str) {
        this.g.put(Integer.valueOf(i), str);
        this.b.put(str, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<O> {

        /* renamed from: a, reason: collision with root package name */
        final androidx.activity.result.a<O> f135a;
        final androidx.activity.result.a.a<?, O> b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(androidx.activity.result.a<O> aVar, androidx.activity.result.a.a<?, O> aVar2) {
            this.f135a = aVar;
            this.b = aVar2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        final Lifecycle f136a;
        private final ArrayList<i> b = new ArrayList<>();

        b(Lifecycle lifecycle) {
            this.f136a = lifecycle;
        }

        void a(i iVar) {
            this.f136a.a(iVar);
            this.b.add(iVar);
        }

        void a() {
            Iterator<i> it = this.b.iterator();
            while (it.hasNext()) {
                this.f136a.b(it.next());
            }
            this.b.clear();
        }
    }
}
