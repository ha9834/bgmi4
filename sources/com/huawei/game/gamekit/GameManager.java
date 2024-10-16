package com.huawei.game.gamekit;

import android.content.Context;

/* loaded from: classes2.dex */
public abstract class GameManager {

    /* loaded from: classes2.dex */
    public interface GameCallBack {
        void onPhoneInfoUpdated(String str);
    }

    public static GameManager getGameManager() {
        return b.a();
    }

    public abstract String getPhoneInfo();

    public abstract boolean registerGame(String str, GameCallBack gameCallBack);

    public abstract boolean registerGame(String str, GameCallBack gameCallBack, Context context);

    public abstract void updateGameAppInfo(String str);
}
