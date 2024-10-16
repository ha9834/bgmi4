package com.tencent.midas.oversea.newnetwork.http;

import com.tencent.midas.comm.APLog;
import com.tencent.midas.http.core.IHttpLog;

/* loaded from: classes.dex */
public class NewNetLog implements IHttpLog {
    private boolean isLog = false;

    @Override // com.tencent.midas.http.core.IHttpLog
    public void e(String str, String str2) {
        APLog.e(str, str2);
    }

    @Override // com.tencent.midas.http.core.IHttpLog
    public void d(String str, String str2) {
        if (this.isLog) {
            APLog.d(str, str2);
        }
    }

    @Override // com.tencent.midas.http.core.IHttpLog
    public void i(String str, String str2) {
        if (this.isLog) {
            APLog.i(str, str2);
        }
    }

    @Override // com.tencent.midas.http.core.IHttpLog
    public void w(String str, String str2) {
        if (this.isLog) {
            APLog.w(str, str2);
        }
    }

    public void setLogEnable(boolean z) {
        this.isLog = z;
    }
}
