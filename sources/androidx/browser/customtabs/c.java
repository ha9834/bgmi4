package androidx.browser.customtabs;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final Intent f400a;
    public final Bundle b;

    public void a(Context context, Uri uri) {
        this.f400a.setData(uri);
        androidx.core.content.a.a(context, this.f400a, this.b);
    }

    c(Intent intent, Bundle bundle) {
        this.f400a = intent;
        this.b = bundle;
    }

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Intent f401a;
        private ArrayList<Bundle> b;
        private Bundle c;
        private ArrayList<Bundle> d;
        private boolean e;

        public a() {
            this(null);
        }

        public a(e eVar) {
            this.f401a = new Intent("android.intent.action.VIEW");
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = true;
            if (eVar != null) {
                this.f401a.setPackage(eVar.b().getPackageName());
            }
            Bundle bundle = new Bundle();
            androidx.core.app.e.a(bundle, "android.support.customtabs.extra.SESSION", eVar != null ? eVar.a() : null);
            this.f401a.putExtras(bundle);
        }

        public c a() {
            ArrayList<Bundle> arrayList = this.b;
            if (arrayList != null) {
                this.f401a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList);
            }
            ArrayList<Bundle> arrayList2 = this.d;
            if (arrayList2 != null) {
                this.f401a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", arrayList2);
            }
            this.f401a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.e);
            return new c(this.f401a, this.c);
        }
    }
}
