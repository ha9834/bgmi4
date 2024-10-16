package kotlin.random;

/* loaded from: classes3.dex */
public abstract class a extends Random {
    public abstract java.util.Random a();

    @Override // kotlin.random.Random
    public int a(int i) {
        return c.a(a().nextInt(), i);
    }

    @Override // kotlin.random.Random
    public int b() {
        return a().nextInt();
    }
}
