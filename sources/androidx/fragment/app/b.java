package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.os.b;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
class b extends SpecialEffectsController {
    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ViewGroup viewGroup) {
        super(viewGroup);
    }

    @Override // androidx.fragment.app.SpecialEffectsController
    void a(List<SpecialEffectsController.Operation> list, boolean z) {
        SpecialEffectsController.Operation operation = null;
        SpecialEffectsController.Operation operation2 = null;
        for (SpecialEffectsController.Operation operation3 : list) {
            SpecialEffectsController.Operation.State a2 = SpecialEffectsController.Operation.State.a(operation3.e().mView);
            switch (operation3.c()) {
                case GONE:
                case INVISIBLE:
                case REMOVED:
                    if (a2 == SpecialEffectsController.Operation.State.VISIBLE && operation == null) {
                        operation = operation3;
                        break;
                    }
                    break;
                case VISIBLE:
                    if (a2 != SpecialEffectsController.Operation.State.VISIBLE) {
                        operation2 = operation3;
                        break;
                    } else {
                        break;
                    }
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList(list);
        Iterator<SpecialEffectsController.Operation> it = list.iterator();
        while (true) {
            boolean z2 = true;
            if (it.hasNext()) {
                final SpecialEffectsController.Operation next = it.next();
                androidx.core.os.b bVar = new androidx.core.os.b();
                next.a(bVar);
                arrayList.add(new a(next, bVar, z));
                androidx.core.os.b bVar2 = new androidx.core.os.b();
                next.a(bVar2);
                if (z) {
                    if (next == operation) {
                        arrayList2.add(new c(next, bVar2, z, z2));
                        next.a(new Runnable() { // from class: androidx.fragment.app.b.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (arrayList3.contains(next)) {
                                    arrayList3.remove(next);
                                    b.this.a(next);
                                }
                            }
                        });
                    }
                    z2 = false;
                    arrayList2.add(new c(next, bVar2, z, z2));
                    next.a(new Runnable() { // from class: androidx.fragment.app.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (arrayList3.contains(next)) {
                                arrayList3.remove(next);
                                b.this.a(next);
                            }
                        }
                    });
                } else {
                    if (next == operation2) {
                        arrayList2.add(new c(next, bVar2, z, z2));
                        next.a(new Runnable() { // from class: androidx.fragment.app.b.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (arrayList3.contains(next)) {
                                    arrayList3.remove(next);
                                    b.this.a(next);
                                }
                            }
                        });
                    }
                    z2 = false;
                    arrayList2.add(new c(next, bVar2, z, z2));
                    next.a(new Runnable() { // from class: androidx.fragment.app.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (arrayList3.contains(next)) {
                                arrayList3.remove(next);
                                b.this.a(next);
                            }
                        }
                    });
                }
            } else {
                Map<SpecialEffectsController.Operation, Boolean> a3 = a(arrayList2, arrayList3, z, operation, operation2);
                a(arrayList, arrayList3, a3.containsValue(true), a3);
                Iterator<SpecialEffectsController.Operation> it2 = arrayList3.iterator();
                while (it2.hasNext()) {
                    a(it2.next());
                }
                arrayList3.clear();
                return;
            }
        }
    }

    private void a(List<a> list, List<SpecialEffectsController.Operation> list2, boolean z, Map<SpecialEffectsController.Operation, Boolean> map) {
        final ViewGroup a2 = a();
        Context context = a2.getContext();
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        for (final a aVar : list) {
            if (aVar.c()) {
                aVar.d();
            } else {
                d.a a3 = aVar.a(context);
                if (a3 == null) {
                    aVar.d();
                } else {
                    final Animator animator = a3.b;
                    if (animator == null) {
                        arrayList.add(aVar);
                    } else {
                        final SpecialEffectsController.Operation a4 = aVar.a();
                        Fragment e = a4.e();
                        if (Boolean.TRUE.equals(map.get(a4))) {
                            if (FragmentManager.a(2)) {
                                Log.v("FragmentManager", "Ignoring Animator set on " + e + " as this Fragment was involved in a Transition.");
                            }
                            aVar.d();
                        } else {
                            final boolean z3 = a4.c() == SpecialEffectsController.Operation.State.GONE;
                            if (z3) {
                                list2.remove(a4);
                            }
                            final View view = e.mView;
                            a2.startViewTransition(view);
                            animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.fragment.app.b.3
                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator2) {
                                    a2.endViewTransition(view);
                                    if (z3) {
                                        a4.c().b(view);
                                    }
                                    aVar.d();
                                }
                            });
                            animator.setTarget(view);
                            animator.start();
                            aVar.b().a(new b.a() { // from class: androidx.fragment.app.b.4
                                @Override // androidx.core.os.b.a
                                public void a() {
                                    animator.end();
                                }
                            });
                            z2 = true;
                        }
                    }
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            final a aVar2 = (a) it.next();
            SpecialEffectsController.Operation a5 = aVar2.a();
            Fragment e2 = a5.e();
            if (z) {
                if (FragmentManager.a(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + e2 + " as Animations cannot run alongside Transitions.");
                }
                aVar2.d();
            } else if (z2) {
                if (FragmentManager.a(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + e2 + " as Animations cannot run alongside Animators.");
                }
                aVar2.d();
            } else {
                final View view2 = e2.mView;
                Animation animation = (Animation) androidx.core.e.e.a(((d.a) androidx.core.e.e.a(aVar2.a(context))).f665a);
                if (a5.c() != SpecialEffectsController.Operation.State.REMOVED) {
                    view2.startAnimation(animation);
                    aVar2.d();
                } else {
                    a2.startViewTransition(view2);
                    d.b bVar = new d.b(animation, a2, view2);
                    bVar.setAnimationListener(new Animation.AnimationListener() { // from class: androidx.fragment.app.b.5
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation2) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation2) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation2) {
                            a2.post(new Runnable() { // from class: androidx.fragment.app.b.5.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    a2.endViewTransition(view2);
                                    aVar2.d();
                                }
                            });
                        }
                    });
                    view2.startAnimation(bVar);
                }
                aVar2.b().a(new b.a() { // from class: androidx.fragment.app.b.6
                    @Override // androidx.core.os.b.a
                    public void a() {
                        view2.clearAnimation();
                        a2.endViewTransition(view2);
                        aVar2.d();
                    }
                });
            }
        }
    }

    private Map<SpecialEffectsController.Operation, Boolean> a(List<c> list, List<SpecialEffectsController.Operation> list2, final boolean z, final SpecialEffectsController.Operation operation, final SpecialEffectsController.Operation operation2) {
        View view;
        Object obj;
        ArrayList<View> arrayList;
        Object obj2;
        ArrayList<View> arrayList2;
        HashMap hashMap;
        SpecialEffectsController.Operation operation3;
        View view2;
        boolean z2;
        Object a2;
        androidx.b.a aVar;
        SpecialEffectsController.Operation operation4;
        v vVar;
        ArrayList<View> arrayList3;
        HashMap hashMap2;
        Rect rect;
        SpecialEffectsController.Operation operation5;
        View view3;
        ArrayList<View> arrayList4;
        b bVar;
        androidx.core.app.m enterTransitionCallback;
        androidx.core.app.m exitTransitionCallback;
        ArrayList<String> arrayList5;
        int i;
        View view4;
        String a3;
        ArrayList<String> arrayList6;
        b bVar2 = this;
        boolean z3 = z;
        SpecialEffectsController.Operation operation6 = operation;
        SpecialEffectsController.Operation operation7 = operation2;
        HashMap hashMap3 = new HashMap();
        final v vVar2 = null;
        for (c cVar : list) {
            if (!cVar.c()) {
                v i2 = cVar.i();
                if (vVar2 == null) {
                    vVar2 = i2;
                } else if (i2 != null && vVar2 != i2) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + cVar.a().e() + " returned Transition " + cVar.e() + " which uses a different Transition  type than other Fragments.");
                }
            }
        }
        if (vVar2 == null) {
            for (c cVar2 : list) {
                hashMap3.put(cVar2.a(), false);
                cVar2.d();
            }
            return hashMap3;
        }
        View view5 = new View(a().getContext());
        final Rect rect2 = new Rect();
        ArrayList<View> arrayList7 = new ArrayList<>();
        ArrayList<View> arrayList8 = new ArrayList<>();
        androidx.b.a aVar2 = new androidx.b.a();
        Object obj3 = null;
        View view6 = null;
        boolean z4 = false;
        for (c cVar3 : list) {
            if (!cVar3.g() || operation6 == null || operation7 == null) {
                aVar = aVar2;
                operation4 = operation7;
                vVar = vVar2;
                arrayList3 = arrayList8;
                hashMap2 = hashMap3;
                rect = rect2;
                operation5 = operation6;
                view3 = view5;
                b bVar3 = bVar2;
                arrayList4 = arrayList7;
                bVar = bVar3;
                view6 = view6;
            } else {
                Object c2 = vVar2.c(vVar2.b(cVar3.h()));
                ArrayList<String> sharedElementSourceNames = operation2.e().getSharedElementSourceNames();
                ArrayList<String> sharedElementSourceNames2 = operation.e().getSharedElementSourceNames();
                ArrayList<String> sharedElementTargetNames = operation.e().getSharedElementTargetNames();
                View view7 = view6;
                int i3 = 0;
                while (i3 < sharedElementTargetNames.size()) {
                    int indexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i3));
                    ArrayList<String> arrayList9 = sharedElementTargetNames;
                    if (indexOf != -1) {
                        sharedElementSourceNames.set(indexOf, sharedElementSourceNames2.get(i3));
                    }
                    i3++;
                    sharedElementTargetNames = arrayList9;
                }
                ArrayList<String> sharedElementTargetNames2 = operation2.e().getSharedElementTargetNames();
                if (!z3) {
                    enterTransitionCallback = operation.e().getExitTransitionCallback();
                    exitTransitionCallback = operation2.e().getEnterTransitionCallback();
                } else {
                    enterTransitionCallback = operation.e().getEnterTransitionCallback();
                    exitTransitionCallback = operation2.e().getExitTransitionCallback();
                }
                int i4 = 0;
                for (int size = sharedElementSourceNames.size(); i4 < size; size = size) {
                    aVar2.put(sharedElementSourceNames.get(i4), sharedElementTargetNames2.get(i4));
                    i4++;
                }
                androidx.b.a<String, View> aVar3 = new androidx.b.a<>();
                bVar2.a(aVar3, operation.e().mView);
                aVar3.a((Collection<?>) sharedElementSourceNames);
                if (enterTransitionCallback != null) {
                    enterTransitionCallback.a(sharedElementSourceNames, aVar3);
                    int size2 = sharedElementSourceNames.size() - 1;
                    while (size2 >= 0) {
                        String str = sharedElementSourceNames.get(size2);
                        View view8 = aVar3.get(str);
                        if (view8 == null) {
                            aVar2.remove(str);
                            arrayList6 = sharedElementSourceNames;
                        } else {
                            arrayList6 = sharedElementSourceNames;
                            if (!str.equals(androidx.core.f.v.n(view8))) {
                                aVar2.put(androidx.core.f.v.n(view8), (String) aVar2.remove(str));
                            }
                        }
                        size2--;
                        sharedElementSourceNames = arrayList6;
                    }
                    arrayList5 = sharedElementSourceNames;
                } else {
                    arrayList5 = sharedElementSourceNames;
                    aVar2.a((Collection<?>) aVar3.keySet());
                }
                final androidx.b.a<String, View> aVar4 = new androidx.b.a<>();
                bVar2.a(aVar4, operation2.e().mView);
                aVar4.a((Collection<?>) sharedElementTargetNames2);
                aVar4.a(aVar2.values());
                if (exitTransitionCallback != null) {
                    exitTransitionCallback.a(sharedElementTargetNames2, aVar4);
                    for (int size3 = sharedElementTargetNames2.size() - 1; size3 >= 0; size3--) {
                        String str2 = sharedElementTargetNames2.get(size3);
                        View view9 = aVar4.get(str2);
                        if (view9 == null) {
                            String a4 = t.a((androidx.b.a<String, String>) aVar2, str2);
                            if (a4 != null) {
                                aVar2.remove(a4);
                            }
                        } else if (!str2.equals(androidx.core.f.v.n(view9)) && (a3 = t.a((androidx.b.a<String, String>) aVar2, str2)) != null) {
                            aVar2.put(a3, androidx.core.f.v.n(view9));
                        }
                    }
                } else {
                    t.a((androidx.b.a<String, String>) aVar2, aVar4);
                }
                bVar2.a(aVar3, aVar2.keySet());
                bVar2.a(aVar4, aVar2.values());
                if (aVar2.isEmpty()) {
                    arrayList7.clear();
                    arrayList8.clear();
                    aVar = aVar2;
                    arrayList3 = arrayList8;
                    rect = rect2;
                    view3 = view5;
                    vVar = vVar2;
                    view6 = view7;
                    obj3 = null;
                    operation4 = operation2;
                    hashMap2 = hashMap3;
                    operation5 = operation;
                    b bVar4 = bVar2;
                    arrayList4 = arrayList7;
                    bVar = bVar4;
                } else {
                    t.a(operation2.e(), operation.e(), z3, aVar3, true);
                    HashMap hashMap4 = hashMap3;
                    aVar = aVar2;
                    View view10 = view5;
                    ArrayList<View> arrayList10 = arrayList8;
                    arrayList4 = arrayList7;
                    androidx.core.f.s.a(a(), new Runnable() { // from class: androidx.fragment.app.b.7
                        @Override // java.lang.Runnable
                        public void run() {
                            t.a(operation2.e(), operation.e(), z, (androidx.b.a<String, View>) aVar4, false);
                        }
                    });
                    arrayList4.addAll(aVar3.values());
                    if (arrayList5.isEmpty()) {
                        i = 0;
                        view6 = view7;
                    } else {
                        i = 0;
                        view6 = aVar3.get(arrayList5.get(0));
                        vVar2.a(c2, view6);
                    }
                    arrayList10.addAll(aVar4.values());
                    if (sharedElementTargetNames2.isEmpty()) {
                        bVar = this;
                    } else {
                        final View view11 = aVar4.get(sharedElementTargetNames2.get(i));
                        if (view11 != null) {
                            bVar = this;
                            androidx.core.f.s.a(a(), new Runnable() { // from class: androidx.fragment.app.b.8
                                @Override // java.lang.Runnable
                                public void run() {
                                    vVar2.a(view11, rect2);
                                }
                            });
                            view4 = view10;
                            z4 = true;
                            vVar2.a(c2, view4, arrayList4);
                            rect = rect2;
                            view3 = view4;
                            arrayList3 = arrayList10;
                            vVar = vVar2;
                            vVar2.a(c2, null, null, null, null, c2, arrayList3);
                            hashMap2 = hashMap4;
                            operation5 = operation;
                            hashMap2.put(operation5, true);
                            operation4 = operation2;
                            hashMap2.put(operation4, true);
                            obj3 = c2;
                        } else {
                            bVar = this;
                        }
                    }
                    view4 = view10;
                    vVar2.a(c2, view4, arrayList4);
                    rect = rect2;
                    view3 = view4;
                    arrayList3 = arrayList10;
                    vVar = vVar2;
                    vVar2.a(c2, null, null, null, null, c2, arrayList3);
                    hashMap2 = hashMap4;
                    operation5 = operation;
                    hashMap2.put(operation5, true);
                    operation4 = operation2;
                    hashMap2.put(operation4, true);
                    obj3 = c2;
                }
            }
            rect2 = rect;
            view5 = view3;
            arrayList8 = arrayList3;
            operation6 = operation5;
            hashMap3 = hashMap2;
            z3 = z;
            operation7 = operation4;
            vVar2 = vVar;
            aVar2 = aVar;
            ArrayList<View> arrayList11 = arrayList4;
            bVar2 = bVar;
            arrayList7 = arrayList11;
        }
        View view12 = view6;
        androidx.b.a aVar5 = aVar2;
        SpecialEffectsController.Operation operation8 = operation7;
        v vVar3 = vVar2;
        boolean z5 = false;
        ArrayList<View> arrayList12 = arrayList8;
        HashMap hashMap5 = hashMap3;
        Rect rect3 = rect2;
        SpecialEffectsController.Operation operation9 = operation6;
        View view13 = view5;
        b bVar5 = bVar2;
        ArrayList<View> arrayList13 = arrayList7;
        ArrayList arrayList14 = new ArrayList();
        Iterator<c> it = list.iterator();
        Object obj4 = null;
        Object obj5 = null;
        while (it.hasNext()) {
            c next = it.next();
            if (next.c()) {
                hashMap5.put(next.a(), Boolean.valueOf(z5));
                next.d();
                it = it;
            } else {
                Iterator<c> it2 = it;
                Object b = vVar3.b(next.e());
                SpecialEffectsController.Operation a5 = next.a();
                boolean z6 = obj3 != null && (a5 == operation9 || a5 == operation8);
                if (b == null) {
                    if (!z6) {
                        hashMap5.put(a5, Boolean.valueOf(z5));
                        next.d();
                    }
                    arrayList = arrayList13;
                    view = view13;
                    arrayList2 = arrayList12;
                    a2 = obj4;
                    obj2 = obj5;
                    hashMap = hashMap5;
                    view2 = view12;
                } else {
                    final ArrayList<View> arrayList15 = new ArrayList<>();
                    Object obj6 = obj4;
                    bVar5.a(arrayList15, a5.e().mView);
                    if (z6) {
                        if (a5 == operation9) {
                            arrayList15.removeAll(arrayList13);
                        } else {
                            arrayList15.removeAll(arrayList12);
                        }
                    }
                    if (arrayList15.isEmpty()) {
                        vVar3.b(b, view13);
                        arrayList = arrayList13;
                        view = view13;
                        arrayList2 = arrayList12;
                        operation3 = a5;
                        obj2 = obj5;
                        hashMap = hashMap5;
                        obj = obj6;
                    } else {
                        vVar3.a(b, arrayList15);
                        view = view13;
                        obj = obj6;
                        arrayList = arrayList13;
                        obj2 = obj5;
                        arrayList2 = arrayList12;
                        hashMap = hashMap5;
                        vVar3.a(b, b, arrayList15, null, null, null, null);
                        if (a5.c() == SpecialEffectsController.Operation.State.GONE) {
                            operation3 = a5;
                            list2.remove(operation3);
                            ArrayList<View> arrayList16 = new ArrayList<>(arrayList15);
                            arrayList16.remove(operation3.e().mView);
                            vVar3.b(b, operation3.e().mView, arrayList16);
                            androidx.core.f.s.a(a(), new Runnable() { // from class: androidx.fragment.app.b.9
                                @Override // java.lang.Runnable
                                public void run() {
                                    t.a((ArrayList<View>) arrayList15, 4);
                                }
                            });
                        } else {
                            operation3 = a5;
                        }
                    }
                    if (operation3.c() == SpecialEffectsController.Operation.State.VISIBLE) {
                        arrayList14.addAll(arrayList15);
                        if (z4) {
                            vVar3.a(b, rect3);
                            view2 = view12;
                            z2 = true;
                        } else {
                            view2 = view12;
                            z2 = true;
                        }
                    } else {
                        view2 = view12;
                        vVar3.a(b, view2);
                        z2 = true;
                    }
                    hashMap.put(operation3, Boolean.valueOf(z2));
                    if (next.f()) {
                        obj2 = vVar3.a(obj2, b, (Object) null);
                        a2 = obj;
                    } else {
                        a2 = vVar3.a(obj, b, (Object) null);
                    }
                }
                view12 = view2;
                obj5 = obj2;
                obj4 = a2;
                hashMap5 = hashMap;
                view13 = view;
                arrayList13 = arrayList;
                arrayList12 = arrayList2;
                z5 = false;
                it = it2;
            }
        }
        ArrayList<View> arrayList17 = arrayList13;
        ArrayList<View> arrayList18 = arrayList12;
        HashMap hashMap6 = hashMap5;
        Object b2 = vVar3.b(obj5, obj4, obj3);
        for (final c cVar4 : list) {
            if (!cVar4.c()) {
                Object e = cVar4.e();
                SpecialEffectsController.Operation a6 = cVar4.a();
                boolean z7 = obj3 != null && (a6 == operation9 || a6 == operation8);
                if (e != null || z7) {
                    if (!androidx.core.f.v.x(a())) {
                        if (FragmentManager.a(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Container " + a() + " has not been laid out. Completing operation " + a6);
                        }
                        cVar4.d();
                    } else {
                        vVar3.a(cVar4.a().e(), b2, cVar4.b(), new Runnable() { // from class: androidx.fragment.app.b.10
                            @Override // java.lang.Runnable
                            public void run() {
                                cVar4.d();
                            }
                        });
                    }
                }
            }
        }
        if (!androidx.core.f.v.x(a())) {
            return hashMap6;
        }
        t.a((ArrayList<View>) arrayList14, 4);
        ArrayList<String> a7 = vVar3.a(arrayList18);
        vVar3.a(a(), b2);
        vVar3.a(a(), arrayList17, arrayList18, a7, aVar5);
        t.a((ArrayList<View>) arrayList14, 0);
        vVar3.a(obj3, arrayList17, arrayList18);
        return hashMap6;
    }

    void a(androidx.b.a<String, View> aVar, Collection<String> collection) {
        Iterator<Map.Entry<String, View>> it = aVar.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(androidx.core.f.v.n(it.next().getValue()))) {
                it.remove();
            }
        }
    }

    void a(ArrayList<View> arrayList, View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (androidx.core.f.x.a(viewGroup)) {
                if (arrayList.contains(view)) {
                    return;
                }
                arrayList.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    a(arrayList, childAt);
                }
            }
            return;
        }
        if (arrayList.contains(view)) {
            return;
        }
        arrayList.add(view);
    }

    void a(Map<String, View> map, View view) {
        String n = androidx.core.f.v.n(view);
        if (n != null) {
            map.put(n, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    a(map, childAt);
                }
            }
        }
    }

    void a(SpecialEffectsController.Operation operation) {
        operation.c().b(operation.e().mView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: androidx.fragment.app.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0054b {

        /* renamed from: a, reason: collision with root package name */
        private final SpecialEffectsController.Operation f654a;
        private final androidx.core.os.b b;

        C0054b(SpecialEffectsController.Operation operation, androidx.core.os.b bVar) {
            this.f654a = operation;
            this.b = bVar;
        }

        SpecialEffectsController.Operation a() {
            return this.f654a;
        }

        androidx.core.os.b b() {
            return this.b;
        }

        boolean c() {
            SpecialEffectsController.Operation.State a2 = SpecialEffectsController.Operation.State.a(this.f654a.e().mView);
            SpecialEffectsController.Operation.State c = this.f654a.c();
            return a2 == c || !(a2 == SpecialEffectsController.Operation.State.VISIBLE || c == SpecialEffectsController.Operation.State.VISIBLE);
        }

        void d() {
            this.f654a.b(this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends C0054b {

        /* renamed from: a, reason: collision with root package name */
        private boolean f653a;
        private boolean b;
        private d.a c;

        a(SpecialEffectsController.Operation operation, androidx.core.os.b bVar, boolean z) {
            super(operation, bVar);
            this.b = false;
            this.f653a = z;
        }

        d.a a(Context context) {
            if (this.b) {
                return this.c;
            }
            this.c = d.a(context, a().e(), a().c() == SpecialEffectsController.Operation.State.VISIBLE, this.f653a);
            this.b = true;
            return this.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends C0054b {

        /* renamed from: a, reason: collision with root package name */
        private final Object f655a;
        private final boolean b;
        private final Object c;

        c(SpecialEffectsController.Operation operation, androidx.core.os.b bVar, boolean z, boolean z2) {
            super(operation, bVar);
            Object exitTransition;
            Object enterTransition;
            boolean allowEnterTransitionOverlap;
            if (operation.c() == SpecialEffectsController.Operation.State.VISIBLE) {
                if (z) {
                    enterTransition = operation.e().getReenterTransition();
                } else {
                    enterTransition = operation.e().getEnterTransition();
                }
                this.f655a = enterTransition;
                if (z) {
                    allowEnterTransitionOverlap = operation.e().getAllowReturnTransitionOverlap();
                } else {
                    allowEnterTransitionOverlap = operation.e().getAllowEnterTransitionOverlap();
                }
                this.b = allowEnterTransitionOverlap;
            } else {
                if (z) {
                    exitTransition = operation.e().getReturnTransition();
                } else {
                    exitTransition = operation.e().getExitTransition();
                }
                this.f655a = exitTransition;
                this.b = true;
            }
            if (!z2) {
                this.c = null;
            } else if (z) {
                this.c = operation.e().getSharedElementReturnTransition();
            } else {
                this.c = operation.e().getSharedElementEnterTransition();
            }
        }

        Object e() {
            return this.f655a;
        }

        boolean f() {
            return this.b;
        }

        public boolean g() {
            return this.c != null;
        }

        public Object h() {
            return this.c;
        }

        v i() {
            v a2 = a(this.f655a);
            v a3 = a(this.c);
            if (a2 == null || a3 == null || a2 == a3) {
                return a2 != null ? a2 : a3;
            }
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + a().e() + " returned Transition " + this.f655a + " which uses a different Transition  type than its shared element transition " + this.c);
        }

        private v a(Object obj) {
            if (obj == null) {
                return null;
            }
            if (t.f682a != null && t.f682a.a(obj)) {
                return t.f682a;
            }
            if (t.b != null && t.b.a(obj)) {
                return t.b;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + a().e() + " is not a valid framework Transition or AndroidX Transition");
        }
    }
}
