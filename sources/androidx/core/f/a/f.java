package androidx.core.f.a;

import android.os.Build;
import android.view.accessibility.AccessibilityRecord;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final AccessibilityRecord f528a;

    public static void a(AccessibilityRecord accessibilityRecord, int i) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollX(i);
        }
    }

    public static void b(AccessibilityRecord accessibilityRecord, int i) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollY(i);
        }
    }

    @Deprecated
    public int hashCode() {
        AccessibilityRecord accessibilityRecord = this.f528a;
        if (accessibilityRecord == null) {
            return 0;
        }
        return accessibilityRecord.hashCode();
    }

    @Deprecated
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        AccessibilityRecord accessibilityRecord = this.f528a;
        if (accessibilityRecord == null) {
            if (fVar.f528a != null) {
                return false;
            }
        } else if (!accessibilityRecord.equals(fVar.f528a)) {
            return false;
        }
        return true;
    }
}
