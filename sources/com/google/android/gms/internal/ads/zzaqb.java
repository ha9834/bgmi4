package com.google.android.gms.internal.ads;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
/* loaded from: classes2.dex */
public class zzaqb {

    /* renamed from: a, reason: collision with root package name */
    private final zzbgz f2782a;
    private final String b;

    public zzaqb(zzbgz zzbgzVar) {
        this(zzbgzVar, "");
    }

    public zzaqb(zzbgz zzbgzVar, String str) {
        this.f2782a = zzbgzVar;
        this.b = str;
    }

    public final void zzdh(String str) {
        try {
            JSONObject put = new JSONObject().put("message", str).put("action", this.b);
            if (this.f2782a != null) {
                this.f2782a.zza("onError", put);
            }
        } catch (JSONException e) {
            zzawz.zzc("Error occurred while dispatching error event.", e);
        }
    }

    public final void zzdi(String str) {
        try {
            this.f2782a.zza("onReadyEventReceived", new JSONObject().put("js", str));
        } catch (JSONException e) {
            zzawz.zzc("Error occured while dispatching ready Event.", e);
        }
    }

    public final void zza(int i, int i2, int i3, int i4) {
        try {
            this.f2782a.zza("onSizeChanged", new JSONObject().put("x", i).put("y", i2).put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, i3).put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, i4));
        } catch (JSONException e) {
            zzawz.zzc("Error occured while dispatching size change.", e);
        }
    }

    public final void zzb(int i, int i2, int i3, int i4) {
        try {
            this.f2782a.zza("onDefaultPositionReceived", new JSONObject().put("x", i).put("y", i2).put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, i3).put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, i4));
        } catch (JSONException e) {
            zzawz.zzc("Error occured while dispatching default position.", e);
        }
    }

    public final void zzdj(String str) {
        try {
            this.f2782a.zza("onStateChanged", new JSONObject().put("state", str));
        } catch (JSONException e) {
            zzawz.zzc("Error occured while dispatching state change.", e);
        }
    }

    public final void zza(int i, int i2, int i3, int i4, float f, int i5) {
        try {
            this.f2782a.zza("onScreenInfoChanged", new JSONObject().put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, i).put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, i2).put("maxSizeWidth", i3).put("maxSizeHeight", i4).put("density", f).put("rotation", i5));
        } catch (JSONException e) {
            zzawz.zzc("Error occured while obtaining screen information.", e);
        }
    }
}
