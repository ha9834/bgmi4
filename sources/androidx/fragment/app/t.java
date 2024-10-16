package androidx.fragment.app;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    static final v f682a;
    static final v b;
    private static final int[] c = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(Fragment fragment, androidx.core.os.b bVar);

        void b(Fragment fragment, androidx.core.os.b bVar);
    }

    static {
        f682a = Build.VERSION.SDK_INT >= 21 ? new u() : null;
        b = a();
    }

    private static v a() {
        try {
            return (v) Class.forName("androidx.g.e").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, e eVar, ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z, a aVar) {
        ViewGroup viewGroup;
        SparseArray sparseArray = new SparseArray();
        for (int i3 = i; i3 < i2; i3++) {
            androidx.fragment.app.a aVar2 = arrayList.get(i3);
            if (arrayList2.get(i3).booleanValue()) {
                b(aVar2, (SparseArray<b>) sparseArray, z);
            } else {
                a(aVar2, (SparseArray<b>) sparseArray, z);
            }
        }
        if (sparseArray.size() != 0) {
            View view = new View(context);
            int size = sparseArray.size();
            for (int i4 = 0; i4 < size; i4++) {
                int keyAt = sparseArray.keyAt(i4);
                androidx.b.a<String, String> a2 = a(keyAt, arrayList, arrayList2, i, i2);
                b bVar = (b) sparseArray.valueAt(i4);
                if (eVar.a() && (viewGroup = (ViewGroup) eVar.a(keyAt)) != null) {
                    if (z) {
                        a(viewGroup, bVar, view, a2, aVar);
                    } else {
                        b(viewGroup, bVar, view, a2, aVar);
                    }
                }
            }
        }
    }

    private static androidx.b.a<String, String> a(int i, ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        androidx.b.a<String, String> aVar = new androidx.b.a<>();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            androidx.fragment.app.a aVar2 = arrayList.get(i4);
            if (aVar2.b(i)) {
                boolean booleanValue = arrayList2.get(i4).booleanValue();
                if (aVar2.q != null) {
                    int size = aVar2.q.size();
                    if (booleanValue) {
                        arrayList3 = aVar2.q;
                        arrayList4 = aVar2.r;
                    } else {
                        ArrayList<String> arrayList5 = aVar2.q;
                        arrayList3 = aVar2.r;
                        arrayList4 = arrayList5;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = arrayList4.get(i5);
                        String str2 = arrayList3.get(i5);
                        String remove = aVar.remove(str2);
                        if (remove != null) {
                            aVar.put(str, remove);
                        } else {
                            aVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return aVar;
    }

    private static void a(ViewGroup viewGroup, b bVar, View view, androidx.b.a<String, String> aVar, final a aVar2) {
        Object obj;
        Fragment fragment = bVar.f689a;
        final Fragment fragment2 = bVar.d;
        v a2 = a(fragment2, fragment);
        if (a2 == null) {
            return;
        }
        boolean z = bVar.b;
        boolean z2 = bVar.e;
        ArrayList<View> arrayList = new ArrayList<>();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object a3 = a(a2, fragment, z);
        Object b2 = b(a2, fragment2, z2);
        Object a4 = a(a2, viewGroup, view, aVar, bVar, arrayList2, arrayList, a3, b2);
        if (a3 == null && a4 == null) {
            obj = b2;
            if (obj == null) {
                return;
            }
        } else {
            obj = b2;
        }
        ArrayList<View> a5 = a(a2, obj, fragment2, arrayList2, view);
        ArrayList<View> a6 = a(a2, a3, fragment, arrayList, view);
        a(a6, 4);
        Object a7 = a(a2, a3, obj, a4, fragment, z);
        if (fragment2 != null && a5 != null && (a5.size() > 0 || arrayList2.size() > 0)) {
            final androidx.core.os.b bVar2 = new androidx.core.os.b();
            aVar2.a(fragment2, bVar2);
            a2.a(fragment2, a7, bVar2, new Runnable() { // from class: androidx.fragment.app.t.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(fragment2, bVar2);
                }
            });
        }
        if (a7 != null) {
            a(a2, obj, fragment2, a5);
            ArrayList<String> a8 = a2.a(arrayList);
            a2.a(a7, a3, a6, obj, a5, a4, arrayList);
            a2.a(viewGroup, a7);
            a2.a(viewGroup, arrayList2, arrayList, a8, aVar);
            a(a6, 0);
            a2.a(a4, arrayList2, arrayList);
        }
    }

    private static void a(v vVar, Object obj, Fragment fragment, final ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.mAdded && fragment.mHidden && fragment.mHiddenChanged) {
            fragment.setHideReplaced(true);
            vVar.b(obj, fragment.getView(), arrayList);
            androidx.core.f.s.a(fragment.mContainer, new Runnable() { // from class: androidx.fragment.app.t.2
                @Override // java.lang.Runnable
                public void run() {
                    t.a((ArrayList<View>) arrayList, 4);
                }
            });
        }
    }

    private static void b(ViewGroup viewGroup, b bVar, View view, androidx.b.a<String, String> aVar, final a aVar2) {
        Object obj;
        Fragment fragment = bVar.f689a;
        final Fragment fragment2 = bVar.d;
        v a2 = a(fragment2, fragment);
        if (a2 == null) {
            return;
        }
        boolean z = bVar.b;
        boolean z2 = bVar.e;
        Object a3 = a(a2, fragment, z);
        Object b2 = b(a2, fragment2, z2);
        ArrayList arrayList = new ArrayList();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object b3 = b(a2, viewGroup, view, aVar, bVar, arrayList, arrayList2, a3, b2);
        if (a3 == null && b3 == null) {
            obj = b2;
            if (obj == null) {
                return;
            }
        } else {
            obj = b2;
        }
        ArrayList<View> a4 = a(a2, obj, fragment2, (ArrayList<View>) arrayList, view);
        Object obj2 = (a4 == null || a4.isEmpty()) ? null : obj;
        a2.b(a3, view);
        Object a5 = a(a2, a3, obj2, b3, fragment, bVar.b);
        if (fragment2 != null && a4 != null && (a4.size() > 0 || arrayList.size() > 0)) {
            final androidx.core.os.b bVar2 = new androidx.core.os.b();
            aVar2.a(fragment2, bVar2);
            a2.a(fragment2, a5, bVar2, new Runnable() { // from class: androidx.fragment.app.t.3
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(fragment2, bVar2);
                }
            });
        }
        if (a5 != null) {
            ArrayList<View> arrayList3 = new ArrayList<>();
            a2.a(a5, a3, arrayList3, obj2, a4, b3, arrayList2);
            a(a2, viewGroup, fragment, view, arrayList2, a3, arrayList3, obj2, a4);
            a2.a((View) viewGroup, arrayList2, (Map<String, String>) aVar);
            a2.a(viewGroup, a5);
            a2.a(viewGroup, arrayList2, (Map<String, String>) aVar);
        }
    }

    private static void a(final v vVar, ViewGroup viewGroup, final Fragment fragment, final View view, final ArrayList<View> arrayList, final Object obj, final ArrayList<View> arrayList2, final Object obj2, final ArrayList<View> arrayList3) {
        androidx.core.f.s.a(viewGroup, new Runnable() { // from class: androidx.fragment.app.t.4
            @Override // java.lang.Runnable
            public void run() {
                Object obj3 = obj;
                if (obj3 != null) {
                    vVar.c(obj3, view);
                    arrayList2.addAll(t.a(vVar, obj, fragment, (ArrayList<View>) arrayList, view));
                }
                if (arrayList3 != null) {
                    if (obj2 != null) {
                        ArrayList<View> arrayList4 = new ArrayList<>();
                        arrayList4.add(view);
                        vVar.b(obj2, arrayList3, arrayList4);
                    }
                    arrayList3.clear();
                    arrayList3.add(view);
                }
            }
        });
    }

    private static v a(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object exitTransition = fragment.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            Object returnTransition = fragment.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            Object sharedElementReturnTransition = fragment.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                arrayList.add(sharedElementReturnTransition);
            }
        }
        if (fragment2 != null) {
            Object enterTransition = fragment2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            Object reenterTransition = fragment2.getReenterTransition();
            if (reenterTransition != null) {
                arrayList.add(reenterTransition);
            }
            Object sharedElementEnterTransition = fragment2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        v vVar = f682a;
        if (vVar != null && a(vVar, arrayList)) {
            return f682a;
        }
        v vVar2 = b;
        if (vVar2 != null && a(vVar2, arrayList)) {
            return b;
        }
        if (f682a == null && b == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    private static boolean a(v vVar, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!vVar.a(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static Object a(v vVar, Fragment fragment, Fragment fragment2, boolean z) {
        Object sharedElementEnterTransition;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        if (z) {
            sharedElementEnterTransition = fragment2.getSharedElementReturnTransition();
        } else {
            sharedElementEnterTransition = fragment.getSharedElementEnterTransition();
        }
        return vVar.c(vVar.b(sharedElementEnterTransition));
    }

    private static Object a(v vVar, Fragment fragment, boolean z) {
        Object enterTransition;
        if (fragment == null) {
            return null;
        }
        if (z) {
            enterTransition = fragment.getReenterTransition();
        } else {
            enterTransition = fragment.getEnterTransition();
        }
        return vVar.b(enterTransition);
    }

    private static Object b(v vVar, Fragment fragment, boolean z) {
        Object exitTransition;
        if (fragment == null) {
            return null;
        }
        if (z) {
            exitTransition = fragment.getReturnTransition();
        } else {
            exitTransition = fragment.getExitTransition();
        }
        return vVar.b(exitTransition);
    }

    private static Object a(final v vVar, ViewGroup viewGroup, View view, androidx.b.a<String, String> aVar, b bVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        final View view2;
        final Rect rect;
        final Fragment fragment = bVar.f689a;
        final Fragment fragment2 = bVar.d;
        if (fragment != null) {
            fragment.requireView().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        final boolean z = bVar.b;
        Object a2 = aVar.isEmpty() ? null : a(vVar, fragment, fragment2, z);
        androidx.b.a<String, View> b2 = b(vVar, aVar, a2, bVar);
        final androidx.b.a<String, View> a3 = a(vVar, aVar, a2, bVar);
        if (aVar.isEmpty()) {
            if (b2 != null) {
                b2.clear();
            }
            if (a3 != null) {
                a3.clear();
            }
            obj3 = null;
        } else {
            a(arrayList, b2, aVar.keySet());
            a(arrayList2, a3, aVar.values());
            obj3 = a2;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        a(fragment, fragment2, z, b2, true);
        if (obj3 != null) {
            arrayList2.add(view);
            vVar.a(obj3, view, arrayList);
            a(vVar, obj3, obj2, b2, bVar.e, bVar.f);
            Rect rect2 = new Rect();
            View a4 = a(a3, bVar, obj, z);
            if (a4 != null) {
                vVar.a(obj, rect2);
            }
            rect = rect2;
            view2 = a4;
        } else {
            view2 = null;
            rect = null;
        }
        androidx.core.f.s.a(viewGroup, new Runnable() { // from class: androidx.fragment.app.t.5
            @Override // java.lang.Runnable
            public void run() {
                t.a(Fragment.this, fragment2, z, (androidx.b.a<String, View>) a3, false);
                View view3 = view2;
                if (view3 != null) {
                    vVar.a(view3, rect);
                }
            }
        });
        return obj3;
    }

    private static void a(ArrayList<View> arrayList, androidx.b.a<String, View> aVar, Collection<String> collection) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View c2 = aVar.c(size);
            if (collection.contains(androidx.core.f.v.n(c2))) {
                arrayList.add(c2);
            }
        }
    }

    private static Object b(final v vVar, ViewGroup viewGroup, final View view, final androidx.b.a<String, String> aVar, final b bVar, final ArrayList<View> arrayList, final ArrayList<View> arrayList2, final Object obj, Object obj2) {
        Object a2;
        androidx.b.a<String, String> aVar2;
        Object obj3;
        Rect rect;
        final Fragment fragment = bVar.f689a;
        final Fragment fragment2 = bVar.d;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        final boolean z = bVar.b;
        if (aVar.isEmpty()) {
            aVar2 = aVar;
            a2 = null;
        } else {
            a2 = a(vVar, fragment, fragment2, z);
            aVar2 = aVar;
        }
        androidx.b.a<String, View> b2 = b(vVar, aVar2, a2, bVar);
        if (aVar.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(b2.values());
            obj3 = a2;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        a(fragment, fragment2, z, b2, true);
        if (obj3 != null) {
            rect = new Rect();
            vVar.a(obj3, view, arrayList);
            a(vVar, obj3, obj2, b2, bVar.e, bVar.f);
            if (obj != null) {
                vVar.a(obj, rect);
            }
        } else {
            rect = null;
        }
        final Object obj4 = obj3;
        final Rect rect2 = rect;
        androidx.core.f.s.a(viewGroup, new Runnable() { // from class: androidx.fragment.app.t.6
            @Override // java.lang.Runnable
            public void run() {
                androidx.b.a<String, View> a3 = t.a(v.this, (androidx.b.a<String, String>) aVar, obj4, bVar);
                if (a3 != null) {
                    arrayList2.addAll(a3.values());
                    arrayList2.add(view);
                }
                t.a(fragment, fragment2, z, a3, false);
                Object obj5 = obj4;
                if (obj5 != null) {
                    v.this.a(obj5, arrayList, arrayList2);
                    View a4 = t.a(a3, bVar, obj, z);
                    if (a4 != null) {
                        v.this.a(a4, rect2);
                    }
                }
            }
        });
        return obj3;
    }

    private static androidx.b.a<String, View> b(v vVar, androidx.b.a<String, String> aVar, Object obj, b bVar) {
        androidx.core.app.m exitTransitionCallback;
        ArrayList<String> arrayList;
        if (aVar.isEmpty() || obj == null) {
            aVar.clear();
            return null;
        }
        Fragment fragment = bVar.d;
        androidx.b.a<String, View> aVar2 = new androidx.b.a<>();
        vVar.a((Map<String, View>) aVar2, fragment.requireView());
        androidx.fragment.app.a aVar3 = bVar.f;
        if (bVar.e) {
            exitTransitionCallback = fragment.getEnterTransitionCallback();
            arrayList = aVar3.r;
        } else {
            exitTransitionCallback = fragment.getExitTransitionCallback();
            arrayList = aVar3.q;
        }
        if (arrayList != null) {
            aVar2.a((Collection<?>) arrayList);
        }
        if (exitTransitionCallback != null) {
            exitTransitionCallback.a(arrayList, aVar2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = aVar2.get(str);
                if (view == null) {
                    aVar.remove(str);
                } else if (!str.equals(androidx.core.f.v.n(view))) {
                    aVar.put(androidx.core.f.v.n(view), aVar.remove(str));
                }
            }
        } else {
            aVar.a((Collection<?>) aVar2.keySet());
        }
        return aVar2;
    }

    static androidx.b.a<String, View> a(v vVar, androidx.b.a<String, String> aVar, Object obj, b bVar) {
        androidx.core.app.m enterTransitionCallback;
        ArrayList<String> arrayList;
        String a2;
        Fragment fragment = bVar.f689a;
        View view = fragment.getView();
        if (aVar.isEmpty() || obj == null || view == null) {
            aVar.clear();
            return null;
        }
        androidx.b.a<String, View> aVar2 = new androidx.b.a<>();
        vVar.a((Map<String, View>) aVar2, view);
        androidx.fragment.app.a aVar3 = bVar.c;
        if (bVar.b) {
            enterTransitionCallback = fragment.getExitTransitionCallback();
            arrayList = aVar3.q;
        } else {
            enterTransitionCallback = fragment.getEnterTransitionCallback();
            arrayList = aVar3.r;
        }
        if (arrayList != null) {
            aVar2.a((Collection<?>) arrayList);
            aVar2.a((Collection<?>) aVar.values());
        }
        if (enterTransitionCallback != null) {
            enterTransitionCallback.a(arrayList, aVar2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view2 = aVar2.get(str);
                if (view2 == null) {
                    String a3 = a(aVar, str);
                    if (a3 != null) {
                        aVar.remove(a3);
                    }
                } else if (!str.equals(androidx.core.f.v.n(view2)) && (a2 = a(aVar, str)) != null) {
                    aVar.put(a2, androidx.core.f.v.n(view2));
                }
            }
        } else {
            a(aVar, aVar2);
        }
        return aVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(androidx.b.a<String, String> aVar, String str) {
        int size = aVar.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(aVar.c(i))) {
                return aVar.b(i);
            }
        }
        return null;
    }

    static View a(androidx.b.a<String, View> aVar, b bVar, Object obj, boolean z) {
        String str;
        androidx.fragment.app.a aVar2 = bVar.c;
        if (obj == null || aVar == null || aVar2.q == null || aVar2.q.isEmpty()) {
            return null;
        }
        if (z) {
            str = aVar2.q.get(0);
        } else {
            str = aVar2.r.get(0);
        }
        return aVar.get(str);
    }

    private static void a(v vVar, Object obj, Object obj2, androidx.b.a<String, View> aVar, boolean z, androidx.fragment.app.a aVar2) {
        String str;
        if (aVar2.q == null || aVar2.q.isEmpty()) {
            return;
        }
        if (z) {
            str = aVar2.r.get(0);
        } else {
            str = aVar2.q.get(0);
        }
        View view = aVar.get(str);
        vVar.a(obj, view);
        if (obj2 != null) {
            vVar.a(obj2, view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(androidx.b.a<String, String> aVar, androidx.b.a<String, View> aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey(aVar.c(size))) {
                aVar.d(size);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Fragment fragment, Fragment fragment2, boolean z, androidx.b.a<String, View> aVar, boolean z2) {
        androidx.core.app.m enterTransitionCallback;
        if (z) {
            enterTransitionCallback = fragment2.getEnterTransitionCallback();
        } else {
            enterTransitionCallback = fragment.getEnterTransitionCallback();
        }
        if (enterTransitionCallback != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = aVar == null ? 0 : aVar.size();
            for (int i = 0; i < size; i++) {
                arrayList2.add(aVar.b(i));
                arrayList.add(aVar.c(i));
            }
            if (z2) {
                enterTransitionCallback.a(arrayList2, arrayList, (List<View>) null);
            } else {
                enterTransitionCallback.b(arrayList2, arrayList, null);
            }
        }
    }

    static ArrayList<View> a(v vVar, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View view2 = fragment.getView();
        if (view2 != null) {
            vVar.a(arrayList2, view2);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        vVar.a(obj, arrayList2);
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ArrayList<View> arrayList, int i) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i);
        }
    }

    private static Object a(v vVar, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        boolean z2;
        if (obj == null || obj2 == null || fragment == null) {
            z2 = true;
        } else if (z) {
            z2 = fragment.getAllowReturnTransitionOverlap();
        } else {
            z2 = fragment.getAllowEnterTransitionOverlap();
        }
        if (z2) {
            return vVar.a(obj2, obj, obj3);
        }
        return vVar.b(obj2, obj, obj3);
    }

    public static void a(androidx.fragment.app.a aVar, SparseArray<b> sparseArray, boolean z) {
        int size = aVar.d.size();
        for (int i = 0; i < size; i++) {
            a(aVar, aVar.d.get(i), sparseArray, false, z);
        }
    }

    public static void b(androidx.fragment.app.a aVar, SparseArray<b> sparseArray, boolean z) {
        if (aVar.f641a.o().a()) {
            for (int size = aVar.d.size() - 1; size >= 0; size--) {
                a(aVar, aVar.d.get(size), sparseArray, true, z);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a(androidx.fragment.app.a r8, androidx.fragment.app.s.a r9, android.util.SparseArray<androidx.fragment.app.t.b> r10, boolean r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.t.a(androidx.fragment.app.a, androidx.fragment.app.s$a, android.util.SparseArray, boolean, boolean):void");
    }

    private static b a(b bVar, SparseArray<b> sparseArray, int i) {
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b();
        sparseArray.put(i, bVar2);
        return bVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public Fragment f689a;
        public boolean b;
        public androidx.fragment.app.a c;
        public Fragment d;
        public boolean e;
        public androidx.fragment.app.a f;

        b() {
        }
    }
}
