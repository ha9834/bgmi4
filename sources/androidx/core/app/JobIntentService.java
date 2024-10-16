package androidx.core.app;

import android.app.Service;
import android.content.ComponentName;
import android.os.Build;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class JobIntentService extends Service {
    static final Object e = new Object();
    static final HashMap<ComponentName, Object> f = new HashMap<>();

    /* renamed from: a, reason: collision with root package name */
    boolean f458a = false;
    boolean b = false;
    boolean c = false;
    final ArrayList<Object> d;

    public JobIntentService() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.d = null;
        } else {
            this.d = new ArrayList<>();
        }
    }
}
