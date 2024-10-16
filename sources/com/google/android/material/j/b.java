package com.google.android.material.j;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.aw;
import androidx.core.e.d;
import androidx.core.f.t;
import androidx.core.f.v;
import androidx.viewpager.widget.ViewPager;
import com.google.android.gms.nearby.messages.BleSignal;
import com.google.android.material.a;
import com.google.android.material.internal.k;
import com.google.android.material.internal.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

@ViewPager.a
/* loaded from: classes2.dex */
public class b extends HorizontalScrollView {
    private static final int ANIMATION_DURATION = 300;
    static final int DEFAULT_GAP_TEXT_ICON = 8;
    private static final int DEFAULT_HEIGHT = 48;
    private static final int DEFAULT_HEIGHT_WITH_TEXT_ICON = 72;
    static final int FIXED_WRAP_GUTTER_MIN = 16;
    public static final int GRAVITY_CENTER = 1;
    public static final int GRAVITY_FILL = 0;
    public static final int INDICATOR_GRAVITY_BOTTOM = 0;
    public static final int INDICATOR_GRAVITY_CENTER = 1;
    public static final int INDICATOR_GRAVITY_STRETCH = 3;
    public static final int INDICATOR_GRAVITY_TOP = 2;
    private static final int INVALID_WIDTH = -1;
    private static final int MIN_INDICATOR_WIDTH = 24;
    public static final int MODE_FIXED = 1;
    public static final int MODE_SCROLLABLE = 0;
    private static final int TAB_MIN_WIDTH_MARGIN = 56;
    private static final d.a<f> tabPool = new d.c(16);
    private a adapterChangeListener;
    private int contentInsetStart;
    private InterfaceC0119b currentVpSelectedListener;
    boolean inlineLabel;
    int mode;
    private g pageChangeListener;
    private androidx.viewpager.widget.a pagerAdapter;
    private DataSetObserver pagerAdapterObserver;
    private final int requestedTabMaxWidth;
    private final int requestedTabMinWidth;
    private ValueAnimator scrollAnimator;
    private final int scrollableTabMinWidth;
    private InterfaceC0119b selectedListener;
    private final ArrayList<InterfaceC0119b> selectedListeners;
    private f selectedTab;
    private boolean setupViewPagerImplicitly;
    private final e slidingTabIndicator;
    final int tabBackgroundResId;
    int tabGravity;
    ColorStateList tabIconTint;
    PorterDuff.Mode tabIconTintMode;
    int tabIndicatorAnimationDuration;
    boolean tabIndicatorFullWidth;
    int tabIndicatorGravity;
    int tabMaxWidth;
    int tabPaddingBottom;
    int tabPaddingEnd;
    int tabPaddingStart;
    int tabPaddingTop;
    ColorStateList tabRippleColorStateList;
    Drawable tabSelectedIndicator;
    int tabTextAppearance;
    ColorStateList tabTextColors;
    float tabTextMultiLineSize;
    float tabTextSize;
    private final RectF tabViewContentBounds;
    private final d.a<h> tabViewPool;
    private final ArrayList<f> tabs;
    boolean unboundedRipple;
    ViewPager viewPager;

    /* renamed from: com.google.android.material.j.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0119b<T extends f> {
        void a(T t);

        void b(T t);

        void c(T t);
    }

    /* loaded from: classes2.dex */
    public interface c extends InterfaceC0119b {
    }

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.tabStyle);
    }

    public b(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.tabs = new ArrayList<>();
        this.tabViewContentBounds = new RectF();
        this.tabMaxWidth = Integer.MAX_VALUE;
        this.selectedListeners = new ArrayList<>();
        this.tabViewPool = new d.b(12);
        setHorizontalScrollBarEnabled(false);
        this.slidingTabIndicator = new e(context);
        super.addView(this.slidingTabIndicator, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray a2 = k.a(context, attributeSet, a.k.TabLayout, i2, a.j.Widget_Design_TabLayout, a.k.TabLayout_tabTextAppearance);
        this.slidingTabIndicator.b(a2.getDimensionPixelSize(a.k.TabLayout_tabIndicatorHeight, -1));
        this.slidingTabIndicator.a(a2.getColor(a.k.TabLayout_tabIndicatorColor, 0));
        setSelectedTabIndicator(com.google.android.material.f.a.b(context, a2, a.k.TabLayout_tabIndicator));
        setSelectedTabIndicatorGravity(a2.getInt(a.k.TabLayout_tabIndicatorGravity, 0));
        setTabIndicatorFullWidth(a2.getBoolean(a.k.TabLayout_tabIndicatorFullWidth, true));
        int dimensionPixelSize = a2.getDimensionPixelSize(a.k.TabLayout_tabPadding, 0);
        this.tabPaddingBottom = dimensionPixelSize;
        this.tabPaddingEnd = dimensionPixelSize;
        this.tabPaddingTop = dimensionPixelSize;
        this.tabPaddingStart = dimensionPixelSize;
        this.tabPaddingStart = a2.getDimensionPixelSize(a.k.TabLayout_tabPaddingStart, this.tabPaddingStart);
        this.tabPaddingTop = a2.getDimensionPixelSize(a.k.TabLayout_tabPaddingTop, this.tabPaddingTop);
        this.tabPaddingEnd = a2.getDimensionPixelSize(a.k.TabLayout_tabPaddingEnd, this.tabPaddingEnd);
        this.tabPaddingBottom = a2.getDimensionPixelSize(a.k.TabLayout_tabPaddingBottom, this.tabPaddingBottom);
        this.tabTextAppearance = a2.getResourceId(a.k.TabLayout_tabTextAppearance, a.j.TextAppearance_Design_Tab);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(this.tabTextAppearance, a.j.TextAppearance);
        try {
            this.tabTextSize = obtainStyledAttributes.getDimensionPixelSize(a.j.TextAppearance_android_textSize, 0);
            this.tabTextColors = com.google.android.material.f.a.a(context, obtainStyledAttributes, a.j.TextAppearance_android_textColor);
            obtainStyledAttributes.recycle();
            if (a2.hasValue(a.k.TabLayout_tabTextColor)) {
                this.tabTextColors = com.google.android.material.f.a.a(context, a2, a.k.TabLayout_tabTextColor);
            }
            if (a2.hasValue(a.k.TabLayout_tabSelectedTextColor)) {
                this.tabTextColors = createColorStateList(this.tabTextColors.getDefaultColor(), a2.getColor(a.k.TabLayout_tabSelectedTextColor, 0));
            }
            this.tabIconTint = com.google.android.material.f.a.a(context, a2, a.k.TabLayout_tabIconTint);
            this.tabIconTintMode = l.a(a2.getInt(a.k.TabLayout_tabIconTintMode, -1), null);
            this.tabRippleColorStateList = com.google.android.material.f.a.a(context, a2, a.k.TabLayout_tabRippleColor);
            this.tabIndicatorAnimationDuration = a2.getInt(a.k.TabLayout_tabIndicatorAnimationDuration, 300);
            this.requestedTabMinWidth = a2.getDimensionPixelSize(a.k.TabLayout_tabMinWidth, -1);
            this.requestedTabMaxWidth = a2.getDimensionPixelSize(a.k.TabLayout_tabMaxWidth, -1);
            this.tabBackgroundResId = a2.getResourceId(a.k.TabLayout_tabBackground, 0);
            this.contentInsetStart = a2.getDimensionPixelSize(a.k.TabLayout_tabContentStart, 0);
            this.mode = a2.getInt(a.k.TabLayout_tabMode, 1);
            this.tabGravity = a2.getInt(a.k.TabLayout_tabGravity, 0);
            this.inlineLabel = a2.getBoolean(a.k.TabLayout_tabInlineLabel, false);
            this.unboundedRipple = a2.getBoolean(a.k.TabLayout_tabUnboundedRipple, false);
            a2.recycle();
            Resources resources = getResources();
            this.tabTextMultiLineSize = resources.getDimensionPixelSize(a.d.design_tab_text_size_2line);
            this.scrollableTabMinWidth = resources.getDimensionPixelSize(a.d.design_tab_scrollable_min_width);
            applyModeAndGravity();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void setSelectedTabIndicatorColor(int i2) {
        this.slidingTabIndicator.a(i2);
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i2) {
        this.slidingTabIndicator.b(i2);
    }

    public void setScrollPosition(int i2, float f2, boolean z) {
        setScrollPosition(i2, f2, z, true);
    }

    void setScrollPosition(int i2, float f2, boolean z, boolean z2) {
        int round = Math.round(i2 + f2);
        if (round < 0 || round >= this.slidingTabIndicator.getChildCount()) {
            return;
        }
        if (z2) {
            this.slidingTabIndicator.a(i2, f2);
        }
        ValueAnimator valueAnimator = this.scrollAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.scrollAnimator.cancel();
        }
        scrollTo(calculateScrollXForTab(i2, f2), 0);
        if (z) {
            setSelectedTabView(round);
        }
    }

    public void addTab(f fVar) {
        addTab(fVar, this.tabs.isEmpty());
    }

    public void addTab(f fVar, int i2) {
        addTab(fVar, i2, this.tabs.isEmpty());
    }

    public void addTab(f fVar, boolean z) {
        addTab(fVar, this.tabs.size(), z);
    }

    public void addTab(f fVar, int i2, boolean z) {
        if (fVar.f5309a != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        configureTab(fVar, i2);
        addTabView(fVar);
        if (z) {
            fVar.e();
        }
    }

    private void addTabFromItemView(com.google.android.material.j.a aVar) {
        f newTab = newTab();
        if (aVar.f5302a != null) {
            newTab.a(aVar.f5302a);
        }
        if (aVar.b != null) {
            newTab.a(aVar.b);
        }
        if (aVar.c != 0) {
            newTab.a(aVar.c);
        }
        if (!TextUtils.isEmpty(aVar.getContentDescription())) {
            newTab.b(aVar.getContentDescription());
        }
        addTab(newTab);
    }

    @Deprecated
    public void setOnTabSelectedListener(InterfaceC0119b interfaceC0119b) {
        InterfaceC0119b interfaceC0119b2 = this.selectedListener;
        if (interfaceC0119b2 != null) {
            removeOnTabSelectedListener(interfaceC0119b2);
        }
        this.selectedListener = interfaceC0119b;
        if (interfaceC0119b != null) {
            addOnTabSelectedListener(interfaceC0119b);
        }
    }

    public void addOnTabSelectedListener(InterfaceC0119b interfaceC0119b) {
        if (this.selectedListeners.contains(interfaceC0119b)) {
            return;
        }
        this.selectedListeners.add(interfaceC0119b);
    }

    public void removeOnTabSelectedListener(InterfaceC0119b interfaceC0119b) {
        this.selectedListeners.remove(interfaceC0119b);
    }

    public void clearOnTabSelectedListeners() {
        this.selectedListeners.clear();
    }

    public f newTab() {
        f createTabFromPool = createTabFromPool();
        createTabFromPool.f5309a = this;
        createTabFromPool.b = createTabView(createTabFromPool);
        return createTabFromPool;
    }

    protected f createTabFromPool() {
        f a2 = tabPool.a();
        return a2 == null ? new f() : a2;
    }

    protected boolean releaseFromTabPool(f fVar) {
        return tabPool.a(fVar);
    }

    public int getTabCount() {
        return this.tabs.size();
    }

    public f getTabAt(int i2) {
        if (i2 < 0 || i2 >= getTabCount()) {
            return null;
        }
        return this.tabs.get(i2);
    }

    public int getSelectedTabPosition() {
        f fVar = this.selectedTab;
        if (fVar != null) {
            return fVar.c();
        }
        return -1;
    }

    public void removeTab(f fVar) {
        if (fVar.f5309a != this) {
            throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
        }
        removeTabAt(fVar.c());
    }

    public void removeTabAt(int i2) {
        f fVar = this.selectedTab;
        int c2 = fVar != null ? fVar.c() : 0;
        removeTabViewAt(i2);
        f remove = this.tabs.remove(i2);
        if (remove != null) {
            remove.h();
            releaseFromTabPool(remove);
        }
        int size = this.tabs.size();
        for (int i3 = i2; i3 < size; i3++) {
            this.tabs.get(i3).b(i3);
        }
        if (c2 == i2) {
            selectTab(this.tabs.isEmpty() ? null : this.tabs.get(Math.max(0, i2 - 1)));
        }
    }

    public void removeAllTabs() {
        for (int childCount = this.slidingTabIndicator.getChildCount() - 1; childCount >= 0; childCount--) {
            removeTabViewAt(childCount);
        }
        Iterator<f> it = this.tabs.iterator();
        while (it.hasNext()) {
            f next = it.next();
            it.remove();
            next.h();
            releaseFromTabPool(next);
        }
        this.selectedTab = null;
    }

    public void setTabMode(int i2) {
        if (i2 != this.mode) {
            this.mode = i2;
            applyModeAndGravity();
        }
    }

    public int getTabMode() {
        return this.mode;
    }

    public void setTabGravity(int i2) {
        if (this.tabGravity != i2) {
            this.tabGravity = i2;
            applyModeAndGravity();
        }
    }

    public int getTabGravity() {
        return this.tabGravity;
    }

    public void setSelectedTabIndicatorGravity(int i2) {
        if (this.tabIndicatorGravity != i2) {
            this.tabIndicatorGravity = i2;
            v.d(this.slidingTabIndicator);
        }
    }

    public int getTabIndicatorGravity() {
        return this.tabIndicatorGravity;
    }

    public void setTabIndicatorFullWidth(boolean z) {
        this.tabIndicatorFullWidth = z;
        v.d(this.slidingTabIndicator);
    }

    public boolean isTabIndicatorFullWidth() {
        return this.tabIndicatorFullWidth;
    }

    public void setInlineLabel(boolean z) {
        if (this.inlineLabel != z) {
            this.inlineLabel = z;
            for (int i2 = 0; i2 < this.slidingTabIndicator.getChildCount(); i2++) {
                View childAt = this.slidingTabIndicator.getChildAt(i2);
                if (childAt instanceof h) {
                    ((h) childAt).c();
                }
            }
            applyModeAndGravity();
        }
    }

    public void setInlineLabelResource(int i2) {
        setInlineLabel(getResources().getBoolean(i2));
    }

    public boolean isInlineLabel() {
        return this.inlineLabel;
    }

    public void setUnboundedRipple(boolean z) {
        if (this.unboundedRipple != z) {
            this.unboundedRipple = z;
            for (int i2 = 0; i2 < this.slidingTabIndicator.getChildCount(); i2++) {
                View childAt = this.slidingTabIndicator.getChildAt(i2);
                if (childAt instanceof h) {
                    ((h) childAt).a(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(int i2) {
        setUnboundedRipple(getResources().getBoolean(i2));
    }

    public boolean hasUnboundedRipple() {
        return this.unboundedRipple;
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.tabTextColors != colorStateList) {
            this.tabTextColors = colorStateList;
            updateAllTabs();
        }
    }

    public ColorStateList getTabTextColors() {
        return this.tabTextColors;
    }

    public void setTabTextColors(int i2, int i3) {
        setTabTextColors(createColorStateList(i2, i3));
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.tabIconTint != colorStateList) {
            this.tabIconTint = colorStateList;
            updateAllTabs();
        }
    }

    public void setTabIconTintResource(int i2) {
        setTabIconTint(androidx.appcompat.a.a.a.a(getContext(), i2));
    }

    public ColorStateList getTabIconTint() {
        return this.tabIconTint;
    }

    public ColorStateList getTabRippleColor() {
        return this.tabRippleColorStateList;
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.tabRippleColorStateList != colorStateList) {
            this.tabRippleColorStateList = colorStateList;
            for (int i2 = 0; i2 < this.slidingTabIndicator.getChildCount(); i2++) {
                View childAt = this.slidingTabIndicator.getChildAt(i2);
                if (childAt instanceof h) {
                    ((h) childAt).a(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(int i2) {
        setTabRippleColor(androidx.appcompat.a.a.a.a(getContext(), i2));
    }

    public Drawable getTabSelectedIndicator() {
        return this.tabSelectedIndicator;
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (this.tabSelectedIndicator != drawable) {
            this.tabSelectedIndicator = drawable;
            v.d(this.slidingTabIndicator);
        }
    }

    public void setSelectedTabIndicator(int i2) {
        if (i2 != 0) {
            setSelectedTabIndicator(androidx.appcompat.a.a.a.b(getContext(), i2));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }

    public void setupWithViewPager(ViewPager viewPager) {
        setupWithViewPager(viewPager, true);
    }

    public void setupWithViewPager(ViewPager viewPager, boolean z) {
        setupWithViewPager(viewPager, z, false);
    }

    private void setupWithViewPager(ViewPager viewPager, boolean z, boolean z2) {
        ViewPager viewPager2 = this.viewPager;
        if (viewPager2 != null) {
            g gVar = this.pageChangeListener;
            if (gVar != null) {
                viewPager2.b(gVar);
            }
            a aVar = this.adapterChangeListener;
            if (aVar != null) {
                this.viewPager.b(aVar);
            }
        }
        InterfaceC0119b interfaceC0119b = this.currentVpSelectedListener;
        if (interfaceC0119b != null) {
            removeOnTabSelectedListener(interfaceC0119b);
            this.currentVpSelectedListener = null;
        }
        if (viewPager != null) {
            this.viewPager = viewPager;
            if (this.pageChangeListener == null) {
                this.pageChangeListener = new g(this);
            }
            this.pageChangeListener.a();
            viewPager.a(this.pageChangeListener);
            this.currentVpSelectedListener = new i(viewPager);
            addOnTabSelectedListener(this.currentVpSelectedListener);
            androidx.viewpager.widget.a adapter = viewPager.getAdapter();
            if (adapter != null) {
                setPagerAdapter(adapter, z);
            }
            if (this.adapterChangeListener == null) {
                this.adapterChangeListener = new a();
            }
            this.adapterChangeListener.a(z);
            viewPager.a(this.adapterChangeListener);
            setScrollPosition(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.viewPager = null;
            setPagerAdapter(null, false);
        }
        this.setupViewPagerImplicitly = z2;
    }

    @Deprecated
    public void setTabsFromPagerAdapter(androidx.viewpager.widget.a aVar) {
        setPagerAdapter(aVar, false);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.viewPager == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                setupWithViewPager((ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.setupViewPagerImplicitly) {
            setupWithViewPager(null);
            this.setupViewPagerImplicitly = false;
        }
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.slidingTabIndicator.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    void setPagerAdapter(androidx.viewpager.widget.a aVar, boolean z) {
        DataSetObserver dataSetObserver;
        androidx.viewpager.widget.a aVar2 = this.pagerAdapter;
        if (aVar2 != null && (dataSetObserver = this.pagerAdapterObserver) != null) {
            aVar2.unregisterDataSetObserver(dataSetObserver);
        }
        this.pagerAdapter = aVar;
        if (z && aVar != null) {
            if (this.pagerAdapterObserver == null) {
                this.pagerAdapterObserver = new d();
            }
            aVar.registerDataSetObserver(this.pagerAdapterObserver);
        }
        populateFromPagerAdapter();
    }

    void populateFromPagerAdapter() {
        int currentItem;
        removeAllTabs();
        androidx.viewpager.widget.a aVar = this.pagerAdapter;
        if (aVar != null) {
            int count = aVar.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                addTab(newTab().a(this.pagerAdapter.getPageTitle(i2)), false);
            }
            ViewPager viewPager = this.viewPager;
            if (viewPager == null || count <= 0 || (currentItem = viewPager.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
                return;
            }
            selectTab(getTabAt(currentItem));
        }
    }

    private void updateAllTabs() {
        int size = this.tabs.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.tabs.get(i2).g();
        }
    }

    private h createTabView(f fVar) {
        d.a<h> aVar = this.tabViewPool;
        h a2 = aVar != null ? aVar.a() : null;
        if (a2 == null) {
            a2 = new h(getContext());
        }
        a2.a(fVar);
        a2.setFocusable(true);
        a2.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(fVar.f)) {
            a2.setContentDescription(fVar.e);
        } else {
            a2.setContentDescription(fVar.f);
        }
        return a2;
    }

    private void configureTab(f fVar, int i2) {
        fVar.b(i2);
        this.tabs.add(i2, fVar);
        int size = this.tabs.size();
        while (true) {
            i2++;
            if (i2 >= size) {
                return;
            } else {
                this.tabs.get(i2).b(i2);
            }
        }
    }

    private void addTabView(f fVar) {
        this.slidingTabIndicator.addView(fVar.b, fVar.c(), createLayoutParamsForTabs());
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        addViewInternal(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2) {
        addViewInternal(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        addViewInternal(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        addViewInternal(view);
    }

    private void addViewInternal(View view) {
        if (view instanceof com.google.android.material.j.a) {
            addTabFromItemView((com.google.android.material.j.a) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private LinearLayout.LayoutParams createLayoutParamsForTabs() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        updateTabViewLayoutParams(layoutParams);
        return layoutParams;
    }

    private void updateTabViewLayoutParams(LinearLayout.LayoutParams layoutParams) {
        if (this.mode == 1 && this.tabGravity == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        }
    }

    int dpToPx(int i2) {
        return Math.round(getResources().getDisplayMetrics().density * i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        for (int i2 = 0; i2 < this.slidingTabIndicator.getChildCount(); i2++) {
            View childAt = this.slidingTabIndicator.getChildAt(i2);
            if (childAt instanceof h) {
                ((h) childAt).a(canvas);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        int dpToPx = dpToPx(getDefaultHeight()) + getPaddingTop() + getPaddingBottom();
        int mode = View.MeasureSpec.getMode(i3);
        if (mode == Integer.MIN_VALUE) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.min(dpToPx, View.MeasureSpec.getSize(i3)), 1073741824);
        } else if (mode == 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(dpToPx, 1073741824);
        }
        int size = View.MeasureSpec.getSize(i2);
        if (View.MeasureSpec.getMode(i2) != 0) {
            int i4 = this.requestedTabMaxWidth;
            if (i4 <= 0) {
                i4 = size - dpToPx(56);
            }
            this.tabMaxWidth = i4;
        }
        super.onMeasure(i2, i3);
        if (getChildCount() == 1) {
            boolean z = false;
            View childAt = getChildAt(0);
            switch (this.mode) {
                case 0:
                    if (childAt.getMeasuredWidth() < getMeasuredWidth()) {
                        z = true;
                        break;
                    }
                    break;
                case 1:
                    if (childAt.getMeasuredWidth() != getMeasuredWidth()) {
                        z = true;
                        break;
                    }
                    break;
            }
            if (z) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
            }
        }
    }

    private void removeTabViewAt(int i2) {
        h hVar = (h) this.slidingTabIndicator.getChildAt(i2);
        this.slidingTabIndicator.removeViewAt(i2);
        if (hVar != null) {
            hVar.a();
            this.tabViewPool.a(hVar);
        }
        requestLayout();
    }

    private void animateToTab(int i2) {
        if (i2 == -1) {
            return;
        }
        if (getWindowToken() == null || !v.x(this) || this.slidingTabIndicator.a()) {
            setScrollPosition(i2, 0.0f, true);
            return;
        }
        int scrollX = getScrollX();
        int calculateScrollXForTab = calculateScrollXForTab(i2, 0.0f);
        if (scrollX != calculateScrollXForTab) {
            ensureScrollAnimator();
            this.scrollAnimator.setIntValues(scrollX, calculateScrollXForTab);
            this.scrollAnimator.start();
        }
        this.slidingTabIndicator.b(i2, this.tabIndicatorAnimationDuration);
    }

    private void ensureScrollAnimator() {
        if (this.scrollAnimator == null) {
            this.scrollAnimator = new ValueAnimator();
            this.scrollAnimator.setInterpolator(com.google.android.material.a.a.b);
            this.scrollAnimator.setDuration(this.tabIndicatorAnimationDuration);
            this.scrollAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.j.b.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    b.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
                }
            });
        }
    }

    void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        ensureScrollAnimator();
        this.scrollAnimator.addListener(animatorListener);
    }

    private void setSelectedTabView(int i2) {
        int childCount = this.slidingTabIndicator.getChildCount();
        if (i2 < childCount) {
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = this.slidingTabIndicator.getChildAt(i3);
                boolean z = true;
                childAt.setSelected(i3 == i2);
                if (i3 != i2) {
                    z = false;
                }
                childAt.setActivated(z);
                i3++;
            }
        }
    }

    void selectTab(f fVar) {
        selectTab(fVar, true);
    }

    void selectTab(f fVar, boolean z) {
        f fVar2 = this.selectedTab;
        if (fVar2 == fVar) {
            if (fVar2 != null) {
                dispatchTabReselected(fVar);
                animateToTab(fVar.c());
                return;
            }
            return;
        }
        int c2 = fVar != null ? fVar.c() : -1;
        if (z) {
            if ((fVar2 == null || fVar2.c() == -1) && c2 != -1) {
                setScrollPosition(c2, 0.0f, true);
            } else {
                animateToTab(c2);
            }
            if (c2 != -1) {
                setSelectedTabView(c2);
            }
        }
        this.selectedTab = fVar;
        if (fVar2 != null) {
            dispatchTabUnselected(fVar2);
        }
        if (fVar != null) {
            dispatchTabSelected(fVar);
        }
    }

    private void dispatchTabSelected(f fVar) {
        for (int size = this.selectedListeners.size() - 1; size >= 0; size--) {
            this.selectedListeners.get(size).a(fVar);
        }
    }

    private void dispatchTabUnselected(f fVar) {
        for (int size = this.selectedListeners.size() - 1; size >= 0; size--) {
            this.selectedListeners.get(size).b(fVar);
        }
    }

    private void dispatchTabReselected(f fVar) {
        for (int size = this.selectedListeners.size() - 1; size >= 0; size--) {
            this.selectedListeners.get(size).c(fVar);
        }
    }

    private int calculateScrollXForTab(int i2, float f2) {
        if (this.mode != 0) {
            return 0;
        }
        View childAt = this.slidingTabIndicator.getChildAt(i2);
        int i3 = i2 + 1;
        View childAt2 = i3 < this.slidingTabIndicator.getChildCount() ? this.slidingTabIndicator.getChildAt(i3) : null;
        int width = childAt != null ? childAt.getWidth() : 0;
        int width2 = childAt2 != null ? childAt2.getWidth() : 0;
        int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        int i4 = (int) ((width + width2) * 0.5f * f2);
        return v.f(this) == 0 ? left + i4 : left - i4;
    }

    private void applyModeAndGravity() {
        v.b(this.slidingTabIndicator, this.mode == 0 ? Math.max(0, this.contentInsetStart - this.tabPaddingStart) : 0, 0, 0, 0);
        switch (this.mode) {
            case 0:
                this.slidingTabIndicator.setGravity(8388611);
                break;
            case 1:
                this.slidingTabIndicator.setGravity(1);
                break;
        }
        updateTabViews(true);
    }

    void updateTabViews(boolean z) {
        for (int i2 = 0; i2 < this.slidingTabIndicator.getChildCount(); i2++) {
            View childAt = this.slidingTabIndicator.getChildAt(i2);
            childAt.setMinimumWidth(getTabMinWidth());
            updateTabViewLayoutParams((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z) {
                childAt.requestLayout();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public b f5309a;
        public h b;
        private Object c;
        private Drawable d;
        private CharSequence e;
        private CharSequence f;
        private int g = -1;
        private View h;

        public View a() {
            return this.h;
        }

        public f a(View view) {
            this.h = view;
            g();
            return this;
        }

        public f a(int i) {
            return a(LayoutInflater.from(this.b.getContext()).inflate(i, (ViewGroup) this.b, false));
        }

        public Drawable b() {
            return this.d;
        }

        public int c() {
            return this.g;
        }

        void b(int i) {
            this.g = i;
        }

        public CharSequence d() {
            return this.e;
        }

        public f a(Drawable drawable) {
            this.d = drawable;
            g();
            return this;
        }

        public f a(CharSequence charSequence) {
            if (TextUtils.isEmpty(this.f) && !TextUtils.isEmpty(charSequence)) {
                this.b.setContentDescription(charSequence);
            }
            this.e = charSequence;
            g();
            return this;
        }

        public void e() {
            b bVar = this.f5309a;
            if (bVar == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            bVar.selectTab(this);
        }

        public boolean f() {
            b bVar = this.f5309a;
            if (bVar != null) {
                return bVar.getSelectedTabPosition() == this.g;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public f b(CharSequence charSequence) {
            this.f = charSequence;
            g();
            return this;
        }

        void g() {
            h hVar = this.b;
            if (hVar != null) {
                hVar.b();
            }
        }

        void h() {
            this.f5309a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = -1;
            this.h = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class h extends LinearLayout {
        private f b;
        private TextView c;
        private ImageView d;
        private View e;
        private TextView f;
        private ImageView g;
        private Drawable h;
        private int i;

        public h(Context context) {
            super(context);
            this.i = 2;
            a(context);
            v.b(this, b.this.tabPaddingStart, b.this.tabPaddingTop, b.this.tabPaddingEnd, b.this.tabPaddingBottom);
            setGravity(17);
            setOrientation(!b.this.inlineLabel ? 1 : 0);
            setClickable(true);
            v.a(this, t.a(getContext(), 1002));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Context context) {
            if (b.this.tabBackgroundResId != 0) {
                this.h = androidx.appcompat.a.a.a.b(context, b.this.tabBackgroundResId);
                Drawable drawable = this.h;
                if (drawable != null && drawable.isStateful()) {
                    this.h.setState(getDrawableState());
                }
            } else {
                this.h = null;
            }
            Drawable gradientDrawable = new GradientDrawable();
            ((GradientDrawable) gradientDrawable).setColor(0);
            if (b.this.tabRippleColorStateList != null) {
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setCornerRadius(1.0E-5f);
                gradientDrawable2.setColor(-1);
                ColorStateList a2 = com.google.android.material.g.a.a(b.this.tabRippleColorStateList);
                if (Build.VERSION.SDK_INT >= 21) {
                    if (b.this.unboundedRipple) {
                        gradientDrawable = null;
                    }
                    if (b.this.unboundedRipple) {
                        gradientDrawable2 = null;
                    }
                    gradientDrawable = new RippleDrawable(a2, gradientDrawable, gradientDrawable2);
                } else {
                    Drawable g = androidx.core.graphics.drawable.a.g(gradientDrawable2);
                    androidx.core.graphics.drawable.a.a(g, a2);
                    gradientDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, g});
                }
            }
            v.a(this, gradientDrawable);
            b.this.invalidate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Canvas canvas) {
            Drawable drawable = this.h;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.h.draw(canvas);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.h;
            boolean z = false;
            if (drawable != null && drawable.isStateful()) {
                z = false | this.h.setState(drawableState);
            }
            if (z) {
                invalidate();
                b.this.invalidate();
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.b == null) {
                return performClick;
            }
            if (!performClick) {
                playSoundEffect(0);
            }
            this.b.e();
            return true;
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z && Build.VERSION.SDK_INT < 16) {
                sendAccessibilityEvent(4);
            }
            TextView textView = this.c;
            if (textView != null) {
                textView.setSelected(z);
            }
            ImageView imageView = this.d;
            if (imageView != null) {
                imageView.setSelected(z);
            }
            View view = this.e;
            if (view != null) {
                view.setSelected(z);
            }
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(a.c.class.getName());
        }

        @Override // android.view.View
        @TargetApi(14)
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(a.c.class.getName());
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            int tabMaxWidth = b.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i = View.MeasureSpec.makeMeasureSpec(b.this.tabMaxWidth, BleSignal.UNKNOWN_TX_POWER);
            }
            super.onMeasure(i, i2);
            if (this.c != null) {
                float f = b.this.tabTextSize;
                int i3 = this.i;
                ImageView imageView = this.d;
                boolean z = true;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.c;
                    if (textView != null && textView.getLineCount() > 1) {
                        f = b.this.tabTextMultiLineSize;
                    }
                } else {
                    i3 = 1;
                }
                float textSize = this.c.getTextSize();
                int lineCount = this.c.getLineCount();
                int a2 = androidx.core.widget.i.a(this.c);
                if (f != textSize || (a2 >= 0 && i3 != a2)) {
                    if (b.this.mode == 1 && f > textSize && lineCount == 1 && ((layout = this.c.getLayout()) == null || a(layout, 0, f) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                        z = false;
                    }
                    if (z) {
                        this.c.setTextSize(0, f);
                        this.c.setMaxLines(i3);
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        void a(f fVar) {
            if (fVar != this.b) {
                this.b = fVar;
                b();
            }
        }

        void a() {
            a((f) null);
            setSelected(false);
        }

        final void b() {
            f fVar = this.b;
            Drawable drawable = null;
            View a2 = fVar != null ? fVar.a() : null;
            if (a2 != null) {
                ViewParent parent = a2.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(a2);
                    }
                    addView(a2);
                }
                this.e = a2;
                TextView textView = this.c;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.d;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.d.setImageDrawable(null);
                }
                this.f = (TextView) a2.findViewById(R.id.text1);
                TextView textView2 = this.f;
                if (textView2 != null) {
                    this.i = androidx.core.widget.i.a(textView2);
                }
                this.g = (ImageView) a2.findViewById(R.id.icon);
            } else {
                View view = this.e;
                if (view != null) {
                    removeView(view);
                    this.e = null;
                }
                this.f = null;
                this.g = null;
            }
            boolean z = false;
            if (this.e == null) {
                if (this.d == null) {
                    ImageView imageView2 = (ImageView) LayoutInflater.from(getContext()).inflate(a.h.design_layout_tab_icon, (ViewGroup) this, false);
                    addView(imageView2, 0);
                    this.d = imageView2;
                }
                if (fVar != null && fVar.b() != null) {
                    drawable = androidx.core.graphics.drawable.a.g(fVar.b()).mutate();
                }
                if (drawable != null) {
                    androidx.core.graphics.drawable.a.a(drawable, b.this.tabIconTint);
                    if (b.this.tabIconTintMode != null) {
                        androidx.core.graphics.drawable.a.a(drawable, b.this.tabIconTintMode);
                    }
                }
                if (this.c == null) {
                    TextView textView3 = (TextView) LayoutInflater.from(getContext()).inflate(a.h.design_layout_tab_text, (ViewGroup) this, false);
                    addView(textView3);
                    this.c = textView3;
                    this.i = androidx.core.widget.i.a(this.c);
                }
                androidx.core.widget.i.a(this.c, b.this.tabTextAppearance);
                if (b.this.tabTextColors != null) {
                    this.c.setTextColor(b.this.tabTextColors);
                }
                a(this.c, this.d);
            } else if (this.f != null || this.g != null) {
                a(this.f, this.g);
            }
            if (fVar != null && !TextUtils.isEmpty(fVar.f)) {
                setContentDescription(fVar.f);
            }
            if (fVar != null && fVar.f()) {
                z = true;
            }
            setSelected(z);
        }

        final void c() {
            setOrientation(!b.this.inlineLabel ? 1 : 0);
            if (this.f != null || this.g != null) {
                a(this.f, this.g);
            } else {
                a(this.c, this.d);
            }
        }

        private void a(TextView textView, ImageView imageView) {
            f fVar = this.b;
            Drawable mutate = (fVar == null || fVar.b() == null) ? null : androidx.core.graphics.drawable.a.g(this.b.b()).mutate();
            f fVar2 = this.b;
            CharSequence d = fVar2 != null ? fVar2.d() : null;
            if (imageView != null) {
                if (mutate != null) {
                    imageView.setImageDrawable(mutate);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
            }
            boolean z = !TextUtils.isEmpty(d);
            if (textView != null) {
                if (z) {
                    textView.setText(d);
                    textView.setVisibility(0);
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int dpToPx = (z && imageView.getVisibility() == 0) ? b.this.dpToPx(8) : 0;
                if (b.this.inlineLabel) {
                    if (dpToPx != androidx.core.f.g.b(marginLayoutParams)) {
                        androidx.core.f.g.a(marginLayoutParams, dpToPx);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (dpToPx != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = dpToPx;
                    androidx.core.f.g.a(marginLayoutParams, 0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            f fVar3 = this.b;
            CharSequence charSequence = fVar3 != null ? fVar3.f : null;
            if (z) {
                charSequence = null;
            }
            aw.a(this, charSequence);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int d() {
            int i = 0;
            int i2 = 0;
            boolean z = false;
            for (View view : new View[]{this.c, this.d, this.e}) {
                if (view != null && view.getVisibility() == 0) {
                    i2 = z ? Math.min(i2, view.getLeft()) : view.getLeft();
                    i = z ? Math.max(i, view.getRight()) : view.getRight();
                    z = true;
                }
            }
            return i - i2;
        }

        private float a(Layout layout, int i, float f) {
            return layout.getLineWidth(i) * (f / layout.getPaint().getTextSize());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class e extends LinearLayout {

        /* renamed from: a, reason: collision with root package name */
        int f5306a;
        float b;
        private int d;
        private final Paint e;
        private final GradientDrawable f;
        private int g;
        private int h;
        private int i;
        private ValueAnimator j;

        e(Context context) {
            super(context);
            this.f5306a = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            setWillNotDraw(false);
            this.e = new Paint();
            this.f = new GradientDrawable();
        }

        void a(int i) {
            if (this.e.getColor() != i) {
                this.e.setColor(i);
                v.d(this);
            }
        }

        void b(int i) {
            if (this.d != i) {
                this.d = i;
                v.d(this);
            }
        }

        boolean a() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        void a(int i, float f) {
            ValueAnimator valueAnimator = this.j;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.j.cancel();
            }
            this.f5306a = i;
            this.b = f;
            b();
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i) {
            super.onRtlPropertiesChanged(i);
            if (Build.VERSION.SDK_INT >= 23 || this.g == i) {
                return;
            }
            requestLayout();
            this.g = i;
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (View.MeasureSpec.getMode(i) != 1073741824) {
                return;
            }
            boolean z = true;
            if (b.this.mode == 1 && b.this.tabGravity == 1) {
                int childCount = getChildCount();
                int i3 = 0;
                for (int i4 = 0; i4 < childCount; i4++) {
                    View childAt = getChildAt(i4);
                    if (childAt.getVisibility() == 0) {
                        i3 = Math.max(i3, childAt.getMeasuredWidth());
                    }
                }
                if (i3 <= 0) {
                    return;
                }
                if (i3 * childCount <= getMeasuredWidth() - (b.this.dpToPx(16) * 2)) {
                    boolean z2 = false;
                    for (int i5 = 0; i5 < childCount; i5++) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i5).getLayoutParams();
                        if (layoutParams.width != i3 || layoutParams.weight != 0.0f) {
                            layoutParams.width = i3;
                            layoutParams.weight = 0.0f;
                            z2 = true;
                        }
                    }
                    z = z2;
                } else {
                    b bVar = b.this;
                    bVar.tabGravity = 0;
                    bVar.updateTabViews(false);
                }
                if (z) {
                    super.onMeasure(i, i2);
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            ValueAnimator valueAnimator = this.j;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.j.cancel();
                b(this.f5306a, Math.round((1.0f - this.j.getAnimatedFraction()) * ((float) this.j.getDuration())));
                return;
            }
            b();
        }

        private void b() {
            int i;
            int i2;
            View childAt = getChildAt(this.f5306a);
            if (childAt == null || childAt.getWidth() <= 0) {
                i = -1;
                i2 = -1;
            } else {
                i = childAt.getLeft();
                i2 = childAt.getRight();
                if (!b.this.tabIndicatorFullWidth && (childAt instanceof h)) {
                    a((h) childAt, b.this.tabViewContentBounds);
                    i = (int) b.this.tabViewContentBounds.left;
                    i2 = (int) b.this.tabViewContentBounds.right;
                }
                if (this.b > 0.0f && this.f5306a < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.f5306a + 1);
                    int left = childAt2.getLeft();
                    int right = childAt2.getRight();
                    if (!b.this.tabIndicatorFullWidth && (childAt2 instanceof h)) {
                        a((h) childAt2, b.this.tabViewContentBounds);
                        left = (int) b.this.tabViewContentBounds.left;
                        right = (int) b.this.tabViewContentBounds.right;
                    }
                    float f = this.b;
                    i = (int) ((left * f) + ((1.0f - f) * i));
                    i2 = (int) ((right * f) + ((1.0f - f) * i2));
                }
            }
            a(i, i2);
        }

        void a(int i, int i2) {
            if (i == this.h && i2 == this.i) {
                return;
            }
            this.h = i;
            this.i = i2;
            v.d(this);
        }

        void b(final int i, int i2) {
            final int i3;
            final int i4;
            ValueAnimator valueAnimator = this.j;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.j.cancel();
            }
            View childAt = getChildAt(i);
            if (childAt == null) {
                b();
                return;
            }
            int left = childAt.getLeft();
            int right = childAt.getRight();
            if (b.this.tabIndicatorFullWidth || !(childAt instanceof h)) {
                i3 = left;
                i4 = right;
            } else {
                a((h) childAt, b.this.tabViewContentBounds);
                i3 = (int) b.this.tabViewContentBounds.left;
                i4 = (int) b.this.tabViewContentBounds.right;
            }
            final int i5 = this.h;
            final int i6 = this.i;
            if (i5 == i3 && i6 == i4) {
                return;
            }
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.j = valueAnimator2;
            valueAnimator2.setInterpolator(com.google.android.material.a.a.b);
            valueAnimator2.setDuration(i2);
            valueAnimator2.setFloatValues(0.0f, 1.0f);
            valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.j.b.e.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    float animatedFraction = valueAnimator3.getAnimatedFraction();
                    e.this.a(com.google.android.material.a.a.a(i5, i3, animatedFraction), com.google.android.material.a.a.a(i6, i4, animatedFraction));
                }
            });
            valueAnimator2.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.j.b.e.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    e eVar = e.this;
                    eVar.f5306a = i;
                    eVar.b = 0.0f;
                }
            });
            valueAnimator2.start();
        }

        private void a(h hVar, RectF rectF) {
            int d = hVar.d();
            if (d < b.this.dpToPx(24)) {
                d = b.this.dpToPx(24);
            }
            int left = (hVar.getLeft() + hVar.getRight()) / 2;
            int i = d / 2;
            rectF.set(left - i, 0.0f, left + i, 0.0f);
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            int i = 0;
            int intrinsicHeight = b.this.tabSelectedIndicator != null ? b.this.tabSelectedIndicator.getIntrinsicHeight() : 0;
            int i2 = this.d;
            if (i2 >= 0) {
                intrinsicHeight = i2;
            }
            switch (b.this.tabIndicatorGravity) {
                case 0:
                    i = getHeight() - intrinsicHeight;
                    intrinsicHeight = getHeight();
                    break;
                case 1:
                    i = (getHeight() - intrinsicHeight) / 2;
                    intrinsicHeight = (getHeight() + intrinsicHeight) / 2;
                    break;
                case 2:
                    break;
                case 3:
                    intrinsicHeight = getHeight();
                    break;
                default:
                    intrinsicHeight = 0;
                    break;
            }
            int i3 = this.h;
            if (i3 >= 0 && this.i > i3) {
                Drawable g = androidx.core.graphics.drawable.a.g(b.this.tabSelectedIndicator != null ? b.this.tabSelectedIndicator : this.f);
                g.setBounds(this.h, i, this.i, intrinsicHeight);
                if (this.e != null) {
                    if (Build.VERSION.SDK_INT == 21) {
                        g.setColorFilter(this.e.getColor(), PorterDuff.Mode.SRC_IN);
                    } else {
                        androidx.core.graphics.drawable.a.a(g, this.e.getColor());
                    }
                }
                g.draw(canvas);
            }
            super.draw(canvas);
        }
    }

    private static ColorStateList createColorStateList(int i2, int i3) {
        return new ColorStateList(new int[][]{SELECTED_STATE_SET, EMPTY_STATE_SET}, new int[]{i3, i2});
    }

    private int getDefaultHeight() {
        int size = this.tabs.size();
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                f fVar = this.tabs.get(i2);
                if (fVar != null && fVar.b() != null && !TextUtils.isEmpty(fVar.d())) {
                    z = true;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        return (!z || this.inlineLabel) ? 48 : 72;
    }

    private int getTabMinWidth() {
        int i2 = this.requestedTabMinWidth;
        if (i2 != -1) {
            return i2;
        }
        if (this.mode == 0) {
            return this.scrollableTabMinWidth;
        }
        return 0;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    int getTabMaxWidth() {
        return this.tabMaxWidth;
    }

    /* loaded from: classes2.dex */
    public static class g implements ViewPager.f {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<b> f5310a;
        private int b;
        private int c;

        public g(b bVar) {
            this.f5310a = new WeakReference<>(bVar);
        }

        @Override // androidx.viewpager.widget.ViewPager.f
        public void onPageScrollStateChanged(int i) {
            this.b = this.c;
            this.c = i;
        }

        @Override // androidx.viewpager.widget.ViewPager.f
        public void onPageScrolled(int i, float f, int i2) {
            b bVar = this.f5310a.get();
            if (bVar != null) {
                bVar.setScrollPosition(i, f, this.c != 2 || this.b == 1, (this.c == 2 && this.b == 0) ? false : true);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.f
        public void onPageSelected(int i) {
            b bVar = this.f5310a.get();
            if (bVar == null || bVar.getSelectedTabPosition() == i || i >= bVar.getTabCount()) {
                return;
            }
            int i2 = this.c;
            bVar.selectTab(bVar.getTabAt(i), i2 == 0 || (i2 == 2 && this.b == 0));
        }

        void a() {
            this.c = 0;
            this.b = 0;
        }
    }

    /* loaded from: classes2.dex */
    public static class i implements c {

        /* renamed from: a, reason: collision with root package name */
        private final ViewPager f5312a;

        @Override // com.google.android.material.j.b.InterfaceC0119b
        public void b(f fVar) {
        }

        @Override // com.google.android.material.j.b.InterfaceC0119b
        public void c(f fVar) {
        }

        public i(ViewPager viewPager) {
            this.f5312a = viewPager;
        }

        @Override // com.google.android.material.j.b.InterfaceC0119b
        public void a(f fVar) {
            this.f5312a.setCurrentItem(fVar.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d extends DataSetObserver {
        d() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            b.this.populateFromPagerAdapter();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            b.this.populateFromPagerAdapter();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements ViewPager.e {
        private boolean b;

        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.e
        public void a(ViewPager viewPager, androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2) {
            if (b.this.viewPager == viewPager) {
                b.this.setPagerAdapter(aVar2, this.b);
            }
        }

        void a(boolean z) {
            this.b = z;
        }
    }
}
