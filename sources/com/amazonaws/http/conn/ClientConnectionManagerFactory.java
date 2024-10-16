package com.amazonaws.http.conn;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionRequest;

/* loaded from: classes.dex */
public class ClientConnectionManagerFactory {
    private static final Log log = LogFactory.getLog(ClientConnectionManagerFactory.class);

    public static ClientConnectionManager wrap(ClientConnectionManager clientConnectionManager) {
        if (clientConnectionManager instanceof Wrapped) {
            throw new IllegalArgumentException();
        }
        return (ClientConnectionManager) Proxy.newProxyInstance(ClientConnectionManagerFactory.class.getClassLoader(), new Class[]{ClientConnectionManager.class, Wrapped.class}, new Handler(clientConnectionManager));
    }

    /* loaded from: classes.dex */
    private static class Handler implements InvocationHandler {
        private final ClientConnectionManager orig;

        Handler(ClientConnectionManager clientConnectionManager) {
            this.orig = clientConnectionManager;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                Object invoke = method.invoke(this.orig, objArr);
                return invoke instanceof ClientConnectionRequest ? ClientConnectionRequestFactory.wrap((ClientConnectionRequest) invoke) : invoke;
            } catch (InvocationTargetException e) {
                ClientConnectionManagerFactory.log.debug("", e);
                throw e.getCause();
            }
        }
    }
}
