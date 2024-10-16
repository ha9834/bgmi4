package com.helpshift.support.conversations.messages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.helpshift.R;
import com.helpshift.support.util.Styles;

/* loaded from: classes2.dex */
public class AgentTypingMessageDataBinder {
    private Context context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AgentTypingMessageDataBinder(Context context) {
        this.context = context;
    }

    public RecyclerView.w createViewHolder(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.hs__msg_agent_typing, viewGroup, false);
        Styles.setAdminChatBubbleColor(this.context, inflate.findViewById(R.id.agent_typing_container).getBackground());
        return new ViewHolder(inflate);
    }

    public void bind(ViewHolder viewHolder, boolean z) {
        if (z) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewHolder.typingContainer.getLayoutParams();
            marginLayoutParams.setMargins((int) this.context.getResources().getDimension(R.dimen.hs__author_avatar_size), marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }
    }

    /* loaded from: classes2.dex */
    public final class ViewHolder extends RecyclerView.w {
        LinearLayout typingContainer;

        public ViewHolder(View view) {
            super(view);
            this.typingContainer = (LinearLayout) view.findViewById(R.id.agent_typing_container);
        }
    }
}
