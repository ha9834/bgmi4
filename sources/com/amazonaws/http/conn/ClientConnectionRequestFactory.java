package com.amazonaws.http.conn;

import com.amazonaws.metrics.AwsSdkMetrics;
import com.amazonaws.metrics.ServiceLatencyProvider;
import com.amazonaws.util.AWSServiceMetrics;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.conn.ClientConnectionRequest;

/* loaded from: classes.dex */
class ClientConnectionRequestFactory {
    private static final Log log = LogFactory.getLog(ClientConnectionRequestFactory.class);
    private static final Class<?>[] INTERFACES = {ClientConnectionRequest.class, Wrapped.class};

    ClientConnectionRequestFactory() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ClientConnectionRequest wrap(ClientConnectionRequest clientConnectionRequest) {
        if (clientConnectionRequest instanceof Wrapped) {
            throw new IllegalArgumentException();
        }
        return (ClientConnectionRequest) Proxy.newProxyInstance(ClientConnectionRequestFactory.class.getClassLoader(), INTERFACES, new Handler(clientConnectionRequest));
    }

    /* loaded from: classes.dex */
    private static class Handler implements InvocationHandler {
        private final ClientConnectionRequest orig;

        Handler(ClientConnectionRequest clientConnectionRequest) {
            this.orig = clientConnectionRequest;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                if ("getConnection".equals(method.getName())) {
                    ServiceLatencyProvider serviceLatencyProvider = new ServiceLatencyProvider(AWSServiceMetrics.HttpClientGetConnectionTime);
                    try {
                        return method.invoke(this.orig, objArr);
                    } finally {
                        AwsSdkMetrics.getServiceMetricCollector().collectLatency(serviceLatencyProvider.endTiming());
                    }
                }
                return method.invoke(this.orig, objArr);
            } catch (InvocationTargetException e) {
                ClientConnectionRequestFactory.log.debug("", e);
                throw e.getCause();
            }
        }
    }
}
