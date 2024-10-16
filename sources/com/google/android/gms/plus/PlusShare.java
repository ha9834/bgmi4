package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.plus.zzr;
import com.google.android.gms.plus.model.people.Person;
import java.util.ArrayList;
import java.util.List;

@Deprecated
/* loaded from: classes2.dex */
public final class PlusShare {

    @Deprecated
    public static final String EXTRA_CALL_TO_ACTION = "com.google.android.apps.plus.CALL_TO_ACTION";

    @Deprecated
    public static final String EXTRA_CONTENT_DEEP_LINK_ID = "com.google.android.apps.plus.CONTENT_DEEP_LINK_ID";

    @Deprecated
    public static final String EXTRA_CONTENT_DEEP_LINK_METADATA = "com.google.android.apps.plus.CONTENT_DEEP_LINK_METADATA";

    @Deprecated
    public static final String EXTRA_CONTENT_URL = "com.google.android.apps.plus.CONTENT_URL";

    @Deprecated
    public static final String EXTRA_IS_INTERACTIVE_POST = "com.google.android.apps.plus.GOOGLE_INTERACTIVE_POST";

    @Deprecated
    public static final String EXTRA_SENDER_ID = "com.google.android.apps.plus.SENDER_ID";

    @Deprecated
    public static final String KEY_CALL_TO_ACTION_DEEP_LINK_ID = "deepLinkId";

    @Deprecated
    public static final String KEY_CALL_TO_ACTION_LABEL = "label";

    @Deprecated
    public static final String KEY_CALL_TO_ACTION_URL = "url";

    @Deprecated
    public static final String KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION = "description";

    @Deprecated
    public static final String KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL = "thumbnailUrl";

    @Deprecated
    public static final String KEY_CONTENT_DEEP_LINK_METADATA_TITLE = "title";

    @Deprecated
    public static final String PARAM_CONTENT_DEEP_LINK_ID = "deep_link_id";

    @VisibleForTesting
    @Deprecated
    /* loaded from: classes2.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private final Context f5044a;
        private final Intent b = new Intent().setAction("android.intent.action.SEND");
        private boolean c;
        private ArrayList<Uri> d;

        @Deprecated
        public Builder(Activity activity) {
            this.f5044a = activity;
            this.b.addFlags(524288);
            if (activity == null || activity.getComponentName() == null) {
                return;
            }
            this.c = true;
        }

        @Deprecated
        public Builder(Context context) {
            this.f5044a = context;
        }

        @Deprecated
        public Builder addCallToAction(String str, Uri uri, String str2) {
            Preconditions.checkState(this.c, "Must include the launching activity with PlusShare.Builder constructor before setting call-to-action");
            Preconditions.checkArgument((uri == null || TextUtils.isEmpty(uri.toString())) ? false : true, "Must provide a call to action URL");
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("label", str);
            }
            bundle.putString("url", uri.toString());
            if (!TextUtils.isEmpty(str2)) {
                Preconditions.checkState(PlusShare.a(str2), "The specified deep-link ID was malformed.");
                bundle.putString(PlusShare.KEY_CALL_TO_ACTION_DEEP_LINK_ID, str2);
            }
            this.b.putExtra(PlusShare.EXTRA_CALL_TO_ACTION, bundle);
            this.b.putExtra(PlusShare.EXTRA_IS_INTERACTIVE_POST, true);
            this.b.setType("text/plain");
            return this;
        }

        @Deprecated
        public Builder addStream(Uri uri) {
            Uri uri2 = (Uri) this.b.getParcelableExtra("android.intent.extra.STREAM");
            if (uri2 == null) {
                return setStream(uri);
            }
            if (this.d == null) {
                this.d = new ArrayList<>();
            }
            this.d.add(uri2);
            this.d.add(uri);
            return this;
        }

        @Deprecated
        public Intent getIntent() {
            Intent intent;
            String str;
            ArrayList<Uri> arrayList = this.d;
            boolean z = true;
            boolean z2 = arrayList != null && arrayList.size() > 1;
            boolean equals = "android.intent.action.SEND_MULTIPLE".equals(this.b.getAction());
            boolean booleanExtra = this.b.getBooleanExtra(PlusShare.EXTRA_IS_INTERACTIVE_POST, false);
            Preconditions.checkState((z2 && booleanExtra) ? false : true, "Call-to-action buttons are only available for URLs.");
            Preconditions.checkState(!booleanExtra || this.b.hasExtra(PlusShare.EXTRA_CONTENT_URL), "The content URL is required for interactive posts.");
            if (booleanExtra && !this.b.hasExtra(PlusShare.EXTRA_CONTENT_URL) && !this.b.hasExtra(PlusShare.EXTRA_CONTENT_DEEP_LINK_ID)) {
                z = false;
            }
            Preconditions.checkState(z, "Must set content URL or content deep-link ID to use a call-to-action button.");
            if (this.b.hasExtra(PlusShare.EXTRA_CONTENT_DEEP_LINK_ID)) {
                Preconditions.checkState(PlusShare.a(this.b.getStringExtra(PlusShare.EXTRA_CONTENT_DEEP_LINK_ID)), "The specified deep-link ID was malformed.");
            }
            if (!z2 && equals) {
                this.b.setAction("android.intent.action.SEND");
                ArrayList<Uri> arrayList2 = this.d;
                if (arrayList2 == null || arrayList2.isEmpty()) {
                    this.b.removeExtra("android.intent.extra.STREAM");
                } else {
                    this.b.putExtra("android.intent.extra.STREAM", this.d.get(0));
                }
                this.d = null;
            }
            if (z2 && !equals) {
                this.b.setAction("android.intent.action.SEND_MULTIPLE");
                ArrayList<Uri> arrayList3 = this.d;
                if (arrayList3 == null || arrayList3.isEmpty()) {
                    this.b.removeExtra("android.intent.extra.STREAM");
                } else {
                    this.b.putParcelableArrayListExtra("android.intent.extra.STREAM", this.d);
                }
            }
            if (!"com.google.android.gms.plus.action.SHARE_INTERNAL_GOOGLE".equals(this.b.getAction())) {
                if (this.b.hasExtra("android.intent.extra.STREAM")) {
                    intent = this.b;
                    str = "com.google.android.apps.plus";
                    intent.setPackage(str);
                    return this.b;
                }
                this.b.setAction("com.google.android.gms.plus.action.SHARE_GOOGLE");
            }
            intent = this.b;
            str = "com.google.android.gms";
            intent.setPackage(str);
            return this.b;
        }

        @Deprecated
        public Builder setContentDeepLinkId(String str) {
            return setContentDeepLinkId(str, null, null, null);
        }

        @Deprecated
        public Builder setContentDeepLinkId(String str, String str2, String str3, Uri uri) {
            Preconditions.checkArgument(this.c, "Must include the launching activity with PlusShare.Builder constructor before setting deep links");
            Preconditions.checkArgument(!TextUtils.isEmpty(str), "The deepLinkId parameter is required.");
            Bundle bundle = new Bundle();
            bundle.putString("title", str2);
            bundle.putString("description", str3);
            if (uri != null) {
                bundle.putString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL, uri.toString());
            }
            this.b.putExtra(PlusShare.EXTRA_CONTENT_DEEP_LINK_ID, str);
            this.b.putExtra(PlusShare.EXTRA_CONTENT_DEEP_LINK_METADATA, bundle);
            this.b.setType("text/plain");
            return this;
        }

        @Deprecated
        public Builder setContentUrl(Uri uri) {
            String uri2 = uri != null ? uri.toString() : null;
            if (TextUtils.isEmpty(uri2)) {
                this.b.removeExtra(PlusShare.EXTRA_CONTENT_URL);
            } else {
                this.b.putExtra(PlusShare.EXTRA_CONTENT_URL, uri2);
            }
            return this;
        }

        @Deprecated
        public Builder setRecipients(Person person, List<Person> list) {
            this.b.putExtra(PlusShare.EXTRA_SENDER_ID, person != null ? person.getId() : "0");
            int size = list != null ? list.size() : 0;
            if (size == 0) {
                this.b.removeExtra("com.google.android.apps.plus.RECIPIENT_IDS");
                this.b.removeExtra("com.google.android.apps.plus.RECIPIENT_DISPLAY_NAMES");
                return this;
            }
            ArrayList<String> arrayList = new ArrayList<>(size);
            ArrayList<String> arrayList2 = new ArrayList<>(size);
            for (Person person2 : list) {
                arrayList.add(person2.getId());
                arrayList2.add(person2.getDisplayName());
            }
            this.b.putStringArrayListExtra("com.google.android.apps.plus.RECIPIENT_IDS", arrayList);
            this.b.putStringArrayListExtra("com.google.android.apps.plus.RECIPIENT_DISPLAY_NAMES", arrayList2);
            return this;
        }

        @Deprecated
        public Builder setStream(Uri uri) {
            this.d = null;
            this.b.putExtra("android.intent.extra.STREAM", uri);
            return this;
        }

        @Deprecated
        public Builder setText(CharSequence charSequence) {
            this.b.putExtra("android.intent.extra.TEXT", charSequence);
            return this;
        }

        @Deprecated
        public Builder setType(String str) {
            this.b.setType(str);
            return this;
        }
    }

    @Deprecated
    protected PlusShare() {
        throw new AssertionError();
    }

    @VisibleForTesting
    protected static boolean a(String str) {
        String str2;
        String str3;
        if (TextUtils.isEmpty(str)) {
            str2 = "GooglePlusPlatform";
            str3 = "The provided deep-link ID is empty.";
        } else {
            if (!str.contains(" ")) {
                return true;
            }
            str2 = "GooglePlusPlatform";
            str3 = "Spaces are not allowed in deep-link IDs.";
        }
        Log.e(str2, str3);
        return false;
    }

    @VisibleForTesting
    @Deprecated
    public static Person createPerson(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("MinimalPerson ID must not be empty.");
        }
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("Display name must not be empty.");
        }
        return new zzr(str2, str, null, 0, null);
    }

    @Deprecated
    public static String getDeepLinkId(Intent intent) {
        if (intent == null || intent.getData() == null) {
            return null;
        }
        return intent.getData().getQueryParameter(PARAM_CONTENT_DEEP_LINK_ID);
    }
}
