package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public abstract class i<E> extends e {

    /* renamed from: a, reason: collision with root package name */
    private final Activity f670a;
    final FragmentManager b;
    private final Context c;
    private final Handler d;
    private final int e;

    @Override // androidx.fragment.app.e
    public View a(int i) {
        return null;
    }

    @Deprecated
    public void a(Fragment fragment, String[] strArr, int i) {
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @Override // androidx.fragment.app.e
    public boolean a() {
        return true;
    }

    public boolean a(Fragment fragment) {
        return true;
    }

    public boolean a(String str) {
        return false;
    }

    public void d() {
    }

    public abstract E e();

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, new Handler(), 0);
    }

    i(Activity activity, Context context, Handler handler, int i) {
        this.b = new l();
        this.f670a = activity;
        this.c = (Context) androidx.core.e.e.a(context, "context == null");
        this.d = (Handler) androidx.core.e.e.a(handler, "handler == null");
        this.e = i;
    }

    public LayoutInflater b() {
        return LayoutInflater.from(this.c);
    }

    public void a(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        if (i != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        androidx.core.content.a.a(this.c, intent, bundle);
    }

    @Deprecated
    public void a(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (i != -1) {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
        androidx.core.app.a.a(this.f670a, intentSender, i, intent, i2, i3, i4, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Activity f() {
        return this.f670a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context g() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Handler h() {
        return this.d;
    }
}
