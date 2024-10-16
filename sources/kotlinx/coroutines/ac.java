package kotlinx.coroutines;

/* loaded from: classes3.dex */
public abstract class ac extends i {
    public abstract ac a();

    @Override // kotlinx.coroutines.i
    public String toString() {
        String b = b();
        if (b != null) {
            return b;
        }
        return o.b(this) + '@' + o.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String b() {
        ac acVar;
        ac a2 = s.a();
        ac acVar2 = this;
        if (acVar2 == a2) {
            return "Dispatchers.Main";
        }
        try {
            acVar = a2.a();
        } catch (UnsupportedOperationException unused) {
            acVar = null;
        }
        if (acVar2 == acVar) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }
}
