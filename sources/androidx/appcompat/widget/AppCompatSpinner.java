package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.a;
import androidx.appcompat.app.c;

/* loaded from: classes.dex */
public class AppCompatSpinner extends Spinner implements androidx.core.f.u {
    private static final int[] c = {R.attr.spinnerMode};

    /* renamed from: a, reason: collision with root package name */
    int f271a;
    final Rect b;
    private final e d;
    private final Context e;
    private af f;
    private SpinnerAdapter g;
    private final boolean h;
    private d i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        CharSequence a();

        void a(int i);

        void a(int i, int i2);

        void a(Drawable drawable);

        void a(ListAdapter listAdapter);

        void a(CharSequence charSequence);

        Drawable b();

        void b(int i);

        int c();

        void c(int i);

        void d();

        boolean e();

        int f();
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0024a.spinnerStyle);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0048, code lost:
    
        if (r11 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004a, code lost:
    
        r11.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005c, code lost:
    
        if (r11 == null) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public AppCompatSpinner(android.content.Context r7, android.util.AttributeSet r8, int r9, int r10, android.content.res.Resources.Theme r11) {
        /*
            r6 = this;
            r6.<init>(r7, r8, r9)
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r6.b = r0
            int[] r0 = androidx.appcompat.a.j.Spinner
            r1 = 0
            androidx.appcompat.widget.au r0 = androidx.appcompat.widget.au.a(r7, r8, r0, r9, r1)
            androidx.appcompat.widget.e r2 = new androidx.appcompat.widget.e
            r2.<init>(r6)
            r6.d = r2
            if (r11 == 0) goto L22
            androidx.appcompat.view.d r2 = new androidx.appcompat.view.d
            r2.<init>(r7, r11)
            r6.e = r2
            goto L34
        L22:
            int r11 = androidx.appcompat.a.j.Spinner_popupTheme
            int r11 = r0.g(r11, r1)
            if (r11 == 0) goto L32
            androidx.appcompat.view.d r2 = new androidx.appcompat.view.d
            r2.<init>(r7, r11)
            r6.e = r2
            goto L34
        L32:
            r6.e = r7
        L34:
            r11 = -1
            r2 = 0
            if (r10 != r11) goto L66
            int[] r11 = androidx.appcompat.widget.AppCompatSpinner.c     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
            android.content.res.TypedArray r11 = r7.obtainStyledAttributes(r8, r11, r9, r1)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
            boolean r3 = r11.hasValue(r1)     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L5f
            if (r3 == 0) goto L48
            int r10 = r11.getInt(r1, r1)     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L5f
        L48:
            if (r11 == 0) goto L66
        L4a:
            r11.recycle()
            goto L66
        L4e:
            r3 = move-exception
            goto L55
        L50:
            r7 = move-exception
            r11 = r2
            goto L60
        L53:
            r3 = move-exception
            r11 = r2
        L55:
            java.lang.String r4 = "AppCompatSpinner"
            java.lang.String r5 = "Could not read android:spinnerMode"
            android.util.Log.i(r4, r5, r3)     // Catch: java.lang.Throwable -> L5f
            if (r11 == 0) goto L66
            goto L4a
        L5f:
            r7 = move-exception
        L60:
            if (r11 == 0) goto L65
            r11.recycle()
        L65:
            throw r7
        L66:
            switch(r10) {
                case 0: goto La1;
                case 1: goto L6a;
                default: goto L69;
            }
        L69:
            goto Lb3
        L6a:
            androidx.appcompat.widget.AppCompatSpinner$c r10 = new androidx.appcompat.widget.AppCompatSpinner$c
            android.content.Context r11 = r6.e
            r10.<init>(r11, r8, r9)
            android.content.Context r11 = r6.e
            int[] r3 = androidx.appcompat.a.j.Spinner
            androidx.appcompat.widget.au r11 = androidx.appcompat.widget.au.a(r11, r8, r3, r9, r1)
            int r1 = androidx.appcompat.a.j.Spinner_android_dropDownWidth
            r3 = -2
            int r1 = r11.f(r1, r3)
            r6.f271a = r1
            int r1 = androidx.appcompat.a.j.Spinner_android_popupBackground
            android.graphics.drawable.Drawable r1 = r11.a(r1)
            r10.a(r1)
            int r1 = androidx.appcompat.a.j.Spinner_android_prompt
            java.lang.String r1 = r0.d(r1)
            r10.a(r1)
            r11.a()
            r6.i = r10
            androidx.appcompat.widget.AppCompatSpinner$1 r11 = new androidx.appcompat.widget.AppCompatSpinner$1
            r11.<init>(r6)
            r6.f = r11
            goto Lb3
        La1:
            androidx.appcompat.widget.AppCompatSpinner$a r10 = new androidx.appcompat.widget.AppCompatSpinner$a
            r10.<init>()
            r6.i = r10
            androidx.appcompat.widget.AppCompatSpinner$d r10 = r6.i
            int r11 = androidx.appcompat.a.j.Spinner_android_prompt
            java.lang.String r11 = r0.d(r11)
            r10.a(r11)
        Lb3:
            int r10 = androidx.appcompat.a.j.Spinner_android_entries
            java.lang.CharSequence[] r10 = r0.f(r10)
            if (r10 == 0) goto Lcb
            android.widget.ArrayAdapter r11 = new android.widget.ArrayAdapter
            r1 = 17367048(0x1090008, float:2.5162948E-38)
            r11.<init>(r7, r1, r10)
            int r7 = androidx.appcompat.a.g.support_simple_spinner_dropdown_item
            r11.setDropDownViewResource(r7)
            r6.setAdapter(r11)
        Lcb:
            r0.a()
            r7 = 1
            r6.h = r7
            android.widget.SpinnerAdapter r7 = r6.g
            if (r7 == 0) goto Lda
            r6.setAdapter(r7)
            r6.g = r2
        Lda:
            androidx.appcompat.widget.e r7 = r6.d
            r7.a(r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatSpinner.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.e;
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        d dVar = this.i;
        if (dVar != null) {
            dVar.a(drawable);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(androidx.appcompat.a.a.a.b(getPopupContext(), i));
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        d dVar = this.i;
        if (dVar != null) {
            return dVar.b();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i) {
        d dVar = this.i;
        if (dVar != null) {
            dVar.a(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        d dVar = this.i;
        if (dVar != null) {
            return dVar.c();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i) {
        d dVar = this.i;
        if (dVar != null) {
            dVar.c(i);
            this.i.b(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        d dVar = this.i;
        if (dVar != null) {
            return dVar.f();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i) {
        if (this.i != null) {
            this.f271a = i;
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i);
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.i != null) {
            return this.f271a;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.h) {
            this.g = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.i != null) {
            Context context = this.e;
            if (context == null) {
                context = getContext();
            }
            this.i.a(new b(spinnerAdapter, context.getTheme()));
        }
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d dVar = this.i;
        if (dVar == null || !dVar.e()) {
            return;
        }
        this.i.d();
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        af afVar = this.f;
        if (afVar == null || !afVar.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.i == null || View.MeasureSpec.getMode(i) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        d dVar = this.i;
        if (dVar != null) {
            if (dVar.e()) {
                return true;
            }
            a();
            return true;
        }
        return super.performClick();
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        d dVar = this.i;
        if (dVar != null) {
            dVar.a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        d dVar = this.i;
        return dVar != null ? dVar.a() : super.getPrompt();
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        e eVar = this.d;
        if (eVar != null) {
            eVar.a(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.d;
        if (eVar != null) {
            eVar.a(drawable);
        }
    }

    @Override // androidx.core.f.u
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.d;
        if (eVar != null) {
            eVar.a(colorStateList);
        }
    }

    @Override // androidx.core.f.u
    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.d;
        if (eVar != null) {
            return eVar.a();
        }
        return null;
    }

    @Override // androidx.core.f.u
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.d;
        if (eVar != null) {
            eVar.a(mode);
        }
    }

    @Override // androidx.core.f.u
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.d;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.d;
        if (eVar != null) {
            eVar.c();
        }
    }

    int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i2 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i2 = Math.max(i2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return i2;
        }
        drawable.getPadding(this.b);
        return i2 + this.b.left + this.b.right;
    }

    final d getInternalPopup() {
        return this.i;
    }

    void a() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.i.a(getTextDirection(), getTextAlignment());
        } else {
            this.i.a(-1, -1);
        }
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        d dVar = this.i;
        savedState.f274a = dVar != null && dVar.e();
        return savedState;
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (!savedState.f274a || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.widget.AppCompatSpinner.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (!AppCompatSpinner.this.getInternalPopup().e()) {
                    AppCompatSpinner.this.a();
                }
                ViewTreeObserver viewTreeObserver2 = AppCompatSpinner.this.getViewTreeObserver();
                if (viewTreeObserver2 != null) {
                    if (Build.VERSION.SDK_INT >= 16) {
                        viewTreeObserver2.removeOnGlobalLayoutListener(this);
                    } else {
                        viewTreeObserver2.removeGlobalOnLayoutListener(this);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.appcompat.widget.AppCompatSpinner.SavedState.1
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
        boolean f274a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f274a = parcel.readByte() != 0;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.f274a ? (byte) 1 : (byte) 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements ListAdapter, SpinnerAdapter {

        /* renamed from: a, reason: collision with root package name */
        private SpinnerAdapter f276a;
        private ListAdapter b;

        @Override // android.widget.Adapter
        public int getItemViewType(int i) {
            return 0;
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        public b(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f276a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.b = (ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                    ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                    if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                        themedSpinnerAdapter.setDropDownViewTheme(theme);
                        return;
                    }
                    return;
                }
                if (spinnerAdapter instanceof aq) {
                    aq aqVar = (aq) spinnerAdapter;
                    if (aqVar.a() == null) {
                        aqVar.a(theme);
                    }
                }
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f276a;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            SpinnerAdapter spinnerAdapter = this.f276a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            SpinnerAdapter spinnerAdapter = this.f276a;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f276a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f276a;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f276a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f276a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }
    }

    /* loaded from: classes.dex */
    class a implements DialogInterface.OnClickListener, d {

        /* renamed from: a, reason: collision with root package name */
        androidx.appcompat.app.c f275a;
        private ListAdapter c;
        private CharSequence d;

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public Drawable b() {
            return null;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public int c() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public int f() {
            return 0;
        }

        a() {
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public void d() {
            androidx.appcompat.app.c cVar = this.f275a;
            if (cVar != null) {
                cVar.dismiss();
                this.f275a = null;
            }
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public boolean e() {
            androidx.appcompat.app.c cVar = this.f275a;
            if (cVar != null) {
                return cVar.isShowing();
            }
            return false;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public void a(ListAdapter listAdapter) {
            this.c = listAdapter;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public void a(CharSequence charSequence) {
            this.d = charSequence;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public CharSequence a() {
            return this.d;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public void a(int i, int i2) {
            if (this.c == null) {
                return;
            }
            c.a aVar = new c.a(AppCompatSpinner.this.getPopupContext());
            CharSequence charSequence = this.d;
            if (charSequence != null) {
                aVar.a(charSequence);
            }
            this.f275a = aVar.a(this.c, AppCompatSpinner.this.getSelectedItemPosition(), this).b();
            ListView a2 = this.f275a.a();
            if (Build.VERSION.SDK_INT >= 17) {
                a2.setTextDirection(i);
                a2.setTextAlignment(i2);
            }
            this.f275a.show();
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            AppCompatSpinner.this.setSelection(i);
            if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                AppCompatSpinner.this.performItemClick(null, i, this.c.getItemId(i));
            }
            d();
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public void a(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public void a(int i) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public void b(int i) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public void c(int i) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }
    }

    /* loaded from: classes.dex */
    class c extends ah implements d {

        /* renamed from: a, reason: collision with root package name */
        ListAdapter f277a;
        private CharSequence h;
        private final Rect i;
        private int j;

        public c(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.i = new Rect();
            b(AppCompatSpinner.this);
            a(true);
            d(0);
            a(new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.widget.AppCompatSpinner.c.1
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                    AppCompatSpinner.this.setSelection(i2);
                    if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                        AppCompatSpinner.this.performItemClick(view, i2, c.this.f277a.getItemId(i2));
                    }
                    c.this.d();
                }
            });
        }

        @Override // androidx.appcompat.widget.ah, androidx.appcompat.widget.AppCompatSpinner.d
        public void a(ListAdapter listAdapter) {
            super.a(listAdapter);
            this.f277a = listAdapter;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public CharSequence a() {
            return this.h;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public void a(CharSequence charSequence) {
            this.h = charSequence;
        }

        void h() {
            int i;
            Drawable b = b();
            int i2 = 0;
            if (b != null) {
                b.getPadding(AppCompatSpinner.this.b);
                i2 = ba.a(AppCompatSpinner.this) ? AppCompatSpinner.this.b.right : -AppCompatSpinner.this.b.left;
            } else {
                Rect rect = AppCompatSpinner.this.b;
                AppCompatSpinner.this.b.right = 0;
                rect.left = 0;
            }
            int paddingLeft = AppCompatSpinner.this.getPaddingLeft();
            int paddingRight = AppCompatSpinner.this.getPaddingRight();
            int width = AppCompatSpinner.this.getWidth();
            if (AppCompatSpinner.this.f271a == -2) {
                int a2 = AppCompatSpinner.this.a((SpinnerAdapter) this.f277a, b());
                int i3 = (AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels - AppCompatSpinner.this.b.left) - AppCompatSpinner.this.b.right;
                if (a2 > i3) {
                    a2 = i3;
                }
                h(Math.max(a2, (width - paddingLeft) - paddingRight));
            } else if (AppCompatSpinner.this.f271a == -1) {
                h((width - paddingLeft) - paddingRight);
            } else {
                h(AppCompatSpinner.this.f271a);
            }
            if (ba.a(AppCompatSpinner.this)) {
                i = i2 + (((width - paddingRight) - l()) - i());
            } else {
                i = i2 + paddingLeft + i();
            }
            b(i);
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public void a(int i, int i2) {
            ViewTreeObserver viewTreeObserver;
            boolean e = e();
            h();
            i(2);
            super.d_();
            ListView g = g();
            g.setChoiceMode(1);
            if (Build.VERSION.SDK_INT >= 17) {
                g.setTextDirection(i);
                g.setTextAlignment(i2);
            }
            j(AppCompatSpinner.this.getSelectedItemPosition());
            if (e || (viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver()) == null) {
                return;
            }
            final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.widget.AppCompatSpinner.c.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    c cVar = c.this;
                    if (!cVar.a(AppCompatSpinner.this)) {
                        c.this.d();
                    } else {
                        c.this.h();
                        c.super.d_();
                    }
                }
            };
            viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
            a(new PopupWindow.OnDismissListener() { // from class: androidx.appcompat.widget.AppCompatSpinner.c.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    ViewTreeObserver viewTreeObserver2 = AppCompatSpinner.this.getViewTreeObserver();
                    if (viewTreeObserver2 != null) {
                        viewTreeObserver2.removeGlobalOnLayoutListener(onGlobalLayoutListener);
                    }
                }
            });
        }

        boolean a(View view) {
            return androidx.core.f.v.A(view) && view.getGlobalVisibleRect(this.i);
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public void c(int i) {
            this.j = i;
        }

        public int i() {
            return this.j;
        }
    }
}
