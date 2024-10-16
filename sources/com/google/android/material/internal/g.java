package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.r;
import androidx.core.f.v;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.a;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class g implements androidx.appcompat.view.menu.m {

    /* renamed from: a, reason: collision with root package name */
    LinearLayout f5292a;
    androidx.appcompat.view.menu.g b;
    b c;
    LayoutInflater d;
    int e;
    boolean f;
    ColorStateList g;
    ColorStateList h;
    Drawable i;
    int j;
    int k;
    int l;
    final View.OnClickListener m;
    private NavigationMenuView n;
    private m.a o;
    private int p;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface d {
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean a(androidx.appcompat.view.menu.g gVar, androidx.appcompat.view.menu.i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean a(r rVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean b() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean b(androidx.appcompat.view.menu.g gVar, androidx.appcompat.view.menu.i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(Context context, androidx.appcompat.view.menu.g gVar) {
        this.d = LayoutInflater.from(context);
        this.b = gVar;
        this.l = context.getResources().getDimensionPixelOffset(a.d.design_navigation_separator_vertical_padding);
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(boolean z) {
        b bVar = this.c;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(m.a aVar) {
        this.o = aVar;
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(androidx.appcompat.view.menu.g gVar, boolean z) {
        m.a aVar = this.o;
        if (aVar != null) {
            aVar.a(gVar, z);
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public int c() {
        return this.p;
    }

    @Override // androidx.appcompat.view.menu.m
    public Parcelable f() {
        Bundle bundle = new Bundle();
        if (this.n != null) {
            SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
            this.n.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        b bVar = this.c;
        if (bVar != null) {
            bundle.putBundle("android:menu:adapter", bVar.c());
        }
        if (this.f5292a != null) {
            SparseArray<? extends Parcelable> sparseArray2 = new SparseArray<>();
            this.f5292a.saveHierarchyState(sparseArray2);
            bundle.putSparseParcelableArray("android:menu:header", sparseArray2);
        }
        return bundle;
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.n.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                this.c.a(bundle2);
            }
            SparseArray sparseParcelableArray2 = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray2 != null) {
                this.f5292a.restoreHierarchyState(sparseParcelableArray2);
            }
        }
    }

    public void a(androidx.appcompat.view.menu.i iVar) {
        this.c.a(iVar);
    }

    public androidx.appcompat.view.menu.i a() {
        return this.c.b();
    }

    public int d() {
        return this.f5292a.getChildCount();
    }

    public ColorStateList e() {
        return this.h;
    }

    public void a(ColorStateList colorStateList) {
        this.h = colorStateList;
        a(false);
    }

    public ColorStateList g() {
        return this.g;
    }

    public void b(ColorStateList colorStateList) {
        this.g = colorStateList;
        a(false);
    }

    public void a(int i2) {
        this.e = i2;
        this.f = true;
        a(false);
    }

    public Drawable h() {
        return this.i;
    }

    public void a(Drawable drawable) {
        this.i = drawable;
        a(false);
    }

    public int i() {
        return this.j;
    }

    public void b(int i2) {
        this.j = i2;
        a(false);
    }

    public int j() {
        return this.k;
    }

    public void c(int i2) {
        this.k = i2;
        a(false);
    }

    /* loaded from: classes2.dex */
    private static abstract class j extends RecyclerView.w {
        public j(View view) {
            super(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.google.android.material.internal.g$g, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0118g extends j {
        public C0118g(LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(a.h.design_navigation_item, viewGroup, false));
            this.itemView.setOnClickListener(onClickListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class i extends j {
        public i(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(a.h.design_navigation_item_subheader, viewGroup, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class h extends j {
        public h(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(a.h.design_navigation_item_separator, viewGroup, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends j {
        public a(View view) {
            super(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends RecyclerView.a<j> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f5293a;
        private final ArrayList<d> b;
        private androidx.appcompat.view.menu.i c;
        private boolean d;

        @Override // androidx.recyclerview.widget.RecyclerView.a
        public long getItemId(int i) {
            return i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a
        public int getItemCount() {
            return this.b.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a
        public int getItemViewType(int i) {
            d dVar = this.b.get(i);
            if (dVar instanceof e) {
                return 2;
            }
            if (dVar instanceof c) {
                return 3;
            }
            if (dVar instanceof f) {
                return ((f) dVar).a().hasSubMenu() ? 1 : 0;
            }
            throw new RuntimeException("Unknown item type.");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public j onCreateViewHolder(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    return new C0118g(this.f5293a.d, viewGroup, this.f5293a.m);
                case 1:
                    return new i(this.f5293a.d, viewGroup);
                case 2:
                    return new h(this.f5293a.d, viewGroup);
                case 3:
                    return new a(this.f5293a.f5292a);
                default:
                    return null;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(j jVar, int i) {
            switch (getItemViewType(i)) {
                case 0:
                    NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) jVar.itemView;
                    navigationMenuItemView.setIconTintList(this.f5293a.h);
                    if (this.f5293a.f) {
                        navigationMenuItemView.setTextAppearance(this.f5293a.e);
                    }
                    if (this.f5293a.g != null) {
                        navigationMenuItemView.setTextColor(this.f5293a.g);
                    }
                    v.a(navigationMenuItemView, this.f5293a.i != null ? this.f5293a.i.getConstantState().newDrawable() : null);
                    f fVar = (f) this.b.get(i);
                    navigationMenuItemView.setNeedsEmptyIcon(fVar.f5295a);
                    navigationMenuItemView.setHorizontalPadding(this.f5293a.j);
                    navigationMenuItemView.setIconPadding(this.f5293a.k);
                    navigationMenuItemView.a(fVar.a(), 0);
                    return;
                case 1:
                    ((TextView) jVar.itemView).setText(((f) this.b.get(i)).a().getTitle());
                    return;
                case 2:
                    e eVar = (e) this.b.get(i);
                    jVar.itemView.setPadding(0, eVar.a(), 0, eVar.b());
                    return;
                default:
                    return;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onViewRecycled(j jVar) {
            if (jVar instanceof C0118g) {
                ((NavigationMenuItemView) jVar.itemView).b();
            }
        }

        public void a() {
            d();
            notifyDataSetChanged();
        }

        private void d() {
            if (this.d) {
                return;
            }
            this.d = true;
            this.b.clear();
            this.b.add(new c());
            int size = this.f5293a.b.j().size();
            int i = -1;
            boolean z = false;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                androidx.appcompat.view.menu.i iVar = this.f5293a.b.j().get(i3);
                if (iVar.isChecked()) {
                    a(iVar);
                }
                if (iVar.isCheckable()) {
                    iVar.a(false);
                }
                if (iVar.hasSubMenu()) {
                    SubMenu subMenu = iVar.getSubMenu();
                    if (subMenu.hasVisibleItems()) {
                        if (i3 != 0) {
                            this.b.add(new e(this.f5293a.l, 0));
                        }
                        this.b.add(new f(iVar));
                        int size2 = this.b.size();
                        int size3 = subMenu.size();
                        boolean z2 = false;
                        for (int i4 = 0; i4 < size3; i4++) {
                            androidx.appcompat.view.menu.i iVar2 = (androidx.appcompat.view.menu.i) subMenu.getItem(i4);
                            if (iVar2.isVisible()) {
                                if (!z2 && iVar2.getIcon() != null) {
                                    z2 = true;
                                }
                                if (iVar2.isCheckable()) {
                                    iVar2.a(false);
                                }
                                if (iVar.isChecked()) {
                                    a(iVar);
                                }
                                this.b.add(new f(iVar2));
                            }
                        }
                        if (z2) {
                            a(size2, this.b.size());
                        }
                    }
                } else {
                    int groupId = iVar.getGroupId();
                    if (groupId != i) {
                        i2 = this.b.size();
                        boolean z3 = iVar.getIcon() != null;
                        if (i3 != 0) {
                            i2++;
                            this.b.add(new e(this.f5293a.l, this.f5293a.l));
                            z = z3;
                        } else {
                            z = z3;
                        }
                    } else if (!z && iVar.getIcon() != null) {
                        a(i2, this.b.size());
                        z = true;
                    }
                    f fVar = new f(iVar);
                    fVar.f5295a = z;
                    this.b.add(fVar);
                    i = groupId;
                }
            }
            this.d = false;
        }

        private void a(int i, int i2) {
            while (i < i2) {
                ((f) this.b.get(i)).f5295a = true;
                i++;
            }
        }

        public void a(androidx.appcompat.view.menu.i iVar) {
            if (this.c == iVar || !iVar.isCheckable()) {
                return;
            }
            androidx.appcompat.view.menu.i iVar2 = this.c;
            if (iVar2 != null) {
                iVar2.setChecked(false);
            }
            this.c = iVar;
            iVar.setChecked(true);
        }

        public androidx.appcompat.view.menu.i b() {
            return this.c;
        }

        public Bundle c() {
            Bundle bundle = new Bundle();
            androidx.appcompat.view.menu.i iVar = this.c;
            if (iVar != null) {
                bundle.putInt("android:menu:checked", iVar.getItemId());
            }
            SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                d dVar = this.b.get(i);
                if (dVar instanceof f) {
                    androidx.appcompat.view.menu.i a2 = ((f) dVar).a();
                    View actionView = a2 != null ? a2.getActionView() : null;
                    if (actionView != null) {
                        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                        actionView.saveHierarchyState(parcelableSparseArray);
                        sparseArray.put(a2.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
            return bundle;
        }

        public void a(Bundle bundle) {
            androidx.appcompat.view.menu.i a2;
            View actionView;
            ParcelableSparseArray parcelableSparseArray;
            androidx.appcompat.view.menu.i a3;
            int i = bundle.getInt("android:menu:checked", 0);
            if (i != 0) {
                this.d = true;
                int size = this.b.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    d dVar = this.b.get(i2);
                    if ((dVar instanceof f) && (a3 = ((f) dVar).a()) != null && a3.getItemId() == i) {
                        a(a3);
                        break;
                    }
                    i2++;
                }
                this.d = false;
                d();
            }
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:action_views");
            if (sparseParcelableArray != null) {
                int size2 = this.b.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    d dVar2 = this.b.get(i3);
                    if ((dVar2 instanceof f) && (a2 = ((f) dVar2).a()) != null && (actionView = a2.getActionView()) != null && (parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray.get(a2.getItemId())) != null) {
                        actionView.restoreHierarchyState(parcelableSparseArray);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class f implements d {

        /* renamed from: a, reason: collision with root package name */
        boolean f5295a;
        private final androidx.appcompat.view.menu.i b;

        f(androidx.appcompat.view.menu.i iVar) {
            this.b = iVar;
        }

        public androidx.appcompat.view.menu.i a() {
            return this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class e implements d {

        /* renamed from: a, reason: collision with root package name */
        private final int f5294a;
        private final int b;

        public e(int i, int i2) {
            this.f5294a = i;
            this.b = i2;
        }

        public int a() {
            return this.f5294a;
        }

        public int b() {
            return this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class c implements d {
        c() {
        }
    }
}
