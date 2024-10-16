package com.tencent.hawk.bridge;

import android.content.Context;

/* loaded from: classes2.dex */
public class Fetcher implements Runnable {
    private boolean isFetchDone = false;
    private CCFileChangeListener mCCFileChangeListener;
    private Context mCtx;
    private String mProjIden;
    private String oldMD5;

    public Fetcher(Context context, String str, String str2) {
        this.mCtx = context;
        this.mProjIden = str;
        this.oldMD5 = str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:87:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x017f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0170 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean doGet(java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 393
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.hawk.bridge.Fetcher.doGet(java.lang.String):boolean");
    }

    @Override // java.lang.Runnable
    public void run() {
        String ccurl;
        int i = 0;
        while (i < 5 && !this.isFetchDone) {
            i++;
            if (i <= 2) {
                ccurl = RTState.getCCURL() != null ? RTState.getCCURL() : Constant.CDN_URL_QQ;
            } else {
                ccurl = RTState.getCCURL() != null ? RTState.getCCURL() : Constant.CDN_URL_NET;
            }
            if (doGet(ccurl)) {
                return;
            } else {
                try {
                    Thread.sleep(100L);
                } catch (Exception unused) {
                }
            }
        }
    }

    public void asynFetch(CCFileChangeListener cCFileChangeListener) {
        this.mCCFileChangeListener = cCFileChangeListener;
        new Thread(this).start();
    }
}
