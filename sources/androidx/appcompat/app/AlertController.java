package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.appcompat.widget.ag;
import androidx.core.f.v;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class AlertController {
    private int A;
    private CharSequence C;
    private Drawable D;
    private CharSequence E;
    private Drawable F;
    private CharSequence G;
    private Drawable H;
    private Drawable J;
    private ImageView K;
    private TextView L;
    private TextView M;
    private View N;
    private int O;
    private int P;
    private boolean Q;

    /* renamed from: a, reason: collision with root package name */
    final f f139a;
    ListView b;
    Button c;
    Message d;
    Button e;
    Message f;
    Button g;
    Message h;
    NestedScrollView i;
    ListAdapter j;
    int l;
    int m;
    int n;
    int o;
    Handler p;
    private final Context q;
    private final Window r;
    private final int s;
    private CharSequence t;
    private CharSequence u;
    private View v;
    private int w;
    private int x;
    private int y;
    private int z;
    private boolean B = false;
    private int I = 0;
    int k = -1;
    private int R = 0;
    private final View.OnClickListener S = new View.OnClickListener() { // from class: androidx.appcompat.app.AlertController.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message obtain;
            if (view == AlertController.this.c && AlertController.this.d != null) {
                obtain = Message.obtain(AlertController.this.d);
            } else if (view == AlertController.this.e && AlertController.this.f != null) {
                obtain = Message.obtain(AlertController.this.f);
            } else {
                obtain = (view != AlertController.this.g || AlertController.this.h == null) ? null : Message.obtain(AlertController.this.h);
            }
            if (obtain != null) {
                obtain.sendToTarget();
            }
            AlertController.this.p.obtainMessage(1, AlertController.this.f139a).sendToTarget();
        }
    };

    /* loaded from: classes.dex */
    private static final class b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<DialogInterface> f151a;

        public b(DialogInterface dialogInterface) {
            this.f151a = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                switch (i) {
                    case -3:
                    case -2:
                    case -1:
                        ((DialogInterface.OnClickListener) message.obj).onClick(this.f151a.get(), message.what);
                        return;
                    default:
                        return;
                }
            }
            ((DialogInterface) message.obj).dismiss();
        }
    }

    private static boolean a(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(a.C0024a.alertDialogCenterButtons, typedValue, true);
        return typedValue.data != 0;
    }

    public AlertController(Context context, f fVar, Window window) {
        this.q = context;
        this.f139a = fVar;
        this.r = window;
        this.p = new b(fVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, a.j.AlertDialog, a.C0024a.alertDialogStyle, 0);
        this.O = obtainStyledAttributes.getResourceId(a.j.AlertDialog_android_layout, 0);
        this.P = obtainStyledAttributes.getResourceId(a.j.AlertDialog_buttonPanelSideLayout, 0);
        this.l = obtainStyledAttributes.getResourceId(a.j.AlertDialog_listLayout, 0);
        this.m = obtainStyledAttributes.getResourceId(a.j.AlertDialog_multiChoiceItemLayout, 0);
        this.n = obtainStyledAttributes.getResourceId(a.j.AlertDialog_singleChoiceItemLayout, 0);
        this.o = obtainStyledAttributes.getResourceId(a.j.AlertDialog_listItemLayout, 0);
        this.Q = obtainStyledAttributes.getBoolean(a.j.AlertDialog_showTitle, true);
        this.s = obtainStyledAttributes.getDimensionPixelSize(a.j.AlertDialog_buttonIconDimen, 0);
        obtainStyledAttributes.recycle();
        fVar.a(1);
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public void a() {
        this.f139a.setContentView(c());
        d();
    }

    private int c() {
        int i = this.P;
        if (i == 0) {
            return this.O;
        }
        return this.R == 1 ? i : this.O;
    }

    public void a(CharSequence charSequence) {
        this.t = charSequence;
        TextView textView = this.L;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void b(View view) {
        this.N = view;
    }

    public void b(CharSequence charSequence) {
        this.u = charSequence;
        TextView textView = this.M;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void a(int i) {
        this.v = null;
        this.w = i;
        this.B = false;
    }

    public void c(View view) {
        this.v = view;
        this.w = 0;
        this.B = false;
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        this.v = view;
        this.w = 0;
        this.B = true;
        this.x = i;
        this.y = i2;
        this.z = i3;
        this.A = i4;
    }

    public void a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.p.obtainMessage(i, onClickListener);
        }
        switch (i) {
            case -3:
                this.G = charSequence;
                this.h = message;
                this.H = drawable;
                return;
            case -2:
                this.E = charSequence;
                this.f = message;
                this.F = drawable;
                return;
            case -1:
                this.C = charSequence;
                this.d = message;
                this.D = drawable;
                return;
            default:
                throw new IllegalArgumentException("Button does not exist");
        }
    }

    public void b(int i) {
        this.J = null;
        this.I = i;
        ImageView imageView = this.K;
        if (imageView != null) {
            if (i != 0) {
                imageView.setVisibility(0);
                this.K.setImageResource(this.I);
            } else {
                imageView.setVisibility(8);
            }
        }
    }

    public void a(Drawable drawable) {
        this.J = drawable;
        this.I = 0;
        ImageView imageView = this.K;
        if (imageView != null) {
            if (drawable != null) {
                imageView.setVisibility(0);
                this.K.setImageDrawable(drawable);
            } else {
                imageView.setVisibility(8);
            }
        }
    }

    public int c(int i) {
        TypedValue typedValue = new TypedValue();
        this.q.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView b() {
        return this.b;
    }

    public boolean a(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.i;
        return nestedScrollView != null && nestedScrollView.a(keyEvent);
    }

    public boolean b(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.i;
        return nestedScrollView != null && nestedScrollView.a(keyEvent);
    }

    private ViewGroup a(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void d() {
        View findViewById;
        ListAdapter listAdapter;
        View findViewById2;
        View findViewById3 = this.r.findViewById(a.f.parentPanel);
        View findViewById4 = findViewById3.findViewById(a.f.topPanel);
        View findViewById5 = findViewById3.findViewById(a.f.contentPanel);
        View findViewById6 = findViewById3.findViewById(a.f.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById3.findViewById(a.f.customPanel);
        a(viewGroup);
        View findViewById7 = viewGroup.findViewById(a.f.topPanel);
        View findViewById8 = viewGroup.findViewById(a.f.contentPanel);
        View findViewById9 = viewGroup.findViewById(a.f.buttonPanel);
        ViewGroup a2 = a(findViewById7, findViewById4);
        ViewGroup a3 = a(findViewById8, findViewById5);
        ViewGroup a4 = a(findViewById9, findViewById6);
        c(a3);
        d(a4);
        b(a2);
        boolean z = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z2 = (a2 == null || a2.getVisibility() == 8) ? 0 : 1;
        boolean z3 = (a4 == null || a4.getVisibility() == 8) ? false : true;
        if (!z3 && a3 != null && (findViewById2 = a3.findViewById(a.f.textSpacerNoButtons)) != null) {
            findViewById2.setVisibility(0);
        }
        if (z2 != 0) {
            NestedScrollView nestedScrollView = this.i;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View findViewById10 = (this.u == null && this.b == null) ? null : a2.findViewById(a.f.titleDividerNoCustom);
            if (findViewById10 != null) {
                findViewById10.setVisibility(0);
            }
        } else if (a3 != null && (findViewById = a3.findViewById(a.f.textSpacerNoTitle)) != null) {
            findViewById.setVisibility(0);
        }
        ListView listView = this.b;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).a(z2, z3);
        }
        if (!z) {
            View view = this.b;
            if (view == null) {
                view = this.i;
            }
            if (view != null) {
                a(a3, view, z2 | (z3 ? 2 : 0), 3);
            }
        }
        ListView listView2 = this.b;
        if (listView2 == null || (listAdapter = this.j) == null) {
            return;
        }
        listView2.setAdapter(listAdapter);
        int i = this.k;
        if (i > -1) {
            listView2.setItemChecked(i, true);
            listView2.setSelection(i);
        }
    }

    private void a(ViewGroup viewGroup, View view, int i, int i2) {
        final View findViewById = this.r.findViewById(a.f.scrollIndicatorUp);
        View findViewById2 = this.r.findViewById(a.f.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23) {
            v.a(view, i, i2);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
            return;
        }
        final View view2 = null;
        if (findViewById != null && (i & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 == null || (i & 2) != 0) {
            view2 = findViewById2;
        } else {
            viewGroup.removeView(findViewById2);
        }
        if (findViewById == null && view2 == null) {
            return;
        }
        if (this.u != null) {
            this.i.setOnScrollChangeListener(new NestedScrollView.b() { // from class: androidx.appcompat.app.AlertController.2
                @Override // androidx.core.widget.NestedScrollView.b
                public void a(NestedScrollView nestedScrollView, int i3, int i4, int i5, int i6) {
                    AlertController.a(nestedScrollView, findViewById, view2);
                }
            });
            this.i.post(new Runnable() { // from class: androidx.appcompat.app.AlertController.3
                @Override // java.lang.Runnable
                public void run() {
                    AlertController.a(AlertController.this.i, findViewById, view2);
                }
            });
            return;
        }
        ListView listView = this.b;
        if (listView != null) {
            listView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: androidx.appcompat.app.AlertController.4
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i3) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i3, int i4, int i5) {
                    AlertController.a(absListView, findViewById, view2);
                }
            });
            this.b.post(new Runnable() { // from class: androidx.appcompat.app.AlertController.5
                @Override // java.lang.Runnable
                public void run() {
                    AlertController.a(AlertController.this.b, findViewById, view2);
                }
            });
            return;
        }
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
        }
        if (view2 != null) {
            viewGroup.removeView(view2);
        }
    }

    private void a(ViewGroup viewGroup) {
        View view = this.v;
        if (view == null) {
            view = this.w != 0 ? LayoutInflater.from(this.q).inflate(this.w, viewGroup, false) : null;
        }
        boolean z = view != null;
        if (!z || !a(view)) {
            this.r.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) this.r.findViewById(a.f.custom);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (this.B) {
                frameLayout.setPadding(this.x, this.y, this.z, this.A);
            }
            if (this.b != null) {
                ((ag.a) viewGroup.getLayoutParams()).g = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void b(ViewGroup viewGroup) {
        if (this.N != null) {
            viewGroup.addView(this.N, 0, new ViewGroup.LayoutParams(-1, -2));
            this.r.findViewById(a.f.title_template).setVisibility(8);
            return;
        }
        this.K = (ImageView) this.r.findViewById(R.id.icon);
        if ((!TextUtils.isEmpty(this.t)) && this.Q) {
            this.L = (TextView) this.r.findViewById(a.f.alertTitle);
            this.L.setText(this.t);
            int i = this.I;
            if (i != 0) {
                this.K.setImageResource(i);
                return;
            }
            Drawable drawable = this.J;
            if (drawable != null) {
                this.K.setImageDrawable(drawable);
                return;
            } else {
                this.L.setPadding(this.K.getPaddingLeft(), this.K.getPaddingTop(), this.K.getPaddingRight(), this.K.getPaddingBottom());
                this.K.setVisibility(8);
                return;
            }
        }
        this.r.findViewById(a.f.title_template).setVisibility(8);
        this.K.setVisibility(8);
        viewGroup.setVisibility(8);
    }

    private void c(ViewGroup viewGroup) {
        this.i = (NestedScrollView) this.r.findViewById(a.f.scrollView);
        this.i.setFocusable(false);
        this.i.setNestedScrollingEnabled(false);
        this.M = (TextView) viewGroup.findViewById(R.id.message);
        TextView textView = this.M;
        if (textView == null) {
            return;
        }
        CharSequence charSequence = this.u;
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
        this.i.removeView(this.M);
        if (this.b != null) {
            ViewGroup viewGroup2 = (ViewGroup) this.i.getParent();
            int indexOfChild = viewGroup2.indexOfChild(this.i);
            viewGroup2.removeViewAt(indexOfChild);
            viewGroup2.addView(this.b, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        viewGroup.setVisibility(8);
    }

    static void a(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    private void d(ViewGroup viewGroup) {
        int i;
        this.c = (Button) viewGroup.findViewById(R.id.button1);
        this.c.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.C) && this.D == null) {
            this.c.setVisibility(8);
            i = 0;
        } else {
            this.c.setText(this.C);
            Drawable drawable = this.D;
            if (drawable != null) {
                int i2 = this.s;
                drawable.setBounds(0, 0, i2, i2);
                this.c.setCompoundDrawables(this.D, null, null, null);
            }
            this.c.setVisibility(0);
            i = 1;
        }
        this.e = (Button) viewGroup.findViewById(R.id.button2);
        this.e.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.E) && this.F == null) {
            this.e.setVisibility(8);
        } else {
            this.e.setText(this.E);
            Drawable drawable2 = this.F;
            if (drawable2 != null) {
                int i3 = this.s;
                drawable2.setBounds(0, 0, i3, i3);
                this.e.setCompoundDrawables(this.F, null, null, null);
            }
            this.e.setVisibility(0);
            i |= 2;
        }
        this.g = (Button) viewGroup.findViewById(R.id.button3);
        this.g.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.G) && this.H == null) {
            this.g.setVisibility(8);
        } else {
            this.g.setText(this.G);
            Drawable drawable3 = this.D;
            if (drawable3 != null) {
                int i4 = this.s;
                drawable3.setBounds(0, 0, i4, i4);
                this.c.setCompoundDrawables(this.D, null, null, null);
            }
            this.g.setVisibility(0);
            i |= 4;
        }
        if (a(this.q)) {
            if (i == 1) {
                a(this.c);
            } else if (i == 2) {
                a(this.e);
            } else if (i == 4) {
                a(this.g);
            }
        }
        if (i != 0) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void a(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    /* loaded from: classes.dex */
    public static class RecycleListView extends ListView {

        /* renamed from: a, reason: collision with root package name */
        private final int f145a;
        private final int b;

        public RecycleListView(Context context) {
            this(context, null);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.RecycleListView);
            this.b = obtainStyledAttributes.getDimensionPixelOffset(a.j.RecycleListView_paddingBottomNoButtons, -1);
            this.f145a = obtainStyledAttributes.getDimensionPixelOffset(a.j.RecycleListView_paddingTopNoTitle, -1);
        }

        public void a(boolean z, boolean z2) {
            if (z2 && z) {
                return;
            }
            setPadding(getPaddingLeft(), z ? getPaddingTop() : this.f145a, getPaddingRight(), z2 ? getPaddingBottom() : this.b);
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int A;
        public int B;
        public int C;
        public int D;
        public boolean[] F;
        public boolean G;
        public boolean H;
        public DialogInterface.OnMultiChoiceClickListener J;
        public Cursor K;
        public String L;
        public String M;
        public AdapterView.OnItemSelectedListener N;
        public InterfaceC0026a O;

        /* renamed from: a, reason: collision with root package name */
        public final Context f146a;
        public final LayoutInflater b;
        public Drawable d;
        public CharSequence f;
        public View g;
        public CharSequence h;
        public CharSequence i;
        public Drawable j;
        public DialogInterface.OnClickListener k;
        public CharSequence l;
        public Drawable m;
        public DialogInterface.OnClickListener n;
        public CharSequence o;
        public Drawable p;
        public DialogInterface.OnClickListener q;
        public DialogInterface.OnCancelListener s;
        public DialogInterface.OnDismissListener t;
        public DialogInterface.OnKeyListener u;
        public CharSequence[] v;
        public ListAdapter w;
        public DialogInterface.OnClickListener x;
        public int y;
        public View z;
        public int c = 0;
        public int e = 0;
        public boolean E = false;
        public int I = -1;
        public boolean P = true;
        public boolean r = true;

        /* renamed from: androidx.appcompat.app.AlertController$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public interface InterfaceC0026a {
            void a(ListView listView);
        }

        public a(Context context) {
            this.f146a = context;
            this.b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public void a(AlertController alertController) {
            View view = this.g;
            if (view != null) {
                alertController.b(view);
            } else {
                CharSequence charSequence = this.f;
                if (charSequence != null) {
                    alertController.a(charSequence);
                }
                Drawable drawable = this.d;
                if (drawable != null) {
                    alertController.a(drawable);
                }
                int i = this.c;
                if (i != 0) {
                    alertController.b(i);
                }
                int i2 = this.e;
                if (i2 != 0) {
                    alertController.b(alertController.c(i2));
                }
            }
            CharSequence charSequence2 = this.h;
            if (charSequence2 != null) {
                alertController.b(charSequence2);
            }
            if (this.i != null || this.j != null) {
                alertController.a(-1, this.i, this.k, (Message) null, this.j);
            }
            if (this.l != null || this.m != null) {
                alertController.a(-2, this.l, this.n, (Message) null, this.m);
            }
            if (this.o != null || this.p != null) {
                alertController.a(-3, this.o, this.q, (Message) null, this.p);
            }
            if (this.v != null || this.K != null || this.w != null) {
                b(alertController);
            }
            View view2 = this.z;
            if (view2 != null) {
                if (this.E) {
                    alertController.a(view2, this.A, this.B, this.C, this.D);
                    return;
                } else {
                    alertController.c(view2);
                    return;
                }
            }
            int i3 = this.y;
            if (i3 != 0) {
                alertController.a(i3);
            }
        }

        private void b(final AlertController alertController) {
            int i;
            ListAdapter listAdapter;
            final RecycleListView recycleListView = (RecycleListView) this.b.inflate(alertController.l, (ViewGroup) null);
            if (this.G) {
                Cursor cursor = this.K;
                if (cursor == null) {
                    listAdapter = new ArrayAdapter<CharSequence>(this.f146a, alertController.m, R.id.text1, this.v) { // from class: androidx.appcompat.app.AlertController.a.1
                        @Override // android.widget.ArrayAdapter, android.widget.Adapter
                        public View getView(int i2, View view, ViewGroup viewGroup) {
                            View view2 = super.getView(i2, view, viewGroup);
                            if (a.this.F != null && a.this.F[i2]) {
                                recycleListView.setItemChecked(i2, true);
                            }
                            return view2;
                        }
                    };
                } else {
                    listAdapter = new CursorAdapter(this.f146a, cursor, false) { // from class: androidx.appcompat.app.AlertController.a.2
                        private final int d;
                        private final int e;

                        {
                            Cursor cursor2 = getCursor();
                            this.d = cursor2.getColumnIndexOrThrow(a.this.L);
                            this.e = cursor2.getColumnIndexOrThrow(a.this.M);
                        }

                        @Override // android.widget.CursorAdapter
                        public void bindView(View view, Context context, Cursor cursor2) {
                            ((CheckedTextView) view.findViewById(R.id.text1)).setText(cursor2.getString(this.d));
                            recycleListView.setItemChecked(cursor2.getPosition(), cursor2.getInt(this.e) == 1);
                        }

                        @Override // android.widget.CursorAdapter
                        public View newView(Context context, Cursor cursor2, ViewGroup viewGroup) {
                            return a.this.b.inflate(alertController.m, viewGroup, false);
                        }
                    };
                }
            } else {
                if (this.H) {
                    i = alertController.n;
                } else {
                    i = alertController.o;
                }
                Cursor cursor2 = this.K;
                if (cursor2 != null) {
                    listAdapter = new SimpleCursorAdapter(this.f146a, i, cursor2, new String[]{this.L}, new int[]{R.id.text1});
                } else {
                    listAdapter = this.w;
                    if (listAdapter == null) {
                        listAdapter = new c(this.f146a, i, R.id.text1, this.v);
                    }
                }
            }
            InterfaceC0026a interfaceC0026a = this.O;
            if (interfaceC0026a != null) {
                interfaceC0026a.a(recycleListView);
            }
            alertController.j = listAdapter;
            alertController.k = this.I;
            if (this.x != null) {
                recycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.app.AlertController.a.3
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a.this.x.onClick(alertController.f139a, i2);
                        if (a.this.H) {
                            return;
                        }
                        alertController.f139a.dismiss();
                    }
                });
            } else if (this.J != null) {
                recycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.app.AlertController.a.4
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        if (a.this.F != null) {
                            a.this.F[i2] = recycleListView.isItemChecked(i2);
                        }
                        a.this.J.onClick(alertController.f139a, i2, recycleListView.isItemChecked(i2));
                    }
                });
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.N;
            if (onItemSelectedListener != null) {
                recycleListView.setOnItemSelectedListener(onItemSelectedListener);
            }
            if (this.H) {
                recycleListView.setChoiceMode(1);
            } else if (this.G) {
                recycleListView.setChoiceMode(2);
            }
            alertController.b = recycleListView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends ArrayAdapter<CharSequence> {
        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }

        public c(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
        }
    }
}
