package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;

/* loaded from: classes.dex */
public class h extends CheckedTextView {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f355a = {R.attr.checkMark};
    private final w b;

    public h(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.checkedTextViewStyle);
    }

    public h(Context context, AttributeSet attributeSet, int i) {
        super(ar.a(context), attributeSet, i);
        this.b = new w(this);
        this.b.a(attributeSet, i);
        this.b.b();
        au a2 = au.a(getContext(), attributeSet, f355a, i, 0);
        setCheckMarkDrawable(a2.a(0));
        a2.a();
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(androidx.appcompat.a.a.a.b(getContext(), i));
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        w wVar = this.b;
        if (wVar != null) {
            wVar.a(context, i);
        }
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        w wVar = this.b;
        if (wVar != null) {
            wVar.b();
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
}
