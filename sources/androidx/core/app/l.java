package androidx.core.app;

import android.app.RemoteInput;
import android.os.Build;
import android.os.Bundle;
import java.util.Set;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    private final String f478a;
    private final CharSequence b;
    private final CharSequence[] c;
    private final boolean d;
    private final int e;
    private final Bundle f;
    private final Set<String> g;

    public String a() {
        return this.f478a;
    }

    public CharSequence b() {
        return this.b;
    }

    public CharSequence[] c() {
        return this.c;
    }

    public Set<String> d() {
        return this.g;
    }

    public boolean e() {
        return this.d;
    }

    public int f() {
        return this.e;
    }

    public Bundle g() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RemoteInput[] a(l[] lVarArr) {
        if (lVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[lVarArr.length];
        for (int i = 0; i < lVarArr.length; i++) {
            remoteInputArr[i] = a(lVarArr[i]);
        }
        return remoteInputArr;
    }

    static RemoteInput a(l lVar) {
        RemoteInput.Builder addExtras = new RemoteInput.Builder(lVar.a()).setLabel(lVar.b()).setChoices(lVar.c()).setAllowFreeFormInput(lVar.e()).addExtras(lVar.g());
        if (Build.VERSION.SDK_INT >= 29) {
            addExtras.setEditChoicesBeforeSending(lVar.f());
        }
        return addExtras.build();
    }
}
