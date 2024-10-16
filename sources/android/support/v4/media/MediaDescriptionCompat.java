package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.c;
import android.support.v4.media.d;
import android.text.TextUtils;

/* loaded from: classes.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new Parcelable.Creator<MediaDescriptionCompat>() { // from class: android.support.v4.media.MediaDescriptionCompat.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            if (Build.VERSION.SDK_INT < 21) {
                return new MediaDescriptionCompat(parcel);
            }
            return MediaDescriptionCompat.a(c.a(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MediaDescriptionCompat[] newArray(int i) {
            return new MediaDescriptionCompat[i];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final String f76a;
    private final CharSequence b;
    private final CharSequence c;
    private final CharSequence d;
    private final Bitmap e;
    private final Uri f;
    private final Bundle g;
    private final Uri h;
    private Object i;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f76a = str;
        this.b = charSequence;
        this.c = charSequence2;
        this.d = charSequence3;
        this.e = bitmap;
        this.f = uri;
        this.g = bundle;
        this.h = uri2;
    }

    MediaDescriptionCompat(Parcel parcel) {
        this.f76a = parcel.readString();
        this.b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        ClassLoader classLoader = getClass().getClassLoader();
        this.e = (Bitmap) parcel.readParcelable(classLoader);
        this.f = (Uri) parcel.readParcelable(classLoader);
        this.g = parcel.readBundle(classLoader);
        this.h = (Uri) parcel.readParcelable(classLoader);
    }

    public String a() {
        return this.f76a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (Build.VERSION.SDK_INT < 21) {
            parcel.writeString(this.f76a);
            TextUtils.writeToParcel(this.b, parcel, i);
            TextUtils.writeToParcel(this.c, parcel, i);
            TextUtils.writeToParcel(this.d, parcel, i);
            parcel.writeParcelable(this.e, i);
            parcel.writeParcelable(this.f, i);
            parcel.writeBundle(this.g);
            parcel.writeParcelable(this.h, i);
            return;
        }
        c.a(b(), parcel, i);
    }

    public String toString() {
        return ((Object) this.b) + ", " + ((Object) this.c) + ", " + ((Object) this.d);
    }

    public Object b() {
        if (this.i != null || Build.VERSION.SDK_INT < 21) {
            return this.i;
        }
        Object a2 = c.a.a();
        c.a.a(a2, this.f76a);
        c.a.a(a2, this.b);
        c.a.b(a2, this.c);
        c.a.c(a2, this.d);
        c.a.a(a2, this.e);
        c.a.a(a2, this.f);
        Bundle bundle = this.g;
        if (Build.VERSION.SDK_INT < 23 && this.h != null) {
            if (bundle == null) {
                bundle = new Bundle();
                bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
            }
            bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", this.h);
        }
        c.a.a(a2, bundle);
        if (Build.VERSION.SDK_INT >= 23) {
            d.a.a(a2, this.h);
        }
        this.i = c.a.a(a2);
        return this.i;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.support.v4.media.MediaDescriptionCompat a(java.lang.Object r6) {
        /*
            r0 = 0
            if (r6 == 0) goto L85
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 21
            if (r1 < r2) goto L85
            android.support.v4.media.MediaDescriptionCompat$a r1 = new android.support.v4.media.MediaDescriptionCompat$a
            r1.<init>()
            java.lang.String r2 = android.support.v4.media.c.a(r6)
            r1.a(r2)
            java.lang.CharSequence r2 = android.support.v4.media.c.b(r6)
            r1.a(r2)
            java.lang.CharSequence r2 = android.support.v4.media.c.c(r6)
            r1.b(r2)
            java.lang.CharSequence r2 = android.support.v4.media.c.d(r6)
            r1.c(r2)
            android.graphics.Bitmap r2 = android.support.v4.media.c.e(r6)
            r1.a(r2)
            android.net.Uri r2 = android.support.v4.media.c.f(r6)
            r1.a(r2)
            android.os.Bundle r2 = android.support.v4.media.c.g(r6)
            if (r2 == 0) goto L4a
            android.support.v4.media.session.MediaSessionCompat.a(r2)
            java.lang.String r3 = "android.support.v4.media.description.MEDIA_URI"
            android.os.Parcelable r3 = r2.getParcelable(r3)
            android.net.Uri r3 = (android.net.Uri) r3
            goto L4b
        L4a:
            r3 = r0
        L4b:
            if (r3 == 0) goto L67
            java.lang.String r4 = "android.support.v4.media.description.NULL_BUNDLE_FLAG"
            boolean r4 = r2.containsKey(r4)
            if (r4 == 0) goto L5d
            int r4 = r2.size()
            r5 = 2
            if (r4 != r5) goto L5d
            goto L68
        L5d:
            java.lang.String r0 = "android.support.v4.media.description.MEDIA_URI"
            r2.remove(r0)
            java.lang.String r0 = "android.support.v4.media.description.NULL_BUNDLE_FLAG"
            r2.remove(r0)
        L67:
            r0 = r2
        L68:
            r1.a(r0)
            if (r3 == 0) goto L71
            r1.b(r3)
            goto L7e
        L71:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 23
            if (r0 < r2) goto L7e
            android.net.Uri r0 = android.support.v4.media.d.a(r6)
            r1.b(r0)
        L7e:
            android.support.v4.media.MediaDescriptionCompat r0 = r1.a()
            r0.i = r6
            return r0
        L85:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaDescriptionCompat.a(java.lang.Object):android.support.v4.media.MediaDescriptionCompat");
    }

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private String f77a;
        private CharSequence b;
        private CharSequence c;
        private CharSequence d;
        private Bitmap e;
        private Uri f;
        private Bundle g;
        private Uri h;

        public a a(String str) {
            this.f77a = str;
            return this;
        }

        public a a(CharSequence charSequence) {
            this.b = charSequence;
            return this;
        }

        public a b(CharSequence charSequence) {
            this.c = charSequence;
            return this;
        }

        public a c(CharSequence charSequence) {
            this.d = charSequence;
            return this;
        }

        public a a(Bitmap bitmap) {
            this.e = bitmap;
            return this;
        }

        public a a(Uri uri) {
            this.f = uri;
            return this;
        }

        public a a(Bundle bundle) {
            this.g = bundle;
            return this;
        }

        public a b(Uri uri) {
            this.h = uri;
            return this;
        }

        public MediaDescriptionCompat a() {
            return new MediaDescriptionCompat(this.f77a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
        }
    }
}
