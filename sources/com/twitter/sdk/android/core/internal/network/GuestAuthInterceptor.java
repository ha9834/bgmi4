package com.twitter.sdk.android.core.internal.network;

import com.twitter.sdk.android.core.GuestSession;
import com.twitter.sdk.android.core.GuestSessionProvider;
import com.twitter.sdk.android.core.internal.oauth.GuestAuthToken;
import java.io.IOException;
import okhttp3.ab;
import okhttp3.u;
import okhttp3.z;

/* loaded from: classes.dex */
public class GuestAuthInterceptor implements u {
    final GuestSessionProvider guestSessionProvider;

    public GuestAuthInterceptor(GuestSessionProvider guestSessionProvider) {
        this.guestSessionProvider = guestSessionProvider;
    }

    @Override // okhttp3.u
    public ab intercept(u.a aVar) throws IOException {
        z a2 = aVar.a();
        GuestSession currentSession = this.guestSessionProvider.getCurrentSession();
        GuestAuthToken authToken = currentSession == null ? null : currentSession.getAuthToken();
        if (authToken != null) {
            z.a e = a2.e();
            addAuthHeaders(e, authToken);
            return aVar.a(e.b());
        }
        return aVar.a(a2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addAuthHeaders(z.a aVar, GuestAuthToken guestAuthToken) {
        aVar.a("Authorization", guestAuthToken.getTokenType() + " " + guestAuthToken.getAccessToken());
        aVar.a("x-guest-token", guestAuthToken.getGuestToken());
    }
}
