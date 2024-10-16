package com.helpshift.support.conversations.messages;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.a;
import androidx.recyclerview.widget.RecyclerView;
import com.helpshift.R;
import com.helpshift.conversation.activeconversation.message.ConversationFooterState;
import com.helpshift.support.widget.CSATView;
import com.helpshift.util.Styles;

/* loaded from: classes2.dex */
public class ConversationFooterViewBinder {
    private Context context;
    ConversationFooterClickListener footerClickListener;

    /* loaded from: classes2.dex */
    public interface ConversationFooterClickListener {
        void onCSATSurveyCancelled();

        void onCSATSurveyStarted();

        void onCSATSurveySubmitted(int i, String str);

        void onStartNewConversationButtonClick();
    }

    public ConversationFooterViewBinder(Context context) {
        this.context = context;
    }

    public ViewHolder createViewHolder(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hs__messages_list_footer, viewGroup, false));
    }

    public void bind(ViewHolder viewHolder, ConversationFooterState conversationFooterState) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        String string = this.context.getResources().getString(R.string.hs__conversation_end_msg);
        boolean z6 = true;
        switch (conversationFooterState) {
            case NONE:
                z = false;
                z6 = false;
                z2 = false;
                z3 = false;
                z4 = false;
                z5 = false;
                break;
            case CONVERSATION_ENDED_MESSAGE:
                string = this.context.getResources().getString(R.string.hs__confirmation_footer_msg);
                z = true;
                z2 = false;
                z3 = false;
                z4 = false;
                z5 = false;
                break;
            case START_NEW_CONVERSATION:
                z = true;
                z2 = true;
                z3 = false;
                z4 = false;
                z5 = false;
                break;
            case CSAT_RATING:
                string = this.context.getResources().getString(R.string.hs__confirmation_footer_msg);
                z = true;
                z2 = true;
                z3 = true;
                z4 = false;
                z5 = false;
                break;
            case ARCHIVAL_MESSAGE:
                z = false;
                z2 = true;
                z3 = false;
                z4 = true;
                z5 = false;
                break;
            case AUTHOR_MISMATCH:
                z = false;
                z2 = true;
                z3 = false;
                z4 = false;
                z5 = true;
                break;
            case REJECTED_MESSAGE:
                string = this.context.getResources().getString(R.string.hs__conversation_rejected_status);
                z = true;
                z2 = true;
                z3 = false;
                z4 = false;
                z5 = false;
                break;
            case REDACTED_STATE:
                z = false;
                z2 = true;
                z3 = false;
                z4 = false;
                z5 = false;
                break;
            default:
                z = true;
                z2 = false;
                z3 = false;
                z4 = false;
                z5 = false;
                break;
        }
        if (z6) {
            viewHolder.conversationFooter.setVisibility(0);
            if (z) {
                viewHolder.footerMessage.setText(string);
                viewHolder.footerMessage.setVisibility(0);
            } else {
                viewHolder.footerMessage.setVisibility(8);
            }
            if (z2) {
                viewHolder.newConversationBox.setVisibility(0);
                viewHolder.newConversationButton.setOnClickListener(viewHolder);
            } else {
                viewHolder.newConversationBox.setVisibility(8);
                viewHolder.newConversationBox.setOnClickListener(null);
            }
            if (z3) {
                viewHolder.csatView.setVisibility(0);
                viewHolder.csatView.setCSATListener(viewHolder);
            } else {
                viewHolder.csatView.hideCSATDialog();
                viewHolder.csatView.setVisibility(8);
                viewHolder.csatView.setCSATListener(null);
            }
            if (z4) {
                viewHolder.newConversationReason.setVisibility(0);
                viewHolder.newConversationReason.setText(R.string.hs__issue_archival_message);
                return;
            } else if (z5) {
                viewHolder.newConversationReason.setVisibility(0);
                viewHolder.newConversationReason.setText(R.string.hs__new_conversation_footer_generic_reason);
                return;
            } else {
                viewHolder.newConversationReason.setVisibility(8);
                return;
            }
        }
        viewHolder.conversationFooter.setVisibility(8);
    }

    public void setConversationFooterClickListener(ConversationFooterClickListener conversationFooterClickListener) {
        this.footerClickListener = conversationFooterClickListener;
    }

    /* loaded from: classes2.dex */
    public final class ViewHolder extends RecyclerView.w implements View.OnClickListener, CSATView.CSATListener {
        final View conversationFooter;
        final CSATView csatView;
        final TextView footerMessage;
        final LinearLayout newConversationBox;
        final Button newConversationButton;
        final TextView newConversationReason;

        public ViewHolder(View view) {
            super(view);
            this.conversationFooter = view;
            this.footerMessage = (TextView) view.findViewById(R.id.footer_message);
            this.newConversationBox = (LinearLayout) view.findViewById(R.id.hs__new_conversation);
            this.newConversationButton = (Button) view.findViewById(R.id.hs__new_conversation_btn);
            this.csatView = (CSATView) view.findViewById(R.id.csat_view_layout);
            this.newConversationReason = (TextView) view.findViewById(R.id.hs__new_conversation_footer_reason);
            setBorderToNewConversationButton();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ConversationFooterViewBinder.this.footerClickListener != null) {
                ConversationFooterViewBinder.this.footerClickListener.onStartNewConversationButtonClick();
            }
        }

        @Override // com.helpshift.support.widget.CSATView.CSATListener
        public void onCSATSurveyStarted() {
            if (ConversationFooterViewBinder.this.footerClickListener != null) {
                ConversationFooterViewBinder.this.footerClickListener.onCSATSurveyStarted();
            }
        }

        @Override // com.helpshift.support.widget.CSATView.CSATListener
        public void onCSATSurveyCancelled() {
            if (ConversationFooterViewBinder.this.footerClickListener != null) {
                ConversationFooterViewBinder.this.footerClickListener.onCSATSurveyCancelled();
            }
        }

        @Override // com.helpshift.support.widget.CSATView.CSATListener
        public void sendCSATSurvey(int i, String str) {
            if (ConversationFooterViewBinder.this.footerClickListener != null) {
                ConversationFooterViewBinder.this.footerClickListener.onCSATSurveySubmitted(i, str);
            }
        }

        private void setBorderToNewConversationButton() {
            GradientDrawable gradientDrawable = (GradientDrawable) a.a(ConversationFooterViewBinder.this.context, R.drawable.hs__button_with_border);
            gradientDrawable.setStroke((int) Styles.dpToPx(ConversationFooterViewBinder.this.context, 1.0f), Styles.getColor(ConversationFooterViewBinder.this.context, R.attr.colorAccent));
            gradientDrawable.setColor(Styles.getColor(ConversationFooterViewBinder.this.context, R.attr.hs__footerPromptBackground));
            int dpToPx = (int) Styles.dpToPx(ConversationFooterViewBinder.this.context, 4.0f);
            int dpToPx2 = (int) Styles.dpToPx(ConversationFooterViewBinder.this.context, 6.0f);
            InsetDrawable insetDrawable = new InsetDrawable((Drawable) gradientDrawable, dpToPx, dpToPx2, dpToPx, dpToPx2);
            if (Build.VERSION.SDK_INT >= 16) {
                this.newConversationButton.setBackground(insetDrawable);
            } else {
                this.newConversationButton.setBackgroundDrawable(insetDrawable);
            }
        }
    }
}
