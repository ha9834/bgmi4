package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.n;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class f extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    g f235a;
    private int b = -1;
    private boolean c;
    private final boolean d;
    private final LayoutInflater e;
    private final int f;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public f(g gVar, LayoutInflater layoutInflater, boolean z, int i) {
        this.d = z;
        this.e = layoutInflater;
        this.f235a = gVar;
        this.f = i;
        b();
    }

    public void a(boolean z) {
        this.c = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<i> m = this.d ? this.f235a.m() : this.f235a.j();
        if (this.b < 0) {
            return m.size();
        }
        return m.size() - 1;
    }

    public g a() {
        return this.f235a;
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public i getItem(int i) {
        ArrayList<i> m = this.d ? this.f235a.m() : this.f235a.j();
        int i2 = this.b;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return m.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.e.inflate(this.f, viewGroup, false);
        }
        int groupId = getItem(i).getGroupId();
        int i2 = i - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f235a.b() && groupId != (i2 >= 0 ? getItem(i2).getGroupId() : groupId));
        n.a aVar = (n.a) view;
        if (this.c) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.a(getItem(i), 0);
        return view;
    }

    void b() {
        i s = this.f235a.s();
        if (s != null) {
            ArrayList<i> m = this.f235a.m();
            int size = m.size();
            for (int i = 0; i < size; i++) {
                if (m.get(i) == s) {
                    this.b = i;
                    return;
                }
            }
        }
        this.b = -1;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        b();
        super.notifyDataSetChanged();
    }
}
