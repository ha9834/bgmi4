package androidx.core.f;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

/* loaded from: classes.dex */
public final class h {

    @Deprecated
    /* loaded from: classes.dex */
    public interface a {
        boolean onMenuItemActionCollapse(MenuItem menuItem);

        boolean onMenuItemActionExpand(MenuItem menuItem);
    }

    @Deprecated
    public static View a(MenuItem menuItem) {
        return menuItem.getActionView();
    }

    public static MenuItem a(MenuItem menuItem, b bVar) {
        if (menuItem instanceof androidx.core.a.a.b) {
            return ((androidx.core.a.a.b) menuItem).a(bVar);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    @Deprecated
    public static boolean b(MenuItem menuItem) {
        return menuItem.expandActionView();
    }

    @Deprecated
    public static boolean c(MenuItem menuItem) {
        return menuItem.collapseActionView();
    }

    @Deprecated
    public static boolean d(MenuItem menuItem) {
        return menuItem.isActionViewExpanded();
    }

    @Deprecated
    public static MenuItem a(MenuItem menuItem, final a aVar) {
        return menuItem.setOnActionExpandListener(new MenuItem.OnActionExpandListener() { // from class: androidx.core.f.h.1
            @Override // android.view.MenuItem.OnActionExpandListener
            public boolean onMenuItemActionExpand(MenuItem menuItem2) {
                return a.this.onMenuItemActionExpand(menuItem2);
            }

            @Override // android.view.MenuItem.OnActionExpandListener
            public boolean onMenuItemActionCollapse(MenuItem menuItem2) {
                return a.this.onMenuItemActionCollapse(menuItem2);
            }
        });
    }

    public static void a(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof androidx.core.a.a.b) {
            ((androidx.core.a.a.b) menuItem).a(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setContentDescription(charSequence);
        }
    }

    public static void b(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof androidx.core.a.a.b) {
            ((androidx.core.a.a.b) menuItem).b(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setTooltipText(charSequence);
        }
    }

    public static void a(MenuItem menuItem, char c, int i) {
        if (menuItem instanceof androidx.core.a.a.b) {
            ((androidx.core.a.a.b) menuItem).setNumericShortcut(c, i);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setNumericShortcut(c, i);
        }
    }

    public static void b(MenuItem menuItem, char c, int i) {
        if (menuItem instanceof androidx.core.a.a.b) {
            ((androidx.core.a.a.b) menuItem).setAlphabeticShortcut(c, i);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setAlphabeticShortcut(c, i);
        }
    }

    public static void a(MenuItem menuItem, ColorStateList colorStateList) {
        if (menuItem instanceof androidx.core.a.a.b) {
            ((androidx.core.a.a.b) menuItem).setIconTintList(colorStateList);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setIconTintList(colorStateList);
        }
    }

    public static void a(MenuItem menuItem, PorterDuff.Mode mode) {
        if (menuItem instanceof androidx.core.a.a.b) {
            ((androidx.core.a.a.b) menuItem).setIconTintMode(mode);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setIconTintMode(mode);
        }
    }
}
