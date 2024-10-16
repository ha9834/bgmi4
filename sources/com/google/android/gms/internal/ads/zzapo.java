package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.amazonaws.http.HttpHeader;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.drive.DriveFile;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;

@zzard
/* loaded from: classes2.dex */
public final class zzapo extends zzaqb {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, String> f2775a;
    private final Context b;
    private String c;
    private long d;
    private long e;
    private String f;
    private String g;

    public zzapo(zzbgz zzbgzVar, Map<String, String> map) {
        super(zzbgzVar, "createCalendarEvent");
        this.f2775a = map;
        this.b = zzbgzVar.zzyd();
        this.c = a("description");
        this.f = a("summary");
        this.d = b("start_ticks");
        this.e = b("end_ticks");
        this.g = a(FirebaseAnalytics.Param.LOCATION);
    }

    private final String a(String str) {
        return TextUtils.isEmpty(this.f2775a.get(str)) ? "" : this.f2775a.get(str);
    }

    private final long b(String str) {
        String str2 = this.f2775a.get(str);
        if (str2 == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public final void execute() {
        if (this.b == null) {
            zzdh("Activity context is not available.");
            return;
        }
        zzk.zzlg();
        if (!zzaxi.zzao(this.b).zzql()) {
            zzdh("This feature is not available on the device.");
            return;
        }
        zzk.zzlg();
        AlertDialog.Builder zzan = zzaxi.zzan(this.b);
        Resources resources = zzk.zzlk().getResources();
        zzan.setTitle(resources != null ? resources.getString(R.string.s5) : "Create calendar event");
        zzan.setMessage(resources != null ? resources.getString(R.string.s6) : "Allow Ad to create a calendar event?");
        zzan.setPositiveButton(resources != null ? resources.getString(R.string.s3) : HttpHeader.ACCEPT, new dq(this));
        zzan.setNegativeButton(resources != null ? resources.getString(R.string.s4) : "Decline", new dr(this));
        zzan.create().show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(14)
    public final Intent a() {
        Intent data = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        data.putExtra("title", this.c);
        data.putExtra("eventLocation", this.g);
        data.putExtra("description", this.f);
        long j = this.d;
        if (j > -1) {
            data.putExtra("beginTime", j);
        }
        long j2 = this.e;
        if (j2 > -1) {
            data.putExtra("endTime", j2);
        }
        data.setFlags(DriveFile.MODE_READ_ONLY);
        return data;
    }
}
