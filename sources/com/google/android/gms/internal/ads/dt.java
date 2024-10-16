package com.google.android.gms.internal.ads;

import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Environment;
import com.google.android.gms.ads.internal.zzk;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class dt implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f2132a;
    private final /* synthetic */ String b;
    private final /* synthetic */ zzapu c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dt(zzapu zzapuVar, String str, String str2) {
        this.c = zzapuVar;
        this.f2132a = str;
        this.b = str2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        Context context;
        context = this.c.b;
        DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
        try {
            String str = this.f2132a;
            String str2 = this.b;
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
            zzk.zzli();
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
            downloadManager.enqueue(request);
        } catch (IllegalStateException unused) {
            this.c.zzdh("Could not store picture.");
        }
    }
}
