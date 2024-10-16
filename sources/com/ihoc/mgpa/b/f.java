package com.ihoc.mgpa.b;

import com.ihoc.mgpa.download.BgDownloadProxy;
import com.ihoc.mgpa.g.g;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class f implements h {

    /* renamed from: a, reason: collision with root package name */
    public static long f5489a;

    private void a() {
        if ((System.currentTimeMillis() / 1000) - f5489a < 86400) {
            return;
        }
        f5489a = System.currentTimeMillis() / 1000;
        new com.ihoc.mgpa.g.g(g.a.CloudContrl).a(new e(this));
    }

    @Override // com.ihoc.mgpa.b.h
    public void a(int i, String str) {
        if (i == com.ihoc.mgpa.a.e.SCENE.a()) {
            if (str.equals(com.ihoc.mgpa.a.g.MAIN_UI.a()) || str.equals(com.ihoc.mgpa.a.g.SCENE_LOAD.a())) {
                a();
                if (com.ihoc.mgpa.i.f.I()) {
                    com.ihoc.mgpa.n.m.a("TGPA_ConfigDownloadObserver", "updateBgPreDownloadNewTask is doing ");
                    BgDownloadProxy.getInstance().updateBgPreDownloadNewTask();
                }
            }
        }
    }

    @Override // com.ihoc.mgpa.b.h
    public void a(int i, float[] fArr) {
    }

    @Override // com.ihoc.mgpa.b.h
    public void a(HashMap<String, String> hashMap) {
    }
}
