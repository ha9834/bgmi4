package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.IFragmentWrapper;

@KeepForSdk
/* loaded from: classes.dex */
public final class SupportFragmentWrapper extends IFragmentWrapper.Stub {

    /* renamed from: a, reason: collision with root package name */
    private Fragment f1586a;

    @KeepForSdk
    public static SupportFragmentWrapper wrap(Fragment fragment) {
        if (fragment != null) {
            return new SupportFragmentWrapper(fragment);
        }
        return null;
    }

    private SupportFragmentWrapper(Fragment fragment) {
        this.f1586a = fragment;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IObjectWrapper zzae() {
        return ObjectWrapper.wrap(this.f1586a.getActivity());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final Bundle getArguments() {
        return this.f1586a.getArguments();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final int getId() {
        return this.f1586a.getId();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IFragmentWrapper zzaf() {
        return wrap(this.f1586a.getParentFragment());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IObjectWrapper zzag() {
        return ObjectWrapper.wrap(this.f1586a.getResources());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean getRetainInstance() {
        return this.f1586a.getRetainInstance();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final String getTag() {
        return this.f1586a.getTag();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IFragmentWrapper zzah() {
        return wrap(this.f1586a.getTargetFragment());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final int getTargetRequestCode() {
        return this.f1586a.getTargetRequestCode();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean getUserVisibleHint() {
        return this.f1586a.getUserVisibleHint();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IObjectWrapper zzai() {
        return ObjectWrapper.wrap(this.f1586a.getView());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean isAdded() {
        return this.f1586a.isAdded();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean isDetached() {
        return this.f1586a.isDetached();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean isHidden() {
        return this.f1586a.isHidden();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean isInLayout() {
        return this.f1586a.isInLayout();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean isRemoving() {
        return this.f1586a.isRemoving();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean isResumed() {
        return this.f1586a.isResumed();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean isVisible() {
        return this.f1586a.isVisible();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zza(IObjectWrapper iObjectWrapper) {
        this.f1586a.registerForContextMenu((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void setHasOptionsMenu(boolean z) {
        this.f1586a.setHasOptionsMenu(z);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void setMenuVisibility(boolean z) {
        this.f1586a.setMenuVisibility(z);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void setRetainInstance(boolean z) {
        this.f1586a.setRetainInstance(z);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void setUserVisibleHint(boolean z) {
        this.f1586a.setUserVisibleHint(z);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void startActivity(Intent intent) {
        this.f1586a.startActivity(intent);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void startActivityForResult(Intent intent, int i) {
        this.f1586a.startActivityForResult(intent, i);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzb(IObjectWrapper iObjectWrapper) {
        this.f1586a.unregisterForContextMenu((View) ObjectWrapper.unwrap(iObjectWrapper));
    }
}
