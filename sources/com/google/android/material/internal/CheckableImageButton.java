package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import androidx.appcompat.a;
import androidx.core.f.v;
import com.amazonaws.event.ProgressEvent;

/* loaded from: classes2.dex */
public class CheckableImageButton extends androidx.appcompat.widget.m implements Checkable {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f5283a = {R.attr.state_checked};
    private boolean b;

    public CheckableImageButton(Context context) {
        this(context, null);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0024a.imageButtonStyle);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        v.a(this, new androidx.core.f.a() { // from class: com.google.android.material.internal.CheckableImageButton.1
            @Override // androidx.core.f.a
            public void d(View view, AccessibilityEvent accessibilityEvent) {
                super.d(view, accessibilityEvent);
                accessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
            }

            @Override // androidx.core.f.a
            public void a(View view, androidx.core.f.a.d dVar) {
                super.a(view, dVar);
                dVar.a(true);
                dVar.b(CheckableImageButton.this.isChecked());
            }
        });
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.b != z) {
            this.b = z;
            refreshDrawableState();
            sendAccessibilityEvent(ProgressEvent.PART_COMPLETED_EVENT_CODE);
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.b;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.b);
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i) {
        if (this.b) {
            return mergeDrawableStates(super.onCreateDrawableState(i + f5283a.length), f5283a);
        }
        return super.onCreateDrawableState(i);
    }
}
