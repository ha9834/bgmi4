package kotlin.text;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;

/* loaded from: classes3.dex */
public final class k {
    /* JADX INFO: Access modifiers changed from: private */
    public static final i b(Matcher matcher, int i, CharSequence charSequence) {
        if (matcher.find(i)) {
            return new j(matcher, charSequence);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.d.c b(MatchResult matchResult) {
        return kotlin.d.d.b(matchResult.start(), matchResult.end());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.d.c b(MatchResult matchResult, int i) {
        return kotlin.d.d.b(matchResult.start(i), matchResult.end(i));
    }
}
