package com.tencent.midas.oversea.business.h5;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.midas.oversea.business.APPayManager;
import com.tencent.midas.oversea.business.h5.IWebInterface;
import com.tencent.midas.oversea.business.pay.MidasResponse;
import com.tencent.midas.oversea.newnetwork.http.DnsManager;

/* loaded from: classes.dex */
public class WebService extends Service {
    static Handler MainHandler = new Handler() { // from class: com.tencent.midas.oversea.business.h5.WebService.1
        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            APPayManager.instance().callBackError(message.arg1, new MidasResponse(message.arg2, (String) message.obj));
        }
    };
    public static final int ON_RESPONSE = 1;
    public static final String TAG = "WebService";

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return new WebBinder();
    }

    /* loaded from: classes.dex */
    static class WebBinder extends IWebInterface.Stub {
        WebBinder() {
        }

        @Override // com.tencent.midas.oversea.business.h5.IWebInterface
        public void onResult(int i, int i2, String str) {
            Message obtainMessage = WebService.MainHandler.obtainMessage(1);
            obtainMessage.arg1 = i;
            obtainMessage.arg2 = i2;
            obtainMessage.obj = str;
            obtainMessage.sendToTarget();
        }

        @Override // com.tencent.midas.oversea.business.h5.IWebInterface
        public String queryCacheIP(String str) {
            return !TextUtils.isEmpty(str) ? DnsManager.singleton().queryIp(str) : "";
        }
    }
}
