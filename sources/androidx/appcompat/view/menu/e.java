package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class e implements AdapterView.OnItemClickListener, m {

    /* renamed from: a, reason: collision with root package name */
    Context f233a;
    LayoutInflater b;
    g c;
    ExpandedMenuView d;
    int e;
    int f;
    int g;
    a h;
    private m.a i;
    private int j;

    @Override // androidx.appcompat.view.menu.m
    public boolean a(g gVar, i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean b() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean b(g gVar, i iVar) {
        return false;
    }

    public e(Context context, int i) {
        this(i, 0);
        this.f233a = context;
        this.b = LayoutInflater.from(this.f233a);
    }

    public e(int i, int i2) {
        this.g = i;
        this.f = i2;
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(Context context, g gVar) {
        int i = this.f;
        if (i != 0) {
            this.f233a = new ContextThemeWrapper(context, i);
            this.b = LayoutInflater.from(this.f233a);
        } else if (this.f233a != null) {
            this.f233a = context;
            if (this.b == null) {
                this.b = LayoutInflater.from(this.f233a);
            }
        }
        this.c = gVar;
        a aVar = this.h;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public n a(ViewGroup viewGroup) {
        if (this.d == null) {
            this.d = (ExpandedMenuView) this.b.inflate(a.g.abc_expanded_menu_layout, viewGroup, false);
            if (this.h == null) {
                this.h = new a();
            }
            this.d.setAdapter((ListAdapter) this.h);
            this.d.setOnItemClickListener(this);
        }
        return this.d;
    }

    public ListAdapter a() {
        if (this.h == null) {
            this.h = new a();
        }
        return this.h;
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(boolean z) {
        a aVar = this.h;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(m.a aVar) {
        this.i = aVar;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean a(r rVar) {
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        new h(rVar).a((IBinder) null);
        m.a aVar = this.i;
        if (aVar == null) {
            return true;
        }
        aVar.a(rVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(g gVar, boolean z) {
        m.a aVar = this.i;
        if (aVar != null) {
            aVar.a(gVar, z);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.c.a(this.h.getItem(i), this, 0);
    }

    public void a(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        ExpandedMenuView expandedMenuView = this.d;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
    }

    public void b(Bundle bundle) {
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.d.restoreHierarchyState(sparseParcelableArray);
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public int c() {
        return this.j;
    }

    @Override // androidx.appcompat.view.menu.m
    public Parcelable f() {
        if (this.d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        a(bundle);
        return bundle;
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(Parcelable parcelable) {
        b((Bundle) parcelable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private int b = -1;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        public a() {
            a();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = e.this.c.m().size() - e.this.e;
            return this.b < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public i getItem(int i) {
            ArrayList<i> m = e.this.c.m();
            int i2 = i + e.this.e;
            int i3 = this.b;
            if (i3 >= 0 && i2 >= i3) {
                i2++;
            }
            return m.get(i2);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = e.this.b.inflate(e.this.g, viewGroup, false);
            }
            ((n.a) view).a(getItem(i), 0);
            return view;
        }

        void a() {
            i s = e.this.c.s();
            if (s != null) {
                ArrayList<i> m = e.this.c.m();
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
            a();
            super.notifyDataSetChanged();
        }
    }
}
