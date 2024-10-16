package com.tencent.imsdk.android.base.stat;

import android.content.Context;
import com.facebook.internal.security.CertificateUtil;
import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.base.IMSDKModules;
import com.tencent.imsdk.android.base.interfaces.IStat;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes.dex */
public class IMSDKStatManager {
    private static final int GET_ATTRIBUTE = 2;
    private static final int REPORT_EVENT = 3;
    private static final int SET_ATTRIBUTE = 1;
    private static Object mLock = new Object();
    private Map<String, IStat> mChannelInsCache;
    protected Context mCtx;
    private List mFilterChannels;
    private Map<String, String[]> mTypeAndChannels;

    public IMSDKStatManager(Context context) {
        if (this.mCtx == null) {
            this.mCtx = context;
        }
        if (this.mChannelInsCache == null) {
            this.mChannelInsCache = new HashMap();
        }
        if (this.mTypeAndChannels == null) {
            this.mTypeAndChannels = new HashMap();
        }
    }

    private void printMap(String str, Map<String, String[]> map) {
        StringBuilder sb = new StringBuilder();
        if (map == null) {
            return;
        }
        for (String str2 : map.keySet()) {
            sb.append(str2);
            sb.append(CertificateUtil.DELIMITER);
            String[] strArr = map.get(str2);
            if (strArr != null && strArr.length > 0) {
                sb.append(Arrays.deepToString(map.get(str2)));
            }
            sb.append("\n");
        }
        IMLogger.d(str + " : " + sb.toString());
    }

    public boolean setStatThreadHold(Map<String, String[]> map) {
        if (map == null || map.isEmpty()) {
            return false;
        }
        for (String[] strArr : map.values()) {
            if (strArr != null) {
                for (String str : strArr) {
                    initChannelInstance(str);
                }
            }
        }
        this.mTypeAndChannels.clear();
        this.mTypeAndChannels.putAll(map);
        for (String str2 : map.keySet()) {
            if ("eventTrack".equals(str2)) {
                String[] strArr2 = this.mTypeAndChannels.get(str2);
                this.mTypeAndChannels.put(IStat.STAT_TRACK_EVENT_BEGIN, strArr2);
                this.mTypeAndChannels.put(IStat.STAT_TRACK_EVENT_END, strArr2);
                this.mTypeAndChannels.remove(str2);
            } else if ("pageTrack".equals(str2)) {
                String[] strArr3 = this.mTypeAndChannels.get(str2);
                this.mTypeAndChannels.put(IStat.STAT_TRACK_PAGE_BEGIN, strArr3);
                this.mTypeAndChannels.put(IStat.STAT_TRACK_PAGE_END, strArr3);
                this.mTypeAndChannels.remove(str2);
            } else if ("testSpeed".equals(str2)) {
                this.mTypeAndChannels.put(IStat.STAT_EVENT_TEST_SPEED, this.mTypeAndChannels.get(str2));
                this.mTypeAndChannels.remove(str2);
            }
        }
        printMap("origin map ", map);
        printMap("after compat ", this.mTypeAndChannels);
        return true;
    }

    public boolean setStatThreadHold(String str, String[] strArr) {
        if (!initChannelInstance(str)) {
            return false;
        }
        for (String str2 : strArr) {
            if (this.mTypeAndChannels.containsKey(str2)) {
                String[] strArr2 = this.mTypeAndChannels.get(str2);
                if (strArr2 == null) {
                    strArr2 = new String[0];
                }
                boolean z = false;
                for (String str3 : strArr2) {
                    if (str3 != null && str3.equals(str)) {
                        z = true;
                    }
                }
                if (!z) {
                    int length = strArr2.length;
                    String[] strArr3 = new String[length + 1];
                    for (int i = 0; i < length; i++) {
                        strArr3[i] = strArr2[i];
                    }
                    strArr3[strArr2.length] = str;
                    this.mTypeAndChannels.put(str2, strArr3);
                }
            } else {
                this.mTypeAndChannels.put(str2, new String[]{str});
            }
        }
        return true;
    }

    public void setFilter(String[] strArr) {
        this.mFilterChannels = new ArrayList();
        Collections.addAll(this.mFilterChannels, strArr);
    }

    public void clearFilter() {
        this.mFilterChannels = null;
    }

    public void setAttribute(String str, IMSDKStatUserAttribute iMSDKStatUserAttribute) {
        methodRouter(1, null, str, iMSDKStatUserAttribute, null, new Object[0]);
    }

    public final <E> E getAttribute(Class<?> cls, String str, Object... objArr) {
        return (E) methodRouter(2, cls, str, null, null, objArr);
    }

    public final void reportCustomEvent(String str, IMSDKStatEventParams iMSDKStatEventParams) {
        methodRouter(3, null, str, null, iMSDKStatEventParams, new Object[0]);
    }

    private boolean initChannelInstance(String str) {
        if (!T.ckIsEmpty(str) && this.mChannelInsCache.get(str) == null) {
            Object[] objArr = new Object[2];
            objArr[0] = str.toLowerCase(Locale.US);
            objArr[1] = str.equalsIgnoreCase(IR.def.IMSDK_KEYWORD) ? IR.def.IMSDK_KEYWORD : str;
            IStat iStat = (IStat) IMSDKModules.getInstance(this.mCtx).getChannelInstance(IStat.class, String.format(IR.def.DEFAULT_PACKAGE_NAME_STAT_FORMAT, objArr));
            if (iStat != null) {
                this.mChannelInsCache.put(str, iStat);
            }
        }
        return this.mChannelInsCache.containsKey(str);
    }

    private <E> E methodRouter(int i, Class<?> cls, String str, IMSDKStatUserAttribute iMSDKStatUserAttribute, IMSDKStatEventParams iMSDKStatEventParams, Object... objArr) {
        String[] strArr = this.mTypeAndChannels.get(str);
        if (strArr != null && strArr.length > 0) {
            for (String str2 : strArr) {
                if (!T.ckIsEmpty(str2)) {
                    List list = this.mFilterChannels;
                    if (list == null || (list != null && list.contains(str2))) {
                        IStat iStat = this.mChannelInsCache.get(str2);
                        if (iStat != null) {
                            switch (i) {
                                case 1:
                                    iStat.setAttribute(str, iMSDKStatUserAttribute);
                                    break;
                                case 2:
                                    return (E) iStat.getAttribute(cls, str, objArr);
                                case 3:
                                    iStat.reportEvent(str, iMSDKStatEventParams);
                                    break;
                            }
                        } else {
                            IMLogger.w("There is not such channel name as " + str2, new Object[0]);
                        }
                    } else {
                        IMLogger.d("filter is active, " + str2 + " is not in filter " + Arrays.deepToString(this.mFilterChannels.toArray()));
                    }
                }
            }
            return null;
        }
        IMLogger.w(str + " has been limit", new Object[0]);
        return null;
    }
}
