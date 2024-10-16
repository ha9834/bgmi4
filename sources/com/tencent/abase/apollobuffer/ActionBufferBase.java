package com.tencent.abase.apollobuffer;

/* loaded from: classes2.dex */
public abstract class ActionBufferBase extends ApolloBufferBase {
    public int Action;

    protected ActionBufferBase() {
        this.Action = 0;
    }

    public ActionBufferBase(int i) {
        this.Action = 0;
        this.Action = i;
    }

    @Override // com.tencent.abase.apollobuffer.ApolloBufferBase
    protected void BeforeEncode(ApolloBufferWriter apolloBufferWriter) {
        apolloBufferWriter.Write(this.Action);
    }

    @Override // com.tencent.abase.apollobuffer.ApolloBufferBase
    protected void BeforeDecode(ApolloBufferReader apolloBufferReader) {
        this.Action = apolloBufferReader.Read(this.Action);
    }
}
