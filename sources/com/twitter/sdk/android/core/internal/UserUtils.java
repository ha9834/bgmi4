package com.twitter.sdk.android.core.internal;

import android.text.TextUtils;
import com.tencent.imsdk.android.IR;
import com.twitter.sdk.android.core.models.User;

/* loaded from: classes.dex */
public final class UserUtils {
    private UserUtils() {
    }

    /* loaded from: classes.dex */
    public enum AvatarSize {
        NORMAL("_normal"),
        BIGGER("_bigger"),
        MINI("_mini"),
        ORIGINAL("_original"),
        REASONABLY_SMALL("_reasonably_small");

        private final String suffix;

        AvatarSize(String str) {
            this.suffix = str;
        }

        String getSuffix() {
            return this.suffix;
        }
    }

    public static String getProfileImageUrlHttps(User user, AvatarSize avatarSize) {
        if (user == null || user.profileImageUrlHttps == null) {
            return null;
        }
        String str = user.profileImageUrlHttps;
        if (avatarSize == null || str == null) {
            return str;
        }
        switch (avatarSize) {
            case NORMAL:
            case BIGGER:
            case MINI:
            case ORIGINAL:
            case REASONABLY_SMALL:
                return str.replace(AvatarSize.NORMAL.getSuffix(), avatarSize.getSuffix());
            default:
                return str;
        }
    }

    public static CharSequence formatScreenName(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return "";
        }
        if (charSequence.charAt(0) == '@') {
            return charSequence;
        }
        return IR.account.EMAIL_TAG + ((Object) charSequence);
    }
}
