package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.f.b;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ActionMenuPresenter extends androidx.appcompat.view.menu.b implements b.a {
    d g;
    e h;
    a i;
    c j;
    final f k;
    int l;
    private Drawable m;
    private boolean n;
    private boolean o;
    private boolean p;
    private int q;
    private int r;
    private int s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private int x;
    private final SparseBooleanArray y;
    private b z;

    public ActionMenuPresenter(Context context) {
        super(context, a.g.abc_action_menu_layout, a.g.abc_action_menu_item_layout);
        this.y = new SparseBooleanArray();
        this.k = new f();
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public void a(Context context, androidx.appcompat.view.menu.g gVar) {
        super.a(context, gVar);
        Resources resources = context.getResources();
        androidx.appcompat.view.a a2 = androidx.appcompat.view.a.a(context);
        if (!this.p) {
            this.o = a2.b();
        }
        if (!this.v) {
            this.q = a2.c();
        }
        if (!this.t) {
            this.s = a2.a();
        }
        int i = this.q;
        if (this.o) {
            if (this.g == null) {
                this.g = new d(this.f225a);
                if (this.n) {
                    this.g.setImageDrawable(this.m);
                    this.m = null;
                    this.n = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.g.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.g.getMeasuredWidth();
        } else {
            this.g = null;
        }
        this.r = i;
        this.x = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    public void a(Configuration configuration) {
        if (!this.t) {
            this.s = androidx.appcompat.view.a.a(this.b).a();
        }
        if (this.c != null) {
            this.c.b(true);
        }
    }

    public void b(boolean z) {
        this.o = z;
        this.p = true;
    }

    public void c(boolean z) {
        this.w = z;
    }

    public void a(Drawable drawable) {
        d dVar = this.g;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
        } else {
            this.n = true;
            this.m = drawable;
        }
    }

    public Drawable d() {
        d dVar = this.g;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.n) {
            return this.m;
        }
        return null;
    }

    @Override // androidx.appcompat.view.menu.b
    public androidx.appcompat.view.menu.n a(ViewGroup viewGroup) {
        androidx.appcompat.view.menu.n nVar = this.f;
        androidx.appcompat.view.menu.n a2 = super.a(viewGroup);
        if (nVar != a2) {
            ((ActionMenuView) a2).setPresenter(this);
        }
        return a2;
    }

    @Override // androidx.appcompat.view.menu.b
    public View a(androidx.appcompat.view.menu.i iVar, View view, ViewGroup viewGroup) {
        View actionView = iVar.getActionView();
        if (actionView == null || iVar.n()) {
            actionView = super.a(iVar, view, viewGroup);
        }
        actionView.setVisibility(iVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.b
    public void a(androidx.appcompat.view.menu.i iVar, n.a aVar) {
        aVar.a(iVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f);
        if (this.z == null) {
            this.z = new b();
        }
        actionMenuItemView.setPopupCallback(this.z);
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean a(int i, androidx.appcompat.view.menu.i iVar) {
        return iVar.j();
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public void a(boolean z) {
        super.a(z);
        ((View) this.f).requestLayout();
        boolean z2 = false;
        if (this.c != null) {
            ArrayList<androidx.appcompat.view.menu.i> l = this.c.l();
            int size = l.size();
            for (int i = 0; i < size; i++) {
                androidx.core.f.b a2 = l.get(i).a();
                if (a2 != null) {
                    a2.a(this);
                }
            }
        }
        ArrayList<androidx.appcompat.view.menu.i> m = this.c != null ? this.c.m() : null;
        if (this.o && m != null) {
            int size2 = m.size();
            if (size2 == 1) {
                z2 = !m.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        if (z2) {
            if (this.g == null) {
                this.g = new d(this.f225a);
            }
            ViewGroup viewGroup = (ViewGroup) this.g.getParent();
            if (viewGroup != this.f) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.g);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f;
                actionMenuView.addView(this.g, actionMenuView.c());
            }
        } else {
            d dVar = this.g;
            if (dVar != null && dVar.getParent() == this.f) {
                ((ViewGroup) this.f).removeView(this.g);
            }
        }
        ((ActionMenuView) this.f).setOverflowReserved(this.o);
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean a(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.g) {
            return false;
        }
        return super.a(viewGroup, i);
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public boolean a(androidx.appcompat.view.menu.r rVar) {
        boolean z = false;
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        androidx.appcompat.view.menu.r rVar2 = rVar;
        while (rVar2.t() != this.c) {
            rVar2 = (androidx.appcompat.view.menu.r) rVar2.t();
        }
        View a2 = a(rVar2.getItem());
        if (a2 == null) {
            return false;
        }
        this.l = rVar.getItem().getItemId();
        int size = rVar.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            MenuItem item = rVar.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
            i++;
        }
        this.i = new a(this.b, rVar, a2);
        this.i.a(z);
        this.i.a();
        super.a(rVar);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof n.a) && ((n.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public boolean e() {
        if (!this.o || j() || this.c == null || this.f == null || this.j != null || this.c.m().isEmpty()) {
            return false;
        }
        this.j = new c(new e(this.b, this.c, this.g, true));
        ((View) this.f).post(this.j);
        super.a((androidx.appcompat.view.menu.r) null);
        return true;
    }

    public boolean g() {
        if (this.j != null && this.f != null) {
            ((View) this.f).removeCallbacks(this.j);
            this.j = null;
            return true;
        }
        e eVar = this.h;
        if (eVar == null) {
            return false;
        }
        eVar.d();
        return true;
    }

    public boolean h() {
        return g() | i();
    }

    public boolean i() {
        a aVar = this.i;
        if (aVar == null) {
            return false;
        }
        aVar.d();
        return true;
    }

    public boolean j() {
        e eVar = this.h;
        return eVar != null && eVar.f();
    }

    public boolean k() {
        return this.j != null || j();
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public boolean b() {
        ArrayList<androidx.appcompat.view.menu.i> arrayList;
        int i;
        int i2;
        int i3;
        int i4;
        boolean z;
        ActionMenuPresenter actionMenuPresenter = this;
        View view = null;
        int i5 = 0;
        if (actionMenuPresenter.c != null) {
            arrayList = actionMenuPresenter.c.j();
            i = arrayList.size();
        } else {
            arrayList = null;
            i = 0;
        }
        int i6 = actionMenuPresenter.s;
        int i7 = actionMenuPresenter.r;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) actionMenuPresenter.f;
        int i8 = i6;
        boolean z2 = false;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < i; i11++) {
            androidx.appcompat.view.menu.i iVar = arrayList.get(i11);
            if (iVar.l()) {
                i9++;
            } else if (iVar.k()) {
                i10++;
            } else {
                z2 = true;
            }
            if (actionMenuPresenter.w && iVar.isActionViewExpanded()) {
                i8 = 0;
            }
        }
        if (actionMenuPresenter.o && (z2 || i10 + i9 > i8)) {
            i8--;
        }
        int i12 = i8 - i9;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.y;
        sparseBooleanArray.clear();
        if (actionMenuPresenter.u) {
            int i13 = actionMenuPresenter.x;
            i3 = i7 / i13;
            i2 = i13 + ((i7 % i13) / i3);
        } else {
            i2 = 0;
            i3 = 0;
        }
        int i14 = i7;
        int i15 = 0;
        int i16 = 0;
        while (i15 < i) {
            androidx.appcompat.view.menu.i iVar2 = arrayList.get(i15);
            if (iVar2.l()) {
                View a2 = actionMenuPresenter.a(iVar2, view, viewGroup);
                if (actionMenuPresenter.u) {
                    i3 -= ActionMenuView.a(a2, i2, i3, makeMeasureSpec, i5);
                } else {
                    a2.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = a2.getMeasuredWidth();
                i14 -= measuredWidth;
                if (i16 != 0) {
                    measuredWidth = i16;
                }
                int groupId = iVar2.getGroupId();
                if (groupId != 0) {
                    z = true;
                    sparseBooleanArray.put(groupId, true);
                } else {
                    z = true;
                }
                iVar2.d(z);
                i16 = measuredWidth;
                i4 = i;
            } else if (iVar2.k()) {
                int groupId2 = iVar2.getGroupId();
                boolean z3 = sparseBooleanArray.get(groupId2);
                boolean z4 = (i12 > 0 || z3) && i14 > 0 && (!actionMenuPresenter.u || i3 > 0);
                if (z4) {
                    boolean z5 = z4;
                    i4 = i;
                    View a3 = actionMenuPresenter.a(iVar2, null, viewGroup);
                    if (actionMenuPresenter.u) {
                        int a4 = ActionMenuView.a(a3, i2, i3, makeMeasureSpec, 0);
                        i3 -= a4;
                        z5 = a4 == 0 ? false : z5;
                    } else {
                        a3.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    int measuredWidth2 = a3.getMeasuredWidth();
                    i14 -= measuredWidth2;
                    if (i16 == 0) {
                        i16 = measuredWidth2;
                    }
                    z4 = actionMenuPresenter.u ? z5 & (i14 >= 0) : z5 & (i14 + i16 > 0);
                } else {
                    i4 = i;
                }
                if (z4 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z3) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i17 = 0; i17 < i15; i17++) {
                        androidx.appcompat.view.menu.i iVar3 = arrayList.get(i17);
                        if (iVar3.getGroupId() == groupId2) {
                            if (iVar3.j()) {
                                i12++;
                            }
                            iVar3.d(false);
                        }
                    }
                }
                if (z4) {
                    i12--;
                }
                iVar2.d(z4);
            } else {
                i4 = i;
                iVar2.d(false);
            }
            i15++;
            i = i4;
            actionMenuPresenter = this;
            view = null;
            i5 = 0;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public void a(androidx.appcompat.view.menu.g gVar, boolean z) {
        h();
        super.a(gVar, z);
    }

    @Override // androidx.appcompat.view.menu.m
    public Parcelable f() {
        SavedState savedState = new SavedState();
        savedState.f256a = this.l;
        return savedState;
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(Parcelable parcelable) {
        MenuItem findItem;
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            if (savedState.f256a <= 0 || (findItem = this.c.findItem(savedState.f256a)) == null) {
                return;
            }
            a((androidx.appcompat.view.menu.r) findItem.getSubMenu());
        }
    }

    @Override // androidx.core.f.b.a
    public void d(boolean z) {
        if (z) {
            super.a((androidx.appcompat.view.menu.r) null);
        } else if (this.c != null) {
            this.c.a(false);
        }
    }

    public void a(ActionMenuView actionMenuView) {
        this.f = actionMenuView;
        actionMenuView.a(this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.appcompat.widget.ActionMenuPresenter.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a, reason: collision with root package name */
        public int f256a;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f256a = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f256a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d extends AppCompatImageView implements ActionMenuView.a {
        private final float[] b;

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean c() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean d() {
            return false;
        }

        public d(Context context) {
            super(context, null, a.C0024a.actionOverflowButtonStyle);
            this.b = new float[2];
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            aw.a(this, getContentDescription());
            setOnTouchListener(new af(this) { // from class: androidx.appcompat.widget.ActionMenuPresenter.d.1
                @Override // androidx.appcompat.widget.af
                public androidx.appcompat.view.menu.p a() {
                    if (ActionMenuPresenter.this.h == null) {
                        return null;
                    }
                    return ActionMenuPresenter.this.h.b();
                }

                @Override // androidx.appcompat.widget.af
                public boolean b() {
                    ActionMenuPresenter.this.e();
                    return true;
                }

                @Override // androidx.appcompat.widget.af
                public boolean c() {
                    if (ActionMenuPresenter.this.j != null) {
                        return false;
                    }
                    ActionMenuPresenter.this.g();
                    return true;
                }
            });
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.e();
            return true;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                androidx.core.graphics.drawable.a.a(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends androidx.appcompat.view.menu.l {
        public e(Context context, androidx.appcompat.view.menu.g gVar, View view, boolean z) {
            super(context, gVar, view, z, a.C0024a.actionOverflowMenuStyle);
            a(8388613);
            a(ActionMenuPresenter.this.k);
        }

        @Override // androidx.appcompat.view.menu.l
        protected void e() {
            if (ActionMenuPresenter.this.c != null) {
                ActionMenuPresenter.this.c.close();
            }
            ActionMenuPresenter.this.h = null;
            super.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends androidx.appcompat.view.menu.l {
        public a(Context context, androidx.appcompat.view.menu.r rVar, View view) {
            super(context, rVar, view, false, a.C0024a.actionOverflowMenuStyle);
            if (!((androidx.appcompat.view.menu.i) rVar.getItem()).j()) {
                a(ActionMenuPresenter.this.g == null ? (View) ActionMenuPresenter.this.f : ActionMenuPresenter.this.g);
            }
            a(ActionMenuPresenter.this.k);
        }

        @Override // androidx.appcompat.view.menu.l
        protected void e() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.i = null;
            actionMenuPresenter.l = 0;
            super.e();
        }
    }

    /* loaded from: classes.dex */
    private class f implements m.a {
        f() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean a(androidx.appcompat.view.menu.g gVar) {
            if (gVar == null) {
                return false;
            }
            ActionMenuPresenter.this.l = ((androidx.appcompat.view.menu.r) gVar).getItem().getItemId();
            m.a a2 = ActionMenuPresenter.this.a();
            if (a2 != null) {
                return a2.a(gVar);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void a(androidx.appcompat.view.menu.g gVar, boolean z) {
            if (gVar instanceof androidx.appcompat.view.menu.r) {
                gVar.q().a(false);
            }
            m.a a2 = ActionMenuPresenter.this.a();
            if (a2 != null) {
                a2.a(gVar, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        private e b;

        public c(e eVar) {
            this.b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ActionMenuPresenter.this.c != null) {
                ActionMenuPresenter.this.c.g();
            }
            View view = (View) ActionMenuPresenter.this.f;
            if (view != null && view.getWindowToken() != null && this.b.c()) {
                ActionMenuPresenter.this.h = this.b;
            }
            ActionMenuPresenter.this.j = null;
        }
    }

    /* loaded from: classes.dex */
    private class b extends ActionMenuItemView.b {
        b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public androidx.appcompat.view.menu.p a() {
            if (ActionMenuPresenter.this.i != null) {
                return ActionMenuPresenter.this.i.b();
            }
            return null;
        }
    }
}
