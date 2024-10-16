package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
class k {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(RecyclerView.t tVar, i iVar, View view, View view2, RecyclerView.i iVar2, boolean z, boolean z2) {
        int max;
        if (iVar2.y() == 0 || tVar.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        int min = Math.min(iVar2.d(view), iVar2.d(view2));
        int max2 = Math.max(iVar2.d(view), iVar2.d(view2));
        if (z2) {
            max = Math.max(0, (tVar.e() - max2) - 1);
        } else {
            max = Math.max(0, min);
        }
        if (!z) {
            return max;
        }
        return Math.round((max * (Math.abs(iVar.b(view2) - iVar.a(view)) / (Math.abs(iVar2.d(view) - iVar2.d(view2)) + 1))) + (iVar.c() - iVar.a(view)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(RecyclerView.t tVar, i iVar, View view, View view2, RecyclerView.i iVar2, boolean z) {
        if (iVar2.y() == 0 || tVar.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(iVar2.d(view) - iVar2.d(view2)) + 1;
        }
        return Math.min(iVar.f(), iVar.b(view2) - iVar.a(view));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(RecyclerView.t tVar, i iVar, View view, View view2, RecyclerView.i iVar2, boolean z) {
        if (iVar2.y() == 0 || tVar.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return tVar.e();
        }
        return (int) (((iVar.b(view2) - iVar.a(view)) / (Math.abs(iVar2.d(view) - iVar2.d(view2)) + 1)) * tVar.e());
    }
}
