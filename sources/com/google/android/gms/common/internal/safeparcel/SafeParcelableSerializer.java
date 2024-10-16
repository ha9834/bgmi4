package com.google.android.gms.common.internal.safeparcel;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.helpshift.util.HSObservableList;
import java.util.ArrayList;
import java.util.Iterator;

@VisibleForTesting
@KeepForSdk
/* loaded from: classes.dex */
public final class SafeParcelableSerializer {
    @KeepForSdk
    public static <T extends SafeParcelable> byte[] serializeToBytes(T t) {
        Parcel obtain = Parcel.obtain();
        t.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    @KeepForSdk
    public static <T extends SafeParcelable> T deserializeFromBytes(byte[] bArr, Parcelable.Creator<T> creator) {
        Preconditions.checkNotNull(creator);
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        T createFromParcel = creator.createFromParcel(obtain);
        obtain.recycle();
        return createFromParcel;
    }

    public static <T extends SafeParcelable> void serializeIterableToBundle(Iterable<T> iterable, Bundle bundle, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(serializeToBytes(it.next()));
        }
        bundle.putSerializable(str, arrayList);
    }

    public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromBundle(Bundle bundle, String str, Parcelable.Creator<T> creator) {
        ArrayList arrayList = (ArrayList) bundle.getSerializable(str);
        if (arrayList == null) {
            return null;
        }
        HSObservableList hSObservableList = (ArrayList<T>) new ArrayList(arrayList.size());
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            hSObservableList.add(deserializeFromBytes((byte[]) obj, creator));
        }
        return hSObservableList;
    }

    @KeepForSdk
    public static <T extends SafeParcelable> String serializeToString(T t) {
        return Base64Utils.encodeUrlSafe(serializeToBytes(t));
    }

    @KeepForSdk
    public static <T extends SafeParcelable> T deserializeFromString(String str, Parcelable.Creator<T> creator) {
        return (T) deserializeFromBytes(Base64Utils.decodeUrlSafe(str), creator);
    }

    @KeepForSdk
    public static <T extends SafeParcelable> void serializeToIntentExtra(T t, Intent intent, String str) {
        intent.putExtra(str, serializeToBytes(t));
    }

    @KeepForSdk
    public static <T extends SafeParcelable> T deserializeFromIntentExtra(Intent intent, String str, Parcelable.Creator<T> creator) {
        byte[] byteArrayExtra = intent.getByteArrayExtra(str);
        if (byteArrayExtra == null) {
            return null;
        }
        return (T) deserializeFromBytes(byteArrayExtra, creator);
    }

    @KeepForSdk
    public static <T extends SafeParcelable> void serializeIterableToIntentExtra(Iterable<T> iterable, Intent intent, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(serializeToBytes(it.next()));
        }
        intent.putExtra(str, arrayList);
    }

    @KeepForSdk
    public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromIntentExtra(Intent intent, String str, Parcelable.Creator<T> creator) {
        ArrayList arrayList = (ArrayList) intent.getSerializableExtra(str);
        if (arrayList == null) {
            return null;
        }
        HSObservableList hSObservableList = (ArrayList<T>) new ArrayList(arrayList.size());
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            hSObservableList.add(deserializeFromBytes((byte[]) obj, creator));
        }
        return hSObservableList;
    }
}
