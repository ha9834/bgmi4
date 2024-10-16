package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.core.d.b;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public class x extends TextView implements androidx.core.f.u, androidx.core.widget.b, androidx.core.widget.k {
    private final e mBackgroundTintHelper;
    private Future<androidx.core.d.b> mPrecomputedTextFuture;
    private final v mTextClassifierHelper;
    private final w mTextHelper;

    public x(Context context) {
        this(context, null);
    }

    public x(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public x(Context context, AttributeSet attributeSet, int i) {
        super(ar.a(context), attributeSet, i);
        this.mBackgroundTintHelper = new e(this);
        this.mBackgroundTintHelper.a(attributeSet, i);
        this.mTextHelper = new w(this);
        this.mTextHelper.a(attributeSet, i);
        this.mTextHelper.b();
        this.mTextClassifierHelper = new v(this);
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

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        w wVar = this.mTextHelper;
        if (wVar != null) {
            wVar.a(context, i);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.c();
        }
        w wVar = this.mTextHelper;
        if (wVar != null) {
            wVar.b();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        w wVar = this.mTextHelper;
        if (wVar != null) {
            wVar.a(z, i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        if (d) {
            super.setTextSize(i, f);
            return;
        }
        w wVar = this.mTextHelper;
        if (wVar != null) {
            wVar.a(i, f);
        }
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (this.mTextHelper == null || d || !this.mTextHelper.d()) {
            return;
        }
        this.mTextHelper.c();
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (d) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        w wVar = this.mTextHelper;
        if (wVar != null) {
            wVar.a(i);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        if (d) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
            return;
        }
        w wVar = this.mTextHelper;
        if (wVar != null) {
            wVar.a(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) throws IllegalArgumentException {
        if (d) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            return;
        }
        w wVar = this.mTextHelper;
        if (wVar != null) {
            wVar.a(iArr, i);
        }
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (d) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        w wVar = this.mTextHelper;
        if (wVar != null) {
            return wVar.e();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (d) {
            return super.getAutoSizeStepGranularity();
        }
        w wVar = this.mTextHelper;
        if (wVar != null) {
            return wVar.f();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (d) {
            return super.getAutoSizeMinTextSize();
        }
        w wVar = this.mTextHelper;
        if (wVar != null) {
            return wVar.g();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (d) {
            return super.getAutoSizeMaxTextSize();
        }
        w wVar = this.mTextHelper;
        if (wVar != null) {
            return wVar.h();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (d) {
            return super.getAutoSizeTextAvailableSizes();
        }
        w wVar = this.mTextHelper;
        if (wVar != null) {
            return wVar.i();
        }
        return new int[0];
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return l.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i);
        } else {
            androidx.core.widget.i.b(this, i);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i);
        } else {
            androidx.core.widget.i.c(this, i);
        }
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return androidx.core.widget.i.c(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return androidx.core.widget.i.d(this);
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i) {
        androidx.core.widget.i.d(this, i);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.i.a(this, callback));
    }

    public b.a getTextMetricsParamsCompat() {
        return androidx.core.widget.i.e(this);
    }

    public void setTextMetricsParamsCompat(b.a aVar) {
        androidx.core.widget.i.a(this, aVar);
    }

    public void setPrecomputedText(androidx.core.d.b bVar) {
        androidx.core.widget.i.a(this, bVar);
    }

    private void consumeTextFutureAndSetBlocking() {
        Future<androidx.core.d.b> future = this.mPrecomputedTextFuture;
        if (future != null) {
            try {
                this.mPrecomputedTextFuture = null;
                androidx.core.widget.i.a(this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        consumeTextFutureAndSetBlocking();
        return super.getText();
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        v vVar;
        if (Build.VERSION.SDK_INT >= 28 || (vVar = this.mTextClassifierHelper) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            vVar.a(textClassifier);
        }
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        v vVar;
        if (Build.VERSION.SDK_INT >= 28 || (vVar = this.mTextClassifierHelper) == null) {
            return super.getTextClassifier();
        }
        return vVar.a();
    }

    public void setTextFuture(Future<androidx.core.d.b> future) {
        this.mPrecomputedTextFuture = future;
        if (future != null) {
            requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        consumeTextFutureAndSetBlocking();
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        w wVar = this.mTextHelper;
        if (wVar != null) {
            wVar.a();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        w wVar = this.mTextHelper;
        if (wVar != null) {
            wVar.a();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        w wVar = this.mTextHelper;
        if (wVar != null) {
            wVar.a();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i != 0 ? androidx.appcompat.a.a.a.b(context, i) : null, i2 != 0 ? androidx.appcompat.a.a.a.b(context, i2) : null, i3 != 0 ? androidx.appcompat.a.a.a.b(context, i3) : null, i4 != 0 ? androidx.appcompat.a.a.a.b(context, i4) : null);
        w wVar = this.mTextHelper;
        if (wVar != null) {
            wVar.a();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        w wVar = this.mTextHelper;
        if (wVar != null) {
            wVar.a();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i != 0 ? androidx.appcompat.a.a.a.b(context, i) : null, i2 != 0 ? androidx.appcompat.a.a.a.b(context, i2) : null, i3 != 0 ? androidx.appcompat.a.a.a.b(context, i3) : null, i4 != 0 ? androidx.appcompat.a.a.a.b(context, i4) : null);
        w wVar = this.mTextHelper;
        if (wVar != null) {
            wVar.a();
        }
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.mTextHelper.j();
    }

    @Override // androidx.core.widget.k
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.mTextHelper.a(colorStateList);
        this.mTextHelper.b();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.mTextHelper.k();
    }

    @Override // androidx.core.widget.k
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.mTextHelper.a(mode);
        this.mTextHelper.b();
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface, int i) {
        Typeface a2 = (typeface == null || i <= 0) ? null : androidx.core.graphics.e.a(getContext(), typeface, i);
        if (a2 != null) {
            typeface = a2;
        }
        super.setTypeface(typeface, i);
    }
}
