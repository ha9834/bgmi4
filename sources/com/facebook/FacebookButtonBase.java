package com.facebook;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import androidx.core.content.a;
import androidx.fragment.app.Fragment;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;

/* loaded from: classes.dex */
public abstract class FacebookButtonBase extends Button {
    private String analyticsButtonCreatedEventName;
    private String analyticsButtonTappedEventName;
    private View.OnClickListener externalOnClickListener;
    private View.OnClickListener internalOnClickListener;
    private boolean overrideCompoundPadding;
    private int overrideCompoundPaddingLeft;
    private int overrideCompoundPaddingRight;
    private FragmentWrapper parentFragment;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int getDefaultRequestCode();

    protected int getDefaultStyleResource() {
        return CrashShieldHandler.isObjectCrashing(this) ? 0 : 0;
    }

    static /* synthetic */ void access$000(FacebookButtonBase facebookButtonBase, Context context) {
        if (CrashShieldHandler.isObjectCrashing(FacebookButtonBase.class)) {
            return;
        }
        try {
            facebookButtonBase.logButtonTapped(context);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FacebookButtonBase.class);
        }
    }

    static /* synthetic */ View.OnClickListener access$100(FacebookButtonBase facebookButtonBase) {
        if (CrashShieldHandler.isObjectCrashing(FacebookButtonBase.class)) {
            return null;
        }
        try {
            return facebookButtonBase.internalOnClickListener;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FacebookButtonBase.class);
            return null;
        }
    }

    static /* synthetic */ View.OnClickListener access$200(FacebookButtonBase facebookButtonBase) {
        if (CrashShieldHandler.isObjectCrashing(FacebookButtonBase.class)) {
            return null;
        }
        try {
            return facebookButtonBase.externalOnClickListener;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FacebookButtonBase.class);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FacebookButtonBase(Context context, AttributeSet attributeSet, int i, int i2, String str, String str2) {
        super(context, attributeSet, 0);
        i2 = i2 == 0 ? getDefaultStyleResource() : i2;
        configureButton(context, attributeSet, i, i2 == 0 ? com.facebook.common.R.style.com_facebook_button : i2);
        this.analyticsButtonCreatedEventName = str;
        this.analyticsButtonTappedEventName = str2;
        setClickable(true);
        setFocusable(true);
    }

    public void setFragment(Fragment fragment) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            this.parentFragment = new FragmentWrapper(fragment);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public void setFragment(android.app.Fragment fragment) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            this.parentFragment = new FragmentWrapper(fragment);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public Fragment getFragment() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            if (this.parentFragment != null) {
                return this.parentFragment.getSupportFragment();
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public android.app.Fragment getNativeFragment() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            if (this.parentFragment != null) {
                return this.parentFragment.getNativeFragment();
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            this.externalOnClickListener = onClickListener;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public int getRequestCode() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            return getDefaultRequestCode();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            super.onAttachedToWindow();
            if (isInEditMode()) {
                return;
            }
            logButtonCreated(getContext());
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if ((getGravity() & 1) != 0) {
                int compoundPaddingLeft = getCompoundPaddingLeft();
                int compoundPaddingRight = getCompoundPaddingRight();
                int min = Math.min((((getWidth() - (getCompoundDrawablePadding() + compoundPaddingLeft)) - compoundPaddingRight) - measureTextWidth(getText().toString())) / 2, (compoundPaddingLeft - getPaddingLeft()) / 2);
                this.overrideCompoundPaddingLeft = compoundPaddingLeft - min;
                this.overrideCompoundPaddingRight = compoundPaddingRight + min;
                this.overrideCompoundPadding = true;
            }
            super.onDraw(canvas);
            this.overrideCompoundPadding = false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @Override // android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            return this.overrideCompoundPadding ? this.overrideCompoundPaddingLeft : super.getCompoundPaddingLeft();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return 0;
        }
    }

    @Override // android.widget.TextView
    public int getCompoundPaddingRight() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            return this.overrideCompoundPadding ? this.overrideCompoundPaddingRight : super.getCompoundPaddingRight();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Activity getActivity() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Context context = getContext();
            while (!(context instanceof Activity) && (context instanceof ContextWrapper)) {
                context = ((ContextWrapper) context).getBaseContext();
            }
            if (context instanceof Activity) {
                return (Activity) context;
            }
            throw new FacebookException("Unable to get Activity.");
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int measureTextWidth(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            return (int) Math.ceil(getPaint().measureText(str));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void configureButton(Context context, AttributeSet attributeSet, int i, int i2) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            parseBackgroundAttributes(context, attributeSet, i, i2);
            parseCompoundDrawableAttributes(context, attributeSet, i, i2);
            parseContentAttributes(context, attributeSet, i, i2);
            parseTextAttributes(context, attributeSet, i, i2);
            setupOnClickListener();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void callExternalOnClickListener(View view) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (this.externalOnClickListener != null) {
                this.externalOnClickListener.onClick(view);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setInternalOnClickListener(View.OnClickListener onClickListener) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            this.internalOnClickListener = onClickListener;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private void logButtonCreated(Context context) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            new InternalAppEventsLogger(context).logEventImplicitly(this.analyticsButtonCreatedEventName);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private void logButtonTapped(Context context) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            new InternalAppEventsLogger(context).logEventImplicitly(this.analyticsButtonTappedEventName);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private void parseBackgroundAttributes(Context context, AttributeSet attributeSet, int i, int i2) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (isInEditMode()) {
                return;
            }
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{android.R.attr.background}, i, i2);
            try {
                if (obtainStyledAttributes.hasValue(0)) {
                    int resourceId = obtainStyledAttributes.getResourceId(0, 0);
                    if (resourceId != 0) {
                        setBackgroundResource(resourceId);
                    } else {
                        setBackgroundColor(obtainStyledAttributes.getColor(0, 0));
                    }
                } else {
                    setBackgroundColor(a.c(context, com.facebook.common.R.color.com_facebook_blue));
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @SuppressLint({"ResourceType"})
    private void parseCompoundDrawableAttributes(Context context, AttributeSet attributeSet, int i, int i2) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{android.R.attr.drawableLeft, android.R.attr.drawableTop, android.R.attr.drawableRight, android.R.attr.drawableBottom, android.R.attr.drawablePadding}, i, i2);
            try {
                setCompoundDrawablesWithIntrinsicBounds(obtainStyledAttributes.getResourceId(0, 0), obtainStyledAttributes.getResourceId(1, 0), obtainStyledAttributes.getResourceId(2, 0), obtainStyledAttributes.getResourceId(3, 0));
                setCompoundDrawablePadding(obtainStyledAttributes.getDimensionPixelSize(4, 0));
            } finally {
                obtainStyledAttributes.recycle();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private void parseContentAttributes(Context context, AttributeSet attributeSet, int i, int i2) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{android.R.attr.paddingLeft, android.R.attr.paddingTop, android.R.attr.paddingRight, android.R.attr.paddingBottom}, i, i2);
            try {
                setPadding(obtainStyledAttributes.getDimensionPixelSize(0, 0), obtainStyledAttributes.getDimensionPixelSize(1, 0), obtainStyledAttributes.getDimensionPixelSize(2, 0), obtainStyledAttributes.getDimensionPixelSize(3, 0));
            } finally {
                obtainStyledAttributes.recycle();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private void parseTextAttributes(Context context, AttributeSet attributeSet, int i, int i2) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{android.R.attr.textColor}, i, i2);
            try {
                setTextColor(obtainStyledAttributes.getColorStateList(0));
                obtainStyledAttributes.recycle();
                obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{android.R.attr.gravity}, i, i2);
                try {
                    setGravity(obtainStyledAttributes.getInt(0, 17));
                    obtainStyledAttributes.recycle();
                    obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{android.R.attr.textSize, android.R.attr.textStyle, android.R.attr.text}, i, i2);
                    try {
                        setTextSize(0, obtainStyledAttributes.getDimensionPixelSize(0, 0));
                        setTypeface(Typeface.defaultFromStyle(obtainStyledAttributes.getInt(1, 1)));
                        setText(obtainStyledAttributes.getString(2));
                    } finally {
                    }
                } finally {
                }
            } finally {
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private void setupOnClickListener() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            super.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.FacebookButtonBase.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (CrashShieldHandler.isObjectCrashing(this)) {
                        return;
                    }
                    try {
                        FacebookButtonBase.access$000(FacebookButtonBase.this, FacebookButtonBase.this.getContext());
                        if (FacebookButtonBase.access$100(FacebookButtonBase.this) != null) {
                            FacebookButtonBase.access$100(FacebookButtonBase.this).onClick(view);
                        } else if (FacebookButtonBase.access$200(FacebookButtonBase.this) != null) {
                            FacebookButtonBase.access$200(FacebookButtonBase.this).onClick(view);
                        }
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, this);
                    }
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }
}
