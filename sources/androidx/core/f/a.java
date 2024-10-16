package androidx.core.f;

import android.os.Build;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.a;
import androidx.core.f.a.d;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final View.AccessibilityDelegate f518a = new View.AccessibilityDelegate();
    private final View.AccessibilityDelegate b;
    private final View.AccessibilityDelegate c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.core.f.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0047a extends View.AccessibilityDelegate {

        /* renamed from: a, reason: collision with root package name */
        final a f519a;

        C0047a(a aVar) {
            this.f519a = aVar;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f519a.b(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f519a.d(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            androidx.core.f.a.d a2 = androidx.core.f.a.d.a(accessibilityNodeInfo);
            a2.f(v.D(view));
            a2.h(v.F(view));
            a2.f(v.E(view));
            this.f519a.a(view, a2);
            a2.a(accessibilityNodeInfo.getText(), view);
            List<d.a> b = a.b(view);
            for (int i = 0; i < b.size(); i++) {
                a2.a(b.get(i));
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f519a.c(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f519a.a(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i) {
            this.f519a.a(view, i);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f519a.a(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            androidx.core.f.a.e a2 = this.f519a.a(view);
            if (a2 != null) {
                return (AccessibilityNodeProvider) a2.a();
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return this.f519a.a(view, i, bundle);
        }
    }

    public a() {
        this(f518a);
    }

    public a(View.AccessibilityDelegate accessibilityDelegate) {
        this.b = accessibilityDelegate;
        this.c = new C0047a(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View.AccessibilityDelegate a() {
        return this.c;
    }

    public void a(View view, int i) {
        this.b.sendAccessibilityEvent(view, i);
    }

    public void a(View view, AccessibilityEvent accessibilityEvent) {
        this.b.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public boolean b(View view, AccessibilityEvent accessibilityEvent) {
        return this.b.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.b.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void d(View view, AccessibilityEvent accessibilityEvent) {
        this.b.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void a(View view, androidx.core.f.a.d dVar) {
        this.b.onInitializeAccessibilityNodeInfo(view, dVar.a());
    }

    public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.b.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public androidx.core.f.a.e a(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider;
        if (Build.VERSION.SDK_INT < 16 || (accessibilityNodeProvider = this.b.getAccessibilityNodeProvider(view)) == null) {
            return null;
        }
        return new androidx.core.f.a.e(accessibilityNodeProvider);
    }

    public boolean a(View view, int i, Bundle bundle) {
        List<d.a> b = b(view);
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= b.size()) {
                break;
            }
            d.a aVar = b.get(i2);
            if (aVar.a() == i) {
                z = aVar.a(view, bundle);
                break;
            }
            i2++;
        }
        if (!z && Build.VERSION.SDK_INT >= 16) {
            z = this.b.performAccessibilityAction(view, i, bundle);
        }
        return (z || i != a.c.accessibility_action_clickable_span) ? z : a(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
    }

    private boolean a(int i, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(a.c.tag_accessibility_clickable_spans);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (!a(clickableSpan, view)) {
            return false;
        }
        clickableSpan.onClick(view);
        return true;
    }

    private boolean a(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] c = androidx.core.f.a.d.c(view.createAccessibilityNodeInfo().getText());
            for (int i = 0; c != null && i < c.length; i++) {
                if (clickableSpan.equals(c[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    static List<d.a> b(View view) {
        List<d.a> list = (List) view.getTag(a.c.tag_accessibility_actions);
        return list == null ? Collections.emptyList() : list;
    }
}
