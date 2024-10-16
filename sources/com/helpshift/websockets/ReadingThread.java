package com.helpshift.websockets;

import com.helpshift.websockets.StateManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ReadingThread extends WebSocketThread {
    private long mCloseDelay;
    private WebSocketFrame mCloseFrame;
    private Object mCloseLock;
    private CloseTask mCloseTask;
    private Timer mCloseTimer;
    private List<WebSocketFrame> mContinuation;
    private boolean mNotWaitForCloseFrame;
    private final PerMessageCompressionExtension mPMCE;
    private boolean mStopRequested;

    public ReadingThread(WebSocket webSocket) {
        super("ReadingThread", webSocket, ThreadType.READING_THREAD);
        this.mContinuation = new ArrayList();
        this.mCloseLock = new Object();
        this.mPMCE = webSocket.getPerMessageCompressionExtension();
    }

    @Override // com.helpshift.websockets.WebSocketThread
    public void runMain() {
        try {
            main();
        } catch (Throwable th) {
            WebSocketException webSocketException = new WebSocketException(WebSocketError.UNEXPECTED_ERROR_IN_READING_THREAD, "An uncaught throwable was detected in the reading thread: " + th.getMessage(), th);
            ListenerManager listenerManager = this.mWebSocket.getListenerManager();
            listenerManager.callOnError(webSocketException);
            listenerManager.callOnUnexpectedError(webSocketException);
        }
        this.mWebSocket.onReadingThreadFinished(this.mCloseFrame);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void main() {
        this.mWebSocket.onReadingThreadStarted();
        while (true) {
            synchronized (this) {
                if (!this.mStopRequested) {
                    WebSocketFrame readFrame = readFrame();
                    if (readFrame == null || !handleFrame(readFrame)) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        waitForCloseFrame();
        cancelClose();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void requestStop(long j) {
        synchronized (this) {
            if (this.mStopRequested) {
                return;
            }
            this.mStopRequested = true;
            interrupt();
            this.mCloseDelay = j;
            scheduleClose();
        }
    }

    private void callOnTextMessage(byte[] bArr) {
        try {
            callOnTextMessage(Misc.toStringUTF8(bArr));
        } catch (Throwable th) {
            WebSocketException webSocketException = new WebSocketException(WebSocketError.TEXT_MESSAGE_CONSTRUCTION_ERROR, "Failed to convert payload data into a string: " + th.getMessage(), th);
            callOnError(webSocketException);
            this.mWebSocket.getListenerManager().callOnTextMessageError(webSocketException, bArr);
        }
    }

    private void callOnTextMessage(String str) {
        this.mWebSocket.getListenerManager().callOnTextMessage(str);
    }

    private void callOnBinaryMessage(byte[] bArr) {
        this.mWebSocket.getListenerManager().callOnBinaryMessage(bArr);
    }

    private void callOnError(WebSocketException webSocketException) {
        this.mWebSocket.getListenerManager().callOnError(webSocketException);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.helpshift.websockets.WebSocketFrame readFrame() {
        /*
            r7 = this;
            r0 = 0
            com.helpshift.websockets.WebSocket r1 = r7.mWebSocket     // Catch: com.helpshift.websockets.WebSocketException -> L15 java.io.IOException -> L19 java.io.InterruptedIOException -> L43
            com.helpshift.websockets.WebSocketInputStream r1 = r1.getInput()     // Catch: com.helpshift.websockets.WebSocketException -> L15 java.io.IOException -> L19 java.io.InterruptedIOException -> L43
            com.helpshift.websockets.WebSocketFrame r1 = r1.readFrame()     // Catch: com.helpshift.websockets.WebSocketException -> L15 java.io.IOException -> L19 java.io.InterruptedIOException -> L43
            r7.verifyFrame(r1)     // Catch: com.helpshift.websockets.WebSocketException -> Lf java.io.IOException -> L11 java.io.InterruptedIOException -> L13
            return r1
        Lf:
            r2 = move-exception
            goto L17
        L11:
            r2 = move-exception
            goto L1b
        L13:
            r2 = move-exception
            goto L45
        L15:
            r2 = move-exception
            r1 = r0
        L17:
            r3 = r2
            goto L66
        L19:
            r2 = move-exception
            r1 = r0
        L1b:
            boolean r3 = r7.mStopRequested
            if (r3 == 0) goto L26
            boolean r3 = r7.isInterrupted()
            if (r3 == 0) goto L26
            return r0
        L26:
            com.helpshift.websockets.WebSocketException r3 = new com.helpshift.websockets.WebSocketException
            com.helpshift.websockets.WebSocketError r4 = com.helpshift.websockets.WebSocketError.IO_ERROR_IN_READING
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "An I/O error occurred while a frame was being read from the web socket: "
            r5.append(r6)
            java.lang.String r6 = r2.getMessage()
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r3.<init>(r4, r5, r2)
            goto L66
        L43:
            r2 = move-exception
            r1 = r0
        L45:
            boolean r3 = r7.mStopRequested
            if (r3 == 0) goto L4a
            return r0
        L4a:
            com.helpshift.websockets.WebSocketException r3 = new com.helpshift.websockets.WebSocketException
            com.helpshift.websockets.WebSocketError r4 = com.helpshift.websockets.WebSocketError.INTERRUPTED_IN_READING
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Interruption occurred while a frame was being read from the web socket: "
            r5.append(r6)
            java.lang.String r6 = r2.getMessage()
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r3.<init>(r4, r5, r2)
        L66:
            boolean r2 = r3 instanceof com.helpshift.websockets.NoMoreFrameException
            r4 = 1
            if (r2 == 0) goto L76
            r7.mNotWaitForCloseFrame = r4
            com.helpshift.websockets.WebSocket r2 = r7.mWebSocket
            boolean r2 = r2.isMissingCloseFrameAllowed()
            if (r2 == 0) goto L76
            r4 = 0
        L76:
            if (r4 == 0) goto L84
            r7.callOnError(r3)
            com.helpshift.websockets.WebSocket r2 = r7.mWebSocket
            com.helpshift.websockets.ListenerManager r2 = r2.getListenerManager()
            r2.callOnFrameError(r3, r1)
        L84:
            com.helpshift.websockets.WebSocketFrame r1 = r7.createCloseFrame(r3)
            com.helpshift.websockets.WebSocket r2 = r7.mWebSocket
            r2.sendFrame(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.websockets.ReadingThread.readFrame():com.helpshift.websockets.WebSocketFrame");
    }

    private void verifyFrame(WebSocketFrame webSocketFrame) throws WebSocketException {
        verifyReservedBits(webSocketFrame);
        verifyFrameOpcode(webSocketFrame);
        verifyFrameMask(webSocketFrame);
        verifyFrameFragmentation(webSocketFrame);
        verifyFrameSize(webSocketFrame);
    }

    private void verifyReservedBits(WebSocketFrame webSocketFrame) throws WebSocketException {
        if (this.mWebSocket.isExtended()) {
            return;
        }
        verifyReservedBit1(webSocketFrame);
        verifyReservedBit2(webSocketFrame);
        verifyReservedBit3(webSocketFrame);
    }

    private void verifyReservedBit1(WebSocketFrame webSocketFrame) throws WebSocketException {
        if ((this.mPMCE == null || !verifyReservedBit1ForPMCE(webSocketFrame)) && webSocketFrame.getRsv1()) {
            throw new WebSocketException(WebSocketError.UNEXPECTED_RESERVED_BIT, "The RSV1 bit of a frame is set unexpectedly.");
        }
    }

    private boolean verifyReservedBit1ForPMCE(WebSocketFrame webSocketFrame) throws WebSocketException {
        return webSocketFrame.isTextFrame() || webSocketFrame.isBinaryFrame();
    }

    private void verifyReservedBit2(WebSocketFrame webSocketFrame) throws WebSocketException {
        if (webSocketFrame.getRsv2()) {
            throw new WebSocketException(WebSocketError.UNEXPECTED_RESERVED_BIT, "The RSV2 bit of a frame is set unexpectedly.");
        }
    }

    private void verifyReservedBit3(WebSocketFrame webSocketFrame) throws WebSocketException {
        if (webSocketFrame.getRsv3()) {
            throw new WebSocketException(WebSocketError.UNEXPECTED_RESERVED_BIT, "The RSV3 bit of a frame is set unexpectedly.");
        }
    }

    private void verifyFrameOpcode(WebSocketFrame webSocketFrame) throws WebSocketException {
        int opcode = webSocketFrame.getOpcode();
        switch (opcode) {
            case 0:
            case 1:
            case 2:
                return;
            default:
                switch (opcode) {
                    case 8:
                    case 9:
                    case 10:
                        return;
                    default:
                        if (this.mWebSocket.isExtended()) {
                            return;
                        }
                        throw new WebSocketException(WebSocketError.UNKNOWN_OPCODE, "A frame has an unknown opcode: 0x" + Integer.toHexString(webSocketFrame.getOpcode()));
                }
        }
    }

    private void verifyFrameMask(WebSocketFrame webSocketFrame) throws WebSocketException {
        if (webSocketFrame.getMask()) {
            throw new WebSocketException(WebSocketError.FRAME_MASKED, "A frame from the server is masked.");
        }
    }

    private void verifyFrameFragmentation(WebSocketFrame webSocketFrame) throws WebSocketException {
        if (webSocketFrame.isControlFrame()) {
            if (!webSocketFrame.getFin()) {
                throw new WebSocketException(WebSocketError.FRAGMENTED_CONTROL_FRAME, "A control frame is fragmented.");
            }
            return;
        }
        boolean z = this.mContinuation.size() != 0;
        if (webSocketFrame.isContinuationFrame()) {
            if (!z) {
                throw new WebSocketException(WebSocketError.UNEXPECTED_CONTINUATION_FRAME, "A continuation frame was detected although a continuation had not started.");
            }
        } else if (z) {
            throw new WebSocketException(WebSocketError.CONTINUATION_NOT_CLOSED, "A non-control frame was detected although the existing continuation had not been closed.");
        }
    }

    private void verifyFrameSize(WebSocketFrame webSocketFrame) throws WebSocketException {
        byte[] payload;
        if (webSocketFrame.isControlFrame() && (payload = webSocketFrame.getPayload()) != null && 125 < payload.length) {
            throw new WebSocketException(WebSocketError.TOO_LONG_CONTROL_FRAME_PAYLOAD, "The payload size of a control frame exceeds the maximum size (125 bytes): " + payload.length);
        }
    }

    private WebSocketFrame createCloseFrame(WebSocketException webSocketException) {
        int i = 1002;
        switch (webSocketException.getError()) {
            case INSUFFICENT_DATA:
            case INVALID_PAYLOAD_LENGTH:
            case NO_MORE_FRAME:
            case NON_ZERO_RESERVED_BITS:
            case UNEXPECTED_RESERVED_BIT:
            case UNKNOWN_OPCODE:
            case FRAME_MASKED:
            case FRAGMENTED_CONTROL_FRAME:
            case UNEXPECTED_CONTINUATION_FRAME:
            case CONTINUATION_NOT_CLOSED:
            case TOO_LONG_CONTROL_FRAME_PAYLOAD:
                break;
            case TOO_LONG_PAYLOAD:
            case INSUFFICIENT_MEMORY_FOR_PAYLOAD:
                i = 1009;
                break;
            case INTERRUPTED_IN_READING:
            case IO_ERROR_IN_READING:
                i = 1008;
                break;
            default:
                i = 1008;
                break;
        }
        return WebSocketFrame.createCloseFrame(i, webSocketException.getMessage());
    }

    private boolean handleFrame(WebSocketFrame webSocketFrame) {
        this.mWebSocket.getListenerManager().callOnFrame(webSocketFrame);
        int opcode = webSocketFrame.getOpcode();
        switch (opcode) {
            case 0:
                return handleContinuationFrame(webSocketFrame);
            case 1:
                return handleTextFrame(webSocketFrame);
            case 2:
                return handleBinaryFrame(webSocketFrame);
            default:
                switch (opcode) {
                    case 8:
                        return handleCloseFrame(webSocketFrame);
                    case 9:
                        return handlePingFrame(webSocketFrame);
                    case 10:
                        return handlePongFrame(webSocketFrame);
                    default:
                        return true;
                }
        }
    }

    private boolean handleContinuationFrame(WebSocketFrame webSocketFrame) {
        this.mWebSocket.getListenerManager().callOnContinuationFrame(webSocketFrame);
        this.mContinuation.add(webSocketFrame);
        if (!webSocketFrame.getFin()) {
            return true;
        }
        byte[] message = getMessage(this.mContinuation);
        if (message == null) {
            return false;
        }
        if (this.mContinuation.get(0).isTextFrame()) {
            callOnTextMessage(message);
        } else {
            callOnBinaryMessage(message);
        }
        this.mContinuation.clear();
        return true;
    }

    private byte[] getMessage(List<WebSocketFrame> list) {
        byte[] concatenatePayloads = concatenatePayloads(this.mContinuation);
        if (concatenatePayloads == null) {
            return null;
        }
        return (this.mPMCE == null || !list.get(0).getRsv1()) ? concatenatePayloads : decompress(concatenatePayloads);
    }

    private byte[] concatenatePayloads(List<WebSocketFrame> list) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Iterator<WebSocketFrame> it = list.iterator();
            while (it.hasNext()) {
                byte[] payload = it.next().getPayload();
                if (payload != null && payload.length != 0) {
                    byteArrayOutputStream.write(payload);
                }
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException | OutOfMemoryError e) {
            WebSocketException webSocketException = new WebSocketException(WebSocketError.MESSAGE_CONSTRUCTION_ERROR, "Failed to concatenate payloads of multiple frames to construct a message: " + e.getMessage(), e);
            callOnError(webSocketException);
            this.mWebSocket.getListenerManager().callOnMessageError(webSocketException, list);
            this.mWebSocket.sendFrame(WebSocketFrame.createCloseFrame(1009, webSocketException.getMessage()));
            return null;
        }
    }

    private byte[] getMessage(WebSocketFrame webSocketFrame) {
        byte[] payload = webSocketFrame.getPayload();
        return (this.mPMCE == null || !webSocketFrame.getRsv1()) ? payload : decompress(payload);
    }

    private byte[] decompress(byte[] bArr) {
        try {
            return this.mPMCE.decompress(bArr);
        } catch (WebSocketException e) {
            callOnError(e);
            this.mWebSocket.getListenerManager().callOnMessageDecompressionError(e, bArr);
            this.mWebSocket.sendFrame(WebSocketFrame.createCloseFrame(1003, e.getMessage()));
            return null;
        }
    }

    private boolean handleTextFrame(WebSocketFrame webSocketFrame) {
        this.mWebSocket.getListenerManager().callOnTextFrame(webSocketFrame);
        if (!webSocketFrame.getFin()) {
            this.mContinuation.add(webSocketFrame);
            return true;
        }
        callOnTextMessage(getMessage(webSocketFrame));
        return true;
    }

    private boolean handleBinaryFrame(WebSocketFrame webSocketFrame) {
        this.mWebSocket.getListenerManager().callOnBinaryFrame(webSocketFrame);
        if (!webSocketFrame.getFin()) {
            this.mContinuation.add(webSocketFrame);
            return true;
        }
        callOnBinaryMessage(getMessage(webSocketFrame));
        return true;
    }

    private boolean handleCloseFrame(WebSocketFrame webSocketFrame) {
        boolean z;
        StateManager stateManager = this.mWebSocket.getStateManager();
        this.mCloseFrame = webSocketFrame;
        synchronized (stateManager) {
            WebSocketState state = stateManager.getState();
            if (state == WebSocketState.CLOSING || state == WebSocketState.CLOSED) {
                z = false;
            } else {
                stateManager.changeToClosing(StateManager.CloseInitiator.SERVER);
                this.mWebSocket.sendFrame(webSocketFrame);
                z = true;
            }
        }
        if (z) {
            this.mWebSocket.getListenerManager().callOnStateChanged(WebSocketState.CLOSING);
        }
        this.mWebSocket.getListenerManager().callOnCloseFrame(webSocketFrame);
        return false;
    }

    private boolean handlePingFrame(WebSocketFrame webSocketFrame) {
        this.mWebSocket.getListenerManager().callOnPingFrame(webSocketFrame);
        this.mWebSocket.sendFrame(WebSocketFrame.createPongFrame(webSocketFrame.getPayload()));
        return true;
    }

    private boolean handlePongFrame(WebSocketFrame webSocketFrame) {
        this.mWebSocket.getListenerManager().callOnPongFrame(webSocketFrame);
        return true;
    }

    private void waitForCloseFrame() {
        if (!this.mNotWaitForCloseFrame && this.mCloseFrame == null) {
            scheduleClose();
            do {
                try {
                    WebSocketFrame readFrame = this.mWebSocket.getInput().readFrame();
                    if (readFrame.isCloseFrame()) {
                        this.mCloseFrame = readFrame;
                        return;
                    }
                } catch (Throwable unused) {
                    return;
                }
            } while (!isInterrupted());
        }
    }

    private void scheduleClose() {
        synchronized (this.mCloseLock) {
            cancelCloseTask();
            scheduleCloseTask();
        }
    }

    private void scheduleCloseTask() {
        this.mCloseTask = new CloseTask();
        this.mCloseTimer = new Timer("ReadingThreadCloseTimer");
        this.mCloseTimer.schedule(this.mCloseTask, this.mCloseDelay);
    }

    private void cancelClose() {
        synchronized (this.mCloseLock) {
            cancelCloseTask();
        }
    }

    private void cancelCloseTask() {
        Timer timer = this.mCloseTimer;
        if (timer != null) {
            timer.cancel();
            this.mCloseTimer = null;
        }
        CloseTask closeTask = this.mCloseTask;
        if (closeTask != null) {
            closeTask.cancel();
            this.mCloseTask = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CloseTask extends TimerTask {
        CloseTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                ReadingThread.this.mWebSocket.getSocket().close();
            } catch (Throwable unused) {
            }
        }
    }
}
