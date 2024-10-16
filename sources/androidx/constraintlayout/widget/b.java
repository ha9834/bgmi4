package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.a.a;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class b extends View {

    /* renamed from: a, reason: collision with root package name */
    protected int[] f443a;
    protected int b;
    protected Context c;
    protected androidx.constraintlayout.solver.widgets.f d;
    protected boolean e;
    private String f;

    public void b(ConstraintLayout constraintLayout) {
    }

    public void c(ConstraintLayout constraintLayout) {
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    public b(Context context) {
        super(context);
        this.f443a = new int[32];
        this.b = 0;
        this.d = null;
        this.e = false;
        this.c = context;
        a((AttributeSet) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.b.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == a.b.ConstraintLayout_Layout_constraint_referenced_ids) {
                    this.f = obtainStyledAttributes.getString(index);
                    setIds(this.f);
                }
            }
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f443a, this.b);
    }

    public void setReferencedIds(int[] iArr) {
        this.b = 0;
        for (int i : iArr) {
            setTag(i, null);
        }
    }

    @Override // android.view.View
    public void setTag(int i, Object obj) {
        int i2 = this.b + 1;
        int[] iArr = this.f443a;
        if (i2 > iArr.length) {
            this.f443a = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f443a;
        int i3 = this.b;
        iArr2[i3] = i;
        this.b = i3 + 1;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.e) {
            super.onMeasure(i, i2);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void a() {
        if (this.d == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.a) {
            ((ConstraintLayout.a) layoutParams).al = this.d;
        }
    }

    private void a(String str) {
        int i;
        Object a2;
        if (str == null || this.c == null) {
            return;
        }
        String trim = str.trim();
        try {
            i = a.C0006a.class.getField(trim).getInt(null);
        } catch (Exception unused) {
            i = 0;
        }
        if (i == 0) {
            i = this.c.getResources().getIdentifier(trim, "id", this.c.getPackageName());
        }
        if (i == 0 && isInEditMode() && (getParent() instanceof ConstraintLayout) && (a2 = ((ConstraintLayout) getParent()).a(0, trim)) != null && (a2 instanceof Integer)) {
            i = ((Integer) a2).intValue();
        }
        if (i != 0) {
            setTag(i, null);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + trim + "\"");
    }

    private void setIds(String str) {
        if (str == null) {
            return;
        }
        int i = 0;
        while (true) {
            int indexOf = str.indexOf(44, i);
            if (indexOf == -1) {
                a(str.substring(i));
                return;
            } else {
                a(str.substring(i, indexOf));
                i = indexOf + 1;
            }
        }
    }

    public void a(ConstraintLayout constraintLayout) {
        if (isInEditMode()) {
            setIds(this.f);
        }
        androidx.constraintlayout.solver.widgets.f fVar = this.d;
        if (fVar == null) {
            return;
        }
        fVar.H();
        for (int i = 0; i < this.b; i++) {
            View findViewById = constraintLayout.findViewById(this.f443a[i]);
            if (findViewById != null) {
                this.d.b(constraintLayout.a(findViewById));
            }
        }
    }
}
