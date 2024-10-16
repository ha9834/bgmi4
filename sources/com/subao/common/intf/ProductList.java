package com.subao.common.intf;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.JsonReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class ProductList implements Parcelable {
    public static final Parcelable.Creator<ProductList> CREATOR = new Parcelable.Creator<ProductList>() { // from class: com.subao.common.intf.ProductList.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProductList createFromParcel(Parcel parcel) {
            return new ProductList(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProductList[] newArray(int i) {
            return new ProductList[i];
        }
    };
    private final List<Product> list;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private ProductList(List<Product> list) {
        this.list = list;
    }

    protected ProductList(Parcel parcel) {
        ArrayList arrayList;
        int readInt = parcel.readInt();
        if (readInt <= 0) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(readInt);
            while (true) {
                int i = readInt - 1;
                if (readInt <= 0) {
                    break;
                }
                arrayList2.add(new Product(parcel));
                readInt = i;
            }
            arrayList = arrayList2;
        }
        this.list = arrayList;
    }

    public static ProductList createFromJson(JsonReader jsonReader) {
        jsonReader.beginObject();
        ProductList productList = null;
        while (jsonReader.hasNext()) {
            if (productList == null && "products".equals(jsonReader.nextName())) {
                productList = new ProductList(createListFromJson(jsonReader));
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return productList;
    }

    private static List<Product> createListFromJson(JsonReader jsonReader) {
        ArrayList arrayList = new ArrayList(8);
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(Product.createFromJson(jsonReader));
        }
        jsonReader.endArray();
        return arrayList;
    }

    public int getCount() {
        List<Product> list = this.list;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Product get(int i) {
        return this.list.get(i);
    }

    public Product findByType(int i) {
        List<Product> list = this.list;
        if (list == null) {
            return null;
        }
        for (Product product : list) {
            if (product.getType() == i) {
                return product;
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof ProductList)) {
            return false;
        }
        ProductList productList = (ProductList) obj;
        List<Product> list = this.list;
        if (list == null) {
            List<Product> list2 = productList.list;
            return list2 == null || list2.isEmpty();
        }
        List<Product> list3 = productList.list;
        if (list3 == null) {
            return list.isEmpty();
        }
        return list.equals(list3);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        List<Product> list = this.list;
        if (list == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(list.size());
        Iterator<Product> it = this.list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, i);
        }
    }
}
