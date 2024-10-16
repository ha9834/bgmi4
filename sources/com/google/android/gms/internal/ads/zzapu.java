package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.amazonaws.http.HttpHeader;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.zzk;
import java.util.Map;

@zzard
/* loaded from: classes2.dex */
public final class zzapu extends zzaqb {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, String> f2778a;
    private final Context b;

    public zzapu(zzbgz zzbgzVar, Map<String, String> map) {
        super(zzbgzVar, "storePicture");
        this.f2778a = map;
        this.b = zzbgzVar.zzyd();
    }

    public final void execute() {
        if (this.b == null) {
            zzdh("Activity context is not available");
            return;
        }
        zzk.zzlg();
        if (!zzaxi.zzao(this.b).zzqk()) {
            zzdh("Feature is not supported by the device.");
            return;
        }
        String str = this.f2778a.get("iurl");
        if (TextUtils.isEmpty(str)) {
            zzdh("Image url cannot be empty.");
            return;
        }
        if (!URLUtil.isValidUrl(str)) {
            String valueOf = String.valueOf(str);
            zzdh(valueOf.length() != 0 ? "Invalid image url: ".concat(valueOf) : new String("Invalid image url: "));
            return;
        }
        String lastPathSegment = Uri.parse(str).getLastPathSegment();
        zzk.zzlg();
        if (!zzaxi.zzdz(lastPathSegment)) {
            String valueOf2 = String.valueOf(lastPathSegment);
            zzdh(valueOf2.length() != 0 ? "Image type not recognized: ".concat(valueOf2) : new String("Image type not recognized: "));
            return;
        }
        Resources resources = zzk.zzlk().getResources();
        zzk.zzlg();
        AlertDialog.Builder zzan = zzaxi.zzan(this.b);
        zzan.setTitle(resources != null ? resources.getString(R.string.s1) : "Save image");
        zzan.setMessage(resources != null ? resources.getString(R.string.s2) : "Allow Ad to store image in Picture gallery?");
        zzan.setPositiveButton(resources != null ? resources.getString(R.string.s3) : HttpHeader.ACCEPT, new dt(this, str, lastPathSegment));
        zzan.setNegativeButton(resources != null ? resources.getString(R.string.s4) : "Decline", new du(this));
        zzan.create().show();
    }
}
