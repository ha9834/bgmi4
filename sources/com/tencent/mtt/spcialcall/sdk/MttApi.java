package com.tencent.mtt.spcialcall.sdk;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import com.tencent.imsdk.android.IR;
import com.tencent.mtt.spcialcall.WebViewProxyManager;
import com.tencent.smtt.sdk.TbsConfig;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class MttApi {
    public static final String BOOKMARK_ITEMS = "bookmarkItems";
    public static final String CHANNELID = "";
    public static final String CID_MQQ_PUB_ACCOUNT = "10299";
    public static final String DISPLAY_TYPE = "display_type";
    public static final String DOWNLOAD_ITEMS = "downloadItems";
    public static final String DOWNLOAD_RSP = "downloadRsp";
    public static final String FAV_ITEMS = "favItems";
    public static final int FROM_AIO = 1;
    public static final int FROM_LEBA = 3;
    public static final int FROM_PUB_ACCOUNT = 4;
    public static final int FROM_QZONE = 2;
    public static final String FROM_TYPE = "from";
    public static final String FUNC_BOOKMARK = "func_bookmark";
    public static final String FUNC_BROWSER = "func_browser";
    public static final String FUNC_COPYLINK = "func_copylink";
    public static final String FUNC_FAV = "func_fav";
    public static final String FUNC_MTT = "func_mtt";
    public static final String FUNC_READMODE = "func_readmode";
    public static final String FUNC_RESTORE = "func_restore";
    public static final String FUNC_SHARE = "func_share";
    public static final String FUNC_TITLE = "func_title";
    public static final String FUNC_TITLE_MUTABLE = "func_title_mutable";
    public static final String FUNC_WEBAPP = "func_hide_toolbar";
    public static final int MENU_ACTION_SHEET = 1;
    public static final int MENU_POP_UP = 0;
    public static final String MENU_STYLE = "menu_style";
    public static final String MORE_ITEMS = "moreItems";
    public static final String MORE_RSP = "moreRsp";
    public static final String MTT_ACTION_LIGHTAPPP = "com.tencent.QQBrowser.action.LIGHTAPP";
    public static final String MTT_ACTION_LITE = "com.tencent.QQBrowser.action.VIEWLITE";
    public static final String MTT_ACTION_SP = "com.tencent.QQBrowser.action.VIEWSP";
    private static final String MTT_SIG = "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a";
    public static final String ORIPKG = "oriPackage";
    public static final String PLUS_ITEMS = "plusItems";
    public static final String PLUS_RSP = "plusRsp";
    public static final String POST_DATA = "post_data";
    public static final int RESULT_LITECORE_STATE = 431;
    public static final int RESULT_SHARE_RSP = 4302;
    public static final int RESULT_X5CORE_FAIL = 4301;
    public static final int RESULT_X5CORE_STATE = 430;
    public static final String SHARE_ITEMS = "shareItems";
    public static final String SHARE_RSP = "shareRsp";
    public static final String THEME_ITEMS = "themeItems";
    public static final String TITLEBAR_HEIGHT = "titlebar_height";
    public static final String TITLE_ITEMS = "title_items";
    public static final String TOOLBAR_HEIGTH = "toolbar_heigth";
    public static final int TYPE_FULLSCREEN = 1;
    public static final int TYPE_NO_TITLEBAR = 0;
    public static final String WEBVIEW_ID = "webview_id";
    public static final String WHITELIST_PATTERN = "whitelist_pattern";
    static Intent intent = new Intent();

    public static WebViewProxy createWebViewProxy(Activity activity) {
        return WebViewProxyManager.getInstance().create(activity);
    }

    @Deprecated
    public static boolean loadUrlInMbWnd(Activity activity, String str, byte[] bArr) {
        intent.setAction("com.tencent.QQBrowser.action.VIEWSP");
        intent.setData(Uri.parse(str));
        Bundle extras = intent.getExtras();
        if (extras != null && (extras.containsKey(IR.unifiedAccount.UNIFIED_ACCOUNT_SESSION_ID) || extras.containsKey("skey"))) {
            try {
                if (!activity.getPackageManager().getPackageInfo(TbsConfig.APP_QB, 64).signatures[0].toCharsString().equals(MTT_SIG)) {
                    return false;
                }
                intent.setPackage(TbsConfig.APP_QB);
            } catch (Exception unused) {
                return false;
            }
        } else {
            intent.setPackage(null);
        }
        intent.putExtra(POST_DATA, bArr);
        intent.putExtra(ORIPKG, activity.getPackageName());
        try {
            activity.startActivityForResult(intent, RESULT_X5CORE_STATE);
            return true;
        } catch (Exception unused2) {
            return false;
        }
    }

    @Deprecated
    public static boolean loadUrlInLiteMbWnd(Activity activity, String str, byte[] bArr) {
        intent.setAction(MTT_ACTION_LITE);
        intent.setData(Uri.parse(str));
        intent.putExtra(POST_DATA, bArr);
        intent.setPackage(activity.getPackageName());
        intent.putExtra(ORIPKG, activity.getPackageName());
        try {
            activity.startActivityForResult(intent, RESULT_LITECORE_STATE);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Deprecated
    public static boolean loadUrlInMbWnd(Activity activity, String str) {
        return loadUrlInMbWnd(activity, str, null);
    }

    @Deprecated
    public static boolean loadUrlInLiteMbWnd(Activity activity, String str) {
        return loadUrlInLiteMbWnd(activity, str, null);
    }

    @Deprecated
    public static int loadUrlInMttWnd(Activity activity, String str, HashMap<String, String> hashMap) {
        return MttLoader.loadUrl(activity, str, hashMap);
    }

    public static boolean isSpecialCallRsp(Intent intent2) {
        if (intent2 != null) {
            return (intent2.getSerializableExtra(SHARE_RSP) == null && intent2.getSerializableExtra(MORE_RSP) == null && intent2.getSerializableExtra(PLUS_RSP) == null && intent2.getSerializableExtra(DOWNLOAD_RSP) == null) ? false : true;
        }
        return false;
    }

    public static RspContent parseResponse(Intent intent2) {
        if (!isSpecialCallRsp(intent2)) {
            return null;
        }
        if (intent2.getSerializableExtra(SHARE_RSP) != null) {
            return (RspContent) intent2.getSerializableExtra(SHARE_RSP);
        }
        if (intent2.getSerializableExtra(MORE_RSP) != null) {
            return (RspContent) intent2.getSerializableExtra(MORE_RSP);
        }
        if (intent2.getSerializableExtra(PLUS_RSP) != null) {
            return (RspContent) intent2.getSerializableExtra(PLUS_RSP);
        }
        if (intent2.getSerializableExtra(DOWNLOAD_RSP) != null) {
            return (RspContent) intent2.getSerializableExtra(DOWNLOAD_RSP);
        }
        return null;
    }

    public static void setDefaultFunc(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i) {
        intent.putExtra(FUNC_SHARE, z);
        intent.putExtra(FUNC_COPYLINK, z2);
        intent.putExtra(FUNC_MTT, z3);
        intent.putExtra(FUNC_BROWSER, z4);
        intent.putExtra(FUNC_READMODE, z5);
        intent.putExtra(FUNC_BOOKMARK, z6);
        intent.putExtra(FUNC_FAV, z7);
        intent.putExtra(MENU_STYLE, i);
    }

    public static void setTile(String str, boolean z) {
        intent.putExtra(FUNC_TITLE, str);
        intent.putExtra(FUNC_TITLE_MUTABLE, z);
    }

    public static void enableRestore(boolean z) {
        intent.putExtra(FUNC_RESTORE, z);
    }

    public static void setDownloadItem(ExtendItem extendItem) {
        intent.putExtra(DOWNLOAD_ITEMS, extendItem);
    }

    @Deprecated
    public static void setWebAppMod(boolean z) {
        intent.putExtra(FUNC_WEBAPP, z);
    }

    public static void setDisplayMode(int i) {
        intent.putExtra(DISPLAY_TYPE, i);
    }

    public static void setTheme(List<ExtendItem> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        intent.putExtra(THEME_ITEMS, (Serializable) list);
    }

    public static void setBarHeight(int i, int i2) {
        if (i != -1) {
            intent.putExtra(TITLEBAR_HEIGHT, i);
        }
        if (i != -1) {
            intent.putExtra(TOOLBAR_HEIGTH, i2);
        }
    }

    public static void setFromType(int i) {
        intent.putExtra("from", i);
    }

    public static int getFromType() {
        return intent.getIntExtra("from", -1);
    }

    public static String getStringExtra(String str) {
        return intent.getStringExtra(str);
    }

    public static void setExtraBundle(Bundle bundle) {
        intent.putExtras(bundle);
    }

    public static void setMoreItem(List<ExtendItem> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        intent.putExtra(MORE_ITEMS, (Serializable) list);
    }

    public static void setShareItem(List<ExtendItem> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        intent.putExtra(SHARE_ITEMS, (Serializable) list);
    }

    public static void setPlusItem(ExtendItem extendItem) {
        intent.putExtra(PLUS_ITEMS, extendItem);
    }

    public static void setFavItem(ExtendItem extendItem) {
        intent.putExtra(FAV_ITEMS, extendItem);
    }

    public static void setBookmarkItem(ExtendItem extendItem) {
        intent.putExtra(BOOKMARK_ITEMS, extendItem);
    }

    public static void setTitleItem(List<ExtendItem> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        intent.putExtra(TITLE_ITEMS, (Serializable) list);
    }

    public static void insertRecommend(WebView webView, RecommendParams recommendParams) {
        recommendParams.put(RecommendParams.BROWSER_VER, new StringBuilder(String.valueOf(MttLoader.getBrowserInfo(webView.getContext()).ver)).toString());
        recommendParams.put("title", webView.getTitle());
        recommendParams.put("url", webView.getUrl());
        try {
            webView.loadUrl("javascript:var insertJsNode=document.getElementById(\"x5insertadnode\");if(null==insertJsNode){insertJsNode=document.createElement('script');insertJsNode.setAttribute('id',\"x5insertadnode\");insertJsNode.setAttribute('charset','gbk');insertJsNode.setAttribute('src',\"" + recommendParams.buildUpon("http://mqqad.html5.qq.com/adjs") + "\");document.body.appendChild(insertJsNode);}");
        } catch (Exception unused) {
        }
    }

    public static void insertRecommend(WebView webView, String str) {
        String str2;
        if (isinValidUrl(webView, str)) {
            return;
        }
        if (MttLoader.isBrowserInstalled(webView.getContext())) {
            str2 = "http://res.imtt.qq.com/mbwebview/open_mtt_hd.txt";
        } else {
            str2 = !TextUtils.isEmpty("") ? "http://res.imtt.qq.com/mbwebview/download_mtt_hd_.txt" : "http://res.imtt.qq.com/mbwebview/download_mtt_hd.txt";
        }
        try {
            webView.loadUrl("javascript:var insertJsNode=document.getElementById(\"x5insertadnode\");if(null==insertJsNode){insertJsNode=document.createElement('script');insertJsNode.setAttribute('id',\"x5insertadnode\");insertJsNode.setAttribute('charset','gbk');insertJsNode.setAttribute('src',\"" + str2 + "\");document.body.appendChild(insertJsNode);}");
        } catch (Exception unused) {
        }
    }

    public static boolean isOpenMttUrl(WebView webView, String str) {
        if (str == null || webView == null || !str.startsWith("mttbrowser://")) {
            return false;
        }
        Intent intent2 = new Intent();
        intent2.setAction("com.tencent.QQBrowser.action.VIEW");
        String url = webView.getUrl();
        if (url == null) {
            return false;
        }
        intent2.setData(Uri.parse(url));
        try {
            webView.getContext().startActivity(intent2);
            return true;
        } catch (Exception unused) {
            webView.loadUrl(MttLoader.QQBROWSER_DOWNLOAD_URL);
            return true;
        }
    }

    private static boolean isinValidUrl(WebView webView, String str) {
        return webView == null || TextUtils.isEmpty(str);
    }

    public static void clearAllData() {
        intent = new Intent();
    }

    public static void setJsWhiteList(String str) {
        intent.putExtra(WHITELIST_PATTERN, str);
    }
}
