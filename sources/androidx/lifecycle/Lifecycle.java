package androidx.lifecycle;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public abstract class Lifecycle {

    /* renamed from: a, reason: collision with root package name */
    AtomicReference<Object> f767a = new AtomicReference<>();

    public abstract State a();

    public abstract void a(j jVar);

    public abstract void b(j jVar);

    /* loaded from: classes.dex */
    public enum Event {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;

        public static Event a(State state) {
            switch (state) {
                case CREATED:
                    return ON_DESTROY;
                case STARTED:
                    return ON_STOP;
                case RESUMED:
                    return ON_PAUSE;
                default:
                    return null;
            }
        }

        public static Event b(State state) {
            int i = AnonymousClass1.f768a[state.ordinal()];
            if (i == 5) {
                return ON_CREATE;
            }
            switch (i) {
                case 1:
                    return ON_START;
                case 2:
                    return ON_RESUME;
                default:
                    return null;
            }
        }

        public static Event c(State state) {
            switch (state) {
                case CREATED:
                    return ON_CREATE;
                case STARTED:
                    return ON_START;
                case RESUMED:
                    return ON_RESUME;
                default:
                    return null;
            }
        }

        public State a() {
            switch (this) {
                case ON_CREATE:
                case ON_STOP:
                    return State.CREATED;
                case ON_START:
                case ON_PAUSE:
                    return State.STARTED;
                case ON_RESUME:
                    return State.RESUMED;
                case ON_DESTROY:
                    return State.DESTROYED;
                default:
                    throw new IllegalArgumentException(this + " has no target state");
            }
        }
    }

    /* loaded from: classes.dex */
    public enum State {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public boolean a(State state) {
            return compareTo(state) >= 0;
        }
    }
}
