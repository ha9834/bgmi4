package androidx.core.app;

import android.app.Notification;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.app.h;
import androidx.core.graphics.drawable.IconCompat;
import com.facebook.applinks.AppLinkData;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j {
    private static Field b;
    private static boolean c;

    /* renamed from: a, reason: collision with root package name */
    private static final Object f476a = new Object();
    private static final Object d = new Object();

    public static SparseArray<Bundle> a(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int i = 0; i < size; i++) {
            Bundle bundle = list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    public static Bundle a(Notification notification) {
        synchronized (f476a) {
            if (c) {
                return null;
            }
            try {
                if (b == null) {
                    Field declaredField = Notification.class.getDeclaredField(AppLinkData.ARGUMENTS_EXTRAS_KEY);
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        c = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    b = declaredField;
                }
                Bundle bundle = (Bundle) b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    b.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e) {
                Log.e("NotificationCompat", "Unable to access notification extras", e);
                c = true;
                return null;
            } catch (NoSuchFieldException e2) {
                Log.e("NotificationCompat", "Unable to access notification extras", e2);
                c = true;
                return null;
            }
        }
    }

    public static Bundle a(Notification.Builder builder, h.a aVar) {
        IconCompat a2 = aVar.a();
        builder.addAction(a2 != null ? a2.c() : 0, aVar.b(), aVar.c());
        Bundle bundle = new Bundle(aVar.d());
        if (aVar.f() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", a(aVar.f()));
        }
        if (aVar.i() != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", a(aVar.i()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.e());
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bundle a(h.a aVar) {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        IconCompat a2 = aVar.a();
        bundle2.putInt("icon", a2 != null ? a2.c() : 0);
        bundle2.putCharSequence("title", aVar.b());
        bundle2.putParcelable("actionIntent", aVar.c());
        if (aVar.d() != null) {
            bundle = new Bundle(aVar.d());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.e());
        bundle2.putBundle(AppLinkData.ARGUMENTS_EXTRAS_KEY, bundle);
        bundle2.putParcelableArray("remoteInputs", a(aVar.f()));
        bundle2.putBoolean("showsUserInterface", aVar.j());
        bundle2.putInt("semanticAction", aVar.g());
        return bundle2;
    }

    private static Bundle a(l lVar) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", lVar.a());
        bundle.putCharSequence("label", lVar.b());
        bundle.putCharSequenceArray("choices", lVar.c());
        bundle.putBoolean("allowFreeFormInput", lVar.e());
        bundle.putBundle(AppLinkData.ARGUMENTS_EXTRAS_KEY, lVar.g());
        Set<String> d2 = lVar.d();
        if (d2 != null && !d2.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList<>(d2.size());
            Iterator<String> it = d2.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            bundle.putStringArrayList("allowedDataTypes", arrayList);
        }
        return bundle;
    }

    private static Bundle[] a(l[] lVarArr) {
        if (lVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[lVarArr.length];
        for (int i = 0; i < lVarArr.length; i++) {
            bundleArr[i] = a(lVarArr[i]);
        }
        return bundleArr;
    }
}
