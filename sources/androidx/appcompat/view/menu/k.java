package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class k implements AdapterView.OnItemClickListener, m, p {

    /* renamed from: a, reason: collision with root package name */
    private Rect f244a;

    public abstract void a(int i);

    @Override // androidx.appcompat.view.menu.m
    public void a(Context context, g gVar) {
    }

    public abstract void a(View view);

    public abstract void a(PopupWindow.OnDismissListener onDismissListener);

    public abstract void a(g gVar);

    @Override // androidx.appcompat.view.menu.m
    public boolean a(g gVar, i iVar) {
        return false;
    }

    public abstract void b(int i);

    public abstract void b(boolean z);

    @Override // androidx.appcompat.view.menu.m
    public boolean b(g gVar, i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public int c() {
        return 0;
    }

    public abstract void c(int i);

    public abstract void c(boolean z);

    protected boolean h() {
        return true;
    }

    public void a(Rect rect) {
        this.f244a = rect;
    }

    public Rect i() {
        return this.f244a;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        a(listAdapter).f235a.a((MenuItem) listAdapter.getItem(i), this, h() ? 0 : 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int a(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        ViewGroup viewGroup2 = viewGroup;
        View view = null;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < count; i4++) {
            int itemViewType = listAdapter.getItemViewType(i4);
            if (itemViewType != i3) {
                view = null;
                i3 = itemViewType;
            }
            if (viewGroup2 == null) {
                viewGroup2 = new FrameLayout(context);
            }
            view = listAdapter.getView(i4, view, viewGroup2);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i) {
                return i;
            }
            if (measuredWidth > i2) {
                i2 = measuredWidth;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static f a(ListAdapter listAdapter) {
        if (listAdapter instanceof HeaderViewListAdapter) {
            return (f) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
        }
        return (f) listAdapter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean b(g gVar) {
        int size = gVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = gVar.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }
}
