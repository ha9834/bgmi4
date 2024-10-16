package com.vk.api.sdk.auth;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.ab;
import kotlin.collections.j;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final a f6860a = new a(null);
    private final int b;
    private final String c;
    private final Set<VKScope> d;

    public d(int i, String str, Collection<? extends VKScope> collection) {
        h.b(str, "redirectUrl");
        h.b(collection, "scope");
        this.b = i;
        this.c = str;
        if (this.b == 0) {
            throw new IllegalStateException("AppId is empty! Find out how to get your appId at https://vk.com/dev/access_token");
        }
        this.d = new HashSet(collection);
    }

    public /* synthetic */ d(int i, String str, Set set, int i2, f fVar) {
        this(i, (i2 & 2) != 0 ? "https://oauth.vk.com/blank.html" : str, (i2 & 4) != 0 ? ab.a() : set);
    }

    public final int a() {
        return this.b;
    }

    public final String b() {
        return this.c;
    }

    public final Bundle c() {
        Bundle bundle = new Bundle();
        bundle.putInt("vk_app_id", this.b);
        Set<VKScope> set = this.d;
        ArrayList arrayList = new ArrayList(j.a(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(((VKScope) it.next()).name());
        }
        bundle.putStringArrayList("vk_app_scope", new ArrayList<>(arrayList));
        bundle.putString("vk_app_redirect_url", this.c);
        return bundle;
    }

    public final Bundle d() {
        Bundle bundle = new Bundle();
        bundle.putInt("client_id", this.b);
        bundle.putBoolean("revoke", true);
        bundle.putString("scope", j.a(this.d, ",", null, null, 0, null, null, 62, null));
        bundle.putString("redirect_url", this.c);
        return bundle;
    }

    public final String e() {
        return j.a(this.d, ",", null, null, 0, null, null, 62, null);
    }

    /* loaded from: classes3.dex */
    public static final class a {
        public /* synthetic */ a(f fVar) {
            this();
        }

        private a() {
        }

        public final d a(Bundle bundle) {
            ArrayList arrayList = null;
            if (bundle == null) {
                return null;
            }
            int i = bundle.getInt("vk_app_id");
            ArrayList<String> stringArrayList = bundle.getStringArrayList("vk_app_scope");
            if (stringArrayList != null) {
                ArrayList<String> arrayList2 = stringArrayList;
                ArrayList arrayList3 = new ArrayList(j.a(arrayList2, 10));
                for (String str : arrayList2) {
                    h.a((Object) str, "it");
                    arrayList3.add(VKScope.valueOf(str));
                }
                arrayList = arrayList3;
            }
            if (arrayList == null) {
                arrayList = ab.a();
            }
            String string = bundle.getString("vk_app_redirect_url", "https://oauth.vk.com/blank.html");
            h.a((Object) string, "redirectUrl");
            return new d(i, string, arrayList);
        }
    }
}
