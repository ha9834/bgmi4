package kotlinx.coroutines;

/* loaded from: classes3.dex */
public final class ah extends i {
    public static final ah b = new ah();

    @Override // kotlinx.coroutines.i
    public boolean a(kotlin.coroutines.e eVar) {
        return false;
    }

    @Override // kotlinx.coroutines.i
    public String toString() {
        return "Dispatchers.Unconfined";
    }

    private ah() {
    }

    @Override // kotlinx.coroutines.i
    public void a(kotlin.coroutines.e eVar, Runnable runnable) {
        ai aiVar = (ai) eVar.get(ai.b);
        if (aiVar != null) {
            aiVar.f6992a = true;
            return;
        }
        throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
    }
}
