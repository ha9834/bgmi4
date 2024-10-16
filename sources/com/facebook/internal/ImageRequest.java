package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.facebook.FacebookSdk;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.l;

/* loaded from: classes.dex */
public final class ImageRequest {
    private static final String ACCESS_TOKEN_PARAM = "access_token";
    public static final Companion Companion = new Companion(null);
    private static final String HEIGHT_PARAM = "height";
    private static final String MIGRATION_PARAM = "migration_overrides";
    private static final String MIGRATION_VALUE = "{october_2012:true}";
    private static final String PATH = "%s/%s/picture";
    public static final int UNSPECIFIED_DIMENSION = 0;
    private static final String WIDTH_PARAM = "width";
    private final boolean allowCachedRedirects;
    private final Callback callback;
    private final Object callerTag;
    private final Context context;
    private final Uri imageUri;

    /* loaded from: classes.dex */
    public interface Callback {
        void onCompleted(ImageResponse imageResponse);
    }

    public static final Uri getProfilePictureUri(String str, int i, int i2) {
        return Companion.getProfilePictureUri(str, i, i2);
    }

    public static final Uri getProfilePictureUri(String str, int i, int i2, String str2) {
        return Companion.getProfilePictureUri(str, i, i2, str2);
    }

    public /* synthetic */ ImageRequest(Context context, Uri uri, Callback callback, boolean z, Object obj, f fVar) {
        this(context, uri, callback, z, obj);
    }

    private ImageRequest(Context context, Uri uri, Callback callback, boolean z, Object obj) {
        this.context = context;
        this.imageUri = uri;
        this.callback = callback;
        this.allowCachedRedirects = z;
        this.callerTag = obj;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Uri getImageUri() {
        return this.imageUri;
    }

    public final Callback getCallback() {
        return this.callback;
    }

    public final boolean getAllowCachedRedirects() {
        return this.allowCachedRedirects;
    }

    public final Object getCallerTag() {
        return this.callerTag;
    }

    public final boolean isCachedRedirectAllowed() {
        return this.allowCachedRedirects;
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final Uri getProfilePictureUri(String str, int i, int i2) {
            return getProfilePictureUri(str, i, i2, "");
        }

        public final Uri getProfilePictureUri(String str, int i, int i2, String str2) {
            Validate.notNullOrEmpty(str, "userId");
            int max = Math.max(i, 0);
            int max2 = Math.max(i2, 0);
            if (!((max == 0 && max2 == 0) ? false : true)) {
                throw new IllegalArgumentException("Either width or height must be greater than 0".toString());
            }
            Uri.Builder buildUpon = Uri.parse(ServerProtocol.getGraphUrlBase()).buildUpon();
            l lVar = l.f6973a;
            Locale locale = Locale.US;
            Object[] objArr = {FacebookSdk.getGraphApiVersion(), str};
            String format = String.format(locale, ImageRequest.PATH, Arrays.copyOf(objArr, objArr.length));
            h.a((Object) format, "java.lang.String.format(locale, format, *args)");
            Uri.Builder path = buildUpon.path(format);
            if (max2 != 0) {
                path.appendQueryParameter("height", String.valueOf(max2));
            }
            if (max != 0) {
                path.appendQueryParameter("width", String.valueOf(max));
            }
            path.appendQueryParameter(ImageRequest.MIGRATION_PARAM, ImageRequest.MIGRATION_VALUE);
            if (!Utility.isNullOrEmpty(str2)) {
                path.appendQueryParameter("access_token", str2);
            } else if (!Utility.isNullOrEmpty(FacebookSdk.getClientToken()) && !Utility.isNullOrEmpty(FacebookSdk.getApplicationId())) {
                path.appendQueryParameter("access_token", FacebookSdk.getApplicationId() + "|" + FacebookSdk.getClientToken());
            } else {
                Log.d("ImageRequest", "Needs access token to fetch profile picture. Without an access token a default silhoutte picture is returned");
            }
            Uri build = path.build();
            h.a((Object) build, "builder.build()");
            return build;
        }
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        private boolean allowCachedRedirects;
        private Callback callback;
        private Object callerTag;
        private final Context context;
        private final Uri imageUri;

        private final Context component1() {
            return this.context;
        }

        private final Uri component2() {
            return this.imageUri;
        }

        public static /* synthetic */ Builder copy$default(Builder builder, Context context, Uri uri, int i, Object obj) {
            if ((i & 1) != 0) {
                context = builder.context;
            }
            if ((i & 2) != 0) {
                uri = builder.imageUri;
            }
            return builder.copy(context, uri);
        }

        public final Builder copy(Context context, Uri uri) {
            h.b(context, "context");
            h.b(uri, "imageUri");
            return new Builder(context, uri);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Builder)) {
                return false;
            }
            Builder builder = (Builder) obj;
            return h.a(this.context, builder.context) && h.a(this.imageUri, builder.imageUri);
        }

        public int hashCode() {
            Context context = this.context;
            int hashCode = (context != null ? context.hashCode() : 0) * 31;
            Uri uri = this.imageUri;
            return hashCode + (uri != null ? uri.hashCode() : 0);
        }

        public String toString() {
            return "Builder(context=" + this.context + ", imageUri=" + this.imageUri + ")";
        }

        public Builder(Context context, Uri uri) {
            h.b(context, "context");
            h.b(uri, "imageUri");
            this.context = context;
            this.imageUri = uri;
        }

        public final Builder setCallback(Callback callback) {
            this.callback = callback;
            return this;
        }

        public final Builder setCallerTag(Object obj) {
            this.callerTag = obj;
            return this;
        }

        public final Builder setAllowCachedRedirects(boolean z) {
            this.allowCachedRedirects = z;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final ImageRequest build() {
            Context context = this.context;
            Uri uri = this.imageUri;
            Callback callback = this.callback;
            boolean z = this.allowCachedRedirects;
            Object obj = this.callerTag;
            if (obj == null) {
                obj = new Object();
            } else if (obj == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            return new ImageRequest(context, uri, callback, z, obj, null);
        }
    }
}
