package com.tencent.smtt.sdk;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import com.google.android.gms.drive.DriveFile;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class a implements com.tencent.smtt.export.external.interfaces.DownloadListener {

    /* renamed from: a, reason: collision with root package name */
    private DownloadListener f6501a;
    private WebView b;

    @Override // com.tencent.smtt.export.external.interfaces.DownloadListener
    public void onDownloadVideo(String str, long j, int i) {
    }

    public a(WebView webView, DownloadListener downloadListener, boolean z) {
        this.f6501a = downloadListener;
        this.b = webView;
    }

    @Override // com.tencent.smtt.export.external.interfaces.DownloadListener
    public void onDownloadStart(String str, String str2, byte[] bArr, String str3, String str4, String str5, long j, String str6, String str7) {
        DownloadListener downloadListener = this.f6501a;
        if (downloadListener == null) {
            if (QbSdk.canOpenMimeFileType(this.b.getContext(), str5)) {
                Intent intent = new Intent("com.tencent.QQBrowser.action.sdk.document");
                intent.setFlags(DriveFile.MODE_READ_ONLY);
                intent.putExtra("key_reader_sdk_url", str);
                intent.putExtra("key_reader_sdk_type", 1);
                intent.setData(Uri.parse(str));
                this.b.getContext().startActivity(intent);
                return;
            }
            ApplicationInfo applicationInfo = this.b.getContext().getApplicationInfo();
            if (applicationInfo == null || !TbsConfig.APP_WX.equals(applicationInfo.packageName)) {
                com.tencent.smtt.sdk.a.a.a(this.b.getContext(), str, null, null);
                return;
            }
            return;
        }
        downloadListener.onDownloadStart(str, str3, str4, str5, j);
    }

    @Override // com.tencent.smtt.export.external.interfaces.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        onDownloadStart(str, null, null, str2, str3, str4, j, null, null);
    }
}
