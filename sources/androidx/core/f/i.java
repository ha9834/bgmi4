package androidx.core.f;

import android.view.MotionEvent;

/* loaded from: classes.dex */
public final class i {
    @Deprecated
    public static int a(MotionEvent motionEvent) {
        return motionEvent.getActionMasked();
    }

    public static boolean a(MotionEvent motionEvent, int i) {
        return (motionEvent.getSource() & i) == i;
    }
}
