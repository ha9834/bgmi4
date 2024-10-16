package com.intlgame.webview;

import android.content.Context;
import android.content.res.Resources;
import com.intlgame.tools.IT;
import com.tencent.mtt.spcialcall.sdk.MttApi;

/* loaded from: classes2.dex */
public class WebViewResID {
    public static int anim_titlebar_hide;
    public static int anim_titlebar_show;
    public static int anim_toolbar_hide;
    public static int anim_toolbar_show;
    public static int back;
    public static int backUnclickable;
    public static int color_toolbar_invisible;
    public static int color_toolbar_visible;
    public static int dimen_fling_limit_x;
    public static int dimen_fling_limit_y;
    public static int dimen_titlebar_height;
    public static int drawable_open_by_otherbrowser;
    public static int forward;
    public static int forwardUnclickable;
    public static int land_more;
    public static int layout_share_item;
    public static int layout_webview_activity;
    public static int more;
    public static int playout;
    public static int refresh;
    public static int return_app;
    public static int stop;
    public static int str_cancel;
    public static int str_confirm;
    public static int str_openbrowser;
    public static int str_untitle_share;
    public static int str_upload_file_title;
    public static int titleBar;
    public static int toolbar;
    public static int webTitle;
    public static int webViewFrameLayout;

    public static void init(Context context) {
        String packageName = context.getPackageName();
        Resources resources = context.getResources();
        layout_webview_activity = IT.loadIdByResource(resources, "intl_webview_activity", "layout", packageName);
        playout = IT.loadIdByResource(resources, "playout", "id", packageName);
        webViewFrameLayout = IT.loadIdByResource(resources, "webview_framelayout", "id", packageName);
        webTitle = IT.loadIdByResource(resources, "webTitle", "id", packageName);
        refresh = IT.loadIdByResource(resources, "refresh", "id", packageName);
        stop = IT.loadIdByResource(resources, "stop", "id", packageName);
        back = IT.loadIdByResource(resources, "back", "id", packageName);
        backUnclickable = IT.loadIdByResource(resources, "backUnclickable", "id", packageName);
        forward = IT.loadIdByResource(resources, "forward", "id", packageName);
        forwardUnclickable = IT.loadIdByResource(resources, "forwardUnclickable", "id", packageName);
        return_app = IT.loadIdByResource(resources, "return_app", "id", packageName);
        more = IT.loadIdByResource(resources, "more", "id", packageName);
        titleBar = IT.loadIdByResource(resources, "titlebar", "id", packageName);
        toolbar = IT.loadIdByResource(resources, "toolbar", "id", packageName);
        land_more = IT.loadIdByResource(resources, "landMore", "id", packageName);
        drawable_open_by_otherbrowser = IT.loadIdByResource(resources, "intl_webview_share_otherbrowser", "drawable", packageName);
        str_confirm = IT.loadIdByResource(resources, "confirm", "string", packageName);
        str_cancel = IT.loadIdByResource(resources, "cancel", "string", packageName);
        str_openbrowser = IT.loadIdByResource(resources, "openbrowser", "string", packageName);
        str_upload_file_title = IT.loadIdByResource(resources, "intl_upload_file_title", "string", packageName);
        str_untitle_share = IT.loadIdByResource(resources, "intl_untitle_share", "string", packageName);
        color_toolbar_visible = IT.loadIdByResource(resources, "intl_webview_toolbar_visible", "color", packageName);
        color_toolbar_invisible = IT.loadIdByResource(resources, "intl_webview_toolbar_invisible", "color", packageName);
        dimen_titlebar_height = IT.loadIdByResource(resources, MttApi.TITLEBAR_HEIGHT, "dimen", packageName);
        dimen_fling_limit_x = IT.loadIdByResource(resources, "fling_limit_x", "dimen", packageName);
        dimen_fling_limit_y = IT.loadIdByResource(resources, "fling_limit_y", "dimen", packageName);
        anim_toolbar_hide = IT.loadIdByResource(resources, "intl_webview_anim_toolbar_hide", "anim", packageName);
        anim_toolbar_show = IT.loadIdByResource(resources, "intl_webview_anim_toolbar_show", "anim", packageName);
        anim_titlebar_hide = IT.loadIdByResource(resources, "intl_webview_anim_titlebar_hide", "anim", packageName);
        anim_titlebar_show = IT.loadIdByResource(resources, "intl_webview_anim_titlebar_show", "anim", packageName);
        layout_share_item = IT.loadIdByResource(resources, "intl_webview_share_item", "layout", packageName);
    }
}
