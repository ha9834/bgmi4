package com.vk.api.sdk;

import android.content.Context;
import com.tencent.open.SocialConstants;
import com.vk.api.sdk.exceptions.VKApiExecutionException;
import com.vk.api.sdk.k;
import com.vk.api.sdk.ui.VKCaptchaActivity;
import com.vk.api.sdk.ui.VKConfirmationActivity;
import com.vk.api.sdk.ui.VKWebViewAuthActivity;

/* loaded from: classes3.dex */
public class l implements k {

    /* renamed from: a, reason: collision with root package name */
    private final Context f6888a;

    public l(Context context) {
        kotlin.jvm.internal.h.b(context, "context");
        this.f6888a = context;
    }

    @Override // com.vk.api.sdk.k
    public void a(VKApiExecutionException vKApiExecutionException, h hVar) throws VKApiExecutionException {
        k.c.a(this, vKApiExecutionException, hVar);
    }

    @Override // com.vk.api.sdk.k
    public void a(String str, k.a<String> aVar) {
        kotlin.jvm.internal.h.b(str, SocialConstants.PARAM_IMG_URL);
        kotlin.jvm.internal.h.b(aVar, "cb");
        VKCaptchaActivity.f6910a.a(this.f6888a, str);
        com.vk.api.sdk.utils.m.f6932a.a();
        a(aVar);
    }

    private final void a(k.a<String> aVar) {
        if (VKCaptchaActivity.f6910a.a() != null) {
            String a2 = VKCaptchaActivity.f6910a.a();
            kotlin.jvm.internal.h.a((Object) a2);
            aVar.a(a2);
            return;
        }
        aVar.b();
    }

    @Override // com.vk.api.sdk.k
    public void c(String str, k.a<Boolean> aVar) {
        kotlin.jvm.internal.h.b(str, "confirmationText");
        kotlin.jvm.internal.h.b(aVar, "cb");
        VKConfirmationActivity.f6911a.a(false);
        VKConfirmationActivity.f6911a.a(this.f6888a, str);
        com.vk.api.sdk.utils.m.f6932a.a();
        aVar.a(Boolean.valueOf(VKConfirmationActivity.f6911a.a()));
        VKConfirmationActivity.f6911a.a(false);
    }

    @Override // com.vk.api.sdk.k
    public void b(String str, k.a<k.b> aVar) {
        kotlin.k kVar;
        kotlin.jvm.internal.h.b(str, "validationUrl");
        kotlin.jvm.internal.h.b(aVar, "cb");
        VKWebViewAuthActivity.f6912a.a(null);
        VKWebViewAuthActivity.f6912a.a(this.f6888a, str);
        com.vk.api.sdk.utils.m.f6932a.a();
        k.b a2 = VKWebViewAuthActivity.f6912a.a();
        if (a2 == null) {
            kVar = null;
        } else {
            aVar.a(a2);
            kVar = kotlin.k.f6974a;
        }
        if (kVar == null) {
            aVar.b();
        }
        VKWebViewAuthActivity.f6912a.a(null);
    }
}
