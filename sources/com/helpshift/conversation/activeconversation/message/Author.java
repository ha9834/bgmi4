package com.helpshift.conversation.activeconversation.message;

import com.helpshift.analytics.AnalyticsEventKey;
import com.helpshift.util.HSCloneable;

/* loaded from: classes2.dex */
public class Author implements HSCloneable {
    public final String authorId;
    public String authorName;
    public String localAvatarImagePath;
    public final AuthorRole role;

    public Author(String str, String str2, AuthorRole authorRole) {
        this.authorName = str;
        this.authorId = str2;
        this.role = authorRole;
    }

    public Author(Author author) {
        this.authorName = author.authorName;
        this.authorId = author.authorId;
        this.role = author.role;
        this.localAvatarImagePath = author.localAvatarImagePath;
    }

    /* loaded from: classes2.dex */
    public enum AuthorRole {
        AGENT(AnalyticsEventKey.ACTION_SHA),
        BOT("b"),
        SYSTEM(AnalyticsEventKey.SEARCH_QUERY),
        LOCAL_USER("local_user");

        private final String roleName;

        AuthorRole(String str) {
            this.roleName = str;
        }

        public static AuthorRole getEnum(String str) {
            for (AuthorRole authorRole : values()) {
                if (authorRole.roleName.equals(str)) {
                    return authorRole;
                }
            }
            return SYSTEM;
        }

        public String getValue() {
            return this.roleName;
        }
    }

    @Override // com.helpshift.util.HSCloneable
    public Author deepClone() {
        return new Author(this);
    }

    public boolean equals(Object obj) {
        Author author = (Author) obj;
        return author != null && author.authorName.equals(this.authorName) && author.authorId.equals(this.authorId) && author.role == this.role;
    }
}
