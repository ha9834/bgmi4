package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.a;

/* loaded from: classes.dex */
public class ActivityChooserView extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    final a f267a;
    final FrameLayout b;
    final FrameLayout c;
    androidx.core.f.b d;
    final DataSetObserver e;
    PopupWindow.OnDismissListener f;
    boolean g;
    int h;
    private final b i;
    private final View j;
    private final ImageView k;
    private final int l;
    private final ViewTreeObserver.OnGlobalLayoutListener m;
    private ah n;
    private boolean o;
    private int p;

    public void setActivityChooserModel(c cVar) {
        this.f267a.a(cVar);
        if (c()) {
            b();
            a();
        }
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.k.setImageDrawable(drawable);
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.k.setContentDescription(getContext().getString(i));
    }

    public void setProvider(androidx.core.f.b bVar) {
        this.d = bVar;
    }

    public boolean a() {
        if (c() || !this.o) {
            return false;
        }
        this.g = false;
        a(this.h);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [boolean, int] */
    void a(int i) {
        if (this.f267a.d() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.m);
        ?? r0 = this.c.getVisibility() == 0 ? 1 : 0;
        int c = this.f267a.c();
        if (i != Integer.MAX_VALUE && c > i + r0) {
            this.f267a.a(true);
            this.f267a.a(i - 1);
        } else {
            this.f267a.a(false);
            this.f267a.a(i);
        }
        ah listPopupWindow = getListPopupWindow();
        if (listPopupWindow.e()) {
            return;
        }
        if (this.g || r0 == 0) {
            this.f267a.a(true, r0);
        } else {
            this.f267a.a(false, false);
        }
        listPopupWindow.h(Math.min(this.f267a.a(), this.l));
        listPopupWindow.d_();
        androidx.core.f.b bVar = this.d;
        if (bVar != null) {
            bVar.a(true);
        }
        listPopupWindow.g().setContentDescription(getContext().getString(a.h.abc_activitychooserview_choose_application));
        listPopupWindow.g().setSelector(new ColorDrawable(0));
    }

    public boolean b() {
        if (!c()) {
            return true;
        }
        getListPopupWindow().d();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        viewTreeObserver.removeGlobalOnLayoutListener(this.m);
        return true;
    }

    public boolean c() {
        return getListPopupWindow().e();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        c d = this.f267a.d();
        if (d != null) {
            d.registerObserver(this.e);
        }
        this.o = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c d = this.f267a.d();
        if (d != null) {
            d.unregisterObserver(this.e);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.m);
        }
        if (c()) {
            b();
        }
        this.o = false;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        View view = this.j;
        if (this.c.getVisibility() != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.j.layout(0, 0, i3 - i, i4 - i2);
        if (c()) {
            return;
        }
        b();
    }

    public c getDataModel() {
        return this.f267a.d();
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f = onDismissListener;
    }

    public void setInitialActivityCount(int i) {
        this.h = i;
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.p = i;
    }

    ah getListPopupWindow() {
        if (this.n == null) {
            this.n = new ah(getContext());
            this.n.a(this.f267a);
            this.n.b(this);
            this.n.a(true);
            this.n.a((AdapterView.OnItemClickListener) this.i);
            this.n.a((PopupWindow.OnDismissListener) this.i);
        }
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ActivityChooserView f270a;

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            switch (((a) adapterView.getAdapter()).getItemViewType(i)) {
                case 0:
                    this.f270a.b();
                    if (this.f270a.g) {
                        if (i > 0) {
                            this.f270a.f267a.d().c(i);
                            return;
                        }
                        return;
                    }
                    if (!this.f270a.f267a.e()) {
                        i++;
                    }
                    Intent b = this.f270a.f267a.d().b(i);
                    if (b != null) {
                        b.addFlags(524288);
                        this.f270a.getContext().startActivity(b);
                        return;
                    }
                    return;
                case 1:
                    this.f270a.a(Integer.MAX_VALUE);
                    return;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.f270a.c) {
                this.f270a.b();
                Intent b = this.f270a.f267a.d().b(this.f270a.f267a.d().a(this.f270a.f267a.b()));
                if (b != null) {
                    b.addFlags(524288);
                    this.f270a.getContext().startActivity(b);
                    return;
                }
                return;
            }
            if (view == this.f270a.b) {
                ActivityChooserView activityChooserView = this.f270a;
                activityChooserView.g = false;
                activityChooserView.a(activityChooserView.h);
                return;
            }
            throw new IllegalArgumentException();
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view == this.f270a.c) {
                if (this.f270a.f267a.getCount() > 0) {
                    ActivityChooserView activityChooserView = this.f270a;
                    activityChooserView.g = true;
                    activityChooserView.a(activityChooserView.h);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            a();
            if (this.f270a.d != null) {
                this.f270a.d.a(false);
            }
        }

        private void a() {
            if (this.f270a.f != null) {
                this.f270a.f.onDismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ActivityChooserView f269a;
        private c b;
        private int c;
        private boolean d;
        private boolean e;
        private boolean f;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 3;
        }

        public void a(c cVar) {
            c d = this.f269a.f267a.d();
            if (d != null && this.f269a.isShown()) {
                d.unregisterObserver(this.f269a.e);
            }
            this.b = cVar;
            if (cVar != null && this.f269a.isShown()) {
                cVar.registerObserver(this.f269a.e);
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            return (this.f && i == getCount() - 1) ? 1 : 0;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int a2 = this.b.a();
            if (!this.d && this.b.b() != null) {
                a2--;
            }
            int min = Math.min(a2, this.c);
            return this.f ? min + 1 : min;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            switch (getItemViewType(i)) {
                case 0:
                    if (!this.d && this.b.b() != null) {
                        i++;
                    }
                    return this.b.a(i);
                case 1:
                    return null;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            switch (getItemViewType(i)) {
                case 0:
                    if (view == null || view.getId() != a.f.list_item) {
                        view = LayoutInflater.from(this.f269a.getContext()).inflate(a.g.abc_activity_chooser_view_list_item, viewGroup, false);
                    }
                    PackageManager packageManager = this.f269a.getContext().getPackageManager();
                    ImageView imageView = (ImageView) view.findViewById(a.f.icon);
                    ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                    imageView.setImageDrawable(resolveInfo.loadIcon(packageManager));
                    ((TextView) view.findViewById(a.f.title)).setText(resolveInfo.loadLabel(packageManager));
                    if (this.d && i == 0 && this.e) {
                        view.setActivated(true);
                    } else {
                        view.setActivated(false);
                    }
                    return view;
                case 1:
                    if (view != null && view.getId() == 1) {
                        return view;
                    }
                    View inflate = LayoutInflater.from(this.f269a.getContext()).inflate(a.g.abc_activity_chooser_view_list_item, viewGroup, false);
                    inflate.setId(1);
                    ((TextView) inflate.findViewById(a.f.title)).setText(this.f269a.getContext().getString(a.h.abc_activity_chooser_view_see_all));
                    return inflate;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public int a() {
            int i = this.c;
            this.c = Integer.MAX_VALUE;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            View view = null;
            int i2 = 0;
            for (int i3 = 0; i3 < count; i3++) {
                view = getView(i3, view, null);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i2 = Math.max(i2, view.getMeasuredWidth());
            }
            this.c = i;
            return i2;
        }

        public void a(int i) {
            if (this.c != i) {
                this.c = i;
                notifyDataSetChanged();
            }
        }

        public ResolveInfo b() {
            return this.b.b();
        }

        public void a(boolean z) {
            if (this.f != z) {
                this.f = z;
                notifyDataSetChanged();
            }
        }

        public int c() {
            return this.b.a();
        }

        public c d() {
            return this.b;
        }

        public void a(boolean z, boolean z2) {
            if (this.d == z && this.e == z2) {
                return;
            }
            this.d = z;
            this.e = z2;
            notifyDataSetChanged();
        }

        public boolean e() {
            return this.d;
        }
    }

    /* loaded from: classes.dex */
    public static class InnerLayout extends LinearLayout {

        /* renamed from: a, reason: collision with root package name */
        private static final int[] f268a = {R.attr.background};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            au a2 = au.a(context, attributeSet, f268a);
            setBackgroundDrawable(a2.a(0));
            a2.a();
        }
    }
}
