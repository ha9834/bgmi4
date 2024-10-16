package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class AppCompatImageView extends ImageView implements androidx.core.f.u, androidx.core.widget.l {
    private final e mBackgroundTintHelper;
    private final n mImageHelper;

    public AppCompatImageView(Context context) {
        this(context, null);
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet, int i) {
        super(ar.a(context), attributeSet, i);
        this.mBackgroundTintHelper = new e(this);
        this.mBackgroundTintHelper.a(attributeSet, i);
        this.mImageHelper = new n(this);
        this.mImageHelper.a(attributeSet, i);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        n nVar = this.mImageHelper;
        if (nVar != null) {
            nVar.a(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        n nVar = this.mImageHelper;
        if (nVar != null) {
            nVar.d();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        n nVar = this.mImageHelper;
        if (nVar != null) {
            nVar.d();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        n nVar = this.mImageHelper;
        if (nVar != null) {
            nVar.d();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.a(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.a(drawable);
        }
    }

    @Override // androidx.core.f.u
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.a(colorStateList);
        }
    }

    @Override // androidx.core.f.u
    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            return eVar.a();
        }
        return null;
    }

    @Override // androidx.core.f.u
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.a(mode);
        }
    }

    @Override // androidx.core.f.u
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    @Override // androidx.core.widget.l
    public void setSupportImageTintList(ColorStateList colorStateList) {
        n nVar = this.mImageHelper;
        if (nVar != null) {
            nVar.a(colorStateList);
        }
    }

    @Override // androidx.core.widget.l
    public ColorStateList getSupportImageTintList() {
        n nVar = this.mImageHelper;
        if (nVar != null) {
            return nVar.b();
        }
        return null;
    }

    @Override // androidx.core.widget.l
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        n nVar = this.mImageHelper;
        if (nVar != null) {
            nVar.a(mode);
        }
    }

    @Override // androidx.core.widget.l
    public PorterDuff.Mode getSupportImageTintMode() {
        n nVar = this.mImageHelper;
        if (nVar != null) {
            return nVar.c();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.c();
        }
        n nVar = this.mImageHelper;
        if (nVar != null) {
            nVar.d();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.mImageHelper.a() && super.hasOverlappingRendering();
    }
}
