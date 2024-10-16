package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.appcompat.a;

/* loaded from: classes.dex */
public class m extends ImageButton implements androidx.core.f.u, androidx.core.widget.l {

    /* renamed from: a, reason: collision with root package name */
    private final e f359a;
    private final n b;

    public m(Context context) {
        this(context, null);
    }

    public m(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0024a.imageButtonStyle);
    }

    public m(Context context, AttributeSet attributeSet, int i) {
        super(ar.a(context), attributeSet, i);
        this.f359a = new e(this);
        this.f359a.a(attributeSet, i);
        this.b = new n(this);
        this.b.a(attributeSet, i);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.b.a(i);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        n nVar = this.b;
        if (nVar != null) {
            nVar.d();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        n nVar = this.b;
        if (nVar != null) {
            nVar.d();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        n nVar = this.b;
        if (nVar != null) {
            nVar.d();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        e eVar = this.f359a;
        if (eVar != null) {
            eVar.a(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f359a;
        if (eVar != null) {
            eVar.a(drawable);
        }
    }

    @Override // androidx.core.f.u
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f359a;
        if (eVar != null) {
            eVar.a(colorStateList);
        }
    }

    @Override // androidx.core.f.u
    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f359a;
        if (eVar != null) {
            return eVar.a();
        }
        return null;
    }

    @Override // androidx.core.f.u
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f359a;
        if (eVar != null) {
            eVar.a(mode);
        }
    }

    @Override // androidx.core.f.u
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f359a;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    @Override // androidx.core.widget.l
    public void setSupportImageTintList(ColorStateList colorStateList) {
        n nVar = this.b;
        if (nVar != null) {
            nVar.a(colorStateList);
        }
    }

    @Override // androidx.core.widget.l
    public ColorStateList getSupportImageTintList() {
        n nVar = this.b;
        if (nVar != null) {
            return nVar.b();
        }
        return null;
    }

    @Override // androidx.core.widget.l
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        n nVar = this.b;
        if (nVar != null) {
            nVar.a(mode);
        }
    }

    @Override // androidx.core.widget.l
    public PorterDuff.Mode getSupportImageTintMode() {
        n nVar = this.b;
        if (nVar != null) {
            return nVar.c();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f359a;
        if (eVar != null) {
            eVar.c();
        }
        n nVar = this.b;
        if (nVar != null) {
            nVar.d();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.b.a() && super.hasOverlappingRendering();
    }
}
