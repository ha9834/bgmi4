package com.twitter.sdk.android.core.internal.network;

import com.twitter.sdk.android.core.GuestSessionProvider;
import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthToken;
import okhttp3.g;
import okhttp3.x;

/* loaded from: classes.dex */
public class OkHttpClientHelper {
    public static x getOkHttpClient(GuestSessionProvider guestSessionProvider) {
        return addGuestAuth(new x.a(), guestSessionProvider).a();
    }

    public static x getOkHttpClient(Session<? extends TwitterAuthToken> session, TwitterAuthConfig twitterAuthConfig) {
        if (session == null) {
            throw new IllegalArgumentException("Session must not be null.");
        }
        return addSessionAuth(new x.a(), session, twitterAuthConfig).a();
    }

    public static x getCustomOkHttpClient(x xVar, GuestSessionProvider guestSessionProvider) {
        if (xVar == null) {
            throw new IllegalArgumentException("HttpClient must not be null.");
        }
        return addGuestAuth(xVar.A(), guestSessionProvider).a();
    }

    public static x getCustomOkHttpClient(x xVar, Session<? extends TwitterAuthToken> session, TwitterAuthConfig twitterAuthConfig) {
        if (session == null) {
            throw new IllegalArgumentException("Session must not be null.");
        }
        if (xVar == null) {
            throw new IllegalArgumentException("HttpClient must not be null.");
        }
        return addSessionAuth(xVar.A(), session, twitterAuthConfig).a();
    }

    static x.a addGuestAuth(x.a aVar, GuestSessionProvider guestSessionProvider) {
        return aVar.a(getCertificatePinner()).a(new GuestAuthenticator(guestSessionProvider)).a(new GuestAuthInterceptor(guestSessionProvider)).b(new GuestAuthNetworkInterceptor());
    }

    static x.a addSessionAuth(x.a aVar, Session<? extends TwitterAuthToken> session, TwitterAuthConfig twitterAuthConfig) {
        return aVar.a(getCertificatePinner()).a(new OAuth1aInterceptor(session, twitterAuthConfig));
    }

    public static g getCertificatePinner() {
        return new g.a().a("*.twitter.com", "sha1/I0PRSKJViZuUfUYaeX7ATP7RcLc=").a("*.twitter.com", "sha1/VRmyeKyygdftp6vBg5nDu2kEJLU=").a("*.twitter.com", "sha1/Eje6RRfurSkm/cHN/r7t8t7ZFFw=").a("*.twitter.com", "sha1/Wr7Fddyu87COJxlD/H8lDD32YeM=").a("*.twitter.com", "sha1/GiG0lStik84Ys2XsnA6TTLOB5tQ=").a("*.twitter.com", "sha1/IvGeLsbqzPxdI0b0wuj2xVTdXgc=").a("*.twitter.com", "sha1/7WYxNdMb1OymFMQp4xkGn5TBJlA=").a("*.twitter.com", "sha1/sYEIGhmkwJQf+uiVKMEkyZs0rMc=").a("*.twitter.com", "sha1/PANDaGiVHPNpKri0Jtq6j+ki5b0=").a("*.twitter.com", "sha1/u8I+KQuzKHcdrT6iTb30I70GsD0=").a("*.twitter.com", "sha1/wHqYaI2J+6sFZAwRfap9ZbjKzE4=").a("*.twitter.com", "sha1/cTg28gIxU0crbrplRqkQFVggBQk=").a("*.twitter.com", "sha1/sBmJ5+/7Sq/LFI9YRjl2IkFQ4bo=").a("*.twitter.com", "sha1/vb6nG6txV/nkddlU0rcngBqCJoI=").a("*.twitter.com", "sha1/nKmNAK90Dd2BgNITRaWLjy6UONY=").a("*.twitter.com", "sha1/h+hbY1PGI6MSjLD/u/VR/lmADiI=").a("*.twitter.com", "sha1/Xk9ThoXdT57KX9wNRW99UbHcm3s=").a("*.twitter.com", "sha1/1S4TwavjSdrotJWU73w4Q2BkZr0=").a("*.twitter.com", "sha1/gzF+YoVCU9bXeDGQ7JGQVumRueM=").a("*.twitter.com", "sha1/aDMOYTWFIVkpg6PI0tLhQG56s8E=").a("*.twitter.com", "sha1/Vv7zwhR9TtOIN/29MFI4cgHld40=").a();
    }
}
