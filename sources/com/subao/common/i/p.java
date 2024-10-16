package com.subao.common.i;

import android.util.JsonWriter;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.helpshift.BuildConfig;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/* loaded from: classes2.dex */
public class p {

    /* loaded from: classes2.dex */
    public enum e implements com.subao.common.i.c {
        UNKNOWN_NETWORKTYPE(0),
        WIFI(1),
        MOBILE_2G(2),
        MOBILE_3G(3),
        MOBILE_4G(4),
        MOBILE_5G(5);

        private final int g;

        e(int i) {
            this.g = i;
        }

        @Override // com.subao.common.i.c
        public int a() {
            return this.g;
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements com.subao.common.c {

        /* renamed from: a, reason: collision with root package name */
        public final float f6052a;
        public final float b;
        public final float c;
        public final float d;
        public final float e;
        public final float f;
        public final int g;

        public c(float f, float f2, float f3, float f4, float f5, float f6, int i) {
            this.f6052a = f;
            this.b = f2;
            this.c = f3;
            this.d = f4;
            this.e = f5;
            this.f = f6;
            this.g = i;
        }

        private static StringBuilder a(StringBuilder sb, NumberFormat numberFormat, String str, float f) {
            sb.append('\"');
            sb.append(str);
            sb.append('\"');
            sb.append(':');
            sb.append(numberFormat.format(f));
            return sb;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || !(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.g == cVar.g && Float.compare(this.f6052a, cVar.f6052a) == 0 && Float.compare(this.b, cVar.b) == 0 && Float.compare(this.c, cVar.c) == 0 && Float.compare(this.d, cVar.d) == 0 && Float.compare(this.e, cVar.e) == 0 && Float.compare(this.f, cVar.f) == 0;
        }

        public String toString() {
            return a();
        }

        public String a() {
            StringBuilder sb = new StringBuilder(256);
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            sb.append('{');
            a(sb, decimalFormat, "delayAvg", this.f6052a).append(',');
            a(sb, decimalFormat, "delaySD", this.b).append(',');
            a(sb, decimalFormat, "lossRatio", this.c).append(',');
            a(sb, decimalFormat, "exPktRatio1", this.d).append(',');
            a(sb, decimalFormat, "exPktRatio2", this.e).append(',');
            a(sb, decimalFormat, "delayAvgRaw", this.f).append(',');
            sb.append('\"');
            sb.append("roundResult");
            sb.append("\":");
            sb.append(this.g);
            sb.append('}');
            return sb.toString();
        }

        @Override // com.subao.common.c
        public void serialize(JsonWriter jsonWriter) {
            jsonWriter.beginObject();
            com.subao.common.n.g.a(jsonWriter, "delayAvg", Float.valueOf(this.f6052a));
            com.subao.common.n.g.a(jsonWriter, "delaySD", Float.valueOf(this.b));
            com.subao.common.n.g.a(jsonWriter, "lossRatio", Float.valueOf(this.c));
            com.subao.common.n.g.a(jsonWriter, "exPktRatio1", Float.valueOf(this.d));
            com.subao.common.n.g.a(jsonWriter, "exPktRatio2", Float.valueOf(this.e));
            com.subao.common.n.g.a(jsonWriter, "delayAvgRaw", Float.valueOf(this.f));
            jsonWriter.name("roundResult").value(this.g);
            jsonWriter.endObject();
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements com.subao.common.c {

        /* renamed from: a, reason: collision with root package name */
        public final e f6053a;
        public final String b;

        public d(e eVar, String str) {
            this.f6053a = eVar;
            this.b = str;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || !(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.b.equals(dVar.b) && this.f6053a.equals(dVar.f6053a);
        }

        @Override // com.subao.common.c
        public void serialize(JsonWriter jsonWriter) {
            jsonWriter.beginObject();
            com.subao.common.i.e.a(jsonWriter, "type", this.f6053a);
            com.subao.common.n.g.a(jsonWriter, ProductAction.ACTION_DETAIL, this.b);
            jsonWriter.endObject();
        }
    }

    /* loaded from: classes2.dex */
    private static abstract class b implements com.subao.common.c {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f6051a;
        public final boolean b;
        public final Integer c;

        protected abstract void a(JsonWriter jsonWriter);

        protected abstract boolean a(b bVar);

        protected b(boolean z, boolean z2, Integer num) {
            this.f6051a = z;
            this.b = z2;
            this.c = num;
        }

        @Override // com.subao.common.c
        public void serialize(JsonWriter jsonWriter) {
            jsonWriter.beginObject();
            jsonWriter.name(BuildConfig.FLAVOR_supportDimension).value(this.f6051a);
            jsonWriter.name("open").value(this.b);
            com.subao.common.n.g.a(jsonWriter, "duration", (Number) this.c);
            a(jsonWriter);
            jsonWriter.endObject();
        }

        public String toString() {
            try {
                return com.subao.common.n.g.a(this);
            } catch (IOException unused) {
                return super.toString();
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || !(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f6051a == bVar.f6051a && this.b == bVar.b && com.subao.common.e.a(this.c, bVar.c) && a(bVar);
        }
    }

    /* loaded from: classes2.dex */
    static class f extends b {
        public final String d;

        public f(boolean z, boolean z2, Integer num, String str) {
            super(z, z2, num);
            this.d = str;
        }

        @Override // com.subao.common.i.p.b
        protected boolean a(b bVar) {
            if (bVar instanceof f) {
                return com.subao.common.e.a(this.d, ((f) bVar).d);
            }
            return false;
        }

        @Override // com.subao.common.i.p.b
        protected void a(JsonWriter jsonWriter) {
            com.subao.common.n.g.a(jsonWriter, "isp", this.d);
        }
    }

    /* loaded from: classes2.dex */
    static class g extends b {
        private final Integer d;

        public g(boolean z, boolean z2, Integer num, Integer num2) {
            super(z, z2, num);
            this.d = num2;
        }

        @Override // com.subao.common.i.p.b
        protected boolean a(b bVar) {
            if (bVar instanceof g) {
                return com.subao.common.e.a(((g) bVar).d, this.d);
            }
            return false;
        }

        @Override // com.subao.common.i.p.b
        protected void a(JsonWriter jsonWriter) {
            com.subao.common.n.g.a(jsonWriter, "traffic", (Number) this.d);
        }
    }

    /* loaded from: classes2.dex */
    static class a implements com.subao.common.c {

        /* renamed from: a, reason: collision with root package name */
        final f f6050a;
        final g b;
        final Integer c;

        public a(f fVar, g gVar, Integer num) {
            this.f6050a = fVar;
            this.b = gVar;
            this.c = num;
        }

        @Override // com.subao.common.c
        public void serialize(JsonWriter jsonWriter) {
            jsonWriter.beginObject();
            com.subao.common.n.g.a(jsonWriter, "qosInfo", this.f6050a);
            com.subao.common.n.g.a(jsonWriter, "multipathInfo", this.b);
            com.subao.common.n.g.a(jsonWriter, FirebaseAnalytics.Param.METHOD, (Number) this.c);
            jsonWriter.endObject();
        }
    }
}
