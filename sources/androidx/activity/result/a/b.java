package androidx.activity.result.a;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.a.a;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: androidx.activity.result.a.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0023b extends androidx.activity.result.a.a<Intent, ActivityResult> {
        @Override // androidx.activity.result.a.a
        public Intent a(Context context, Intent intent) {
            return intent;
        }

        @Override // androidx.activity.result.a.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ActivityResult a(int i, Intent intent) {
            return new ActivityResult(i, intent);
        }
    }

    /* loaded from: classes.dex */
    public static final class a extends androidx.activity.result.a.a<String[], Map<String, Boolean>> {
        @Override // androidx.activity.result.a.a
        public Intent a(Context context, String[] strArr) {
            return a(strArr);
        }

        @Override // androidx.activity.result.a.a
        public a.C0022a<Map<String, Boolean>> b(Context context, String[] strArr) {
            if (strArr == null || strArr.length == 0) {
                return new a.C0022a<>(Collections.emptyMap());
            }
            androidx.b.a aVar = new androidx.b.a();
            boolean z = true;
            for (String str : strArr) {
                boolean z2 = androidx.core.content.a.b(context, str) == 0;
                aVar.put(str, Boolean.valueOf(z2));
                if (!z2) {
                    z = false;
                }
            }
            if (z) {
                return new a.C0022a<>(aVar);
            }
            return null;
        }

        @Override // androidx.activity.result.a.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map<String, Boolean> a(int i, Intent intent) {
            if (i != -1) {
                return Collections.emptyMap();
            }
            if (intent == null) {
                return Collections.emptyMap();
            }
            String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
            if (intArrayExtra == null || stringArrayExtra == null) {
                return Collections.emptyMap();
            }
            HashMap hashMap = new HashMap();
            int length = stringArrayExtra.length;
            for (int i2 = 0; i2 < length; i2++) {
                hashMap.put(stringArrayExtra[i2], Boolean.valueOf(intArrayExtra[i2] == 0));
            }
            return hashMap;
        }

        static Intent a(String[] strArr) {
            return new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr);
        }
    }
}
