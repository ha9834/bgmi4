package com.google.android.material.navigation;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.internal.f;
import com.google.android.material.internal.g;
import com.google.android.material.internal.i;

/* loaded from: classes2.dex */
public class NavigationView extends i {
    private static final int[] d = {R.attr.state_checked};
    private static final int[] e = {-16842910};
    a c;
    private final f f;
    private final g g;
    private final int h;
    private MenuInflater i;

    /* loaded from: classes2.dex */
    public interface a {
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f5313a = new Bundle();
        this.f.a(savedState.f5313a);
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        this.f.b(savedState.f5313a);
    }

    public void setNavigationItemSelectedListener(a aVar) {
        this.c = aVar;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE) {
            i = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i), this.h), 1073741824);
        } else if (mode == 0) {
            i = View.MeasureSpec.makeMeasureSpec(this.h, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public Menu getMenu() {
        return this.f;
    }

    public int getHeaderCount() {
        return this.g.d();
    }

    public ColorStateList getItemIconTintList() {
        return this.g.e();
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.g.a(colorStateList);
    }

    public ColorStateList getItemTextColor() {
        return this.g.g();
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.g.b(colorStateList);
    }

    public Drawable getItemBackground() {
        return this.g.h();
    }

    public void setItemBackgroundResource(int i) {
        setItemBackground(androidx.core.content.a.a(getContext(), i));
    }

    public void setItemBackground(Drawable drawable) {
        this.g.a(drawable);
    }

    public int getItemHorizontalPadding() {
        return this.g.i();
    }

    public void setItemHorizontalPadding(int i) {
        this.g.b(i);
    }

    public void setItemHorizontalPaddingResource(int i) {
        this.g.b(getResources().getDimensionPixelSize(i));
    }

    public int getItemIconPadding() {
        return this.g.j();
    }

    public void setItemIconPadding(int i) {
        this.g.c(i);
    }

    public void setItemIconPaddingResource(int i) {
        this.g.c(getResources().getDimensionPixelSize(i));
    }

    public void setCheckedItem(int i) {
        MenuItem findItem = this.f.findItem(i);
        if (findItem != null) {
            this.g.a((androidx.appcompat.view.menu.i) findItem);
        }
    }

    public void setCheckedItem(MenuItem menuItem) {
        MenuItem findItem = this.f.findItem(menuItem.getItemId());
        if (findItem != null) {
            this.g.a((androidx.appcompat.view.menu.i) findItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }

    public MenuItem getCheckedItem() {
        return this.g.a();
    }

    public void setItemTextAppearance(int i) {
        this.g.a(i);
    }

    private MenuInflater getMenuInflater() {
        if (this.i == null) {
            this.i = new androidx.appcompat.view.g(getContext());
        }
        return this.i;
    }

    /* loaded from: classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.navigation.NavigationView.SavedState.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a, reason: collision with root package name */
        public Bundle f5313a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f5313a = parcel.readBundle(classLoader);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.f5313a);
        }
    }
}
