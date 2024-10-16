package com.facebook.internal.gatekeeper;

import com.facebook.FacebookSdk;
import com.helpshift.util.ErrorReportProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.h;

/* loaded from: classes.dex */
public final class GateKeeperRuntimeCache {
    private final ConcurrentHashMap<String, ConcurrentHashMap<String, GateKeeper>> gateKeepers = new ConcurrentHashMap<>();

    public static /* synthetic */ void setGateKeepers$default(GateKeeperRuntimeCache gateKeeperRuntimeCache, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = FacebookSdk.getApplicationId();
            h.a((Object) str, "FacebookSdk.getApplicationId()");
        }
        gateKeeperRuntimeCache.setGateKeepers(str, list);
    }

    public final void setGateKeepers(String str, List<GateKeeper> list) {
        h.b(str, ErrorReportProvider.KEY_APP_ID);
        h.b(list, "gateKeeperList");
        ConcurrentHashMap<String, GateKeeper> concurrentHashMap = new ConcurrentHashMap<>();
        for (GateKeeper gateKeeper : list) {
            concurrentHashMap.put(gateKeeper.getName(), gateKeeper);
        }
        this.gateKeepers.put(str, concurrentHashMap);
    }

    public static /* synthetic */ List dumpGateKeepers$default(GateKeeperRuntimeCache gateKeeperRuntimeCache, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = FacebookSdk.getApplicationId();
            h.a((Object) str, "FacebookSdk.getApplicationId()");
        }
        return gateKeeperRuntimeCache.dumpGateKeepers(str);
    }

    public final List<GateKeeper> dumpGateKeepers(String str) {
        h.b(str, ErrorReportProvider.KEY_APP_ID);
        ConcurrentHashMap<String, GateKeeper> concurrentHashMap = this.gateKeepers.get(str);
        if (concurrentHashMap == null) {
            return null;
        }
        ConcurrentHashMap<String, GateKeeper> concurrentHashMap2 = concurrentHashMap;
        ArrayList arrayList = new ArrayList(concurrentHashMap2.size());
        Iterator<Map.Entry<String, GateKeeper>> it = concurrentHashMap2.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue());
        }
        return arrayList;
    }

    public static /* synthetic */ boolean getGateKeeperValue$default(GateKeeperRuntimeCache gateKeeperRuntimeCache, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = FacebookSdk.getApplicationId();
            h.a((Object) str, "FacebookSdk.getApplicationId()");
        }
        return gateKeeperRuntimeCache.getGateKeeperValue(str, str2, z);
    }

    public final boolean getGateKeeperValue(String str, String str2, boolean z) {
        h.b(str, ErrorReportProvider.KEY_APP_ID);
        h.b(str2, "name");
        GateKeeper gateKeeper = getGateKeeper(str, str2);
        return gateKeeper != null ? gateKeeper.getValue() : z;
    }

    public static /* synthetic */ void setGateKeeperValue$default(GateKeeperRuntimeCache gateKeeperRuntimeCache, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = FacebookSdk.getApplicationId();
            h.a((Object) str, "FacebookSdk.getApplicationId()");
        }
        gateKeeperRuntimeCache.setGateKeeperValue(str, str2, z);
    }

    public final void setGateKeeperValue(String str, String str2, boolean z) {
        h.b(str, ErrorReportProvider.KEY_APP_ID);
        h.b(str2, "name");
        setGateKeeper(str, new GateKeeper(str2, z));
    }

    public static /* synthetic */ GateKeeper getGateKeeper$default(GateKeeperRuntimeCache gateKeeperRuntimeCache, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = FacebookSdk.getApplicationId();
            h.a((Object) str, "FacebookSdk.getApplicationId()");
        }
        return gateKeeperRuntimeCache.getGateKeeper(str, str2);
    }

    public final GateKeeper getGateKeeper(String str, String str2) {
        h.b(str, ErrorReportProvider.KEY_APP_ID);
        h.b(str2, "name");
        ConcurrentHashMap<String, GateKeeper> concurrentHashMap = this.gateKeepers.get(str);
        if (concurrentHashMap != null) {
            return concurrentHashMap.get(str2);
        }
        return null;
    }

    public static /* synthetic */ void setGateKeeper$default(GateKeeperRuntimeCache gateKeeperRuntimeCache, String str, GateKeeper gateKeeper, int i, Object obj) {
        if ((i & 1) != 0) {
            str = FacebookSdk.getApplicationId();
            h.a((Object) str, "FacebookSdk.getApplicationId()");
        }
        gateKeeperRuntimeCache.setGateKeeper(str, gateKeeper);
    }

    public final void setGateKeeper(String str, GateKeeper gateKeeper) {
        h.b(str, ErrorReportProvider.KEY_APP_ID);
        h.b(gateKeeper, "gateKeeper");
        if (!this.gateKeepers.containsKey(str)) {
            this.gateKeepers.put(str, new ConcurrentHashMap<>());
        }
        ConcurrentHashMap<String, GateKeeper> concurrentHashMap = this.gateKeepers.get(str);
        if (concurrentHashMap != null) {
            concurrentHashMap.put(gateKeeper.getName(), gateKeeper);
        }
    }

    public static /* synthetic */ void resetCache$default(GateKeeperRuntimeCache gateKeeperRuntimeCache, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = FacebookSdk.getApplicationId();
            h.a((Object) str, "FacebookSdk.getApplicationId()");
        }
        gateKeeperRuntimeCache.resetCache(str);
    }

    public final void resetCache(String str) {
        h.b(str, ErrorReportProvider.KEY_APP_ID);
        this.gateKeepers.remove(str);
    }
}
