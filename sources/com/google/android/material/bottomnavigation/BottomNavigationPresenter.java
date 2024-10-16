package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.r;

/* loaded from: classes2.dex */
public class BottomNavigationPresenter implements m {

    /* renamed from: a, reason: collision with root package name */
    private g f5239a;
    private b b;
    private boolean c;
    private int d;

    @Override // androidx.appcompat.view.menu.m
    public void a(g gVar, boolean z) {
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(m.a aVar) {
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean a(g gVar, i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean a(r rVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean b() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean b(g gVar, i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(Context context, g gVar) {
        this.f5239a = gVar;
        this.b.a(this.f5239a);
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(boolean z) {
        if (this.c) {
            return;
        }
        if (z) {
            this.b.b();
        } else {
            this.b.c();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public int c() {
        return this.d;
    }

    @Override // androidx.appcompat.view.menu.m
    public Parcelable f() {
        SavedState savedState = new SavedState();
        savedState.f5240a = this.b.getSelectedItemId();
        return savedState;
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.b.a(((SavedState) parcelable).f5240a);
        }
    }

    public void b(boolean z) {
        this.c = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.google.android.material.bottomnavigation.BottomNavigationPresenter.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a, reason: collision with root package name */
        int f5240a;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f5240a = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f5240a);
        }
    }
}
