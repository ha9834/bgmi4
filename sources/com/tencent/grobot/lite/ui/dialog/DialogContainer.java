package com.tencent.grobot.lite.ui.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.grobot.lite.common.ComponentRef;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class DialogContainer extends FrameLayout implements ComponentRef {
    private boolean canPassthrough;
    private Dialog curDialog;
    private List<Integer> exceptIds;
    private final int[] tempLocation;

    public DialogContainer(Context context) {
        this(context, null);
    }

    public DialogContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DialogContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.canPassthrough = true;
        this.exceptIds = new ArrayList();
        this.tempLocation = new int[2];
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.curDialog != null) {
            if (!this.canPassthrough) {
                if (this.exceptIds.isEmpty()) {
                    return true;
                }
                Iterator<Integer> it = this.exceptIds.iterator();
                while (it.hasNext()) {
                    View findViewById = findViewById(it.next().intValue());
                    if (findViewById != null) {
                        findViewById.getLocationOnScreen(this.tempLocation);
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        int[] iArr = this.tempLocation;
                        boolean z = rawX >= ((float) iArr[0]) && rawX <= ((float) (iArr[0] + findViewById.getWidth()));
                        int[] iArr2 = this.tempLocation;
                        boolean z2 = rawY >= ((float) iArr2[1]) && rawY <= ((float) (iArr2[1] + findViewById.getHeight()));
                        if (z && z2) {
                            return false;
                        }
                    }
                }
                return true;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.tencent.grobot.lite.common.ComponentRef
    public void onDestroy() {
        setBackground(null);
    }

    public void addExceptId(int i) {
        this.exceptIds.add(Integer.valueOf(i));
    }

    public void clearExceptId() {
        this.exceptIds.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addDialog(Dialog dialog, boolean z) {
        Dialog dialog2 = this.curDialog;
        if (dialog2 != null) {
            removeView(dialog2.v);
            this.curDialog.onDetach();
        }
        this.curDialog = dialog;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.curDialog.width(), this.curDialog.heigth());
        layoutParams.gravity = 17;
        if (this.curDialog.v == null) {
            Dialog dialog3 = this.curDialog;
            dialog3.v = dialog3.view();
        }
        addView(this.curDialog.v, layoutParams);
        this.curDialog.onAttach();
        this.canPassthrough = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeDialog(Dialog dialog) {
        Dialog dialog2 = this.curDialog;
        if (dialog2 != dialog) {
            return;
        }
        removeView(dialog2.v);
        this.curDialog.onDetach();
        this.curDialog = null;
        this.canPassthrough = true;
    }
}
