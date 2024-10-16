package androidx.legacy.app;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
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
    private final ArrayList<a> f759a;
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
        final String f761a;
        final Class<?> b;
        final Bundle c;
        Fragment d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.legacy.app.FragmentTabHost.SavedState.1
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
        String f760a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f760a = parcel.readString();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f760a);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.f760a + "}";
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
        FragmentTransaction fragmentTransaction = null;
        for (int i = 0; i < this.f759a.size(); i++) {
            a aVar = this.f759a.get(i);
            aVar.d = this.c.findFragmentByTag(aVar.f761a);
            if (aVar.d != null && !aVar.d.isDetached()) {
                if (aVar.f761a.equals(currentTabTag)) {
                    this.f = aVar;
                } else {
                    if (fragmentTransaction == null) {
                        fragmentTransaction = this.c.beginTransaction();
                    }
                    fragmentTransaction.detach(aVar.d);
                }
            }
        }
        this.g = true;
        FragmentTransaction a2 = a(currentTabTag, fragmentTransaction);
        if (a2 != null) {
            a2.commit();
            this.c.executePendingTransactions();
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
        savedState.f760a = getCurrentTabTag();
        return savedState;
    }

    @Override // android.view.View
    @Deprecated
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.f760a);
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    @Deprecated
    public void onTabChanged(String str) {
        FragmentTransaction a2;
        if (this.g && (a2 = a(str, null)) != null) {
            a2.commit();
        }
        TabHost.OnTabChangeListener onTabChangeListener = this.e;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private FragmentTransaction a(String str, FragmentTransaction fragmentTransaction) {
        a aVar = null;
        for (int i = 0; i < this.f759a.size(); i++) {
            a aVar2 = this.f759a.get(i);
            if (aVar2.f761a.equals(str)) {
                aVar = aVar2;
            }
        }
        if (aVar == null) {
            throw new IllegalStateException("No tab known for tag " + str);
        }
        if (this.f != aVar) {
            if (fragmentTransaction == null) {
                fragmentTransaction = this.c.beginTransaction();
            }
            a aVar3 = this.f;
            if (aVar3 != null && aVar3.d != null) {
                fragmentTransaction.detach(this.f.d);
            }
            if (aVar != null) {
                if (aVar.d == null) {
                    aVar.d = Fragment.instantiate(this.b, aVar.b.getName(), aVar.c);
                    fragmentTransaction.add(this.d, aVar.d, aVar.f761a);
                } else {
                    fragmentTransaction.attach(aVar.d);
                }
            }
            this.f = aVar;
        }
        return fragmentTransaction;
    }
}
