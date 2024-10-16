package kotlin.text;

import com.tencent.grobot.lite.model.local.EvaluateItemInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.text.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class j implements i {

    /* renamed from: a, reason: collision with root package name */
    private final g f6984a;
    private List<String> b;
    private final Matcher c;
    private final CharSequence d;

    public j(Matcher matcher, CharSequence charSequence) {
        kotlin.jvm.internal.h.b(matcher, "matcher");
        kotlin.jvm.internal.h.b(charSequence, EvaluateItemInfo.ACTIONTYPE_INPUT);
        this.c = matcher;
        this.d = charSequence;
        this.f6984a = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MatchResult d() {
        return this.c;
    }

    @Override // kotlin.text.i
    public kotlin.d.c a() {
        kotlin.d.c b2;
        b2 = k.b(d());
        return b2;
    }

    /* loaded from: classes3.dex */
    public static final class b extends kotlin.collections.a<f> implements h {
        @Override // kotlin.collections.a, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        b() {
        }

        public boolean a(f fVar) {
            return super.contains(fVar);
        }

        @Override // kotlin.collections.a, java.util.Collection
        public final boolean contains(Object obj) {
            if (obj != null ? obj instanceof f : true) {
                return a((f) obj);
            }
            return false;
        }

        @Override // kotlin.collections.a
        public int a() {
            return j.this.d().groupCount() + 1;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<f> iterator() {
            return kotlin.f.c.a(kotlin.collections.j.e(kotlin.collections.j.a((Collection<?>) this)), new kotlin.jvm.a.b<Integer, f>() { // from class: kotlin.text.MatcherMatchResult$groups$1$iterator$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.a.b
                public /* synthetic */ f a(Integer num) {
                    return a(num.intValue());
                }

                public final f a(int i) {
                    return j.b.this.a(i);
                }
            }).a();
        }

        public f a(int i) {
            kotlin.d.c b;
            b = k.b(j.this.d(), i);
            if (b.f().intValue() < 0) {
                return null;
            }
            String group = j.this.d().group(i);
            kotlin.jvm.internal.h.a((Object) group, "matchResult.group(index)");
            return new f(group, b);
        }
    }

    /* loaded from: classes3.dex */
    public static final class a extends kotlin.collections.b<String> {
        a() {
        }

        public int a(String str) {
            return super.indexOf(str);
        }

        public int b(String str) {
            return super.lastIndexOf(str);
        }

        public boolean c(String str) {
            return super.contains(str);
        }

        @Override // kotlin.collections.a, java.util.Collection
        public final boolean contains(Object obj) {
            if (obj instanceof String) {
                return c((String) obj);
            }
            return false;
        }

        @Override // kotlin.collections.b, java.util.List
        public final int indexOf(Object obj) {
            if (obj instanceof String) {
                return a((String) obj);
            }
            return -1;
        }

        @Override // kotlin.collections.b, java.util.List
        public final int lastIndexOf(Object obj) {
            if (obj instanceof String) {
                return b((String) obj);
            }
            return -1;
        }

        @Override // kotlin.collections.a
        public int a() {
            return j.this.d().groupCount() + 1;
        }

        @Override // kotlin.collections.b, java.util.List
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String get(int i) {
            String group = j.this.d().group(i);
            return group != null ? group : "";
        }
    }

    @Override // kotlin.text.i
    public List<String> b() {
        if (this.b == null) {
            this.b = new a();
        }
        List<String> list = this.b;
        kotlin.jvm.internal.h.a(list);
        return list;
    }

    @Override // kotlin.text.i
    public i c() {
        i b2;
        int end = d().end() + (d().end() == d().start() ? 1 : 0);
        if (end > this.d.length()) {
            return null;
        }
        Matcher matcher = this.c.pattern().matcher(this.d);
        kotlin.jvm.internal.h.a((Object) matcher, "matcher.pattern().matcher(input)");
        b2 = k.b(matcher, end, this.d);
        return b2;
    }
}
