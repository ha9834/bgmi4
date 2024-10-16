package com.tencent.abase.apollobuffer;

/* loaded from: classes2.dex */
public abstract class ApolloBufferBase {
    protected void BeforeDecode(ApolloBufferReader apolloBufferReader) {
    }

    protected void BeforeEncode(ApolloBufferWriter apolloBufferWriter) {
    }

    public abstract void ReadFrom(ApolloBufferReader apolloBufferReader);

    public abstract void WriteTo(ApolloBufferWriter apolloBufferWriter);

    public byte[] Encode() {
        try {
            ApolloBufferWriter apolloBufferWriter = new ApolloBufferWriter();
            BeforeEncode(apolloBufferWriter);
            WriteTo(apolloBufferWriter);
            return apolloBufferWriter.GetBufferData();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean Encode(ApolloBufferWriter apolloBufferWriter) {
        if (apolloBufferWriter == null) {
            return false;
        }
        try {
            BeforeEncode(apolloBufferWriter);
            WriteTo(apolloBufferWriter);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean Decode(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        try {
            ApolloBufferReader apolloBufferReader = new ApolloBufferReader(bArr);
            BeforeDecode(apolloBufferReader);
            ReadFrom(apolloBufferReader);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean Decode(ApolloBufferReader apolloBufferReader) {
        if (apolloBufferReader == null) {
            return false;
        }
        try {
            BeforeDecode(apolloBufferReader);
            ReadFrom(apolloBufferReader);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
