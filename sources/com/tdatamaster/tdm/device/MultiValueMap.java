package com.tdatamaster.tdm.device;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
class MultiValueMap<T> {
    private final Map<String, ArrayList<T>> mMap = new LinkedHashMap();

    public void put(String str, T t) {
        ArrayList<T> arrayList = this.mMap.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.mMap.put(str, arrayList);
        }
        arrayList.add(t);
    }

    public ArrayList<T> get(String str) {
        return this.mMap.get(str);
    }

    public Set<Map.Entry<String, ArrayList<T>>> entrySet() {
        return this.mMap.entrySet();
    }

    public void remove(String str) {
        if (this.mMap.containsKey(str)) {
            this.mMap.remove(str);
        }
    }
}
