package androidx.constraintlayout.solver.widgets;

import java.util.Arrays;

/* loaded from: classes.dex */
public class f extends ConstraintWidget {
    protected ConstraintWidget[] ac = new ConstraintWidget[4];
    protected int ad = 0;

    public void b(ConstraintWidget constraintWidget) {
        int i = this.ad + 1;
        ConstraintWidget[] constraintWidgetArr = this.ac;
        if (i > constraintWidgetArr.length) {
            this.ac = (ConstraintWidget[]) Arrays.copyOf(constraintWidgetArr, constraintWidgetArr.length * 2);
        }
        ConstraintWidget[] constraintWidgetArr2 = this.ac;
        int i2 = this.ad;
        constraintWidgetArr2[i2] = constraintWidget;
        this.ad = i2 + 1;
    }

    public void H() {
        this.ad = 0;
    }
}
