package com.helpshift.support.conversations.messages;

import android.content.Context;
import com.helpshift.R;
import com.helpshift.configuration.domainmodel.SDKConfigurationDM;
import com.helpshift.conversation.activeconversation.message.Author;
import com.helpshift.conversation.activeconversation.message.MessageDM;
import com.helpshift.support.imageloader.ImageLoader;
import com.helpshift.util.HelpshiftContext;
import com.helpshift.util.StringUtils;
import com.helpshift.util.ValuePair;
import com.helpshift.views.CircleImageView;

/* loaded from: classes2.dex */
public class AvatarImageLoader {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void loadAvatarImageAccordingToState(Context context, MessageDM messageDM, CircleImageView circleImageView) {
        SDKConfigurationDM sDKConfigurationDM = HelpshiftContext.getCoreApi().getSDKConfigurationDM();
        MessageDM.AvatarImageDownloadState avatarImageState = messageDM.getAvatarImageState();
        int localFallbackImage = getLocalFallbackImage(messageDM.author.role);
        ValuePair<String, String> authorAvatarActualImage = getAuthorAvatarActualImage(messageDM);
        String str = authorAvatarActualImage.first;
        String str2 = authorAvatarActualImage.second;
        int width = circleImageView.getWidth();
        if (width == 0) {
            width = context.getResources().getDimensionPixelSize(R.dimen.hs__author_avatar_size);
        }
        switch (avatarImageState) {
            case AVATAR_IMAGE_DOWNLOAD_FAILED:
            case AVATAR_IMAGE_NOT_PRESENT:
            case AVATAR_IMAGE_DOWNLOADING:
                if (StringUtils.isNotEmpty(str2)) {
                    circleImageView.setTag(getFallbackImageURL(messageDM.author.role));
                    ImageLoader.getInstance().loadImageWithoutSampling(str2, circleImageView, context.getResources().getDrawable(localFallbackImage), width);
                    return;
                } else {
                    circleImageView.setTag(Integer.valueOf(localFallbackImage));
                    circleImageView.setImageResource(localFallbackImage);
                    return;
                }
            case AVATAR_IMAGE_DOWNLOADED:
                circleImageView.setTag(sDKConfigurationDM.getAvatarImageUrl(messageDM.author.authorId));
                ImageLoader.getInstance().loadImageWithoutSampling(str, circleImageView, context.getResources().getDrawable(localFallbackImage), width);
                return;
            default:
                return;
        }
    }

    private static ValuePair<String, String> getAuthorAvatarActualImage(MessageDM messageDM) {
        String str;
        String authorAvatarFallbackImage = messageDM.getAuthorAvatarFallbackImage();
        Author.AuthorRole authorRole = messageDM.author.role;
        if (authorRole == Author.AuthorRole.AGENT && messageDM.shouldShowPersonalisedAgentAvatar()) {
            str = messageDM.author.localAvatarImagePath;
        } else if (authorRole == Author.AuthorRole.BOT && messageDM.shouldShowPersonalisedBotAvatar()) {
            str = messageDM.author.localAvatarImagePath;
        } else {
            Author.AuthorRole authorRole2 = Author.AuthorRole.SYSTEM;
            str = authorAvatarFallbackImage;
        }
        return new ValuePair<>(str, authorAvatarFallbackImage);
    }

    private static int getLocalFallbackImage(Author.AuthorRole authorRole) {
        switch (authorRole) {
            case SYSTEM:
                return R.drawable.hs__default_support_avatar;
            case BOT:
                return R.drawable.hs__default_bot_avatar;
            case AGENT:
                return R.drawable.hs__default_agent_avatar;
            default:
                return R.drawable.hs__default_support_avatar;
        }
    }

    public static void loadConversationHeaderAvatarImage(Context context, CircleImageView circleImageView, String str) {
        if (StringUtils.isNotEmpty(str)) {
            ImageLoader.getInstance().loadImageWithoutSampling(str, circleImageView, context.getResources().getDrawable(R.drawable.hs__default_support_avatar), circleImageView.getWidth() == 0 ? context.getResources().getDimensionPixelSize(R.dimen.hs__author_avatar_size) : circleImageView.getWidth());
        } else {
            circleImageView.setImageResource(R.drawable.hs__default_support_avatar);
        }
    }

    private static String getFallbackImageURL(Author.AuthorRole authorRole) {
        SDKConfigurationDM sDKConfigurationDM = HelpshiftContext.getCoreApi().getSDKConfigurationDM();
        switch (authorRole) {
            case BOT:
                return sDKConfigurationDM.getBotFallbackImageUrl();
            case AGENT:
                return sDKConfigurationDM.getAgentFallbackImageUrl();
            default:
                return sDKConfigurationDM.getConversationHeaderImageUrl();
        }
    }
}
