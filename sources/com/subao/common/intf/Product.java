package com.subao.common.intf;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.JsonReader;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.subao.common.e;
import com.subao.common.e.r;
import com.subao.common.n.g;

/* loaded from: classes2.dex */
public class Product implements Parcelable {
    public static final Parcelable.Creator<Product> CREATOR = new Parcelable.Creator<Product>() { // from class: com.subao.common.intf.Product.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Product createFromParcel(Parcel parcel) {
            return new Product(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Product[] newArray(int i) {
            return new Product[i];
        }
    };
    public static final int TYPE_MONTH = 1;
    public static final int TYPE_QUARTER = 2;
    public static final int TYPE_TRIAL = 3;
    private final int accelDays;
    private final String description;
    private final int flag;
    private final String id;
    private final String name;
    private final int price;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Product(String str, String str2, int i, String str3, int i2, int i3) {
        this.id = str;
        this.name = str2;
        this.price = i;
        this.description = str3;
        this.accelDays = i2;
        this.flag = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Product(Parcel parcel) {
        this.id = parcel.readString();
        this.name = parcel.readString();
        this.price = parcel.readInt();
        this.description = parcel.readString();
        this.accelDays = parcel.readInt();
        this.flag = parcel.readInt();
    }

    public static Product createFromJson(JsonReader jsonReader) {
        jsonReader.beginObject();
        float f = 0.0f;
        String str = null;
        String str2 = null;
        String str3 = null;
        int i = 0;
        int i2 = 0;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if ("productId".equals(nextName)) {
                str = g.b(jsonReader);
            } else if ("productName".equals(nextName)) {
                str2 = g.b(jsonReader);
            } else if ("description".equals(nextName)) {
                str3 = g.b(jsonReader);
            } else if (FirebaseAnalytics.Param.PRICE.equals(nextName)) {
                f = (float) jsonReader.nextDouble();
            } else if ("accelDays".equals(nextName)) {
                i = jsonReader.nextInt();
            } else if ("flag".equals(nextName)) {
                i2 = jsonReader.nextInt();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return new Product(str, str2, Math.round(f * 100.0f), str3, i, i2);
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public int getOriginalPrice() {
        return (this.price * 10) / 9;
    }

    public int getAccelDays() {
        return this.accelDays;
    }

    public int getType() {
        return this.flag & 255;
    }

    public String getDescription() {
        return this.description;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.name);
        parcel.writeInt(this.price);
        parcel.writeString(this.description);
        parcel.writeInt(this.accelDays);
        parcel.writeInt(this.flag);
    }

    public String toString() {
        return String.format(r.f6001a, "[id=%s, %s, %d, price=%d]", this.id, this.name, Integer.valueOf(this.flag), Integer.valueOf(this.price));
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Product)) {
            return false;
        }
        Product product = (Product) obj;
        return this.flag == product.flag && this.accelDays == product.accelDays && this.price == product.price && e.a(this.id, product.id) && e.a(this.name, product.name) && e.a(this.description, product.description);
    }
}
