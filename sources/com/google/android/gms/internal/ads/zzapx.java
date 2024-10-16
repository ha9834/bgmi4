package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

@zzard
/* loaded from: classes2.dex */
public final class zzapx {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f2779a;
    private final boolean b;
    private final boolean c;
    private final boolean d;
    private final boolean e;

    private zzapx(zzapz zzapzVar) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        z = zzapzVar.f2780a;
        this.f2779a = z;
        z2 = zzapzVar.b;
        this.b = z2;
        z3 = zzapzVar.c;
        this.c = z3;
        z4 = zzapzVar.d;
        this.d = z4;
        z5 = zzapzVar.e;
        this.e = z5;
    }

    public final JSONObject toJson() {
        try {
            return new JSONObject().put("sms", this.f2779a).put("tel", this.b).put("calendar", this.c).put("storePicture", this.d).put("inlineVideo", this.e);
        } catch (JSONException e) {
            zzawz.zzc("Error occured while obtaining the MRAID capabilities.", e);
            return null;
        }
    }
}
