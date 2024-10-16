package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressLint({"UnknownNullness"})
/* loaded from: classes.dex */
public abstract class v {
    public abstract Object a(Object obj, Object obj2, Object obj3);

    public abstract void a(ViewGroup viewGroup, Object obj);

    public abstract void a(Object obj, Rect rect);

    public abstract void a(Object obj, View view);

    public abstract void a(Object obj, View view, ArrayList<View> arrayList);

    public abstract void a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    public abstract void a(Object obj, ArrayList<View> arrayList);

    public abstract void a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract boolean a(Object obj);

    public abstract Object b(Object obj);

    public abstract Object b(Object obj, Object obj2, Object obj3);

    public abstract void b(Object obj, View view);

    public abstract void b(Object obj, View view, ArrayList<View> arrayList);

    public abstract void b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract Object c(Object obj);

    public abstract void c(Object obj, View view);

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, Rect rect) {
        if (androidx.core.f.v.A(view)) {
            RectF rectF = new RectF();
            rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
            view.getMatrix().mapRect(rectF);
            rectF.offset(view.getLeft(), view.getTop());
            Object parent = view.getParent();
            while (parent instanceof View) {
                View view2 = (View) parent;
                rectF.offset(-view2.getScrollX(), -view2.getScrollY());
                view2.getMatrix().mapRect(rectF);
                rectF.offset(view2.getLeft(), view2.getTop());
                parent = view2.getParent();
            }
            view.getRootView().getLocationOnScreen(new int[2]);
            rectF.offset(r1[0], r1[1]);
            rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<String> a(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = arrayList.get(i);
            arrayList2.add(androidx.core.f.v.n(view));
            androidx.core.f.v.a(view, (String) null);
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, final ArrayList<View> arrayList, final ArrayList<View> arrayList2, final ArrayList<String> arrayList3, Map<String, String> map) {
        final int size = arrayList2.size();
        final ArrayList arrayList4 = new ArrayList();
        for (int i = 0; i < size; i++) {
            View view2 = arrayList.get(i);
            String n = androidx.core.f.v.n(view2);
            arrayList4.add(n);
            if (n != null) {
                androidx.core.f.v.a(view2, (String) null);
                String str = map.get(n);
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    if (str.equals(arrayList3.get(i2))) {
                        androidx.core.f.v.a(arrayList2.get(i2), n);
                        break;
                    }
                    i2++;
                }
            }
        }
        androidx.core.f.s.a(view, new Runnable() { // from class: androidx.fragment.app.v.1
            @Override // java.lang.Runnable
            public void run() {
                for (int i3 = 0; i3 < size; i3++) {
                    androidx.core.f.v.a((View) arrayList2.get(i3), (String) arrayList3.get(i3));
                    androidx.core.f.v.a((View) arrayList.get(i3), (String) arrayList4.get(i3));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() == 0) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (androidx.core.f.x.a(viewGroup)) {
                    arrayList.add(viewGroup);
                    return;
                }
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    a(arrayList, viewGroup.getChildAt(i));
                }
                return;
            }
            arrayList.add(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String n = androidx.core.f.v.n(view);
            if (n != null) {
                map.put(n, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    a(map, viewGroup.getChildAt(i));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, final ArrayList<View> arrayList, final Map<String, String> map) {
        androidx.core.f.s.a(view, new Runnable() { // from class: androidx.fragment.app.v.2
            @Override // java.lang.Runnable
            public void run() {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    View view2 = (View) arrayList.get(i);
                    String n = androidx.core.f.v.n(view2);
                    if (n != null) {
                        androidx.core.f.v.a(view2, v.a((Map<String, String>) map, n));
                    }
                }
            }
        });
    }

    public void a(Fragment fragment, Object obj, androidx.core.os.b bVar, Runnable runnable) {
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ViewGroup viewGroup, final ArrayList<View> arrayList, final Map<String, String> map) {
        androidx.core.f.s.a(viewGroup, new Runnable() { // from class: androidx.fragment.app.v.3
            @Override // java.lang.Runnable
            public void run() {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    View view = (View) arrayList.get(i);
                    androidx.core.f.v.a(view, (String) map.get(androidx.core.f.v.n(view)));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(List<View> list, View view) {
        int size = list.size();
        if (a(list, view, size)) {
            return;
        }
        if (androidx.core.f.v.n(view) != null) {
            list.add(view);
        }
        for (int i = size; i < list.size(); i++) {
            View view2 = list.get(i);
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    if (!a(list, childAt, size) && androidx.core.f.v.n(childAt) != null) {
                        list.add(childAt);
                    }
                }
            }
        }
    }

    private static boolean a(List<View> list, View view, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2) == view) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean a(List list) {
        return list == null || list.isEmpty();
    }

    static String a(Map<String, String> map, String str) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (str.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}
