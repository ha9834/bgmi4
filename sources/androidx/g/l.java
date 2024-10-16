package androidx.g;

import android.view.View;
import android.view.ViewGroup;
import androidx.g.j;

/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private ViewGroup f729a;
    private Runnable b;

    public void a() {
        Runnable runnable;
        if (a(this.f729a) != this || (runnable = this.b) == null) {
            return;
        }
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view, l lVar) {
        view.setTag(j.a.transition_current_scene, lVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static l a(View view) {
        return (l) view.getTag(j.a.transition_current_scene);
    }
}
