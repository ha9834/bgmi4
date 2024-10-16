package com.intlgame.foundation.swig;

/* loaded from: classes2.dex */
public class SingleLineLogHeader {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected SingleLineLogHeader(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(SingleLineLogHeader singleLineLogHeader) {
        if (singleLineLogHeader == null) {
            return 0L;
        }
        return singleLineLogHeader.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                INTLFoundationJNI.delete_SingleLineLogHeader(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setLog_len(long j) {
        INTLFoundationJNI.SingleLineLogHeader_log_len_set(this.swigCPtr, this, j);
    }

    public long getLog_len() {
        return INTLFoundationJNI.SingleLineLogHeader_log_len_get(this.swigCPtr, this);
    }

    public void setEncrypt_compress_flag(short s) {
        INTLFoundationJNI.SingleLineLogHeader_encrypt_compress_flag_set(this.swigCPtr, this, s);
    }

    public short getEncrypt_compress_flag() {
        return INTLFoundationJNI.SingleLineLogHeader_encrypt_compress_flag_get(this.swigCPtr, this);
    }

    public void setReserved_space(SWIGTYPE_p_unsigned_char sWIGTYPE_p_unsigned_char) {
        INTLFoundationJNI.SingleLineLogHeader_reserved_space_set(this.swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(sWIGTYPE_p_unsigned_char));
    }

    public SWIGTYPE_p_unsigned_char getReserved_space() {
        long SingleLineLogHeader_reserved_space_get = INTLFoundationJNI.SingleLineLogHeader_reserved_space_get(this.swigCPtr, this);
        if (SingleLineLogHeader_reserved_space_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_unsigned_char(SingleLineLogHeader_reserved_space_get, false);
    }

    public SingleLineLogHeader() {
        this(INTLFoundationJNI.new_SingleLineLogHeader(), true);
    }
}
