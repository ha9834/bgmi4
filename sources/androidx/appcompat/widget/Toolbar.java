package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.ActionMenuView;
import androidx.customview.view.AbsSavedState;
import com.google.android.gms.nearby.messages.BleSignal;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class Toolbar extends ViewGroup {
    private static final String TAG = "Toolbar";
    private m.a mActionMenuPresenterCallback;
    int mButtonGravity;
    ImageButton mCollapseButtonView;
    private CharSequence mCollapseDescription;
    private Drawable mCollapseIcon;
    private boolean mCollapsible;
    private int mContentInsetEndWithActions;
    private int mContentInsetStartWithNavigation;
    private am mContentInsets;
    private boolean mEatingHover;
    private boolean mEatingTouch;
    View mExpandedActionView;
    private a mExpandedMenuPresenter;
    private int mGravity;
    private final ArrayList<View> mHiddenViews;
    private ImageView mLogoView;
    private int mMaxButtonHeight;
    private g.a mMenuBuilderCallback;
    private ActionMenuView mMenuView;
    private final ActionMenuView.e mMenuViewItemClickListener;
    private ImageButton mNavButtonView;
    c mOnMenuItemClickListener;
    private ActionMenuPresenter mOuterActionMenuPresenter;
    private Context mPopupContext;
    private int mPopupTheme;
    private final Runnable mShowOverflowMenuRunnable;
    private CharSequence mSubtitleText;
    private int mSubtitleTextAppearance;
    private ColorStateList mSubtitleTextColor;
    private TextView mSubtitleTextView;
    private final int[] mTempMargins;
    private final ArrayList<View> mTempViews;
    private int mTitleMarginBottom;
    private int mTitleMarginEnd;
    private int mTitleMarginStart;
    private int mTitleMarginTop;
    private CharSequence mTitleText;
    private int mTitleTextAppearance;
    private ColorStateList mTitleTextColor;
    private TextView mTitleTextView;
    private av mWrapper;

    /* loaded from: classes.dex */
    public interface c {
        boolean a(MenuItem menuItem);
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0024a.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mGravity = 8388627;
        this.mTempViews = new ArrayList<>();
        this.mHiddenViews = new ArrayList<>();
        this.mTempMargins = new int[2];
        this.mMenuViewItemClickListener = new ActionMenuView.e() { // from class: androidx.appcompat.widget.Toolbar.1
            @Override // androidx.appcompat.widget.ActionMenuView.e
            public boolean a(MenuItem menuItem) {
                if (Toolbar.this.mOnMenuItemClickListener != null) {
                    return Toolbar.this.mOnMenuItemClickListener.a(menuItem);
                }
                return false;
            }
        };
        this.mShowOverflowMenuRunnable = new Runnable() { // from class: androidx.appcompat.widget.Toolbar.2
            @Override // java.lang.Runnable
            public void run() {
                Toolbar.this.showOverflowMenu();
            }
        };
        au a2 = au.a(getContext(), attributeSet, a.j.Toolbar, i, 0);
        this.mTitleTextAppearance = a2.g(a.j.Toolbar_titleTextAppearance, 0);
        this.mSubtitleTextAppearance = a2.g(a.j.Toolbar_subtitleTextAppearance, 0);
        this.mGravity = a2.c(a.j.Toolbar_android_gravity, this.mGravity);
        this.mButtonGravity = a2.c(a.j.Toolbar_buttonGravity, 48);
        int d = a2.d(a.j.Toolbar_titleMargin, 0);
        d = a2.g(a.j.Toolbar_titleMargins) ? a2.d(a.j.Toolbar_titleMargins, d) : d;
        this.mTitleMarginBottom = d;
        this.mTitleMarginTop = d;
        this.mTitleMarginEnd = d;
        this.mTitleMarginStart = d;
        int d2 = a2.d(a.j.Toolbar_titleMarginStart, -1);
        if (d2 >= 0) {
            this.mTitleMarginStart = d2;
        }
        int d3 = a2.d(a.j.Toolbar_titleMarginEnd, -1);
        if (d3 >= 0) {
            this.mTitleMarginEnd = d3;
        }
        int d4 = a2.d(a.j.Toolbar_titleMarginTop, -1);
        if (d4 >= 0) {
            this.mTitleMarginTop = d4;
        }
        int d5 = a2.d(a.j.Toolbar_titleMarginBottom, -1);
        if (d5 >= 0) {
            this.mTitleMarginBottom = d5;
        }
        this.mMaxButtonHeight = a2.e(a.j.Toolbar_maxButtonHeight, -1);
        int d6 = a2.d(a.j.Toolbar_contentInsetStart, BleSignal.UNKNOWN_TX_POWER);
        int d7 = a2.d(a.j.Toolbar_contentInsetEnd, BleSignal.UNKNOWN_TX_POWER);
        int e = a2.e(a.j.Toolbar_contentInsetLeft, 0);
        int e2 = a2.e(a.j.Toolbar_contentInsetRight, 0);
        ensureContentInsets();
        this.mContentInsets.b(e, e2);
        if (d6 != Integer.MIN_VALUE || d7 != Integer.MIN_VALUE) {
            this.mContentInsets.a(d6, d7);
        }
        this.mContentInsetStartWithNavigation = a2.d(a.j.Toolbar_contentInsetStartWithNavigation, BleSignal.UNKNOWN_TX_POWER);
        this.mContentInsetEndWithActions = a2.d(a.j.Toolbar_contentInsetEndWithActions, BleSignal.UNKNOWN_TX_POWER);
        this.mCollapseIcon = a2.a(a.j.Toolbar_collapseIcon);
        this.mCollapseDescription = a2.c(a.j.Toolbar_collapseContentDescription);
        CharSequence c2 = a2.c(a.j.Toolbar_title);
        if (!TextUtils.isEmpty(c2)) {
            setTitle(c2);
        }
        CharSequence c3 = a2.c(a.j.Toolbar_subtitle);
        if (!TextUtils.isEmpty(c3)) {
            setSubtitle(c3);
        }
        this.mPopupContext = getContext();
        setPopupTheme(a2.g(a.j.Toolbar_popupTheme, 0));
        Drawable a3 = a2.a(a.j.Toolbar_navigationIcon);
        if (a3 != null) {
            setNavigationIcon(a3);
        }
        CharSequence c4 = a2.c(a.j.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(c4)) {
            setNavigationContentDescription(c4);
        }
        Drawable a4 = a2.a(a.j.Toolbar_logo);
        if (a4 != null) {
            setLogo(a4);
        }
        CharSequence c5 = a2.c(a.j.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(c5)) {
            setLogoDescription(c5);
        }
        if (a2.g(a.j.Toolbar_titleTextColor)) {
            setTitleTextColor(a2.e(a.j.Toolbar_titleTextColor));
        }
        if (a2.g(a.j.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(a2.e(a.j.Toolbar_subtitleTextColor));
        }
        if (a2.g(a.j.Toolbar_menu)) {
            inflateMenu(a2.g(a.j.Toolbar_menu, 0));
        }
        a2.a();
    }

    public void setPopupTheme(int i) {
        if (this.mPopupTheme != i) {
            this.mPopupTheme = i;
            if (i == 0) {
                this.mPopupContext = getContext();
            } else {
                this.mPopupContext = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    public void setTitleMargin(int i, int i2, int i3, int i4) {
        this.mTitleMarginStart = i;
        this.mTitleMarginTop = i2;
        this.mTitleMarginEnd = i3;
        this.mTitleMarginBottom = i4;
        requestLayout();
    }

    public int getTitleMarginStart() {
        return this.mTitleMarginStart;
    }

    public void setTitleMarginStart(int i) {
        this.mTitleMarginStart = i;
        requestLayout();
    }

    public int getTitleMarginTop() {
        return this.mTitleMarginTop;
    }

    public void setTitleMarginTop(int i) {
        this.mTitleMarginTop = i;
        requestLayout();
    }

    public int getTitleMarginEnd() {
        return this.mTitleMarginEnd;
    }

    public void setTitleMarginEnd(int i) {
        this.mTitleMarginEnd = i;
        requestLayout();
    }

    public int getTitleMarginBottom() {
        return this.mTitleMarginBottom;
    }

    public void setTitleMarginBottom(int i) {
        this.mTitleMarginBottom = i;
        requestLayout();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        ensureContentInsets();
        this.mContentInsets.a(i == 1);
    }

    public void setLogo(int i) {
        setLogo(androidx.appcompat.a.a.a.b(getContext(), i));
    }

    public boolean canShowOverflowMenu() {
        ActionMenuView actionMenuView;
        return getVisibility() == 0 && (actionMenuView = this.mMenuView) != null && actionMenuView.a();
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuView actionMenuView = this.mMenuView;
        return actionMenuView != null && actionMenuView.g();
    }

    public boolean isOverflowMenuShowPending() {
        ActionMenuView actionMenuView = this.mMenuView;
        return actionMenuView != null && actionMenuView.h();
    }

    public boolean showOverflowMenu() {
        ActionMenuView actionMenuView = this.mMenuView;
        return actionMenuView != null && actionMenuView.e();
    }

    public boolean hideOverflowMenu() {
        ActionMenuView actionMenuView = this.mMenuView;
        return actionMenuView != null && actionMenuView.f();
    }

    public void setMenu(androidx.appcompat.view.menu.g gVar, ActionMenuPresenter actionMenuPresenter) {
        if (gVar == null && this.mMenuView == null) {
            return;
        }
        ensureMenuView();
        androidx.appcompat.view.menu.g d = this.mMenuView.d();
        if (d == gVar) {
            return;
        }
        if (d != null) {
            d.b(this.mOuterActionMenuPresenter);
            d.b(this.mExpandedMenuPresenter);
        }
        if (this.mExpandedMenuPresenter == null) {
            this.mExpandedMenuPresenter = new a();
        }
        actionMenuPresenter.c(true);
        if (gVar != null) {
            gVar.a(actionMenuPresenter, this.mPopupContext);
            gVar.a(this.mExpandedMenuPresenter, this.mPopupContext);
        } else {
            actionMenuPresenter.a(this.mPopupContext, (androidx.appcompat.view.menu.g) null);
            this.mExpandedMenuPresenter.a(this.mPopupContext, (androidx.appcompat.view.menu.g) null);
            actionMenuPresenter.a(true);
            this.mExpandedMenuPresenter.a(true);
        }
        this.mMenuView.setPopupTheme(this.mPopupTheme);
        this.mMenuView.setPresenter(actionMenuPresenter);
        this.mOuterActionMenuPresenter = actionMenuPresenter;
    }

    public void dismissPopupMenus() {
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null) {
            actionMenuView.i();
        }
    }

    public boolean isTitleTruncated() {
        Layout layout;
        TextView textView = this.mTitleTextView;
        if (textView == null || (layout = textView.getLayout()) == null) {
            return false;
        }
        int lineCount = layout.getLineCount();
        for (int i = 0; i < lineCount; i++) {
            if (layout.getEllipsisCount(i) > 0) {
                return true;
            }
        }
        return false;
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            ensureLogoView();
            if (!isChildOrHidden(this.mLogoView)) {
                addSystemView(this.mLogoView, true);
            }
        } else {
            ImageView imageView = this.mLogoView;
            if (imageView != null && isChildOrHidden(imageView)) {
                removeView(this.mLogoView);
                this.mHiddenViews.remove(this.mLogoView);
            }
        }
        ImageView imageView2 = this.mLogoView;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public Drawable getLogo() {
        ImageView imageView = this.mLogoView;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ensureLogoView();
        }
        ImageView imageView = this.mLogoView;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.mLogoView;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    private void ensureLogoView() {
        if (this.mLogoView == null) {
            this.mLogoView = new AppCompatImageView(getContext());
        }
    }

    public boolean hasExpandedActionView() {
        a aVar = this.mExpandedMenuPresenter;
        return (aVar == null || aVar.b == null) ? false : true;
    }

    public void collapseActionView() {
        a aVar = this.mExpandedMenuPresenter;
        androidx.appcompat.view.menu.i iVar = aVar == null ? null : aVar.b;
        if (iVar != null) {
            iVar.collapseActionView();
        }
    }

    public CharSequence getTitle() {
        return this.mTitleText;
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.mTitleTextView == null) {
                Context context = getContext();
                this.mTitleTextView = new x(context);
                this.mTitleTextView.setSingleLine();
                this.mTitleTextView.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.mTitleTextAppearance;
                if (i != 0) {
                    this.mTitleTextView.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.mTitleTextColor;
                if (colorStateList != null) {
                    this.mTitleTextView.setTextColor(colorStateList);
                }
            }
            if (!isChildOrHidden(this.mTitleTextView)) {
                addSystemView(this.mTitleTextView, true);
            }
        } else {
            TextView textView = this.mTitleTextView;
            if (textView != null && isChildOrHidden(textView)) {
                removeView(this.mTitleTextView);
                this.mHiddenViews.remove(this.mTitleTextView);
            }
        }
        TextView textView2 = this.mTitleTextView;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.mTitleText = charSequence;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitleText;
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.mSubtitleTextView == null) {
                Context context = getContext();
                this.mSubtitleTextView = new x(context);
                this.mSubtitleTextView.setSingleLine();
                this.mSubtitleTextView.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.mSubtitleTextAppearance;
                if (i != 0) {
                    this.mSubtitleTextView.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.mSubtitleTextColor;
                if (colorStateList != null) {
                    this.mSubtitleTextView.setTextColor(colorStateList);
                }
            }
            if (!isChildOrHidden(this.mSubtitleTextView)) {
                addSystemView(this.mSubtitleTextView, true);
            }
        } else {
            TextView textView = this.mSubtitleTextView;
            if (textView != null && isChildOrHidden(textView)) {
                removeView(this.mSubtitleTextView);
                this.mHiddenViews.remove(this.mSubtitleTextView);
            }
        }
        TextView textView2 = this.mSubtitleTextView;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.mSubtitleText = charSequence;
    }

    public void setTitleTextAppearance(Context context, int i) {
        this.mTitleTextAppearance = i;
        TextView textView = this.mTitleTextView;
        if (textView != null) {
            textView.setTextAppearance(context, i);
        }
    }

    public void setSubtitleTextAppearance(Context context, int i) {
        this.mSubtitleTextAppearance = i;
        TextView textView = this.mSubtitleTextView;
        if (textView != null) {
            textView.setTextAppearance(context, i);
        }
    }

    public void setTitleTextColor(int i) {
        setTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.mTitleTextColor = colorStateList;
        TextView textView = this.mTitleTextView;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setSubtitleTextColor(int i) {
        setSubtitleTextColor(ColorStateList.valueOf(i));
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.mSubtitleTextColor = colorStateList;
        TextView textView = this.mSubtitleTextView;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.mNavButtonView;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ensureNavButtonView();
        }
        ImageButton imageButton = this.mNavButtonView;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(androidx.appcompat.a.a.a.b(getContext(), i));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            ensureNavButtonView();
            if (!isChildOrHidden(this.mNavButtonView)) {
                addSystemView(this.mNavButtonView, true);
            }
        } else {
            ImageButton imageButton = this.mNavButtonView;
            if (imageButton != null && isChildOrHidden(imageButton)) {
                removeView(this.mNavButtonView);
                this.mHiddenViews.remove(this.mNavButtonView);
            }
        }
        ImageButton imageButton2 = this.mNavButtonView;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.mNavButtonView;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        ensureNavButtonView();
        this.mNavButtonView.setOnClickListener(onClickListener);
    }

    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.mCollapseButtonView;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public void setCollapseContentDescription(int i) {
        setCollapseContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ensureCollapseButtonView();
        }
        ImageButton imageButton = this.mCollapseButtonView;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.mCollapseButtonView;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public void setCollapseIcon(int i) {
        setCollapseIcon(androidx.appcompat.a.a.a.b(getContext(), i));
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            ensureCollapseButtonView();
            this.mCollapseButtonView.setImageDrawable(drawable);
        } else {
            ImageButton imageButton = this.mCollapseButtonView;
            if (imageButton != null) {
                imageButton.setImageDrawable(this.mCollapseIcon);
            }
        }
    }

    public Menu getMenu() {
        ensureMenu();
        return this.mMenuView.getMenu();
    }

    public void setOverflowIcon(Drawable drawable) {
        ensureMenu();
        this.mMenuView.setOverflowIcon(drawable);
    }

    public Drawable getOverflowIcon() {
        ensureMenu();
        return this.mMenuView.getOverflowIcon();
    }

    private void ensureMenu() {
        ensureMenuView();
        if (this.mMenuView.d() == null) {
            androidx.appcompat.view.menu.g gVar = (androidx.appcompat.view.menu.g) this.mMenuView.getMenu();
            if (this.mExpandedMenuPresenter == null) {
                this.mExpandedMenuPresenter = new a();
            }
            this.mMenuView.setExpandedActionViewsExclusive(true);
            gVar.a(this.mExpandedMenuPresenter, this.mPopupContext);
        }
    }

    private void ensureMenuView() {
        if (this.mMenuView == null) {
            this.mMenuView = new ActionMenuView(getContext());
            this.mMenuView.setPopupTheme(this.mPopupTheme);
            this.mMenuView.setOnMenuItemClickListener(this.mMenuViewItemClickListener);
            this.mMenuView.a(this.mActionMenuPresenterCallback, this.mMenuBuilderCallback);
            b generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f175a = 8388613 | (this.mButtonGravity & 112);
            this.mMenuView.setLayoutParams(generateDefaultLayoutParams);
            addSystemView(this.mMenuView, false);
        }
    }

    private MenuInflater getMenuInflater() {
        return new androidx.appcompat.view.g(getContext());
    }

    public void inflateMenu(int i) {
        getMenuInflater().inflate(i, getMenu());
    }

    public void setOnMenuItemClickListener(c cVar) {
        this.mOnMenuItemClickListener = cVar;
    }

    public void setContentInsetsRelative(int i, int i2) {
        ensureContentInsets();
        this.mContentInsets.a(i, i2);
    }

    public int getContentInsetStart() {
        am amVar = this.mContentInsets;
        if (amVar != null) {
            return amVar.c();
        }
        return 0;
    }

    public int getContentInsetEnd() {
        am amVar = this.mContentInsets;
        if (amVar != null) {
            return amVar.d();
        }
        return 0;
    }

    public void setContentInsetsAbsolute(int i, int i2) {
        ensureContentInsets();
        this.mContentInsets.b(i, i2);
    }

    public int getContentInsetLeft() {
        am amVar = this.mContentInsets;
        if (amVar != null) {
            return amVar.a();
        }
        return 0;
    }

    public int getContentInsetRight() {
        am amVar = this.mContentInsets;
        if (amVar != null) {
            return amVar.b();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i = this.mContentInsetStartWithNavigation;
        return i != Integer.MIN_VALUE ? i : getContentInsetStart();
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = BleSignal.UNKNOWN_TX_POWER;
        }
        if (i != this.mContentInsetStartWithNavigation) {
            this.mContentInsetStartWithNavigation = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public int getContentInsetEndWithActions() {
        int i = this.mContentInsetEndWithActions;
        return i != Integer.MIN_VALUE ? i : getContentInsetEnd();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = BleSignal.UNKNOWN_TX_POWER;
        }
        if (i != this.mContentInsetEndWithActions) {
            this.mContentInsetEndWithActions = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() != null) {
            return Math.max(getContentInsetStart(), Math.max(this.mContentInsetStartWithNavigation, 0));
        }
        return getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        boolean z;
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null) {
            androidx.appcompat.view.menu.g d = actionMenuView.d();
            z = d != null && d.hasVisibleItems();
        } else {
            z = false;
        }
        if (z) {
            return Math.max(getContentInsetEnd(), Math.max(this.mContentInsetEndWithActions, 0));
        }
        return getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        if (androidx.core.f.v.f(this) == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (androidx.core.f.v.f(this) == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    private void ensureNavButtonView() {
        if (this.mNavButtonView == null) {
            this.mNavButtonView = new m(getContext(), null, a.C0024a.toolbarNavigationButtonStyle);
            b generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f175a = 8388611 | (this.mButtonGravity & 112);
            this.mNavButtonView.setLayoutParams(generateDefaultLayoutParams);
        }
    }

    void ensureCollapseButtonView() {
        if (this.mCollapseButtonView == null) {
            this.mCollapseButtonView = new m(getContext(), null, a.C0024a.toolbarNavigationButtonStyle);
            this.mCollapseButtonView.setImageDrawable(this.mCollapseIcon);
            this.mCollapseButtonView.setContentDescription(this.mCollapseDescription);
            b generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f175a = 8388611 | (this.mButtonGravity & 112);
            generateDefaultLayoutParams.b = 2;
            this.mCollapseButtonView.setLayoutParams(generateDefaultLayoutParams);
            this.mCollapseButtonView.setOnClickListener(new View.OnClickListener() { // from class: androidx.appcompat.widget.Toolbar.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Toolbar.this.collapseActionView();
                }
            });
        }
    }

    private void addSystemView(View view, boolean z) {
        b bVar;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            bVar = generateDefaultLayoutParams();
        } else if (!checkLayoutParams(layoutParams)) {
            bVar = generateLayoutParams(layoutParams);
        } else {
            bVar = (b) layoutParams;
        }
        bVar.b = 1;
        if (z && this.mExpandedActionView != null) {
            view.setLayoutParams(bVar);
            this.mHiddenViews.add(view);
        } else {
            addView(view, bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        a aVar = this.mExpandedMenuPresenter;
        if (aVar != null && aVar.b != null) {
            savedState.f303a = this.mExpandedMenuPresenter.b.getItemId();
        }
        savedState.b = isOverflowMenuShowing();
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        ActionMenuView actionMenuView = this.mMenuView;
        androidx.appcompat.view.menu.g d = actionMenuView != null ? actionMenuView.d() : null;
        if (savedState.f303a != 0 && this.mExpandedMenuPresenter != null && d != null && (findItem = d.findItem(savedState.f303a)) != null) {
            findItem.expandActionView();
        }
        if (savedState.b) {
            postShowOverflowMenu();
        }
    }

    private void postShowOverflowMenu() {
        removeCallbacks(this.mShowOverflowMenuRunnable);
        post(this.mShowOverflowMenuRunnable);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.mShowOverflowMenuRunnable);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mEatingTouch = false;
        }
        if (!this.mEatingTouch) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.mEatingTouch = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.mEatingTouch = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.mEatingHover = false;
        }
        if (!this.mEatingHover) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.mEatingHover = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.mEatingHover = false;
        }
        return true;
    }

    private void measureChildConstrained(View view, int i, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private int measureChildCollapseMargins(View view, int i, int i2, int i3, int i4, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + max + i2, marginLayoutParams.width), getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private boolean shouldCollapse() {
        if (!this.mCollapsible) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (shouldLayout(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        char c2;
        char c3;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int[] iArr = this.mTempMargins;
        if (ba.a(this)) {
            c2 = 1;
            c3 = 0;
        } else {
            c2 = 0;
            c3 = 1;
        }
        if (shouldLayout(this.mNavButtonView)) {
            measureChildConstrained(this.mNavButtonView, i, 0, i2, 0, this.mMaxButtonHeight);
            i3 = this.mNavButtonView.getMeasuredWidth() + getHorizontalMargins(this.mNavButtonView);
            i4 = Math.max(0, this.mNavButtonView.getMeasuredHeight() + getVerticalMargins(this.mNavButtonView));
            i5 = View.combineMeasuredStates(0, this.mNavButtonView.getMeasuredState());
        } else {
            i3 = 0;
            i4 = 0;
            i5 = 0;
        }
        if (shouldLayout(this.mCollapseButtonView)) {
            measureChildConstrained(this.mCollapseButtonView, i, 0, i2, 0, this.mMaxButtonHeight);
            i3 = this.mCollapseButtonView.getMeasuredWidth() + getHorizontalMargins(this.mCollapseButtonView);
            i4 = Math.max(i4, this.mCollapseButtonView.getMeasuredHeight() + getVerticalMargins(this.mCollapseButtonView));
            i5 = View.combineMeasuredStates(i5, this.mCollapseButtonView.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = 0 + Math.max(currentContentInsetStart, i3);
        iArr[c2] = Math.max(0, currentContentInsetStart - i3);
        if (shouldLayout(this.mMenuView)) {
            measureChildConstrained(this.mMenuView, i, max, i2, 0, this.mMaxButtonHeight);
            i6 = this.mMenuView.getMeasuredWidth() + getHorizontalMargins(this.mMenuView);
            i4 = Math.max(i4, this.mMenuView.getMeasuredHeight() + getVerticalMargins(this.mMenuView));
            i5 = View.combineMeasuredStates(i5, this.mMenuView.getMeasuredState());
        } else {
            i6 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max2 = max + Math.max(currentContentInsetEnd, i6);
        iArr[c3] = Math.max(0, currentContentInsetEnd - i6);
        if (shouldLayout(this.mExpandedActionView)) {
            max2 += measureChildCollapseMargins(this.mExpandedActionView, i, max2, i2, 0, iArr);
            i4 = Math.max(i4, this.mExpandedActionView.getMeasuredHeight() + getVerticalMargins(this.mExpandedActionView));
            i5 = View.combineMeasuredStates(i5, this.mExpandedActionView.getMeasuredState());
        }
        if (shouldLayout(this.mLogoView)) {
            max2 += measureChildCollapseMargins(this.mLogoView, i, max2, i2, 0, iArr);
            i4 = Math.max(i4, this.mLogoView.getMeasuredHeight() + getVerticalMargins(this.mLogoView));
            i5 = View.combineMeasuredStates(i5, this.mLogoView.getMeasuredState());
        }
        int childCount = getChildCount();
        int i10 = i4;
        int i11 = max2;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (((b) childAt.getLayoutParams()).b == 0 && shouldLayout(childAt)) {
                i11 += measureChildCollapseMargins(childAt, i, i11, i2, 0, iArr);
                i10 = Math.max(i10, childAt.getMeasuredHeight() + getVerticalMargins(childAt));
                i5 = View.combineMeasuredStates(i5, childAt.getMeasuredState());
            }
        }
        int i13 = this.mTitleMarginTop + this.mTitleMarginBottom;
        int i14 = this.mTitleMarginStart + this.mTitleMarginEnd;
        if (shouldLayout(this.mTitleTextView)) {
            measureChildCollapseMargins(this.mTitleTextView, i, i11 + i14, i2, i13, iArr);
            int measuredWidth = this.mTitleTextView.getMeasuredWidth() + getHorizontalMargins(this.mTitleTextView);
            i9 = this.mTitleTextView.getMeasuredHeight() + getVerticalMargins(this.mTitleTextView);
            i7 = View.combineMeasuredStates(i5, this.mTitleTextView.getMeasuredState());
            i8 = measuredWidth;
        } else {
            i7 = i5;
            i8 = 0;
            i9 = 0;
        }
        if (shouldLayout(this.mSubtitleTextView)) {
            i8 = Math.max(i8, measureChildCollapseMargins(this.mSubtitleTextView, i, i11 + i14, i2, i9 + i13, iArr));
            i9 += this.mSubtitleTextView.getMeasuredHeight() + getVerticalMargins(this.mSubtitleTextView);
            i7 = View.combineMeasuredStates(i7, this.mSubtitleTextView.getMeasuredState());
        }
        int max3 = Math.max(i10, i9);
        int paddingLeft = i11 + i8 + getPaddingLeft() + getPaddingRight();
        int paddingTop = max3 + getPaddingTop() + getPaddingBottom();
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, (-16777216) & i7);
        int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, i7 << 16);
        if (shouldCollapse()) {
            resolveSizeAndState2 = 0;
        }
        setMeasuredDimension(resolveSizeAndState, resolveSizeAndState2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z2;
        int i11;
        int i12;
        int paddingTop;
        int i13;
        int i14;
        int i15;
        char c2;
        int i16;
        int i17;
        int i18;
        boolean z3 = androidx.core.f.v.f(this) == 1;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop2 = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i19 = width - paddingRight;
        int[] iArr = this.mTempMargins;
        iArr[1] = 0;
        iArr[0] = 0;
        int k = androidx.core.f.v.k(this);
        int min = k >= 0 ? Math.min(k, i4 - i2) : 0;
        if (!shouldLayout(this.mNavButtonView)) {
            i5 = paddingLeft;
            i6 = i19;
        } else if (z3) {
            i6 = layoutChildRight(this.mNavButtonView, i19, iArr, min);
            i5 = paddingLeft;
        } else {
            i5 = layoutChildLeft(this.mNavButtonView, paddingLeft, iArr, min);
            i6 = i19;
        }
        if (shouldLayout(this.mCollapseButtonView)) {
            if (z3) {
                i6 = layoutChildRight(this.mCollapseButtonView, i6, iArr, min);
            } else {
                i5 = layoutChildLeft(this.mCollapseButtonView, i5, iArr, min);
            }
        }
        if (shouldLayout(this.mMenuView)) {
            if (z3) {
                i5 = layoutChildLeft(this.mMenuView, i5, iArr, min);
            } else {
                i6 = layoutChildRight(this.mMenuView, i6, iArr, min);
            }
        }
        int currentContentInsetLeft = getCurrentContentInsetLeft();
        int currentContentInsetRight = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, currentContentInsetLeft - i5);
        iArr[1] = Math.max(0, currentContentInsetRight - (i19 - i6));
        int max = Math.max(i5, currentContentInsetLeft);
        int min2 = Math.min(i6, i19 - currentContentInsetRight);
        if (shouldLayout(this.mExpandedActionView)) {
            if (z3) {
                min2 = layoutChildRight(this.mExpandedActionView, min2, iArr, min);
            } else {
                max = layoutChildLeft(this.mExpandedActionView, max, iArr, min);
            }
        }
        if (shouldLayout(this.mLogoView)) {
            if (z3) {
                min2 = layoutChildRight(this.mLogoView, min2, iArr, min);
            } else {
                max = layoutChildLeft(this.mLogoView, max, iArr, min);
            }
        }
        boolean shouldLayout = shouldLayout(this.mTitleTextView);
        boolean shouldLayout2 = shouldLayout(this.mSubtitleTextView);
        if (shouldLayout) {
            b bVar = (b) this.mTitleTextView.getLayoutParams();
            i7 = paddingRight;
            i8 = bVar.topMargin + this.mTitleTextView.getMeasuredHeight() + bVar.bottomMargin + 0;
        } else {
            i7 = paddingRight;
            i8 = 0;
        }
        if (shouldLayout2) {
            b bVar2 = (b) this.mSubtitleTextView.getLayoutParams();
            i9 = width;
            i8 += bVar2.topMargin + this.mSubtitleTextView.getMeasuredHeight() + bVar2.bottomMargin;
        } else {
            i9 = width;
        }
        if (shouldLayout || shouldLayout2) {
            TextView textView = shouldLayout ? this.mTitleTextView : this.mSubtitleTextView;
            TextView textView2 = shouldLayout2 ? this.mSubtitleTextView : this.mTitleTextView;
            b bVar3 = (b) textView.getLayoutParams();
            b bVar4 = (b) textView2.getLayoutParams();
            if ((!shouldLayout || this.mTitleTextView.getMeasuredWidth() <= 0) && (!shouldLayout2 || this.mSubtitleTextView.getMeasuredWidth() <= 0)) {
                i10 = paddingLeft;
                z2 = false;
            } else {
                i10 = paddingLeft;
                z2 = true;
            }
            int i20 = this.mGravity & 112;
            i11 = min;
            if (i20 == 48) {
                i12 = max;
                paddingTop = getPaddingTop() + bVar3.topMargin + this.mTitleMarginTop;
            } else if (i20 != 80) {
                int i21 = (((height - paddingTop2) - paddingBottom) - i8) / 2;
                i12 = max;
                if (i21 < bVar3.topMargin + this.mTitleMarginTop) {
                    i21 = bVar3.topMargin + this.mTitleMarginTop;
                } else {
                    int i22 = (((height - paddingBottom) - i8) - i21) - paddingTop2;
                    if (i22 < bVar3.bottomMargin + this.mTitleMarginBottom) {
                        i21 = Math.max(0, i21 - ((bVar4.bottomMargin + this.mTitleMarginBottom) - i22));
                    }
                }
                paddingTop = paddingTop2 + i21;
            } else {
                i12 = max;
                paddingTop = (((height - paddingBottom) - bVar4.bottomMargin) - this.mTitleMarginBottom) - i8;
            }
            if (z3) {
                if (z2) {
                    i16 = this.mTitleMarginStart;
                    c2 = 1;
                } else {
                    c2 = 1;
                    i16 = 0;
                }
                int i23 = i16 - iArr[c2];
                min2 -= Math.max(0, i23);
                iArr[c2] = Math.max(0, -i23);
                if (shouldLayout) {
                    b bVar5 = (b) this.mTitleTextView.getLayoutParams();
                    int measuredWidth = min2 - this.mTitleTextView.getMeasuredWidth();
                    int measuredHeight = this.mTitleTextView.getMeasuredHeight() + paddingTop;
                    this.mTitleTextView.layout(measuredWidth, paddingTop, min2, measuredHeight);
                    i17 = measuredWidth - this.mTitleMarginEnd;
                    paddingTop = measuredHeight + bVar5.bottomMargin;
                } else {
                    i17 = min2;
                }
                if (shouldLayout2) {
                    b bVar6 = (b) this.mSubtitleTextView.getLayoutParams();
                    int i24 = paddingTop + bVar6.topMargin;
                    this.mSubtitleTextView.layout(min2 - this.mSubtitleTextView.getMeasuredWidth(), i24, min2, this.mSubtitleTextView.getMeasuredHeight() + i24);
                    i18 = min2 - this.mTitleMarginEnd;
                    int i25 = bVar6.bottomMargin;
                } else {
                    i18 = min2;
                }
                if (z2) {
                    min2 = Math.min(i17, i18);
                }
                max = i12;
                i13 = 0;
            } else {
                i13 = 0;
                int i26 = (z2 ? this.mTitleMarginStart : 0) - iArr[0];
                max = i12 + Math.max(0, i26);
                iArr[0] = Math.max(0, -i26);
                if (shouldLayout) {
                    b bVar7 = (b) this.mTitleTextView.getLayoutParams();
                    int measuredWidth2 = this.mTitleTextView.getMeasuredWidth() + max;
                    int measuredHeight2 = this.mTitleTextView.getMeasuredHeight() + paddingTop;
                    this.mTitleTextView.layout(max, paddingTop, measuredWidth2, measuredHeight2);
                    i14 = measuredWidth2 + this.mTitleMarginEnd;
                    paddingTop = measuredHeight2 + bVar7.bottomMargin;
                } else {
                    i14 = max;
                }
                if (shouldLayout2) {
                    b bVar8 = (b) this.mSubtitleTextView.getLayoutParams();
                    int i27 = paddingTop + bVar8.topMargin;
                    int measuredWidth3 = this.mSubtitleTextView.getMeasuredWidth() + max;
                    this.mSubtitleTextView.layout(max, i27, measuredWidth3, this.mSubtitleTextView.getMeasuredHeight() + i27);
                    i15 = measuredWidth3 + this.mTitleMarginEnd;
                    int i28 = bVar8.bottomMargin;
                } else {
                    i15 = max;
                }
                if (z2) {
                    max = Math.max(i14, i15);
                }
            }
        } else {
            i10 = paddingLeft;
            i11 = min;
            i13 = 0;
        }
        addCustomViewsWithGravity(this.mTempViews, 3);
        int size = this.mTempViews.size();
        int i29 = max;
        for (int i30 = 0; i30 < size; i30++) {
            i29 = layoutChildLeft(this.mTempViews.get(i30), i29, iArr, i11);
        }
        int i31 = i11;
        addCustomViewsWithGravity(this.mTempViews, 5);
        int size2 = this.mTempViews.size();
        for (int i32 = 0; i32 < size2; i32++) {
            min2 = layoutChildRight(this.mTempViews.get(i32), min2, iArr, i31);
        }
        addCustomViewsWithGravity(this.mTempViews, 1);
        int viewListMeasuredWidth = getViewListMeasuredWidth(this.mTempViews, iArr);
        int i33 = (i10 + (((i9 - i10) - i7) / 2)) - (viewListMeasuredWidth / 2);
        int i34 = viewListMeasuredWidth + i33;
        if (i33 >= i29) {
            i29 = i34 > min2 ? i33 - (i34 - min2) : i33;
        }
        int size3 = this.mTempViews.size();
        while (i13 < size3) {
            i29 = layoutChildLeft(this.mTempViews.get(i13), i29, iArr, i31);
            i13++;
        }
        this.mTempViews.clear();
    }

    private int getViewListMeasuredWidth(List<View> list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = i2;
        int i4 = i;
        int i5 = 0;
        int i6 = 0;
        while (i5 < size) {
            View view = list.get(i5);
            b bVar = (b) view.getLayoutParams();
            int i7 = bVar.leftMargin - i4;
            int i8 = bVar.rightMargin - i3;
            int max = Math.max(0, i7);
            int max2 = Math.max(0, i8);
            int max3 = Math.max(0, -i7);
            int max4 = Math.max(0, -i8);
            i6 += max + view.getMeasuredWidth() + max2;
            i5++;
            i3 = max4;
            i4 = max3;
        }
        return i6;
    }

    private int layoutChildLeft(View view, int i, int[] iArr, int i2) {
        b bVar = (b) view.getLayoutParams();
        int i3 = bVar.leftMargin - iArr[0];
        int max = i + Math.max(0, i3);
        iArr[0] = Math.max(0, -i3);
        int childTop = getChildTop(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, childTop, max + measuredWidth, view.getMeasuredHeight() + childTop);
        return max + measuredWidth + bVar.rightMargin;
    }

    private int layoutChildRight(View view, int i, int[] iArr, int i2) {
        b bVar = (b) view.getLayoutParams();
        int i3 = bVar.rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        int childTop = getChildTop(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, childTop, max, view.getMeasuredHeight() + childTop);
        return max - (measuredWidth + bVar.leftMargin);
    }

    private int getChildTop(View view, int i) {
        b bVar = (b) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        int childVerticalGravity = getChildVerticalGravity(bVar.f175a);
        if (childVerticalGravity == 48) {
            return getPaddingTop() - i2;
        }
        if (childVerticalGravity == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - bVar.bottomMargin) - i2;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int i3 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        if (i3 < bVar.topMargin) {
            i3 = bVar.topMargin;
        } else {
            int i4 = (((height - paddingBottom) - measuredHeight) - i3) - paddingTop;
            if (i4 < bVar.bottomMargin) {
                i3 = Math.max(0, i3 - (bVar.bottomMargin - i4));
            }
        }
        return paddingTop + i3;
    }

    private int getChildVerticalGravity(int i) {
        int i2 = i & 112;
        return (i2 == 16 || i2 == 48 || i2 == 80) ? i2 : this.mGravity & 112;
    }

    private void addCustomViewsWithGravity(List<View> list, int i) {
        boolean z = androidx.core.f.v.f(this) == 1;
        int childCount = getChildCount();
        int a2 = androidx.core.f.d.a(i, androidx.core.f.v.f(this));
        list.clear();
        if (!z) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                b bVar = (b) childAt.getLayoutParams();
                if (bVar.b == 0 && shouldLayout(childAt) && getChildHorizontalGravity(bVar.f175a) == a2) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i3 = childCount - 1; i3 >= 0; i3--) {
            View childAt2 = getChildAt(i3);
            b bVar2 = (b) childAt2.getLayoutParams();
            if (bVar2.b == 0 && shouldLayout(childAt2) && getChildHorizontalGravity(bVar2.f175a) == a2) {
                list.add(childAt2);
            }
        }
    }

    private int getChildHorizontalGravity(int i) {
        int f = androidx.core.f.v.f(this);
        int a2 = androidx.core.f.d.a(i, f) & 7;
        return (a2 == 1 || a2 == 3 || a2 == 5) ? a2 : f == 1 ? 5 : 3;
    }

    private boolean shouldLayout(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private int getHorizontalMargins(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return androidx.core.f.g.a(marginLayoutParams) + androidx.core.f.g.b(marginLayoutParams);
    }

    private int getVerticalMargins(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    @Override // android.view.ViewGroup
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public b generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof b) {
            return new b((b) layoutParams);
        }
        if (layoutParams instanceof a.C0027a) {
            return new b((a.C0027a) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new b((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new b(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public b generateDefaultLayoutParams() {
        return new b(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof b);
    }

    private static boolean isCustomView(View view) {
        return ((b) view.getLayoutParams()).b == 0;
    }

    public ab getWrapper() {
        if (this.mWrapper == null) {
            this.mWrapper = new av(this, true);
        }
        return this.mWrapper;
    }

    void removeChildrenForExpandedActionView() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((b) childAt.getLayoutParams()).b != 2 && childAt != this.mMenuView) {
                removeViewAt(childCount);
                this.mHiddenViews.add(childAt);
            }
        }
    }

    void addChildrenForExpandedActionView() {
        for (int size = this.mHiddenViews.size() - 1; size >= 0; size--) {
            addView(this.mHiddenViews.get(size));
        }
        this.mHiddenViews.clear();
    }

    private boolean isChildOrHidden(View view) {
        return view.getParent() == this || this.mHiddenViews.contains(view);
    }

    public void setCollapsible(boolean z) {
        this.mCollapsible = z;
        requestLayout();
    }

    public void setMenuCallbacks(m.a aVar, g.a aVar2) {
        this.mActionMenuPresenterCallback = aVar;
        this.mMenuBuilderCallback = aVar2;
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null) {
            actionMenuView.a(aVar, aVar2);
        }
    }

    private void ensureContentInsets() {
        if (this.mContentInsets == null) {
            this.mContentInsets = new am();
        }
    }

    final TextView getTitleTextView() {
        return this.mTitleTextView;
    }

    final TextView getSubtitleTextView() {
        return this.mSubtitleTextView;
    }

    ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.mOuterActionMenuPresenter;
    }

    Context getPopupContext() {
        return this.mPopupContext;
    }

    /* loaded from: classes.dex */
    public static class b extends a.C0027a {
        int b;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.b = 0;
        }

        public b(int i, int i2) {
            super(i, i2);
            this.b = 0;
            this.f175a = 8388627;
        }

        public b(b bVar) {
            super((a.C0027a) bVar);
            this.b = 0;
            this.b = bVar.b;
        }

        public b(a.C0027a c0027a) {
            super(c0027a);
            this.b = 0;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.b = 0;
            a(marginLayoutParams);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.b = 0;
        }

        void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.appcompat.widget.Toolbar.SavedState.1
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
        int f303a;
        boolean b;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f303a = parcel.readInt();
            this.b = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f303a);
            parcel.writeInt(this.b ? 1 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements androidx.appcompat.view.menu.m {

        /* renamed from: a, reason: collision with root package name */
        androidx.appcompat.view.menu.g f304a;
        androidx.appcompat.view.menu.i b;

        @Override // androidx.appcompat.view.menu.m
        public void a(Parcelable parcelable) {
        }

        @Override // androidx.appcompat.view.menu.m
        public void a(androidx.appcompat.view.menu.g gVar, boolean z) {
        }

        @Override // androidx.appcompat.view.menu.m
        public void a(m.a aVar) {
        }

        @Override // androidx.appcompat.view.menu.m
        public boolean a(androidx.appcompat.view.menu.r rVar) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.m
        public boolean b() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.m
        public int c() {
            return 0;
        }

        @Override // androidx.appcompat.view.menu.m
        public Parcelable f() {
            return null;
        }

        a() {
        }

        @Override // androidx.appcompat.view.menu.m
        public void a(Context context, androidx.appcompat.view.menu.g gVar) {
            androidx.appcompat.view.menu.i iVar;
            androidx.appcompat.view.menu.g gVar2 = this.f304a;
            if (gVar2 != null && (iVar = this.b) != null) {
                gVar2.d(iVar);
            }
            this.f304a = gVar;
        }

        @Override // androidx.appcompat.view.menu.m
        public void a(boolean z) {
            if (this.b != null) {
                androidx.appcompat.view.menu.g gVar = this.f304a;
                boolean z2 = false;
                if (gVar != null) {
                    int size = gVar.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            break;
                        }
                        if (this.f304a.getItem(i) == this.b) {
                            z2 = true;
                            break;
                        }
                        i++;
                    }
                }
                if (z2) {
                    return;
                }
                b(this.f304a, this.b);
            }
        }

        @Override // androidx.appcompat.view.menu.m
        public boolean a(androidx.appcompat.view.menu.g gVar, androidx.appcompat.view.menu.i iVar) {
            Toolbar.this.ensureCollapseButtonView();
            ViewParent parent = Toolbar.this.mCollapseButtonView.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.mCollapseButtonView);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.mCollapseButtonView);
            }
            Toolbar.this.mExpandedActionView = iVar.getActionView();
            this.b = iVar;
            ViewParent parent2 = Toolbar.this.mExpandedActionView.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.mExpandedActionView);
                }
                b generateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                generateDefaultLayoutParams.f175a = 8388611 | (Toolbar.this.mButtonGravity & 112);
                generateDefaultLayoutParams.b = 2;
                Toolbar.this.mExpandedActionView.setLayoutParams(generateDefaultLayoutParams);
                Toolbar toolbar4 = Toolbar.this;
                toolbar4.addView(toolbar4.mExpandedActionView);
            }
            Toolbar.this.removeChildrenForExpandedActionView();
            Toolbar.this.requestLayout();
            iVar.e(true);
            if (Toolbar.this.mExpandedActionView instanceof androidx.appcompat.view.c) {
                ((androidx.appcompat.view.c) Toolbar.this.mExpandedActionView).onActionViewExpanded();
            }
            return true;
        }

        @Override // androidx.appcompat.view.menu.m
        public boolean b(androidx.appcompat.view.menu.g gVar, androidx.appcompat.view.menu.i iVar) {
            if (Toolbar.this.mExpandedActionView instanceof androidx.appcompat.view.c) {
                ((androidx.appcompat.view.c) Toolbar.this.mExpandedActionView).onActionViewCollapsed();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.mExpandedActionView);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.mCollapseButtonView);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.mExpandedActionView = null;
            toolbar3.addChildrenForExpandedActionView();
            this.b = null;
            Toolbar.this.requestLayout();
            iVar.e(false);
            return true;
        }
    }
}
