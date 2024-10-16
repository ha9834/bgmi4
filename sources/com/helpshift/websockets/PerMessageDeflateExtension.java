package com.helpshift.websockets;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.util.Map;

/* loaded from: classes2.dex */
class PerMessageDeflateExtension extends PerMessageCompressionExtension {
    private static final String CLIENT_MAX_WINDOW_BITS = "client_max_window_bits";
    private static final String CLIENT_NO_CONTEXT_TAKEOVER = "client_no_context_takeover";
    private static final byte[] COMPRESSION_TERMINATOR = {0, 0, -1, -1};
    private static final int INCOMING_SLIDING_WINDOW_MARGIN = 1024;
    private static final int MAX_BITS = 15;
    private static final int MAX_WINDOW_SIZE = 32768;
    private static final int MIN_BITS = 8;
    private static final int MIN_WINDOW_SIZE = 256;
    private static final String SERVER_MAX_WINDOW_BITS = "server_max_window_bits";
    private static final String SERVER_NO_CONTEXT_TAKEOVER = "server_no_context_takeover";
    private boolean mClientNoContextTakeover;
    private int mClientWindowSize;
    private ByteArray mIncomingSlidingWindow;
    private int mIncomingSlidingWindowBufferSize;
    private boolean mServerNoContextTakeover;
    private int mServerWindowSize;

    public PerMessageDeflateExtension() {
        super(WebSocketExtension.PERMESSAGE_DEFLATE);
        this.mServerWindowSize = 32768;
        this.mClientWindowSize = 32768;
    }

    public PerMessageDeflateExtension(String str) {
        super(str);
        this.mServerWindowSize = 32768;
        this.mClientWindowSize = 32768;
    }

    private static byte[] adjustCompressedData(byte[] bArr) throws FormatException {
        ByteArray byteArray = new ByteArray(bArr.length + 1);
        byteArray.put(bArr);
        int[] iArr = new int[1];
        boolean[] zArr = new boolean[1];
        do {
        } while (skipBlock(byteArray, iArr, zArr));
        if (zArr[0]) {
            return byteArray.toBytes(0, (((iArr[0] - 1) / 8) + 1) - 4);
        }
        appendEmptyBlock(byteArray, iArr);
        return byteArray.toBytes(0, ((iArr[0] - 1) / 8) + 1);
    }

    private static void appendEmptyBlock(ByteArray byteArray, int[] iArr) {
        int i = iArr[0] % 8;
        if (i != 0) {
            switch (i) {
            }
            iArr[0] = iArr[0] + 3;
        }
        byteArray.put(0);
        iArr[0] = iArr[0] + 3;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0013. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0053 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005a A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean skipBlock(com.helpshift.websockets.ByteArray r5, int[] r6, boolean[] r7) throws com.helpshift.websockets.FormatException {
        /*
            boolean r0 = r5.readBit(r6)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto Le
            r3 = r6[r2]
            int r3 = r3 - r1
            r5.clearBit(r3)
        Le:
            r3 = 2
            int r4 = r5.readBits(r6, r3)
            switch(r4) {
                case 0: goto L3d;
                case 1: goto L38;
                case 2: goto L34;
                default: goto L16;
            }
        L16:
            java.lang.Object[] r5 = new java.lang.Object[r3]
            java.lang.Class<com.helpshift.websockets.PerMessageDeflateExtension> r7 = com.helpshift.websockets.PerMessageDeflateExtension.class
            java.lang.String r7 = r7.getSimpleName()
            r5[r2] = r7
            r6 = r6[r2]
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r5[r1] = r6
            java.lang.String r6 = "[%s] Bad compression type '11' at the bit index '%d'."
            java.lang.String r5 = java.lang.String.format(r6, r5)
            com.helpshift.websockets.FormatException r6 = new com.helpshift.websockets.FormatException
            r6.<init>(r5)
            throw r6
        L34:
            skipDynamicBlock(r5, r6)
            goto L3b
        L38:
            skipFixedBlock(r5, r6)
        L3b:
            r3 = 0
            goto L46
        L3d:
            int r3 = skipPlainBlock(r5, r6)
            if (r3 != 0) goto L45
            r3 = 1
            goto L46
        L45:
            r3 = 0
        L46:
            int r5 = r5.length()
            r6 = r6[r2]
            int r6 = r6 / 8
            if (r5 > r6) goto L51
            r0 = 1
        L51:
            if (r0 == 0) goto L57
            if (r3 == 0) goto L57
            r7[r2] = r1
        L57:
            if (r0 != 0) goto L5a
            goto L5b
        L5a:
            r1 = 0
        L5b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.websockets.PerMessageDeflateExtension.skipBlock(com.helpshift.websockets.ByteArray, int[], boolean[]):boolean");
    }

    private static int skipPlainBlock(ByteArray byteArray, int[] iArr) {
        int i = ((iArr[0] + 7) & (-8)) / 8;
        int i2 = (byteArray.get(i) & DeviceInfos.NETWORK_TYPE_UNCONNECTED) + ((byteArray.get(i + 1) & DeviceInfos.NETWORK_TYPE_UNCONNECTED) * 256);
        iArr[0] = (i + 4 + i2) * 8;
        return i2;
    }

    private static void skipFixedBlock(ByteArray byteArray, int[] iArr) throws FormatException {
        skipData(byteArray, iArr, FixedLiteralLengthHuffman.getInstance(), FixedDistanceHuffman.getInstance());
    }

    private static void skipDynamicBlock(ByteArray byteArray, int[] iArr) throws FormatException {
        Huffman[] huffmanArr = new Huffman[2];
        DeflateUtil.readDynamicTables(byteArray, iArr, huffmanArr);
        skipData(byteArray, iArr, huffmanArr[0], huffmanArr[1]);
    }

    private static void skipData(ByteArray byteArray, int[] iArr, Huffman huffman, Huffman huffman2) throws FormatException {
        while (true) {
            int readSym = huffman.readSym(byteArray, iArr);
            if (readSym == 256) {
                return;
            }
            if (readSym < 0 || readSym > 255) {
                DeflateUtil.readLength(byteArray, iArr, readSym);
                DeflateUtil.readDistance(byteArray, iArr, huffman2);
            }
        }
    }

    @Override // com.helpshift.websockets.WebSocketExtension
    void validate() throws WebSocketException {
        for (Map.Entry<String, String> entry : getParameters().entrySet()) {
            validateParameter(entry.getKey(), entry.getValue());
        }
        this.mIncomingSlidingWindowBufferSize = this.mServerWindowSize + 1024;
    }

    public boolean isServerNoContextTakeover() {
        return this.mServerNoContextTakeover;
    }

    public boolean isClientNoContextTakeover() {
        return this.mClientNoContextTakeover;
    }

    public int getServerWindowSize() {
        return this.mServerWindowSize;
    }

    public int getClientWindowSize() {
        return this.mClientWindowSize;
    }

    private void validateParameter(String str, String str2) throws WebSocketException {
        if (SERVER_NO_CONTEXT_TAKEOVER.equals(str)) {
            this.mServerNoContextTakeover = true;
            return;
        }
        if (CLIENT_NO_CONTEXT_TAKEOVER.equals(str)) {
            this.mClientNoContextTakeover = true;
            return;
        }
        if (SERVER_MAX_WINDOW_BITS.equals(str)) {
            this.mServerWindowSize = computeWindowSize(str, str2);
            return;
        }
        if (CLIENT_MAX_WINDOW_BITS.equals(str)) {
            this.mClientWindowSize = computeWindowSize(str, str2);
            return;
        }
        throw new WebSocketException(WebSocketError.PERMESSAGE_DEFLATE_UNSUPPORTED_PARAMETER, "permessage-deflate extension contains an unsupported parameter: " + str);
    }

    private int computeWindowSize(String str, String str2) throws WebSocketException {
        int extractMaxWindowBits = extractMaxWindowBits(str, str2);
        int i = 256;
        for (int i2 = 8; i2 < extractMaxWindowBits; i2++) {
            i *= 2;
        }
        return i;
    }

    private int extractMaxWindowBits(String str, String str2) throws WebSocketException {
        int parseMaxWindowBits = parseMaxWindowBits(str2);
        if (parseMaxWindowBits >= 0) {
            return parseMaxWindowBits;
        }
        throw new WebSocketException(WebSocketError.PERMESSAGE_DEFLATE_INVALID_MAX_WINDOW_BITS, String.format("The value of %s parameter of permessage-deflate extension is invalid: %s", str, str2));
    }

    private int parseMaxWindowBits(String str) {
        if (str == null) {
            return -1;
        }
        try {
            int parseInt = Integer.parseInt(str);
            if (parseInt < 8 || 15 < parseInt) {
                return -1;
            }
            return parseInt;
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.helpshift.websockets.PerMessageCompressionExtension
    public byte[] decompress(byte[] bArr) throws WebSocketException {
        ByteArray byteArray = new ByteArray(bArr.length + COMPRESSION_TERMINATOR.length);
        byteArray.put(bArr);
        byteArray.put(COMPRESSION_TERMINATOR);
        if (this.mIncomingSlidingWindow == null) {
            this.mIncomingSlidingWindow = new ByteArray(this.mIncomingSlidingWindowBufferSize);
        }
        int length = this.mIncomingSlidingWindow.length();
        try {
            DeflateDecompressor.decompress(byteArray, this.mIncomingSlidingWindow);
            byte[] bytes = this.mIncomingSlidingWindow.toBytes(length);
            this.mIncomingSlidingWindow.shrink(this.mIncomingSlidingWindowBufferSize);
            if (this.mServerNoContextTakeover) {
                this.mIncomingSlidingWindow.clear();
            }
            return bytes;
        } catch (Exception e) {
            throw new WebSocketException(WebSocketError.DECOMPRESSION_ERROR, String.format("Failed to decompress the message: %s", e.getMessage()), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.helpshift.websockets.PerMessageCompressionExtension
    public byte[] compress(byte[] bArr) throws WebSocketException {
        if (!canCompress(bArr)) {
            return bArr;
        }
        try {
            return adjustCompressedData(DeflateCompressor.compress(bArr));
        } catch (Exception e) {
            throw new WebSocketException(WebSocketError.COMPRESSION_ERROR, String.format("Failed to compress the message: %s", e.getMessage()), e);
        }
    }

    private boolean canCompress(byte[] bArr) {
        int i = this.mClientWindowSize;
        return i == 32768 || bArr.length < i;
    }
}
