package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckBox;
import androidx.appcompat.a;

/* loaded from: classes.dex */
public class g extends CheckBox implements androidx.core.f.u, androidx.core.widget.j {

    /* renamed from: a, reason: collision with root package name */
    private final i f354a;
    private final e b;
    private final w c;

    public g(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0024a.checkboxStyle);
    }

    public g(Context context, AttributeSet attributeSet, int i) {
        super(ar.a(context), attributeSet, i);
        this.f354a = new i(this);
        this.f354a.a(attributeSet, i);
        this.b = new e(this);
        this.b.a(attributeSet, i);
        this.c = new w(this);
        this.c.a(attributeSet, i);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        i iVar = this.f354a;
        if (iVar != null) {
            iVar.c();
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(androidx.appcompat.a.a.a.b(getContext(), i));
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        i iVar = this.f354a;
        return iVar != null ? iVar.a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    @Override // androidx.core.widget.j
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        i iVar = this.f354a;
        if (iVar != null) {
            iVar.a(colorStateList);
        }
    }

    public ColorStateList getSupportButtonTintList() {
        i iVar = this.f354a;
        if (iVar != null) {
            return iVar.a();
        }
        return null;
    }

    @Override // androidx.core.widget.j
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        i iVar = this.f354a;
        if (iVar != null) {
            iVar.a(mode);
        }
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        i iVar = this.f354a;
        if (iVar != null) {
            return iVar.b();
        }
        return null;
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

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.b;
        if (eVar != null) {
            eVar.a(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        e eVar = this.b;
        if (eVar != null) {
            eVar.a(i);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
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
}
