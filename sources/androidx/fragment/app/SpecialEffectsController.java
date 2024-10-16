package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.b;
import androidx.fragment.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class SpecialEffectsController {

    /* renamed from: a, reason: collision with root package name */
    final ArrayList<Operation> f632a = new ArrayList<>();
    final ArrayList<Operation> b = new ArrayList<>();
    boolean c = false;
    boolean d = false;
    private final ViewGroup e;

    abstract void a(List<Operation> list, boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SpecialEffectsController a(ViewGroup viewGroup, FragmentManager fragmentManager) {
        return a(viewGroup, fragmentManager.F());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SpecialEffectsController a(ViewGroup viewGroup, z zVar) {
        Object tag = viewGroup.getTag(a.b.special_effects_controller_view_tag);
        if (tag instanceof SpecialEffectsController) {
            return (SpecialEffectsController) tag;
        }
        SpecialEffectsController a2 = zVar.a(viewGroup);
        viewGroup.setTag(a.b.special_effects_controller_view_tag, a2);
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SpecialEffectsController(ViewGroup viewGroup) {
        this.e = viewGroup;
    }

    public ViewGroup a() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Operation.LifecycleImpact a(p pVar) {
        Operation a2 = a(pVar.a());
        Operation.LifecycleImpact d = a2 != null ? a2.d() : null;
        Operation b = b(pVar.a());
        return (b == null || !(d == null || d == Operation.LifecycleImpact.NONE)) ? d : b.d();
    }

    private Operation a(Fragment fragment) {
        Iterator<Operation> it = this.f632a.iterator();
        while (it.hasNext()) {
            Operation next = it.next();
            if (next.e().equals(fragment) && !next.f()) {
                return next;
            }
        }
        return null;
    }

    private Operation b(Fragment fragment) {
        Iterator<Operation> it = this.b.iterator();
        while (it.hasNext()) {
            Operation next = it.next();
            if (next.e().equals(fragment) && !next.f()) {
                return next;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Operation.State state, p pVar) {
        if (FragmentManager.a(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + pVar.a());
        }
        a(state, Operation.LifecycleImpact.ADDING, pVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(p pVar) {
        if (FragmentManager.a(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + pVar.a());
        }
        a(Operation.State.VISIBLE, Operation.LifecycleImpact.NONE, pVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(p pVar) {
        if (FragmentManager.a(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + pVar.a());
        }
        a(Operation.State.GONE, Operation.LifecycleImpact.NONE, pVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(p pVar) {
        if (FragmentManager.a(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + pVar.a());
        }
        a(Operation.State.REMOVED, Operation.LifecycleImpact.REMOVING, pVar);
    }

    private void a(Operation.State state, Operation.LifecycleImpact lifecycleImpact, p pVar) {
        synchronized (this.f632a) {
            androidx.core.os.b bVar = new androidx.core.os.b();
            Operation a2 = a(pVar.a());
            if (a2 != null) {
                a2.a(state, lifecycleImpact);
                return;
            }
            final a aVar = new a(state, lifecycleImpact, pVar, bVar);
            this.f632a.add(aVar);
            aVar.a(new Runnable() { // from class: androidx.fragment.app.SpecialEffectsController.1
                @Override // java.lang.Runnable
                public void run() {
                    if (SpecialEffectsController.this.f632a.contains(aVar)) {
                        aVar.c().b(aVar.e().mView);
                    }
                }
            });
            aVar.a(new Runnable() { // from class: androidx.fragment.app.SpecialEffectsController.2
                @Override // java.lang.Runnable
                public void run() {
                    SpecialEffectsController.this.f632a.remove(aVar);
                    SpecialEffectsController.this.b.remove(aVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        this.c = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void b() {
        synchronized (this.f632a) {
            f();
            this.d = false;
            int size = this.f632a.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                Operation operation = this.f632a.get(size);
                Operation.State a2 = Operation.State.a(operation.e().mView);
                if (operation.c() == Operation.State.VISIBLE && a2 != Operation.State.VISIBLE) {
                    this.d = operation.e().isPostponed();
                    break;
                }
                size--;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (this.d) {
            this.d = false;
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void d() {
        if (this.d) {
            return;
        }
        if (!androidx.core.f.v.A(this.e)) {
            e();
            this.c = false;
            return;
        }
        synchronized (this.f632a) {
            if (!this.f632a.isEmpty()) {
                ArrayList arrayList = new ArrayList(this.b);
                this.b.clear();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Operation operation = (Operation) it.next();
                    if (FragmentManager.a(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + operation);
                    }
                    operation.g();
                    if (!operation.h()) {
                        this.b.add(operation);
                    }
                }
                f();
                ArrayList arrayList2 = new ArrayList(this.f632a);
                this.f632a.clear();
                this.b.addAll(arrayList2);
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    ((Operation) it2.next()).a();
                }
                a(arrayList2, this.c);
                this.c = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void e() {
        String str;
        String str2;
        boolean A = androidx.core.f.v.A(this.e);
        synchronized (this.f632a) {
            f();
            Iterator<Operation> it = this.f632a.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            Iterator it2 = new ArrayList(this.b).iterator();
            while (it2.hasNext()) {
                Operation operation = (Operation) it2.next();
                if (FragmentManager.a(2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("SpecialEffectsController: ");
                    if (A) {
                        str2 = "";
                    } else {
                        str2 = "Container " + this.e + " is not attached to window. ";
                    }
                    sb.append(str2);
                    sb.append("Cancelling running operation ");
                    sb.append(operation);
                    Log.v("FragmentManager", sb.toString());
                }
                operation.g();
            }
            Iterator it3 = new ArrayList(this.f632a).iterator();
            while (it3.hasNext()) {
                Operation operation2 = (Operation) it3.next();
                if (FragmentManager.a(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("SpecialEffectsController: ");
                    if (A) {
                        str = "";
                    } else {
                        str = "Container " + this.e + " is not attached to window. ";
                    }
                    sb2.append(str);
                    sb2.append("Cancelling pending operation ");
                    sb2.append(operation2);
                    Log.v("FragmentManager", sb2.toString());
                }
                operation2.g();
            }
        }
    }

    private void f() {
        Iterator<Operation> it = this.f632a.iterator();
        while (it.hasNext()) {
            Operation next = it.next();
            if (next.d() == Operation.LifecycleImpact.ADDING) {
                next.a(Operation.State.a(next.e().requireView().getVisibility()), Operation.LifecycleImpact.NONE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Operation {

        /* renamed from: a, reason: collision with root package name */
        private State f636a;
        private LifecycleImpact b;
        private final Fragment c;
        private final List<Runnable> d = new ArrayList();
        private final HashSet<androidx.core.os.b> e = new HashSet<>();
        private boolean f = false;
        private boolean g = false;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public enum LifecycleImpact {
            NONE,
            ADDING,
            REMOVING
        }

        void a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public enum State {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            /* JADX INFO: Access modifiers changed from: package-private */
            public static State a(View view) {
                if (view.getAlpha() == 0.0f && view.getVisibility() == 0) {
                    return INVISIBLE;
                }
                return a(view.getVisibility());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public static State a(int i) {
                if (i == 0) {
                    return VISIBLE;
                }
                if (i == 4) {
                    return INVISIBLE;
                }
                if (i == 8) {
                    return GONE;
                }
                throw new IllegalArgumentException("Unknown visibility " + i);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public void b(View view) {
                switch (this) {
                    case REMOVED:
                        ViewGroup viewGroup = (ViewGroup) view.getParent();
                        if (viewGroup != null) {
                            if (FragmentManager.a(2)) {
                                Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                            }
                            viewGroup.removeView(view);
                            return;
                        }
                        return;
                    case VISIBLE:
                        if (FragmentManager.a(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                        }
                        view.setVisibility(0);
                        return;
                    case GONE:
                        if (FragmentManager.a(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                        }
                        view.setVisibility(8);
                        return;
                    case INVISIBLE:
                        if (FragmentManager.a(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                        }
                        view.setVisibility(4);
                        return;
                    default:
                        return;
                }
            }
        }

        Operation(State state, LifecycleImpact lifecycleImpact, Fragment fragment, androidx.core.os.b bVar) {
            this.f636a = state;
            this.b = lifecycleImpact;
            this.c = fragment;
            bVar.a(new b.a() { // from class: androidx.fragment.app.SpecialEffectsController.Operation.1
                @Override // androidx.core.os.b.a
                public void a() {
                    Operation.this.g();
                }
            });
        }

        public State c() {
            return this.f636a;
        }

        LifecycleImpact d() {
            return this.b;
        }

        public final Fragment e() {
            return this.c;
        }

        final boolean f() {
            return this.f;
        }

        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + this.f636a + "} {mLifecycleImpact = " + this.b + "} {mFragment = " + this.c + "}";
        }

        final void g() {
            if (f()) {
                return;
            }
            this.f = true;
            if (this.e.isEmpty()) {
                b();
                return;
            }
            Iterator it = new ArrayList(this.e).iterator();
            while (it.hasNext()) {
                ((androidx.core.os.b) it.next()).b();
            }
        }

        final void a(State state, LifecycleImpact lifecycleImpact) {
            switch (lifecycleImpact) {
                case ADDING:
                    if (this.f636a == State.REMOVED) {
                        if (FragmentManager.a(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.c + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.b + " to ADDING.");
                        }
                        this.f636a = State.VISIBLE;
                        this.b = LifecycleImpact.ADDING;
                        return;
                    }
                    return;
                case REMOVING:
                    if (FragmentManager.a(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.c + " mFinalState = " + this.f636a + " -> REMOVED. mLifecycleImpact  = " + this.b + " to REMOVING.");
                    }
                    this.f636a = State.REMOVED;
                    this.b = LifecycleImpact.REMOVING;
                    return;
                case NONE:
                    if (this.f636a != State.REMOVED) {
                        if (FragmentManager.a(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.c + " mFinalState = " + this.f636a + " -> " + state + ". ");
                        }
                        this.f636a = state;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void a(Runnable runnable) {
            this.d.add(runnable);
        }

        public final void a(androidx.core.os.b bVar) {
            a();
            this.e.add(bVar);
        }

        public final void b(androidx.core.os.b bVar) {
            if (this.e.remove(bVar) && this.e.isEmpty()) {
                b();
            }
        }

        final boolean h() {
            return this.g;
        }

        public void b() {
            if (this.g) {
                return;
            }
            if (FragmentManager.a(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.g = true;
            Iterator<Runnable> it = this.d.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends Operation {

        /* renamed from: a, reason: collision with root package name */
        private final p f640a;

        a(Operation.State state, Operation.LifecycleImpact lifecycleImpact, p pVar, androidx.core.os.b bVar) {
            super(state, lifecycleImpact, pVar.a(), bVar);
            this.f640a = pVar;
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        void a() {
            if (d() == Operation.LifecycleImpact.ADDING) {
                Fragment a2 = this.f640a.a();
                View findFocus = a2.mView.findFocus();
                if (findFocus != null) {
                    a2.setFocusedView(findFocus);
                    if (FragmentManager.a(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + a2);
                    }
                }
                View requireView = e().requireView();
                if (requireView.getParent() == null) {
                    this.f640a.s();
                    requireView.setAlpha(0.0f);
                }
                if (requireView.getAlpha() == 0.0f && requireView.getVisibility() == 0) {
                    requireView.setVisibility(4);
                }
                requireView.setAlpha(a2.getPostOnViewCreatedAlpha());
            }
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        public void b() {
            super.b();
            this.f640a.c();
        }
    }
}
