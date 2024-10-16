package com.twitter.sdk.android.core.internal.network;

import com.twitter.sdk.android.core.GuestSession;
import com.twitter.sdk.android.core.GuestSessionProvider;
import com.twitter.sdk.android.core.internal.oauth.GuestAuthToken;
import com.twitter.sdk.android.core.internal.oauth.OAuth2Token;
import java.io.IOException;
import okhttp3.ab;
import okhttp3.ad;
import okhttp3.b;
import okhttp3.s;
import okhttp3.z;

/* loaded from: classes.dex */
public class GuestAuthenticator implements b {
    static final int MAX_RETRIES = 2;
    final GuestSessionProvider guestSessionProvider;

    public GuestAuthenticator(GuestSessionProvider guestSessionProvider) {
        this.guestSessionProvider = guestSessionProvider;
    }

    @Override // okhttp3.b
    public z authenticate(ad adVar, ab abVar) throws IOException {
        return reauth(abVar);
    }

    z reauth(ab abVar) {
        if (canRetry(abVar)) {
            GuestSession refreshCurrentSession = this.guestSessionProvider.refreshCurrentSession(getExpiredSession(abVar));
            GuestAuthToken authToken = refreshCurrentSession == null ? null : refreshCurrentSession.getAuthToken();
            if (authToken != null) {
                return resign(abVar.a(), authToken);
            }
        }
        return null;
    }

    GuestSession getExpiredSession(ab abVar) {
        s c = abVar.a().c();
        String a2 = c.a("Authorization");
        String a3 = c.a("x-guest-token");
        if (a2 == null || a3 == null) {
            return null;
        }
        return new GuestSession(new GuestAuthToken(OAuth2Token.TOKEN_TYPE_BEARER, a2.replace("bearer ", ""), a3));
    }

    z resign(z zVar, GuestAuthToken guestAuthToken) {
        z.a e = zVar.e();
        GuestAuthInterceptor.addAuthHeaders(e, guestAuthToken);
        return e.b();
    }

    boolean canRetry(ab abVar) {
        int i = 1;
        while (true) {
            abVar = abVar.i();
            if (abVar == null) {
                break;
            }
            i++;
        }
        return i < 2;
    }
}
