package com.helpshift.support.conversations.messages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import com.helpshift.R;
import com.helpshift.conversation.activeconversation.message.HistoryLoadingState;
import com.helpshift.support.util.Styles;

/* loaded from: classes2.dex */
public class HistoryLoadingViewBinder {
    private Context context;
    private HistoryLoadingClickListener historyLoadingClickListener;

    /* loaded from: classes2.dex */
    public interface HistoryLoadingClickListener {
        void onHistoryLoadingRetryClicked();
    }

    public HistoryLoadingViewBinder(Context context) {
        this.context = context;
    }

    public ViewHolder createViewHolder(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hs__history_loading_view_layout, viewGroup, false));
    }

    public void bind(ViewHolder viewHolder, HistoryLoadingState historyLoadingState) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        switch (historyLoadingState) {
            case NONE:
                z = false;
                z3 = false;
                z2 = false;
                break;
            case LOADING:
                z = true;
                z2 = false;
                break;
            case ERROR:
                z = false;
                z2 = true;
                break;
            default:
                z = false;
                z2 = false;
                break;
        }
        viewHolder.layoutView.setVisibility(z3 ? 0 : 8);
        viewHolder.loadingStateView.setVisibility(z ? 0 : 8);
        viewHolder.errorStateView.setVisibility(z2 ? 0 : 8);
    }

    public void setHistoryLoadingClickListener(HistoryLoadingClickListener historyLoadingClickListener) {
        this.historyLoadingClickListener = historyLoadingClickListener;
    }

    /* loaded from: classes2.dex */
    public class ViewHolder extends RecyclerView.w implements View.OnClickListener {
        private final View errorStateView;
        private final View layoutView;
        private final View loadingErrorTapToRetry;
        private final View loadingStateView;
        private final ProgressBar progress;

        public ViewHolder(View view) {
            super(view);
            this.layoutView = this.itemView.findViewById(R.id.history_loading_layout_view);
            this.loadingStateView = this.itemView.findViewById(R.id.loading_state_view);
            this.errorStateView = this.itemView.findViewById(R.id.loading_error_state_view);
            this.loadingErrorTapToRetry = this.itemView.findViewById(R.id.loading_error_tap_to_retry);
            this.loadingErrorTapToRetry.setOnClickListener(this);
            this.progress = (ProgressBar) this.itemView.findViewById(R.id.loading_progressbar);
            Styles.setAccentColor(HistoryLoadingViewBinder.this.context, this.progress.getIndeterminateDrawable());
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (HistoryLoadingViewBinder.this.historyLoadingClickListener != null) {
                HistoryLoadingViewBinder.this.historyLoadingClickListener.onHistoryLoadingRetryClicked();
            }
        }
    }
}
