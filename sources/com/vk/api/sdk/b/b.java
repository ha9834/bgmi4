package com.vk.api.sdk.b;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.helpshift.analytics.AnalyticsEventKey;
import com.tencent.imsdk.android.base.config.ConfigDBHelper;
import com.vk.api.sdk.e;
import com.vk.api.sdk.exceptions.VKApiException;
import com.vk.api.sdk.exceptions.VKApiExecutionException;
import com.vk.api.sdk.i;
import com.vk.api.sdk.n;
import java.io.IOException;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class b<T> extends com.vk.api.sdk.internal.a<T> implements i<T> {

    /* renamed from: a, reason: collision with root package name */
    public static final a f6863a = new a(null);
    private String b;
    private final String c;
    private volatile boolean d;
    private volatile boolean e;
    private final LinkedHashMap<String, String> f;

    /* JADX WARN: Multi-variable type inference failed */
    public T b(JSONObject jSONObject) throws Exception {
        h.b(jSONObject, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
        return jSONObject;
    }

    public b(String str, String str2) {
        h.b(str, FirebaseAnalytics.Param.METHOD);
        this.b = str;
        this.c = str2;
        this.f = new LinkedHashMap<>();
    }

    public /* synthetic */ b(String str, String str2, int i, f fVar) {
        this(str, (i & 2) != 0 ? null : str2);
    }

    public final LinkedHashMap<String, String> a() {
        return this.f;
    }

    @Override // com.vk.api.sdk.i
    public T a(String str) throws VKApiException {
        h.b(str, AnalyticsEventKey.RESPONSE);
        try {
            return b(new JSONObject(str));
        } catch (Throwable th) {
            throw new VKApiExecutionException(-2, this.b, true, '[' + this.b + "] " + ((Object) th.getLocalizedMessage()), null, null, null, null, 0, 496, null);
        }
    }

    @Override // com.vk.api.sdk.internal.a
    protected T b(com.vk.api.sdk.h hVar) throws InterruptedException, IOException, VKApiException {
        h.b(hVar, "manager");
        e a2 = hVar.a();
        String str = this.c;
        if (str == null) {
            str = a2.e();
        }
        this.f.put("lang", a2.r());
        this.f.put("device_id", a2.d().a());
        String a3 = a2.p().a();
        if (a3 != null) {
            a().put("external_device_id", a3);
        }
        this.f.put("v", str);
        return (T) hVar.a(a(a2).a(this.f).a(this.b).b(str).b(this.e).a(this.d).k(), this);
    }

    protected n.a a(e eVar) {
        h.b(eVar, ConfigDBHelper.TABLE_NAME_CONFIG);
        return new n.a();
    }

    /* loaded from: classes3.dex */
    public static final class a {
        public /* synthetic */ a(f fVar) {
            this();
        }

        private a() {
        }
    }
}
