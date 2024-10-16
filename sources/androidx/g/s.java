package androidx.g;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class s {
    public View b;

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f740a = new HashMap();
    final ArrayList<m> c = new ArrayList<>();

    public boolean equals(Object obj) {
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.b == sVar.b && this.f740a.equals(sVar.f740a);
    }

    public int hashCode() {
        return (this.b.hashCode() * 31) + this.f740a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.b + "\n") + "    values:";
        for (String str2 : this.f740a.keySet()) {
            str = str + "    " + str2 + ": " + this.f740a.get(str2) + "\n";
        }
        return str;
    }
}
