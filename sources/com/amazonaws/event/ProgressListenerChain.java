package com.amazonaws.event;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* loaded from: classes.dex */
public class ProgressListenerChain implements ProgressListener {
    private static final Log log = LogFactory.getLog(ProgressListenerChain.class);
    private final List<ProgressListener> listeners;
    private final ProgressEventFilter progressEventFilter;

    /* loaded from: classes.dex */
    public interface ProgressEventFilter {
        ProgressEvent filter(ProgressEvent progressEvent);
    }

    public ProgressListenerChain(ProgressListener... progressListenerArr) {
        this(null, progressListenerArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ProgressListenerChain(ProgressEventFilter progressEventFilter, ProgressListener... progressListenerArr) {
        this.listeners = new CopyOnWriteArrayList();
        if (progressListenerArr == null) {
            throw new IllegalArgumentException("Progress Listeners cannot be null.");
        }
        for (ProgressListener progressListener : progressListenerArr) {
            addProgressListener(progressListener);
        }
        this.progressEventFilter = progressEventFilter;
    }

    public synchronized void addProgressListener(ProgressListener progressListener) {
        if (progressListener == null) {
            return;
        }
        this.listeners.add(progressListener);
    }

    public synchronized void removeProgressListener(ProgressListener progressListener) {
        if (progressListener == null) {
            return;
        }
        this.listeners.remove(progressListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<ProgressListener> getListeners() {
        return this.listeners;
    }

    @Override // com.amazonaws.event.ProgressListener
    public void progressChanged(ProgressEvent progressEvent) {
        ProgressEventFilter progressEventFilter = this.progressEventFilter;
        if (progressEventFilter == null || (progressEvent = progressEventFilter.filter(progressEvent)) != null) {
            Iterator<ProgressListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                try {
                    it.next().progressChanged(progressEvent);
                } catch (RuntimeException e) {
                    log.warn("Couldn't update progress listener", e);
                }
            }
        }
    }
}
