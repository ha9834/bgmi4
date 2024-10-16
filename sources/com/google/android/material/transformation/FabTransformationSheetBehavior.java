package com.google.android.material.transformation;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.f.v;
import com.google.android.material.a;
import com.google.android.material.a.h;
import com.google.android.material.a.j;
import com.google.android.material.transformation.FabTransformationBehavior;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class FabTransformationSheetBehavior extends FabTransformationBehavior {

    /* renamed from: a, reason: collision with root package name */
    private Map<View, Integer> f5355a;

    public FabTransformationSheetBehavior() {
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.google.android.material.transformation.FabTransformationBehavior
    protected FabTransformationBehavior.a a(Context context, boolean z) {
        int i;
        if (z) {
            i = a.C0113a.mtrl_fab_transformation_sheet_expand_spec;
        } else {
            i = a.C0113a.mtrl_fab_transformation_sheet_collapse_spec;
        }
        FabTransformationBehavior.a aVar = new FabTransformationBehavior.a();
        aVar.f5352a = h.a(context, i);
        aVar.b = new j(17, 0.0f, 0.0f);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior, com.google.android.material.transformation.ExpandableBehavior
    public boolean a(View view, View view2, boolean z, boolean z2) {
        a(view2, z);
        return super.a(view, view2, z, z2);
    }

    private void a(View view, boolean z) {
        ViewParent parent = view.getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (Build.VERSION.SDK_INT >= 16 && z) {
                this.f5355a = new HashMap(childCount);
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                boolean z2 = (childAt.getLayoutParams() instanceof CoordinatorLayout.e) && (((CoordinatorLayout.e) childAt.getLayoutParams()).b() instanceof FabTransformationScrimBehavior);
                if (childAt != view && !z2) {
                    if (!z) {
                        Map<View, Integer> map = this.f5355a;
                        if (map != null && map.containsKey(childAt)) {
                            v.b(childAt, this.f5355a.get(childAt).intValue());
                        }
                    } else {
                        if (Build.VERSION.SDK_INT >= 16) {
                            this.f5355a.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        }
                        v.b(childAt, 4);
                    }
                }
            }
            if (z) {
                return;
            }
            this.f5355a = null;
        }
    }
}
