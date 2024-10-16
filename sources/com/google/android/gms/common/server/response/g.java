package com.google.android.gms.common.server.response;

import com.google.android.gms.common.server.response.FastParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigInteger;

/* loaded from: classes.dex */
final class g implements FastParser.a<BigInteger> {
    @Override // com.google.android.gms.common.server.response.FastParser.a
    public final /* synthetic */ BigInteger a(FastParser fastParser, BufferedReader bufferedReader) throws FastParser.ParseException, IOException {
        BigInteger f;
        f = fastParser.f(bufferedReader);
        return f;
    }
}
