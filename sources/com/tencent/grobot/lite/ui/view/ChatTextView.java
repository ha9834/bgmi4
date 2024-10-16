package com.tencent.grobot.lite.ui.view;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

/* loaded from: classes2.dex */
public class ChatTextView extends TextView {
    private Context context;
    boolean dontConsumeNonUrlClicks;
    public boolean linkHit;

    public ChatTextView(Context context) {
        this(context, null, 0);
    }

    public ChatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChatTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dontConsumeNonUrlClicks = true;
        this.context = context;
        setMovementMethod(LocalLinkMovementMethod.getInstance());
        setHighlightColor(getResources().getColor(R.color.transparent));
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.linkHit = false;
        return this.dontConsumeNonUrlClicks ? this.linkHit : super.onTouchEvent(motionEvent);
    }
}
