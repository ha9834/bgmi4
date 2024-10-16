package com.amazonaws.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.util.Base64;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public class SimpleTypeJsonUnmarshallers {

    /* loaded from: classes.dex */
    public static class StringJsonUnmarshaller implements Unmarshaller<String, JsonUnmarshallerContext> {
        private static StringJsonUnmarshaller instance;

        @Override // com.amazonaws.transform.Unmarshaller
        public String unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            return jsonUnmarshallerContext.getReader().nextString();
        }

        public static StringJsonUnmarshaller getInstance() {
            if (instance == null) {
                instance = new StringJsonUnmarshaller();
            }
            return instance;
        }
    }

    /* loaded from: classes.dex */
    public static class DoubleJsonUnmarshaller implements Unmarshaller<Double, JsonUnmarshallerContext> {
        private static DoubleJsonUnmarshaller instance;

        @Override // com.amazonaws.transform.Unmarshaller
        public Double unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            String nextString = jsonUnmarshallerContext.getReader().nextString();
            if (nextString == null) {
                return null;
            }
            return Double.valueOf(Double.parseDouble(nextString));
        }

        public static DoubleJsonUnmarshaller getInstance() {
            if (instance == null) {
                instance = new DoubleJsonUnmarshaller();
            }
            return instance;
        }
    }

    /* loaded from: classes.dex */
    public static class IntegerJsonUnmarshaller implements Unmarshaller<Integer, JsonUnmarshallerContext> {
        private static IntegerJsonUnmarshaller instance;

        @Override // com.amazonaws.transform.Unmarshaller
        public Integer unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            String nextString = jsonUnmarshallerContext.getReader().nextString();
            if (nextString == null) {
                return null;
            }
            return Integer.valueOf(Integer.parseInt(nextString));
        }

        public static IntegerJsonUnmarshaller getInstance() {
            if (instance == null) {
                instance = new IntegerJsonUnmarshaller();
            }
            return instance;
        }
    }

    /* loaded from: classes.dex */
    public static class BigIntegerJsonUnmarshaller implements Unmarshaller<BigInteger, JsonUnmarshallerContext> {
        private static BigIntegerJsonUnmarshaller instance;

        @Override // com.amazonaws.transform.Unmarshaller
        public BigInteger unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            String nextString = jsonUnmarshallerContext.getReader().nextString();
            if (nextString == null) {
                return null;
            }
            return new BigInteger(nextString);
        }

        public static BigIntegerJsonUnmarshaller getInstance() {
            if (instance == null) {
                instance = new BigIntegerJsonUnmarshaller();
            }
            return instance;
        }
    }

    /* loaded from: classes.dex */
    public static class BigDecimalJsonUnmarshaller implements Unmarshaller<BigDecimal, JsonUnmarshallerContext> {
        private static BigDecimalJsonUnmarshaller instance;

        @Override // com.amazonaws.transform.Unmarshaller
        public BigDecimal unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            String nextString = jsonUnmarshallerContext.getReader().nextString();
            if (nextString == null) {
                return null;
            }
            return new BigDecimal(nextString);
        }

        public static BigDecimalJsonUnmarshaller getInstance() {
            if (instance == null) {
                instance = new BigDecimalJsonUnmarshaller();
            }
            return instance;
        }
    }

    /* loaded from: classes.dex */
    public static class BooleanJsonUnmarshaller implements Unmarshaller<Boolean, JsonUnmarshallerContext> {
        private static BooleanJsonUnmarshaller instance;

        @Override // com.amazonaws.transform.Unmarshaller
        public Boolean unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            String nextString = jsonUnmarshallerContext.getReader().nextString();
            if (nextString == null) {
                return null;
            }
            return Boolean.valueOf(Boolean.parseBoolean(nextString));
        }

        public static BooleanJsonUnmarshaller getInstance() {
            if (instance == null) {
                instance = new BooleanJsonUnmarshaller();
            }
            return instance;
        }
    }

    /* loaded from: classes.dex */
    public static class FloatJsonUnmarshaller implements Unmarshaller<Float, JsonUnmarshallerContext> {
        private static FloatJsonUnmarshaller instance;

        @Override // com.amazonaws.transform.Unmarshaller
        public Float unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            String nextString = jsonUnmarshallerContext.getReader().nextString();
            if (nextString == null) {
                return null;
            }
            return Float.valueOf(nextString);
        }

        public static FloatJsonUnmarshaller getInstance() {
            if (instance == null) {
                instance = new FloatJsonUnmarshaller();
            }
            return instance;
        }
    }

    /* loaded from: classes.dex */
    public static class LongJsonUnmarshaller implements Unmarshaller<Long, JsonUnmarshallerContext> {
        private static LongJsonUnmarshaller instance;

        @Override // com.amazonaws.transform.Unmarshaller
        public Long unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            String nextString = jsonUnmarshallerContext.getReader().nextString();
            if (nextString == null) {
                return null;
            }
            return Long.valueOf(Long.parseLong(nextString));
        }

        public static LongJsonUnmarshaller getInstance() {
            if (instance == null) {
                instance = new LongJsonUnmarshaller();
            }
            return instance;
        }
    }

    /* loaded from: classes.dex */
    public static class ByteJsonUnmarshaller implements Unmarshaller<Byte, JsonUnmarshallerContext> {
        private static ByteJsonUnmarshaller instance;

        @Override // com.amazonaws.transform.Unmarshaller
        public Byte unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            String nextString = jsonUnmarshallerContext.getReader().nextString();
            if (nextString == null) {
                return null;
            }
            return Byte.valueOf(nextString);
        }

        public static ByteJsonUnmarshaller getInstance() {
            if (instance == null) {
                instance = new ByteJsonUnmarshaller();
            }
            return instance;
        }
    }

    /* loaded from: classes.dex */
    public static class DateJsonUnmarshaller implements Unmarshaller<Date, JsonUnmarshallerContext> {
        private static final int DATE_MULTIPLIER = 1000;
        private static DateJsonUnmarshaller instance;

        @Override // com.amazonaws.transform.Unmarshaller
        public Date unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            String nextString = jsonUnmarshallerContext.getReader().nextString();
            if (nextString == null) {
                return null;
            }
            try {
                return new Date(NumberFormat.getInstance(new Locale("en")).parse(nextString).longValue() * 1000);
            } catch (ParseException e) {
                throw new AmazonClientException("Unable to parse date '" + nextString + "':  " + e.getMessage(), e);
            }
        }

        public static DateJsonUnmarshaller getInstance() {
            if (instance == null) {
                instance = new DateJsonUnmarshaller();
            }
            return instance;
        }
    }

    /* loaded from: classes.dex */
    public static class ByteBufferJsonUnmarshaller implements Unmarshaller<ByteBuffer, JsonUnmarshallerContext> {
        private static ByteBufferJsonUnmarshaller instance;

        @Override // com.amazonaws.transform.Unmarshaller
        public ByteBuffer unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            return ByteBuffer.wrap(Base64.decode(jsonUnmarshallerContext.getReader().nextString()));
        }

        public static ByteBufferJsonUnmarshaller getInstance() {
            if (instance == null) {
                instance = new ByteBufferJsonUnmarshaller();
            }
            return instance;
        }
    }
}
