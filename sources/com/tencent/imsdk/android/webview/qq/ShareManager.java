package com.tencent.imsdk.android.webview.qq;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.api.relation.IMSDKFriend;
import com.tencent.imsdk.android.api.relation.IMSDKFriendReqInfo;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;

/* loaded from: classes.dex */
public class ShareManager {
    private static final String FORMAT_SHARE_NAME = "share_%s";
    public static final int ID_SHARE_BROWSER = 99;
    private static final String NAME_SHARE_BROWSER = "Browser";
    private static final int TOAST_POSITION_X = 0;
    private static final int TOAST_POSITION_Y = 200;

    private static int getStringId(Context context, String str) {
        int stringId = ResourceUtil.getStringId(context, "share_browser");
        int stringId2 = ResourceUtil.getStringId(context, str);
        return stringId2 != 0 ? stringId2 : stringId;
    }

    private static int getDrawableId(Context context, String str) {
        int drawableId = ResourceUtil.getDrawableId(context, "share_browser");
        int drawableId2 = ResourceUtil.getDrawableId(context, str);
        return drawableId2 != 0 ? drawableId2 : drawableId;
    }

    public static List<Map<String, Object>> getChannelListData(Context context) {
        Resources resources = context.getResources();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int arrayId = ResourceUtil.getArrayId(context, "ShareChannel");
        if (arrayId != 0) {
            String[] stringArray = resources.getStringArray(arrayId);
            for (int i = 0; i < stringArray.length; i++) {
                linkedHashMap.put(Integer.valueOf(i), stringArray[i]);
            }
        } else {
            IMLogger.e("ShareChannel not set!", new Object[0]);
        }
        linkedHashMap.put(99, "Browser");
        ArrayList arrayList = new ArrayList();
        for (Integer num : linkedHashMap.keySet()) {
            try {
                String format = String.format(FORMAT_SHARE_NAME, ((String) linkedHashMap.get(num)).toLowerCase(Locale.US));
                HashMap hashMap = new HashMap();
                int drawableId = getDrawableId(context, format);
                if (drawableId <= 0) {
                    IMLogger.w("no " + format + " found in resource files", new Object[0]);
                } else {
                    hashMap.put("image", Integer.valueOf(drawableId));
                    int stringId = getStringId(context, format);
                    String string = stringId != 0 ? resources.getString(stringId) : "";
                    if (T.ckIsEmpty(string)) {
                        IMLogger.w("no  " + format + " found in resource files!", new Object[0]);
                    } else {
                        hashMap.put(com.intlgame.webview.WebViewManager.KEY_JS_CHANNEL, string);
                        hashMap.put("id", num);
                        arrayList.add(hashMap);
                    }
                }
            } catch (Exception e) {
                IMLogger.e("add share channel error : " + e.getMessage(), new Object[0]);
            }
        }
        return arrayList;
    }

    private static void initShareChannel(Activity activity, String str) {
        IMSDKFriend.initialize(activity);
        if (IMSDKFriend.setChannel(str)) {
            return;
        }
        IMLogger.e("set channel failed !", new Object[0]);
    }

    public static void shareToBrowser(Context context, String str) {
        ArrayList arrayList = new ArrayList();
        int arrayId = ResourceUtil.getArrayId(context, "urlKeyFilter");
        if (arrayId != 0) {
            for (String str2 : context.getResources().getStringArray(arrayId)) {
                arrayList.add(str2.trim());
            }
        } else {
            IMLogger.e("urlKeyFilter not set!", new Object[0]);
        }
        arrayList.add("sTicket");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.setData(Uri.parse(DisplayUtil.filterUrlParaKey(str, arrayList)));
        context.startActivity(intent);
    }

    public static void shareToChannel(final Activity activity, String str, String str2, String str3) {
        initShareChannel(activity, str);
        IMSDKFriendReqInfo iMSDKFriendReqInfo = new IMSDKFriendReqInfo();
        iMSDKFriendReqInfo.type = 3;
        ArrayList arrayList = new ArrayList();
        int arrayId = ResourceUtil.getArrayId(activity, "urlKeyFilter");
        if (arrayId != 0) {
            for (String str4 : activity.getResources().getStringArray(arrayId)) {
                arrayList.add(str4.trim());
            }
        } else {
            IMLogger.e("urlKeyFilter not set!", new Object[0]);
        }
        arrayList.add("sTicket");
        iMSDKFriendReqInfo.link = DisplayUtil.filterUrlParaKey(str3, arrayList);
        iMSDKFriendReqInfo.title = str2;
        iMSDKFriendReqInfo.imagePath = null;
        IMSDKFriend.share(iMSDKFriendReqInfo, new IMSDKResultListener<IMSDKResult>() { // from class: com.tencent.imsdk.android.webview.qq.ShareManager.1
            @Override // com.tencent.imsdk.android.api.IMSDKResultListener
            public void onResult(IMSDKResult iMSDKResult) {
                if (iMSDKResult != null) {
                    try {
                        IMLogger.json(iMSDKResult.toJSONString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    ShareManager.showToast(activity.getApplicationContext(), iMSDKResult.imsdkRetCode);
                    return;
                }
                IMLogger.e("shareToFacebook onResult error, result = null", new Object[0]);
            }
        }, new Object[0]);
    }

    public static void showToast(Context context, int i) {
        View inflate;
        int id;
        TextView textView;
        int layoutId = ResourceUtil.getLayoutId(context, "layout_toast");
        if (layoutId == 0 || (inflate = LayoutInflater.from(context).inflate(layoutId, (ViewGroup) null)) == null || (id = ResourceUtil.getId(context, "toast_title")) == 0 || (textView = (TextView) inflate.findViewById(id)) == null) {
            return;
        }
        Typeface typeface = ResourceUtil.getTypeface(context, "share_result");
        if (typeface != null) {
            textView.setTypeface(typeface);
        }
        if (i == 1) {
            int stringId = ResourceUtil.getStringId(context, "share_success");
            textView.setText(stringId != 0 ? context.getString(stringId) : "Shared");
        } else if (i == 2) {
            int stringId2 = ResourceUtil.getStringId(context, "share_cancel");
            textView.setText(stringId2 != 0 ? context.getString(stringId2) : "Sharing canceled");
        } else {
            int stringId3 = ResourceUtil.getStringId(context, "share_failure");
            textView.setText(stringId3 != 0 ? context.getString(stringId3) : "Sharing failed");
        }
        Toast toast = new Toast(context);
        toast.setGravity(81, 0, 200);
        toast.setDuration(0);
        toast.setView(inflate);
        toast.show();
    }

    public static void sharePictureToChannel(Activity activity, String str, String str2, String str3) {
        initShareChannel(activity, str);
        IMSDKFriendReqInfo iMSDKFriendReqInfo = new IMSDKFriendReqInfo();
        iMSDKFriendReqInfo.type = 5;
        iMSDKFriendReqInfo.link = str3;
        iMSDKFriendReqInfo.title = str2;
        IMSDKFriend.share(iMSDKFriendReqInfo, new IMSDKResultListener<IMSDKResult>() { // from class: com.tencent.imsdk.android.webview.qq.ShareManager.2
            @Override // com.tencent.imsdk.android.api.IMSDKResultListener
            public void onResult(IMSDKResult iMSDKResult) {
                try {
                    IMLogger.json(iMSDKResult.toJSONString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Object[0]);
    }
}
