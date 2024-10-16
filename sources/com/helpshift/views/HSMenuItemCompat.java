package com.helpshift.views;

import android.view.MenuItem;
import android.view.View;
import androidx.core.f.h;
import com.helpshift.util.ApplicationUtil;
import com.helpshift.util.HSLogger;
import com.helpshift.util.HelpshiftContext;

/* loaded from: classes2.dex */
public class HSMenuItemCompat {
    public static <T extends MenuItem.OnActionExpandListener & h.a> void setOnActionExpandListener(MenuItem menuItem, T t) {
        if (ApplicationUtil.isSupportLibVersionEqualAndAbove(HelpshiftContext.getApplicationContext(), 26)) {
            try {
                menuItem.setOnActionExpandListener(t);
                return;
            } catch (UnsupportedOperationException e) {
                HSLogger.e("HSMenuItemCompat", "Exception thrown while calling MenuItem#setOnActionExpandListener: ", e);
                h.a(menuItem, t);
                return;
            }
        }
        h.a(menuItem, t);
    }

    public static View getActionView(MenuItem menuItem) {
        if (ApplicationUtil.isSupportLibVersionEqualAndAbove(HelpshiftContext.getApplicationContext(), 26)) {
            return menuItem.getActionView();
        }
        return h.a(menuItem);
    }

    public static boolean isActionViewExpanded(MenuItem menuItem) {
        if (ApplicationUtil.isSupportLibVersionEqualAndAbove(HelpshiftContext.getApplicationContext(), 26)) {
            return menuItem.isActionViewExpanded();
        }
        return h.d(menuItem);
    }

    public static void collapseActionView(MenuItem menuItem) {
        if (ApplicationUtil.isSupportLibVersionEqualAndAbove(HelpshiftContext.getApplicationContext(), 26)) {
            menuItem.collapseActionView();
        } else {
            h.c(menuItem);
        }
    }

    public static void expandActionView(MenuItem menuItem) {
        if (ApplicationUtil.isSupportLibVersionEqualAndAbove(HelpshiftContext.getApplicationContext(), 26)) {
            menuItem.expandActionView();
        } else {
            h.b(menuItem);
        }
    }
}
