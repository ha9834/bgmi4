package com.facebook.internal.logging.dumpsys;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.d;
import kotlin.collections.j;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.l;

/* loaded from: classes.dex */
public final class AndroidRootResolver {
    public static final Companion Companion = new Companion(null);
    private static final String GET_DEFAULT_IMPL = "getDefault";
    private static final String GET_GLOBAL_INSTANCE = "getInstance";
    private static final String TAG;
    private static final String VIEWS_FIELD = "mViews";
    private static final String WINDOW_MANAGER_GLOBAL_CLAZZ = "android.view.WindowManagerGlobal";
    private static final String WINDOW_MANAGER_IMPL_CLAZZ = "android.view.WindowManagerImpl";
    private static final String WINDOW_PARAMS_FIELD = "mParams";
    private boolean initialized;
    private Field paramsField;
    private Field viewsField;
    private Object windowManagerObj;

    /* loaded from: classes.dex */
    public interface Listener {
        void onRootAdded(View view);

        void onRootRemoved(View view);

        void onRootsChanged(List<? extends View> list);
    }

    /* loaded from: classes.dex */
    public static final class Root {
        private final WindowManager.LayoutParams param;
        private final View view;

        public Root(View view, WindowManager.LayoutParams layoutParams) {
            h.b(view, "view");
            h.b(layoutParams, "param");
            this.view = view;
            this.param = layoutParams;
        }

        public final WindowManager.LayoutParams getParam() {
            return this.param;
        }

        public final View getView() {
            return this.view;
        }
    }

    /* loaded from: classes.dex */
    public static final class ListenableArrayList extends ArrayList<View> {
        private Listener listener;

        public /* bridge */ boolean contains(View view) {
            return super.contains((Object) view);
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj != null ? obj instanceof View : true) {
                return contains((View) obj);
            }
            return false;
        }

        public int getSize() {
            return super.size();
        }

        public /* bridge */ int indexOf(View view) {
            return super.indexOf((Object) view);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj != null ? obj instanceof View : true) {
                return indexOf((View) obj);
            }
            return -1;
        }

        public /* bridge */ int lastIndexOf(View view) {
            return super.lastIndexOf((Object) view);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj != null ? obj instanceof View : true) {
                return lastIndexOf((View) obj);
            }
            return -1;
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final View remove(int i) {
            return remove(i);
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean remove(Object obj) {
            if (obj != null ? obj instanceof View : true) {
                return remove((View) obj);
            }
            return false;
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final int size() {
            return getSize();
        }

        public final void setListener(Listener listener) {
            this.listener = listener;
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean add(View view) {
            Listener listener;
            boolean add = super.add((ListenableArrayList) view);
            if (add && (listener = this.listener) != null) {
                if (listener != null) {
                    listener.onRootAdded(view);
                }
                Listener listener2 = this.listener;
                if (listener2 != null) {
                    listener2.onRootsChanged(this);
                }
            }
            return add;
        }

        public boolean remove(View view) {
            Listener listener;
            boolean remove = super.remove((Object) view);
            if (remove && (listener = this.listener) != null && (view instanceof View)) {
                if (listener != null) {
                    listener.onRootRemoved(view);
                }
                Listener listener2 = this.listener;
                if (listener2 != null) {
                    listener2.onRootsChanged(this);
                }
            }
            return remove;
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        /* renamed from: removeAt, reason: merged with bridge method [inline-methods] */
        public View remove(int i) {
            View view = (View) super.remove(i);
            Listener listener = this.listener;
            if (listener != null) {
                if (listener != null) {
                    listener.onRootRemoved(view);
                }
                Listener listener2 = this.listener;
                if (listener2 != null) {
                    listener2.onRootsChanged(this);
                }
            }
            return view;
        }
    }

    public final void attachActiveRootListener(Listener listener) {
        if (Build.VERSION.SDK_INT < 19 || listener == null) {
            return;
        }
        if (!this.initialized) {
            initialize();
        }
        try {
            Field declaredField = Field.class.getDeclaredField("accessFlags");
            h.a((Object) declaredField, "Field::class.java.getDeclaredField(\"accessFlags\")");
            declaredField.setAccessible(true);
            Field field = this.viewsField;
            Field field2 = this.viewsField;
            declaredField.setInt(field, field2 != null ? field2.getModifiers() : 0);
            Field field3 = this.viewsField;
            Object obj = field3 != null ? field3.get(this.windowManagerObj) : null;
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.ArrayList<android.view.View> /* = java.util.ArrayList<android.view.View> */");
            }
            ListenableArrayList listenableArrayList = new ListenableArrayList();
            listenableArrayList.setListener(listener);
            listenableArrayList.addAll((ArrayList) obj);
            Field field4 = this.viewsField;
            if (field4 != null) {
                field4.set(this.windowManagerObj, listenableArrayList);
            }
        } catch (Throwable th) {
            Log.d(TAG, "Couldn't attach root listener.", th);
        }
    }

    public final List<Root> listActiveRoots() {
        List list;
        if (!this.initialized) {
            initialize();
        }
        List list2 = null;
        if (this.windowManagerObj == null) {
            Log.d(TAG, "No reflective access to windowmanager object.");
            return null;
        }
        if (this.viewsField == null) {
            Log.d(TAG, "No reflective access to mViews");
            return null;
        }
        if (this.paramsField == null) {
            Log.d(TAG, "No reflective access to mPArams");
            return null;
        }
        try {
            if (Build.VERSION.SDK_INT < 19) {
                Field field = this.viewsField;
                View[] viewArr = (View[]) (field != null ? field.get(this.windowManagerObj) : null);
                list = viewArr != null ? d.c(viewArr) : null;
                Field field2 = this.paramsField;
                WindowManager.LayoutParams[] layoutParamsArr = (WindowManager.LayoutParams[]) (field2 != null ? field2.get(this.windowManagerObj) : null);
                if (layoutParamsArr != null) {
                    list2 = d.c(layoutParamsArr);
                }
            } else {
                Field field3 = this.viewsField;
                list = (List) (field3 != null ? field3.get(this.windowManagerObj) : null);
                Field field4 = this.paramsField;
                list2 = (List) (field4 != null ? field4.get(this.windowManagerObj) : null);
            }
            ArrayList arrayList = new ArrayList();
            if (list == null) {
                list = j.a();
            }
            List list3 = list;
            if (list2 == null) {
                list2 = j.a();
            }
            for (Pair pair : j.a((Iterable) list3, (Iterable) list2)) {
                arrayList.add(new Root((View) pair.c(), (WindowManager.LayoutParams) pair.d()));
            }
            return arrayList;
        } catch (IllegalAccessException e) {
            String str = TAG;
            l lVar = l.f6973a;
            Object[] objArr = {this.viewsField, this.paramsField, this.windowManagerObj};
            String format = String.format("Reflective access to %s or %s on %s failed.", Arrays.copyOf(objArr, objArr.length));
            h.a((Object) format, "java.lang.String.format(format, *args)");
            Log.d(str, format, e);
            return null;
        } catch (RuntimeException e2) {
            String str2 = TAG;
            l lVar2 = l.f6973a;
            Object[] objArr2 = {this.viewsField, this.paramsField, this.windowManagerObj};
            String format2 = String.format("Reflective access to %s or %s on %s failed.", Arrays.copyOf(objArr2, objArr2.length));
            h.a((Object) format2, "java.lang.String.format(format, *args)");
            Log.d(str2, format2, e2);
            return null;
        }
    }

    private final void initialize() {
        this.initialized = true;
        String str = Build.VERSION.SDK_INT > 16 ? WINDOW_MANAGER_GLOBAL_CLAZZ : WINDOW_MANAGER_IMPL_CLAZZ;
        String str2 = Build.VERSION.SDK_INT > 16 ? GET_GLOBAL_INSTANCE : GET_DEFAULT_IMPL;
        try {
            Class<?> cls = Class.forName(str);
            h.a((Object) cls, "Class.forName(accessClass)");
            Method method = cls.getMethod(str2, new Class[0]);
            h.a((Object) method, "clazz.getMethod(instanceMethod)");
            this.windowManagerObj = method.invoke(null, new Object[0]);
            this.viewsField = cls.getDeclaredField(VIEWS_FIELD);
            Field field = this.viewsField;
            if (field != null) {
                field.setAccessible(true);
            }
            this.paramsField = cls.getDeclaredField(WINDOW_PARAMS_FIELD);
            Field field2 = this.paramsField;
            if (field2 != null) {
                field2.setAccessible(true);
            }
        } catch (ClassNotFoundException e) {
            String str3 = TAG;
            l lVar = l.f6973a;
            Object[] objArr = {str};
            String format = String.format("could not find class: %s", Arrays.copyOf(objArr, objArr.length));
            h.a((Object) format, "java.lang.String.format(format, *args)");
            Log.d(str3, format, e);
        } catch (IllegalAccessException e2) {
            String str4 = TAG;
            l lVar2 = l.f6973a;
            Object[] objArr2 = {str, str2, VIEWS_FIELD};
            String format2 = String.format("reflective setup failed using obj: %s method: %s field: %s", Arrays.copyOf(objArr2, objArr2.length));
            h.a((Object) format2, "java.lang.String.format(format, *args)");
            Log.d(str4, format2, e2);
        } catch (NoSuchFieldException e3) {
            String str5 = TAG;
            l lVar3 = l.f6973a;
            Object[] objArr3 = {WINDOW_PARAMS_FIELD, VIEWS_FIELD, str};
            String format3 = String.format("could not find field: %s or %s on %s", Arrays.copyOf(objArr3, objArr3.length));
            h.a((Object) format3, "java.lang.String.format(format, *args)");
            Log.d(str5, format3, e3);
        } catch (NoSuchMethodException e4) {
            String str6 = TAG;
            l lVar4 = l.f6973a;
            Object[] objArr4 = {str2, str};
            String format4 = String.format("could not find method: %s on %s", Arrays.copyOf(objArr4, objArr4.length));
            h.a((Object) format4, "java.lang.String.format(format, *args)");
            Log.d(str6, format4, e4);
        } catch (RuntimeException e5) {
            String str7 = TAG;
            l lVar5 = l.f6973a;
            Object[] objArr5 = {str, str2, VIEWS_FIELD};
            String format5 = String.format("reflective setup failed using obj: %s method: %s field: %s", Arrays.copyOf(objArr5, objArr5.length));
            h.a((Object) format5, "java.lang.String.format(format, *args)");
            Log.d(str7, format5, e5);
        } catch (InvocationTargetException e6) {
            String str8 = TAG;
            l lVar6 = l.f6973a;
            Object[] objArr6 = {str2, str};
            String format6 = String.format("could not invoke: %s on %s", Arrays.copyOf(objArr6, objArr6.length));
            h.a((Object) format6, "java.lang.String.format(format, *args)");
            Log.d(str8, format6, e6.getCause());
        }
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    static {
        String simpleName = AndroidRootResolver.class.getSimpleName();
        h.a((Object) simpleName, "AndroidRootResolver::class.java.simpleName");
        TAG = simpleName;
    }
}
