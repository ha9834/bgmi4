package com.huawei.game.gamekit;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.game.gamekit.GameManager;

/* loaded from: classes2.dex */
public final class b extends GameManager {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5468a = "GameKit";
    private static final int b = 1;
    private static final int c = 2048;
    private static b d;
    private static final Object e = new Object();
    private a i;
    private String f = "";
    private boolean g = false;
    private com.huawei.game.gamekit.a j = null;
    private GameManager.GameCallBack k = null;
    private GameManager.GameCallBack l = new GameManager.GameCallBack() { // from class: com.huawei.game.gamekit.b.1
        @Override // com.huawei.game.gamekit.GameManager.GameCallBack
        public final void onPhoneInfoUpdated(String str) {
            com.huawei.game.gamekit.b.c.b(b.f5468a, "onPhoneInfoUpdated info=" + str);
            b.this.f = str;
            if (b.this.i == null) {
                com.huawei.game.gamekit.b.c.d(b.f5468a, "sendMessage failed: handler is null");
                return;
            }
            Message obtainMessage = b.this.i.obtainMessage(1);
            obtainMessage.obj = b.this.f;
            b.this.i.sendMessage(obtainMessage);
        }
    };
    private HandlerThread h = new HandlerThread("GameKitWorkThread");

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            String str = (String) message.obj;
            if (b.this.k != null) {
                b.this.k.onPhoneInfoUpdated(str);
            }
        }
    }

    private b() {
        this.h.start();
        Looper looper = this.h.getLooper();
        if (looper != null) {
            this.i = new a(looper);
        } else {
            com.huawei.game.gamekit.b.c.d(f5468a, "GameKitWorkThread got null looper!");
        }
    }

    public static GameManager a() {
        b bVar;
        synchronized (e) {
            if (d == null) {
                d = new b();
            }
            bVar = d;
        }
        return bVar;
    }

    @Override // com.huawei.game.gamekit.GameManager
    public final String getPhoneInfo() {
        com.huawei.game.gamekit.b.c.b(f5468a, "calling getPhoneInfo: " + this.f);
        return this.f;
    }

    @Override // com.huawei.game.gamekit.GameManager
    public final boolean registerGame(String str, GameManager.GameCallBack gameCallBack) {
        com.huawei.game.gamekit.b.c.b(f5468a, "registerGame, packageName:" + str + " gameCallback:" + gameCallBack);
        if (TextUtils.isEmpty(str)) {
            com.huawei.game.gamekit.b.c.c(f5468a, "register failed: invalid params: packageName:" + str);
            return false;
        }
        this.k = gameCallBack;
        if (this.j == null) {
            this.j = com.huawei.game.gamekit.a.a();
            com.huawei.game.gamekit.b.c.b(f5468a, "It is the first time calling registerGame");
        }
        if (this.g) {
            a aVar = this.i;
            if (aVar != null) {
                Message obtainMessage = aVar.obtainMessage(1);
                obtainMessage.obj = this.f;
                this.i.sendMessage(obtainMessage);
            } else {
                com.huawei.game.gamekit.b.c.d(f5468a, "sendMessage failed: handler is null");
            }
        } else {
            this.g = this.j.a(str, this.l);
        }
        return this.g;
    }

    @Override // com.huawei.game.gamekit.GameManager
    public final boolean registerGame(String str, GameManager.GameCallBack gameCallBack, Context context) {
        com.huawei.game.gamekit.b.c.b(f5468a, "registerGame, packageName:" + str + " gameCallback:" + gameCallBack);
        com.huawei.game.gamekit.b.b a2 = com.huawei.game.gamekit.b.b.a();
        com.huawei.game.gamekit.b.c.c("HapticsUtil", "init Haptics Util");
        a2.f5472a = new com.huawei.devices.hapticskit.a(context);
        a2.b = a2.f5472a.a();
        return registerGame(str, gameCallBack);
    }

    @Override // com.huawei.game.gamekit.GameManager
    public final void updateGameAppInfo(String str) {
        String str2;
        String str3;
        if (this.g) {
            if (TextUtils.isEmpty(str) || str.length() > 2048) {
                str2 = f5468a;
                str3 = "updateGameAppInfo failed: illegal param";
            } else {
                com.huawei.game.gamekit.a aVar = this.j;
                if (aVar != null) {
                    aVar.a(str);
                    return;
                } else {
                    str2 = f5468a;
                    str3 = "updateGameAppInfo failed: did not register game";
                }
            }
            com.huawei.game.gamekit.b.c.c(str2, str3);
        }
    }
}
