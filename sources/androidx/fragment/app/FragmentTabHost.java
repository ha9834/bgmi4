package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.TabHost;
import java.util.ArrayList;

@Deprecated
/* loaded from: classes.dex */
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<a> f629a;
    private Context b;
    private FragmentManager c;
    private int d;
    private TabHost.OnTabChangeListener e;
    private a f;
    private boolean g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        final String f631a;
        final Class<?> b;
        final Bundle c;
        Fragment d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.fragment.app.FragmentTabHost.SavedState.1
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
        String f630a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f630a = parcel.readString();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f630a);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.f630a + "}";
        }
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setOnTabChangedListener(TabHost.OnTabChangeListener onTabChangeListener) {
        this.e = onTabChangeListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        int size = this.f629a.size();
        s sVar = null;
        for (int i = 0; i < size; i++) {
            a aVar = this.f629a.get(i);
            aVar.d = this.c.b(aVar.f631a);
            if (aVar.d != null && !aVar.d.isDetached()) {
                if (aVar.f631a.equals(currentTabTag)) {
                    this.f = aVar;
                } else {
                    if (sVar == null) {
                        sVar = this.c.a();
                    }
                    sVar.b(aVar.d);
                }
            }
        }
        this.g = true;
        s a2 = a(currentTabTag, sVar);
        if (a2 != null) {
            a2.b();
            this.c.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.g = false;
    }

    @Override // android.view.View
    @Deprecated
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f630a = getCurrentTabTag();
        return savedState;
    }

    @Override // android.view.View
    @Deprecated
    protected void onRestoreInstanceState(@SuppressLint({"UnknownNullness"}) Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.f630a);
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    @Deprecated
    public void onTabChanged(String str) {
        s a2;
        if (this.g && (a2 = a(str, null)) != null) {
            a2.b();
        }
        TabHost.OnTabChangeListener onTabChangeListener = this.e;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
    }

    private s a(String str, s sVar) {
        a a2 = a(str);
        if (this.f != a2) {
            if (sVar == null) {
                sVar = this.c.a();
            }
            a aVar = this.f;
            if (aVar != null && aVar.d != null) {
                sVar.b(this.f.d);
            }
            if (a2 != null) {
                if (a2.d == null) {
                    a2.d = this.c.E().c(this.b.getClassLoader(), a2.b.getName());
                    a2.d.setArguments(a2.c);
                    sVar.a(this.d, a2.d, a2.f631a);
                } else {
                    sVar.c(a2.d);
                }
            }
            this.f = a2;
        }
        return sVar;
    }

    private a a(String str) {
        int size = this.f629a.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.f629a.get(i);
            if (aVar.f631a.equals(str)) {
                return aVar;
            }
        }
        return null;
    }
}
