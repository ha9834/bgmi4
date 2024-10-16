package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import androidx.appcompat.a;

/* loaded from: classes.dex */
public class k extends EditText implements androidx.core.f.u {
    private final e mBackgroundTintHelper;
    private final v mTextClassifierHelper;
    private final w mTextHelper;

    public k(Context context) {
        this(context, null);
    }

    public k(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0024a.editTextStyle);
    }

    public k(Context context, AttributeSet attributeSet, int i) {
        super(ar.a(context), attributeSet, i);
        this.mBackgroundTintHelper = new e(this);
        this.mBackgroundTintHelper.a(attributeSet, i);
        this.mTextHelper = new w(this);
        this.mTextHelper.a(attributeSet, i);
        this.mTextHelper.b();
        this.mTextClassifierHelper = new v(this);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        if (Build.VERSION.SDK_INT >= 28) {
            return super.getText();
        }
        return super.getEditableText();
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

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        w wVar = this.mTextHelper;
        if (wVar != null) {
            wVar.a(context, i);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return l.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.i.a(this, callback));
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
}
