package com.google.android.gms.internal.gtm;

import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ShowFirstParty
/* loaded from: classes2.dex */
public final class zzw extends com.google.android.gms.analytics.zzi<zzw> {

    /* renamed from: a, reason: collision with root package name */
    private final List<Product> f4463a = new ArrayList();
    private final List<Promotion> b = new ArrayList();
    private final Map<String, List<Product>> c = new HashMap();
    private ProductAction d;

    public final ProductAction zzbn() {
        return this.d;
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        if (!this.f4463a.isEmpty()) {
            hashMap.put("products", this.f4463a);
        }
        if (!this.b.isEmpty()) {
            hashMap.put("promotions", this.b);
        }
        if (!this.c.isEmpty()) {
            hashMap.put("impressions", this.c);
        }
        hashMap.put("productAction", this.d);
        return zza((Object) hashMap);
    }

    public final List<Product> zzbo() {
        return Collections.unmodifiableList(this.f4463a);
    }

    public final Map<String, List<Product>> zzbp() {
        return this.c;
    }

    public final List<Promotion> zzbq() {
        return Collections.unmodifiableList(this.b);
    }

    @Override // com.google.android.gms.analytics.zzi
    public final /* synthetic */ void zzb(zzw zzwVar) {
        zzw zzwVar2 = zzwVar;
        zzwVar2.f4463a.addAll(this.f4463a);
        zzwVar2.b.addAll(this.b);
        for (Map.Entry<String, List<Product>> entry : this.c.entrySet()) {
            String key = entry.getKey();
            for (Product product : entry.getValue()) {
                if (product != null) {
                    String str = key == null ? "" : key;
                    if (!zzwVar2.c.containsKey(str)) {
                        zzwVar2.c.put(str, new ArrayList());
                    }
                    zzwVar2.c.get(str).add(product);
                }
            }
        }
        ProductAction productAction = this.d;
        if (productAction != null) {
            zzwVar2.d = productAction;
        }
    }
}
