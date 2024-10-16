package com.helpshift.support.conversations.picker;

import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.helpshift.R;
import com.helpshift.conversation.viewmodel.HSRange;
import com.helpshift.conversation.viewmodel.OptionUIModel;
import com.helpshift.support.conversations.ConversationalFragmentRouter;
import com.helpshift.util.ListUtils;
import com.helpshift.util.Styles;
import java.util.List;

/* loaded from: classes2.dex */
public class PickerAdapter extends RecyclerView.a<ViewHolder> {
    ConversationalFragmentRouter conversationalFragmentRouter;
    private List<OptionUIModel> options;

    public PickerAdapter(List<OptionUIModel> list, ConversationalFragmentRouter conversationalFragmentRouter) {
        this.options = list;
        this.conversationalFragmentRouter = conversationalFragmentRouter;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hs__picker_option, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        OptionUIModel optionUIModel = this.options.get(i);
        String str = optionUIModel.option.title;
        if (ListUtils.isEmpty(optionUIModel.titleHighlightInfo)) {
            viewHolder.optionView.setText(str);
        } else {
            int color = Styles.getColor(viewHolder.optionView.getContext(), R.attr.hs__searchHighlightColor);
            SpannableString spannableString = new SpannableString(str);
            for (HSRange hSRange : optionUIModel.titleHighlightInfo) {
                spannableString.setSpan(new BackgroundColorSpan(color), hSRange.index, hSRange.index + hSRange.length, 33);
            }
            viewHolder.optionView.setText(spannableString);
        }
        viewHolder.layoutView.setContentDescription(viewHolder.optionView.getContext().getString(R.string.hs__picker_option_list_item_voice_over, str));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int getItemCount() {
        return this.options.size();
    }

    public void dispatchUpdates(List<OptionUIModel> list) {
        this.options.clear();
        this.options.addAll(list);
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class ViewHolder extends RecyclerView.w implements View.OnClickListener {
        private final View layoutView;
        private final TextView optionView;

        public ViewHolder(View view) {
            super(view);
            this.optionView = (TextView) this.itemView.findViewById(R.id.hs__option);
            this.layoutView = this.itemView.findViewById(R.id.option_list_item_layout);
            this.layoutView.setOnClickListener(this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PickerAdapter.this.conversationalFragmentRouter != null) {
                PickerAdapter.this.conversationalFragmentRouter.handleOptionSelectedForPicker((OptionUIModel) PickerAdapter.this.options.get(getAdapterPosition()), false);
            }
        }
    }
}
