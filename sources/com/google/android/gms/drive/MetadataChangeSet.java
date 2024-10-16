package com.google.android.gms.drive;

import android.graphics.Bitmap;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.drive.zzhp;
import com.google.android.gms.internal.drive.zzic;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes.dex */
public final class MetadataChangeSet {
    public static final int CUSTOM_PROPERTY_SIZE_LIMIT_BYTES = 124;
    public static final int INDEXABLE_TEXT_SIZE_LIMIT_BYTES = 131072;
    public static final int MAX_PRIVATE_PROPERTIES_PER_RESOURCE_PER_APP = 30;
    public static final int MAX_PUBLIC_PROPERTIES_PER_RESOURCE = 30;
    public static final int MAX_TOTAL_PROPERTIES_PER_RESOURCE = 100;
    public static final MetadataChangeSet zzav = new MetadataChangeSet(MetadataBundle.zzaw());

    /* renamed from: a, reason: collision with root package name */
    private final MetadataBundle f1530a;

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private final MetadataBundle f1531a = MetadataBundle.zzaw();
        private AppVisibleCustomProperties.zza b;

        private static int a(String str) {
            if (str == null) {
                return 0;
            }
            return str.getBytes().length;
        }

        private final AppVisibleCustomProperties.zza a() {
            if (this.b == null) {
                this.b = new AppVisibleCustomProperties.zza();
            }
            return this.b;
        }

        private static void a(String str, int i, int i2) {
            Preconditions.checkArgument(i2 <= i, String.format(Locale.US, "%s must be no more than %d bytes, but is %d bytes.", str, Integer.valueOf(i), Integer.valueOf(i2)));
        }

        public MetadataChangeSet build() {
            if (this.b != null) {
                this.f1531a.zzb(zzhp.zzix, this.b.zzat());
            }
            return new MetadataChangeSet(this.f1531a);
        }

        public Builder deleteCustomProperty(CustomPropertyKey customPropertyKey) {
            Preconditions.checkNotNull(customPropertyKey, "key");
            a().zza(customPropertyKey, null);
            return this;
        }

        public Builder setCustomProperty(CustomPropertyKey customPropertyKey, String str) {
            Preconditions.checkNotNull(customPropertyKey, "key");
            Preconditions.checkNotNull(str, "value");
            a("The total size of key string and value string of a custom property", 124, a(customPropertyKey.getKey()) + a(str));
            a().zza(customPropertyKey, str);
            return this;
        }

        public Builder setDescription(String str) {
            this.f1531a.zzb(zzhp.zziy, str);
            return this;
        }

        public Builder setIndexableText(String str) {
            a("Indexable text size", 131072, a(str));
            this.f1531a.zzb(zzhp.zzje, str);
            return this;
        }

        public Builder setLastViewedByMeDate(Date date) {
            this.f1531a.zzb(zzic.zzko, date);
            return this;
        }

        public Builder setMimeType(String str) {
            Preconditions.checkNotNull(str);
            this.f1531a.zzb(zzhp.zzjs, str);
            return this;
        }

        public Builder setPinned(boolean z) {
            this.f1531a.zzb(zzhp.zzjk, Boolean.valueOf(z));
            return this;
        }

        public Builder setStarred(boolean z) {
            this.f1531a.zzb(zzhp.zzjz, Boolean.valueOf(z));
            return this;
        }

        public Builder setTitle(String str) {
            Preconditions.checkNotNull(str, "Title cannot be null.");
            this.f1531a.zzb(zzhp.zzkb, str);
            return this;
        }

        public Builder setViewed() {
            this.f1531a.zzb(zzhp.zzjr, true);
            return this;
        }

        @Deprecated
        public Builder setViewed(boolean z) {
            if (z) {
                this.f1531a.zzb(zzhp.zzjr, true);
            } else if (this.f1531a.zzd(zzhp.zzjr)) {
                this.f1531a.zzc(zzhp.zzjr);
            }
            return this;
        }
    }

    public MetadataChangeSet(MetadataBundle metadataBundle) {
        this.f1530a = metadataBundle.zzax();
    }

    public final Map<CustomPropertyKey, String> getCustomPropertyChangeMap() {
        AppVisibleCustomProperties appVisibleCustomProperties = (AppVisibleCustomProperties) this.f1530a.zza(zzhp.zzix);
        return appVisibleCustomProperties == null ? Collections.emptyMap() : appVisibleCustomProperties.zzas();
    }

    public final String getDescription() {
        return (String) this.f1530a.zza(zzhp.zziy);
    }

    public final String getIndexableText() {
        return (String) this.f1530a.zza(zzhp.zzje);
    }

    public final Date getLastViewedByMeDate() {
        return (Date) this.f1530a.zza(zzic.zzko);
    }

    public final String getMimeType() {
        return (String) this.f1530a.zza(zzhp.zzjs);
    }

    @KeepForSdk
    public final Bitmap getThumbnail() {
        BitmapTeleporter bitmapTeleporter = (BitmapTeleporter) this.f1530a.zza(zzhp.zzka);
        if (bitmapTeleporter == null) {
            return null;
        }
        return bitmapTeleporter.get();
    }

    public final String getTitle() {
        return (String) this.f1530a.zza(zzhp.zzkb);
    }

    public final Boolean isPinned() {
        return (Boolean) this.f1530a.zza(zzhp.zzjk);
    }

    public final Boolean isStarred() {
        return (Boolean) this.f1530a.zza(zzhp.zzjz);
    }

    public final Boolean isViewed() {
        return (Boolean) this.f1530a.zza(zzhp.zzjr);
    }

    public final MetadataBundle zzp() {
        return this.f1530a;
    }
}
