package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* loaded from: classes.dex */
public class j extends androidx.core.f.a {

    /* renamed from: a, reason: collision with root package name */
    final RecyclerView f903a;
    final androidx.core.f.a b = new a(this);

    public j(RecyclerView recyclerView) {
        this.f903a = recyclerView;
    }

    boolean b() {
        return this.f903a.hasPendingAdapterUpdates();
    }

    @Override // androidx.core.f.a
    public boolean a(View view, int i, Bundle bundle) {
        if (super.a(view, i, bundle)) {
            return true;
        }
        if (b() || this.f903a.getLayoutManager() == null) {
            return false;
        }
        return this.f903a.getLayoutManager().a(i, bundle);
    }

    @Override // androidx.core.f.a
    public void a(View view, androidx.core.f.a.d dVar) {
        super.a(view, dVar);
        dVar.a((CharSequence) RecyclerView.class.getName());
        if (b() || this.f903a.getLayoutManager() == null) {
            return;
        }
        this.f903a.getLayoutManager().a(dVar);
    }

    @Override // androidx.core.f.a
    public void d(View view, AccessibilityEvent accessibilityEvent) {
        super.d(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if (!(view instanceof RecyclerView) || b()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().a(accessibilityEvent);
        }
    }

    public androidx.core.f.a c() {
        return this.b;
    }

    /* loaded from: classes.dex */
    public static class a extends androidx.core.f.a {

        /* renamed from: a, reason: collision with root package name */
        final j f904a;

        public a(j jVar) {
            this.f904a = jVar;
        }

        @Override // androidx.core.f.a
        public void a(View view, androidx.core.f.a.d dVar) {
            super.a(view, dVar);
            if (this.f904a.b() || this.f904a.f903a.getLayoutManager() == null) {
                return;
            }
            this.f904a.f903a.getLayoutManager().a(view, dVar);
        }

        @Override // androidx.core.f.a
        public boolean a(View view, int i, Bundle bundle) {
            if (super.a(view, i, bundle)) {
                return true;
            }
            if (this.f904a.b() || this.f904a.f903a.getLayoutManager() == null) {
                return false;
            }
            return this.f904a.f903a.getLayoutManager().a(view, i, bundle);
        }
    }
}
