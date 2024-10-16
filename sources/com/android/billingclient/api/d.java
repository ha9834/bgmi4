package com.android.billingclient.api;

import android.app.Activity;
import android.content.Context;
import com.android.billingclient.api.l;

/* loaded from: classes.dex */
public abstract class d {

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f969a;
        private final Context b;
        private o c;

        /* synthetic */ a(Context context, ao aoVar) {
            this.b = context;
        }

        public a a() {
            this.f969a = true;
            return this;
        }

        public a a(o oVar) {
            this.c = oVar;
            return this;
        }

        public d b() {
            Context context = this.b;
            if (context != null) {
                o oVar = this.c;
                if (oVar != null) {
                    if (!this.f969a) {
                        throw new IllegalArgumentException("Support for pending purchases must be enabled. Enable this by calling 'enablePendingPurchases()' on BillingClientBuilder.");
                    }
                    return new e(null, true, context, oVar);
                }
                throw new IllegalArgumentException("Please provide a valid listener for purchases updates.");
            }
            throw new IllegalArgumentException("Please provide a valid Context.");
        }
    }

    public static a a(Context context) {
        return new a(context, null);
    }

    public abstract h a(Activity activity, g gVar);

    public abstract h a(String str);

    public abstract void a(b bVar, c cVar);

    public abstract void a(f fVar);

    public abstract void a(i iVar, j jVar);

    public abstract void a(q qVar, r rVar);

    public abstract void a(String str, n nVar);

    public abstract boolean a();

    public abstract l.a b(String str);

    public abstract void b();
}
