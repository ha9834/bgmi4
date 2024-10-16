package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.b;
import java.util.Iterator;

/* loaded from: classes.dex */
final class SavedStateHandleController implements i {

    /* renamed from: a, reason: collision with root package name */
    private final String f778a;
    private boolean b = false;
    private final t c;

    SavedStateHandleController(String str, t tVar) {
        this.f778a = str;
        this.c = tVar;
    }

    boolean a() {
        return this.b;
    }

    void a(androidx.savedstate.b bVar, Lifecycle lifecycle) {
        if (this.b) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.b = true;
        lifecycle.a(this);
        bVar.a(this.f778a, this.c.a());
    }

    @Override // androidx.lifecycle.i
    public void a(k kVar, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.b = false;
            kVar.getLifecycle().b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public t b() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SavedStateHandleController a(androidx.savedstate.b bVar, Lifecycle lifecycle, String str, Bundle bundle) {
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, t.a(bVar.a(str), bundle));
        savedStateHandleController.a(bVar, lifecycle);
        b(bVar, lifecycle);
        return savedStateHandleController;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a implements b.a {
        a() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.savedstate.b.a
        public void a(androidx.savedstate.d dVar) {
            if (!(dVar instanceof y)) {
                throw new IllegalStateException("Internal error: OnRecreation should be registered only on componentsthat implement ViewModelStoreOwner");
            }
            x viewModelStore = ((y) dVar).getViewModelStore();
            androidx.savedstate.b savedStateRegistry = dVar.getSavedStateRegistry();
            Iterator<String> it = viewModelStore.a().iterator();
            while (it.hasNext()) {
                SavedStateHandleController.a(viewModelStore.a(it.next()), savedStateRegistry, dVar.getLifecycle());
            }
            if (viewModelStore.a().isEmpty()) {
                return;
            }
            savedStateRegistry.a(a.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(v vVar, androidx.savedstate.b bVar, Lifecycle lifecycle) {
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) vVar.b("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController == null || savedStateHandleController.a()) {
            return;
        }
        savedStateHandleController.a(bVar, lifecycle);
        b(bVar, lifecycle);
    }

    private static void b(final androidx.savedstate.b bVar, final Lifecycle lifecycle) {
        Lifecycle.State a2 = lifecycle.a();
        if (a2 == Lifecycle.State.INITIALIZED || a2.a(Lifecycle.State.STARTED)) {
            bVar.a(a.class);
        } else {
            lifecycle.a(new i() { // from class: androidx.lifecycle.SavedStateHandleController.1
                @Override // androidx.lifecycle.i
                public void a(k kVar, Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_START) {
                        Lifecycle.this.b(this);
                        bVar.a(a.class);
                    }
                }
            });
        }
    }
}
