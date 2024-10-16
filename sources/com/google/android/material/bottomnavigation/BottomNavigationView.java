package com.google.android.material.bottomnavigation;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.g;
import androidx.customview.view.AbsSavedState;

/* loaded from: classes2.dex */
public class BottomNavigationView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private final g f5241a;
    private final com.google.android.material.bottomnavigation.b b;
    private final BottomNavigationPresenter c;
    private MenuInflater d;
    private b e;
    private a f;

    /* loaded from: classes2.dex */
    public interface a {
    }

    /* loaded from: classes2.dex */
    public interface b {
    }

    public int getMaxItemCount() {
        return 5;
    }

    public void setOnNavigationItemSelectedListener(b bVar) {
        this.e = bVar;
    }

    public void setOnNavigationItemReselectedListener(a aVar) {
        this.f = aVar;
    }

    public Menu getMenu() {
        return this.f5241a;
    }

    public ColorStateList getItemIconTintList() {
        return this.b.getIconTintList();
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.b.setIconTintList(colorStateList);
    }

    public void setItemIconSize(int i) {
        this.b.setItemIconSize(i);
    }

    public void setItemIconSizeRes(int i) {
        setItemIconSize(getResources().getDimensionPixelSize(i));
    }

    public int getItemIconSize() {
        return this.b.getItemIconSize();
    }

    public ColorStateList getItemTextColor() {
        return this.b.getItemTextColor();
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.b.setItemTextColor(colorStateList);
    }

    @Deprecated
    public int getItemBackgroundResource() {
        return this.b.getItemBackgroundRes();
    }

    public void setItemBackgroundResource(int i) {
        this.b.setItemBackgroundRes(i);
    }

    public Drawable getItemBackground() {
        return this.b.getItemBackground();
    }

    public void setItemBackground(Drawable drawable) {
        this.b.setItemBackground(drawable);
    }

    public int getSelectedItemId() {
        return this.b.getSelectedItemId();
    }

    public void setSelectedItemId(int i) {
        MenuItem findItem = this.f5241a.findItem(i);
        if (findItem == null || this.f5241a.a(findItem, this.c, 0)) {
            return;
        }
        findItem.setChecked(true);
    }

    public void setLabelVisibilityMode(int i) {
        if (this.b.getLabelVisibilityMode() != i) {
            this.b.setLabelVisibilityMode(i);
            this.c.a(false);
        }
    }

    public int getLabelVisibilityMode() {
        return this.b.getLabelVisibilityMode();
    }

    public void setItemTextAppearanceInactive(int i) {
        this.b.setItemTextAppearanceInactive(i);
    }

    public int getItemTextAppearanceInactive() {
        return this.b.getItemTextAppearanceInactive();
    }

    public void setItemTextAppearanceActive(int i) {
        this.b.setItemTextAppearanceActive(i);
    }

    public int getItemTextAppearanceActive() {
        return this.b.getItemTextAppearanceActive();
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        if (this.b.a() != z) {
            this.b.setItemHorizontalTranslationEnabled(z);
            this.c.a(false);
        }
    }

    private MenuInflater getMenuInflater() {
        if (this.d == null) {
            this.d = new androidx.appcompat.view.g(getContext());
        }
        return this.d;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f5242a = new Bundle();
        this.f5241a.a(savedState.f5242a);
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
        this.f5241a.b(savedState.f5242a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.bottomnavigation.BottomNavigationView.SavedState.1
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
        Bundle f5242a;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel, classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.f5242a);
        }

        private void a(Parcel parcel, ClassLoader classLoader) {
            this.f5242a = parcel.readBundle(classLoader);
        }
    }
}
