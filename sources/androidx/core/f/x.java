package androidx.core.f;

import android.os.Build;
import android.view.ViewGroup;
import androidx.core.a;

/* loaded from: classes.dex */
public final class x {
    public static boolean a(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 21) {
            return viewGroup.isTransitionGroup();
        }
        Boolean bool = (Boolean) viewGroup.getTag(a.c.tag_transition_group);
        return ((bool == null || !bool.booleanValue()) && viewGroup.getBackground() == null && v.n(viewGroup) == null) ? false : true;
    }
}
