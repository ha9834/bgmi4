package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.ac;
import androidx.appcompat.widget.au;
import androidx.appcompat.widget.j;
import androidx.appcompat.widget.x;
import androidx.core.f.v;
import androidx.core.widget.i;
import androidx.customview.view.AbsSavedState;
import com.amazonaws.event.ProgressEvent;
import com.google.android.material.a;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.d;
import com.google.android.material.internal.k;
import com.google.android.material.internal.l;

/* loaded from: classes2.dex */
public class TextInputLayout extends LinearLayout {
    public static final int BOX_BACKGROUND_FILLED = 1;
    public static final int BOX_BACKGROUND_NONE = 0;
    public static final int BOX_BACKGROUND_OUTLINE = 2;
    private static final int INVALID_MAX_LENGTH = -1;
    private static final int LABEL_SCALE_ANIMATION_DURATION = 167;
    private static final String LOG_TAG = "TextInputLayout";
    private ValueAnimator animator;
    private GradientDrawable boxBackground;
    private int boxBackgroundColor;
    private int boxBackgroundMode;
    private final int boxBottomOffsetPx;
    private final int boxCollapsedPaddingTopPx;
    private float boxCornerRadiusBottomEnd;
    private float boxCornerRadiusBottomStart;
    private float boxCornerRadiusTopEnd;
    private float boxCornerRadiusTopStart;
    private final int boxLabelCutoutPaddingPx;
    private int boxStrokeColor;
    private final int boxStrokeWidthDefaultPx;
    private final int boxStrokeWidthFocusedPx;
    private int boxStrokeWidthPx;
    final com.google.android.material.internal.b collapsingTextHelper;
    boolean counterEnabled;
    private int counterMaxLength;
    private final int counterOverflowTextAppearance;
    private boolean counterOverflowed;
    private final int counterTextAppearance;
    private TextView counterView;
    private ColorStateList defaultHintTextColor;
    private final int defaultStrokeColor;
    private final int disabledColor;
    EditText editText;
    private Drawable editTextOriginalDrawable;
    private int focusedStrokeColor;
    private ColorStateList focusedTextColor;
    private boolean hasPasswordToggleTintList;
    private boolean hasPasswordToggleTintMode;
    private boolean hasReconstructedEditTextBackground;
    private CharSequence hint;
    private boolean hintAnimationEnabled;
    private boolean hintEnabled;
    private boolean hintExpanded;
    private final int hoveredStrokeColor;
    private boolean inDrawableStateChanged;
    private final b indicatorViewController;
    private final FrameLayout inputFrame;
    private boolean isProvidingHint;
    private Drawable originalEditTextEndDrawable;
    private CharSequence originalHint;
    private CharSequence passwordToggleContentDesc;
    private Drawable passwordToggleDrawable;
    private Drawable passwordToggleDummyDrawable;
    private boolean passwordToggleEnabled;
    private ColorStateList passwordToggleTintList;
    private PorterDuff.Mode passwordToggleTintMode;
    private CheckableImageButton passwordToggleView;
    private boolean passwordToggledVisible;
    private boolean restoringSavedState;
    private final Rect tmpRect;
    private final RectF tmpRectF;
    private Typeface typeface;

    public TextInputLayout(Context context) {
        this(context, null);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.textInputStyle);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.indicatorViewController = new b(this);
        this.tmpRect = new Rect();
        this.tmpRectF = new RectF();
        this.collapsingTextHelper = new com.google.android.material.internal.b(this);
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        this.inputFrame = new FrameLayout(context);
        this.inputFrame.setAddStatesFromChildren(true);
        addView(this.inputFrame);
        this.collapsingTextHelper.a(com.google.android.material.a.a.f5204a);
        this.collapsingTextHelper.b(com.google.android.material.a.a.f5204a);
        this.collapsingTextHelper.b(8388659);
        au b = k.b(context, attributeSet, a.k.TextInputLayout, i, a.j.Widget_Design_TextInputLayout, new int[0]);
        this.hintEnabled = b.a(a.k.TextInputLayout_hintEnabled, true);
        setHint(b.c(a.k.TextInputLayout_android_hint));
        this.hintAnimationEnabled = b.a(a.k.TextInputLayout_hintAnimationEnabled, true);
        this.boxBottomOffsetPx = context.getResources().getDimensionPixelOffset(a.d.mtrl_textinput_box_bottom_offset);
        this.boxLabelCutoutPaddingPx = context.getResources().getDimensionPixelOffset(a.d.mtrl_textinput_box_label_cutout_padding);
        this.boxCollapsedPaddingTopPx = b.d(a.k.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.boxCornerRadiusTopStart = b.b(a.k.TextInputLayout_boxCornerRadiusTopStart, 0.0f);
        this.boxCornerRadiusTopEnd = b.b(a.k.TextInputLayout_boxCornerRadiusTopEnd, 0.0f);
        this.boxCornerRadiusBottomEnd = b.b(a.k.TextInputLayout_boxCornerRadiusBottomEnd, 0.0f);
        this.boxCornerRadiusBottomStart = b.b(a.k.TextInputLayout_boxCornerRadiusBottomStart, 0.0f);
        this.boxBackgroundColor = b.b(a.k.TextInputLayout_boxBackgroundColor, 0);
        this.focusedStrokeColor = b.b(a.k.TextInputLayout_boxStrokeColor, 0);
        this.boxStrokeWidthDefaultPx = context.getResources().getDimensionPixelSize(a.d.mtrl_textinput_box_stroke_width_default);
        this.boxStrokeWidthFocusedPx = context.getResources().getDimensionPixelSize(a.d.mtrl_textinput_box_stroke_width_focused);
        this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
        setBoxBackgroundMode(b.a(a.k.TextInputLayout_boxBackgroundMode, 0));
        if (b.g(a.k.TextInputLayout_android_textColorHint)) {
            ColorStateList e = b.e(a.k.TextInputLayout_android_textColorHint);
            this.focusedTextColor = e;
            this.defaultHintTextColor = e;
        }
        this.defaultStrokeColor = androidx.core.content.a.c(context, a.c.mtrl_textinput_default_box_stroke_color);
        this.disabledColor = androidx.core.content.a.c(context, a.c.mtrl_textinput_disabled_color);
        this.hoveredStrokeColor = androidx.core.content.a.c(context, a.c.mtrl_textinput_hovered_box_stroke_color);
        if (b.g(a.k.TextInputLayout_hintTextAppearance, -1) != -1) {
            setHintTextAppearance(b.g(a.k.TextInputLayout_hintTextAppearance, 0));
        }
        int g = b.g(a.k.TextInputLayout_errorTextAppearance, 0);
        boolean a2 = b.a(a.k.TextInputLayout_errorEnabled, false);
        int g2 = b.g(a.k.TextInputLayout_helperTextTextAppearance, 0);
        boolean a3 = b.a(a.k.TextInputLayout_helperTextEnabled, false);
        CharSequence c = b.c(a.k.TextInputLayout_helperText);
        boolean a4 = b.a(a.k.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(b.a(a.k.TextInputLayout_counterMaxLength, -1));
        this.counterTextAppearance = b.g(a.k.TextInputLayout_counterTextAppearance, 0);
        this.counterOverflowTextAppearance = b.g(a.k.TextInputLayout_counterOverflowTextAppearance, 0);
        this.passwordToggleEnabled = b.a(a.k.TextInputLayout_passwordToggleEnabled, false);
        this.passwordToggleDrawable = b.a(a.k.TextInputLayout_passwordToggleDrawable);
        this.passwordToggleContentDesc = b.c(a.k.TextInputLayout_passwordToggleContentDescription);
        if (b.g(a.k.TextInputLayout_passwordToggleTint)) {
            this.hasPasswordToggleTintList = true;
            this.passwordToggleTintList = b.e(a.k.TextInputLayout_passwordToggleTint);
        }
        if (b.g(a.k.TextInputLayout_passwordToggleTintMode)) {
            this.hasPasswordToggleTintMode = true;
            this.passwordToggleTintMode = l.a(b.a(a.k.TextInputLayout_passwordToggleTintMode, -1), null);
        }
        b.a();
        setHelperTextEnabled(a3);
        setHelperText(c);
        setHelperTextTextAppearance(g2);
        setErrorEnabled(a2);
        setErrorTextAppearance(g);
        setCounterEnabled(a4);
        applyPasswordToggleTint();
        v.b(this, 2);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
            this.inputFrame.addView(view, layoutParams2);
            this.inputFrame.setLayoutParams(layoutParams);
            updateInputLayoutMargins();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i, layoutParams);
    }

    private Drawable getBoxBackground() {
        int i = this.boxBackgroundMode;
        if (i == 1 || i == 2) {
            return this.boxBackground;
        }
        throw new IllegalStateException();
    }

    public void setBoxBackgroundMode(int i) {
        if (i == this.boxBackgroundMode) {
            return;
        }
        this.boxBackgroundMode = i;
        onApplyBoxBackgroundMode();
    }

    private void onApplyBoxBackgroundMode() {
        assignBoxBackgroundByMode();
        if (this.boxBackgroundMode != 0) {
            updateInputLayoutMargins();
        }
        updateTextInputBoxBounds();
    }

    private void assignBoxBackgroundByMode() {
        int i = this.boxBackgroundMode;
        if (i == 0) {
            this.boxBackground = null;
            return;
        }
        if (i == 2 && this.hintEnabled && !(this.boxBackground instanceof com.google.android.material.textfield.a)) {
            this.boxBackground = new com.google.android.material.textfield.a();
        } else {
            if (this.boxBackground instanceof GradientDrawable) {
                return;
            }
            this.boxBackground = new GradientDrawable();
        }
    }

    public void setBoxStrokeColor(int i) {
        if (this.focusedStrokeColor != i) {
            this.focusedStrokeColor = i;
            updateTextInputBoxState();
        }
    }

    public int getBoxStrokeColor() {
        return this.focusedStrokeColor;
    }

    public void setBoxBackgroundColorResource(int i) {
        setBoxBackgroundColor(androidx.core.content.a.c(getContext(), i));
    }

    public void setBoxBackgroundColor(int i) {
        if (this.boxBackgroundColor != i) {
            this.boxBackgroundColor = i;
            applyBoxAttributes();
        }
    }

    public int getBoxBackgroundColor() {
        return this.boxBackgroundColor;
    }

    public void setBoxCornerRadiiResources(int i, int i2, int i3, int i4) {
        setBoxCornerRadii(getContext().getResources().getDimension(i), getContext().getResources().getDimension(i2), getContext().getResources().getDimension(i3), getContext().getResources().getDimension(i4));
    }

    public void setBoxCornerRadii(float f, float f2, float f3, float f4) {
        if (this.boxCornerRadiusTopStart == f && this.boxCornerRadiusTopEnd == f2 && this.boxCornerRadiusBottomEnd == f4 && this.boxCornerRadiusBottomStart == f3) {
            return;
        }
        this.boxCornerRadiusTopStart = f;
        this.boxCornerRadiusTopEnd = f2;
        this.boxCornerRadiusBottomEnd = f4;
        this.boxCornerRadiusBottomStart = f3;
        applyBoxAttributes();
    }

    public float getBoxCornerRadiusTopStart() {
        return this.boxCornerRadiusTopStart;
    }

    public float getBoxCornerRadiusTopEnd() {
        return this.boxCornerRadiusTopEnd;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return this.boxCornerRadiusBottomEnd;
    }

    public float getBoxCornerRadiusBottomStart() {
        return this.boxCornerRadiusBottomStart;
    }

    private float[] getCornerRadiiAsArray() {
        if (!l.a(this)) {
            float f = this.boxCornerRadiusTopStart;
            float f2 = this.boxCornerRadiusTopEnd;
            float f3 = this.boxCornerRadiusBottomEnd;
            float f4 = this.boxCornerRadiusBottomStart;
            return new float[]{f, f, f2, f2, f3, f3, f4, f4};
        }
        float f5 = this.boxCornerRadiusTopEnd;
        float f6 = this.boxCornerRadiusTopStart;
        float f7 = this.boxCornerRadiusBottomStart;
        float f8 = this.boxCornerRadiusBottomEnd;
        return new float[]{f5, f5, f6, f6, f7, f7, f8, f8};
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.typeface) {
            this.typeface = typeface;
            this.collapsingTextHelper.a(typeface);
            this.indicatorViewController.a(typeface);
            TextView textView = this.counterView;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    public Typeface getTypeface() {
        return this.typeface;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i) {
        EditText editText;
        if (this.originalHint == null || (editText = this.editText) == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i);
            return;
        }
        boolean z = this.isProvidingHint;
        this.isProvidingHint = false;
        CharSequence hint = editText.getHint();
        this.editText.setHint(this.originalHint);
        try {
            super.dispatchProvideAutofillStructure(viewStructure, i);
        } finally {
            this.editText.setHint(hint);
            this.isProvidingHint = z;
        }
    }

    private void setEditText(EditText editText) {
        if (this.editText != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (!(editText instanceof c)) {
            Log.i(LOG_TAG, "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.editText = editText;
        onApplyBoxBackgroundMode();
        setTextInputAccessibilityDelegate(new a(this));
        if (!hasPasswordTransformation()) {
            this.collapsingTextHelper.a(this.editText.getTypeface());
        }
        this.collapsingTextHelper.a(this.editText.getTextSize());
        int gravity = this.editText.getGravity();
        this.collapsingTextHelper.b((gravity & (-113)) | 48);
        this.collapsingTextHelper.a(gravity);
        this.editText.addTextChangedListener(new TextWatcher() { // from class: com.google.android.material.textfield.TextInputLayout.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                TextInputLayout.this.updateLabelState(!r0.restoringSavedState);
                if (TextInputLayout.this.counterEnabled) {
                    TextInputLayout.this.updateCounter(editable.length());
                }
            }
        });
        if (this.defaultHintTextColor == null) {
            this.defaultHintTextColor = this.editText.getHintTextColors();
        }
        if (this.hintEnabled) {
            if (TextUtils.isEmpty(this.hint)) {
                this.originalHint = this.editText.getHint();
                setHint(this.originalHint);
                this.editText.setHint((CharSequence) null);
            }
            this.isProvidingHint = true;
        }
        if (this.counterView != null) {
            updateCounter(this.editText.getText().length());
        }
        this.indicatorViewController.d();
        updatePasswordToggleView();
        updateLabelState(false, true);
    }

    private void updateInputLayoutMargins() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.inputFrame.getLayoutParams();
        int calculateLabelMarginTop = calculateLabelMarginTop();
        if (calculateLabelMarginTop != layoutParams.topMargin) {
            layoutParams.topMargin = calculateLabelMarginTop;
            this.inputFrame.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateLabelState(boolean z) {
        updateLabelState(z, false);
    }

    private void updateLabelState(boolean z, boolean z2) {
        ColorStateList colorStateList;
        TextView textView;
        boolean isEnabled = isEnabled();
        EditText editText = this.editText;
        boolean z3 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.editText;
        boolean z4 = editText2 != null && editText2.hasFocus();
        boolean g = this.indicatorViewController.g();
        ColorStateList colorStateList2 = this.defaultHintTextColor;
        if (colorStateList2 != null) {
            this.collapsingTextHelper.a(colorStateList2);
            this.collapsingTextHelper.b(this.defaultHintTextColor);
        }
        if (!isEnabled) {
            this.collapsingTextHelper.a(ColorStateList.valueOf(this.disabledColor));
            this.collapsingTextHelper.b(ColorStateList.valueOf(this.disabledColor));
        } else if (g) {
            this.collapsingTextHelper.a(this.indicatorViewController.l());
        } else if (this.counterOverflowed && (textView = this.counterView) != null) {
            this.collapsingTextHelper.a(textView.getTextColors());
        } else if (z4 && (colorStateList = this.focusedTextColor) != null) {
            this.collapsingTextHelper.a(colorStateList);
        }
        if (z3 || (isEnabled() && (z4 || g))) {
            if (z2 || this.hintExpanded) {
                collapseHint(z);
                return;
            }
            return;
        }
        if (z2 || !this.hintExpanded) {
            expandHint(z);
        }
    }

    public EditText getEditText() {
        return this.editText;
    }

    public void setHint(CharSequence charSequence) {
        if (this.hintEnabled) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(ProgressEvent.PART_COMPLETED_EVENT_CODE);
        }
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.hint)) {
            return;
        }
        this.hint = charSequence;
        this.collapsingTextHelper.a(charSequence);
        if (this.hintExpanded) {
            return;
        }
        openCutout();
    }

    public CharSequence getHint() {
        if (this.hintEnabled) {
            return this.hint;
        }
        return null;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.hintEnabled) {
            this.hintEnabled = z;
            if (!this.hintEnabled) {
                this.isProvidingHint = false;
                if (!TextUtils.isEmpty(this.hint) && TextUtils.isEmpty(this.editText.getHint())) {
                    this.editText.setHint(this.hint);
                }
                setHintInternal(null);
            } else {
                CharSequence hint = this.editText.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.hint)) {
                        setHint(hint);
                    }
                    this.editText.setHint((CharSequence) null);
                }
                this.isProvidingHint = true;
            }
            if (this.editText != null) {
                updateInputLayoutMargins();
            }
        }
    }

    public boolean isHintEnabled() {
        return this.hintEnabled;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isProvidingHint() {
        return this.isProvidingHint;
    }

    public void setHintTextAppearance(int i) {
        this.collapsingTextHelper.c(i);
        this.focusedTextColor = this.collapsingTextHelper.h();
        if (this.editText != null) {
            updateLabelState(false);
            updateInputLayoutMargins();
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.defaultHintTextColor = colorStateList;
        this.focusedTextColor = colorStateList;
        if (this.editText != null) {
            updateLabelState(false);
        }
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.defaultHintTextColor;
    }

    public void setErrorEnabled(boolean z) {
        this.indicatorViewController.a(z);
    }

    public void setErrorTextAppearance(int i) {
        this.indicatorViewController.b(i);
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        this.indicatorViewController.a(colorStateList);
    }

    public int getErrorCurrentTextColors() {
        return this.indicatorViewController.k();
    }

    public void setHelperTextTextAppearance(int i) {
        this.indicatorViewController.c(i);
    }

    public boolean isErrorEnabled() {
        return this.indicatorViewController.e();
    }

    public void setHelperTextEnabled(boolean z) {
        this.indicatorViewController.b(z);
    }

    public void setHelperText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (isHelperTextEnabled()) {
                setHelperTextEnabled(false);
            }
        } else {
            if (!isHelperTextEnabled()) {
                setHelperTextEnabled(true);
            }
            this.indicatorViewController.a(charSequence);
        }
    }

    public boolean isHelperTextEnabled() {
        return this.indicatorViewController.f();
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        this.indicatorViewController.b(colorStateList);
    }

    public int getHelperTextCurrentTextColor() {
        return this.indicatorViewController.m();
    }

    public void setError(CharSequence charSequence) {
        if (!this.indicatorViewController.e()) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.indicatorViewController.b(charSequence);
        } else {
            this.indicatorViewController.b();
        }
    }

    public void setCounterEnabled(boolean z) {
        if (this.counterEnabled != z) {
            if (z) {
                this.counterView = new x(getContext());
                this.counterView.setId(a.f.textinput_counter);
                Typeface typeface = this.typeface;
                if (typeface != null) {
                    this.counterView.setTypeface(typeface);
                }
                this.counterView.setMaxLines(1);
                setTextAppearanceCompatWithErrorFallback(this.counterView, this.counterTextAppearance);
                this.indicatorViewController.a(this.counterView, 2);
                EditText editText = this.editText;
                if (editText == null) {
                    updateCounter(0);
                } else {
                    updateCounter(editText.getText().length());
                }
            } else {
                this.indicatorViewController.b(this.counterView, 2);
                this.counterView = null;
            }
            this.counterEnabled = z;
        }
    }

    public boolean isCounterEnabled() {
        return this.counterEnabled;
    }

    public void setCounterMaxLength(int i) {
        if (this.counterMaxLength != i) {
            if (i > 0) {
                this.counterMaxLength = i;
            } else {
                this.counterMaxLength = -1;
            }
            if (this.counterEnabled) {
                EditText editText = this.editText;
                updateCounter(editText == null ? 0 : editText.getText().length());
            }
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        recursiveSetEnabled(this, z);
        super.setEnabled(z);
    }

    private static void recursiveSetEnabled(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                recursiveSetEnabled((ViewGroup) childAt, z);
            }
        }
    }

    public int getCounterMaxLength() {
        return this.counterMaxLength;
    }

    CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (this.counterEnabled && this.counterOverflowed && (textView = this.counterView) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    void updateCounter(int i) {
        boolean z = this.counterOverflowed;
        if (this.counterMaxLength == -1) {
            this.counterView.setText(String.valueOf(i));
            this.counterView.setContentDescription(null);
            this.counterOverflowed = false;
        } else {
            if (v.g(this.counterView) == 1) {
                v.c(this.counterView, 0);
            }
            this.counterOverflowed = i > this.counterMaxLength;
            boolean z2 = this.counterOverflowed;
            if (z != z2) {
                setTextAppearanceCompatWithErrorFallback(this.counterView, z2 ? this.counterOverflowTextAppearance : this.counterTextAppearance);
                if (this.counterOverflowed) {
                    v.c(this.counterView, 1);
                }
            }
            this.counterView.setText(getContext().getString(a.i.character_counter_pattern, Integer.valueOf(i), Integer.valueOf(this.counterMaxLength)));
            this.counterView.setContentDescription(getContext().getString(a.i.character_counter_content_description, Integer.valueOf(i), Integer.valueOf(this.counterMaxLength)));
        }
        if (this.editText == null || z == this.counterOverflowed) {
            return;
        }
        updateLabelState(false);
        updateTextInputBoxState();
        updateEditTextBackground();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0015, code lost:
    
        if (r3.getTextColors().getDefaultColor() == (-65281)) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setTextAppearanceCompatWithErrorFallback(android.widget.TextView r3, int r4) {
        /*
            r2 = this;
            r0 = 1
            androidx.core.widget.i.a(r3, r4)     // Catch: java.lang.Exception -> L1a
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L1a
            r1 = 23
            if (r4 < r1) goto L18
            android.content.res.ColorStateList r4 = r3.getTextColors()     // Catch: java.lang.Exception -> L1a
            int r4 = r4.getDefaultColor()     // Catch: java.lang.Exception -> L1a
            r1 = -65281(0xffffffffffff00ff, float:NaN)
            if (r4 != r1) goto L18
            goto L1a
        L18:
            r4 = 0
            r0 = 0
        L1a:
            if (r0 == 0) goto L2e
            int r4 = com.google.android.material.a.j.TextAppearance_AppCompat_Caption
            androidx.core.widget.i.a(r3, r4)
            android.content.Context r4 = r2.getContext()
            int r0 = com.google.android.material.a.c.design_error
            int r4 = androidx.core.content.a.c(r4, r0)
            r3.setTextColor(r4)
        L2e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.setTextAppearanceCompatWithErrorFallback(android.widget.TextView, int):void");
    }

    private void updateTextInputBoxBounds() {
        if (this.boxBackgroundMode == 0 || this.boxBackground == null || this.editText == null || getRight() == 0) {
            return;
        }
        int left = this.editText.getLeft();
        int calculateBoxBackgroundTop = calculateBoxBackgroundTop();
        int right = this.editText.getRight();
        int bottom = this.editText.getBottom() + this.boxBottomOffsetPx;
        if (this.boxBackgroundMode == 2) {
            int i = this.boxStrokeWidthFocusedPx;
            left += i / 2;
            calculateBoxBackgroundTop -= i / 2;
            right -= i / 2;
            bottom += i / 2;
        }
        this.boxBackground.setBounds(left, calculateBoxBackgroundTop, right, bottom);
        applyBoxAttributes();
        updateEditTextBackgroundBounds();
    }

    private int calculateBoxBackgroundTop() {
        EditText editText = this.editText;
        if (editText == null) {
            return 0;
        }
        switch (this.boxBackgroundMode) {
            case 1:
                return editText.getTop();
            case 2:
                return editText.getTop() + calculateLabelMarginTop();
            default:
                return 0;
        }
    }

    private int calculateLabelMarginTop() {
        if (!this.hintEnabled) {
            return 0;
        }
        switch (this.boxBackgroundMode) {
            case 0:
            case 1:
                return (int) this.collapsingTextHelper.b();
            case 2:
                return (int) (this.collapsingTextHelper.b() / 2.0f);
            default:
                return 0;
        }
    }

    private int calculateCollapsedTextTopBounds() {
        switch (this.boxBackgroundMode) {
            case 1:
                return getBoxBackground().getBounds().top + this.boxCollapsedPaddingTopPx;
            case 2:
                return getBoxBackground().getBounds().top - calculateLabelMarginTop();
            default:
                return getPaddingTop();
        }
    }

    private void updateEditTextBackgroundBounds() {
        Drawable background;
        EditText editText = this.editText;
        if (editText == null || (background = editText.getBackground()) == null) {
            return;
        }
        if (ac.b(background)) {
            background = background.mutate();
        }
        com.google.android.material.internal.c.b(this, this.editText, new Rect());
        Rect bounds = background.getBounds();
        if (bounds.left != bounds.right) {
            Rect rect = new Rect();
            background.getPadding(rect);
            background.setBounds(bounds.left - rect.left, bounds.top, bounds.right + (rect.right * 2), this.editText.getBottom());
        }
    }

    private void setBoxAttributes() {
        switch (this.boxBackgroundMode) {
            case 1:
                this.boxStrokeWidthPx = 0;
                return;
            case 2:
                if (this.focusedStrokeColor == 0) {
                    this.focusedStrokeColor = this.focusedTextColor.getColorForState(getDrawableState(), this.focusedTextColor.getDefaultColor());
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void applyBoxAttributes() {
        int i;
        Drawable drawable;
        if (this.boxBackground == null) {
            return;
        }
        setBoxAttributes();
        EditText editText = this.editText;
        if (editText != null && this.boxBackgroundMode == 2) {
            if (editText.getBackground() != null) {
                this.editTextOriginalDrawable = this.editText.getBackground();
            }
            v.a(this.editText, (Drawable) null);
        }
        EditText editText2 = this.editText;
        if (editText2 != null && this.boxBackgroundMode == 1 && (drawable = this.editTextOriginalDrawable) != null) {
            v.a(editText2, drawable);
        }
        int i2 = this.boxStrokeWidthPx;
        if (i2 > -1 && (i = this.boxStrokeColor) != 0) {
            this.boxBackground.setStroke(i2, i);
        }
        this.boxBackground.setCornerRadii(getCornerRadiiAsArray());
        this.boxBackground.setColor(this.boxBackgroundColor);
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateEditTextBackground() {
        Drawable background;
        TextView textView;
        EditText editText = this.editText;
        if (editText == null || (background = editText.getBackground()) == null) {
            return;
        }
        ensureBackgroundDrawableStateWorkaround();
        if (ac.b(background)) {
            background = background.mutate();
        }
        if (this.indicatorViewController.g()) {
            background.setColorFilter(j.a(this.indicatorViewController.k(), PorterDuff.Mode.SRC_IN));
        } else if (this.counterOverflowed && (textView = this.counterView) != null) {
            background.setColorFilter(j.a(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            androidx.core.graphics.drawable.a.f(background);
            this.editText.refreshDrawableState();
        }
    }

    private void ensureBackgroundDrawableStateWorkaround() {
        Drawable background;
        int i = Build.VERSION.SDK_INT;
        if ((i != 21 && i != 22) || (background = this.editText.getBackground()) == null || this.hasReconstructedEditTextBackground) {
            return;
        }
        Drawable newDrawable = background.getConstantState().newDrawable();
        if (background instanceof DrawableContainer) {
            this.hasReconstructedEditTextBackground = d.a((DrawableContainer) background, newDrawable.getConstantState());
        }
        if (this.hasReconstructedEditTextBackground) {
            return;
        }
        v.a(this.editText, newDrawable);
        this.hasReconstructedEditTextBackground = true;
        onApplyBoxBackgroundMode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.textfield.TextInputLayout.SavedState.1
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
        CharSequence f5338a;
        boolean b;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f5338a = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.b = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.f5338a, parcel, i);
            parcel.writeInt(this.b ? 1 : 0);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f5338a) + "}";
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.indicatorViewController.g()) {
            savedState.f5338a = getError();
        }
        savedState.b = this.passwordToggledVisible;
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        setError(savedState.f5338a);
        if (savedState.b) {
            passwordVisibilityToggleRequested(true);
        }
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.restoringSavedState = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.restoringSavedState = false;
    }

    public CharSequence getError() {
        if (this.indicatorViewController.e()) {
            return this.indicatorViewController.i();
        }
        return null;
    }

    public CharSequence getHelperText() {
        if (this.indicatorViewController.f()) {
            return this.indicatorViewController.j();
        }
        return null;
    }

    public boolean isHintAnimationEnabled() {
        return this.hintAnimationEnabled;
    }

    public void setHintAnimationEnabled(boolean z) {
        this.hintAnimationEnabled = z;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        GradientDrawable gradientDrawable = this.boxBackground;
        if (gradientDrawable != null) {
            gradientDrawable.draw(canvas);
        }
        super.draw(canvas);
        if (this.hintEnabled) {
            this.collapsingTextHelper.a(canvas);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        updatePasswordToggleView();
        super.onMeasure(i, i2);
    }

    private void updatePasswordToggleView() {
        if (this.editText == null) {
            return;
        }
        if (shouldShowPasswordIcon()) {
            if (this.passwordToggleView == null) {
                this.passwordToggleView = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(a.h.design_text_input_password_icon, (ViewGroup) this.inputFrame, false);
                this.passwordToggleView.setImageDrawable(this.passwordToggleDrawable);
                this.passwordToggleView.setContentDescription(this.passwordToggleContentDesc);
                this.inputFrame.addView(this.passwordToggleView);
                this.passwordToggleView.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.textfield.TextInputLayout.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TextInputLayout.this.passwordVisibilityToggleRequested(false);
                    }
                });
            }
            EditText editText = this.editText;
            if (editText != null && v.k(editText) <= 0) {
                this.editText.setMinimumHeight(v.k(this.passwordToggleView));
            }
            this.passwordToggleView.setVisibility(0);
            this.passwordToggleView.setChecked(this.passwordToggledVisible);
            if (this.passwordToggleDummyDrawable == null) {
                this.passwordToggleDummyDrawable = new ColorDrawable();
            }
            this.passwordToggleDummyDrawable.setBounds(0, 0, this.passwordToggleView.getMeasuredWidth(), 1);
            Drawable[] b = i.b(this.editText);
            if (b[2] != this.passwordToggleDummyDrawable) {
                this.originalEditTextEndDrawable = b[2];
            }
            i.a(this.editText, b[0], b[1], this.passwordToggleDummyDrawable, b[3]);
            this.passwordToggleView.setPadding(this.editText.getPaddingLeft(), this.editText.getPaddingTop(), this.editText.getPaddingRight(), this.editText.getPaddingBottom());
            return;
        }
        CheckableImageButton checkableImageButton = this.passwordToggleView;
        if (checkableImageButton != null && checkableImageButton.getVisibility() == 0) {
            this.passwordToggleView.setVisibility(8);
        }
        if (this.passwordToggleDummyDrawable != null) {
            Drawable[] b2 = i.b(this.editText);
            if (b2[2] == this.passwordToggleDummyDrawable) {
                i.a(this.editText, b2[0], b2[1], this.originalEditTextEndDrawable, b2[3]);
                this.passwordToggleDummyDrawable = null;
            }
        }
    }

    public void setPasswordVisibilityToggleDrawable(int i) {
        setPasswordVisibilityToggleDrawable(i != 0 ? androidx.appcompat.a.a.a.b(getContext(), i) : null);
    }

    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.passwordToggleDrawable = drawable;
        CheckableImageButton checkableImageButton = this.passwordToggleView;
        if (checkableImageButton != null) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    public void setPasswordVisibilityToggleContentDescription(int i) {
        setPasswordVisibilityToggleContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.passwordToggleContentDesc = charSequence;
        CheckableImageButton checkableImageButton = this.passwordToggleView;
        if (checkableImageButton != null) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.passwordToggleDrawable;
    }

    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.passwordToggleContentDesc;
    }

    public boolean isPasswordVisibilityToggleEnabled() {
        return this.passwordToggleEnabled;
    }

    public void setPasswordVisibilityToggleEnabled(boolean z) {
        EditText editText;
        if (this.passwordToggleEnabled != z) {
            this.passwordToggleEnabled = z;
            if (!z && this.passwordToggledVisible && (editText = this.editText) != null) {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            this.passwordToggledVisible = false;
            updatePasswordToggleView();
        }
    }

    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.passwordToggleTintList = colorStateList;
        this.hasPasswordToggleTintList = true;
        applyPasswordToggleTint();
    }

    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.passwordToggleTintMode = mode;
        this.hasPasswordToggleTintMode = true;
        applyPasswordToggleTint();
    }

    public void passwordVisibilityToggleRequested(boolean z) {
        if (this.passwordToggleEnabled) {
            int selectionEnd = this.editText.getSelectionEnd();
            if (hasPasswordTransformation()) {
                this.editText.setTransformationMethod(null);
                this.passwordToggledVisible = true;
            } else {
                this.editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.passwordToggledVisible = false;
            }
            this.passwordToggleView.setChecked(this.passwordToggledVisible);
            if (z) {
                this.passwordToggleView.jumpDrawablesToCurrentState();
            }
            this.editText.setSelection(selectionEnd);
        }
    }

    public void setTextInputAccessibilityDelegate(a aVar) {
        EditText editText = this.editText;
        if (editText != null) {
            v.a(editText, aVar);
        }
    }

    private boolean hasPasswordTransformation() {
        EditText editText = this.editText;
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    private boolean shouldShowPasswordIcon() {
        return this.passwordToggleEnabled && (hasPasswordTransformation() || this.passwordToggledVisible);
    }

    private void applyPasswordToggleTint() {
        if (this.passwordToggleDrawable != null) {
            if (this.hasPasswordToggleTintList || this.hasPasswordToggleTintMode) {
                this.passwordToggleDrawable = androidx.core.graphics.drawable.a.g(this.passwordToggleDrawable).mutate();
                if (this.hasPasswordToggleTintList) {
                    androidx.core.graphics.drawable.a.a(this.passwordToggleDrawable, this.passwordToggleTintList);
                }
                if (this.hasPasswordToggleTintMode) {
                    androidx.core.graphics.drawable.a.a(this.passwordToggleDrawable, this.passwordToggleTintMode);
                }
                CheckableImageButton checkableImageButton = this.passwordToggleView;
                if (checkableImageButton != null) {
                    Drawable drawable = checkableImageButton.getDrawable();
                    Drawable drawable2 = this.passwordToggleDrawable;
                    if (drawable != drawable2) {
                        this.passwordToggleView.setImageDrawable(drawable2);
                    }
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        EditText editText;
        super.onLayout(z, i, i2, i3, i4);
        if (this.boxBackground != null) {
            updateTextInputBoxBounds();
        }
        if (!this.hintEnabled || (editText = this.editText) == null) {
            return;
        }
        Rect rect = this.tmpRect;
        com.google.android.material.internal.c.b(this, editText, rect);
        int compoundPaddingLeft = rect.left + this.editText.getCompoundPaddingLeft();
        int compoundPaddingRight = rect.right - this.editText.getCompoundPaddingRight();
        int calculateCollapsedTextTopBounds = calculateCollapsedTextTopBounds();
        this.collapsingTextHelper.a(compoundPaddingLeft, rect.top + this.editText.getCompoundPaddingTop(), compoundPaddingRight, rect.bottom - this.editText.getCompoundPaddingBottom());
        this.collapsingTextHelper.b(compoundPaddingLeft, calculateCollapsedTextTopBounds, compoundPaddingRight, (i4 - i2) - getPaddingBottom());
        this.collapsingTextHelper.g();
        if (!cutoutEnabled() || this.hintExpanded) {
            return;
        }
        openCutout();
    }

    private void collapseHint(boolean z) {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.animator.cancel();
        }
        if (z && this.hintAnimationEnabled) {
            animateToExpansionFraction(1.0f);
        } else {
            this.collapsingTextHelper.b(1.0f);
        }
        this.hintExpanded = false;
        if (cutoutEnabled()) {
            openCutout();
        }
    }

    private boolean cutoutEnabled() {
        return this.hintEnabled && !TextUtils.isEmpty(this.hint) && (this.boxBackground instanceof com.google.android.material.textfield.a);
    }

    private void openCutout() {
        if (cutoutEnabled()) {
            RectF rectF = this.tmpRectF;
            this.collapsingTextHelper.a(rectF);
            applyCutoutPadding(rectF);
            ((com.google.android.material.textfield.a) this.boxBackground).a(rectF);
        }
    }

    private void closeCutout() {
        if (cutoutEnabled()) {
            ((com.google.android.material.textfield.a) this.boxBackground).b();
        }
    }

    private void applyCutoutPadding(RectF rectF) {
        rectF.left -= this.boxLabelCutoutPaddingPx;
        rectF.top -= this.boxLabelCutoutPaddingPx;
        rectF.right += this.boxLabelCutoutPaddingPx;
        rectF.bottom += this.boxLabelCutoutPaddingPx;
    }

    boolean cutoutIsOpen() {
        return cutoutEnabled() && ((com.google.android.material.textfield.a) this.boxBackground).a();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.inDrawableStateChanged) {
            return;
        }
        this.inDrawableStateChanged = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        updateLabelState(v.x(this) && isEnabled());
        updateEditTextBackground();
        updateTextInputBoxBounds();
        updateTextInputBoxState();
        com.google.android.material.internal.b bVar = this.collapsingTextHelper;
        if (bVar != null ? bVar.a(drawableState) | false : false) {
            invalidate();
        }
        this.inDrawableStateChanged = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateTextInputBoxState() {
        TextView textView;
        if (this.boxBackground == null || this.boxBackgroundMode == 0) {
            return;
        }
        EditText editText = this.editText;
        boolean z = editText != null && editText.hasFocus();
        EditText editText2 = this.editText;
        boolean z2 = editText2 != null && editText2.isHovered();
        if (this.boxBackgroundMode == 2) {
            if (!isEnabled()) {
                this.boxStrokeColor = this.disabledColor;
            } else if (this.indicatorViewController.g()) {
                this.boxStrokeColor = this.indicatorViewController.k();
            } else if (this.counterOverflowed && (textView = this.counterView) != null) {
                this.boxStrokeColor = textView.getCurrentTextColor();
            } else if (z) {
                this.boxStrokeColor = this.focusedStrokeColor;
            } else if (z2) {
                this.boxStrokeColor = this.hoveredStrokeColor;
            } else {
                this.boxStrokeColor = this.defaultStrokeColor;
            }
            if ((z2 || z) && isEnabled()) {
                this.boxStrokeWidthPx = this.boxStrokeWidthFocusedPx;
            } else {
                this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
            }
            applyBoxAttributes();
        }
    }

    private void expandHint(boolean z) {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.animator.cancel();
        }
        if (z && this.hintAnimationEnabled) {
            animateToExpansionFraction(0.0f);
        } else {
            this.collapsingTextHelper.b(0.0f);
        }
        if (cutoutEnabled() && ((com.google.android.material.textfield.a) this.boxBackground).a()) {
            closeCutout();
        }
        this.hintExpanded = true;
    }

    void animateToExpansionFraction(float f) {
        if (this.collapsingTextHelper.e() == f) {
            return;
        }
        if (this.animator == null) {
            this.animator = new ValueAnimator();
            this.animator.setInterpolator(com.google.android.material.a.a.b);
            this.animator.setDuration(167L);
            this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.TextInputLayout.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    TextInputLayout.this.collapsingTextHelper.b(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        this.animator.setFloatValues(this.collapsingTextHelper.e(), f);
        this.animator.start();
    }

    final boolean isHintExpanded() {
        return this.hintExpanded;
    }

    final boolean isHelperTextDisplayed() {
        return this.indicatorViewController.h();
    }

    final int getHintCurrentCollapsedTextColor() {
        return this.collapsingTextHelper.f();
    }

    final float getHintCollapsedTextHeight() {
        return this.collapsingTextHelper.b();
    }

    final int getErrorTextCurrentColor() {
        return this.indicatorViewController.k();
    }

    /* loaded from: classes2.dex */
    public static class a extends androidx.core.f.a {

        /* renamed from: a, reason: collision with root package name */
        private final TextInputLayout f5339a;

        public a(TextInputLayout textInputLayout) {
            this.f5339a = textInputLayout;
        }

        @Override // androidx.core.f.a
        public void a(View view, androidx.core.f.a.d dVar) {
            super.a(view, dVar);
            EditText editText = this.f5339a.getEditText();
            Editable text = editText != null ? editText.getText() : null;
            CharSequence hint = this.f5339a.getHint();
            CharSequence error = this.f5339a.getError();
            CharSequence counterOverflowDescription = this.f5339a.getCounterOverflowDescription();
            boolean z = !TextUtils.isEmpty(text);
            boolean z2 = !TextUtils.isEmpty(hint);
            boolean z3 = !TextUtils.isEmpty(error);
            boolean z4 = false;
            boolean z5 = z3 || !TextUtils.isEmpty(counterOverflowDescription);
            if (z) {
                dVar.b((CharSequence) text);
            } else if (z2) {
                dVar.b(hint);
            }
            if (z2) {
                dVar.d(hint);
                if (!z && z2) {
                    z4 = true;
                }
                dVar.g(z4);
            }
            if (z5) {
                if (!z3) {
                    error = counterOverflowDescription;
                }
                dVar.e(error);
                dVar.d(true);
            }
        }

        @Override // androidx.core.f.a
        public void c(View view, AccessibilityEvent accessibilityEvent) {
            super.c(view, accessibilityEvent);
            EditText editText = this.f5339a.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            if (TextUtils.isEmpty(text)) {
                text = this.f5339a.getHint();
            }
            if (TextUtils.isEmpty(text)) {
                return;
            }
            accessibilityEvent.getText().add(text);
        }
    }
}
