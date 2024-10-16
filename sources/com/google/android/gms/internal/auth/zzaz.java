package com.google.android.gms.internal.auth;

import android.util.Log;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import java.io.UnsupportedEncodingException;

/* loaded from: classes2.dex */
public abstract class zzaz extends FastSafeParcelableJsonResponse {

    /* renamed from: a, reason: collision with root package name */
    private static String f3834a = "AUTH";

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
    public byte[] toByteArray() {
        try {
            return toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            Log.e(f3834a, "Error serializing object.", e);
            return null;
        }
    }
}
