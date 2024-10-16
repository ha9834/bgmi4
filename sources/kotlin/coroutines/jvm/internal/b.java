package kotlin.coroutines.jvm.internal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface b {
    int a() default 1;

    String b() default "";

    int[] c() default {};

    String d() default "";

    String e() default "";
}
