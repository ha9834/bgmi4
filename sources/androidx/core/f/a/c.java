package androidx.core.f.a;

import android.os.Build;
import android.view.accessibility.AccessibilityManager;

/* loaded from: classes.dex */
public final class c {

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z);
    }

    public static boolean a(AccessibilityManager accessibilityManager, a aVar) {
        if (Build.VERSION.SDK_INT < 19 || aVar == null) {
            return false;
        }
        return accessibilityManager.addTouchExplorationStateChangeListener(new b(aVar));
    }

    public static boolean b(AccessibilityManager accessibilityManager, a aVar) {
        if (Build.VERSION.SDK_INT < 19 || aVar == null) {
            return false;
        }
        return accessibilityManager.removeTouchExplorationStateChangeListener(new b(aVar));
    }

    /* loaded from: classes.dex */
    private static final class b implements AccessibilityManager.TouchExplorationStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final a f521a;

        b(a aVar) {
            this.f521a = aVar;
        }

        public int hashCode() {
            return this.f521a.hashCode();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                return this.f521a.equals(((b) obj).f521a);
            }
            return false;
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public void onTouchExplorationStateChanged(boolean z) {
            this.f521a.a(z);
        }
    }
}
