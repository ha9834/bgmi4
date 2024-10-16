package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.ag;
import androidx.appcompat.widget.aw;
import androidx.core.f.v;
import com.amazonaws.event.ProgressEvent;
import com.google.android.material.a;

/* loaded from: classes2.dex */
public class NavigationMenuItemView extends e implements n.a {
    private static final int[] d = {R.attr.state_checked};
    boolean c;
    private final int e;
    private boolean f;
    private final CheckedTextView g;
    private FrameLayout h;
    private androidx.appcompat.view.menu.i i;
    private ColorStateList j;
    private boolean k;
    private Drawable l;
    private final androidx.core.f.a m;

    @Override // androidx.appcompat.view.menu.n.a
    public boolean a() {
        return false;
    }

    public NavigationMenuItemView(Context context) {
        this(context, null);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.m = new androidx.core.f.a() { // from class: com.google.android.material.internal.NavigationMenuItemView.1
            @Override // androidx.core.f.a
            public void a(View view, androidx.core.f.a.d dVar) {
                super.a(view, dVar);
                dVar.a(NavigationMenuItemView.this.c);
            }
        };
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.h.design_navigation_menu_item, (ViewGroup) this, true);
        this.e = context.getResources().getDimensionPixelSize(a.d.design_navigation_icon_size);
        this.g = (CheckedTextView) findViewById(a.f.design_menu_item_text);
        this.g.setDuplicateParentStateEnabled(true);
        v.a(this.g, this.m);
    }

    @Override // androidx.appcompat.view.menu.n.a
    public void a(androidx.appcompat.view.menu.i iVar, int i) {
        this.i = iVar;
        setVisibility(iVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            v.a(this, e());
        }
        setCheckable(iVar.isCheckable());
        setChecked(iVar.isChecked());
        setEnabled(iVar.isEnabled());
        setTitle(iVar.getTitle());
        setIcon(iVar.getIcon());
        setActionView(iVar.getActionView());
        setContentDescription(iVar.getContentDescription());
        aw.a(this, iVar.getTooltipText());
        d();
    }

    private boolean c() {
        return this.i.getTitle() == null && this.i.getIcon() == null && this.i.getActionView() != null;
    }

    private void d() {
        if (c()) {
            this.g.setVisibility(8);
            FrameLayout frameLayout = this.h;
            if (frameLayout != null) {
                ag.a aVar = (ag.a) frameLayout.getLayoutParams();
                aVar.width = -1;
                this.h.setLayoutParams(aVar);
                return;
            }
            return;
        }
        this.g.setVisibility(0);
        FrameLayout frameLayout2 = this.h;
        if (frameLayout2 != null) {
            ag.a aVar2 = (ag.a) frameLayout2.getLayoutParams();
            aVar2.width = -2;
            this.h.setLayoutParams(aVar2);
        }
    }

    public void b() {
        FrameLayout frameLayout = this.h;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        this.g.setCompoundDrawables(null, null, null, null);
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.h == null) {
                this.h = (FrameLayout) ((ViewStub) findViewById(a.f.design_menu_item_action_area_stub)).inflate();
            }
            this.h.removeAllViews();
            this.h.addView(view);
        }
    }

    private StateListDrawable e() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(a.C0024a.colorControlHighlight, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(d, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    @Override // androidx.appcompat.view.menu.n.a
    public androidx.appcompat.view.menu.i getItemData() {
        return this.i;
    }

    public void setTitle(CharSequence charSequence) {
        this.g.setText(charSequence);
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.c != z) {
            this.c = z;
            this.m.a(this.g, ProgressEvent.PART_COMPLETED_EVENT_CODE);
        }
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.g.setChecked(z);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.k) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = androidx.core.graphics.drawable.a.g(drawable).mutate();
                androidx.core.graphics.drawable.a.a(drawable, this.j);
            }
            int i = this.e;
            drawable.setBounds(0, 0, i, i);
        } else if (this.f) {
            if (this.l == null) {
                this.l = androidx.core.content.a.f.a(getResources(), a.e.navigation_empty_icon, getContext().getTheme());
                Drawable drawable2 = this.l;
                if (drawable2 != null) {
                    int i2 = this.e;
                    drawable2.setBounds(0, 0, i2, i2);
                }
            }
            drawable = this.l;
        }
        androidx.core.widget.i.a(this.g, drawable, null, null, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        androidx.appcompat.view.menu.i iVar = this.i;
        if (iVar != null && iVar.isCheckable() && this.i.isChecked()) {
            mergeDrawableStates(onCreateDrawableState, d);
        }
        return onCreateDrawableState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setIconTintList(ColorStateList colorStateList) {
        this.j = colorStateList;
        this.k = this.j != null;
        androidx.appcompat.view.menu.i iVar = this.i;
        if (iVar != null) {
            setIcon(iVar.getIcon());
        }
    }

    public void setTextAppearance(int i) {
        androidx.core.widget.i.a(this.g, i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.g.setTextColor(colorStateList);
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.f = z;
    }

    public void setHorizontalPadding(int i) {
        setPadding(i, 0, i, 0);
    }

    public void setIconPadding(int i) {
        this.g.setCompoundDrawablePadding(i);
    }
}
