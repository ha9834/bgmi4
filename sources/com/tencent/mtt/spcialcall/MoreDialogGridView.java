package com.tencent.mtt.spcialcall;

import android.R;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.mtt.common.utils.MttResources;
import com.tencent.mtt.spcialcall.sdk.ExtendItem;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class MoreDialogGridView extends DialogSp implements View.OnClickListener {
    private TextView mCancel;
    LinearLayout mFrame;
    private GridView mGridView;

    public MoreDialogGridView(Context context, IWebViewClientSp iWebViewClientSp) {
        super(context, iWebViewClientSp);
        this.mFrame = new LinearLayout(getContext());
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
        this.mFrame.setOrientation(1);
        this.mFrame.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.mFrame.setBackgroundDrawable(this.mRes.getDrawable(MttResources.getDrawableId("thrdcall_action_sheet_base_9")));
        this.mGridView = new GridView(getContext());
        this.mGridView.setNumColumns(3);
        this.mGridView.setAdapter((ListAdapter) new MoreListAdapter(this.mMoreItems));
        this.mGridView.setStretchMode(2);
        this.mCancel = createMenuBtn(new ExtendItem(0, this.mRes.getString(MttResources.getStringId("thrdcall_cancel"))));
        this.mCancel.setOnClickListener(this);
        this.mFrame.addView(this.mGridView, new LinearLayout.LayoutParams(-1, -1));
        this.mFrame.addView(this.mCancel);
        setContentView(this.mFrame);
        setPadding();
        this.mGridView.requestFocus();
    }

    private Button createMenuBtn(ExtendItem extendItem) {
        Button button = new Button(getContext());
        button.setTag(extendItem);
        button.setText(extendItem.getLabel());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.mRes.getDimensionPixelSize(MttResources.getDimensId("thrdcall_menu_btn_height")));
        layoutParams.gravity = 1;
        button.setTextSize(1, 18.0f);
        layoutParams.topMargin = this.mRes.getDimensionPixelSize(MttResources.getDimensId("thrdcall_menu_btn_inner_cancel_margin"));
        button.setTextColor(this.mRes.getColor(MttResources.getColorId("thrdcall_white")));
        button.setBackgroundDrawable(getStateDrawable(this.mRes.getDrawable(MttResources.getDrawableId("thrdcall_action_sheet_button_cancel_normal")), this.mRes.getDrawable(MttResources.getDrawableId("thrdcall_action_sheet_button_cancel_click"))));
        button.setLayoutParams(layoutParams);
        button.setOnClickListener(this);
        return button;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class MoreListAdapter extends BaseAdapter {
        private ArrayList<ExtendItem> items;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        public MoreListAdapter(ArrayList<ExtendItem> arrayList) {
            this.items = arrayList;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.items.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.items.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ExtendItem extendItem = this.items.get(i);
            if (view == null || view.getTag() == null) {
                int textColor = extendItem.getTextColor() == 0 ? -4276546 : extendItem.getTextColor();
                int textSize = extendItem.getTextSize() == 0 ? 10 : extendItem.getTextSize();
                CharSequence label = extendItem.getLabel();
                Drawable initTransDrawable = ThemeSwitcher.initTransDrawable(MoreDialogGridView.this.getContext(), extendItem);
                if (initTransDrawable != null) {
                    extendItem.setImage(initTransDrawable);
                }
                view = MoreDialogGridView.this.createListItem(label, initTransDrawable, textColor, textSize);
                view.setLayoutParams(new AbsListView.LayoutParams(-1, MoreDialogGridView.this.mRes.getDimensionPixelOffset(MttResources.getDimensId("thrdcall_grid_item_height"))));
                view.setTag(extendItem);
            } else {
                if (extendItem.getImage() != null) {
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(extendItem.getImage());
                    int dimensionPixelOffset = MoreDialogGridView.this.mRes.getDimensionPixelOffset(MttResources.getDimensId("thrdcall_grid_item_icon_height"));
                    bitmapDrawable.setBounds(0, 0, dimensionPixelOffset, dimensionPixelOffset);
                    ((TextView) view).setCompoundDrawables(null, bitmapDrawable, null, null);
                }
                ((TextView) view).setText(extendItem.getLabel());
            }
            view.setId(extendItem.getID());
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mtt.spcialcall.MoreDialogGridView.MoreListAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    MoreDialogGridView.this.onExtendItemOnClick(view2);
                    MoreDialogGridView.this.dismiss();
                }
            });
            return view;
        }

        /* loaded from: classes.dex */
        public class ViewHodler {
            public Drawable icon;
            public int id;
            public CharSequence label;

            public ViewHodler() {
            }
        }
    }

    public View createListItem(CharSequence charSequence, Drawable drawable, int i, int i2) {
        TextView textView = new TextView(getContext());
        textView.setGravity(1);
        if (drawable == null) {
            drawable = this.mRes.getDrawable(MttResources.getDrawableId("thrdcall_action_sheet_button_normal"));
        }
        int dimensionPixelOffset = this.mRes.getDimensionPixelOffset(MttResources.getDimensId("thrdcall_grid_item_icon_height"));
        drawable.setBounds(0, 0, dimensionPixelOffset, dimensionPixelOffset);
        textView.setCompoundDrawables(null, drawable, null, null);
        textView.setCompoundDrawablePadding(this.mRes.getDimensionPixelOffset(MttResources.getDimensId("thrdcall_menu_item_icon_top_padding")));
        textView.setClickable(true);
        textView.setFocusable(true);
        textView.setTextColor(i);
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        textView.setText(charSequence);
        textView.setContentDescription(charSequence);
        textView.setTextSize(2, i2);
        return textView;
    }

    @Override // com.tencent.mtt.spcialcall.DialogSp
    public boolean switchTheme() {
        if (ExtraInfo.getExtraThemeItem() == null || ExtraInfo.getExtraThemeItem().size() <= 0) {
            return false;
        }
        Iterator<ExtendItem> it = ExtraInfo.getExtraThemeItem().iterator();
        while (it.hasNext()) {
            ExtendItem next = it.next();
            int id = next.getID();
            if (id == 20) {
                ThemeSwitcher.doSwitch(this.mFrame, next);
            } else if (id == 22) {
                ThemeSwitcher.doSwitch(this.mCancel, next);
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

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
        if (view != this.mCancel && (view.getTag() instanceof ExtendItem)) {
            onExtendItemOnClick(view);
        }
    }
}
