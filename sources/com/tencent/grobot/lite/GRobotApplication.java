package com.tencent.grobot.lite;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.text.TextUtils;
import com.nostra13.universalimageloader.core.d;
import com.tencent.grobot.lite.common.BitmapPools;
import com.tencent.grobot.lite.common.Const;
import com.tencent.grobot.lite.common.SystemUtils;
import com.tencent.grobot.lite.common.ViewPools;
import com.tencent.grobot.lite.common.thread.ThreadManager;
import com.tencent.grobot.lite.core.IService;
import com.tencent.grobot.lite.image.ImagePresenter;
import com.tencent.grobot.lite.image.download.ImageService;
import com.tencent.grobot.lite.image.upload.UploadManager;
import com.tencent.grobot.lite.image.upload.cos.BizService;
import com.tencent.grobot.lite.network.NetworkService;
import com.tencent.grobot.lite.presenter.PresenterService;
import com.tencent.grobot.lite.report.ReportService;
import com.tencent.grobot.lite.ui.view.LocalLinkMovementMethod;
import com.tencent.midas.oversea.newapi.APMidasPayNewAPI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class GRobotApplication implements Runnable {
    private static volatile GRobotApplication instance;
    public Context context;
    private GameParameters gameParam;
    private boolean hasBackground;
    private String gameParamString = "";
    private Map<String, IService> services = new HashMap(4);
    private final Object lock = new Object();

    public static GRobotApplication getInstance() {
        if (instance == null) {
            synchronized (GRobotApplication.class) {
                if (instance == null) {
                    instance = new GRobotApplication();
                }
            }
        }
        return instance;
    }

    private GRobotApplication() {
        this.hasBackground = false;
        this.hasBackground = false;
    }

    public void init(Context context, String str) {
        this.context = context.getApplicationContext();
        this.gameParamString = str;
        parseGameParameters(this.context, str);
        initSharedBugly(context);
    }

    public void initFromOtherProcess(Context context, GameParameters gameParameters, String str) {
        this.context = context.getApplicationContext();
        this.gameParam = gameParameters;
        this.gameParamString = str;
    }

    public boolean isInit() {
        return (this.context == null || TextUtils.isEmpty(this.gameParamString) || this.gameParam == null) ? false : true;
    }

    public static Context self() {
        if (instance != null) {
            return instance.context;
        }
        return null;
    }

    public boolean isBackground() {
        return this.hasBackground;
    }

    public void setBackground(boolean z) {
        this.gameParam = null;
        this.hasBackground = z;
    }

    private void parseGameParameters(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = getSharedParam(Const.GAME_PARAMETERS_KEY, "");
        } else {
            setSharedParam(Const.GAME_PARAMETERS_KEY, str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.gameParam = new GameParameters(context, str);
    }

    public void initSharedBugly(Context context) {
        if (context == null) {
            return;
        }
        if (context instanceof Activity) {
            context = ((Activity) context).getApplication();
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(APMidasPayNewAPI.BUGLY_SP_NAME, 0).edit();
        edit.putString("599c879cb8", "mobile_2.2.0_" + this.gameParam.gameId);
        edit.commit();
    }

    public GameParameters getGameParam() {
        return this.gameParam;
    }

    public String getOpenId() {
        GameParameters gameParameters = this.gameParam;
        return gameParameters != null ? gameParameters.openid : "";
    }

    public String getRoleId() {
        GameParameters gameParameters = this.gameParam;
        return gameParameters != null ? gameParameters.roleId : "";
    }

    public String getGameParamString() {
        return this.gameParamString;
    }

    public int getServerKey() {
        GameParameters gameParameters = this.gameParam;
        if (gameParameters == null) {
            return 0;
        }
        return gameParameters.debug;
    }

    public boolean isDebug() {
        GameParameters gameParameters = this.gameParam;
        return gameParameters != null && gameParameters.debugLog == 1;
    }

    public boolean isHighPerformace() {
        GameParameters gameParameters = this.gameParam;
        return gameParameters != null && gameParameters.performace == 1;
    }

    public boolean isHms() {
        GameParameters gameParameters = this.gameParam;
        return gameParameters != null && gameParameters.hms == 1;
    }

    public String headerUrl() {
        GameParameters gameParameters = this.gameParam;
        return gameParameters != null ? gameParameters.headerUrl : "";
    }

    public String getSharedParam(String str, String str2) {
        Context context = this.context;
        if (context == null) {
            return null;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(Const.PREFERENCE_NAME, 0);
        return sharedPreferences != null ? sharedPreferences.getString(str, str2) : str2;
    }

    public void setSharedParam(String str, String str2) {
        SharedPreferences sharedPreferences;
        Context context = this.context;
        if (context == null || (sharedPreferences = context.getSharedPreferences(Const.PREFERENCE_NAME, 0)) == null) {
            return;
        }
        sharedPreferences.edit().putString(str, str2).apply();
    }

    public <T extends IService> T getService(Class<T> cls) {
        ReportService reportService;
        if (NetworkService.class.equals(cls)) {
            reportService = (T) this.services.get(NetworkService.class.getName());
            if (reportService == null) {
                synchronized (this.lock) {
                    reportService = this.services.get(NetworkService.class.getName());
                    if (reportService == null) {
                        reportService = new NetworkService(this);
                        this.services.put(NetworkService.class.getName(), reportService);
                    }
                }
            }
        } else if (PresenterService.class.equals(cls)) {
            reportService = (T) this.services.get(PresenterService.class.getName());
            if (reportService == null) {
                synchronized (this.lock) {
                    reportService = this.services.get(PresenterService.class.getName());
                    if (reportService == null) {
                        reportService = new PresenterService(this);
                        this.services.put(PresenterService.class.getName(), reportService);
                    }
                }
            }
        } else if (ImageService.class.equals(cls)) {
            reportService = (T) this.services.get(ImageService.class.getName());
            if (reportService == null) {
                synchronized (this.lock) {
                    reportService = this.services.get(ImageService.class.getName());
                    if (reportService == null) {
                        reportService = new ImageService(this);
                        this.services.put(ImageService.class.getName(), reportService);
                    }
                }
            }
        } else if (ReportService.class.equals(cls)) {
            reportService = (T) this.services.get(ReportService.class.getName());
            if (reportService == null) {
                synchronized (this.lock) {
                    reportService = this.services.get(ReportService.class.getName());
                    if (reportService == null) {
                        reportService = new ReportService(this);
                        this.services.put(ReportService.class.getName(), reportService);
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("clazz is illegal， t=" + cls);
        }
        return (T) reportService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onClose() {
        this.gameParam = null;
        Iterator<Map.Entry<String, IService>> it = this.services.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().onDestroy();
        }
        this.services.clear();
        BizService.onDestory();
        UploadManager.onDestory();
        ImagePresenter.onDestory();
        ThreadManager.destory();
        LocalLinkMovementMethod.destory();
        ViewPools.destory();
        BitmapPools.destroy();
        SQLiteDatabase.releaseMemory();
        if (d.a().b()) {
            d.a().d();
            d.a().c();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        SystemUtils.doGC();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doLastGC() {
        new Handler().postDelayed(this, 35000L);
    }
}
