package androidx.recyclerview.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.f.a.d;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.a;
import androidx.recyclerview.widget.a;
import androidx.recyclerview.widget.b;
import androidx.recyclerview.widget.e;
import androidx.recyclerview.widget.m;
import androidx.recyclerview.widget.n;
import com.amazonaws.event.ProgressEvent;
import com.gcloudsdk.gcloud.voice.GCloudVoiceErrorCode;
import com.google.android.gms.nearby.messages.BleSignal;
import com.intlgame.core.INTLMethodID;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements androidx.core.f.k {
    static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC;
    static final boolean ALLOW_THREAD_GAP_WORK;
    static final boolean DEBUG = false;
    static final int DEFAULT_ORIENTATION = 1;
    static final boolean DISPATCH_TEMP_DETACH = false;
    private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION;
    static final boolean FORCE_INVALIDATE_DISPLAY_LIST;
    static final long FOREVER_NS = Long.MAX_VALUE;
    public static final int HORIZONTAL = 0;
    private static final boolean IGNORE_DETACHED_FOCUSED_CHILD;
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
    static final int MAX_SCROLL_DURATION = 2000;
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    static final boolean POST_UPDATES_ON_ANIMATION;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
    private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    static final String TRACE_PREFETCH_TAG = "RV Prefetch";
    static final String TRACE_SCROLL_TAG = "RV Scroll";
    static final boolean VERBOSE_TRACING = false;
    public static final int VERTICAL = 1;
    static final Interpolator sQuinticInterpolator;
    androidx.recyclerview.widget.j mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    private m mActiveOnItemTouchListener;
    a mAdapter;
    androidx.recyclerview.widget.a mAdapterHelper;
    boolean mAdapterUpdateDuringMeasure;
    private EdgeEffect mBottomGlow;
    private d mChildDrawingOrderCallback;
    androidx.recyclerview.widget.b mChildHelper;
    boolean mClipToPadding;
    boolean mDataSetHasChangedAfterLayout;
    boolean mDispatchItemsChangedEvent;
    private int mDispatchScrollCounter;
    private int mEatenAccessibilityChangeFlags;
    private e mEdgeEffectFactory;
    boolean mEnableFastScroller;
    boolean mFirstLayoutComplete;
    androidx.recyclerview.widget.e mGapWorker;
    boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mInterceptRequestLayoutDepth;
    boolean mIsAttached;
    f mItemAnimator;
    private f.b mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    final ArrayList<h> mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastTouchX;
    private int mLastTouchY;
    i mLayout;
    boolean mLayoutFrozen;
    private int mLayoutOrScrollCounter;
    boolean mLayoutWasDefered;
    private EdgeEffect mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final r mObserver;
    private List<k> mOnChildAttachStateListeners;
    private l mOnFlingListener;
    private final ArrayList<m> mOnItemTouchListeners;
    final List<w> mPendingAccessibilityImportanceChange;
    private SavedState mPendingSavedState;
    boolean mPostedAnimatorRunner;
    e.a mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    final p mRecycler;
    q mRecyclerListener;
    private EdgeEffect mRightGlow;
    private float mScaledHorizontalScrollFactor;
    private float mScaledVerticalScrollFactor;
    final int[] mScrollConsumed;
    private n mScrollListener;
    private List<n> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    final int[] mScrollStepConsumed;
    private androidx.core.f.m mScrollingChildHelper;
    final t mState;
    final Rect mTempRect;
    private final Rect mTempRect2;
    final RectF mTempRectF;
    private EdgeEffect mTopGlow;
    private int mTouchSlop;
    final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    final v mViewFlinger;
    private final n.b mViewInfoProcessCallback;
    final androidx.recyclerview.widget.n mViewInfoStore;
    private static final int[] NESTED_SCROLLING_ATTRS = {R.attr.nestedScrollingEnabled};
    private static final int[] CLIP_TO_PADDING_ATTR = {R.attr.clipToPadding};

    /* loaded from: classes.dex */
    public interface d {
        int a(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface k {
        void a(View view);

        void b(View view);
    }

    /* loaded from: classes.dex */
    public static abstract class l {
        public abstract boolean a(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface m {
        void a(boolean z);

        boolean a(RecyclerView recyclerView, MotionEvent motionEvent);

        void b(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public static abstract class n {
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        }
    }

    /* loaded from: classes.dex */
    public interface q {
        void a(w wVar);
    }

    /* loaded from: classes.dex */
    public static abstract class u {
        public abstract View a(p pVar, int i, int i2);
    }

    public void onChildAttachedToWindow(View view) {
    }

    public void onChildDetachedFromWindow(View view) {
    }

    public void onScrollStateChanged(int i2) {
    }

    public void onScrolled(int i2, int i3) {
    }

    static {
        FORCE_INVALIDATE_DISPLAY_LIST = Build.VERSION.SDK_INT == 18 || Build.VERSION.SDK_INT == 19 || Build.VERSION.SDK_INT == 20;
        ALLOW_SIZE_IN_UNSPECIFIED_SPEC = Build.VERSION.SDK_INT >= 23;
        POST_UPDATES_ON_ANIMATION = Build.VERSION.SDK_INT >= 16;
        ALLOW_THREAD_GAP_WORK = Build.VERSION.SDK_INT >= 21;
        FORCE_ABS_FOCUS_SEARCH_DIRECTION = Build.VERSION.SDK_INT <= 15;
        IGNORE_DETACHED_FOCUSED_CHILD = Build.VERSION.SDK_INT <= 15;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
        sQuinticInterpolator = new Interpolator() { // from class: androidx.recyclerview.widget.RecyclerView.3
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f2) {
                float f3 = f2 - 1.0f;
                return (f3 * f3 * f3 * f3 * f3) + 1.0f;
            }
        };
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mObserver = new r();
        this.mRecycler = new p();
        this.mViewInfoStore = new androidx.recyclerview.widget.n();
        this.mUpdateChildViewsRunnable = new Runnable() { // from class: androidx.recyclerview.widget.RecyclerView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!RecyclerView.this.mFirstLayoutComplete || RecyclerView.this.isLayoutRequested()) {
                    return;
                }
                if (!RecyclerView.this.mIsAttached) {
                    RecyclerView.this.requestLayout();
                } else if (RecyclerView.this.mLayoutFrozen) {
                    RecyclerView.this.mLayoutWasDefered = true;
                } else {
                    RecyclerView.this.consumePendingUpdateOperations();
                }
            }
        };
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mItemDecorations = new ArrayList<>();
        this.mOnItemTouchListeners = new ArrayList<>();
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mEdgeEffectFactory = new e();
        this.mItemAnimator = new androidx.recyclerview.widget.c();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        boolean z = true;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new v();
        this.mPrefetchRegistry = ALLOW_THREAD_GAP_WORK ? new e.a() : null;
        this.mState = new t();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new g();
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mScrollConsumed = new int[2];
        this.mNestedOffsets = new int[2];
        this.mScrollStepConsumed = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mItemAnimatorRunner = new Runnable() { // from class: androidx.recyclerview.widget.RecyclerView.2
            @Override // java.lang.Runnable
            public void run() {
                if (RecyclerView.this.mItemAnimator != null) {
                    RecyclerView.this.mItemAnimator.a();
                }
                RecyclerView.this.mPostedAnimatorRunner = false;
            }
        };
        this.mViewInfoProcessCallback = new n.b() { // from class: androidx.recyclerview.widget.RecyclerView.4
            @Override // androidx.recyclerview.widget.n.b
            public void a(w wVar, f.c cVar, f.c cVar2) {
                RecyclerView.this.mRecycler.c(wVar);
                RecyclerView.this.animateDisappearance(wVar, cVar, cVar2);
            }

            @Override // androidx.recyclerview.widget.n.b
            public void b(w wVar, f.c cVar, f.c cVar2) {
                RecyclerView.this.animateAppearance(wVar, cVar, cVar2);
            }

            @Override // androidx.recyclerview.widget.n.b
            public void c(w wVar, f.c cVar, f.c cVar2) {
                wVar.setIsRecyclable(false);
                if (RecyclerView.this.mDataSetHasChangedAfterLayout) {
                    if (RecyclerView.this.mItemAnimator.a(wVar, wVar, cVar, cVar2)) {
                        RecyclerView.this.postAnimationRunner();
                    }
                } else if (RecyclerView.this.mItemAnimator.c(wVar, cVar, cVar2)) {
                    RecyclerView.this.postAnimationRunner();
                }
            }

            @Override // androidx.recyclerview.widget.n.b
            public void a(w wVar) {
                RecyclerView.this.mLayout.a(wVar.itemView, RecyclerView.this.mRecycler);
            }
        };
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, CLIP_TO_PADDING_ATTR, i2, 0);
            this.mClipToPadding = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            this.mClipToPadding = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mScaledHorizontalScrollFactor = androidx.core.f.w.a(viewConfiguration, context);
        this.mScaledVerticalScrollFactor = androidx.core.f.w.b(viewConfiguration, context);
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.mItemAnimator.a(this.mItemAnimatorListener);
        initAdapterManager();
        initChildrenHelper();
        initAutofill();
        if (androidx.core.f.v.e(this) == 0) {
            androidx.core.f.v.b(this, 1);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new androidx.recyclerview.widget.j(this));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, a.b.RecyclerView, i2, 0);
            String string = obtainStyledAttributes2.getString(a.b.RecyclerView_layoutManager);
            if (obtainStyledAttributes2.getInt(a.b.RecyclerView_android_descendantFocusability, -1) == -1) {
                setDescendantFocusability(262144);
            }
            this.mEnableFastScroller = obtainStyledAttributes2.getBoolean(a.b.RecyclerView_fastScrollEnabled, false);
            if (this.mEnableFastScroller) {
                initFastScroller((StateListDrawable) obtainStyledAttributes2.getDrawable(a.b.RecyclerView_fastScrollVerticalThumbDrawable), obtainStyledAttributes2.getDrawable(a.b.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) obtainStyledAttributes2.getDrawable(a.b.RecyclerView_fastScrollHorizontalThumbDrawable), obtainStyledAttributes2.getDrawable(a.b.RecyclerView_fastScrollHorizontalTrackDrawable));
            }
            obtainStyledAttributes2.recycle();
            createLayoutManager(context, string, attributeSet, i2, 0);
            if (Build.VERSION.SDK_INT >= 21) {
                TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, NESTED_SCROLLING_ATTRS, i2, 0);
                boolean z2 = obtainStyledAttributes3.getBoolean(0, true);
                obtainStyledAttributes3.recycle();
                z = z2;
            }
        } else {
            setDescendantFocusability(262144);
        }
        setNestedScrollingEnabled(z);
    }

    String exceptionLabel() {
        return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + getContext();
    }

    @SuppressLint({"InlinedApi"})
    private void initAutofill() {
        if (androidx.core.f.v.a(this) == 0) {
            androidx.core.f.v.a((View) this, 8);
        }
    }

    public androidx.recyclerview.widget.j getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void setAccessibilityDelegateCompat(androidx.recyclerview.widget.j jVar) {
        this.mAccessibilityDelegate = jVar;
        androidx.core.f.v.a(this, this.mAccessibilityDelegate);
    }

    private void createLayoutManager(Context context, String str, AttributeSet attributeSet, int i2, int i3) {
        ClassLoader classLoader;
        Constructor constructor;
        if (str != null) {
            String trim = str.trim();
            if (trim.isEmpty()) {
                return;
            }
            String fullClassName = getFullClassName(context, trim);
            try {
                if (isInEditMode()) {
                    classLoader = getClass().getClassLoader();
                } else {
                    classLoader = context.getClassLoader();
                }
                Class<? extends U> asSubclass = classLoader.loadClass(fullClassName).asSubclass(i.class);
                Object[] objArr = null;
                try {
                    constructor = asSubclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
                } catch (NoSuchMethodException e2) {
                    try {
                        constructor = asSubclass.getConstructor(new Class[0]);
                    } catch (NoSuchMethodException e3) {
                        e3.initCause(e2);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + fullClassName, e3);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((i) constructor.newInstance(objArr));
            } catch (ClassCastException e4) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + fullClassName, e4);
            } catch (ClassNotFoundException e5) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + fullClassName, e5);
            } catch (IllegalAccessException e6) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + fullClassName, e6);
            } catch (InstantiationException e7) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e7);
            } catch (InvocationTargetException e8) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e8);
            }
        }
    }

    private String getFullClassName(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        if (str.contains(".")) {
            return str;
        }
        return RecyclerView.class.getPackage().getName() + '.' + str;
    }

    private void initChildrenHelper() {
        this.mChildHelper = new androidx.recyclerview.widget.b(new b.InterfaceC0066b() { // from class: androidx.recyclerview.widget.RecyclerView.5
            @Override // androidx.recyclerview.widget.b.InterfaceC0066b
            public int a() {
                return RecyclerView.this.getChildCount();
            }

            @Override // androidx.recyclerview.widget.b.InterfaceC0066b
            public void a(View view, int i2) {
                RecyclerView.this.addView(view, i2);
                RecyclerView.this.dispatchChildAttached(view);
            }

            @Override // androidx.recyclerview.widget.b.InterfaceC0066b
            public int a(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            @Override // androidx.recyclerview.widget.b.InterfaceC0066b
            public void a(int i2) {
                View childAt = RecyclerView.this.getChildAt(i2);
                if (childAt != null) {
                    RecyclerView.this.dispatchChildDetached(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeViewAt(i2);
            }

            @Override // androidx.recyclerview.widget.b.InterfaceC0066b
            public View b(int i2) {
                return RecyclerView.this.getChildAt(i2);
            }

            @Override // androidx.recyclerview.widget.b.InterfaceC0066b
            public void b() {
                int a2 = a();
                for (int i2 = 0; i2 < a2; i2++) {
                    View b2 = b(i2);
                    RecyclerView.this.dispatchChildDetached(b2);
                    b2.clearAnimation();
                }
                RecyclerView.this.removeAllViews();
            }

            @Override // androidx.recyclerview.widget.b.InterfaceC0066b
            public w b(View view) {
                return RecyclerView.getChildViewHolderInt(view);
            }

            @Override // androidx.recyclerview.widget.b.InterfaceC0066b
            public void a(View view, int i2, ViewGroup.LayoutParams layoutParams) {
                w childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    if (!childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + childViewHolderInt + RecyclerView.this.exceptionLabel());
                    }
                    childViewHolderInt.clearTmpDetachFlag();
                }
                RecyclerView.this.attachViewToParent(view, i2, layoutParams);
            }

            @Override // androidx.recyclerview.widget.b.InterfaceC0066b
            public void c(int i2) {
                w childViewHolderInt;
                View b2 = b(i2);
                if (b2 != null && (childViewHolderInt = RecyclerView.getChildViewHolderInt(b2)) != null) {
                    if (childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                        throw new IllegalArgumentException("called detach on an already detached child " + childViewHolderInt + RecyclerView.this.exceptionLabel());
                    }
                    childViewHolderInt.addFlags(256);
                }
                RecyclerView.this.detachViewFromParent(i2);
            }

            @Override // androidx.recyclerview.widget.b.InterfaceC0066b
            public void c(View view) {
                w childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    childViewHolderInt.onEnteredHiddenState(RecyclerView.this);
                }
            }

            @Override // androidx.recyclerview.widget.b.InterfaceC0066b
            public void d(View view) {
                w childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    childViewHolderInt.onLeftHiddenState(RecyclerView.this);
                }
            }
        });
    }

    void initAdapterManager() {
        this.mAdapterHelper = new androidx.recyclerview.widget.a(new a.InterfaceC0065a() { // from class: androidx.recyclerview.widget.RecyclerView.6
            @Override // androidx.recyclerview.widget.a.InterfaceC0065a
            public w a(int i2) {
                w findViewHolderForPosition = RecyclerView.this.findViewHolderForPosition(i2, true);
                if (findViewHolderForPosition == null || RecyclerView.this.mChildHelper.c(findViewHolderForPosition.itemView)) {
                    return null;
                }
                return findViewHolderForPosition;
            }

            @Override // androidx.recyclerview.widget.a.InterfaceC0065a
            public void a(int i2, int i3) {
                RecyclerView.this.offsetPositionRecordsForRemove(i2, i3, true);
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.mItemsAddedOrRemoved = true;
                recyclerView.mState.c += i3;
            }

            @Override // androidx.recyclerview.widget.a.InterfaceC0065a
            public void b(int i2, int i3) {
                RecyclerView.this.offsetPositionRecordsForRemove(i2, i3, false);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }

            @Override // androidx.recyclerview.widget.a.InterfaceC0065a
            public void a(int i2, int i3, Object obj) {
                RecyclerView.this.viewRangeUpdate(i2, i3, obj);
                RecyclerView.this.mItemsChanged = true;
            }

            @Override // androidx.recyclerview.widget.a.InterfaceC0065a
            public void a(a.b bVar) {
                c(bVar);
            }

            void c(a.b bVar) {
                int i2 = bVar.f877a;
                if (i2 == 4) {
                    RecyclerView.this.mLayout.a(RecyclerView.this, bVar.b, bVar.d, bVar.c);
                    return;
                }
                if (i2 != 8) {
                    switch (i2) {
                        case 1:
                            RecyclerView.this.mLayout.a(RecyclerView.this, bVar.b, bVar.d);
                            return;
                        case 2:
                            RecyclerView.this.mLayout.b(RecyclerView.this, bVar.b, bVar.d);
                            return;
                        default:
                            return;
                    }
                }
                RecyclerView.this.mLayout.a(RecyclerView.this, bVar.b, bVar.d, 1);
            }

            @Override // androidx.recyclerview.widget.a.InterfaceC0065a
            public void b(a.b bVar) {
                c(bVar);
            }

            @Override // androidx.recyclerview.widget.a.InterfaceC0065a
            public void c(int i2, int i3) {
                RecyclerView.this.offsetPositionRecordsForInsert(i2, i3);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }

            @Override // androidx.recyclerview.widget.a.InterfaceC0065a
            public void d(int i2, int i3) {
                RecyclerView.this.offsetPositionRecordsForMove(i2, i3);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }
        });
    }

    public void setHasFixedSize(boolean z) {
        this.mHasFixedSize = z;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        if (z != this.mClipToPadding) {
            invalidateGlows();
        }
        this.mClipToPadding = z;
        super.setClipToPadding(z);
        if (this.mFirstLayoutComplete) {
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0008. Please report as an issue. */
    public void setScrollingTouchSlop(int i2) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        switch (i2) {
            case 0:
                this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
                return;
            case 1:
                this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                return;
            default:
                Log.w(TAG, "setScrollingTouchSlop(): bad argument constant " + i2 + "; using default value");
                this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
                return;
        }
    }

    public void swapAdapter(a aVar, boolean z) {
        setLayoutFrozen(false);
        setAdapterInternal(aVar, true, z);
        processDataSetCompletelyChanged(true);
        requestLayout();
    }

    public void setAdapter(a aVar) {
        setLayoutFrozen(false);
        setAdapterInternal(aVar, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeAndRecycleViews() {
        f fVar = this.mItemAnimator;
        if (fVar != null) {
            fVar.d();
        }
        i iVar = this.mLayout;
        if (iVar != null) {
            iVar.c(this.mRecycler);
            this.mLayout.b(this.mRecycler);
        }
        this.mRecycler.a();
    }

    private void setAdapterInternal(a aVar, boolean z, boolean z2) {
        a aVar2 = this.mAdapter;
        if (aVar2 != null) {
            aVar2.unregisterAdapterDataObserver(this.mObserver);
            this.mAdapter.onDetachedFromRecyclerView(this);
        }
        if (!z || z2) {
            removeAndRecycleViews();
        }
        this.mAdapterHelper.a();
        a aVar3 = this.mAdapter;
        this.mAdapter = aVar;
        if (aVar != null) {
            aVar.registerAdapterDataObserver(this.mObserver);
            aVar.onAttachedToRecyclerView(this);
        }
        i iVar = this.mLayout;
        if (iVar != null) {
            iVar.a(aVar3, this.mAdapter);
        }
        this.mRecycler.a(aVar3, this.mAdapter, z);
        this.mState.f = true;
    }

    public a getAdapter() {
        return this.mAdapter;
    }

    public void setRecyclerListener(q qVar) {
        this.mRecyclerListener = qVar;
    }

    @Override // android.view.View
    public int getBaseline() {
        i iVar = this.mLayout;
        if (iVar != null) {
            return iVar.x();
        }
        return super.getBaseline();
    }

    public void addOnChildAttachStateChangeListener(k kVar) {
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList();
        }
        this.mOnChildAttachStateListeners.add(kVar);
    }

    public void removeOnChildAttachStateChangeListener(k kVar) {
        List<k> list = this.mOnChildAttachStateListeners;
        if (list == null) {
            return;
        }
        list.remove(kVar);
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<k> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void setLayoutManager(i iVar) {
        if (iVar == this.mLayout) {
            return;
        }
        stopScroll();
        if (this.mLayout != null) {
            f fVar = this.mItemAnimator;
            if (fVar != null) {
                fVar.d();
            }
            this.mLayout.c(this.mRecycler);
            this.mLayout.b(this.mRecycler);
            this.mRecycler.a();
            if (this.mIsAttached) {
                this.mLayout.b(this, this.mRecycler);
            }
            this.mLayout.b((RecyclerView) null);
            this.mLayout = null;
        } else {
            this.mRecycler.a();
        }
        this.mChildHelper.a();
        this.mLayout = iVar;
        if (iVar != null) {
            if (iVar.q != null) {
                throw new IllegalArgumentException("LayoutManager " + iVar + " is already attached to a RecyclerView:" + iVar.q.exceptionLabel());
            }
            this.mLayout.b(this);
            if (this.mIsAttached) {
                this.mLayout.c(this);
            }
        }
        this.mRecycler.b();
        requestLayout();
    }

    public void setOnFlingListener(l lVar) {
        this.mOnFlingListener = lVar;
    }

    public l getOnFlingListener() {
        return this.mOnFlingListener;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.mPendingSavedState;
        if (savedState2 != null) {
            savedState.a(savedState2);
        } else {
            i iVar = this.mLayout;
            if (iVar != null) {
                savedState.f852a = iVar.e();
            } else {
                savedState.f852a = null;
            }
        }
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        this.mPendingSavedState = (SavedState) parcelable;
        super.onRestoreInstanceState(this.mPendingSavedState.a());
        if (this.mLayout == null || this.mPendingSavedState.f852a == null) {
            return;
        }
        this.mLayout.a(this.mPendingSavedState.f852a);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    private void addAnimatingView(w wVar) {
        View view = wVar.itemView;
        boolean z = view.getParent() == this;
        this.mRecycler.c(getChildViewHolder(view));
        if (wVar.isTmpDetached()) {
            this.mChildHelper.a(view, -1, view.getLayoutParams(), true);
        } else if (!z) {
            this.mChildHelper.a(view, true);
        } else {
            this.mChildHelper.d(view);
        }
    }

    boolean removeAnimatingView(View view) {
        startInterceptRequestLayout();
        boolean f2 = this.mChildHelper.f(view);
        if (f2) {
            w childViewHolderInt = getChildViewHolderInt(view);
            this.mRecycler.c(childViewHolderInt);
            this.mRecycler.b(childViewHolderInt);
        }
        stopInterceptRequestLayout(!f2);
        return f2;
    }

    public i getLayoutManager() {
        return this.mLayout;
    }

    public o getRecycledViewPool() {
        return this.mRecycler.g();
    }

    public void setRecycledViewPool(o oVar) {
        this.mRecycler.a(oVar);
    }

    public void setViewCacheExtension(u uVar) {
        this.mRecycler.a(uVar);
    }

    public void setItemViewCacheSize(int i2) {
        this.mRecycler.a(i2);
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    void setScrollState(int i2) {
        if (i2 == this.mScrollState) {
            return;
        }
        this.mScrollState = i2;
        if (i2 != 2) {
            stopScrollersInternal();
        }
        dispatchOnScrollStateChanged(i2);
    }

    public void addItemDecoration(h hVar, int i2) {
        i iVar = this.mLayout;
        if (iVar != null) {
            iVar.a("Cannot add item decoration during a scroll  or layout");
        }
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i2 < 0) {
            this.mItemDecorations.add(hVar);
        } else {
            this.mItemDecorations.add(i2, hVar);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void addItemDecoration(h hVar) {
        addItemDecoration(hVar, -1);
    }

    public h getItemDecorationAt(int i2) {
        int itemDecorationCount = getItemDecorationCount();
        if (i2 < 0 || i2 >= itemDecorationCount) {
            throw new IndexOutOfBoundsException(i2 + " is an invalid index for size " + itemDecorationCount);
        }
        return this.mItemDecorations.get(i2);
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    public void removeItemDecorationAt(int i2) {
        int itemDecorationCount = getItemDecorationCount();
        if (i2 < 0 || i2 >= itemDecorationCount) {
            throw new IndexOutOfBoundsException(i2 + " is an invalid index for size " + itemDecorationCount);
        }
        removeItemDecoration(getItemDecorationAt(i2));
    }

    public void removeItemDecoration(h hVar) {
        i iVar = this.mLayout;
        if (iVar != null) {
            iVar.a("Cannot remove item decoration during a scroll  or layout");
        }
        this.mItemDecorations.remove(hVar);
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void setChildDrawingOrderCallback(d dVar) {
        if (dVar == this.mChildDrawingOrderCallback) {
            return;
        }
        this.mChildDrawingOrderCallback = dVar;
        setChildrenDrawingOrderEnabled(this.mChildDrawingOrderCallback != null);
    }

    @Deprecated
    public void setOnScrollListener(n nVar) {
        this.mScrollListener = nVar;
    }

    public void addOnScrollListener(n nVar) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }
        this.mScrollListeners.add(nVar);
    }

    public void removeOnScrollListener(n nVar) {
        List<n> list = this.mScrollListeners;
        if (list != null) {
            list.remove(nVar);
        }
    }

    public void clearOnScrollListeners() {
        List<n> list = this.mScrollListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void scrollToPosition(int i2) {
        if (this.mLayoutFrozen) {
            return;
        }
        stopScroll();
        i iVar = this.mLayout;
        if (iVar == null) {
            Log.e(TAG, "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            iVar.e(i2);
            awakenScrollBars();
        }
    }

    void jumpToPositionForSmoothScroller(int i2) {
        i iVar = this.mLayout;
        if (iVar == null) {
            return;
        }
        iVar.e(i2);
        awakenScrollBars();
    }

    public void smoothScrollToPosition(int i2) {
        if (this.mLayoutFrozen) {
            return;
        }
        i iVar = this.mLayout;
        if (iVar == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            iVar.a(this, this.mState, i2);
        }
    }

    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
        Log.w(TAG, "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View
    public void scrollBy(int i2, int i3) {
        i iVar = this.mLayout;
        if (iVar == null) {
            Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutFrozen) {
            return;
        }
        boolean f2 = iVar.f();
        boolean g2 = this.mLayout.g();
        if (f2 || g2) {
            if (!f2) {
                i2 = 0;
            }
            if (!g2) {
                i3 = 0;
            }
            scrollByInternal(i2, i3, null);
        }
    }

    void scrollStep(int i2, int i3, int[] iArr) {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        androidx.core.os.c.a(TRACE_SCROLL_TAG);
        fillRemainingScrollValues(this.mState);
        int a2 = i2 != 0 ? this.mLayout.a(i2, this.mRecycler, this.mState) : 0;
        int b2 = i3 != 0 ? this.mLayout.b(i3, this.mRecycler, this.mState) : 0;
        androidx.core.os.c.a();
        repositionShadowingViews();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        if (iArr != null) {
            iArr[0] = a2;
            iArr[1] = b2;
        }
    }

    void consumePendingUpdateOperations() {
        if (!this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout) {
            androidx.core.os.c.a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
            dispatchLayout();
            androidx.core.os.c.a();
            return;
        }
        if (this.mAdapterHelper.d()) {
            if (this.mAdapterHelper.a(4) && !this.mAdapterHelper.a(11)) {
                androidx.core.os.c.a(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
                startInterceptRequestLayout();
                onEnterLayoutOrScroll();
                this.mAdapterHelper.b();
                if (!this.mLayoutWasDefered) {
                    if (hasUpdatedView()) {
                        dispatchLayout();
                    } else {
                        this.mAdapterHelper.c();
                    }
                }
                stopInterceptRequestLayout(true);
                onExitLayoutOrScroll();
                androidx.core.os.c.a();
                return;
            }
            if (this.mAdapterHelper.d()) {
                androidx.core.os.c.a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
                dispatchLayout();
                androidx.core.os.c.a();
            }
        }
    }

    private boolean hasUpdatedView() {
        int b2 = this.mChildHelper.b();
        for (int i2 = 0; i2 < b2; i2++) {
            w childViewHolderInt = getChildViewHolderInt(this.mChildHelper.b(i2));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.isUpdated()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x009b, code lost:
    
        if (r0 != 0) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    boolean scrollByInternal(int r19, int r20, android.view.MotionEvent r21) {
        /*
            r18 = this;
            r7 = r18
            r8 = r19
            r9 = r20
            r10 = r21
            r18.consumePendingUpdateOperations()
            androidx.recyclerview.widget.RecyclerView$a r0 = r7.mAdapter
            r11 = 1
            r12 = 0
            if (r0 == 0) goto L25
            int[] r0 = r7.mScrollStepConsumed
            r7.scrollStep(r8, r9, r0)
            int[] r0 = r7.mScrollStepConsumed
            r1 = r0[r12]
            r0 = r0[r11]
            int r2 = r8 - r1
            int r3 = r9 - r0
            r6 = r0
            r15 = r1
            r13 = r2
            r14 = r3
            goto L29
        L25:
            r6 = 0
            r13 = 0
            r14 = 0
            r15 = 0
        L29:
            java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$h> r0 = r7.mItemDecorations
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L34
            r18.invalidate()
        L34:
            int[] r5 = r7.mScrollOffset
            r16 = 0
            r0 = r18
            r1 = r15
            r2 = r6
            r3 = r13
            r4 = r14
            r17 = r6
            r6 = r16
            boolean r0 = r0.dispatchNestedScroll(r1, r2, r3, r4, r5, r6)
            if (r0 == 0) goto L76
            int r0 = r7.mLastTouchX
            int[] r1 = r7.mScrollOffset
            r2 = r1[r12]
            int r0 = r0 - r2
            r7.mLastTouchX = r0
            int r0 = r7.mLastTouchY
            r2 = r1[r11]
            int r0 = r0 - r2
            r7.mLastTouchY = r0
            if (r10 == 0) goto L63
            r0 = r1[r12]
            float r0 = (float) r0
            r1 = r1[r11]
            float r1 = (float) r1
            r10.offsetLocation(r0, r1)
        L63:
            int[] r0 = r7.mNestedOffsets
            r1 = r0[r12]
            int[] r2 = r7.mScrollOffset
            r3 = r2[r12]
            int r1 = r1 + r3
            r0[r12] = r1
            r1 = r0[r11]
            r2 = r2[r11]
            int r1 = r1 + r2
            r0[r11] = r1
            goto L97
        L76:
            int r0 = r18.getOverScrollMode()
            r1 = 2
            if (r0 == r1) goto L97
            if (r10 == 0) goto L94
            r0 = 8194(0x2002, float:1.1482E-41)
            boolean r0 = androidx.core.f.i.a(r10, r0)
            if (r0 != 0) goto L94
            float r0 = r21.getX()
            float r1 = (float) r13
            float r2 = r21.getY()
            float r3 = (float) r14
            r7.pullGlows(r0, r1, r2, r3)
        L94:
            r18.considerReleasingGlowsOnScroll(r19, r20)
        L97:
            if (r15 != 0) goto L9e
            r0 = r17
            if (r0 == 0) goto La3
            goto La0
        L9e:
            r0 = r17
        La0:
            r7.dispatchOnScrolled(r15, r0)
        La3:
            boolean r1 = r18.awakenScrollBars()
            if (r1 != 0) goto Lac
            r18.invalidate()
        Lac:
            if (r15 != 0) goto Lb0
            if (r0 == 0) goto Lb1
        Lb0:
            r12 = 1
        Lb1:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.scrollByInternal(int, int, android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        i iVar = this.mLayout;
        if (iVar != null && iVar.f()) {
            return this.mLayout.c(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        i iVar = this.mLayout;
        if (iVar != null && iVar.f()) {
            return this.mLayout.e(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        i iVar = this.mLayout;
        if (iVar != null && iVar.f()) {
            return this.mLayout.g(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        i iVar = this.mLayout;
        if (iVar != null && iVar.g()) {
            return this.mLayout.d(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        i iVar = this.mLayout;
        if (iVar != null && iVar.g()) {
            return this.mLayout.f(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        i iVar = this.mLayout;
        if (iVar != null && iVar.g()) {
            return this.mLayout.h(this.mState);
        }
        return 0;
    }

    void startInterceptRequestLayout() {
        this.mInterceptRequestLayoutDepth++;
        if (this.mInterceptRequestLayoutDepth != 1 || this.mLayoutFrozen) {
            return;
        }
        this.mLayoutWasDefered = false;
    }

    void stopInterceptRequestLayout(boolean z) {
        if (this.mInterceptRequestLayoutDepth < 1) {
            this.mInterceptRequestLayoutDepth = 1;
        }
        if (!z && !this.mLayoutFrozen) {
            this.mLayoutWasDefered = false;
        }
        if (this.mInterceptRequestLayoutDepth == 1) {
            if (z && this.mLayoutWasDefered && !this.mLayoutFrozen && this.mLayout != null && this.mAdapter != null) {
                dispatchLayout();
            }
            if (!this.mLayoutFrozen) {
                this.mLayoutWasDefered = false;
            }
        }
        this.mInterceptRequestLayoutDepth--;
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.mLayoutFrozen) {
            assertNotInLayoutOrScroll("Do not setLayoutFrozen in layout or scroll");
            if (!z) {
                this.mLayoutFrozen = false;
                if (this.mLayoutWasDefered && this.mLayout != null && this.mAdapter != null) {
                    requestLayout();
                }
                this.mLayoutWasDefered = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.mLayoutFrozen = true;
            this.mIgnoreMotionEventTillDown = true;
            stopScroll();
        }
    }

    public boolean isLayoutFrozen() {
        return this.mLayoutFrozen;
    }

    public void smoothScrollBy(int i2, int i3) {
        smoothScrollBy(i2, i3, null);
    }

    public void smoothScrollBy(int i2, int i3, Interpolator interpolator) {
        i iVar = this.mLayout;
        if (iVar == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutFrozen) {
            return;
        }
        if (!iVar.f()) {
            i2 = 0;
        }
        if (!this.mLayout.g()) {
            i3 = 0;
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        this.mViewFlinger.a(i2, i3, interpolator);
    }

    public boolean fling(int i2, int i3) {
        i iVar = this.mLayout;
        if (iVar == null) {
            Log.e(TAG, "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.mLayoutFrozen) {
            return false;
        }
        boolean f2 = iVar.f();
        boolean g2 = this.mLayout.g();
        if (!f2 || Math.abs(i2) < this.mMinFlingVelocity) {
            i2 = 0;
        }
        if (!g2 || Math.abs(i3) < this.mMinFlingVelocity) {
            i3 = 0;
        }
        if (i2 == 0 && i3 == 0) {
            return false;
        }
        float f3 = i2;
        float f4 = i3;
        if (!dispatchNestedPreFling(f3, f4)) {
            boolean z = f2 || g2;
            dispatchNestedFling(f3, f4, z);
            l lVar = this.mOnFlingListener;
            if (lVar != null && lVar.a(i2, i3)) {
                return true;
            }
            if (z) {
                int i4 = f2 ? 1 : 0;
                if (g2) {
                    i4 |= 2;
                }
                startNestedScroll(i4, 1);
                int i5 = this.mMaxFlingVelocity;
                int max = Math.max(-i5, Math.min(i2, i5));
                int i6 = this.mMaxFlingVelocity;
                this.mViewFlinger.a(max, Math.max(-i6, Math.min(i3, i6)));
                return true;
            }
        }
        return false;
    }

    public void stopScroll() {
        setScrollState(0);
        stopScrollersInternal();
    }

    private void stopScrollersInternal() {
        this.mViewFlinger.b();
        i iVar = this.mLayout;
        if (iVar != null) {
            iVar.L();
        }
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    private void pullGlows(float f2, float f3, float f4, float f5) {
        boolean z;
        boolean z2 = true;
        if (f3 < 0.0f) {
            ensureLeftGlow();
            androidx.core.widget.d.a(this.mLeftGlow, (-f3) / getWidth(), 1.0f - (f4 / getHeight()));
            z = true;
        } else if (f3 > 0.0f) {
            ensureRightGlow();
            androidx.core.widget.d.a(this.mRightGlow, f3 / getWidth(), f4 / getHeight());
            z = true;
        } else {
            z = false;
        }
        if (f5 < 0.0f) {
            ensureTopGlow();
            androidx.core.widget.d.a(this.mTopGlow, (-f5) / getHeight(), f2 / getWidth());
        } else if (f5 > 0.0f) {
            ensureBottomGlow();
            androidx.core.widget.d.a(this.mBottomGlow, f5 / getHeight(), 1.0f - (f2 / getWidth()));
        } else {
            z2 = z;
        }
        if (!z2 && f3 == 0.0f && f5 == 0.0f) {
            return;
        }
        androidx.core.f.v.d(this);
    }

    private void releaseGlows() {
        boolean z;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z = this.mLeftGlow.isFinished();
        } else {
            z = false;
        }
        EdgeEffect edgeEffect2 = this.mTopGlow;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mRightGlow;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z |= this.mBottomGlow.isFinished();
        }
        if (z) {
            androidx.core.f.v.d(this);
        }
    }

    void considerReleasingGlowsOnScroll(int i2, int i3) {
        boolean z;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished() || i2 <= 0) {
            z = false;
        } else {
            this.mLeftGlow.onRelease();
            z = this.mLeftGlow.isFinished();
        }
        EdgeEffect edgeEffect2 = this.mRightGlow;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
            this.mRightGlow.onRelease();
            z |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i3 > 0) {
            this.mTopGlow.onRelease();
            z |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i3 < 0) {
            this.mBottomGlow.onRelease();
            z |= this.mBottomGlow.isFinished();
        }
        if (z) {
            androidx.core.f.v.d(this);
        }
    }

    void absorbGlows(int i2, int i3) {
        if (i2 < 0) {
            ensureLeftGlow();
            this.mLeftGlow.onAbsorb(-i2);
        } else if (i2 > 0) {
            ensureRightGlow();
            this.mRightGlow.onAbsorb(i2);
        }
        if (i3 < 0) {
            ensureTopGlow();
            this.mTopGlow.onAbsorb(-i3);
        } else if (i3 > 0) {
            ensureBottomGlow();
            this.mBottomGlow.onAbsorb(i3);
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        androidx.core.f.v.d(this);
    }

    void ensureLeftGlow() {
        if (this.mLeftGlow != null) {
            return;
        }
        this.mLeftGlow = this.mEdgeEffectFactory.a(this, 0);
        if (this.mClipToPadding) {
            this.mLeftGlow.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            this.mLeftGlow.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    void ensureRightGlow() {
        if (this.mRightGlow != null) {
            return;
        }
        this.mRightGlow = this.mEdgeEffectFactory.a(this, 2);
        if (this.mClipToPadding) {
            this.mRightGlow.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            this.mRightGlow.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    void ensureTopGlow() {
        if (this.mTopGlow != null) {
            return;
        }
        this.mTopGlow = this.mEdgeEffectFactory.a(this, 1);
        if (this.mClipToPadding) {
            this.mTopGlow.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            this.mTopGlow.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    void ensureBottomGlow() {
        if (this.mBottomGlow != null) {
            return;
        }
        this.mBottomGlow = this.mEdgeEffectFactory.a(this, 3);
        if (this.mClipToPadding) {
            this.mBottomGlow.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            this.mBottomGlow.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void setEdgeEffectFactory(e eVar) {
        androidx.core.e.e.a(eVar);
        this.mEdgeEffectFactory = eVar;
        invalidateGlows();
    }

    public e getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i2) {
        View view2;
        boolean z;
        View d2 = this.mLayout.d(view, i2);
        if (d2 != null) {
            return d2;
        }
        boolean z2 = (this.mAdapter == null || this.mLayout == null || isComputingLayout() || this.mLayoutFrozen) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z2 && (i2 == 2 || i2 == 1)) {
            if (this.mLayout.g()) {
                int i3 = i2 == 2 ? INTLMethodID.INTL_METHOD_ID_QUERY_ID_TOKEN : 33;
                z = focusFinder.findNextFocus(this, view, i3) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i2 = i3;
                }
            } else {
                z = false;
            }
            if (!z && this.mLayout.f()) {
                int i4 = (this.mLayout.w() == 1) ^ (i2 == 2) ? 66 : 17;
                z = focusFinder.findNextFocus(this, view, i4) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i2 = i4;
                }
            }
            if (z) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                this.mLayout.a(view, i2, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            }
            view2 = focusFinder.findNextFocus(this, view, i2);
        } else {
            View findNextFocus = focusFinder.findNextFocus(this, view, i2);
            if (findNextFocus == null && z2) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                view2 = this.mLayout.a(view, i2, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            } else {
                view2 = findNextFocus;
            }
        }
        if (view2 == null || view2.hasFocusable()) {
            return isPreferredNextFocus(view, view2, i2) ? view2 : super.focusSearch(view, i2);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i2);
        }
        requestChildOnScreen(view2, null);
        return view;
    }

    private boolean isPreferredNextFocus(View view, View view2, int i2) {
        int i3;
        if (view2 == null || view2 == this || findContainingItemView(view2) == null) {
            return false;
        }
        if (view == null || findContainingItemView(view) == null) {
            return true;
        }
        this.mTempRect.set(0, 0, view.getWidth(), view.getHeight());
        this.mTempRect2.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        offsetDescendantRectToMyCoords(view2, this.mTempRect2);
        char c2 = 65535;
        int i4 = this.mLayout.w() == 1 ? -1 : 1;
        if ((this.mTempRect.left < this.mTempRect2.left || this.mTempRect.right <= this.mTempRect2.left) && this.mTempRect.right < this.mTempRect2.right) {
            i3 = 1;
        } else {
            i3 = ((this.mTempRect.right > this.mTempRect2.right || this.mTempRect.left >= this.mTempRect2.right) && this.mTempRect.left > this.mTempRect2.left) ? -1 : 0;
        }
        if ((this.mTempRect.top < this.mTempRect2.top || this.mTempRect.bottom <= this.mTempRect2.top) && this.mTempRect.bottom < this.mTempRect2.bottom) {
            c2 = 1;
        } else if ((this.mTempRect.bottom <= this.mTempRect2.bottom && this.mTempRect.top < this.mTempRect2.bottom) || this.mTempRect.top <= this.mTempRect2.top) {
            c2 = 0;
        }
        if (i2 == 17) {
            return i3 < 0;
        }
        if (i2 == 33) {
            return c2 < 0;
        }
        if (i2 == 66) {
            return i3 > 0;
        }
        if (i2 == 130) {
            return c2 > 0;
        }
        switch (i2) {
            case 1:
                return c2 < 0 || (c2 == 0 && i3 * i4 <= 0);
            case 2:
                return c2 > 0 || (c2 == 0 && i3 * i4 >= 0);
            default:
                throw new IllegalArgumentException("Invalid direction: " + i2 + exceptionLabel());
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.mLayout.a(this, this.mState, view, view2) && view2 != null) {
            requestChildOnScreen(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    private void requestChildOnScreen(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.mTempRect.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof j) {
            j jVar = (j) layoutParams;
            if (!jVar.e) {
                Rect rect = jVar.d;
                this.mTempRect.left -= rect.left;
                this.mTempRect.right += rect.right;
                this.mTempRect.top -= rect.top;
                this.mTempRect.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
        }
        this.mLayout.a(this, view, this.mTempRect, !this.mFirstLayoutComplete, view2 == null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.mLayout.a(this, view, rect, z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        i iVar = this.mLayout;
        if (iVar == null || !iVar.a(this, arrayList, i2, i3)) {
            super.addFocusables(arrayList, i2, i3);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004f, code lost:
    
        if (r0 >= 30.0f) goto L22;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onAttachedToWindow() {
        /*
            r4 = this;
            super.onAttachedToWindow()
            r0 = 0
            r4.mLayoutOrScrollCounter = r0
            r1 = 1
            r4.mIsAttached = r1
            boolean r2 = r4.mFirstLayoutComplete
            if (r2 == 0) goto L14
            boolean r2 = r4.isLayoutRequested()
            if (r2 != 0) goto L14
            goto L15
        L14:
            r1 = 0
        L15:
            r4.mFirstLayoutComplete = r1
            androidx.recyclerview.widget.RecyclerView$i r1 = r4.mLayout
            if (r1 == 0) goto L1e
            r1.c(r4)
        L1e:
            r4.mPostedAnimatorRunner = r0
            boolean r0 = androidx.recyclerview.widget.RecyclerView.ALLOW_THREAD_GAP_WORK
            if (r0 == 0) goto L69
            java.lang.ThreadLocal<androidx.recyclerview.widget.e> r0 = androidx.recyclerview.widget.e.f896a
            java.lang.Object r0 = r0.get()
            androidx.recyclerview.widget.e r0 = (androidx.recyclerview.widget.e) r0
            r4.mGapWorker = r0
            androidx.recyclerview.widget.e r0 = r4.mGapWorker
            if (r0 != 0) goto L64
            androidx.recyclerview.widget.e r0 = new androidx.recyclerview.widget.e
            r0.<init>()
            r4.mGapWorker = r0
            android.view.Display r0 = androidx.core.f.v.C(r4)
            r1 = 1114636288(0x42700000, float:60.0)
            boolean r2 = r4.isInEditMode()
            if (r2 != 0) goto L52
            if (r0 == 0) goto L52
            float r0 = r0.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 < 0) goto L52
            goto L54
        L52:
            r0 = 1114636288(0x42700000, float:60.0)
        L54:
            androidx.recyclerview.widget.e r1 = r4.mGapWorker
            r2 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r2 = r2 / r0
            long r2 = (long) r2
            r1.d = r2
            java.lang.ThreadLocal<androidx.recyclerview.widget.e> r0 = androidx.recyclerview.widget.e.f896a
            androidx.recyclerview.widget.e r1 = r4.mGapWorker
            r0.set(r1)
        L64:
            androidx.recyclerview.widget.e r0 = r4.mGapWorker
            r0.a(r4)
        L69:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        androidx.recyclerview.widget.e eVar;
        super.onDetachedFromWindow();
        f fVar = this.mItemAnimator;
        if (fVar != null) {
            fVar.d();
        }
        stopScroll();
        this.mIsAttached = false;
        i iVar = this.mLayout;
        if (iVar != null) {
            iVar.b(this, this.mRecycler);
        }
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.b();
        if (!ALLOW_THREAD_GAP_WORK || (eVar = this.mGapWorker) == null) {
            return;
        }
        eVar.b(this);
        this.mGapWorker = null;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    void assertInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling" + exceptionLabel());
        }
        throw new IllegalStateException(str + exceptionLabel());
    }

    void assertNotInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + exceptionLabel());
            }
            throw new IllegalStateException(str);
        }
        if (this.mDispatchScrollCounter > 0) {
            Log.w(TAG, "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + exceptionLabel()));
        }
    }

    public void addOnItemTouchListener(m mVar) {
        this.mOnItemTouchListeners.add(mVar);
    }

    public void removeOnItemTouchListener(m mVar) {
        this.mOnItemTouchListeners.remove(mVar);
        if (this.mActiveOnItemTouchListener == mVar) {
            this.mActiveOnItemTouchListener = null;
        }
    }

    private boolean dispatchOnItemTouchIntercept(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.mActiveOnItemTouchListener = null;
        }
        int size = this.mOnItemTouchListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            m mVar = this.mOnItemTouchListeners.get(i2);
            if (mVar.a(this, motionEvent) && action != 3) {
                this.mActiveOnItemTouchListener = mVar;
                return true;
            }
        }
        return false;
    }

    private boolean dispatchOnItemTouch(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        m mVar = this.mActiveOnItemTouchListener;
        if (mVar != null) {
            if (action == 0) {
                this.mActiveOnItemTouchListener = null;
            } else {
                mVar.b(this, motionEvent);
                if (action == 3 || action == 1) {
                    this.mActiveOnItemTouchListener = null;
                }
                return true;
            }
        }
        if (action != 0) {
            int size = this.mOnItemTouchListeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                m mVar2 = this.mOnItemTouchListeners.get(i2);
                if (mVar2.a(this, motionEvent)) {
                    this.mActiveOnItemTouchListener = mVar2;
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.mLayoutFrozen) {
            return false;
        }
        if (dispatchOnItemTouchIntercept(motionEvent)) {
            cancelTouch();
            return true;
        }
        i iVar = this.mLayout;
        if (iVar == null) {
            return false;
        }
        boolean f2 = iVar.f();
        boolean g2 = this.mLayout.g();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        switch (actionMasked) {
            case 0:
                if (this.mIgnoreMotionEventTillDown) {
                    this.mIgnoreMotionEventTillDown = false;
                }
                this.mScrollPointerId = motionEvent.getPointerId(0);
                int x = (int) (motionEvent.getX() + 0.5f);
                this.mLastTouchX = x;
                this.mInitialTouchX = x;
                int y = (int) (motionEvent.getY() + 0.5f);
                this.mLastTouchY = y;
                this.mInitialTouchY = y;
                if (this.mScrollState == 2) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    setScrollState(1);
                }
                int[] iArr = this.mNestedOffsets;
                iArr[1] = 0;
                iArr[0] = 0;
                int i2 = f2 ? 1 : 0;
                if (g2) {
                    i2 |= 2;
                }
                startNestedScroll(i2, 0);
                break;
            case 1:
                this.mVelocityTracker.clear();
                stopNestedScroll(0);
                break;
            case 2:
                int findPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
                if (findPointerIndex < 0) {
                    Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                    return false;
                }
                int x2 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                int y2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                if (this.mScrollState != 1) {
                    int i3 = x2 - this.mInitialTouchX;
                    int i4 = y2 - this.mInitialTouchY;
                    if (!f2 || Math.abs(i3) <= this.mTouchSlop) {
                        z = false;
                    } else {
                        this.mLastTouchX = x2;
                        z = true;
                    }
                    if (g2 && Math.abs(i4) > this.mTouchSlop) {
                        this.mLastTouchY = y2;
                        z = true;
                    }
                    if (z) {
                        setScrollState(1);
                        break;
                    }
                }
                break;
            case 3:
                cancelTouch();
                break;
            case 5:
                this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
                int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                this.mLastTouchX = x3;
                this.mInitialTouchX = x3;
                int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                this.mLastTouchY = y3;
                this.mInitialTouchY = y3;
                break;
            case 6:
                onPointerUp(motionEvent);
                break;
        }
        return this.mScrollState == 1;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.mOnItemTouchListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mOnItemTouchListeners.get(i2).a(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x010f  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r15) {
        /*
            Method dump skipped, instructions count: 462
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private void resetTouch() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        stopNestedScroll(0);
        releaseGlows();
    }

    private void cancelTouch() {
        resetTouch();
        setScrollState(0);
    }

    private void onPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mScrollPointerId) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.mScrollPointerId = motionEvent.getPointerId(i2);
            int x = (int) (motionEvent.getX(i2) + 0.5f);
            this.mLastTouchX = x;
            this.mInitialTouchX = x;
            int y = (int) (motionEvent.getY(i2) + 0.5f);
            this.mLastTouchY = y;
            this.mInitialTouchY = y;
        }
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f2;
        float f3;
        if (this.mLayout != null && !this.mLayoutFrozen && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                f2 = this.mLayout.g() ? -motionEvent.getAxisValue(9) : 0.0f;
                f3 = this.mLayout.f() ? motionEvent.getAxisValue(10) : 0.0f;
            } else if ((motionEvent.getSource() & 4194304) != 0) {
                float axisValue = motionEvent.getAxisValue(26);
                if (this.mLayout.g()) {
                    f2 = -axisValue;
                    f3 = 0.0f;
                } else if (this.mLayout.f()) {
                    f3 = axisValue;
                    f2 = 0.0f;
                } else {
                    f2 = 0.0f;
                    f3 = 0.0f;
                }
            } else {
                f2 = 0.0f;
                f3 = 0.0f;
            }
            if (f2 != 0.0f || f3 != 0.0f) {
                scrollByInternal((int) (f3 * this.mScaledHorizontalScrollFactor), (int) (f2 * this.mScaledVerticalScrollFactor), motionEvent);
            }
        }
        return false;
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        i iVar = this.mLayout;
        if (iVar == null) {
            defaultOnMeasure(i2, i3);
            return;
        }
        boolean z = false;
        if (iVar.d()) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.mLayout.a(this.mRecycler, this.mState, i2, i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            if (z || this.mAdapter == null) {
                return;
            }
            if (this.mState.d == 1) {
                dispatchLayoutStep1();
            }
            this.mLayout.d(i2, i3);
            this.mState.i = true;
            dispatchLayoutStep2();
            this.mLayout.e(i2, i3);
            if (this.mLayout.m()) {
                this.mLayout.d(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.mState.i = true;
                dispatchLayoutStep2();
                this.mLayout.e(i2, i3);
                return;
            }
            return;
        }
        if (this.mHasFixedSize) {
            this.mLayout.a(this.mRecycler, this.mState, i2, i3);
            return;
        }
        if (this.mAdapterUpdateDuringMeasure) {
            startInterceptRequestLayout();
            onEnterLayoutOrScroll();
            processAdapterUpdatesAndSetAnimationFlags();
            onExitLayoutOrScroll();
            if (this.mState.k) {
                this.mState.g = true;
            } else {
                this.mAdapterHelper.e();
                this.mState.g = false;
            }
            this.mAdapterUpdateDuringMeasure = false;
            stopInterceptRequestLayout(false);
        } else if (this.mState.k) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        a aVar = this.mAdapter;
        if (aVar != null) {
            this.mState.e = aVar.getItemCount();
        } else {
            this.mState.e = 0;
        }
        startInterceptRequestLayout();
        this.mLayout.a(this.mRecycler, this.mState, i2, i3);
        stopInterceptRequestLayout(false);
        this.mState.g = false;
    }

    void defaultOnMeasure(int i2, int i3) {
        setMeasuredDimension(i.a(i2, getPaddingLeft() + getPaddingRight(), androidx.core.f.v.j(this)), i.a(i3, getPaddingTop() + getPaddingBottom(), androidx.core.f.v.k(this)));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 == i4 && i3 == i5) {
            return;
        }
        invalidateGlows();
    }

    public void setItemAnimator(f fVar) {
        f fVar2 = this.mItemAnimator;
        if (fVar2 != null) {
            fVar2.d();
            this.mItemAnimator.a(null);
        }
        this.mItemAnimator = fVar;
        f fVar3 = this.mItemAnimator;
        if (fVar3 != null) {
            fVar3.a(this.mItemAnimatorListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onExitLayoutOrScroll(boolean z) {
        this.mLayoutOrScrollCounter--;
        if (this.mLayoutOrScrollCounter < 1) {
            this.mLayoutOrScrollCounter = 0;
            if (z) {
                dispatchContentChangedIfNecessary();
                dispatchPendingImportantForAccessibilityChanges();
            }
        }
    }

    boolean isAccessibilityEnabled() {
        AccessibilityManager accessibilityManager = this.mAccessibilityManager;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    private void dispatchContentChangedIfNecessary() {
        int i2 = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (i2 == 0 || !isAccessibilityEnabled()) {
            return;
        }
        AccessibilityEvent obtain = AccessibilityEvent.obtain();
        obtain.setEventType(ProgressEvent.PART_COMPLETED_EVENT_CODE);
        androidx.core.f.a.b.a(obtain, i2);
        sendAccessibilityEventUnchecked(obtain);
    }

    public boolean isComputingLayout() {
        return this.mLayoutOrScrollCounter > 0;
    }

    boolean shouldDeferAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (!isComputingLayout()) {
            return false;
        }
        int a2 = accessibilityEvent != null ? androidx.core.f.a.b.a(accessibilityEvent) : 0;
        if (a2 == 0) {
            a2 = 0;
        }
        this.mEatenAccessibilityChangeFlags = a2 | this.mEatenAccessibilityChangeFlags;
        return true;
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (shouldDeferAccessibilityEvent(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public f getItemAnimator() {
        return this.mItemAnimator;
    }

    void postAnimationRunner() {
        if (this.mPostedAnimatorRunner || !this.mIsAttached) {
            return;
        }
        androidx.core.f.v.a(this, this.mItemAnimatorRunner);
        this.mPostedAnimatorRunner = true;
    }

    private boolean predictiveItemAnimationsEnabled() {
        return this.mItemAnimator != null && this.mLayout.c();
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        if (this.mDataSetHasChangedAfterLayout) {
            this.mAdapterHelper.a();
            if (this.mDispatchItemsChangedEvent) {
                this.mLayout.a(this);
            }
        }
        if (predictiveItemAnimationsEnabled()) {
            this.mAdapterHelper.b();
        } else {
            this.mAdapterHelper.e();
        }
        boolean z = false;
        boolean z2 = this.mItemsAddedOrRemoved || this.mItemsChanged;
        this.mState.j = this.mFirstLayoutComplete && this.mItemAnimator != null && (this.mDataSetHasChangedAfterLayout || z2 || this.mLayout.u) && (!this.mDataSetHasChangedAfterLayout || this.mAdapter.hasStableIds());
        t tVar = this.mState;
        if (tVar.j && z2 && !this.mDataSetHasChangedAfterLayout && predictiveItemAnimationsEnabled()) {
            z = true;
        }
        tVar.k = z;
    }

    void dispatchLayout() {
        if (this.mAdapter == null) {
            Log.e(TAG, "No adapter attached; skipping layout");
            return;
        }
        if (this.mLayout == null) {
            Log.e(TAG, "No layout manager attached; skipping layout");
            return;
        }
        t tVar = this.mState;
        tVar.i = false;
        if (tVar.d == 1) {
            dispatchLayoutStep1();
            this.mLayout.f(this);
            dispatchLayoutStep2();
        } else if (this.mAdapterHelper.f() || this.mLayout.B() != getWidth() || this.mLayout.C() != getHeight()) {
            this.mLayout.f(this);
            dispatchLayoutStep2();
        } else {
            this.mLayout.f(this);
        }
        dispatchLayoutStep3();
    }

    private void saveFocusInfo() {
        int adapterPosition;
        View focusedChild = (this.mPreserveFocusAfterLayout && hasFocus() && this.mAdapter != null) ? getFocusedChild() : null;
        w findContainingViewHolder = focusedChild != null ? findContainingViewHolder(focusedChild) : null;
        if (findContainingViewHolder == null) {
            resetFocusInfo();
            return;
        }
        this.mState.m = this.mAdapter.hasStableIds() ? findContainingViewHolder.getItemId() : -1L;
        t tVar = this.mState;
        if (this.mDataSetHasChangedAfterLayout) {
            adapterPosition = -1;
        } else {
            adapterPosition = findContainingViewHolder.isRemoved() ? findContainingViewHolder.mOldPosition : findContainingViewHolder.getAdapterPosition();
        }
        tVar.l = adapterPosition;
        this.mState.n = getDeepestFocusedViewWithId(findContainingViewHolder.itemView);
    }

    private void resetFocusInfo() {
        t tVar = this.mState;
        tVar.m = -1L;
        tVar.l = -1;
        tVar.n = -1;
    }

    private View findNextViewToFocus() {
        w findViewHolderForAdapterPosition;
        int i2 = this.mState.l != -1 ? this.mState.l : 0;
        int e2 = this.mState.e();
        for (int i3 = i2; i3 < e2; i3++) {
            w findViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i3);
            if (findViewHolderForAdapterPosition2 == null) {
                break;
            }
            if (findViewHolderForAdapterPosition2.itemView.hasFocusable()) {
                return findViewHolderForAdapterPosition2.itemView;
            }
        }
        int min = Math.min(e2, i2);
        do {
            min--;
            if (min < 0 || (findViewHolderForAdapterPosition = findViewHolderForAdapterPosition(min)) == null) {
                return null;
            }
        } while (!findViewHolderForAdapterPosition.itemView.hasFocusable());
        return findViewHolderForAdapterPosition.itemView;
    }

    private void recoverFocusFromState() {
        View view;
        if (!this.mPreserveFocusAfterLayout || this.mAdapter == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (IGNORE_DETACHED_FOCUSED_CHILD && (focusedChild.getParent() == null || !focusedChild.hasFocus())) {
                if (this.mChildHelper.b() == 0) {
                    requestFocus();
                    return;
                }
            } else if (!this.mChildHelper.c(focusedChild)) {
                return;
            }
        }
        View view2 = null;
        w findViewHolderForItemId = (this.mState.m == -1 || !this.mAdapter.hasStableIds()) ? null : findViewHolderForItemId(this.mState.m);
        if (findViewHolderForItemId == null || this.mChildHelper.c(findViewHolderForItemId.itemView) || !findViewHolderForItemId.itemView.hasFocusable()) {
            if (this.mChildHelper.b() > 0) {
                view2 = findNextViewToFocus();
            }
        } else {
            view2 = findViewHolderForItemId.itemView;
        }
        if (view2 != null) {
            if (this.mState.n == -1 || (view = view2.findViewById(this.mState.n)) == null || !view.isFocusable()) {
                view = view2;
            }
            view.requestFocus();
        }
    }

    private int getDeepestFocusedViewWithId(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    final void fillRemainingScrollValues(t tVar) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.mViewFlinger.f867a;
            tVar.o = overScroller.getFinalX() - overScroller.getCurrX();
            tVar.p = overScroller.getFinalY() - overScroller.getCurrY();
        } else {
            tVar.o = 0;
            tVar.p = 0;
        }
    }

    private void dispatchLayoutStep1() {
        this.mState.a(1);
        fillRemainingScrollValues(this.mState);
        this.mState.i = false;
        startInterceptRequestLayout();
        this.mViewInfoStore.a();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        saveFocusInfo();
        t tVar = this.mState;
        tVar.h = tVar.j && this.mItemsChanged;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        t tVar2 = this.mState;
        tVar2.g = tVar2.k;
        this.mState.e = this.mAdapter.getItemCount();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.j) {
            int b2 = this.mChildHelper.b();
            for (int i2 = 0; i2 < b2; i2++) {
                w childViewHolderInt = getChildViewHolderInt(this.mChildHelper.b(i2));
                if (!childViewHolderInt.shouldIgnore() && (!childViewHolderInt.isInvalid() || this.mAdapter.hasStableIds())) {
                    this.mViewInfoStore.a(childViewHolderInt, this.mItemAnimator.a(this.mState, childViewHolderInt, f.e(childViewHolderInt), childViewHolderInt.getUnmodifiedPayloads()));
                    if (this.mState.h && childViewHolderInt.isUpdated() && !childViewHolderInt.isRemoved() && !childViewHolderInt.shouldIgnore() && !childViewHolderInt.isInvalid()) {
                        this.mViewInfoStore.a(getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                    }
                }
            }
        }
        if (this.mState.k) {
            saveOldPositions();
            boolean z = this.mState.f;
            t tVar3 = this.mState;
            tVar3.f = false;
            this.mLayout.c(this.mRecycler, tVar3);
            this.mState.f = z;
            for (int i3 = 0; i3 < this.mChildHelper.b(); i3++) {
                w childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.b(i3));
                if (!childViewHolderInt2.shouldIgnore() && !this.mViewInfoStore.d(childViewHolderInt2)) {
                    int e2 = f.e(childViewHolderInt2);
                    boolean hasAnyOfTheFlags = childViewHolderInt2.hasAnyOfTheFlags(8192);
                    if (!hasAnyOfTheFlags) {
                        e2 |= 4096;
                    }
                    f.c a2 = this.mItemAnimator.a(this.mState, childViewHolderInt2, e2, childViewHolderInt2.getUnmodifiedPayloads());
                    if (hasAnyOfTheFlags) {
                        recordAnimationInfoIfBouncedHiddenView(childViewHolderInt2, a2);
                    } else {
                        this.mViewInfoStore.b(childViewHolderInt2, a2);
                    }
                }
            }
            clearOldPositions();
        } else {
            clearOldPositions();
        }
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mState.d = 2;
    }

    private void dispatchLayoutStep2() {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.a(6);
        this.mAdapterHelper.e();
        this.mState.e = this.mAdapter.getItemCount();
        t tVar = this.mState;
        tVar.c = 0;
        tVar.g = false;
        this.mLayout.c(this.mRecycler, tVar);
        t tVar2 = this.mState;
        tVar2.f = false;
        this.mPendingSavedState = null;
        tVar2.j = tVar2.j && this.mItemAnimator != null;
        this.mState.d = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
    }

    private void dispatchLayoutStep3() {
        this.mState.a(4);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        t tVar = this.mState;
        tVar.d = 1;
        if (tVar.j) {
            for (int b2 = this.mChildHelper.b() - 1; b2 >= 0; b2--) {
                w childViewHolderInt = getChildViewHolderInt(this.mChildHelper.b(b2));
                if (!childViewHolderInt.shouldIgnore()) {
                    long changedHolderKey = getChangedHolderKey(childViewHolderInt);
                    f.c a2 = this.mItemAnimator.a(this.mState, childViewHolderInt);
                    w a3 = this.mViewInfoStore.a(changedHolderKey);
                    if (a3 != null && !a3.shouldIgnore()) {
                        boolean a4 = this.mViewInfoStore.a(a3);
                        boolean a5 = this.mViewInfoStore.a(childViewHolderInt);
                        if (a4 && a3 == childViewHolderInt) {
                            this.mViewInfoStore.c(childViewHolderInt, a2);
                        } else {
                            f.c b3 = this.mViewInfoStore.b(a3);
                            this.mViewInfoStore.c(childViewHolderInt, a2);
                            f.c c2 = this.mViewInfoStore.c(childViewHolderInt);
                            if (b3 == null) {
                                handleMissingPreInfoForChangeError(changedHolderKey, childViewHolderInt, a3);
                            } else {
                                animateChange(a3, childViewHolderInt, b3, c2, a4, a5);
                            }
                        }
                    } else {
                        this.mViewInfoStore.c(childViewHolderInt, a2);
                    }
                }
            }
            this.mViewInfoStore.a(this.mViewInfoProcessCallback);
        }
        this.mLayout.b(this.mRecycler);
        t tVar2 = this.mState;
        tVar2.b = tVar2.e;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        t tVar3 = this.mState;
        tVar3.j = false;
        tVar3.k = false;
        this.mLayout.u = false;
        if (this.mRecycler.b != null) {
            this.mRecycler.b.clear();
        }
        if (this.mLayout.y) {
            i iVar = this.mLayout;
            iVar.x = 0;
            iVar.y = false;
            this.mRecycler.b();
        }
        this.mLayout.a(this.mState);
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mViewInfoStore.a();
        int[] iArr = this.mMinMaxLayoutPositions;
        if (didChildRangeChange(iArr[0], iArr[1])) {
            dispatchOnScrolled(0, 0);
        }
        recoverFocusFromState();
        resetFocusInfo();
    }

    private void handleMissingPreInfoForChangeError(long j2, w wVar, w wVar2) {
        int b2 = this.mChildHelper.b();
        for (int i2 = 0; i2 < b2; i2++) {
            w childViewHolderInt = getChildViewHolderInt(this.mChildHelper.b(i2));
            if (childViewHolderInt != wVar && getChangedHolderKey(childViewHolderInt) == j2) {
                a aVar = this.mAdapter;
                if (aVar != null && aVar.hasStableIds()) {
                    throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + wVar + exceptionLabel());
                }
                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + wVar + exceptionLabel());
            }
        }
        Log.e(TAG, "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + wVar2 + " cannot be found but it is necessary for " + wVar + exceptionLabel());
    }

    void recordAnimationInfoIfBouncedHiddenView(w wVar, f.c cVar) {
        wVar.setFlags(0, 8192);
        if (this.mState.h && wVar.isUpdated() && !wVar.isRemoved() && !wVar.shouldIgnore()) {
            this.mViewInfoStore.a(getChangedHolderKey(wVar), wVar);
        }
        this.mViewInfoStore.a(wVar, cVar);
    }

    private void findMinMaxChildLayoutPositions(int[] iArr) {
        int b2 = this.mChildHelper.b();
        if (b2 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = BleSignal.UNKNOWN_TX_POWER;
        for (int i4 = 0; i4 < b2; i4++) {
            w childViewHolderInt = getChildViewHolderInt(this.mChildHelper.b(i4));
            if (!childViewHolderInt.shouldIgnore()) {
                int layoutPosition = childViewHolderInt.getLayoutPosition();
                if (layoutPosition < i2) {
                    i2 = layoutPosition;
                }
                if (layoutPosition > i3) {
                    i3 = layoutPosition;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = i3;
    }

    private boolean didChildRangeChange(int i2, int i3) {
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        int[] iArr = this.mMinMaxLayoutPositions;
        return (iArr[0] == i2 && iArr[1] == i3) ? false : true;
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z) {
        w childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.isTmpDetached()) {
                childViewHolderInt.clearTmpDetachFlag();
            } else if (!childViewHolderInt.shouldIgnore()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + childViewHolderInt + exceptionLabel());
            }
        }
        view.clearAnimation();
        dispatchChildDetached(view);
        super.removeDetachedView(view, z);
    }

    long getChangedHolderKey(w wVar) {
        return this.mAdapter.hasStableIds() ? wVar.getItemId() : wVar.mPosition;
    }

    void animateAppearance(w wVar, f.c cVar, f.c cVar2) {
        wVar.setIsRecyclable(false);
        if (this.mItemAnimator.b(wVar, cVar, cVar2)) {
            postAnimationRunner();
        }
    }

    void animateDisappearance(w wVar, f.c cVar, f.c cVar2) {
        addAnimatingView(wVar);
        wVar.setIsRecyclable(false);
        if (this.mItemAnimator.a(wVar, cVar, cVar2)) {
            postAnimationRunner();
        }
    }

    private void animateChange(w wVar, w wVar2, f.c cVar, f.c cVar2, boolean z, boolean z2) {
        wVar.setIsRecyclable(false);
        if (z) {
            addAnimatingView(wVar);
        }
        if (wVar != wVar2) {
            if (z2) {
                addAnimatingView(wVar2);
            }
            wVar.mShadowedHolder = wVar2;
            addAnimatingView(wVar);
            this.mRecycler.c(wVar);
            wVar2.setIsRecyclable(false);
            wVar2.mShadowingHolder = wVar;
        }
        if (this.mItemAnimator.a(wVar, wVar2, cVar, cVar2)) {
            postAnimationRunner();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        androidx.core.os.c.a(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        androidx.core.os.c.a();
        this.mFirstLayoutComplete = true;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mInterceptRequestLayoutDepth == 0 && !this.mLayoutFrozen) {
            super.requestLayout();
        } else {
            this.mLayoutWasDefered = true;
        }
    }

    void markItemDecorInsetsDirty() {
        int c2 = this.mChildHelper.c();
        for (int i2 = 0; i2 < c2; i2++) {
            ((j) this.mChildHelper.d(i2).getLayoutParams()).e = true;
        }
        this.mRecycler.j();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z;
        boolean z2;
        super.draw(canvas);
        int size = this.mItemDecorations.size();
        boolean z3 = false;
        for (int i2 = 0; i2 < size; i2++) {
            this.mItemDecorations.get(i2).onDrawOver(canvas, this, this.mState);
        }
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.mClipToPadding ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.mLeftGlow;
            z = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.mTopGlow;
            z |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.mRightGlow;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.mClipToPadding ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.mRightGlow;
            z |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.mBottomGlow;
        if (edgeEffect7 == null || edgeEffect7.isFinished()) {
            z2 = z;
        } else {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.mClipToPadding) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.mBottomGlow;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z3 = true;
            }
            z2 = z3 | z;
            canvas.restoreToCount(save4);
        }
        if (!z2 && this.mItemAnimator != null && this.mItemDecorations.size() > 0 && this.mItemAnimator.b()) {
            z2 = true;
        }
        if (z2) {
            androidx.core.f.v.d(this);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.mItemDecorations.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mItemDecorations.get(i2).onDraw(canvas, this, this.mState);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof j) && this.mLayout.a((j) layoutParams);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        i iVar = this.mLayout;
        if (iVar == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
        }
        return iVar.a();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        i iVar = this.mLayout;
        if (iVar == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
        }
        return iVar.a(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        i iVar = this.mLayout;
        if (iVar == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
        }
        return iVar.a(layoutParams);
    }

    public boolean isAnimating() {
        f fVar = this.mItemAnimator;
        return fVar != null && fVar.b();
    }

    void saveOldPositions() {
        int c2 = this.mChildHelper.c();
        for (int i2 = 0; i2 < c2; i2++) {
            w childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(i2));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.saveOldPosition();
            }
        }
    }

    void clearOldPositions() {
        int c2 = this.mChildHelper.c();
        for (int i2 = 0; i2 < c2; i2++) {
            w childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(i2));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.clearOldPosition();
            }
        }
        this.mRecycler.i();
    }

    void offsetPositionRecordsForMove(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int c2 = this.mChildHelper.c();
        if (i2 < i3) {
            i5 = i2;
            i4 = i3;
            i6 = -1;
        } else {
            i4 = i2;
            i5 = i3;
            i6 = 1;
        }
        for (int i7 = 0; i7 < c2; i7++) {
            w childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(i7));
            if (childViewHolderInt != null && childViewHolderInt.mPosition >= i5 && childViewHolderInt.mPosition <= i4) {
                if (childViewHolderInt.mPosition == i2) {
                    childViewHolderInt.offsetPosition(i3 - i2, false);
                } else {
                    childViewHolderInt.offsetPosition(i6, false);
                }
                this.mState.f = true;
            }
        }
        this.mRecycler.a(i2, i3);
        requestLayout();
    }

    void offsetPositionRecordsForInsert(int i2, int i3) {
        int c2 = this.mChildHelper.c();
        for (int i4 = 0; i4 < c2; i4++) {
            w childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(i4));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i2) {
                childViewHolderInt.offsetPosition(i3, false);
                this.mState.f = true;
            }
        }
        this.mRecycler.b(i2, i3);
        requestLayout();
    }

    void offsetPositionRecordsForRemove(int i2, int i3, boolean z) {
        int i4 = i2 + i3;
        int c2 = this.mChildHelper.c();
        for (int i5 = 0; i5 < c2; i5++) {
            w childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(i5));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                if (childViewHolderInt.mPosition >= i4) {
                    childViewHolderInt.offsetPosition(-i3, z);
                    this.mState.f = true;
                } else if (childViewHolderInt.mPosition >= i2) {
                    childViewHolderInt.flagRemovedAndOffsetPosition(i2 - 1, -i3, z);
                    this.mState.f = true;
                }
            }
        }
        this.mRecycler.a(i2, i3, z);
        requestLayout();
    }

    void viewRangeUpdate(int i2, int i3, Object obj) {
        int c2 = this.mChildHelper.c();
        int i4 = i2 + i3;
        for (int i5 = 0; i5 < c2; i5++) {
            View d2 = this.mChildHelper.d(i5);
            w childViewHolderInt = getChildViewHolderInt(d2);
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i2 && childViewHolderInt.mPosition < i4) {
                childViewHolderInt.addFlags(2);
                childViewHolderInt.addChangePayload(obj);
                ((j) d2.getLayoutParams()).e = true;
            }
        }
        this.mRecycler.c(i2, i3);
    }

    boolean canReuseUpdatedViewHolder(w wVar) {
        f fVar = this.mItemAnimator;
        return fVar == null || fVar.a(wVar, wVar.getUnmodifiedPayloads());
    }

    void processDataSetCompletelyChanged(boolean z) {
        this.mDispatchItemsChangedEvent = z | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    void markKnownViewsInvalid() {
        int c2 = this.mChildHelper.c();
        for (int i2 = 0; i2 < c2; i2++) {
            w childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(i2));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.addFlags(6);
            }
        }
        markItemDecorInsetsDirty();
        this.mRecycler.h();
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() == 0) {
            return;
        }
        i iVar = this.mLayout;
        if (iVar != null) {
            iVar.a("Cannot invalidate item decorations during a scroll or layout");
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.mPreserveFocusAfterLayout = z;
    }

    public w getChildViewHolder(View view) {
        ViewParent parent = view.getParent();
        if (parent != null && parent != this) {
            throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
        }
        return getChildViewHolderInt(view);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:?, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View findContainingItemView(android.view.View r3) {
        /*
            r2 = this;
            android.view.ViewParent r0 = r3.getParent()
        L4:
            if (r0 == 0) goto L14
            if (r0 == r2) goto L14
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto L14
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            android.view.ViewParent r0 = r3.getParent()
            goto L4
        L14:
            if (r0 != r2) goto L17
            goto L18
        L17:
            r3 = 0
        L18:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.findContainingItemView(android.view.View):android.view.View");
    }

    public w findContainingViewHolder(View view) {
        View findContainingItemView = findContainingItemView(view);
        if (findContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(findContainingItemView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static w getChildViewHolderInt(View view) {
        if (view == null) {
            return null;
        }
        return ((j) view.getLayoutParams()).c;
    }

    @Deprecated
    public int getChildPosition(View view) {
        return getChildAdapterPosition(view);
    }

    public int getChildAdapterPosition(View view) {
        w childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getAdapterPosition();
        }
        return -1;
    }

    public int getChildLayoutPosition(View view) {
        w childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getLayoutPosition();
        }
        return -1;
    }

    public long getChildItemId(View view) {
        w childViewHolderInt;
        a aVar = this.mAdapter;
        if (aVar == null || !aVar.hasStableIds() || (childViewHolderInt = getChildViewHolderInt(view)) == null) {
            return -1L;
        }
        return childViewHolderInt.getItemId();
    }

    @Deprecated
    public w findViewHolderForPosition(int i2) {
        return findViewHolderForPosition(i2, false);
    }

    public w findViewHolderForLayoutPosition(int i2) {
        return findViewHolderForPosition(i2, false);
    }

    public w findViewHolderForAdapterPosition(int i2) {
        w wVar = null;
        if (this.mDataSetHasChangedAfterLayout) {
            return null;
        }
        int c2 = this.mChildHelper.c();
        for (int i3 = 0; i3 < c2; i3++) {
            w childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(i3));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && getAdapterPositionFor(childViewHolderInt) == i2) {
                if (!this.mChildHelper.c(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                wVar = childViewHolderInt;
            }
        }
        return wVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0036 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    androidx.recyclerview.widget.RecyclerView.w findViewHolderForPosition(int r6, boolean r7) {
        /*
            r5 = this;
            androidx.recyclerview.widget.b r0 = r5.mChildHelper
            int r0 = r0.c()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L3a
            androidx.recyclerview.widget.b r3 = r5.mChildHelper
            android.view.View r3 = r3.d(r2)
            androidx.recyclerview.widget.RecyclerView$w r3 = getChildViewHolderInt(r3)
            if (r3 == 0) goto L37
            boolean r4 = r3.isRemoved()
            if (r4 != 0) goto L37
            if (r7 == 0) goto L23
            int r4 = r3.mPosition
            if (r4 == r6) goto L2a
            goto L37
        L23:
            int r4 = r3.getLayoutPosition()
            if (r4 == r6) goto L2a
            goto L37
        L2a:
            androidx.recyclerview.widget.b r1 = r5.mChildHelper
            android.view.View r4 = r3.itemView
            boolean r1 = r1.c(r4)
            if (r1 == 0) goto L36
            r1 = r3
            goto L37
        L36:
            return r3
        L37:
            int r2 = r2 + 1
            goto L8
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.findViewHolderForPosition(int, boolean):androidx.recyclerview.widget.RecyclerView$w");
    }

    public w findViewHolderForItemId(long j2) {
        a aVar = this.mAdapter;
        w wVar = null;
        if (aVar == null || !aVar.hasStableIds()) {
            return null;
        }
        int c2 = this.mChildHelper.c();
        for (int i2 = 0; i2 < c2; i2++) {
            w childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(i2));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && childViewHolderInt.getItemId() == j2) {
                if (!this.mChildHelper.c(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                wVar = childViewHolderInt;
            }
        }
        return wVar;
    }

    public View findChildViewUnder(float f2, float f3) {
        for (int b2 = this.mChildHelper.b() - 1; b2 >= 0; b2--) {
            View b3 = this.mChildHelper.b(b2);
            float translationX = b3.getTranslationX();
            float translationY = b3.getTranslationY();
            if (f2 >= b3.getLeft() + translationX && f2 <= b3.getRight() + translationX && f3 >= b3.getTop() + translationY && f3 <= b3.getBottom() + translationY) {
                return b3;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    public void offsetChildrenVertical(int i2) {
        int b2 = this.mChildHelper.b();
        for (int i3 = 0; i3 < b2; i3++) {
            this.mChildHelper.b(i3).offsetTopAndBottom(i2);
        }
    }

    public void offsetChildrenHorizontal(int i2) {
        int b2 = this.mChildHelper.b();
        for (int i3 = 0; i3 < b2; i3++) {
            this.mChildHelper.b(i3).offsetLeftAndRight(i2);
        }
    }

    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        getDecoratedBoundsWithMarginsInt(view, rect);
    }

    static void getDecoratedBoundsWithMarginsInt(View view, Rect rect) {
        j jVar = (j) view.getLayoutParams();
        Rect rect2 = jVar.d;
        rect.set((view.getLeft() - rect2.left) - jVar.leftMargin, (view.getTop() - rect2.top) - jVar.topMargin, view.getRight() + rect2.right + jVar.rightMargin, view.getBottom() + rect2.bottom + jVar.bottomMargin);
    }

    Rect getItemDecorInsetsForChild(View view) {
        j jVar = (j) view.getLayoutParams();
        if (!jVar.e) {
            return jVar.d;
        }
        if (this.mState.a() && (jVar.e() || jVar.c())) {
            return jVar.d;
        }
        Rect rect = jVar.d;
        rect.set(0, 0, 0, 0);
        int size = this.mItemDecorations.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mTempRect.set(0, 0, 0, 0);
            this.mItemDecorations.get(i2).getItemOffsets(this.mTempRect, view, this, this.mState);
            rect.left += this.mTempRect.left;
            rect.top += this.mTempRect.top;
            rect.right += this.mTempRect.right;
            rect.bottom += this.mTempRect.bottom;
        }
        jVar.e = false;
        return rect;
    }

    void dispatchOnScrolled(int i2, int i3) {
        this.mDispatchScrollCounter++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        onScrolled(i2, i3);
        n nVar = this.mScrollListener;
        if (nVar != null) {
            nVar.onScrolled(this, i2, i3);
        }
        List<n> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrolled(this, i2, i3);
            }
        }
        this.mDispatchScrollCounter--;
    }

    void dispatchOnScrollStateChanged(int i2) {
        i iVar = this.mLayout;
        if (iVar != null) {
            iVar.l(i2);
        }
        onScrollStateChanged(i2);
        n nVar = this.mScrollListener;
        if (nVar != null) {
            nVar.onScrollStateChanged(this, i2);
        }
        List<n> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrollStateChanged(this, i2);
            }
        }
    }

    public boolean hasPendingAdapterUpdates() {
        return !this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout || this.mAdapterHelper.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class v implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        OverScroller f867a;
        private int d;
        private int e;
        Interpolator b = RecyclerView.sQuinticInterpolator;
        private boolean f = false;
        private boolean g = false;

        v() {
            this.f867a = new OverScroller(RecyclerView.this.getContext(), RecyclerView.sQuinticInterpolator);
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            int i3;
            int i4;
            if (RecyclerView.this.mLayout == null) {
                b();
                return;
            }
            c();
            RecyclerView.this.consumePendingUpdateOperations();
            OverScroller overScroller = this.f867a;
            s sVar = RecyclerView.this.mLayout.t;
            if (overScroller.computeScrollOffset()) {
                int[] iArr = RecyclerView.this.mScrollConsumed;
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i5 = currX - this.d;
                int i6 = currY - this.e;
                this.d = currX;
                this.e = currY;
                if (RecyclerView.this.dispatchNestedPreScroll(i5, i6, iArr, null, 1)) {
                    i5 -= iArr[0];
                    i6 -= iArr[1];
                }
                if (RecyclerView.this.mAdapter != null) {
                    RecyclerView recyclerView = RecyclerView.this;
                    recyclerView.scrollStep(i5, i6, recyclerView.mScrollStepConsumed);
                    i = RecyclerView.this.mScrollStepConsumed[0];
                    i2 = RecyclerView.this.mScrollStepConsumed[1];
                    i3 = i5 - i;
                    i4 = i6 - i2;
                    if (sVar != null && !sVar.g() && sVar.h()) {
                        int e = RecyclerView.this.mState.e();
                        if (e == 0) {
                            sVar.f();
                        } else if (sVar.i() >= e) {
                            sVar.c(e - 1);
                            sVar.a(i5 - i3, i6 - i4);
                        } else {
                            sVar.a(i5 - i3, i6 - i4);
                        }
                    }
                } else {
                    i = 0;
                    i2 = 0;
                    i3 = 0;
                    i4 = 0;
                }
                if (!RecyclerView.this.mItemDecorations.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.considerReleasingGlowsOnScroll(i5, i6);
                }
                if (!RecyclerView.this.dispatchNestedScroll(i, i2, i3, i4, null, 1) && (i3 != 0 || i4 != 0)) {
                    int currVelocity = (int) overScroller.getCurrVelocity();
                    int i7 = i3 != currX ? i3 < 0 ? -currVelocity : i3 > 0 ? currVelocity : 0 : 0;
                    if (i4 == currY) {
                        currVelocity = 0;
                    } else if (i4 < 0) {
                        currVelocity = -currVelocity;
                    } else if (i4 <= 0) {
                        currVelocity = 0;
                    }
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        RecyclerView.this.absorbGlows(i7, currVelocity);
                    }
                    if ((i7 != 0 || i3 == currX || overScroller.getFinalX() == 0) && (currVelocity != 0 || i4 == currY || overScroller.getFinalY() == 0)) {
                        overScroller.abortAnimation();
                    }
                }
                if (i != 0 || i2 != 0) {
                    RecyclerView.this.dispatchOnScrolled(i, i2);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z = (i5 == 0 && i6 == 0) || (i5 != 0 && RecyclerView.this.mLayout.f() && i == i5) || (i6 != 0 && RecyclerView.this.mLayout.g() && i2 == i6);
                if (overScroller.isFinished() || (!z && !RecyclerView.this.hasNestedScrollingParent(1))) {
                    RecyclerView.this.setScrollState(0);
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                        RecyclerView.this.mPrefetchRegistry.a();
                    }
                    RecyclerView.this.stopNestedScroll(1);
                } else {
                    a();
                    if (RecyclerView.this.mGapWorker != null) {
                        RecyclerView.this.mGapWorker.a(RecyclerView.this, i5, i6);
                    }
                }
            }
            if (sVar != null) {
                if (sVar.g()) {
                    sVar.a(0, 0);
                }
                if (!this.g) {
                    sVar.f();
                }
            }
            d();
        }

        private void c() {
            this.g = false;
            this.f = true;
        }

        private void d() {
            this.f = false;
            if (this.g) {
                a();
            }
        }

        void a() {
            if (this.f) {
                this.g = true;
            } else {
                RecyclerView.this.removeCallbacks(this);
                androidx.core.f.v.a(RecyclerView.this, this);
            }
        }

        public void a(int i, int i2) {
            RecyclerView.this.setScrollState(2);
            this.e = 0;
            this.d = 0;
            this.f867a.fling(0, 0, i, i2, BleSignal.UNKNOWN_TX_POWER, Integer.MAX_VALUE, BleSignal.UNKNOWN_TX_POWER, Integer.MAX_VALUE);
            a();
        }

        public void b(int i, int i2) {
            a(i, i2, 0, 0);
        }

        public void a(int i, int i2, int i3, int i4) {
            a(i, i2, b(i, i2, i3, i4));
        }

        private float a(float f) {
            return (float) Math.sin((f - 0.5f) * 0.47123894f);
        }

        private int b(int i, int i2, int i3, int i4) {
            int i5;
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            boolean z = abs > abs2;
            int sqrt = (int) Math.sqrt((i3 * i3) + (i4 * i4));
            int sqrt2 = (int) Math.sqrt((i * i) + (i2 * i2));
            int width = z ? RecyclerView.this.getWidth() : RecyclerView.this.getHeight();
            int i6 = width / 2;
            float f = width;
            float f2 = i6;
            float a2 = f2 + (a(Math.min(1.0f, (sqrt2 * 1.0f) / f)) * f2);
            if (sqrt > 0) {
                i5 = Math.round(Math.abs(a2 / sqrt) * 1000.0f) * 4;
            } else {
                if (!z) {
                    abs = abs2;
                }
                i5 = (int) (((abs / f) + 1.0f) * 300.0f);
            }
            return Math.min(i5, 2000);
        }

        public void a(int i, int i2, int i3) {
            a(i, i2, i3, RecyclerView.sQuinticInterpolator);
        }

        public void a(int i, int i2, Interpolator interpolator) {
            int b = b(i, i2, 0, 0);
            if (interpolator == null) {
                interpolator = RecyclerView.sQuinticInterpolator;
            }
            a(i, i2, b, interpolator);
        }

        public void a(int i, int i2, int i3, Interpolator interpolator) {
            if (this.b != interpolator) {
                this.b = interpolator;
                this.f867a = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.setScrollState(2);
            this.e = 0;
            this.d = 0;
            this.f867a.startScroll(0, 0, i, i2, i3);
            if (Build.VERSION.SDK_INT < 23) {
                this.f867a.computeScrollOffset();
            }
            a();
        }

        public void b() {
            RecyclerView.this.removeCallbacks(this);
            this.f867a.abortAnimation();
        }
    }

    void repositionShadowingViews() {
        int b2 = this.mChildHelper.b();
        for (int i2 = 0; i2 < b2; i2++) {
            View b3 = this.mChildHelper.b(i2);
            w childViewHolder = getChildViewHolder(b3);
            if (childViewHolder != null && childViewHolder.mShadowingHolder != null) {
                View view = childViewHolder.mShadowingHolder.itemView;
                int left = b3.getLeft();
                int top = b3.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class r extends c {
        r() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c
        public void onChanged() {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            RecyclerView.this.mState.f = true;
            RecyclerView.this.processDataSetCompletelyChanged(true);
            if (RecyclerView.this.mAdapterHelper.d()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c
        public void onItemRangeChanged(int i, int i2, Object obj) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.a(i, i2, obj)) {
                a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c
        public void onItemRangeInserted(int i, int i2) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.b(i, i2)) {
                a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c
        public void onItemRangeRemoved(int i, int i2) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.c(i, i2)) {
                a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c
        public void onItemRangeMoved(int i, int i2, int i3) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.a(i, i2, i3)) {
                a();
            }
        }

        void a() {
            if (RecyclerView.POST_UPDATES_ON_ANIMATION && RecyclerView.this.mHasFixedSize && RecyclerView.this.mIsAttached) {
                RecyclerView recyclerView = RecyclerView.this;
                androidx.core.f.v.a(recyclerView, recyclerView.mUpdateChildViewsRunnable);
            } else {
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.mAdapterUpdateDuringMeasure = true;
                recyclerView2.requestLayout();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class e {
        protected EdgeEffect a(RecyclerView recyclerView, int i) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    /* loaded from: classes.dex */
    public static class o {

        /* renamed from: a, reason: collision with root package name */
        SparseArray<a> f860a = new SparseArray<>();
        private int b = 0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            final ArrayList<w> f861a = new ArrayList<>();
            int b = 5;
            long c = 0;
            long d = 0;

            a() {
            }
        }

        public void a() {
            for (int i = 0; i < this.f860a.size(); i++) {
                this.f860a.valueAt(i).f861a.clear();
            }
        }

        public w a(int i) {
            a aVar = this.f860a.get(i);
            if (aVar == null || aVar.f861a.isEmpty()) {
                return null;
            }
            return aVar.f861a.remove(r2.size() - 1);
        }

        public void a(w wVar) {
            int itemViewType = wVar.getItemViewType();
            ArrayList<w> arrayList = b(itemViewType).f861a;
            if (this.f860a.get(itemViewType).b <= arrayList.size()) {
                return;
            }
            wVar.resetInternal();
            arrayList.add(wVar);
        }

        long a(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        void a(int i, long j) {
            a b = b(i);
            b.c = a(b.c, j);
        }

        void b(int i, long j) {
            a b = b(i);
            b.d = a(b.d, j);
        }

        boolean a(int i, long j, long j2) {
            long j3 = b(i).c;
            return j3 == 0 || j + j3 < j2;
        }

        boolean b(int i, long j, long j2) {
            long j3 = b(i).d;
            return j3 == 0 || j + j3 < j2;
        }

        void b() {
            this.b++;
        }

        void c() {
            this.b--;
        }

        void a(a aVar, a aVar2, boolean z) {
            if (aVar != null) {
                c();
            }
            if (!z && this.b == 0) {
                a();
            }
            if (aVar2 != null) {
                b();
            }
        }

        private a b(int i) {
            a aVar = this.f860a.get(i);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.f860a.put(i, aVar2);
            return aVar2;
        }
    }

    static RecyclerView findNestedRecyclerView(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView findNestedRecyclerView = findNestedRecyclerView(viewGroup.getChildAt(i2));
            if (findNestedRecyclerView != null) {
                return findNestedRecyclerView;
            }
        }
        return null;
    }

    static void clearNestedRecyclerViewIfNotNested(w wVar) {
        if (wVar.mNestedRecyclerView != null) {
            RecyclerView recyclerView = wVar.mNestedRecyclerView.get();
            while (recyclerView != null) {
                if (recyclerView == wVar.itemView) {
                    return;
                }
                Object parent = recyclerView.getParent();
                recyclerView = parent instanceof View ? (View) parent : null;
            }
            wVar.mNestedRecyclerView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getNanoTime() {
        if (ALLOW_THREAD_GAP_WORK) {
            return System.nanoTime();
        }
        return 0L;
    }

    /* loaded from: classes.dex */
    public final class p {
        o e;
        private u i;

        /* renamed from: a, reason: collision with root package name */
        final ArrayList<w> f862a = new ArrayList<>();
        ArrayList<w> b = null;
        final ArrayList<w> c = new ArrayList<>();
        private final List<w> g = Collections.unmodifiableList(this.f862a);
        private int h = 2;
        int d = 2;

        public p() {
        }

        public void a() {
            this.f862a.clear();
            d();
        }

        public void a(int i) {
            this.h = i;
            b();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void b() {
            this.d = this.h + (RecyclerView.this.mLayout != null ? RecyclerView.this.mLayout.x : 0);
            for (int size = this.c.size() - 1; size >= 0 && this.c.size() > this.d; size--) {
                d(size);
            }
        }

        public List<w> c() {
            return this.g;
        }

        boolean a(w wVar) {
            if (wVar.isRemoved()) {
                return RecyclerView.this.mState.a();
            }
            if (wVar.mPosition < 0 || wVar.mPosition >= RecyclerView.this.mAdapter.getItemCount()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + wVar + RecyclerView.this.exceptionLabel());
            }
            if (RecyclerView.this.mState.a() || RecyclerView.this.mAdapter.getItemViewType(wVar.mPosition) == wVar.getItemViewType()) {
                return !RecyclerView.this.mAdapter.hasStableIds() || wVar.getItemId() == RecyclerView.this.mAdapter.getItemId(wVar.mPosition);
            }
            return false;
        }

        private boolean a(w wVar, int i, int i2, long j) {
            wVar.mOwnerRecyclerView = RecyclerView.this;
            int itemViewType = wVar.getItemViewType();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j != RecyclerView.FOREVER_NS && !this.e.b(itemViewType, nanoTime, j)) {
                return false;
            }
            RecyclerView.this.mAdapter.bindViewHolder(wVar, i);
            this.e.b(wVar.getItemViewType(), RecyclerView.this.getNanoTime() - nanoTime);
            e(wVar);
            if (!RecyclerView.this.mState.a()) {
                return true;
            }
            wVar.mPreLayoutPosition = i2;
            return true;
        }

        public int b(int i) {
            if (i >= 0 && i < RecyclerView.this.mState.e()) {
                return !RecyclerView.this.mState.a() ? i : RecyclerView.this.mAdapterHelper.b(i);
            }
            throw new IndexOutOfBoundsException("invalid position " + i + ". State item count is " + RecyclerView.this.mState.e() + RecyclerView.this.exceptionLabel());
        }

        public View c(int i) {
            return a(i, false);
        }

        View a(int i, boolean z) {
            return a(i, z, RecyclerView.FOREVER_NS).itemView;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Removed duplicated region for block: B:83:0x020c  */
        /* JADX WARN: Removed duplicated region for block: B:90:0x021a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public androidx.recyclerview.widget.RecyclerView.w a(int r17, boolean r18, long r19) {
            /*
                Method dump skipped, instructions count: 629
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.p.a(int, boolean, long):androidx.recyclerview.widget.RecyclerView$w");
        }

        private void e(w wVar) {
            if (RecyclerView.this.isAccessibilityEnabled()) {
                View view = wVar.itemView;
                if (androidx.core.f.v.e(view) == 0) {
                    androidx.core.f.v.b(view, 1);
                }
                if (androidx.core.f.v.b(view)) {
                    return;
                }
                wVar.addFlags(16384);
                androidx.core.f.v.a(view, RecyclerView.this.mAccessibilityDelegate.c());
            }
        }

        private void f(w wVar) {
            if (wVar.itemView instanceof ViewGroup) {
                a((ViewGroup) wVar.itemView, false);
            }
        }

        private void a(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    a((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }

        public void a(View view) {
            w childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (childViewHolderInt.isScrap()) {
                childViewHolderInt.unScrap();
            } else if (childViewHolderInt.wasReturnedFromScrap()) {
                childViewHolderInt.clearReturnedFromScrapFlag();
            }
            b(childViewHolderInt);
        }

        void d() {
            for (int size = this.c.size() - 1; size >= 0; size--) {
                d(size);
            }
            this.c.clear();
            if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                RecyclerView.this.mPrefetchRegistry.a();
            }
        }

        void d(int i) {
            a(this.c.get(i), true);
            this.c.remove(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void b(w wVar) {
            boolean z;
            if (wVar.isScrap() || wVar.itemView.getParent() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(wVar.isScrap());
                sb.append(" isAttached:");
                sb.append(wVar.itemView.getParent() != null);
                sb.append(RecyclerView.this.exceptionLabel());
                throw new IllegalArgumentException(sb.toString());
            }
            if (wVar.isTmpDetached()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + wVar + RecyclerView.this.exceptionLabel());
            }
            if (wVar.shouldIgnore()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.exceptionLabel());
            }
            boolean doesTransientStatePreventRecycling = wVar.doesTransientStatePreventRecycling();
            if ((RecyclerView.this.mAdapter != null && doesTransientStatePreventRecycling && RecyclerView.this.mAdapter.onFailedToRecycleView(wVar)) || wVar.isRecyclable()) {
                if (this.d <= 0 || wVar.hasAnyOfTheFlags(526)) {
                    z = false;
                } else {
                    int size = this.c.size();
                    if (size >= this.d && size > 0) {
                        d(0);
                        size--;
                    }
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK && size > 0 && !RecyclerView.this.mPrefetchRegistry.a(wVar.mPosition)) {
                        int i = size - 1;
                        while (i >= 0) {
                            if (!RecyclerView.this.mPrefetchRegistry.a(this.c.get(i).mPosition)) {
                                break;
                            } else {
                                i--;
                            }
                        }
                        size = i + 1;
                    }
                    this.c.add(size, wVar);
                    z = true;
                }
                if (!z) {
                    a(wVar, true);
                    r1 = true;
                }
            } else {
                z = false;
            }
            RecyclerView.this.mViewInfoStore.g(wVar);
            if (z || r1 || !doesTransientStatePreventRecycling) {
                return;
            }
            wVar.mOwnerRecyclerView = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(w wVar, boolean z) {
            RecyclerView.clearNestedRecyclerViewIfNotNested(wVar);
            if (wVar.hasAnyOfTheFlags(16384)) {
                wVar.setFlags(0, 16384);
                androidx.core.f.v.a(wVar.itemView, (androidx.core.f.a) null);
            }
            if (z) {
                d(wVar);
            }
            wVar.mOwnerRecyclerView = null;
            g().a(wVar);
        }

        void b(View view) {
            w childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.mScrapContainer = null;
            childViewHolderInt.mInChangeScrap = false;
            childViewHolderInt.clearReturnedFromScrapFlag();
            b(childViewHolderInt);
        }

        void c(View view) {
            w childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.hasAnyOfTheFlags(12) || !childViewHolderInt.isUpdated() || RecyclerView.this.canReuseUpdatedViewHolder(childViewHolderInt)) {
                if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !RecyclerView.this.mAdapter.hasStableIds()) {
                    throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.exceptionLabel());
                }
                childViewHolderInt.setScrapContainer(this, false);
                this.f862a.add(childViewHolderInt);
                return;
            }
            if (this.b == null) {
                this.b = new ArrayList<>();
            }
            childViewHolderInt.setScrapContainer(this, true);
            this.b.add(childViewHolderInt);
        }

        void c(w wVar) {
            if (wVar.mInChangeScrap) {
                this.b.remove(wVar);
            } else {
                this.f862a.remove(wVar);
            }
            wVar.mScrapContainer = null;
            wVar.mInChangeScrap = false;
            wVar.clearReturnedFromScrapFlag();
        }

        int e() {
            return this.f862a.size();
        }

        View e(int i) {
            return this.f862a.get(i).itemView;
        }

        void f() {
            this.f862a.clear();
            ArrayList<w> arrayList = this.b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        w f(int i) {
            int size;
            int b;
            ArrayList<w> arrayList = this.b;
            if (arrayList == null || (size = arrayList.size()) == 0) {
                return null;
            }
            for (int i2 = 0; i2 < size; i2++) {
                w wVar = this.b.get(i2);
                if (!wVar.wasReturnedFromScrap() && wVar.getLayoutPosition() == i) {
                    wVar.addFlags(32);
                    return wVar;
                }
            }
            if (RecyclerView.this.mAdapter.hasStableIds() && (b = RecyclerView.this.mAdapterHelper.b(i)) > 0 && b < RecyclerView.this.mAdapter.getItemCount()) {
                long itemId = RecyclerView.this.mAdapter.getItemId(b);
                for (int i3 = 0; i3 < size; i3++) {
                    w wVar2 = this.b.get(i3);
                    if (!wVar2.wasReturnedFromScrap() && wVar2.getItemId() == itemId) {
                        wVar2.addFlags(32);
                        return wVar2;
                    }
                }
            }
            return null;
        }

        w b(int i, boolean z) {
            View c;
            int size = this.f862a.size();
            for (int i2 = 0; i2 < size; i2++) {
                w wVar = this.f862a.get(i2);
                if (!wVar.wasReturnedFromScrap() && wVar.getLayoutPosition() == i && !wVar.isInvalid() && (RecyclerView.this.mState.g || !wVar.isRemoved())) {
                    wVar.addFlags(32);
                    return wVar;
                }
            }
            if (!z && (c = RecyclerView.this.mChildHelper.c(i)) != null) {
                w childViewHolderInt = RecyclerView.getChildViewHolderInt(c);
                RecyclerView.this.mChildHelper.e(c);
                int b = RecyclerView.this.mChildHelper.b(c);
                if (b == -1) {
                    throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + childViewHolderInt + RecyclerView.this.exceptionLabel());
                }
                RecyclerView.this.mChildHelper.e(b);
                c(c);
                childViewHolderInt.addFlags(8224);
                return childViewHolderInt;
            }
            int size2 = this.c.size();
            for (int i3 = 0; i3 < size2; i3++) {
                w wVar2 = this.c.get(i3);
                if (!wVar2.isInvalid() && wVar2.getLayoutPosition() == i) {
                    if (!z) {
                        this.c.remove(i3);
                    }
                    return wVar2;
                }
            }
            return null;
        }

        w a(long j, int i, boolean z) {
            for (int size = this.f862a.size() - 1; size >= 0; size--) {
                w wVar = this.f862a.get(size);
                if (wVar.getItemId() == j && !wVar.wasReturnedFromScrap()) {
                    if (i == wVar.getItemViewType()) {
                        wVar.addFlags(32);
                        if (wVar.isRemoved() && !RecyclerView.this.mState.a()) {
                            wVar.setFlags(2, 14);
                        }
                        return wVar;
                    }
                    if (!z) {
                        this.f862a.remove(size);
                        RecyclerView.this.removeDetachedView(wVar.itemView, false);
                        b(wVar.itemView);
                    }
                }
            }
            int size2 = this.c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                w wVar2 = this.c.get(size2);
                if (wVar2.getItemId() == j) {
                    if (i == wVar2.getItemViewType()) {
                        if (!z) {
                            this.c.remove(size2);
                        }
                        return wVar2;
                    }
                    if (!z) {
                        d(size2);
                        return null;
                    }
                }
            }
        }

        void d(w wVar) {
            if (RecyclerView.this.mRecyclerListener != null) {
                RecyclerView.this.mRecyclerListener.a(wVar);
            }
            if (RecyclerView.this.mAdapter != null) {
                RecyclerView.this.mAdapter.onViewRecycled(wVar);
            }
            if (RecyclerView.this.mState != null) {
                RecyclerView.this.mViewInfoStore.g(wVar);
            }
        }

        void a(a aVar, a aVar2, boolean z) {
            a();
            g().a(aVar, aVar2, z);
        }

        void a(int i, int i2) {
            int i3;
            int i4;
            int i5;
            if (i < i2) {
                i4 = i;
                i3 = i2;
                i5 = -1;
            } else {
                i3 = i;
                i4 = i2;
                i5 = 1;
            }
            int size = this.c.size();
            for (int i6 = 0; i6 < size; i6++) {
                w wVar = this.c.get(i6);
                if (wVar != null && wVar.mPosition >= i4 && wVar.mPosition <= i3) {
                    if (wVar.mPosition == i) {
                        wVar.offsetPosition(i2 - i, false);
                    } else {
                        wVar.offsetPosition(i5, false);
                    }
                }
            }
        }

        void b(int i, int i2) {
            int size = this.c.size();
            for (int i3 = 0; i3 < size; i3++) {
                w wVar = this.c.get(i3);
                if (wVar != null && wVar.mPosition >= i) {
                    wVar.offsetPosition(i2, true);
                }
            }
        }

        void a(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.c.size() - 1; size >= 0; size--) {
                w wVar = this.c.get(size);
                if (wVar != null) {
                    if (wVar.mPosition >= i3) {
                        wVar.offsetPosition(-i2, z);
                    } else if (wVar.mPosition >= i) {
                        wVar.addFlags(8);
                        d(size);
                    }
                }
            }
        }

        void a(u uVar) {
            this.i = uVar;
        }

        void a(o oVar) {
            o oVar2 = this.e;
            if (oVar2 != null) {
                oVar2.c();
            }
            this.e = oVar;
            if (this.e == null || RecyclerView.this.getAdapter() == null) {
                return;
            }
            this.e.b();
        }

        o g() {
            if (this.e == null) {
                this.e = new o();
            }
            return this.e;
        }

        void c(int i, int i2) {
            int i3;
            int i4 = i2 + i;
            for (int size = this.c.size() - 1; size >= 0; size--) {
                w wVar = this.c.get(size);
                if (wVar != null && (i3 = wVar.mPosition) >= i && i3 < i4) {
                    wVar.addFlags(2);
                    d(size);
                }
            }
        }

        void h() {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                w wVar = this.c.get(i);
                if (wVar != null) {
                    wVar.addFlags(6);
                    wVar.addChangePayload(null);
                }
            }
            if (RecyclerView.this.mAdapter == null || !RecyclerView.this.mAdapter.hasStableIds()) {
                d();
            }
        }

        void i() {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                this.c.get(i).clearOldPosition();
            }
            int size2 = this.f862a.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.f862a.get(i2).clearOldPosition();
            }
            ArrayList<w> arrayList = this.b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    this.b.get(i3).clearOldPosition();
                }
            }
        }

        void j() {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                j jVar = (j) this.c.get(i).itemView.getLayoutParams();
                if (jVar != null) {
                    jVar.e = true;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class a<VH extends w> {
        private final b mObservable = new b();
        private boolean mHasStableIds = false;

        public abstract int getItemCount();

        public long getItemId(int i) {
            return -1L;
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(VH vh, int i);

        public abstract VH onCreateViewHolder(ViewGroup viewGroup, int i);

        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        }

        public boolean onFailedToRecycleView(VH vh) {
            return false;
        }

        public void onViewAttachedToWindow(VH vh) {
        }

        public void onViewDetachedFromWindow(VH vh) {
        }

        public void onViewRecycled(VH vh) {
        }

        public void onBindViewHolder(VH vh, int i, List<Object> list) {
            onBindViewHolder(vh, i);
        }

        public final VH createViewHolder(ViewGroup viewGroup, int i) {
            try {
                androidx.core.os.c.a(RecyclerView.TRACE_CREATE_VIEW_TAG);
                VH onCreateViewHolder = onCreateViewHolder(viewGroup, i);
                if (onCreateViewHolder.itemView.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                onCreateViewHolder.mItemViewType = i;
                return onCreateViewHolder;
            } finally {
                androidx.core.os.c.a();
            }
        }

        public final void bindViewHolder(VH vh, int i) {
            vh.mPosition = i;
            if (hasStableIds()) {
                vh.mItemId = getItemId(i);
            }
            vh.setFlags(1, 519);
            androidx.core.os.c.a(RecyclerView.TRACE_BIND_VIEW_TAG);
            onBindViewHolder(vh, i, vh.getUnmodifiedPayloads());
            vh.clearPayload();
            ViewGroup.LayoutParams layoutParams = vh.itemView.getLayoutParams();
            if (layoutParams instanceof j) {
                ((j) layoutParams).e = true;
            }
            androidx.core.os.c.a();
        }

        public void setHasStableIds(boolean z) {
            if (hasObservers()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.mHasStableIds = z;
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final boolean hasObservers() {
            return this.mObservable.a();
        }

        public void registerAdapterDataObserver(c cVar) {
            this.mObservable.registerObserver(cVar);
        }

        public void unregisterAdapterDataObserver(c cVar) {
            this.mObservable.unregisterObserver(cVar);
        }

        public final void notifyDataSetChanged() {
            this.mObservable.b();
        }

        public final void notifyItemChanged(int i) {
            this.mObservable.a(i, 1);
        }

        public final void notifyItemChanged(int i, Object obj) {
            this.mObservable.a(i, 1, obj);
        }

        public final void notifyItemRangeChanged(int i, int i2) {
            this.mObservable.a(i, i2);
        }

        public final void notifyItemRangeChanged(int i, int i2, Object obj) {
            this.mObservable.a(i, i2, obj);
        }

        public final void notifyItemInserted(int i) {
            this.mObservable.b(i, 1);
        }

        public final void notifyItemMoved(int i, int i2) {
            this.mObservable.d(i, i2);
        }

        public final void notifyItemRangeInserted(int i, int i2) {
            this.mObservable.b(i, i2);
        }

        public final void notifyItemRemoved(int i) {
            this.mObservable.c(i, 1);
        }

        public final void notifyItemRangeRemoved(int i, int i2) {
            this.mObservable.c(i, i2);
        }
    }

    void dispatchChildDetached(View view) {
        w childViewHolderInt = getChildViewHolderInt(view);
        onChildDetachedFromWindow(view);
        a aVar = this.mAdapter;
        if (aVar != null && childViewHolderInt != null) {
            aVar.onViewDetachedFromWindow(childViewHolderInt);
        }
        List<k> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).b(view);
            }
        }
    }

    void dispatchChildAttached(View view) {
        w childViewHolderInt = getChildViewHolderInt(view);
        onChildAttachedToWindow(view);
        a aVar = this.mAdapter;
        if (aVar != null && childViewHolderInt != null) {
            aVar.onViewAttachedToWindow(childViewHolderInt);
        }
        List<k> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).a(view);
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class i {
        private int e;
        private int f;
        private int g;
        private int h;
        androidx.recyclerview.widget.b p;
        RecyclerView q;
        s t;
        int x;
        boolean y;

        /* renamed from: a, reason: collision with root package name */
        private final m.b f856a = new m.b() { // from class: androidx.recyclerview.widget.RecyclerView.i.1
            @Override // androidx.recyclerview.widget.m.b
            public View a(int i) {
                return i.this.i(i);
            }

            @Override // androidx.recyclerview.widget.m.b
            public int a() {
                return i.this.D();
            }

            @Override // androidx.recyclerview.widget.m.b
            public int b() {
                return i.this.B() - i.this.F();
            }

            @Override // androidx.recyclerview.widget.m.b
            public int a(View view) {
                return i.this.h(view) - ((j) view.getLayoutParams()).leftMargin;
            }

            @Override // androidx.recyclerview.widget.m.b
            public int b(View view) {
                return i.this.j(view) + ((j) view.getLayoutParams()).rightMargin;
            }
        };
        private final m.b b = new m.b() { // from class: androidx.recyclerview.widget.RecyclerView.i.2
            @Override // androidx.recyclerview.widget.m.b
            public View a(int i) {
                return i.this.i(i);
            }

            @Override // androidx.recyclerview.widget.m.b
            public int a() {
                return i.this.E();
            }

            @Override // androidx.recyclerview.widget.m.b
            public int b() {
                return i.this.C() - i.this.G();
            }

            @Override // androidx.recyclerview.widget.m.b
            public int a(View view) {
                return i.this.i(view) - ((j) view.getLayoutParams()).topMargin;
            }

            @Override // androidx.recyclerview.widget.m.b
            public int b(View view) {
                return i.this.k(view) + ((j) view.getLayoutParams()).bottomMargin;
            }
        };
        androidx.recyclerview.widget.m r = new androidx.recyclerview.widget.m(this.f856a);
        androidx.recyclerview.widget.m s = new androidx.recyclerview.widget.m(this.b);
        boolean u = false;
        boolean v = false;
        boolean w = false;
        private boolean c = true;
        private boolean d = true;

        /* loaded from: classes.dex */
        public interface a {
            void b(int i, int i2);
        }

        /* loaded from: classes.dex */
        public static class b {

            /* renamed from: a, reason: collision with root package name */
            public int f859a;
            public int b;
            public boolean c;
            public boolean d;
        }

        public int a(int i, p pVar, t tVar) {
            return 0;
        }

        public View a(View view, int i, p pVar, t tVar) {
            return null;
        }

        public abstract j a();

        public void a(int i, int i2, t tVar, a aVar) {
        }

        public void a(int i, a aVar) {
        }

        public void a(Parcelable parcelable) {
        }

        public void a(a aVar, a aVar2) {
        }

        public void a(t tVar) {
        }

        public void a(RecyclerView recyclerView) {
        }

        public void a(RecyclerView recyclerView, int i, int i2) {
        }

        public void a(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        public boolean a(j jVar) {
            return jVar != null;
        }

        public boolean a(p pVar, t tVar, View view, int i, Bundle bundle) {
            return false;
        }

        public boolean a(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        public int b(int i, p pVar, t tVar) {
            return 0;
        }

        public void b(RecyclerView recyclerView, int i, int i2) {
        }

        public int c(t tVar) {
            return 0;
        }

        public void c(RecyclerView recyclerView, int i, int i2) {
        }

        public boolean c() {
            return false;
        }

        public int d(p pVar, t tVar) {
            return 0;
        }

        public int d(t tVar) {
            return 0;
        }

        public View d(View view, int i) {
            return null;
        }

        public void d(RecyclerView recyclerView) {
        }

        public int e(t tVar) {
            return 0;
        }

        public Parcelable e() {
            return null;
        }

        public void e(int i) {
        }

        @Deprecated
        public void e(RecyclerView recyclerView) {
        }

        public boolean e(p pVar, t tVar) {
            return false;
        }

        public int f(t tVar) {
            return 0;
        }

        public boolean f() {
            return false;
        }

        public int g(t tVar) {
            return 0;
        }

        public boolean g() {
            return false;
        }

        public int h(t tVar) {
            return 0;
        }

        public void l(int i) {
        }

        boolean m() {
            return false;
        }

        public int x() {
            return -1;
        }

        void b(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.q = null;
                this.p = null;
                this.g = 0;
                this.h = 0;
            } else {
                this.q = recyclerView;
                this.p = recyclerView.mChildHelper;
                this.g = recyclerView.getWidth();
                this.h = recyclerView.getHeight();
            }
            this.e = 1073741824;
            this.f = 1073741824;
        }

        void d(int i, int i2) {
            this.g = View.MeasureSpec.getSize(i);
            this.e = View.MeasureSpec.getMode(i);
            if (this.e == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.g = 0;
            }
            this.h = View.MeasureSpec.getSize(i2);
            this.f = View.MeasureSpec.getMode(i2);
            if (this.f != 0 || RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                return;
            }
            this.h = 0;
        }

        void e(int i, int i2) {
            int y = y();
            if (y == 0) {
                this.q.defaultOnMeasure(i, i2);
                return;
            }
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MAX_VALUE;
            int i5 = BleSignal.UNKNOWN_TX_POWER;
            int i6 = BleSignal.UNKNOWN_TX_POWER;
            for (int i7 = 0; i7 < y; i7++) {
                View i8 = i(i7);
                Rect rect = this.q.mTempRect;
                a(i8, rect);
                if (rect.left < i3) {
                    i3 = rect.left;
                }
                if (rect.right > i5) {
                    i5 = rect.right;
                }
                if (rect.top < i4) {
                    i4 = rect.top;
                }
                if (rect.bottom > i6) {
                    i6 = rect.bottom;
                }
            }
            this.q.mTempRect.set(i3, i4, i5, i6);
            a(this.q.mTempRect, i, i2);
        }

        public void a(Rect rect, int i, int i2) {
            g(a(i, rect.width() + D() + F(), J()), a(i2, rect.height() + E() + G(), K()));
        }

        public void r() {
            RecyclerView recyclerView = this.q;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public static int a(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i2, i3) : size;
            }
            return Math.min(size, Math.max(i2, i3));
        }

        public void a(String str) {
            RecyclerView recyclerView = this.q;
            if (recyclerView != null) {
                recyclerView.assertNotInLayoutOrScroll(str);
            }
        }

        @Deprecated
        public void c(boolean z) {
            this.w = z;
        }

        public boolean d() {
            return this.w;
        }

        public final boolean s() {
            return this.d;
        }

        void c(RecyclerView recyclerView) {
            this.v = true;
            d(recyclerView);
        }

        void b(RecyclerView recyclerView, p pVar) {
            this.v = false;
            a(recyclerView, pVar);
        }

        public boolean t() {
            return this.v;
        }

        public boolean a(Runnable runnable) {
            RecyclerView recyclerView = this.q;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void a(RecyclerView recyclerView, p pVar) {
            e(recyclerView);
        }

        public boolean u() {
            RecyclerView recyclerView = this.q;
            return recyclerView != null && recyclerView.mClipToPadding;
        }

        public void c(p pVar, t tVar) {
            Log.e(RecyclerView.TAG, "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public j a(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof j) {
                return new j((j) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new j((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new j(layoutParams);
        }

        public j a(Context context, AttributeSet attributeSet) {
            return new j(context, attributeSet);
        }

        public void a(RecyclerView recyclerView, t tVar, int i) {
            Log.e(RecyclerView.TAG, "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void a(s sVar) {
            s sVar2 = this.t;
            if (sVar2 != null && sVar != sVar2 && sVar2.h()) {
                this.t.f();
            }
            this.t = sVar;
            this.t.a(this.q, this);
        }

        public boolean v() {
            s sVar = this.t;
            return sVar != null && sVar.h();
        }

        public int w() {
            return androidx.core.f.v.f(this.q);
        }

        public void a(View view) {
            a(view, -1);
        }

        public void a(View view, int i) {
            a(view, i, true);
        }

        public void b(View view) {
            b(view, -1);
        }

        public void b(View view, int i) {
            a(view, i, false);
        }

        private void a(View view, int i, boolean z) {
            w childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (z || childViewHolderInt.isRemoved()) {
                this.q.mViewInfoStore.e(childViewHolderInt);
            } else {
                this.q.mViewInfoStore.f(childViewHolderInt);
            }
            j jVar = (j) view.getLayoutParams();
            if (childViewHolderInt.wasReturnedFromScrap() || childViewHolderInt.isScrap()) {
                if (childViewHolderInt.isScrap()) {
                    childViewHolderInt.unScrap();
                } else {
                    childViewHolderInt.clearReturnedFromScrapFlag();
                }
                this.p.a(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.q) {
                int b2 = this.p.b(view);
                if (i == -1) {
                    i = this.p.b();
                }
                if (b2 == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.q.indexOfChild(view) + this.q.exceptionLabel());
                }
                if (b2 != i) {
                    this.q.mLayout.f(b2, i);
                }
            } else {
                this.p.a(view, i, false);
                jVar.e = true;
                s sVar = this.t;
                if (sVar != null && sVar.h()) {
                    this.t.b(view);
                }
            }
            if (jVar.f) {
                childViewHolderInt.itemView.invalidate();
                jVar.f = false;
            }
        }

        public void c(View view) {
            this.p.a(view);
        }

        public void g(int i) {
            if (i(i) != null) {
                this.p.a(i);
            }
        }

        public int d(View view) {
            return ((j) view.getLayoutParams()).f();
        }

        public View e(View view) {
            View findContainingItemView;
            RecyclerView recyclerView = this.q;
            if (recyclerView == null || (findContainingItemView = recyclerView.findContainingItemView(view)) == null || this.p.c(findContainingItemView)) {
                return null;
            }
            return findContainingItemView;
        }

        public View c(int i) {
            int y = y();
            for (int i2 = 0; i2 < y; i2++) {
                View i3 = i(i2);
                w childViewHolderInt = RecyclerView.getChildViewHolderInt(i3);
                if (childViewHolderInt != null && childViewHolderInt.getLayoutPosition() == i && !childViewHolderInt.shouldIgnore() && (this.q.mState.a() || !childViewHolderInt.isRemoved())) {
                    return i3;
                }
            }
            return null;
        }

        public void h(int i) {
            a(i, i(i));
        }

        private void a(int i, View view) {
            this.p.e(i);
        }

        public void a(View view, int i, j jVar) {
            w childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isRemoved()) {
                this.q.mViewInfoStore.e(childViewHolderInt);
            } else {
                this.q.mViewInfoStore.f(childViewHolderInt);
            }
            this.p.a(view, i, jVar, childViewHolderInt.isRemoved());
        }

        public void c(View view, int i) {
            a(view, i, (j) view.getLayoutParams());
        }

        public void f(int i, int i2) {
            View i3 = i(i);
            if (i3 == null) {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.q.toString());
            }
            h(i);
            c(i3, i2);
        }

        public void a(View view, p pVar) {
            c(view);
            pVar.a(view);
        }

        public void a(int i, p pVar) {
            View i2 = i(i);
            g(i);
            pVar.a(i2);
        }

        public int y() {
            androidx.recyclerview.widget.b bVar = this.p;
            if (bVar != null) {
                return bVar.b();
            }
            return 0;
        }

        public View i(int i) {
            androidx.recyclerview.widget.b bVar = this.p;
            if (bVar != null) {
                return bVar.b(i);
            }
            return null;
        }

        public int z() {
            return this.e;
        }

        public int A() {
            return this.f;
        }

        public int B() {
            return this.g;
        }

        public int C() {
            return this.h;
        }

        public int D() {
            RecyclerView recyclerView = this.q;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int E() {
            RecyclerView recyclerView = this.q;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int F() {
            RecyclerView recyclerView = this.q;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int G() {
            RecyclerView recyclerView = this.q;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public View H() {
            View focusedChild;
            RecyclerView recyclerView = this.q;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.p.c(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public int I() {
            RecyclerView recyclerView = this.q;
            a adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public void j(int i) {
            RecyclerView recyclerView = this.q;
            if (recyclerView != null) {
                recyclerView.offsetChildrenHorizontal(i);
            }
        }

        public void k(int i) {
            RecyclerView recyclerView = this.q;
            if (recyclerView != null) {
                recyclerView.offsetChildrenVertical(i);
            }
        }

        public void a(p pVar) {
            for (int y = y() - 1; y >= 0; y--) {
                a(pVar, y, i(y));
            }
        }

        private void a(p pVar, int i, View view) {
            w childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.shouldIgnore()) {
                return;
            }
            if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !this.q.mAdapter.hasStableIds()) {
                g(i);
                pVar.b(childViewHolderInt);
            } else {
                h(i);
                pVar.c(view);
                this.q.mViewInfoStore.h(childViewHolderInt);
            }
        }

        void b(p pVar) {
            int e = pVar.e();
            for (int i = e - 1; i >= 0; i--) {
                View e2 = pVar.e(i);
                w childViewHolderInt = RecyclerView.getChildViewHolderInt(e2);
                if (!childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.setIsRecyclable(false);
                    if (childViewHolderInt.isTmpDetached()) {
                        this.q.removeDetachedView(e2, false);
                    }
                    if (this.q.mItemAnimator != null) {
                        this.q.mItemAnimator.d(childViewHolderInt);
                    }
                    childViewHolderInt.setIsRecyclable(true);
                    pVar.b(e2);
                }
            }
            pVar.f();
            if (e > 0) {
                this.q.invalidate();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a(View view, int i, int i2, j jVar) {
            return (this.c && b(view.getMeasuredWidth(), i, jVar.width) && b(view.getMeasuredHeight(), i2, jVar.height)) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean b(View view, int i, int i2, j jVar) {
            return (!view.isLayoutRequested() && this.c && b(view.getWidth(), i, jVar.width) && b(view.getHeight(), i2, jVar.height)) ? false : true;
        }

        private static boolean b(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i;
            }
            return true;
        }

        public void a(View view, int i, int i2) {
            j jVar = (j) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.q.getItemDecorInsetsForChild(view);
            int i3 = i + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right;
            int i4 = i2 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
            int a2 = a(B(), z(), D() + F() + jVar.leftMargin + jVar.rightMargin + i3, jVar.width, f());
            int a3 = a(C(), A(), E() + G() + jVar.topMargin + jVar.bottomMargin + i4, jVar.height, g());
            if (b(view, a2, a3, jVar)) {
                view.measure(a2, a3);
            }
        }

        public static int a(int i, int i2, int i3, int i4, boolean z) {
            int i5;
            int i6 = i - i3;
            int i7 = 0;
            int max = Math.max(0, i6);
            if (z) {
                if (i4 >= 0) {
                    max = i4;
                    i7 = 1073741824;
                } else if (i4 == -1) {
                    if (i2 != Integer.MIN_VALUE) {
                        if (i2 == 0) {
                            i2 = 0;
                            i5 = 0;
                        } else if (i2 != 1073741824) {
                            i2 = 0;
                            i5 = 0;
                        }
                        i7 = i2;
                        max = i5;
                    }
                    i5 = max;
                    i7 = i2;
                    max = i5;
                } else {
                    if (i4 == -2) {
                        max = 0;
                    }
                    max = 0;
                }
            } else if (i4 >= 0) {
                max = i4;
                i7 = 1073741824;
            } else if (i4 == -1) {
                i7 = i2;
            } else {
                if (i4 == -2) {
                    if (i2 == Integer.MIN_VALUE || i2 == 1073741824) {
                        i7 = BleSignal.UNKNOWN_TX_POWER;
                    }
                }
                max = 0;
            }
            return View.MeasureSpec.makeMeasureSpec(max, i7);
        }

        public int f(View view) {
            Rect rect = ((j) view.getLayoutParams()).d;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int g(View view) {
            Rect rect = ((j) view.getLayoutParams()).d;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void a(View view, int i, int i2, int i3, int i4) {
            j jVar = (j) view.getLayoutParams();
            Rect rect = jVar.d;
            view.layout(i + rect.left + jVar.leftMargin, i2 + rect.top + jVar.topMargin, (i3 - rect.right) - jVar.rightMargin, (i4 - rect.bottom) - jVar.bottomMargin);
        }

        public void a(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((j) view.getLayoutParams()).d;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.q != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.q.mTempRectF;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void a(View view, Rect rect) {
            RecyclerView.getDecoratedBoundsWithMarginsInt(view, rect);
        }

        public int h(View view) {
            return view.getLeft() - n(view);
        }

        public int i(View view) {
            return view.getTop() - l(view);
        }

        public int j(View view) {
            return view.getRight() + o(view);
        }

        public int k(View view) {
            return view.getBottom() + m(view);
        }

        public void b(View view, Rect rect) {
            RecyclerView recyclerView = this.q;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.getItemDecorInsetsForChild(view));
            }
        }

        public int l(View view) {
            return ((j) view.getLayoutParams()).d.top;
        }

        public int m(View view) {
            return ((j) view.getLayoutParams()).d.bottom;
        }

        public int n(View view) {
            return ((j) view.getLayoutParams()).d.left;
        }

        public int o(View view) {
            return ((j) view.getLayoutParams()).d.right;
        }

        private int[] b(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            int[] iArr = new int[2];
            int D = D();
            int E = E();
            int B = B() - F();
            int C = C() - G();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width = rect.width() + left;
            int height = rect.height() + top;
            int i = left - D;
            int min = Math.min(0, i);
            int i2 = top - E;
            int min2 = Math.min(0, i2);
            int i3 = width - B;
            int max = Math.max(0, i3);
            int max2 = Math.max(0, height - C);
            if (w() != 1) {
                max = min != 0 ? min : Math.min(i, max);
            } else if (max == 0) {
                max = Math.max(min, i3);
            }
            if (min2 == 0) {
                min2 = Math.min(i2, max2);
            }
            iArr[0] = max;
            iArr[1] = min2;
            return iArr;
        }

        public boolean a(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return a(recyclerView, view, rect, z, false);
        }

        public boolean a(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] b2 = b(recyclerView, view, rect, z);
            int i = b2[0];
            int i2 = b2[1];
            if ((z2 && !d(recyclerView, i, i2)) || (i == 0 && i2 == 0)) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i, i2);
            } else {
                recyclerView.smoothScrollBy(i, i2);
            }
            return true;
        }

        public boolean a(View view, boolean z, boolean z2) {
            boolean z3 = this.r.a(view, GCloudVoiceErrorCode.GCloudVoiceCompleteCode.GV_ON_PUNISHED) && this.s.a(view, GCloudVoiceErrorCode.GCloudVoiceCompleteCode.GV_ON_PUNISHED);
            return z ? z3 : !z3;
        }

        private boolean d(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int D = D();
            int E = E();
            int B = B() - F();
            int C = C() - G();
            Rect rect = this.q.mTempRect;
            a(focusedChild, rect);
            return rect.left - i < B && rect.right - i > D && rect.top - i2 < C && rect.bottom - i2 > E;
        }

        @Deprecated
        public boolean a(RecyclerView recyclerView, View view, View view2) {
            return v() || recyclerView.isComputingLayout();
        }

        public boolean a(RecyclerView recyclerView, t tVar, View view, View view2) {
            return a(recyclerView, view, view2);
        }

        public void a(RecyclerView recyclerView, int i, int i2, Object obj) {
            c(recyclerView, i, i2);
        }

        public void a(p pVar, t tVar, int i, int i2) {
            this.q.defaultOnMeasure(i, i2);
        }

        public void g(int i, int i2) {
            this.q.setMeasuredDimension(i, i2);
        }

        public int J() {
            return androidx.core.f.v.j(this.q);
        }

        public int K() {
            return androidx.core.f.v.k(this.q);
        }

        void L() {
            s sVar = this.t;
            if (sVar != null) {
                sVar.f();
            }
        }

        void b(s sVar) {
            if (this.t == sVar) {
                this.t = null;
            }
        }

        public void c(p pVar) {
            for (int y = y() - 1; y >= 0; y--) {
                if (!RecyclerView.getChildViewHolderInt(i(y)).shouldIgnore()) {
                    a(y, pVar);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(androidx.core.f.a.d dVar) {
            a(this.q.mRecycler, this.q.mState, dVar);
        }

        public void a(p pVar, t tVar, androidx.core.f.a.d dVar) {
            if (this.q.canScrollVertically(-1) || this.q.canScrollHorizontally(-1)) {
                dVar.a(8192);
                dVar.c(true);
            }
            if (this.q.canScrollVertically(1) || this.q.canScrollHorizontally(1)) {
                dVar.a(4096);
                dVar.c(true);
            }
            dVar.a(d.b.a(a(pVar, tVar), b(pVar, tVar), e(pVar, tVar), d(pVar, tVar)));
        }

        public void a(AccessibilityEvent accessibilityEvent) {
            a(this.q.mRecycler, this.q.mState, accessibilityEvent);
        }

        public void a(p pVar, t tVar, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.q;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z = true;
            if (!recyclerView.canScrollVertically(1) && !this.q.canScrollVertically(-1) && !this.q.canScrollHorizontally(-1) && !this.q.canScrollHorizontally(1)) {
                z = false;
            }
            accessibilityEvent.setScrollable(z);
            if (this.q.mAdapter != null) {
                accessibilityEvent.setItemCount(this.q.mAdapter.getItemCount());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(View view, androidx.core.f.a.d dVar) {
            w childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt == null || childViewHolderInt.isRemoved() || this.p.c(childViewHolderInt.itemView)) {
                return;
            }
            a(this.q.mRecycler, this.q.mState, view, dVar);
        }

        public void a(p pVar, t tVar, View view, androidx.core.f.a.d dVar) {
            dVar.b(d.c.a(g() ? d(view) : 0, 1, f() ? d(view) : 0, 1, false, false));
        }

        public void M() {
            this.u = true;
        }

        public int a(p pVar, t tVar) {
            RecyclerView recyclerView = this.q;
            if (recyclerView == null || recyclerView.mAdapter == null || !g()) {
                return 1;
            }
            return this.q.mAdapter.getItemCount();
        }

        public int b(p pVar, t tVar) {
            RecyclerView recyclerView = this.q;
            if (recyclerView == null || recyclerView.mAdapter == null || !f()) {
                return 1;
            }
            return this.q.mAdapter.getItemCount();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a(int i, Bundle bundle) {
            return a(this.q.mRecycler, this.q.mState, i, bundle);
        }

        public boolean a(p pVar, t tVar, int i, Bundle bundle) {
            int C;
            int B;
            RecyclerView recyclerView = this.q;
            if (recyclerView == null) {
                return false;
            }
            if (i == 4096) {
                C = recyclerView.canScrollVertically(1) ? (C() - E()) - G() : 0;
                B = this.q.canScrollHorizontally(1) ? (B() - D()) - F() : 0;
            } else if (i != 8192) {
                C = 0;
                B = 0;
            } else {
                C = recyclerView.canScrollVertically(-1) ? -((C() - E()) - G()) : 0;
                B = this.q.canScrollHorizontally(-1) ? -((B() - D()) - F()) : 0;
            }
            if (C == 0 && B == 0) {
                return false;
            }
            this.q.smoothScrollBy(B, C);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a(View view, int i, Bundle bundle) {
            return a(this.q.mRecycler, this.q.mState, view, i, bundle);
        }

        public static b a(Context context, AttributeSet attributeSet, int i, int i2) {
            b bVar = new b();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.b.RecyclerView, i, i2);
            bVar.f859a = obtainStyledAttributes.getInt(a.b.RecyclerView_android_orientation, 1);
            bVar.b = obtainStyledAttributes.getInt(a.b.RecyclerView_spanCount, 1);
            bVar.c = obtainStyledAttributes.getBoolean(a.b.RecyclerView_reverseLayout, false);
            bVar.d = obtainStyledAttributes.getBoolean(a.b.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return bVar;
        }

        void f(RecyclerView recyclerView) {
            d(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean N() {
            int y = y();
            for (int i = 0; i < y; i++) {
                ViewGroup.LayoutParams layoutParams = i(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class h {
        @Deprecated
        public void onDraw(Canvas canvas, RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView) {
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, t tVar) {
            onDraw(canvas, recyclerView);
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, t tVar) {
            onDrawOver(canvas, recyclerView);
        }

        @Deprecated
        public void getItemOffsets(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, t tVar) {
            getItemOffsets(rect, ((j) view.getLayoutParams()).f(), recyclerView);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class w {
        static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        static final int FLAG_BOUND = 1;
        static final int FLAG_IGNORE = 128;
        static final int FLAG_INVALID = 4;
        static final int FLAG_MOVED = 2048;
        static final int FLAG_NOT_RECYCLABLE = 16;
        static final int FLAG_REMOVED = 8;
        static final int FLAG_RETURNED_FROM_SCRAP = 32;
        static final int FLAG_SET_A11Y_ITEM_DELEGATE = 16384;
        static final int FLAG_TMP_DETACHED = 256;
        static final int FLAG_UPDATE = 2;
        private static final List<Object> FULLUPDATE_PAYLOADS = Collections.emptyList();
        static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
        public final View itemView;
        int mFlags;
        WeakReference<RecyclerView> mNestedRecyclerView;
        RecyclerView mOwnerRecyclerView;
        int mPosition = -1;
        int mOldPosition = -1;
        long mItemId = -1;
        int mItemViewType = -1;
        int mPreLayoutPosition = -1;
        w mShadowedHolder = null;
        w mShadowingHolder = null;
        List<Object> mPayloads = null;
        List<Object> mUnmodifiedPayloads = null;
        private int mIsRecyclableCount = 0;
        p mScrapContainer = null;
        boolean mInChangeScrap = false;
        private int mWasImportantForAccessibilityBeforeHidden = 0;
        int mPendingAccessibilityState = -1;

        public w(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.itemView = view;
        }

        void flagRemovedAndOffsetPosition(int i, int i2, boolean z) {
            addFlags(8);
            offsetPosition(i2, z);
            this.mPosition = i;
        }

        void offsetPosition(int i, boolean z) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z) {
                this.mPreLayoutPosition += i;
            }
            this.mPosition += i;
            if (this.itemView.getLayoutParams() != null) {
                ((j) this.itemView.getLayoutParams()).e = true;
            }
        }

        void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        void saveOldPosition() {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean shouldIgnore() {
            return (this.mFlags & 128) != 0;
        }

        @Deprecated
        public final int getPosition() {
            int i = this.mPreLayoutPosition;
            return i == -1 ? this.mPosition : i;
        }

        public final int getLayoutPosition() {
            int i = this.mPreLayoutPosition;
            return i == -1 ? this.mPosition : i;
        }

        public final int getAdapterPosition() {
            RecyclerView recyclerView = this.mOwnerRecyclerView;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.getAdapterPositionFor(this);
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        boolean isScrap() {
            return this.mScrapContainer != null;
        }

        void unScrap() {
            this.mScrapContainer.c(this);
        }

        boolean wasReturnedFromScrap() {
            return (this.mFlags & 32) != 0;
        }

        void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        void stopIgnoring() {
            this.mFlags &= -129;
        }

        void setScrapContainer(p pVar, boolean z) {
            this.mScrapContainer = pVar;
            this.mInChangeScrap = z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isInvalid() {
            return (this.mFlags & 4) != 0;
        }

        boolean needsUpdate() {
            return (this.mFlags & 2) != 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isBound() {
            return (this.mFlags & 1) != 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isRemoved() {
            return (this.mFlags & 8) != 0;
        }

        boolean hasAnyOfTheFlags(int i) {
            return (i & this.mFlags) != 0;
        }

        boolean isTmpDetached() {
            return (this.mFlags & 256) != 0;
        }

        boolean isAdapterPositionUnknown() {
            return (this.mFlags & 512) != 0 || isInvalid();
        }

        void setFlags(int i, int i2) {
            this.mFlags = (i & i2) | (this.mFlags & (i2 ^ (-1)));
        }

        void addFlags(int i) {
            this.mFlags = i | this.mFlags;
        }

        void addChangePayload(Object obj) {
            if (obj == null) {
                addFlags(1024);
            } else if ((1024 & this.mFlags) == 0) {
                createPayloadsIfNeeded();
                this.mPayloads.add(obj);
            }
        }

        private void createPayloadsIfNeeded() {
            if (this.mPayloads == null) {
                this.mPayloads = new ArrayList();
                this.mUnmodifiedPayloads = Collections.unmodifiableList(this.mPayloads);
            }
        }

        void clearPayload() {
            List<Object> list = this.mPayloads;
            if (list != null) {
                list.clear();
            }
            this.mFlags &= -1025;
        }

        List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & 1024) == 0) {
                List<Object> list = this.mPayloads;
                if (list == null || list.size() == 0) {
                    return FULLUPDATE_PAYLOADS;
                }
                return this.mUnmodifiedPayloads;
            }
            return FULLUPDATE_PAYLOADS;
        }

        void resetInternal() {
            this.mFlags = 0;
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1L;
            this.mPreLayoutPosition = -1;
            this.mIsRecyclableCount = 0;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            RecyclerView.clearNestedRecyclerViewIfNotNested(this);
        }

        void onEnteredHiddenState(RecyclerView recyclerView) {
            int i = this.mPendingAccessibilityState;
            if (i != -1) {
                this.mWasImportantForAccessibilityBeforeHidden = i;
            } else {
                this.mWasImportantForAccessibilityBeforeHidden = androidx.core.f.v.e(this.itemView);
            }
            recyclerView.setChildImportantForAccessibilityInternal(this, 4);
        }

        void onLeftHiddenState(RecyclerView recyclerView) {
            recyclerView.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
            if (isScrap()) {
                sb.append(" scrap ");
                sb.append(this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]");
            }
            if (isInvalid()) {
                sb.append(" invalid");
            }
            if (!isBound()) {
                sb.append(" unbound");
            }
            if (needsUpdate()) {
                sb.append(" update");
            }
            if (isRemoved()) {
                sb.append(" removed");
            }
            if (shouldIgnore()) {
                sb.append(" ignored");
            }
            if (isTmpDetached()) {
                sb.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                sb.append(" not recyclable(" + this.mIsRecyclableCount + ")");
            }
            if (isAdapterPositionUnknown()) {
                sb.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public final void setIsRecyclable(boolean z) {
            this.mIsRecyclableCount = z ? this.mIsRecyclableCount - 1 : this.mIsRecyclableCount + 1;
            int i = this.mIsRecyclableCount;
            if (i < 0) {
                this.mIsRecyclableCount = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!z && i == 1) {
                this.mFlags |= 16;
            } else if (z && this.mIsRecyclableCount == 0) {
                this.mFlags &= -17;
            }
        }

        public final boolean isRecyclable() {
            return (this.mFlags & 16) == 0 && !androidx.core.f.v.c(this.itemView);
        }

        boolean shouldBeKeptAsChild() {
            return (this.mFlags & 16) != 0;
        }

        boolean doesTransientStatePreventRecycling() {
            return (this.mFlags & 16) == 0 && androidx.core.f.v.c(this.itemView);
        }

        boolean isUpdated() {
            return (this.mFlags & 2) != 0;
        }
    }

    boolean setChildImportantForAccessibilityInternal(w wVar, int i2) {
        if (isComputingLayout()) {
            wVar.mPendingAccessibilityState = i2;
            this.mPendingAccessibilityImportanceChange.add(wVar);
            return false;
        }
        androidx.core.f.v.b(wVar.itemView, i2);
        return true;
    }

    void dispatchPendingImportantForAccessibilityChanges() {
        int i2;
        for (int size = this.mPendingAccessibilityImportanceChange.size() - 1; size >= 0; size--) {
            w wVar = this.mPendingAccessibilityImportanceChange.get(size);
            if (wVar.itemView.getParent() == this && !wVar.shouldIgnore() && (i2 = wVar.mPendingAccessibilityState) != -1) {
                androidx.core.f.v.b(wVar.itemView, i2);
                wVar.mPendingAccessibilityState = -1;
            }
        }
        this.mPendingAccessibilityImportanceChange.clear();
    }

    int getAdapterPositionFor(w wVar) {
        if (wVar.hasAnyOfTheFlags(524) || !wVar.isBound()) {
            return -1;
        }
        return this.mAdapterHelper.c(wVar.mPosition);
    }

    void initFastScroller(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + exceptionLabel());
        }
        Resources resources = getContext().getResources();
        new androidx.recyclerview.widget.d(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(a.C0064a.fastscroll_default_thickness), resources.getDimensionPixelSize(a.C0064a.fastscroll_minimum_range), resources.getDimensionPixelOffset(a.C0064a.fastscroll_margin));
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().a(z);
    }

    @Override // android.view.View, androidx.core.f.j
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().a();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().b(i2);
    }

    public boolean startNestedScroll(int i2, int i3) {
        return getScrollingChildHelper().a(i2, i3);
    }

    @Override // android.view.View, androidx.core.f.j
    public void stopNestedScroll() {
        getScrollingChildHelper().c();
    }

    @Override // androidx.core.f.k
    public void stopNestedScroll(int i2) {
        getScrollingChildHelper().c(i2);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().b();
    }

    public boolean hasNestedScrollingParent(int i2) {
        return getScrollingChildHelper().a(i2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().a(i2, i3, i4, i5, iArr);
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        return getScrollingChildHelper().a(i2, i3, i4, i5, iArr, i6);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().a(i2, i3, iArr, iArr2);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return getScrollingChildHelper().a(i2, i3, iArr, iArr2, i4);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return getScrollingChildHelper().a(f2, f3, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().a(f2, f3);
    }

    /* loaded from: classes.dex */
    public static class j extends ViewGroup.MarginLayoutParams {
        w c;
        final Rect d;
        boolean e;
        boolean f;

        public j(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.d = new Rect();
            this.e = true;
            this.f = false;
        }

        public j(int i, int i2) {
            super(i, i2);
            this.d = new Rect();
            this.e = true;
            this.f = false;
        }

        public j(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.d = new Rect();
            this.e = true;
            this.f = false;
        }

        public j(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.d = new Rect();
            this.e = true;
            this.f = false;
        }

        public j(j jVar) {
            super((ViewGroup.LayoutParams) jVar);
            this.d = new Rect();
            this.e = true;
            this.f = false;
        }

        public boolean c() {
            return this.c.isInvalid();
        }

        public boolean d() {
            return this.c.isRemoved();
        }

        public boolean e() {
            return this.c.isUpdated();
        }

        public int f() {
            return this.c.getLayoutPosition();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class c {
        public void onChanged() {
        }

        public void onItemRangeChanged(int i, int i2) {
        }

        public void onItemRangeInserted(int i, int i2) {
        }

        public void onItemRangeMoved(int i, int i2, int i3) {
        }

        public void onItemRangeRemoved(int i, int i2) {
        }

        public void onItemRangeChanged(int i, int i2, Object obj) {
            onItemRangeChanged(i, i2);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class s {
        private RecyclerView b;
        private i c;
        private boolean d;
        private boolean e;
        private View f;
        private boolean h;

        /* renamed from: a, reason: collision with root package name */
        private int f864a = -1;
        private final a g = new a(0, 0);

        /* loaded from: classes.dex */
        public interface b {
            PointF d(int i);
        }

        protected abstract void a();

        protected abstract void a(int i, int i2, t tVar, a aVar);

        protected abstract void a(View view, t tVar, a aVar);

        protected abstract void b();

        void a(RecyclerView recyclerView, i iVar) {
            if (this.h) {
                Log.w(RecyclerView.TAG, "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.b = recyclerView;
            this.c = iVar;
            if (this.f864a == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            this.b.mState.f866a = this.f864a;
            this.e = true;
            this.d = true;
            this.f = e(i());
            a();
            this.b.mViewFlinger.a();
            this.h = true;
        }

        public void c(int i) {
            this.f864a = i;
        }

        public PointF d(int i) {
            Object e = e();
            if (e instanceof b) {
                return ((b) e).d(i);
            }
            Log.w(RecyclerView.TAG, "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + b.class.getCanonicalName());
            return null;
        }

        public i e() {
            return this.c;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void f() {
            if (this.e) {
                this.e = false;
                b();
                this.b.mState.f866a = -1;
                this.f = null;
                this.f864a = -1;
                this.d = false;
                this.c.b(this);
                this.c = null;
                this.b = null;
            }
        }

        public boolean g() {
            return this.d;
        }

        public boolean h() {
            return this.e;
        }

        public int i() {
            return this.f864a;
        }

        void a(int i, int i2) {
            PointF d;
            RecyclerView recyclerView = this.b;
            if (!this.e || this.f864a == -1 || recyclerView == null) {
                f();
            }
            if (this.d && this.f == null && this.c != null && (d = d(this.f864a)) != null && (d.x != 0.0f || d.y != 0.0f)) {
                recyclerView.scrollStep((int) Math.signum(d.x), (int) Math.signum(d.y), null);
            }
            this.d = false;
            View view = this.f;
            if (view != null) {
                if (a(view) == this.f864a) {
                    a(this.f, recyclerView.mState, this.g);
                    this.g.a(recyclerView);
                    f();
                } else {
                    Log.e(RecyclerView.TAG, "Passed over target position while smooth scrolling.");
                    this.f = null;
                }
            }
            if (this.e) {
                a(i, i2, recyclerView.mState, this.g);
                boolean a2 = this.g.a();
                this.g.a(recyclerView);
                if (a2) {
                    if (this.e) {
                        this.d = true;
                        recyclerView.mViewFlinger.a();
                    } else {
                        f();
                    }
                }
            }
        }

        public int a(View view) {
            return this.b.getChildLayoutPosition(view);
        }

        public int j() {
            return this.b.mLayout.y();
        }

        public View e(int i) {
            return this.b.mLayout.c(i);
        }

        protected void b(View view) {
            if (a(view) == i()) {
                this.f = view;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void a(PointF pointF) {
            float sqrt = (float) Math.sqrt((pointF.x * pointF.x) + (pointF.y * pointF.y));
            pointF.x /= sqrt;
            pointF.y /= sqrt;
        }

        /* loaded from: classes.dex */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            private int f865a;
            private int b;
            private int c;
            private int d;
            private Interpolator e;
            private boolean f;
            private int g;

            public a(int i, int i2) {
                this(i, i2, BleSignal.UNKNOWN_TX_POWER, null);
            }

            public a(int i, int i2, int i3, Interpolator interpolator) {
                this.d = -1;
                this.f = false;
                this.g = 0;
                this.f865a = i;
                this.b = i2;
                this.c = i3;
                this.e = interpolator;
            }

            public void a(int i) {
                this.d = i;
            }

            boolean a() {
                return this.d >= 0;
            }

            void a(RecyclerView recyclerView) {
                int i = this.d;
                if (i >= 0) {
                    this.d = -1;
                    recyclerView.jumpToPositionForSmoothScroller(i);
                    this.f = false;
                } else {
                    if (this.f) {
                        b();
                        if (this.e == null) {
                            if (this.c == Integer.MIN_VALUE) {
                                recyclerView.mViewFlinger.b(this.f865a, this.b);
                            } else {
                                recyclerView.mViewFlinger.a(this.f865a, this.b, this.c);
                            }
                        } else {
                            recyclerView.mViewFlinger.a(this.f865a, this.b, this.c, this.e);
                        }
                        this.g++;
                        if (this.g > 10) {
                            Log.e(RecyclerView.TAG, "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                        }
                        this.f = false;
                        return;
                    }
                    this.g = 0;
                }
            }

            private void b() {
                if (this.e != null && this.c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            public void a(int i, int i2, int i3, Interpolator interpolator) {
                this.f865a = i;
                this.b = i2;
                this.c = i3;
                this.e = interpolator;
                this.f = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b extends Observable<c> {
        b() {
        }

        public boolean a() {
            return !this.mObservers.isEmpty();
        }

        public void b() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).onChanged();
            }
        }

        public void a(int i, int i2) {
            a(i, i2, null);
        }

        public void a(int i, int i2, Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).onItemRangeChanged(i, i2, obj);
            }
        }

        public void b(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).onItemRangeInserted(i, i2);
            }
        }

        public void c(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).onItemRangeRemoved(i, i2);
            }
        }

        public void d(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).onItemRangeMoved(i, i2, 1);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.recyclerview.widget.RecyclerView.SavedState.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a, reason: collision with root package name */
        Parcelable f852a;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f852a = parcel.readParcelable(classLoader == null ? i.class.getClassLoader() : classLoader);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.f852a, 0);
        }

        void a(SavedState savedState) {
            this.f852a = savedState.f852a;
        }
    }

    /* loaded from: classes.dex */
    public static class t {

        /* renamed from: a, reason: collision with root package name */
        int f866a = -1;
        int b = 0;
        int c = 0;
        int d = 1;
        int e = 0;
        boolean f = false;
        boolean g = false;
        boolean h = false;
        boolean i = false;
        boolean j = false;
        boolean k = false;
        int l;
        long m;
        int n;
        int o;
        int p;
        private SparseArray<Object> q;

        void a(int i) {
            if ((this.d & i) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.d));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(a aVar) {
            this.d = 1;
            this.e = aVar.getItemCount();
            this.g = false;
            this.h = false;
            this.i = false;
        }

        public boolean a() {
            return this.g;
        }

        public boolean b() {
            return this.k;
        }

        public int c() {
            return this.f866a;
        }

        public boolean d() {
            return this.f866a != -1;
        }

        public int e() {
            return this.g ? this.b - this.c : this.e;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f866a + ", mData=" + this.q + ", mItemCount=" + this.e + ", mIsMeasuring=" + this.i + ", mPreviousLayoutItemCount=" + this.b + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.c + ", mStructureChanged=" + this.f + ", mInPreLayout=" + this.g + ", mRunSimpleAnimations=" + this.j + ", mRunPredictiveAnimations=" + this.k + '}';
        }
    }

    /* loaded from: classes.dex */
    private class g implements f.b {
        g() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.f.b
        public void a(w wVar) {
            wVar.setIsRecyclable(true);
            if (wVar.mShadowedHolder != null && wVar.mShadowingHolder == null) {
                wVar.mShadowedHolder = null;
            }
            wVar.mShadowingHolder = null;
            if (wVar.shouldBeKeptAsChild() || RecyclerView.this.removeAnimatingView(wVar.itemView) || !wVar.isTmpDetached()) {
                return;
            }
            RecyclerView.this.removeDetachedView(wVar.itemView, false);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class f {

        /* renamed from: a, reason: collision with root package name */
        private b f853a = null;
        private ArrayList<a> b = new ArrayList<>();
        private long c = 120;
        private long d = 120;
        private long e = 250;
        private long f = 250;

        /* loaded from: classes.dex */
        public interface a {
            void a();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public interface b {
            void a(w wVar);
        }

        public abstract void a();

        public abstract boolean a(w wVar, c cVar, c cVar2);

        public abstract boolean a(w wVar, w wVar2, c cVar, c cVar2);

        public abstract boolean b();

        public abstract boolean b(w wVar, c cVar, c cVar2);

        public abstract boolean c(w wVar, c cVar, c cVar2);

        public abstract void d();

        public abstract void d(w wVar);

        public void g(w wVar) {
        }

        public boolean h(w wVar) {
            return true;
        }

        public long e() {
            return this.e;
        }

        public long f() {
            return this.c;
        }

        public long g() {
            return this.d;
        }

        public long h() {
            return this.f;
        }

        void a(b bVar) {
            this.f853a = bVar;
        }

        public c a(t tVar, w wVar, int i, List<Object> list) {
            return j().a(wVar);
        }

        public c a(t tVar, w wVar) {
            return j().a(wVar);
        }

        static int e(w wVar) {
            int i = wVar.mFlags & 14;
            if (wVar.isInvalid()) {
                return 4;
            }
            if ((i & 4) != 0) {
                return i;
            }
            int oldPosition = wVar.getOldPosition();
            int adapterPosition = wVar.getAdapterPosition();
            return (oldPosition == -1 || adapterPosition == -1 || oldPosition == adapterPosition) ? i : i | ProgressEvent.PART_COMPLETED_EVENT_CODE;
        }

        public final void f(w wVar) {
            g(wVar);
            b bVar = this.f853a;
            if (bVar != null) {
                bVar.a(wVar);
            }
        }

        public boolean a(w wVar, List<Object> list) {
            return h(wVar);
        }

        public final void i() {
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                this.b.get(i).a();
            }
            this.b.clear();
        }

        public c j() {
            return new c();
        }

        /* loaded from: classes.dex */
        public static class c {

            /* renamed from: a, reason: collision with root package name */
            public int f854a;
            public int b;
            public int c;
            public int d;

            public c a(w wVar) {
                return a(wVar, 0);
            }

            public c a(w wVar, int i) {
                View view = wVar.itemView;
                this.f854a = view.getLeft();
                this.b = view.getTop();
                this.c = view.getRight();
                this.d = view.getBottom();
                return this;
            }
        }
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        d dVar = this.mChildDrawingOrderCallback;
        if (dVar == null) {
            return super.getChildDrawingOrder(i2, i3);
        }
        return dVar.a(i2, i3);
    }

    private androidx.core.f.m getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new androidx.core.f.m(this);
        }
        return this.mScrollingChildHelper;
    }
}
