package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.au;

/* loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements AdapterView.OnItemClickListener, g.b, n {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f222a = {R.attr.background, R.attr.divider};
    private g b;
    private int c;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        au a2 = au.a(context, attributeSet, f222a, i, 0);
        if (a2.g(0)) {
            setBackgroundDrawable(a2.a(0));
        }
        if (a2.g(1)) {
            setDivider(a2.a(1));
        }
        a2.a();
    }

    @Override // androidx.appcompat.view.menu.n
    public void a(g gVar) {
        this.b = gVar;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // androidx.appcompat.view.menu.g.b
    public boolean a(i iVar) {
        return this.b.a(iVar, 0);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        a((i) getAdapter().getItem(i));
    }

    public int getWindowAnimations() {
        return this.c;
    }
}
