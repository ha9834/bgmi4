package com.google.android.gms.dynamic;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.IFragmentWrapper;

@KeepForSdk
@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public final class FragmentWrapper extends IFragmentWrapper.Stub {

    /* renamed from: a, reason: collision with root package name */
    private Fragment f1583a;

    @KeepForSdk
    public static FragmentWrapper wrap(Fragment fragment) {
        if (fragment != null) {
            return new FragmentWrapper(fragment);
        }
        return null;
    }

    private FragmentWrapper(Fragment fragment) {
        this.f1583a = fragment;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IObjectWrapper zzae() {
        return ObjectWrapper.wrap(this.f1583a.getActivity());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final Bundle getArguments() {
        return this.f1583a.getArguments();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final int getId() {
        return this.f1583a.getId();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IFragmentWrapper zzaf() {
        return wrap(this.f1583a.getParentFragment());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IObjectWrapper zzag() {
        return ObjectWrapper.wrap(this.f1583a.getResources());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean getRetainInstance() {
        return this.f1583a.getRetainInstance();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final String getTag() {
        return this.f1583a.getTag();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IFragmentWrapper zzah() {
        return wrap(this.f1583a.getTargetFragment());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final int getTargetRequestCode() {
        return this.f1583a.getTargetRequestCode();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean getUserVisibleHint() {
        return this.f1583a.getUserVisibleHint();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IObjectWrapper zzai() {
        return ObjectWrapper.wrap(this.f1583a.getView());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean isAdded() {
        return this.f1583a.isAdded();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean isDetached() {
        return this.f1583a.isDetached();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean isHidden() {
        return this.f1583a.isHidden();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean isInLayout() {
        return this.f1583a.isInLayout();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean isRemoving() {
        return this.f1583a.isRemoving();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean isResumed() {
        return this.f1583a.isResumed();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean isVisible() {
        return this.f1583a.isVisible();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zza(IObjectWrapper iObjectWrapper) {
        this.f1583a.registerForContextMenu((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void setHasOptionsMenu(boolean z) {
        this.f1583a.setHasOptionsMenu(z);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void setMenuVisibility(boolean z) {
        this.f1583a.setMenuVisibility(z);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void setRetainInstance(boolean z) {
        this.f1583a.setRetainInstance(z);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void setUserVisibleHint(boolean z) {
        this.f1583a.setUserVisibleHint(z);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void startActivity(Intent intent) {
        this.f1583a.startActivity(intent);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void startActivityForResult(Intent intent, int i) {
        this.f1583a.startActivityForResult(intent, i);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzb(IObjectWrapper iObjectWrapper) {
        this.f1583a.unregisterForContextMenu((View) ObjectWrapper.unwrap(iObjectWrapper));
    }
}
