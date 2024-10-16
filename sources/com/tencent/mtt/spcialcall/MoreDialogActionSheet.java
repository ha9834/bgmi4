package com.tencent.mtt.spcialcall;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.mtt.common.utils.MttResources;
import com.tencent.mtt.spcialcall.sdk.ExtendItem;
import java.util.Iterator;

/* loaded from: classes.dex */
public class MoreDialogActionSheet extends DialogSp implements View.OnClickListener {
    private Button[] mBtns;
    private Button mCancel;
    private LinearLayout mFrame;

    public MoreDialogActionSheet(Context context, IWebViewClientSp iWebViewClientSp) {
        super(context, iWebViewClientSp);
        initWindow();
        addExtendItems();
        addSystemItems();
        initUI();
        switchTheme();
    }

    private void initWindow() {
        requestWindowFeature(1);
        Window window = getWindow();
        window.setWindowAnimations(MttResources.getStyleId("shareInputAnimationStyle"));
        window.setBackgroundDrawableResource(MttResources.getColorId("thrdcall_transparent"));
        window.addFlags(2);
        setCanceledOnTouchOutside(false);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 80;
        attributes.dimAmount = 0.5f;
        window.setAttributes(attributes);
    }

    public void initUI() {
        this.mFrame = new LinearLayout(getContext());
        this.mFrame.setBackgroundDrawable(this.mRes.getDrawable(MttResources.getDrawableId("thrdcall_action_sheet_base_9")));
        setContentView(this.mFrame);
        this.mFrame.setOrientation(1);
        this.mBtns = new Button[this.mMoreItems.size()];
        for (int i = 0; i < this.mMoreItems.size(); i++) {
            this.mBtns[i] = addMenuBtn(this.mMoreItems.get(i));
        }
        this.mCancel = addMenuBtn(new ExtendItem(0, this.mRes.getString(MttResources.getStringId("thrdcall_cancel"))));
        setPadding();
    }

    private Button addMenuBtn(ExtendItem extendItem) {
        Button button = new Button(getContext());
        button.setTag(extendItem);
        button.setText(extendItem.getLabel());
        button.setContentDescription(extendItem.getLabel());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.mRes.getDimensionPixelSize(MttResources.getDimensId("thrdcall_menu_btn_height")));
        layoutParams.gravity = 1;
        button.setTextSize(1, 16.0f);
        if (extendItem.getLabel().equals(this.mRes.getString(MttResources.getStringId("thrdcall_cancel")))) {
            layoutParams.topMargin = this.mRes.getDimensionPixelSize(MttResources.getDimensId("thrdcall_menu_btn_inner_cancel_margin"));
            button.setTextColor(this.mRes.getColor(MttResources.getColorId("thrdcall_white")));
            button.setBackgroundDrawable(getStateDrawable(this.mRes.getDrawable(MttResources.getDrawableId("thrdcall_action_sheet_button_cancel_normal")), this.mRes.getDrawable(MttResources.getDrawableId("thrdcall_action_sheet_button_cancel_click"))));
        } else {
            layoutParams.bottomMargin = this.mRes.getDimensionPixelSize(MttResources.getDimensId("thrdcall_menu_btn_inner_margin"));
            button.setTextColor(this.mRes.getColor(MttResources.getColorId("thrdcall_menu_text_color")));
            button.setBackgroundDrawable(getStateDrawable(this.mRes.getDrawable(MttResources.getDrawableId("thrdcall_action_sheet_button_normal")), this.mRes.getDrawable(MttResources.getDrawableId("thrdcall_action_sheet_button_click"))));
        }
        button.setLayoutParams(layoutParams);
        button.setOnClickListener(this);
        this.mFrame.addView(button);
        return button;
    }

    @Override // com.tencent.mtt.spcialcall.DialogSp
    public boolean switchTheme() {
        if (ExtraInfo.getExtraThemeItem() == null || ExtraInfo.getExtraThemeItem().size() <= 0) {
            return false;
        }
        Iterator<ExtendItem> it = ExtraInfo.getExtraThemeItem().iterator();
        while (it.hasNext()) {
            ExtendItem next = it.next();
            switch (next.getID()) {
                case 20:
                    ThemeSwitcher.doSwitch(this.mFrame, next);
                    break;
                case 21:
                    for (Button button : this.mBtns) {
                        ThemeSwitcher.doSwitch(button, next);
                    }
                    break;
                case 22:
                    ThemeSwitcher.doSwitch(this.mCancel, next);
                    break;
            }
        }
        setPadding();
        return true;
    }

    public void setPadding() {
        int dimensionPixelOffset = this.mRes.getDimensionPixelOffset(MttResources.getDimensId("thrdcall_menu_padding_top"));
        int dimensionPixelOffset2 = this.mRes.getDimensionPixelOffset(MttResources.getDimensId("thrdcall_menu_padding_lr"));
        this.mFrame.setPadding(dimensionPixelOffset2, dimensionPixelOffset, dimensionPixelOffset2, this.mRes.getDimensionPixelOffset(MttResources.getDimensId("thrdcall_menu_padding_bottom")));
    }

    private StateListDrawable getStateDrawable(Drawable drawable, Drawable drawable2) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_enabled, R.attr.state_focused}, drawable2);
        stateListDrawable.addState(new int[]{R.attr.state_pressed, R.attr.state_enabled}, drawable2);
        stateListDrawable.addState(new int[]{R.attr.state_focused}, drawable2);
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, drawable2);
        stateListDrawable.addState(new int[]{R.attr.state_enabled}, drawable);
        stateListDrawable.addState(new int[0], drawable);
        return stateListDrawable;
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        getWindow().setLayout(-1, -2);
    }

    public void onClick(View view) {
        if (view.getTag() instanceof ExtendItem) {
            onExtendItemOnClick(view);
        }
        dismiss();
    }
}
