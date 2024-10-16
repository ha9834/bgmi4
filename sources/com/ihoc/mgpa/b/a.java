package com.ihoc.mgpa.b;

import com.ihoc.mgpa.download.BgDownloadService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f5485a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(c cVar) {
        this.f5485a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BgDownloadService.BgDownloadServiceLocalBinder bgDownloadServiceLocalBinder;
        BgDownloadService.BgDownloadServiceLocalBinder bgDownloadServiceLocalBinder2;
        String str;
        int i;
        bgDownloadServiceLocalBinder = this.f5485a.f;
        if (bgDownloadServiceLocalBinder != null) {
            bgDownloadServiceLocalBinder2 = this.f5485a.f;
            str = this.f5485a.f5487a;
            i = this.f5485a.c;
            bgDownloadServiceLocalBinder2.bringServiceToForeground(str, i);
        }
    }
}
