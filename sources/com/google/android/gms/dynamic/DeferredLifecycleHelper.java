package com.google.android.gms.dynamic;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ConnectionErrorMessages;
import com.google.android.gms.dynamic.LifecycleDelegate;
import java.util.LinkedList;

@KeepForSdk
/* loaded from: classes.dex */
public abstract class DeferredLifecycleHelper<T extends LifecycleDelegate> {

    /* renamed from: a, reason: collision with root package name */
    private T f1582a;
    private Bundle b;
    private LinkedList<a> c;
    private final OnDelegateCreatedListener<T> d = new com.google.android.gms.dynamic.a(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface a {
        int a();

        void a(LifecycleDelegate lifecycleDelegate);
    }

    @KeepForSdk
    public DeferredLifecycleHelper() {
    }

    @KeepForSdk
    protected abstract void a(OnDelegateCreatedListener<T> onDelegateCreatedListener);

    @KeepForSdk
    public T getDelegate() {
        return this.f1582a;
    }

    private final void a(int i) {
        while (!this.c.isEmpty() && this.c.getLast().a() >= i) {
            this.c.removeLast();
        }
    }

    private final void a(Bundle bundle, a aVar) {
        T t = this.f1582a;
        if (t != null) {
            aVar.a(t);
            return;
        }
        if (this.c == null) {
            this.c = new LinkedList<>();
        }
        this.c.add(aVar);
        if (bundle != null) {
            Bundle bundle2 = this.b;
            if (bundle2 == null) {
                this.b = (Bundle) bundle.clone();
            } else {
                bundle2.putAll(bundle);
            }
        }
        a(this.d);
    }

    @KeepForSdk
    public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
        a(bundle2, new b(this, activity, bundle, bundle2));
    }

    @KeepForSdk
    public void onCreate(Bundle bundle) {
        a(bundle, new c(this, bundle));
    }

    @KeepForSdk
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        a(bundle, new d(this, frameLayout, layoutInflater, viewGroup, bundle));
        if (this.f1582a == null) {
            a(frameLayout);
        }
        return frameLayout;
    }

    @KeepForSdk
    protected void a(FrameLayout frameLayout) {
        showGooglePlayUnavailableMessage(frameLayout);
    }

    @KeepForSdk
    public static void showGooglePlayUnavailableMessage(FrameLayout frameLayout) {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        Context context = frameLayout.getContext();
        int isGooglePlayServicesAvailable = googleApiAvailability.isGooglePlayServicesAvailable(context);
        String errorMessage = ConnectionErrorMessages.getErrorMessage(context, isGooglePlayServicesAvailable);
        String errorDialogButtonMessage = ConnectionErrorMessages.getErrorDialogButtonMessage(context, isGooglePlayServicesAvailable);
        LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        TextView textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        textView.setText(errorMessage);
        linearLayout.addView(textView);
        Intent errorResolutionIntent = googleApiAvailability.getErrorResolutionIntent(context, isGooglePlayServicesAvailable, null);
        if (errorResolutionIntent != null) {
            Button button = new Button(context);
            button.setId(R.id.button1);
            button.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            button.setText(errorDialogButtonMessage);
            linearLayout.addView(button);
            button.setOnClickListener(new e(context, errorResolutionIntent));
        }
    }

    @KeepForSdk
    public void onStart() {
        a((Bundle) null, new f(this));
    }

    @KeepForSdk
    public void onResume() {
        a((Bundle) null, new g(this));
    }

    @KeepForSdk
    public void onPause() {
        T t = this.f1582a;
        if (t != null) {
            t.onPause();
        } else {
            a(5);
        }
    }

    @KeepForSdk
    public void onStop() {
        T t = this.f1582a;
        if (t != null) {
            t.onStop();
        } else {
            a(4);
        }
    }

    @KeepForSdk
    public void onDestroyView() {
        T t = this.f1582a;
        if (t != null) {
            t.onDestroyView();
        } else {
            a(2);
        }
    }

    @KeepForSdk
    public void onDestroy() {
        T t = this.f1582a;
        if (t != null) {
            t.onDestroy();
        } else {
            a(1);
        }
    }

    @KeepForSdk
    public void onSaveInstanceState(Bundle bundle) {
        T t = this.f1582a;
        if (t != null) {
            t.onSaveInstanceState(bundle);
            return;
        }
        Bundle bundle2 = this.b;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
    }

    @KeepForSdk
    public void onLowMemory() {
        T t = this.f1582a;
        if (t != null) {
            t.onLowMemory();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Bundle a(DeferredLifecycleHelper deferredLifecycleHelper, Bundle bundle) {
        deferredLifecycleHelper.b = null;
        return null;
    }
}
