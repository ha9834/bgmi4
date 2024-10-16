package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.f.b;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class j extends androidx.appcompat.view.menu.c implements MenuItem {
    private final androidx.core.a.a.b b;
    private Method c;

    public j(Context context, androidx.core.a.a.b bVar) {
        super(context);
        if (bVar == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.b = bVar;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.b.getItemId();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.b.getGroupId();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.b.getOrder();
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.b.setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        this.b.setTitle(i);
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.b.getTitle();
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.b.setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.b.getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.b.setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.b.setIcon(i);
        return this;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.b.getIcon();
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.b.setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.b.getIntent();
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3) {
        this.b.setShortcut(c2, c3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3, int i, int i2) {
        this.b.setShortcut(c2, c3, i, i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        this.b.setNumericShortcut(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2, int i) {
        this.b.setNumericShortcut(c2, i);
        return this;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.b.getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.b.getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        this.b.setAlphabeticShortcut(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2, int i) {
        this.b.setAlphabeticShortcut(c2, i);
        return this;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.b.getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.b.getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        this.b.setCheckable(z);
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return this.b.isCheckable();
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        this.b.setChecked(z);
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return this.b.isChecked();
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        return this.b.setVisible(z);
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return this.b.isVisible();
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        this.b.setEnabled(z);
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return this.b.isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.b.hasSubMenu();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return a(this.b.getSubMenu());
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.b.setOnMenuItemClickListener(onMenuItemClickListener != null ? new e(onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.b.getMenuInfo();
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i) {
        this.b.setShowAsAction(i);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i) {
        this.b.setShowAsActionFlags(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new c(view);
        }
        this.b.setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i) {
        this.b.setActionView(i);
        View actionView = this.b.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.b.setActionView(new c(actionView));
        }
        return this;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View actionView = this.b.getActionView();
        return actionView instanceof c ? ((c) actionView).a() : actionView;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        androidx.core.f.b aVar;
        if (Build.VERSION.SDK_INT >= 16) {
            aVar = new b(this.f226a, actionProvider);
        } else {
            aVar = new a(this.f226a, actionProvider);
        }
        androidx.core.a.a.b bVar = this.b;
        if (actionProvider == null) {
            aVar = null;
        }
        bVar.a(aVar);
        return this;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        androidx.core.f.b a2 = this.b.a();
        if (a2 instanceof a) {
            return ((a) a2).f240a;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return this.b.expandActionView();
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return this.b.collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.b.isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.b.setOnActionExpandListener(onActionExpandListener != null ? new d(onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence charSequence) {
        this.b.setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.b.getContentDescription();
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence charSequence) {
        this.b.setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.b.getTooltipText();
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.b.setIconTintList(colorStateList);
        return this;
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.b.getIconTintList();
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.b.setIconTintMode(mode);
        return this;
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.b.getIconTintMode();
    }

    public void a(boolean z) {
        try {
            if (this.c == null) {
                this.c = this.b.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.c.invoke(this.b, Boolean.valueOf(z));
        } catch (Exception e2) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e2);
        }
    }

    /* loaded from: classes.dex */
    private class e implements MenuItem.OnMenuItemClickListener {
        private final MenuItem.OnMenuItemClickListener b;

        e(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.b = onMenuItemClickListener;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.b.onMenuItemClick(j.this.a(menuItem));
        }
    }

    /* loaded from: classes.dex */
    private class d implements MenuItem.OnActionExpandListener {
        private final MenuItem.OnActionExpandListener b;

        d(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.b = onActionExpandListener;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.b.onMenuItemActionExpand(j.this.a(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.b.onMenuItemActionCollapse(j.this.a(menuItem));
        }
    }

    /* loaded from: classes.dex */
    private class a extends androidx.core.f.b {

        /* renamed from: a, reason: collision with root package name */
        final ActionProvider f240a;

        a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f240a = actionProvider;
        }

        @Override // androidx.core.f.b
        public View a() {
            return this.f240a.onCreateActionView();
        }

        @Override // androidx.core.f.b
        public boolean b() {
            return this.f240a.onPerformDefaultAction();
        }

        @Override // androidx.core.f.b
        public boolean c() {
            return this.f240a.hasSubMenu();
        }

        @Override // androidx.core.f.b
        public void a(SubMenu subMenu) {
            this.f240a.onPrepareSubMenu(j.this.a(subMenu));
        }
    }

    /* loaded from: classes.dex */
    private class b extends a implements ActionProvider.VisibilityListener {
        private b.InterfaceC0049b d;

        b(Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // androidx.core.f.b
        public View a(MenuItem menuItem) {
            return this.f240a.onCreateActionView(menuItem);
        }

        @Override // androidx.core.f.b
        public boolean d() {
            return this.f240a.overridesItemVisibility();
        }

        @Override // androidx.core.f.b
        public boolean e() {
            return this.f240a.isVisible();
        }

        @Override // androidx.core.f.b
        public void a(b.InterfaceC0049b interfaceC0049b) {
            this.d = interfaceC0049b;
            this.f240a.setVisibilityListener(interfaceC0049b != null ? this : null);
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z) {
            b.InterfaceC0049b interfaceC0049b = this.d;
            if (interfaceC0049b != null) {
                interfaceC0049b.a(z);
            }
        }
    }

    /* loaded from: classes.dex */
    static class c extends FrameLayout implements androidx.appcompat.view.c {

        /* renamed from: a, reason: collision with root package name */
        final CollapsibleActionView f241a;

        /* JADX WARN: Multi-variable type inference failed */
        c(View view) {
            super(view.getContext());
            this.f241a = (CollapsibleActionView) view;
            addView(view);
        }

        @Override // androidx.appcompat.view.c
        public void onActionViewExpanded() {
            this.f241a.onActionViewExpanded();
        }

        @Override // androidx.appcompat.view.c
        public void onActionViewCollapsed() {
            this.f241a.onActionViewCollapsed();
        }

        View a() {
            return (View) this.f241a;
        }
    }
}
