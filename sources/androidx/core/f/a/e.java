package androidx.core.f.a;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final Object f526a;

    public d a(int i) {
        return null;
    }

    public List<d> a(String str, int i) {
        return null;
    }

    public boolean a(int i, int i2, Bundle bundle) {
        return false;
    }

    public d b(int i) {
        return null;
    }

    /* loaded from: classes.dex */
    static class a extends AccessibilityNodeProvider {

        /* renamed from: a, reason: collision with root package name */
        final e f527a;

        a(e eVar) {
            this.f527a = eVar;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            d a2 = this.f527a.a(i);
            if (a2 == null) {
                return null;
            }
            return a2.a();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            List<d> a2 = this.f527a.a(str, i);
            if (a2 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = a2.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(a2.get(i2).a());
            }
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i, int i2, Bundle bundle) {
            return this.f527a.a(i, i2, bundle);
        }
    }

    /* loaded from: classes.dex */
    static class b extends a {
        b(e eVar) {
            super(eVar);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int i) {
            d b = this.f527a.b(i);
            if (b == null) {
                return null;
            }
            return b.a();
        }
    }

    public e() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f526a = new b(this);
        } else if (Build.VERSION.SDK_INT >= 16) {
            this.f526a = new a(this);
        } else {
            this.f526a = null;
        }
    }

    public e(Object obj) {
        this.f526a = obj;
    }

    public Object a() {
        return this.f526a;
    }
}
