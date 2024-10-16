package kotlin.text;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class m {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void a(Appendable appendable, T t, kotlin.jvm.a.b<? super T, ? extends CharSequence> bVar) {
        kotlin.jvm.internal.h.b(appendable, "$this$appendElement");
        if (bVar != null) {
            appendable.append(bVar.a(t));
            return;
        }
        if (t != 0 ? t instanceof CharSequence : true) {
            appendable.append((CharSequence) t);
        } else if (t instanceof Character) {
            appendable.append(((Character) t).charValue());
        } else {
            appendable.append(String.valueOf(t));
        }
    }
}
