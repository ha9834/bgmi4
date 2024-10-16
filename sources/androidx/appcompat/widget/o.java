package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import androidx.appcompat.a;

/* loaded from: classes.dex */
public class o extends MultiAutoCompleteTextView implements androidx.core.f.u {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f361a = {R.attr.popupBackground};
    private final e b;
    private final w c;

    public o(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0024a.autoCompleteTextViewStyle);
    }

    public o(Context context, AttributeSet attributeSet, int i) {
        super(ar.a(context), attributeSet, i);
        au a2 = au.a(getContext(), attributeSet, f361a, i, 0);
        if (a2.g(0)) {
            setDropDownBackgroundDrawable(a2.a(0));
        }
        a2.a();
        this.b = new e(this);
        this.b.a(attributeSet, i);
        this.c = new w(this);
        this.c.a(attributeSet, i);
        this.c.b();
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(androidx.appcompat.a.a.a.b(getContext(), i));
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        e eVar = this.b;
        if (eVar != null) {
            eVar.a(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.b;
        if (eVar != null) {
            eVar.a(drawable);
        }
    }

    @Override // androidx.core.f.u
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.b;
        if (eVar != null) {
            eVar.a(colorStateList);
        }
    }

    @Override // androidx.core.f.u
    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.b;
        if (eVar != null) {
            return eVar.a();
        }
        return null;
    }

    @Override // androidx.core.f.u
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.b;
        if (eVar != null) {
            eVar.a(mode);
        }
    }

    @Override // androidx.core.f.u
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.b;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.b;
        if (eVar != null) {
            eVar.c();
        }
        w wVar = this.c;
        if (wVar != null) {
            wVar.b();
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        w wVar = this.c;
        if (wVar != null) {
            wVar.a(context, i);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return l.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }
}
