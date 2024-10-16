package androidx.lifecycle;

import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.savedstate.b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class t {
    private static final Class[] e;

    /* renamed from: a, reason: collision with root package name */
    final Map<String, Object> f791a;
    final Map<String, b.InterfaceC0068b> b;
    private final Map<String, Object<?>> c;
    private final b.InterfaceC0068b d;

    public t(Map<String, Object> map) {
        this.b = new HashMap();
        this.c = new HashMap();
        this.d = new b.InterfaceC0068b() { // from class: androidx.lifecycle.t.1
            @Override // androidx.savedstate.b.InterfaceC0068b
            public Bundle a() {
                for (Map.Entry entry : new HashMap(t.this.b).entrySet()) {
                    t.this.a((String) entry.getKey(), (String) ((b.InterfaceC0068b) entry.getValue()).a());
                }
                Set<String> keySet = t.this.f791a.keySet();
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>(keySet.size());
                ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>(arrayList.size());
                for (String str : keySet) {
                    arrayList.add(str);
                    arrayList2.add(t.this.f791a.get(str));
                }
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("keys", arrayList);
                bundle.putParcelableArrayList("values", arrayList2);
                return bundle;
            }
        };
        this.f791a = new HashMap(map);
    }

    public t() {
        this.b = new HashMap();
        this.c = new HashMap();
        this.d = new b.InterfaceC0068b() { // from class: androidx.lifecycle.t.1
            @Override // androidx.savedstate.b.InterfaceC0068b
            public Bundle a() {
                for (Map.Entry entry : new HashMap(t.this.b).entrySet()) {
                    t.this.a((String) entry.getKey(), (String) ((b.InterfaceC0068b) entry.getValue()).a());
                }
                Set<String> keySet = t.this.f791a.keySet();
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>(keySet.size());
                ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>(arrayList.size());
                for (String str : keySet) {
                    arrayList.add(str);
                    arrayList2.add(t.this.f791a.get(str));
                }
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("keys", arrayList);
                bundle.putParcelableArrayList("values", arrayList2);
                return bundle;
            }
        };
        this.f791a = new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static t a(Bundle bundle, Bundle bundle2) {
        if (bundle == null && bundle2 == null) {
            return new t();
        }
        HashMap hashMap = new HashMap();
        if (bundle2 != null) {
            for (String str : bundle2.keySet()) {
                hashMap.put(str, bundle2.get(str));
            }
        }
        if (bundle == null) {
            return new t(hashMap);
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("keys");
        ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
        if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
            throw new IllegalStateException("Invalid bundle passed as restored state");
        }
        for (int i = 0; i < parcelableArrayList.size(); i++) {
            hashMap.put((String) parcelableArrayList.get(i), parcelableArrayList2.get(i));
        }
        return new t(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b.InterfaceC0068b a() {
        return this.d;
    }

    public <T> void a(String str, T t) {
        a(t);
        p pVar = (p) this.c.get(str);
        if (pVar != null) {
            pVar.b((p) t);
        } else {
            this.f791a.put(str, t);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void a(Object obj) {
        if (obj == null) {
            return;
        }
        for (Class cls : e) {
            if (cls.isInstance(obj)) {
                return;
            }
        }
        throw new IllegalArgumentException("Can't put value with type " + obj.getClass() + " into saved state");
    }

    static {
        Class[] clsArr = new Class[29];
        clsArr[0] = Boolean.TYPE;
        clsArr[1] = boolean[].class;
        clsArr[2] = Double.TYPE;
        clsArr[3] = double[].class;
        clsArr[4] = Integer.TYPE;
        clsArr[5] = int[].class;
        clsArr[6] = Long.TYPE;
        clsArr[7] = long[].class;
        clsArr[8] = String.class;
        clsArr[9] = String[].class;
        clsArr[10] = Binder.class;
        clsArr[11] = Bundle.class;
        clsArr[12] = Byte.TYPE;
        clsArr[13] = byte[].class;
        clsArr[14] = Character.TYPE;
        clsArr[15] = char[].class;
        clsArr[16] = CharSequence.class;
        clsArr[17] = CharSequence[].class;
        clsArr[18] = ArrayList.class;
        clsArr[19] = Float.TYPE;
        clsArr[20] = float[].class;
        clsArr[21] = Parcelable.class;
        clsArr[22] = Parcelable[].class;
        clsArr[23] = Serializable.class;
        clsArr[24] = Short.TYPE;
        clsArr[25] = short[].class;
        clsArr[26] = SparseArray.class;
        clsArr[27] = Build.VERSION.SDK_INT >= 21 ? Size.class : Integer.TYPE;
        clsArr[28] = Build.VERSION.SDK_INT >= 21 ? SizeF.class : Integer.TYPE;
        e = clsArr;
    }
}
