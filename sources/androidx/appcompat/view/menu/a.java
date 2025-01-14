package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* loaded from: classes.dex */
public class a implements androidx.core.a.a.b {

    /* renamed from: a, reason: collision with root package name */
    private final int f224a;
    private final int b;
    private final int c;
    private final int d;
    private CharSequence e;
    private CharSequence f;
    private Intent g;
    private char h;
    private char j;
    private Drawable l;
    private Context n;
    private MenuItem.OnMenuItemClickListener o;
    private CharSequence p;
    private CharSequence q;
    private int i = 4096;
    private int k = 4096;
    private int m = 0;
    private ColorStateList r = null;
    private PorterDuff.Mode s = null;
    private boolean t = false;
    private boolean u = false;
    private int v = 16;

    @Override // androidx.core.a.a.b
    public androidx.core.f.b a() {
        return null;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public void setShowAsAction(int i) {
    }

    public a(Context context, int i, int i2, int i3, int i4, CharSequence charSequence) {
        this.n = context;
        this.f224a = i2;
        this.b = i;
        this.c = i3;
        this.d = i4;
        this.e = charSequence;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.j;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.k;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.l;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.g;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f224a;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.h;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.i;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.d;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f;
        return charSequence != null ? charSequence : this.e;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.v & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.v & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.v & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.v & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        this.j = Character.toLowerCase(c);
        return this;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c, int i) {
        this.j = Character.toLowerCase(c);
        this.k = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        this.v = (z ? 1 : 0) | (this.v & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        this.v = (z ? 2 : 0) | (this.v & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        this.v = (z ? 16 : 0) | (this.v & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.l = drawable;
        this.m = 0;
        b();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.m = i;
        this.l = androidx.core.content.a.a(this.n, i);
        b();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        this.h = c;
        return this;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c, int i) {
        this.h = c;
        this.i = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.o = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2) {
        this.h = c;
        this.j = Character.toLowerCase(c2);
        return this;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.h = c;
        this.i = KeyEvent.normalizeMetaState(i);
        this.j = Character.toLowerCase(c2);
        this.k = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.e = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        this.e = this.n.getResources().getString(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        this.v = (this.v & 8) | (z ? 0 : 8);
        return this;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public androidx.core.a.a.b setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public androidx.core.a.a.b setActionView(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.a.a.b
    public androidx.core.a.a.b a(androidx.core.f.b bVar) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public androidx.core.a.a.b setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    /* renamed from: a */
    public androidx.core.a.a.b setContentDescription(CharSequence charSequence) {
        this.p = charSequence;
        return this;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.p;
    }

    @Override // android.view.MenuItem
    /* renamed from: b */
    public androidx.core.a.a.b setTooltipText(CharSequence charSequence) {
        this.q = charSequence;
        return this;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.q;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.r = colorStateList;
        this.t = true;
        b();
        return this;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.r;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.s = mode;
        this.u = true;
        b();
        return this;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.s;
    }

    private void b() {
        if (this.l != null) {
            if (this.t || this.u) {
                this.l = androidx.core.graphics.drawable.a.g(this.l);
                this.l = this.l.mutate();
                if (this.t) {
                    androidx.core.graphics.drawable.a.a(this.l, this.r);
                }
                if (this.u) {
                    androidx.core.graphics.drawable.a.a(this.l, this.s);
                }
            }
        }
    }
}
