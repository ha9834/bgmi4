package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements LayoutInflater.Factory2 {

    /* renamed from: a, reason: collision with root package name */
    final FragmentManager f671a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FragmentManager fragmentManager) {
        this.f671a = fragmentManager;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        final p i;
        if (f.class.getName().equals(str)) {
            return new f(context, attributeSet, this.f671a);
        }
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.c.Fragment);
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(a.c.Fragment_android_name);
        }
        int resourceId = obtainStyledAttributes.getResourceId(a.c.Fragment_android_id, -1);
        String string = obtainStyledAttributes.getString(a.c.Fragment_android_tag);
        obtainStyledAttributes.recycle();
        if (attributeValue == null || !h.a(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        Fragment d = resourceId != -1 ? this.f671a.d(resourceId) : null;
        if (d == null && string != null) {
            d = this.f671a.b(string);
        }
        if (d == null && id != -1) {
            d = this.f671a.d(id);
        }
        if (d == null) {
            d = this.f671a.E().c(context.getClassLoader(), attributeValue);
            d.mFromLayout = true;
            d.mFragmentId = resourceId != 0 ? resourceId : id;
            d.mContainerId = id;
            d.mTag = string;
            d.mInLayout = true;
            FragmentManager fragmentManager = this.f671a;
            d.mFragmentManager = fragmentManager;
            d.mHost = fragmentManager.m();
            d.onInflate(this.f671a.m().g(), attributeSet, d.mSavedFragmentState);
            i = this.f671a.j(d);
            if (FragmentManager.a(2)) {
                Log.v("FragmentManager", "Fragment " + d + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        } else {
            if (d.mInLayout) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
            }
            d.mInLayout = true;
            FragmentManager fragmentManager2 = this.f671a;
            d.mFragmentManager = fragmentManager2;
            d.mHost = fragmentManager2.m();
            d.onInflate(this.f671a.m().g(), attributeSet, d.mSavedFragmentState);
            i = this.f671a.i(d);
            if (FragmentManager.a(2)) {
                Log.v("FragmentManager", "Retained Fragment " + d + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        }
        d.mContainer = (ViewGroup) view;
        i.c();
        i.d();
        if (d.mView == null) {
            throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
        }
        if (resourceId != 0) {
            d.mView.setId(resourceId);
        }
        if (d.mView.getTag() == null) {
            d.mView.setTag(string);
        }
        d.mView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.fragment.app.j.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                Fragment a2 = i.a();
                i.c();
                SpecialEffectsController.a((ViewGroup) a2.mView.getParent(), j.this.f671a).e();
            }
        });
        return d.mView;
    }
}
