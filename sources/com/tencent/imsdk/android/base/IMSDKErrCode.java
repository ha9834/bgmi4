package com.tencent.imsdk.android.base;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.SparseArray;
import androidx.annotation.Keep;
import com.tencent.imsdk.android.tools.DeviceUtils;
import com.tencent.imsdk.android.tools.FileUtils;
import com.tencent.imsdk.android.tools.log.IMLogger;
import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

@Keep
/* loaded from: classes.dex */
public class IMSDKErrCode {
    public static final int APP_NOT_SUPPORT = 16;
    public static final int CANCEL = 2;
    public static final int DISABLED = 19;
    private static final String ERROR_MESSAGE_DIR = "IMSDK";
    private static final String ERROR_MESSAGE_FILENAME = "IMSDKRetMsg";
    public static final int FILE_SYSTEM = 8;
    public static final int INTERFACE_DEPRECATED = 999;
    public static final int INVALID = -1;
    public static final int INVALID_ARGUMENT = 11;
    public static final int LOGIN_CACHE_EXPIRE = 1002;
    public static final int LOGIN_CODE_FOR_CONNECT = 1006;
    public static final int LOGIN_NEED_USER_DATA = 1005;
    public static final int LOGIN_NOCACHE = 1001;
    public static final int LOGIN_UNKNOWN_ERROR = 1000;
    public static final int NEED_APP = 15;
    public static final int NEED_CHANNEL = 18;
    public static final int NEED_CONFIG = 13;
    public static final int NEED_INIT = 17;
    public static final int NEED_LOGIN = 10;
    public static final int NEED_PERMISSION = 12;
    public static final int NEED_PLUGIN = 9;
    public static final int NETWORK = 4;
    public static final int NOT_SUPPORT = 7;
    public static final int PAY_INVENTORY_EMPTY = 1302;
    public static final int PAY_PROCESS_ERROR = 1300;
    public static final int PAY_PULL_MP_INTERCEPT = 1301;
    public static final int PAY_REQ_PRODUCT_EMPTY = 1303;
    public static final int PUSH_NOTIFICATION_CLICK = 1401;
    public static final int PUSH_NOTIFICATION_SHOW = 1402;
    public static final int PUSH_RECEIVER_TEXT = 1400;
    public static final int SERVER = 5;
    public static final int SERVICE_REFUSE = 14;
    public static final int SHARE_UNKNOWN_ERROR = 1100;
    public static final int SUCCESS = 1;
    public static final int SYSTEM = 3;
    public static final int THIRD = 9999;
    public static final int TIMEOUT = 6;
    public static final int UNKNOWN = 0;
    private static Context mContext;
    private static String mCurrentLanguage;
    private static SparseArray<String> mMessages = new SparseArray<>();

    public static void initialize(Context context) {
        if (mContext == null) {
            mContext = context;
        }
    }

    public static String getMessageByCode(int i) {
        return getMessageByCode(i, DeviceUtils.getLanguage());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int loadMessage(String str) {
        InputStreamReader inputStreamReader;
        InputStream inputStream;
        SparseArray<String> sparseArray = mMessages;
        if (sparseArray == null) {
            mMessages = new SparseArray<>();
        } else {
            sparseArray.clear();
        }
        String str2 = "";
        BufferedReader bufferedReader = null;
        try {
            if (str == null) {
                try {
                    str = DeviceUtils.getLanguage();
                } catch (IOException e) {
                    e = e;
                    inputStream = null;
                    inputStreamReader = null;
                    IMLogger.d(e.getMessage());
                    FileUtils.closeQuietly(bufferedReader);
                    FileUtils.closeQuietly(inputStreamReader);
                    FileUtils.closeQuietly(inputStream);
                    return mMessages.size();
                } catch (JSONException e2) {
                    e = e2;
                    inputStream = null;
                    inputStreamReader = null;
                    IMLogger.w(e.getMessage(), new Object[0]);
                    FileUtils.closeQuietly(bufferedReader);
                    FileUtils.closeQuietly(inputStreamReader);
                    FileUtils.closeQuietly(inputStream);
                    return mMessages.size();
                } catch (Throwable th) {
                    th = th;
                    inputStream = null;
                    inputStreamReader = null;
                    FileUtils.closeQuietly(bufferedReader);
                    FileUtils.closeQuietly(inputStreamReader);
                    FileUtils.closeQuietly(inputStream);
                    throw th;
                }
            }
            String str3 = "IMSDK" + File.separator + ERROR_MESSAGE_FILENAME + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + str.toLowerCase(Locale.US) + ".json";
            AssetManager assets = mContext.getAssets();
            try {
                inputStream = assets.open(str3);
            } catch (FileNotFoundException e3) {
                IMLogger.w("file not found : " + str3 + ", error occur :" + e3.getMessage(), new Object[0]);
                str3 = "IMSDK" + File.separator + ERROR_MESSAGE_FILENAME + ".json";
                inputStream = assets.open(str3);
            }
            if (inputStream != null) {
                try {
                    inputStreamReader = new InputStreamReader(inputStream);
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                        while (true) {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                str2 = str2 + readLine;
                            } catch (IOException e4) {
                                e = e4;
                                bufferedReader = bufferedReader2;
                                IMLogger.d(e.getMessage());
                                FileUtils.closeQuietly(bufferedReader);
                                FileUtils.closeQuietly(inputStreamReader);
                                FileUtils.closeQuietly(inputStream);
                                return mMessages.size();
                            } catch (JSONException e5) {
                                e = e5;
                                bufferedReader = bufferedReader2;
                                IMLogger.w(e.getMessage(), new Object[0]);
                                FileUtils.closeQuietly(bufferedReader);
                                FileUtils.closeQuietly(inputStreamReader);
                                FileUtils.closeQuietly(inputStream);
                                return mMessages.size();
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedReader = bufferedReader2;
                                FileUtils.closeQuietly(bufferedReader);
                                FileUtils.closeQuietly(inputStreamReader);
                                FileUtils.closeQuietly(inputStream);
                                throw th;
                            }
                        }
                        bufferedReader = bufferedReader2;
                    } catch (IOException e6) {
                        e = e6;
                    } catch (JSONException e7) {
                        e = e7;
                    }
                } catch (IOException e8) {
                    e = e8;
                    inputStreamReader = null;
                } catch (JSONException e9) {
                    e = e9;
                    inputStreamReader = null;
                } catch (Throwable th3) {
                    th = th3;
                    inputStreamReader = null;
                }
            } else {
                inputStreamReader = null;
            }
            if (str2 != null && str2.length() > 0) {
                JSONObject jSONObject = new JSONObject(str2);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    int intValue = Integer.valueOf(keys.next()).intValue();
                    mMessages.put(intValue, jSONObject.getString(String.valueOf(intValue)));
                }
            } else {
                IMLogger.d("IMSDKRetMsg error message config file content is null or empty : " + str3);
            }
            FileUtils.closeQuietly(bufferedReader);
            FileUtils.closeQuietly(inputStreamReader);
            FileUtils.closeQuietly(inputStream);
            return mMessages.size();
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static String getMessageByCode(int i, String str) {
        SparseArray<String> sparseArray;
        String str2 = "";
        if (mContext == null) {
            IMLogger.w("IMErrorMsg mContext is null, please check init first", new Object[0]);
        } else {
            String str3 = mCurrentLanguage;
            if (str3 == null || !str3.equals(str) || (sparseArray = mMessages) == null || sparseArray.size() <= 0) {
                loadMessage(str);
                mCurrentLanguage = str;
            }
            SparseArray<String> sparseArray2 = mMessages;
            if (sparseArray2 != null && (str2 = sparseArray2.get(i)) == null) {
                IMLogger.w("IMErrorMsg message not contains code : " + i, new Object[0]);
            }
        }
        return str2;
    }
}
