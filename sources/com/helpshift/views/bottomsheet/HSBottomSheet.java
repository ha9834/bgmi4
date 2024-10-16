package com.helpshift.views.bottomsheet;

import android.R;
import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.f.v;
import androidx.core.graphics.b;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class HSBottomSheet {
    final ViewGroup bottomSheet;
    final View bottomSheetParentView;
    final Window bottomSheetWindow;
    List<BottomSheetBehavior.a> callbacks = new ArrayList();
    final View contentView;
    final float dimOpacity;
    final boolean enableDimAnimation;
    final View referenceWindowView;
    final View viewToDim;

    HSBottomSheet(View view, Window window, View view2, View view3, boolean z, float f, View view4, ViewGroup viewGroup) {
        this.contentView = view;
        this.bottomSheetWindow = window;
        this.referenceWindowView = view2;
        this.viewToDim = view3;
        this.enableDimAnimation = z;
        this.dimOpacity = f;
        this.bottomSheetParentView = view4;
        this.bottomSheet = viewGroup;
    }

    public void show() {
        this.bottomSheet.addView(this.contentView);
        attachBehaviourCallback();
        if (this.referenceWindowView != null) {
            initiateReferenceViewAttachment();
        } else {
            this.bottomSheetWindow.addContentView(this.bottomSheetParentView, getParamsForWindow());
        }
    }

    public void remove() {
        if (v.A(this.bottomSheetParentView)) {
            ((ViewGroup) this.bottomSheetParentView.getParent()).removeView(this.bottomSheetParentView);
        }
        View view = this.viewToDim;
        if (view == null || !v.A(view)) {
            return;
        }
        ((ViewGroup) this.viewToDim.getParent()).removeView(this.viewToDim);
    }

    public void setDraggable(boolean z) {
        ((HSBottomSheetBehaviour) getBottomSheetBehaviour()).setDraggable(z);
    }

    public void addBottomSheetCallback(BottomSheetBehavior.a aVar) {
        this.callbacks.add(aVar);
    }

    public void removeAllBottomSheetCallbacks() {
        this.callbacks.clear();
    }

    private void initiateReferenceViewAttachment() {
        if (v.x(this.referenceWindowView)) {
            showOnReferenceView();
        } else {
            this.referenceWindowView.post(new Runnable() { // from class: com.helpshift.views.bottomsheet.HSBottomSheet.1
                @Override // java.lang.Runnable
                public void run() {
                    HSBottomSheet.this.showOnReferenceView();
                }
            });
        }
    }

    public View getBottomSheetContentView() {
        return this.contentView;
    }

    void showOnReferenceView() {
        setupBottomSheetView();
        attachBottomSheetToWindow(getParamsForReferenceView());
    }

    ViewGroup.LayoutParams getParamsForWindow() {
        ViewGroup.LayoutParams layoutParams = this.contentView.getLayoutParams();
        layoutParams.height = -1;
        layoutParams.width = -1;
        return layoutParams;
    }

    ViewGroup.LayoutParams getParamsForReferenceView() {
        ViewGroup.LayoutParams layoutParams = this.contentView.getLayoutParams();
        layoutParams.height = -1;
        layoutParams.width = this.referenceWindowView.getWidth();
        return layoutParams;
    }

    private void attachBottomSheetToWindow(ViewGroup.LayoutParams layoutParams) {
        this.bottomSheetWindow.addContentView(this.bottomSheetParentView, layoutParams);
    }

    private void attachBehaviourCallback() {
        getBottomSheetBehaviour().setBottomSheetCallback(new BottomSheetBehavior.a() { // from class: com.helpshift.views.bottomsheet.HSBottomSheet.2
            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.a
            public void onStateChanged(View view, int i) {
                if (HSBottomSheet.this.viewToDim != null) {
                    if (i == 3) {
                        HSBottomSheet.this.viewToDim.setClickable(true);
                    } else if (i == 4) {
                        HSBottomSheet.this.viewToDim.setClickable(false);
                    }
                }
                if (HSBottomSheet.this.callbacks.size() > 0) {
                    Iterator<BottomSheetBehavior.a> it = HSBottomSheet.this.callbacks.iterator();
                    while (it.hasNext()) {
                        it.next().onStateChanged(view, i);
                    }
                }
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.a
            public void onSlide(View view, float f) {
                if (HSBottomSheet.this.enableDimAnimation && HSBottomSheet.this.viewToDim != null) {
                    HSBottomSheet.this.viewToDim.setBackgroundColor(b.a(0, WebView.NIGHT_MODE_COLOR, (f > 0.0f ? f : 0.0f) * HSBottomSheet.this.dimOpacity));
                }
                if (HSBottomSheet.this.callbacks.size() > 0) {
                    Iterator<BottomSheetBehavior.a> it = HSBottomSheet.this.callbacks.iterator();
                    while (it.hasNext()) {
                        it.next().onSlide(view, f);
                    }
                }
            }
        });
    }

    void setupBottomSheetView() {
        int i;
        View findViewById;
        this.referenceWindowView.getLocationInWindow(new int[2]);
        View decorView = this.bottomSheetWindow.getDecorView();
        if (decorView == null || (findViewById = decorView.findViewById(R.id.content)) == null) {
            i = 0;
        } else {
            int[] iArr = new int[2];
            findViewById.getLocationInWindow(iArr);
            i = iArr[0];
        }
        this.bottomSheetParentView.setX(Math.max(0, r1[0] - i));
    }

    public BottomSheetBehavior getBottomSheetBehaviour() {
        return BottomSheetBehavior.from(this.bottomSheet);
    }

    /* loaded from: classes2.dex */
    public static class Builder {
        private View content;
        private float dimOpacity = 1.0f;
        private boolean enableDimAnimation;
        private int layoutId;
        private Window layoutWindow;
        private View referenceView;

        public Builder(Window window) {
            this.layoutWindow = window;
        }

        public Builder contentView(int i) {
            this.layoutId = i;
            return this;
        }

        public Builder referenceView(View view) {
            this.referenceView = view;
            return this;
        }

        public Builder enableDimAnimation(boolean z) {
            this.enableDimAnimation = z;
            return this;
        }

        public Builder dimOpacity(float f) {
            this.dimOpacity = f;
            return this;
        }

        @SuppressLint({"InflateParams"})
        public HSBottomSheet inflateAndBuild() {
            View view;
            if (this.layoutWindow == null) {
                throw new IllegalArgumentException("Bottomsheet layout window can not be null");
            }
            if (this.enableDimAnimation) {
                View view2 = new View(this.referenceView.getContext());
                Window window = this.layoutWindow;
                window.addContentView(view2, window.getAttributes());
                view = view2;
            } else {
                view = null;
            }
            LayoutInflater from = LayoutInflater.from(this.layoutWindow.getContext());
            this.content = from.inflate(this.layoutId, (ViewGroup) null);
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) from.inflate(com.helpshift.R.layout.hs__bottomsheet_wrapper, (ViewGroup) null);
            return new HSBottomSheet(this.content, this.layoutWindow, this.referenceView, view, this.enableDimAnimation, this.dimOpacity, coordinatorLayout, (FrameLayout) coordinatorLayout.findViewById(com.helpshift.R.id.hs__bottom_sheet));
        }
    }
}
