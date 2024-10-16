package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzch;
import com.google.android.gms.internal.gtm.zzcz;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@VisibleForTesting
/* loaded from: classes.dex */
public class HitBuilders {

    @VisibleForTesting
    @Deprecated
    /* loaded from: classes.dex */
    public static class AppViewBuilder extends HitBuilder<AppViewBuilder> {
        public AppViewBuilder() {
            set("&t", "screenview");
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class ScreenViewBuilder extends HitBuilder<ScreenViewBuilder> {
        public ScreenViewBuilder() {
            set("&t", "screenview");
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class EventBuilder extends HitBuilder<EventBuilder> {
        public EventBuilder() {
            set("&t", DataLayer.EVENT_KEY);
        }

        public EventBuilder(String str, String str2) {
            this();
            setCategory(str);
            setAction(str2);
        }

        public EventBuilder setCategory(String str) {
            set("&ec", str);
            return this;
        }

        public EventBuilder setAction(String str) {
            set("&ea", str);
            return this;
        }

        public EventBuilder setLabel(String str) {
            set("&el", str);
            return this;
        }

        public EventBuilder setValue(long j) {
            set("&ev", Long.toString(j));
            return this;
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class ExceptionBuilder extends HitBuilder<ExceptionBuilder> {
        public ExceptionBuilder() {
            set("&t", "exception");
        }

        public ExceptionBuilder setDescription(String str) {
            set("&exd", str);
            return this;
        }

        public ExceptionBuilder setFatal(boolean z) {
            set("&exf", zzcz.zzc(z));
            return this;
        }
    }

    @VisibleForTesting
    @Deprecated
    /* loaded from: classes.dex */
    public static class ItemBuilder extends HitBuilder<ItemBuilder> {
        public ItemBuilder() {
            set("&t", "item");
        }

        public ItemBuilder setTransactionId(String str) {
            set("&ti", str);
            return this;
        }

        public ItemBuilder setName(String str) {
            set("&in", str);
            return this;
        }

        public ItemBuilder setSku(String str) {
            set("&ic", str);
            return this;
        }

        public ItemBuilder setCategory(String str) {
            set("&iv", str);
            return this;
        }

        public ItemBuilder setPrice(double d) {
            set("&ip", Double.toString(d));
            return this;
        }

        public ItemBuilder setQuantity(long j) {
            set("&iq", Long.toString(j));
            return this;
        }

        public ItemBuilder setCurrencyCode(String str) {
            set("&cu", str);
            return this;
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class SocialBuilder extends HitBuilder<SocialBuilder> {
        public SocialBuilder() {
            set("&t", "social");
        }

        public SocialBuilder setNetwork(String str) {
            set("&sn", str);
            return this;
        }

        public SocialBuilder setAction(String str) {
            set("&sa", str);
            return this;
        }

        public SocialBuilder setTarget(String str) {
            set("&st", str);
            return this;
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class TimingBuilder extends HitBuilder<TimingBuilder> {
        public TimingBuilder() {
            set("&t", "timing");
        }

        public TimingBuilder(String str, String str2, long j) {
            this();
            setVariable(str2);
            setValue(j);
            setCategory(str);
        }

        public TimingBuilder setVariable(String str) {
            set("&utv", str);
            return this;
        }

        public TimingBuilder setValue(long j) {
            set("&utt", Long.toString(j));
            return this;
        }

        public TimingBuilder setCategory(String str) {
            set("&utc", str);
            return this;
        }

        public TimingBuilder setLabel(String str) {
            set("&utl", str);
            return this;
        }
    }

    @VisibleForTesting
    @Deprecated
    /* loaded from: classes.dex */
    public static class TransactionBuilder extends HitBuilder<TransactionBuilder> {
        public TransactionBuilder() {
            set("&t", "transaction");
        }

        public TransactionBuilder setTransactionId(String str) {
            set("&ti", str);
            return this;
        }

        public TransactionBuilder setAffiliation(String str) {
            set("&ta", str);
            return this;
        }

        public TransactionBuilder setRevenue(double d) {
            set("&tr", Double.toString(d));
            return this;
        }

        public TransactionBuilder setTax(double d) {
            set("&tt", Double.toString(d));
            return this;
        }

        public TransactionBuilder setShipping(double d) {
            set("&ts", Double.toString(d));
            return this;
        }

        public TransactionBuilder setCurrencyCode(String str) {
            set("&cu", str);
            return this;
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class HitBuilder<T extends HitBuilder> {
        private ProductAction b;

        /* renamed from: a, reason: collision with root package name */
        private Map<String, String> f1193a = new HashMap();
        private Map<String, List<Product>> c = new HashMap();
        private List<Promotion> d = new ArrayList();
        private List<Product> e = new ArrayList();

        protected HitBuilder() {
        }

        public T setNewSession() {
            set("&sc", "start");
            return this;
        }

        public T setNonInteraction(boolean z) {
            set("&ni", zzcz.zzc(z));
            return this;
        }

        public T setCampaignParamsFromUrl(String str) {
            String zzah = zzcz.zzah(str);
            if (TextUtils.isEmpty(zzah)) {
                return this;
            }
            Map<String, String> zzaf = zzcz.zzaf(zzah);
            a("&cc", zzaf.get("utm_content"));
            a("&cm", zzaf.get("utm_medium"));
            a("&cn", zzaf.get("utm_campaign"));
            a("&cs", zzaf.get("utm_source"));
            a("&ck", zzaf.get("utm_term"));
            a("&ci", zzaf.get("utm_id"));
            a("&anid", zzaf.get("anid"));
            a("&gclid", zzaf.get("gclid"));
            a("&dclid", zzaf.get("dclid"));
            a("&aclid", zzaf.get(FirebaseAnalytics.Param.ACLID));
            a("&gmob_t", zzaf.get("gmob_t"));
            return this;
        }

        public T setCustomDimension(int i, String str) {
            set(zzd.zzd(i), str);
            return this;
        }

        public T setCustomMetric(int i, float f) {
            set(zzd.zzf(i), Float.toString(f));
            return this;
        }

        public final T set(String str, String str2) {
            if (str != null) {
                this.f1193a.put(str, str2);
            } else {
                zzch.zzac("HitBuilder.set() called with a null paramName.");
            }
            return this;
        }

        private final T a(String str, String str2) {
            if (str2 != null) {
                this.f1193a.put(str, str2);
            }
            return this;
        }

        public final T setAll(Map<String, String> map) {
            if (map == null) {
                return this;
            }
            this.f1193a.putAll(new HashMap(map));
            return this;
        }

        public Map<String, String> build() {
            HashMap hashMap = new HashMap(this.f1193a);
            ProductAction productAction = this.b;
            if (productAction != null) {
                hashMap.putAll(productAction.build());
            }
            Iterator<Promotion> it = this.d.iterator();
            int i = 1;
            while (it.hasNext()) {
                hashMap.putAll(it.next().zzn(zzd.zzj(i)));
                i++;
            }
            Iterator<Product> it2 = this.e.iterator();
            int i2 = 1;
            while (it2.hasNext()) {
                hashMap.putAll(it2.next().zzn(zzd.zzh(i2)));
                i2++;
            }
            int i3 = 1;
            for (Map.Entry<String, List<Product>> entry : this.c.entrySet()) {
                List<Product> value = entry.getValue();
                String zzm = zzd.zzm(i3);
                int i4 = 1;
                for (Product product : value) {
                    String valueOf = String.valueOf(zzm);
                    String valueOf2 = String.valueOf(zzd.zzl(i4));
                    hashMap.putAll(product.zzn(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)));
                    i4++;
                }
                if (!TextUtils.isEmpty(entry.getKey())) {
                    String valueOf3 = String.valueOf(zzm);
                    String valueOf4 = String.valueOf("nm");
                    hashMap.put(valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3), entry.getKey());
                }
                i3++;
            }
            return hashMap;
        }

        public T setProductAction(ProductAction productAction) {
            this.b = productAction;
            return this;
        }

        public T addImpression(Product product, String str) {
            if (product == null) {
                zzch.zzac("product should be non-null");
                return this;
            }
            if (str == null) {
                str = "";
            }
            if (!this.c.containsKey(str)) {
                this.c.put(str, new ArrayList());
            }
            this.c.get(str).add(product);
            return this;
        }

        public T addPromotion(Promotion promotion) {
            if (promotion == null) {
                zzch.zzac("promotion should be non-null");
                return this;
            }
            this.d.add(promotion);
            return this;
        }

        public T setPromotionAction(String str) {
            this.f1193a.put("&promoa", str);
            return this;
        }

        public T addProduct(Product product) {
            if (product == null) {
                zzch.zzac("product should be non-null");
                return this;
            }
            this.e.add(product);
            return this;
        }
    }
}
