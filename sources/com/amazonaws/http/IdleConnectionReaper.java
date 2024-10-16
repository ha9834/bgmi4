package com.amazonaws.http;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.conn.ClientConnectionManager;

/* loaded from: classes.dex */
public final class IdleConnectionReaper extends Thread {
    private static final int MINUTE_IN_SECONDS = 60;
    private static final int PERIOD_MILLISECONDS = 60000;
    private static IdleConnectionReaper instance;
    private volatile boolean shuttingDown;
    private static final ArrayList<ClientConnectionManager> CONNECTION_MANAGERS = new ArrayList<>();
    static final Log log = LogFactory.getLog(IdleConnectionReaper.class);

    private IdleConnectionReaper() {
        super("java-sdk-http-connection-reaper");
        setDaemon(true);
    }

    public static synchronized boolean registerConnectionManager(ClientConnectionManager clientConnectionManager) {
        boolean add;
        synchronized (IdleConnectionReaper.class) {
            if (instance == null) {
                instance = new IdleConnectionReaper();
                instance.start();
            }
            add = CONNECTION_MANAGERS.add(clientConnectionManager);
        }
        return add;
    }

    public static synchronized boolean removeConnectionManager(ClientConnectionManager clientConnectionManager) {
        boolean remove;
        synchronized (IdleConnectionReaper.class) {
            remove = CONNECTION_MANAGERS.remove(clientConnectionManager);
            if (CONNECTION_MANAGERS.isEmpty()) {
                shutdown();
            }
        }
        return remove;
    }

    private void markShuttingDown() {
        this.shuttingDown = true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        List list;
        while (!this.shuttingDown) {
            try {
                Thread.sleep(60000L);
                synchronized (IdleConnectionReaper.class) {
                    list = (List) CONNECTION_MANAGERS.clone();
                }
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    try {
                        ((ClientConnectionManager) it.next()).closeIdleConnections(60L, TimeUnit.SECONDS);
                    } catch (Exception e) {
                        log.warn("Unable to close idle connections", e);
                    }
                }
            } catch (Throwable th) {
                log.debug("Reaper thread: ", th);
            }
        }
        log.debug("Shutting down reaper thread.");
    }

    public static synchronized boolean shutdown() {
        synchronized (IdleConnectionReaper.class) {
            if (instance == null) {
                return false;
            }
            instance.markShuttingDown();
            instance.interrupt();
            CONNECTION_MANAGERS.clear();
            instance = null;
            return true;
        }
    }

    static synchronized int size() {
        int size;
        synchronized (IdleConnectionReaper.class) {
            size = CONNECTION_MANAGERS.size();
        }
        return size;
    }
}
