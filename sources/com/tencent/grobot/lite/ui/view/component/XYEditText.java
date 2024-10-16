package com.tencent.grobot.lite.ui.view.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;

/* loaded from: classes2.dex */
public class XYEditText extends EditText {
    private OnKeyEventListener keyEventListener;

    /* loaded from: classes2.dex */
    public interface OnKeyEventListener {
        void onDeleteClick();

        void onKeyboardHide();
    }

    public XYEditText(Context context) {
        super(context);
    }

    public XYEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public XYEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return new XYInputConnection(super.onCreateInputConnection(editorInfo), true);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            OnKeyEventListener onKeyEventListener = this.keyEventListener;
            if (onKeyEventListener != null) {
                onKeyEventListener.onKeyboardHide();
            }
            super.onKeyPreIme(i, keyEvent);
            return false;
        }
        return super.onKeyPreIme(i, keyEvent);
    }

    public void setKeyEventListener(OnKeyEventListener onKeyEventListener) {
        this.keyEventListener = onKeyEventListener;
    }

    /* loaded from: classes2.dex */
    private class XYInputConnection extends InputConnectionWrapper {
        public XYInputConnection(InputConnection inputConnection, boolean z) {
            super(inputConnection, z);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean sendKeyEvent(KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 67 && XYEditText.this.keyEventListener != null) {
                XYEditText.this.keyEventListener.onDeleteClick();
                return true;
            }
            return super.sendKeyEvent(keyEvent);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean deleteSurroundingText(int i, int i2) {
            if (i == 1 && i2 == 0) {
                return sendKeyEvent(new KeyEvent(0, 67)) && sendKeyEvent(new KeyEvent(1, 67));
            }
            return super.deleteSurroundingText(i, i2);
        }
    }
}
