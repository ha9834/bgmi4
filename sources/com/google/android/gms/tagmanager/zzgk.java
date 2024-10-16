package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzb;
import com.google.android.gms.internal.gtm.zzl;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.uqm.crashsight.CrashSight;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ShowFirstParty
@VisibleForTesting
/* loaded from: classes2.dex */
public final class zzgk extends dx {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5173a = com.google.android.gms.internal.gtm.zza.UNIVERSAL_ANALYTICS.toString();
    private static final String b = zzb.ACCOUNT.toString();
    private static final String c = zzb.ANALYTICS_PASS_THROUGH.toString();
    private static final String d = zzb.ENABLE_ECOMMERCE.toString();
    private static final String e = zzb.ECOMMERCE_USE_DATA_LAYER.toString();
    private static final String f = zzb.ECOMMERCE_MACRO_DATA.toString();
    private static final String g = zzb.ANALYTICS_FIELDS.toString();
    private static final String h = zzb.TRACK_TRANSACTION.toString();
    private static final String i = zzb.TRANSACTION_DATALAYER_MAP.toString();
    private static final String j = zzb.TRANSACTION_ITEM_DATALAYER_MAP.toString();
    private static final List<String> k = Arrays.asList(ProductAction.ACTION_DETAIL, ProductAction.ACTION_CHECKOUT, "checkout_option", "click", ProductAction.ACTION_ADD, ProductAction.ACTION_REMOVE, ProductAction.ACTION_PURCHASE, ProductAction.ACTION_REFUND);
    private static final Pattern l = Pattern.compile("dimension(\\d+)");
    private static final Pattern m = Pattern.compile("metric(\\d+)");
    private static Map<String, String> n;
    private static Map<String, String> o;
    private final Set<String> p;
    private final zzgf q;
    private final DataLayer r;

    public zzgk(Context context, DataLayer dataLayer) {
        this(context, dataLayer, new zzgf(context));
    }

    @VisibleForTesting
    private zzgk(Context context, DataLayer dataLayer, zzgf zzgfVar) {
        super(f5173a, new String[0]);
        this.r = dataLayer;
        this.q = zzgfVar;
        this.p = new HashSet();
        this.p.add("");
        this.p.add("0");
        this.p.add(CrashSight.SDK_IS_DEV);
    }

    private static boolean a(Map<String, zzl> map, String str) {
        zzl zzlVar = map.get(str);
        if (zzlVar == null) {
            return false;
        }
        return zzgj.zzg(zzlVar).booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x018b  */
    @Override // com.google.android.gms.tagmanager.dx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzd(java.util.Map<java.lang.String, com.google.android.gms.internal.gtm.zzl> r11) {
        /*
            Method dump skipped, instructions count: 1154
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzgk.zzd(java.util.Map):void");
    }

    private final String a(String str) {
        Object obj = this.r.get(str);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    private static void a(Map<String, String> map, String str, String str2) {
        if (str2 != null) {
            map.put(str, str2);
        }
    }

    private static Product a(Map<String, Object> map) {
        Product product = new Product();
        Object obj = map.get("id");
        if (obj != null) {
            product.setId(String.valueOf(obj));
        }
        Object obj2 = map.get("name");
        if (obj2 != null) {
            product.setName(String.valueOf(obj2));
        }
        Object obj3 = map.get("brand");
        if (obj3 != null) {
            product.setBrand(String.valueOf(obj3));
        }
        Object obj4 = map.get("category");
        if (obj4 != null) {
            product.setCategory(String.valueOf(obj4));
        }
        Object obj5 = map.get("variant");
        if (obj5 != null) {
            product.setVariant(String.valueOf(obj5));
        }
        Object obj6 = map.get(FirebaseAnalytics.Param.COUPON);
        if (obj6 != null) {
            product.setCouponCode(String.valueOf(obj6));
        }
        Object obj7 = map.get("position");
        if (obj7 != null) {
            product.setPosition(b(obj7).intValue());
        }
        Object obj8 = map.get(FirebaseAnalytics.Param.PRICE);
        if (obj8 != null) {
            product.setPrice(a(obj8).doubleValue());
        }
        Object obj9 = map.get(FirebaseAnalytics.Param.QUANTITY);
        if (obj9 != null) {
            product.setQuantity(b(obj9).intValue());
        }
        for (String str : map.keySet()) {
            Matcher matcher = l.matcher(str);
            if (matcher.matches()) {
                try {
                    product.setCustomDimension(Integer.parseInt(matcher.group(1)), String.valueOf(map.get(str)));
                } catch (NumberFormatException unused) {
                    String valueOf = String.valueOf(str);
                    zzdi.zzac(valueOf.length() != 0 ? "illegal number in custom dimension value: ".concat(valueOf) : new String("illegal number in custom dimension value: "));
                }
            } else {
                Matcher matcher2 = m.matcher(str);
                if (matcher2.matches()) {
                    try {
                        product.setCustomMetric(Integer.parseInt(matcher2.group(1)), b(map.get(str)).intValue());
                    } catch (NumberFormatException unused2) {
                        String valueOf2 = String.valueOf(str);
                        zzdi.zzac(valueOf2.length() != 0 ? "illegal number in custom metric value: ".concat(valueOf2) : new String("illegal number in custom metric value: "));
                    }
                }
            }
        }
        return product;
    }

    private static Map<String, String> a(zzl zzlVar) {
        Object zzh = zzgj.zzh(zzlVar);
        if (!(zzh instanceof Map)) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : ((Map) zzh).entrySet()) {
            linkedHashMap.put(entry.getKey().toString(), entry.getValue().toString());
        }
        return linkedHashMap;
    }

    private final Map<String, String> b(zzl zzlVar) {
        if (zzlVar == null) {
            return new HashMap();
        }
        Map<String, String> a2 = a(zzlVar);
        if (a2 == null) {
            return new HashMap();
        }
        String str = a2.get("&aip");
        if (str != null && this.p.contains(str.toLowerCase())) {
            a2.remove("&aip");
        }
        return a2;
    }

    private static Double a(Object obj) {
        if (obj instanceof String) {
            try {
                return Double.valueOf((String) obj);
            } catch (NumberFormatException e2) {
                String valueOf = String.valueOf(e2.getMessage());
                throw new RuntimeException(valueOf.length() != 0 ? "Cannot convert the object to Double: ".concat(valueOf) : new String("Cannot convert the object to Double: "));
            }
        }
        if (obj instanceof Integer) {
            return Double.valueOf(((Integer) obj).doubleValue());
        }
        if (obj instanceof Double) {
            return (Double) obj;
        }
        String valueOf2 = String.valueOf(obj.toString());
        throw new RuntimeException(valueOf2.length() != 0 ? "Cannot convert the object to Double: ".concat(valueOf2) : new String("Cannot convert the object to Double: "));
    }

    private static Integer b(Object obj) {
        if (obj instanceof String) {
            try {
                return Integer.valueOf((String) obj);
            } catch (NumberFormatException e2) {
                String valueOf = String.valueOf(e2.getMessage());
                throw new RuntimeException(valueOf.length() != 0 ? "Cannot convert the object to Integer: ".concat(valueOf) : new String("Cannot convert the object to Integer: "));
            }
        }
        if (obj instanceof Double) {
            return Integer.valueOf(((Double) obj).intValue());
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        String valueOf2 = String.valueOf(obj.toString());
        throw new RuntimeException(valueOf2.length() != 0 ? "Cannot convert the object to Integer: ".concat(valueOf2) : new String("Cannot convert the object to Integer: "));
    }

    @Override // com.google.android.gms.tagmanager.dx, com.google.android.gms.tagmanager.ag
    public final /* bridge */ /* synthetic */ zzl zzb(Map map) {
        return super.zzb(map);
    }

    @Override // com.google.android.gms.tagmanager.dx, com.google.android.gms.tagmanager.ag
    public final /* bridge */ /* synthetic */ boolean zzgw() {
        return super.zzgw();
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final /* bridge */ /* synthetic */ Set zzig() {
        return super.zzig();
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final /* bridge */ /* synthetic */ String zzif() {
        return super.zzif();
    }
}
