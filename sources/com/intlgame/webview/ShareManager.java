package com.intlgame.webview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.drive.DriveFile;
import com.intlgame.api.compliance.R;
import com.intlgame.foundation.EmptyUtils;
import com.intlgame.foundation.INTLLog;
import com.intlgame.webview.ShareAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes2.dex */
public class ShareManager {
    private static final String FORMAT_SHARE_NAME = "intl_webview_share_%s";
    public static final String NAME_SHARE_BROWSER = "Browser";
    public static final String NAME_SHARE_FACEBOOK = "Facebook";
    private static final int TOAST_POSITION_X = 0;
    private static final int TOAST_POSITION_Y = 200;
    public static final String WEBVIEW_URL_KEY_FILTER = "WEBVIEW_URL_KEY_FILTER";
    private static List<String> userAuthKeywords;

    private static int getStringId(Context context, String str) {
        int stringId = ResourceUtil.getStringId(context, str);
        return stringId != 0 ? stringId : R.string.intl_webview_share_browser;
    }

    private static int getDrawableId(Context context, String str) {
        int drawableId = ResourceUtil.getDrawableId(context, str);
        return drawableId != 0 ? drawableId : R.drawable.intl_webview_share_otherbrowser;
    }

    public static List<ShareAdapter.ItemData> getShareListData(Context context, String str) {
        ArrayList arrayList = new ArrayList();
        INTLLog.i("configShareChannel = " + str);
        if (!EmptyUtils.isNonEmpty(str)) {
            INTLLog.i("no INTL_WEBVIEW_SHARE_CHANNEL config in INTLConfig.ini");
        }
        for (String str2 : str.split(",")) {
            String trim = str2.trim();
            char c = 65535;
            if (trim.hashCode() == 561774310 && trim.equals("Facebook")) {
                c = 0;
            }
            if (c == 0) {
                arrayList.add(new ShareAdapter.ItemData("Facebook", true));
            }
        }
        arrayList.add(new ShareAdapter.ItemData(NAME_SHARE_BROWSER));
        INTLLog.i("shareDataList = " + arrayList.toString());
        for (int i = 0; i < arrayList.size(); i++) {
            try {
                ShareAdapter.ItemData itemData = (ShareAdapter.ItemData) arrayList.get(i);
                String format = String.format(FORMAT_SHARE_NAME, itemData.channel.toLowerCase(Locale.US));
                int stringId = getStringId(context, format);
                if (stringId <= 0) {
                    INTLLog.i("no " + format + " string found in resource files");
                } else {
                    int drawableId = getDrawableId(context, format);
                    if (drawableId <= 0) {
                        INTLLog.i("no " + format + " png found in resource files");
                    } else {
                        itemData.shareTitleResId = stringId;
                        itemData.shareIconResId = drawableId;
                        arrayList.set(i, itemData);
                    }
                }
            } catch (Exception e) {
                INTLLog.e("add share channel error : " + e.getMessage());
            }
        }
        return arrayList;
    }

    public static void shareToBrowser(Context context, String str, boolean z) {
        INTLLog.i("shareToBrowser url = " + str);
        if (str == null || str.isEmpty()) {
            INTLLog.e("cannot share illegal URL to browser, url is empty or null");
            return;
        }
        if (str.startsWith("file://")) {
            INTLLog.e("not allow to share illegal URL begins with \"file://\"");
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.BROWSABLE");
        if (z) {
            str = WebViewCommonUtil.getDecodeURL(str);
        }
        intent.setData(Uri.parse(str));
        intent.setFlags(DriveFile.MODE_READ_ONLY);
        context.startActivity(intent);
    }

    private static void initUserAuthKeyword() {
        try {
            if (userAuthKeywords != null) {
                return;
            }
            userAuthKeywords = new ArrayList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String deleteUserAuthInfoFromUrl(String str) {
        int indexOf;
        String queryParameter;
        initUserAuthKeyword();
        if (userAuthKeywords.size() > 0) {
            try {
                Uri parse = Uri.parse(str);
                Set<String> queryParameterNames = parse.getQueryParameterNames();
                if (queryParameterNames.size() > 0 && (indexOf = str.indexOf("?")) > 0 && indexOf != str.length() - 1) {
                    String substring = str.substring(0, indexOf + 1);
                    StringBuilder sb = new StringBuilder(substring);
                    boolean z = true;
                    for (String str2 : queryParameterNames) {
                        if (str2 != null && str2.trim().length() != 0 && (queryParameter = parse.getQueryParameter(str2)) != null && queryParameter.trim().length() != 0 && !userAuthKeywords.contains(str2.toLowerCase())) {
                            if (z) {
                                z = false;
                            } else {
                                sb.append("&");
                            }
                            sb.append(str2);
                            sb.append("=");
                            sb.append(queryParameter);
                        }
                    }
                    String sb2 = sb.toString();
                    return (sb2.equals(substring) && sb2.endsWith("?")) ? sb2.substring(0, sb2.length() - 1) : sb2;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    public static void showToast(Context context, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.intl_webvidw_share_toast, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.toast_title);
        if (textView != null) {
            if (i == 0) {
                textView.setText(context.getString(R.string.share_success));
            } else if (i == 2) {
                textView.setText(context.getString(R.string.share_cancel));
            } else {
                textView.setText(context.getString(R.string.share_failure));
            }
            Toast toast = new Toast(context);
            toast.setGravity(81, 0, 200);
            toast.setDuration(0);
            toast.setView(inflate);
            toast.show();
        }
    }

    private static String filterUrlParaKey(String str, List<String> list) {
        INTLLog.i("filterUrlParaKey -|- origin url = " + str + ", keyArray = " + list);
        if (!EmptyUtils.isNonEmpty(str) || !str.contains("?") || list.size() == 0) {
            INTLLog.i("filterUrlParaKey -|- do not need process!");
            return str;
        }
        String substring = str.substring(str.indexOf("?") + 1);
        String substring2 = str.substring(0, str.indexOf("?"));
        String[] split = substring.split("&");
        ArrayList arrayList = new ArrayList();
        for (String str2 : split) {
            arrayList.add(str2);
        }
        INTLLog.i("filterUrlParaKey -|- paraList start = " + arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            if (list.contains(str3.substring(0, str3.indexOf("=")))) {
                it.remove();
            }
        }
        INTLLog.i("filterUrlParaKey -|- paraList end = " + arrayList);
        StringBuilder sb = new StringBuilder();
        if (arrayList.size() > 0) {
            String str4 = substring2 + "?";
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append((String) arrayList.get(i));
                sb.append("&");
            }
            String str5 = str4 + sb.toString();
            substring2 = str5.substring(0, str5.lastIndexOf("&"));
        }
        INTLLog.i("filterUrlParaKey -|- target url = " + substring2);
        return substring2;
    }
}
