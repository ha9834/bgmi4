package com.google.android.gms.internal.ads;

import android.util.JsonWriter;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.tagmanager.DataLayer;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzcfn {

    /* renamed from: a, reason: collision with root package name */
    private final Clock f3233a;

    public zzcfn(Clock clock) {
        this.f3233a = clock;
    }

    public final void zza(List<Object> list, String str, String str2, Object... objArr) {
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcqg)).booleanValue()) {
            long currentTimeMillis = this.f3233a.currentTimeMillis();
            StringWriter stringWriter = new StringWriter();
            JsonWriter jsonWriter = new JsonWriter(stringWriter);
            try {
                jsonWriter.beginObject();
                jsonWriter.name("timestamp").value(currentTimeMillis);
                jsonWriter.name("source").value(str);
                jsonWriter.name(DataLayer.EVENT_KEY).value(str2);
                jsonWriter.name("components").beginArray();
                Iterator<Object> it = list.iterator();
                while (it.hasNext()) {
                    jsonWriter.value(it.next().toString());
                }
                jsonWriter.endArray();
                jsonWriter.name(NativeProtocol.WEB_DIALOG_PARAMS).beginArray();
                int length = objArr.length;
                for (int i = 0; i < length; i++) {
                    Object obj = objArr[i];
                    jsonWriter.value(obj != null ? obj.toString() : null);
                }
                jsonWriter.endArray();
                jsonWriter.endObject();
                jsonWriter.flush();
                jsonWriter.close();
            } catch (IOException e) {
                zzawz.zzc("unable to log", e);
            }
            String valueOf = String.valueOf(stringWriter.toString());
            zzawz.zzeo(valueOf.length() != 0 ? "AD-DBG ".concat(valueOf) : new String("AD-DBG "));
        }
    }
}
