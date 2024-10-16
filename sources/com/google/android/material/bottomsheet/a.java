package com.google.android.material.bottomsheet;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.f;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.f.a.d;
import androidx.core.f.v;
import com.amazonaws.services.s3.internal.Constants;
import com.google.android.gms.nearby.messages.BleSignal;
import com.google.android.material.a;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* loaded from: classes2.dex */
public class a extends f {

    /* renamed from: a, reason: collision with root package name */
    boolean f5249a;
    private BottomSheetBehavior<FrameLayout> b;
    private boolean c;
    private boolean d;
    private BottomSheetBehavior.a e;

    public a(Context context) {
        this(context, 0);
    }

    public a(Context context, int i) {
        super(context, a(context, i));
        this.f5249a = true;
        this.c = true;
        this.e = new BottomSheetBehavior.a() { // from class: com.google.android.material.bottomsheet.a.4
            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.a
            public void onSlide(View view, float f) {
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.a
            public void onStateChanged(View view, int i2) {
                if (i2 == 5) {
                    a.this.cancel();
                }
            }
        };
        a(1);
    }

    @Override // androidx.appcompat.app.f, android.app.Dialog
    public void setContentView(int i) {
        super.setContentView(a(i, null, null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.f, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                window.clearFlags(67108864);
                window.addFlags(BleSignal.UNKNOWN_TX_POWER);
            }
            window.setLayout(-1, -1);
        }
    }

    @Override // androidx.appcompat.app.f, android.app.Dialog
    public void setContentView(View view) {
        super.setContentView(a(0, view, null));
    }

    @Override // androidx.appcompat.app.f, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(a(0, view, layoutParams));
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z) {
        super.setCancelable(z);
        if (this.f5249a != z) {
            this.f5249a = z;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.b;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.setHideable(z);
            }
        }
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.b;
        if (bottomSheetBehavior == null || bottomSheetBehavior.getState() != 5) {
            return;
        }
        this.b.setState(4);
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.f5249a) {
            this.f5249a = true;
        }
        this.c = z;
        this.d = true;
    }

    private View a(int i, View view, ViewGroup.LayoutParams layoutParams) {
        FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), a.h.design_bottom_sheet_dialog, null);
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) frameLayout.findViewById(a.f.coordinator);
        if (i != 0 && view == null) {
            view = getLayoutInflater().inflate(i, (ViewGroup) coordinatorLayout, false);
        }
        FrameLayout frameLayout2 = (FrameLayout) coordinatorLayout.findViewById(a.f.design_bottom_sheet);
        this.b = BottomSheetBehavior.from(frameLayout2);
        this.b.setBottomSheetCallback(this.e);
        this.b.setHideable(this.f5249a);
        if (layoutParams == null) {
            frameLayout2.addView(view);
        } else {
            frameLayout2.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(a.f.touch_outside).setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.bottomsheet.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.f5249a && a.this.isShowing() && a.this.a()) {
                    a.this.cancel();
                }
            }
        });
        v.a(frameLayout2, new androidx.core.f.a() { // from class: com.google.android.material.bottomsheet.a.2
            @Override // androidx.core.f.a
            public void a(View view2, d dVar) {
                super.a(view2, dVar);
                if (a.this.f5249a) {
                    dVar.a(Constants.MB);
                    dVar.e(true);
                } else {
                    dVar.e(false);
                }
            }

            @Override // androidx.core.f.a
            public boolean a(View view2, int i2, Bundle bundle) {
                if (i2 == 1048576 && a.this.f5249a) {
                    a.this.cancel();
                    return true;
                }
                return super.a(view2, i2, bundle);
            }
        });
        frameLayout2.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.material.bottomsheet.a.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                return true;
            }
        });
        return frameLayout;
    }

    boolean a() {
        if (!this.d) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{R.attr.windowCloseOnTouchOutside});
            this.c = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
            this.d = true;
        }
        return this.c;
    }

    private static int a(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(a.b.bottomSheetDialogTheme, typedValue, true)) {
            return typedValue.resourceId;
        }
        return a.j.Theme_Design_Light_BottomSheetDialog;
    }
}
