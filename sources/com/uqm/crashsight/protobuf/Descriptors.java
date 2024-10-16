package com.uqm.crashsight.protobuf;

import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.games.request.GameRequest;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import com.uqm.crashsight.protobuf.DescriptorProtos;
import com.uqm.crashsight.protobuf.FieldSet;
import com.uqm.crashsight.protobuf.Internal;
import com.uqm.crashsight.protobuf.Message;
import com.uqm.crashsight.protobuf.MessageLite;
import com.uqm.crashsight.protobuf.TextFormat;
import com.uqm.crashsight.protobuf.WireFormat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public final class Descriptors {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f6675a = Logger.getLogger(Descriptors.class.getName());

    static /* synthetic */ String a(FileDescriptor fileDescriptor, Descriptor descriptor, String str) {
        if (descriptor != null) {
            return descriptor.c() + '.' + str;
        }
        String e = fileDescriptor.e();
        if (e.isEmpty()) {
            return str;
        }
        return e + '.' + str;
    }

    /* loaded from: classes3.dex */
    public static final class FileDescriptor extends GenericDescriptor {

        /* renamed from: a, reason: collision with root package name */
        private DescriptorProtos.FileDescriptorProto f6687a;
        private final Descriptor[] b;
        private final EnumDescriptor[] c;
        private final ServiceDescriptor[] d;
        private final FieldDescriptor[] e;
        private final FileDescriptor[] f;
        private final DescriptorPool g;

        @Deprecated
        /* loaded from: classes3.dex */
        public interface InternalDescriptorAssigner {
        }

        @Override // com.uqm.crashsight.protobuf.Descriptors.GenericDescriptor
        public final FileDescriptor d() {
            return this;
        }

        @Override // com.uqm.crashsight.protobuf.Descriptors.GenericDescriptor
        public final /* bridge */ /* synthetic */ Message j() {
            return this.f6687a;
        }

        public final DescriptorProtos.FileDescriptorProto a() {
            return this.f6687a;
        }

        @Override // com.uqm.crashsight.protobuf.Descriptors.GenericDescriptor
        public final String b() {
            return this.f6687a.f();
        }

        @Override // com.uqm.crashsight.protobuf.Descriptors.GenericDescriptor
        public final String c() {
            return this.f6687a.f();
        }

        public final String e() {
            return this.f6687a.h();
        }

        public final DescriptorProtos.FileOptions f() {
            return this.f6687a.s();
        }

        public final List<Descriptor> g() {
            return Collections.unmodifiableList(Arrays.asList(this.b));
        }

        public final List<FileDescriptor> h() {
            return Collections.unmodifiableList(Arrays.asList(this.f));
        }

        /* loaded from: classes3.dex */
        public enum Syntax {
            UNKNOWN("unknown"),
            PROTO2("proto2"),
            PROTO3("proto3");

            private final String d;

            Syntax(String str) {
                this.d = str;
            }
        }

        public final Syntax i() {
            if (Syntax.PROTO3.d.equals(this.f6687a.w())) {
                return Syntax.PROTO3;
            }
            return Syntax.PROTO2;
        }

        private static FileDescriptor a(DescriptorProtos.FileDescriptorProto fileDescriptorProto, FileDescriptor[] fileDescriptorArr, boolean z) throws DescriptorValidationException {
            FileDescriptor fileDescriptor = new FileDescriptor(fileDescriptorProto, fileDescriptorArr, new DescriptorPool(fileDescriptorArr, true), true);
            for (Descriptor descriptor : fileDescriptor.b) {
                descriptor.k();
            }
            for (ServiceDescriptor serviceDescriptor : fileDescriptor.d) {
                ServiceDescriptor.a(serviceDescriptor);
            }
            for (FieldDescriptor fieldDescriptor : fileDescriptor.e) {
                FieldDescriptor.a(fieldDescriptor);
            }
            return fileDescriptor;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static FileDescriptor a(String[] strArr, FileDescriptor[] fileDescriptorArr) {
            String sb;
            if (strArr.length == 1) {
                sb = strArr[0];
            } else {
                StringBuilder sb2 = new StringBuilder();
                for (String str : strArr) {
                    sb2.append(str);
                }
                sb = sb2.toString();
            }
            try {
                DescriptorProtos.FileDescriptorProto a2 = DescriptorProtos.FileDescriptorProto.a(sb.getBytes(Internal.b));
                try {
                    return a(a2, fileDescriptorArr, true);
                } catch (DescriptorValidationException e) {
                    throw new IllegalArgumentException("Invalid embedded descriptor for \"" + a2.f() + "\".", e);
                }
            } catch (InvalidProtocolBufferException e2) {
                throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", e2);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        private FileDescriptor(DescriptorProtos.FileDescriptorProto fileDescriptorProto, FileDescriptor[] fileDescriptorArr, DescriptorPool descriptorPool, boolean z) throws DescriptorValidationException {
            super(0 == true ? 1 : 0);
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            Object[] objArr3 = 0;
            this.g = descriptorPool;
            this.f6687a = fileDescriptorProto;
            fileDescriptorArr.clone();
            HashMap hashMap = new HashMap();
            for (FileDescriptor fileDescriptor : fileDescriptorArr) {
                hashMap.put(fileDescriptor.f6687a.f(), fileDescriptor);
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < fileDescriptorProto.j(); i++) {
                int b = fileDescriptorProto.b(i);
                if (b < 0 || b >= fileDescriptorProto.i()) {
                    throw new DescriptorValidationException(this, "Invalid public dependency index.", (byte) (objArr2 == true ? 1 : 0));
                }
                String a2 = fileDescriptorProto.a(b);
                FileDescriptor fileDescriptor2 = (FileDescriptor) hashMap.get(a2);
                if (fileDescriptor2 != null) {
                    arrayList.add(fileDescriptor2);
                } else if (!z) {
                    throw new DescriptorValidationException(this, "Invalid public dependency: " + a2, (byte) (objArr3 == true ? 1 : 0));
                }
            }
            this.f = new FileDescriptor[arrayList.size()];
            arrayList.toArray(this.f);
            descriptorPool.a(this.f6687a.h(), this);
            this.b = new Descriptor[fileDescriptorProto.k()];
            for (int i2 = 0; i2 < fileDescriptorProto.k(); i2++) {
                this.b[i2] = new Descriptor(fileDescriptorProto.c(i2), this, null, i2, (byte) 0);
            }
            this.c = new EnumDescriptor[fileDescriptorProto.l()];
            for (int i3 = 0; i3 < fileDescriptorProto.l(); i3++) {
                this.c[i3] = new EnumDescriptor(fileDescriptorProto.d(i3), this, null, i3, (byte) 0);
            }
            this.d = new ServiceDescriptor[fileDescriptorProto.m()];
            for (int i4 = 0; i4 < fileDescriptorProto.m(); i4++) {
                this.d[i4] = new ServiceDescriptor(fileDescriptorProto.e(i4), this, i4, objArr == true ? 1 : 0);
            }
            this.e = new FieldDescriptor[fileDescriptorProto.n()];
            for (int i5 = 0; i5 < fileDescriptorProto.n(); i5++) {
                this.e[i5] = new FieldDescriptor(fileDescriptorProto.f(i5), this, null, i5, true, (byte) 0);
            }
        }

        FileDescriptor(String str, Descriptor descriptor) throws DescriptorValidationException {
            super((byte) 0);
            this.g = new DescriptorPool(new FileDescriptor[0], true);
            this.f6687a = DescriptorProtos.FileDescriptorProto.x().a(descriptor.c() + ".placeholder.proto").b(str).a(descriptor.a()).e();
            this.f = new FileDescriptor[0];
            this.b = new Descriptor[]{descriptor};
            this.c = new EnumDescriptor[0];
            this.d = new ServiceDescriptor[0];
            this.e = new FieldDescriptor[0];
            this.g.a(str, this);
            this.g.a(descriptor);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final boolean k() {
            return (Syntax.PROTO3.d.equals(this.f6687a.w()) ? Syntax.PROTO3 : Syntax.PROTO2) == Syntax.PROTO3;
        }
    }

    /* loaded from: classes3.dex */
    public static final class Descriptor extends GenericDescriptor {

        /* renamed from: a, reason: collision with root package name */
        private DescriptorProtos.DescriptorProto f6677a;
        private final String b;
        private final FileDescriptor c;
        private final Descriptor[] d;
        private final EnumDescriptor[] e;
        private final FieldDescriptor[] f;
        private final FieldDescriptor[] g;
        private final OneofDescriptor[] h;

        /* synthetic */ Descriptor(DescriptorProtos.DescriptorProto descriptorProto, FileDescriptor fileDescriptor, Descriptor descriptor, int i, byte b) throws DescriptorValidationException {
            this(descriptorProto, fileDescriptor, null, i);
        }

        @Override // com.uqm.crashsight.protobuf.Descriptors.GenericDescriptor
        public final /* bridge */ /* synthetic */ Message j() {
            return this.f6677a;
        }

        public final DescriptorProtos.DescriptorProto a() {
            return this.f6677a;
        }

        @Override // com.uqm.crashsight.protobuf.Descriptors.GenericDescriptor
        public final String b() {
            return this.f6677a.e();
        }

        @Override // com.uqm.crashsight.protobuf.Descriptors.GenericDescriptor
        public final String c() {
            return this.b;
        }

        @Override // com.uqm.crashsight.protobuf.Descriptors.GenericDescriptor
        public final FileDescriptor d() {
            return this.c;
        }

        public final DescriptorProtos.MessageOptions e() {
            return this.f6677a.m();
        }

        public final List<FieldDescriptor> f() {
            return Collections.unmodifiableList(Arrays.asList(this.f));
        }

        public final List<OneofDescriptor> g() {
            return Collections.unmodifiableList(Arrays.asList(this.h));
        }

        public final List<Descriptor> h() {
            return Collections.unmodifiableList(Arrays.asList(this.d));
        }

        public final boolean a(int i) {
            for (DescriptorProtos.DescriptorProto.ExtensionRange extensionRange : this.f6677a.j()) {
                if (extensionRange.f() <= i && i < extensionRange.h()) {
                    return true;
                }
            }
            return false;
        }

        public final boolean i() {
            return this.f6677a.j().size() != 0;
        }

        public final FieldDescriptor a(String str) {
            GenericDescriptor a2 = this.c.g.a(this.b + '.' + str);
            if (a2 == null || !(a2 instanceof FieldDescriptor)) {
                return null;
            }
            return (FieldDescriptor) a2;
        }

        public final FieldDescriptor b(int i) {
            return (FieldDescriptor) this.c.g.d.get(new DescriptorPool.a(this, i));
        }

        Descriptor(String str) throws DescriptorValidationException {
            super((byte) 0);
            String str2;
            String str3;
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf != -1) {
                str3 = str.substring(lastIndexOf + 1);
                str2 = str.substring(0, lastIndexOf);
            } else {
                str2 = "";
                str3 = str;
            }
            this.f6677a = DescriptorProtos.DescriptorProto.n().a(str3).a(DescriptorProtos.DescriptorProto.ExtensionRange.k().a(1).b(DriveFile.MODE_WRITE_ONLY).e()).e();
            this.b = str;
            this.d = new Descriptor[0];
            this.e = new EnumDescriptor[0];
            this.f = new FieldDescriptor[0];
            this.g = new FieldDescriptor[0];
            this.h = new OneofDescriptor[0];
            this.c = new FileDescriptor(str2, this);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        private Descriptor(DescriptorProtos.DescriptorProto descriptorProto, FileDescriptor fileDescriptor, Descriptor descriptor, int i) throws DescriptorValidationException {
            super(0 == true ? 1 : 0);
            this.f6677a = descriptorProto;
            this.b = Descriptors.a(fileDescriptor, descriptor, descriptorProto.e());
            this.c = fileDescriptor;
            this.h = new OneofDescriptor[descriptorProto.k()];
            for (int i2 = 0; i2 < descriptorProto.k(); i2++) {
                this.h[i2] = new OneofDescriptor(descriptorProto.e(i2), fileDescriptor, this, i2, (byte) 0);
            }
            this.d = new Descriptor[descriptorProto.h()];
            for (int i3 = 0; i3 < descriptorProto.h(); i3++) {
                this.d[i3] = new Descriptor(descriptorProto.c(i3), fileDescriptor, this, i3);
            }
            this.e = new EnumDescriptor[descriptorProto.i()];
            for (int i4 = 0; i4 < descriptorProto.i(); i4++) {
                this.e[i4] = new EnumDescriptor(descriptorProto.d(i4), fileDescriptor, this, i4, (byte) 0);
            }
            this.f = new FieldDescriptor[descriptorProto.f()];
            for (int i5 = 0; i5 < descriptorProto.f(); i5++) {
                this.f[i5] = new FieldDescriptor(descriptorProto.a(i5), fileDescriptor, this, i5, false, (byte) 0);
            }
            this.g = new FieldDescriptor[descriptorProto.g()];
            for (int i6 = 0; i6 < descriptorProto.g(); i6++) {
                this.g[i6] = new FieldDescriptor(descriptorProto.b(i6), fileDescriptor, this, i6, true, (byte) 0);
            }
            for (int i7 = 0; i7 < descriptorProto.k(); i7++) {
                OneofDescriptor[] oneofDescriptorArr = this.h;
                oneofDescriptorArr[i7].g = new FieldDescriptor[oneofDescriptorArr[i7].f()];
                OneofDescriptor.a(this.h[i7], 0);
            }
            for (int i8 = 0; i8 < descriptorProto.f(); i8++) {
                OneofDescriptor u = this.f[i8].u();
                if (u != null) {
                    u.g[OneofDescriptor.b(u)] = this.f[i8];
                }
            }
            fileDescriptor.g.a(this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k() throws DescriptorValidationException {
            for (Descriptor descriptor : this.d) {
                descriptor.k();
            }
            for (FieldDescriptor fieldDescriptor : this.f) {
                FieldDescriptor.a(fieldDescriptor);
            }
            for (FieldDescriptor fieldDescriptor2 : this.g) {
                FieldDescriptor.a(fieldDescriptor2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class FieldDescriptor extends GenericDescriptor implements FieldSet.FieldDescriptorLite<FieldDescriptor>, Comparable<FieldDescriptor> {

        /* renamed from: a, reason: collision with root package name */
        private static final WireFormat.FieldType[] f6684a = WireFormat.FieldType.values();
        private final int b;
        private DescriptorProtos.FieldDescriptorProto c;
        private final String d;
        private final FileDescriptor e;
        private final Descriptor f;
        private Type g;
        private Descriptor h;
        private Descriptor i;
        private OneofDescriptor j;
        private EnumDescriptor k;
        private Object l;

        /* synthetic */ FieldDescriptor(DescriptorProtos.FieldDescriptorProto fieldDescriptorProto, FileDescriptor fileDescriptor, Descriptor descriptor, int i, boolean z, byte b) throws DescriptorValidationException {
            this(fieldDescriptorProto, fileDescriptor, descriptor, i, z);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:48:0x019e. Please report as an issue. */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static /* synthetic */ void a(FieldDescriptor fieldDescriptor) throws DescriptorValidationException {
            Object obj;
            Object valueOf;
            Type type;
            byte b = 0;
            if (fieldDescriptor.c.o()) {
                GenericDescriptor a2 = fieldDescriptor.e.g.a(fieldDescriptor.c.s(), fieldDescriptor, DescriptorPool.SearchFilter.TYPES_ONLY);
                if (!(a2 instanceof Descriptor)) {
                    throw new DescriptorValidationException(fieldDescriptor, "\"" + fieldDescriptor.c.s() + "\" is not a message type.", b);
                }
                fieldDescriptor.h = (Descriptor) a2;
                if (!fieldDescriptor.h.a(fieldDescriptor.c.h())) {
                    throw new DescriptorValidationException(fieldDescriptor, "\"" + fieldDescriptor.h.c() + "\" does not declare " + fieldDescriptor.c.h() + " as an extension number.", b);
                }
            }
            if (fieldDescriptor.c.m()) {
                GenericDescriptor a3 = fieldDescriptor.e.g.a(fieldDescriptor.c.n(), fieldDescriptor, DescriptorPool.SearchFilter.TYPES_ONLY);
                if (!fieldDescriptor.c.k()) {
                    if (a3 instanceof Descriptor) {
                        type = Type.MESSAGE;
                    } else {
                        if (!(a3 instanceof EnumDescriptor)) {
                            throw new DescriptorValidationException(fieldDescriptor, "\"" + fieldDescriptor.c.n() + "\" is not a type.", b);
                        }
                        type = Type.ENUM;
                    }
                    fieldDescriptor.g = type;
                }
                if (fieldDescriptor.g.a() == JavaType.MESSAGE) {
                    if (!(a3 instanceof Descriptor)) {
                        throw new DescriptorValidationException(fieldDescriptor, "\"" + fieldDescriptor.c.n() + "\" is not a message type.", b);
                    }
                    fieldDescriptor.i = (Descriptor) a3;
                    if (fieldDescriptor.c.t()) {
                        throw new DescriptorValidationException(fieldDescriptor, "Messages can't have default values.", b);
                    }
                } else {
                    if (fieldDescriptor.g.a() != JavaType.ENUM) {
                        throw new DescriptorValidationException(fieldDescriptor, "Field with primitive type has type_name.", b);
                    }
                    if (!(a3 instanceof EnumDescriptor)) {
                        throw new DescriptorValidationException(fieldDescriptor, "\"" + fieldDescriptor.c.n() + "\" is not an enum type.", b);
                    }
                    fieldDescriptor.k = (EnumDescriptor) a3;
                }
            } else if (fieldDescriptor.g.a() == JavaType.MESSAGE || fieldDescriptor.g.a() == JavaType.ENUM) {
                throw new DescriptorValidationException(fieldDescriptor, "Field with message or enum type missing type_name.", b);
            }
            if (fieldDescriptor.c.A().h() && !fieldDescriptor.q()) {
                throw new DescriptorValidationException(fieldDescriptor, "[packed = true] can only be specified for repeated primitive fields.", b);
            }
            if (fieldDescriptor.c.t()) {
                if (fieldDescriptor.c.j() == DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED) {
                    throw new DescriptorValidationException(fieldDescriptor, "Repeated fields cannot have default values.", b);
                }
                try {
                    switch (fieldDescriptor.g) {
                        case INT32:
                        case SINT32:
                        case SFIXED32:
                            valueOf = Integer.valueOf(TextFormat.b(fieldDescriptor.c.u()));
                            fieldDescriptor.l = valueOf;
                            break;
                        case UINT32:
                        case FIXED32:
                            valueOf = Integer.valueOf(TextFormat.c(fieldDescriptor.c.u()));
                            fieldDescriptor.l = valueOf;
                            break;
                        case INT64:
                        case SINT64:
                        case SFIXED64:
                            valueOf = Long.valueOf(TextFormat.d(fieldDescriptor.c.u()));
                            fieldDescriptor.l = valueOf;
                            break;
                        case UINT64:
                        case FIXED64:
                            valueOf = Long.valueOf(TextFormat.e(fieldDescriptor.c.u()));
                            fieldDescriptor.l = valueOf;
                            break;
                        case FLOAT:
                            valueOf = fieldDescriptor.c.u().equals("inf") ? Float.valueOf(Float.POSITIVE_INFINITY) : fieldDescriptor.c.u().equals("-inf") ? Float.valueOf(Float.NEGATIVE_INFINITY) : fieldDescriptor.c.u().equals("nan") ? Float.valueOf(Float.NaN) : Float.valueOf(fieldDescriptor.c.u());
                            fieldDescriptor.l = valueOf;
                            break;
                        case DOUBLE:
                            valueOf = fieldDescriptor.c.u().equals("inf") ? Double.valueOf(Double.POSITIVE_INFINITY) : fieldDescriptor.c.u().equals("-inf") ? Double.valueOf(Double.NEGATIVE_INFINITY) : fieldDescriptor.c.u().equals("nan") ? Double.valueOf(Double.NaN) : Double.valueOf(fieldDescriptor.c.u());
                            fieldDescriptor.l = valueOf;
                            break;
                        case BOOL:
                            valueOf = Boolean.valueOf(fieldDescriptor.c.u());
                            fieldDescriptor.l = valueOf;
                            break;
                        case STRING:
                            valueOf = fieldDescriptor.c.u();
                            fieldDescriptor.l = valueOf;
                            break;
                        case BYTES:
                            try {
                                fieldDescriptor.l = TextFormat.a((CharSequence) fieldDescriptor.c.u());
                                break;
                            } catch (TextFormat.InvalidEscapeSequenceException e) {
                                throw new DescriptorValidationException(fieldDescriptor, "Couldn't parse default value: " + e.getMessage(), e, b);
                            }
                        case ENUM:
                            fieldDescriptor.l = fieldDescriptor.k.a(fieldDescriptor.c.u());
                            if (fieldDescriptor.l == null) {
                                throw new DescriptorValidationException(fieldDescriptor, "Unknown enum default value: \"" + fieldDescriptor.c.u() + '\"', b);
                            }
                            break;
                        case MESSAGE:
                        case GROUP:
                            throw new DescriptorValidationException(fieldDescriptor, "Message type had default value.", b);
                    }
                } catch (NumberFormatException e2) {
                    throw new DescriptorValidationException(fieldDescriptor, "Could not parse default value: \"" + fieldDescriptor.c.u() + '\"', e2, b);
                }
            } else {
                if (!(fieldDescriptor.c.j() == DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED)) {
                    switch (fieldDescriptor.g.a()) {
                        case ENUM:
                            obj = fieldDescriptor.k.a().get(0);
                            break;
                        case MESSAGE:
                            obj = null;
                            break;
                        default:
                            obj = fieldDescriptor.g.a().j;
                            break;
                    }
                } else {
                    obj = Collections.emptyList();
                }
                fieldDescriptor.l = obj;
            }
            if (!fieldDescriptor.c.o()) {
                fieldDescriptor.e.g.a(fieldDescriptor);
            }
            Descriptor descriptor = fieldDescriptor.h;
            if (descriptor == null || !descriptor.e().f()) {
                return;
            }
            if (!fieldDescriptor.c.o()) {
                throw new DescriptorValidationException(fieldDescriptor, "MessageSets cannot have fields, only extensions.", b);
            }
            if (!(fieldDescriptor.c.j() == DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL) || fieldDescriptor.g != Type.MESSAGE) {
                throw new DescriptorValidationException(fieldDescriptor, "Extensions of MessageSets must be optional messages.", b);
            }
        }

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(FieldDescriptor fieldDescriptor) {
            FieldDescriptor fieldDescriptor2 = fieldDescriptor;
            if (fieldDescriptor2.h == this.h) {
                return this.c.h() - fieldDescriptor2.c.h();
            }
            throw new IllegalArgumentException("FieldDescriptors can only be compared to other FieldDescriptors for fields of the same message type.");
        }

        @Override // com.uqm.crashsight.protobuf.Descriptors.GenericDescriptor
        public final /* bridge */ /* synthetic */ Message j() {
            return this.c;
        }

        public final int a() {
            return this.b;
        }

        @Override // com.uqm.crashsight.protobuf.Descriptors.GenericDescriptor
        public final String b() {
            return this.c.f();
        }

        @Override // com.uqm.crashsight.protobuf.FieldSet.FieldDescriptorLite
        public final int e() {
            return this.c.h();
        }

        @Override // com.uqm.crashsight.protobuf.Descriptors.GenericDescriptor
        public final String c() {
            return this.d;
        }

        public final JavaType f() {
            return this.g.a();
        }

        @Override // com.uqm.crashsight.protobuf.FieldSet.FieldDescriptorLite
        public final WireFormat.JavaType g() {
            return f6684a[this.g.ordinal()].a();
        }

        @Override // com.uqm.crashsight.protobuf.Descriptors.GenericDescriptor
        public final FileDescriptor d() {
            return this.e;
        }

        public final Type h() {
            return this.g;
        }

        @Override // com.uqm.crashsight.protobuf.FieldSet.FieldDescriptorLite
        public final WireFormat.FieldType i() {
            return f6684a[this.g.ordinal()];
        }

        public final boolean k() {
            if (this.g != Type.STRING) {
                return false;
            }
            if (this.h.e().l() || this.e.i() == FileDescriptor.Syntax.PROTO3) {
                return true;
            }
            return this.e.f().l();
        }

        public final boolean l() {
            if (this.g == Type.MESSAGE) {
                if ((this.c.j() == DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED) && w().e().l()) {
                    return true;
                }
            }
            return false;
        }

        static {
            if (Type.values().length != DescriptorProtos.FieldDescriptorProto.Type.values().length) {
                throw new RuntimeException("descriptor.proto has a new declared type but Descriptors.java wasn't updated.");
            }
        }

        public final boolean m() {
            return this.c.j() == DescriptorProtos.FieldDescriptorProto.Label.LABEL_REQUIRED;
        }

        public final boolean n() {
            return this.c.j() == DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL;
        }

        @Override // com.uqm.crashsight.protobuf.FieldSet.FieldDescriptorLite
        public final boolean o() {
            return this.c.j() == DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED;
        }

        @Override // com.uqm.crashsight.protobuf.FieldSet.FieldDescriptorLite
        public final boolean p() {
            if (!((this.c.j() == DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED) && f6684a[this.g.ordinal()].c())) {
                return false;
            }
            if (this.e.i() == FileDescriptor.Syntax.PROTO2) {
                return this.c.A().h();
            }
            return !this.c.A().g() || this.c.A().h();
        }

        public final boolean q() {
            return (this.c.j() == DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED) && f6684a[this.g.ordinal()].c();
        }

        public final Object r() {
            if (this.g.a() == JavaType.MESSAGE) {
                throw new UnsupportedOperationException("FieldDescriptor.getDefaultValue() called on an embedded message field.");
            }
            return this.l;
        }

        public final boolean s() {
            return this.c.o();
        }

        public final Descriptor t() {
            return this.h;
        }

        public final OneofDescriptor u() {
            return this.j;
        }

        public final Descriptor v() {
            if (!this.c.o()) {
                throw new UnsupportedOperationException(String.format("This field is not an extension. (%s)", this.d));
            }
            return this.f;
        }

        public final Descriptor w() {
            if (this.g.a() != JavaType.MESSAGE) {
                throw new UnsupportedOperationException(String.format("This field is not of message type. (%s)", this.d));
            }
            return this.i;
        }

        public final EnumDescriptor x() {
            if (this.g.a() != JavaType.ENUM) {
                throw new UnsupportedOperationException(String.format("This field is not of enum type. (%s)", this.d));
            }
            return this.k;
        }

        public final String toString() {
            return this.d;
        }

        /* loaded from: classes3.dex */
        public enum Type {
            DOUBLE(JavaType.DOUBLE),
            FLOAT(JavaType.FLOAT),
            INT64(JavaType.LONG),
            UINT64(JavaType.LONG),
            INT32(JavaType.INT),
            FIXED64(JavaType.LONG),
            FIXED32(JavaType.INT),
            BOOL(JavaType.BOOLEAN),
            STRING(JavaType.STRING),
            GROUP(JavaType.MESSAGE),
            MESSAGE(JavaType.MESSAGE),
            BYTES(JavaType.BYTE_STRING),
            UINT32(JavaType.INT),
            ENUM(JavaType.ENUM),
            SFIXED32(JavaType.INT),
            SFIXED64(JavaType.LONG),
            SINT32(JavaType.INT),
            SINT64(JavaType.LONG);

            private JavaType s;

            Type(JavaType javaType) {
                this.s = javaType;
            }

            public final JavaType a() {
                return this.s;
            }

            public static Type a(DescriptorProtos.FieldDescriptorProto.Type type) {
                return values()[type.a() - 1];
            }
        }

        /* loaded from: classes3.dex */
        public enum JavaType {
            INT(0),
            LONG(0L),
            FLOAT(Float.valueOf(0.0f)),
            DOUBLE(Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)),
            BOOLEAN(false),
            STRING(""),
            BYTE_STRING(ByteString.f6635a),
            ENUM(null),
            MESSAGE(null);

            private final Object j;

            JavaType(Object obj) {
                this.j = obj;
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private FieldDescriptor(com.uqm.crashsight.protobuf.DescriptorProtos.FieldDescriptorProto r8, com.uqm.crashsight.protobuf.Descriptors.FileDescriptor r9, com.uqm.crashsight.protobuf.Descriptors.Descriptor r10, int r11, boolean r12) throws com.uqm.crashsight.protobuf.Descriptors.DescriptorValidationException {
            /*
                Method dump skipped, instructions count: 262
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.Descriptors.FieldDescriptor.<init>(com.uqm.crashsight.protobuf.DescriptorProtos$FieldDescriptorProto, com.uqm.crashsight.protobuf.Descriptors$FileDescriptor, com.uqm.crashsight.protobuf.Descriptors$Descriptor, int, boolean):void");
        }

        @Override // com.uqm.crashsight.protobuf.FieldSet.FieldDescriptorLite
        public final MessageLite.Builder a(MessageLite.Builder builder, MessageLite messageLite) {
            return ((Message.Builder) builder).c((Message) messageLite);
        }
    }

    /* loaded from: classes3.dex */
    public static final class EnumDescriptor extends GenericDescriptor implements Internal.EnumLiteMap<EnumValueDescriptor> {

        /* renamed from: a, reason: collision with root package name */
        private DescriptorProtos.EnumDescriptorProto f6682a;
        private final String b;
        private final FileDescriptor c;
        private EnumValueDescriptor[] d;
        private final WeakHashMap<Integer, WeakReference<EnumValueDescriptor>> e;

        /* synthetic */ EnumDescriptor(DescriptorProtos.EnumDescriptorProto enumDescriptorProto, FileDescriptor fileDescriptor, Descriptor descriptor, int i, byte b) throws DescriptorValidationException {
            this(enumDescriptorProto, fileDescriptor, descriptor, i);
        }

        @Override // com.uqm.crashsight.protobuf.Internal.EnumLiteMap
        public final /* synthetic */ EnumValueDescriptor a(int i) {
            return (EnumValueDescriptor) this.c.g.e.get(new DescriptorPool.a(this, i));
        }

        @Override // com.uqm.crashsight.protobuf.Descriptors.GenericDescriptor
        public final /* bridge */ /* synthetic */ Message j() {
            return this.f6682a;
        }

        @Override // com.uqm.crashsight.protobuf.Descriptors.GenericDescriptor
        public final String b() {
            return this.f6682a.f();
        }

        @Override // com.uqm.crashsight.protobuf.Descriptors.GenericDescriptor
        public final String c() {
            return this.b;
        }

        @Override // com.uqm.crashsight.protobuf.Descriptors.GenericDescriptor
        public final FileDescriptor d() {
            return this.c;
        }

        public final List<EnumValueDescriptor> a() {
            return Collections.unmodifiableList(Arrays.asList(this.d));
        }

        public final EnumValueDescriptor a(String str) {
            GenericDescriptor a2 = this.c.g.a(this.b + '.' + str);
            if (a2 == null || !(a2 instanceof EnumValueDescriptor)) {
                return null;
            }
            return (EnumValueDescriptor) a2;
        }

        public final EnumValueDescriptor b(int i) {
            return (EnumValueDescriptor) this.c.g.e.get(new DescriptorPool.a(this, i));
        }

        public final EnumValueDescriptor c(int i) {
            EnumValueDescriptor enumValueDescriptor = (EnumValueDescriptor) this.c.g.e.get(new DescriptorPool.a(this, i));
            if (enumValueDescriptor != null) {
                return enumValueDescriptor;
            }
            synchronized (this) {
                Integer num = new Integer(i);
                WeakReference<EnumValueDescriptor> weakReference = this.e.get(num);
                if (weakReference != null) {
                    enumValueDescriptor = weakReference.get();
                }
                if (enumValueDescriptor == null) {
                    enumValueDescriptor = new EnumValueDescriptor(this.c, this, num, (byte) 0);
                    this.e.put(num, new WeakReference<>(enumValueDescriptor));
                }
            }
            return enumValueDescriptor;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private EnumDescriptor(DescriptorProtos.EnumDescriptorProto enumDescriptorProto, FileDescriptor fileDescriptor, Descriptor descriptor, int i) throws DescriptorValidationException {
            super(0 == true ? 1 : 0);
            Object[] objArr = 0;
            this.e = new WeakHashMap<>();
            this.f6682a = enumDescriptorProto;
            this.b = Descriptors.a(fileDescriptor, descriptor, enumDescriptorProto.f());
            this.c = fileDescriptor;
            if (enumDescriptorProto.g() == 0) {
                throw new DescriptorValidationException((GenericDescriptor) this, "Enums must contain at least one value.", (byte) (objArr == true ? 1 : 0));
            }
            this.d = new EnumValueDescriptor[enumDescriptorProto.g()];
            for (int i2 = 0; i2 < enumDescriptorProto.g(); i2++) {
                this.d[i2] = new EnumValueDescriptor(enumDescriptorProto.a(i2), fileDescriptor, this, i2, (byte) 0);
            }
            fileDescriptor.g.a(this);
        }
    }

    /* loaded from: classes3.dex */
    public static final class EnumValueDescriptor extends GenericDescriptor implements Internal.EnumLite {

        /* renamed from: a, reason: collision with root package name */
        private DescriptorProtos.EnumValueDescriptorProto f6683a;
        private final String b;
        private final FileDescriptor c;
        private final EnumDescriptor d;

        /* synthetic */ EnumValueDescriptor(DescriptorProtos.EnumValueDescriptorProto enumValueDescriptorProto, FileDescriptor fileDescriptor, EnumDescriptor enumDescriptor, int i, byte b) throws DescriptorValidationException {
            this(enumValueDescriptorProto, fileDescriptor, enumDescriptor, i);
        }

        /* synthetic */ EnumValueDescriptor(FileDescriptor fileDescriptor, EnumDescriptor enumDescriptor, Integer num, byte b) {
            this(fileDescriptor, enumDescriptor, num);
        }

        @Override // com.uqm.crashsight.protobuf.Descriptors.GenericDescriptor
        public final /* bridge */ /* synthetic */ Message j() {
            return this.f6683a;
        }

        @Override // com.uqm.crashsight.protobuf.Descriptors.GenericDescriptor
        public final String b() {
            return this.f6683a.f();
        }

        @Override // com.uqm.crashsight.protobuf.Internal.EnumLite
        public final int a() {
            return this.f6683a.h();
        }

        public final String toString() {
            return this.f6683a.f();
        }

        @Override // com.uqm.crashsight.protobuf.Descriptors.GenericDescriptor
        public final String c() {
            return this.b;
        }

        @Override // com.uqm.crashsight.protobuf.Descriptors.GenericDescriptor
        public final FileDescriptor d() {
            return this.c;
        }

        public final EnumDescriptor e() {
            return this.d;
        }

        private EnumValueDescriptor(DescriptorProtos.EnumValueDescriptorProto enumValueDescriptorProto, FileDescriptor fileDescriptor, EnumDescriptor enumDescriptor, int i) throws DescriptorValidationException {
            super((byte) 0);
            this.f6683a = enumValueDescriptorProto;
            this.c = fileDescriptor;
            this.d = enumDescriptor;
            this.b = enumDescriptor.c() + '.' + enumValueDescriptorProto.f();
            fileDescriptor.g.a((GenericDescriptor) this);
            fileDescriptor.g.a(this);
        }

        private EnumValueDescriptor(FileDescriptor fileDescriptor, EnumDescriptor enumDescriptor, Integer num) {
            super((byte) 0);
            DescriptorProtos.EnumValueDescriptorProto e = DescriptorProtos.EnumValueDescriptorProto.k().a("UNKNOWN_ENUM_VALUE_" + enumDescriptor.b() + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + num).a(num.intValue()).e();
            this.f6683a = e;
            this.c = fileDescriptor;
            this.d = enumDescriptor;
            this.b = enumDescriptor.c() + '.' + e.f();
        }
    }

    /* loaded from: classes3.dex */
    public static final class ServiceDescriptor extends GenericDescriptor {

        /* renamed from: a, reason: collision with root package name */
        private DescriptorProtos.ServiceDescriptorProto f6691a;
        private final String b;
        private final FileDescriptor c;
        private MethodDescriptor[] d;

        /* synthetic */ ServiceDescriptor(DescriptorProtos.ServiceDescriptorProto serviceDescriptorProto, FileDescriptor fileDescriptor, int i, byte b) throws DescriptorValidationException {
            this(serviceDescriptorProto, fileDescriptor, i);
        }

        static /* synthetic */ void a(ServiceDescriptor serviceDescriptor) throws DescriptorValidationException {
            for (MethodDescriptor methodDescriptor : serviceDescriptor.d) {
                MethodDescriptor.a(methodDescriptor);
            }
        }

        @Override // com.uqm.crashsight.protobuf.Descriptors.GenericDescriptor
        public final /* bridge */ /* synthetic */ Message j() {
            return this.f6691a;
        }

        @Override // com.uqm.crashsight.protobuf.Descriptors.GenericDescriptor
        public final String b() {
            return this.f6691a.f();
        }

        @Override // com.uqm.crashsight.protobuf.Descriptors.GenericDescriptor
        public final String c() {
            return this.b;
        }

        @Override // com.uqm.crashsight.protobuf.Descriptors.GenericDescriptor
        public final FileDescriptor d() {
            return this.c;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        private ServiceDescriptor(DescriptorProtos.ServiceDescriptorProto serviceDescriptorProto, FileDescriptor fileDescriptor, int i) throws DescriptorValidationException {
            super(0 == true ? 1 : 0);
            this.f6691a = serviceDescriptorProto;
            this.b = Descriptors.a(fileDescriptor, null, serviceDescriptorProto.f());
            this.c = fileDescriptor;
            this.d = new MethodDescriptor[serviceDescriptorProto.g()];
            for (int i2 = 0; i2 < serviceDescriptorProto.g(); i2++) {
                this.d[i2] = new MethodDescriptor(serviceDescriptorProto.a(i2), fileDescriptor, this, i2, (byte) 0);
            }
            fileDescriptor.g.a(this);
        }
    }

    /* loaded from: classes3.dex */
    public static final class MethodDescriptor extends GenericDescriptor {

        /* renamed from: a, reason: collision with root package name */
        private DescriptorProtos.MethodDescriptorProto f6689a;
        private final String b;
        private final FileDescriptor c;

        /* synthetic */ MethodDescriptor(DescriptorProtos.MethodDescriptorProto methodDescriptorProto, FileDescriptor fileDescriptor, ServiceDescriptor serviceDescriptor, int i, byte b) throws DescriptorValidationException {
            this(methodDescriptorProto, fileDescriptor, serviceDescriptor, i);
        }

        static /* synthetic */ void a(MethodDescriptor methodDescriptor) throws DescriptorValidationException {
            byte b = 0;
            if (!(methodDescriptor.c.g.a(methodDescriptor.f6689a.h(), methodDescriptor, DescriptorPool.SearchFilter.TYPES_ONLY) instanceof Descriptor)) {
                throw new DescriptorValidationException(methodDescriptor, "\"" + methodDescriptor.f6689a.h() + "\" is not a message type.", b);
            }
            if (methodDescriptor.c.g.a(methodDescriptor.f6689a.j(), methodDescriptor, DescriptorPool.SearchFilter.TYPES_ONLY) instanceof Descriptor) {
                return;
            }
            throw new DescriptorValidationException(methodDescriptor, "\"" + methodDescriptor.f6689a.j() + "\" is not a message type.", b);
        }

        @Override // com.uqm.crashsight.protobuf.Descriptors.GenericDescriptor
        public final /* bridge */ /* synthetic */ Message j() {
            return this.f6689a;
        }

        @Override // com.uqm.crashsight.protobuf.Descriptors.GenericDescriptor
        public final String b() {
            return this.f6689a.f();
        }

        @Override // com.uqm.crashsight.protobuf.Descriptors.GenericDescriptor
        public final String c() {
            return this.b;
        }

        @Override // com.uqm.crashsight.protobuf.Descriptors.GenericDescriptor
        public final FileDescriptor d() {
            return this.c;
        }

        private MethodDescriptor(DescriptorProtos.MethodDescriptorProto methodDescriptorProto, FileDescriptor fileDescriptor, ServiceDescriptor serviceDescriptor, int i) throws DescriptorValidationException {
            super((byte) 0);
            this.f6689a = methodDescriptorProto;
            this.c = fileDescriptor;
            this.b = serviceDescriptor.c() + '.' + methodDescriptorProto.f();
            fileDescriptor.g.a(this);
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class GenericDescriptor {
        public abstract String b();

        public abstract String c();

        public abstract FileDescriptor d();

        public abstract Message j();

        /* synthetic */ GenericDescriptor(byte b) {
            this();
        }

        private GenericDescriptor() {
        }
    }

    /* loaded from: classes3.dex */
    public static class DescriptorValidationException extends Exception {
        /* synthetic */ DescriptorValidationException(FileDescriptor fileDescriptor, String str, byte b) {
            this(fileDescriptor, str);
        }

        /* synthetic */ DescriptorValidationException(GenericDescriptor genericDescriptor, String str, byte b) {
            this(genericDescriptor, str);
        }

        /* synthetic */ DescriptorValidationException(GenericDescriptor genericDescriptor, String str, Throwable th, byte b) {
            this(genericDescriptor, str, th);
        }

        private DescriptorValidationException(GenericDescriptor genericDescriptor, String str) {
            super(genericDescriptor.c() + ": " + str);
            genericDescriptor.c();
            genericDescriptor.j();
        }

        private DescriptorValidationException(GenericDescriptor genericDescriptor, String str, Throwable th) {
            this(genericDescriptor, str);
            initCause(th);
        }

        private DescriptorValidationException(FileDescriptor fileDescriptor, String str) {
            super(fileDescriptor.b() + ": " + str);
            fileDescriptor.b();
            fileDescriptor.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class DescriptorPool {
        private boolean b;
        private final Map<String, GenericDescriptor> c = new HashMap();
        private final Map<a, FieldDescriptor> d = new HashMap();
        private final Map<a, EnumValueDescriptor> e = new HashMap();

        /* renamed from: a, reason: collision with root package name */
        private final Set<FileDescriptor> f6678a = new HashSet();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public enum SearchFilter {
            TYPES_ONLY,
            AGGREGATES_ONLY,
            ALL_SYMBOLS
        }

        DescriptorPool(FileDescriptor[] fileDescriptorArr, boolean z) {
            this.b = z;
            for (int i = 0; i < fileDescriptorArr.length; i++) {
                this.f6678a.add(fileDescriptorArr[i]);
                a(fileDescriptorArr[i]);
            }
            for (FileDescriptor fileDescriptor : this.f6678a) {
                try {
                    a(fileDescriptor.e(), fileDescriptor);
                } catch (DescriptorValidationException e) {
                    throw new AssertionError(e);
                }
            }
        }

        private void a(FileDescriptor fileDescriptor) {
            for (FileDescriptor fileDescriptor2 : fileDescriptor.h()) {
                if (this.f6678a.add(fileDescriptor2)) {
                    a(fileDescriptor2);
                }
            }
        }

        final GenericDescriptor a(String str) {
            return a(str, SearchFilter.ALL_SYMBOLS);
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
        
            if (((r0 instanceof com.uqm.crashsight.protobuf.Descriptors.Descriptor) || (r0 instanceof com.uqm.crashsight.protobuf.Descriptors.EnumDescriptor)) == false) goto L16;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x002a, code lost:
        
            if (b(r0) != false) goto L20;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private com.uqm.crashsight.protobuf.Descriptors.GenericDescriptor a(java.lang.String r6, com.uqm.crashsight.protobuf.Descriptors.DescriptorPool.SearchFilter r7) {
            /*
                r5 = this;
                java.util.Map<java.lang.String, com.uqm.crashsight.protobuf.Descriptors$GenericDescriptor> r0 = r5.c
                java.lang.Object r0 = r0.get(r6)
                com.uqm.crashsight.protobuf.Descriptors$GenericDescriptor r0 = (com.uqm.crashsight.protobuf.Descriptors.GenericDescriptor) r0
                r1 = 0
                r2 = 1
                if (r0 == 0) goto L2d
                com.uqm.crashsight.protobuf.Descriptors$DescriptorPool$SearchFilter r3 = com.uqm.crashsight.protobuf.Descriptors.DescriptorPool.SearchFilter.ALL_SYMBOLS
                if (r7 == r3) goto L2c
                com.uqm.crashsight.protobuf.Descriptors$DescriptorPool$SearchFilter r3 = com.uqm.crashsight.protobuf.Descriptors.DescriptorPool.SearchFilter.TYPES_ONLY
                if (r7 != r3) goto L22
                boolean r3 = r0 instanceof com.uqm.crashsight.protobuf.Descriptors.Descriptor
                if (r3 != 0) goto L1f
                boolean r3 = r0 instanceof com.uqm.crashsight.protobuf.Descriptors.EnumDescriptor
                if (r3 == 0) goto L1d
                goto L1f
            L1d:
                r3 = 0
                goto L20
            L1f:
                r3 = 1
            L20:
                if (r3 != 0) goto L2c
            L22:
                com.uqm.crashsight.protobuf.Descriptors$DescriptorPool$SearchFilter r3 = com.uqm.crashsight.protobuf.Descriptors.DescriptorPool.SearchFilter.AGGREGATES_ONLY
                if (r7 != r3) goto L2d
                boolean r3 = b(r0)
                if (r3 == 0) goto L2d
            L2c:
                return r0
            L2d:
                java.util.Set<com.uqm.crashsight.protobuf.Descriptors$FileDescriptor> r0 = r5.f6678a
                java.util.Iterator r0 = r0.iterator()
            L33:
                boolean r3 = r0.hasNext()
                if (r3 == 0) goto L6e
                java.lang.Object r3 = r0.next()
                com.uqm.crashsight.protobuf.Descriptors$FileDescriptor r3 = (com.uqm.crashsight.protobuf.Descriptors.FileDescriptor) r3
                com.uqm.crashsight.protobuf.Descriptors$DescriptorPool r3 = com.uqm.crashsight.protobuf.Descriptors.FileDescriptor.a(r3)
                java.util.Map<java.lang.String, com.uqm.crashsight.protobuf.Descriptors$GenericDescriptor> r3 = r3.c
                java.lang.Object r3 = r3.get(r6)
                com.uqm.crashsight.protobuf.Descriptors$GenericDescriptor r3 = (com.uqm.crashsight.protobuf.Descriptors.GenericDescriptor) r3
                if (r3 == 0) goto L33
                com.uqm.crashsight.protobuf.Descriptors$DescriptorPool$SearchFilter r4 = com.uqm.crashsight.protobuf.Descriptors.DescriptorPool.SearchFilter.ALL_SYMBOLS
                if (r7 == r4) goto L6d
                com.uqm.crashsight.protobuf.Descriptors$DescriptorPool$SearchFilter r4 = com.uqm.crashsight.protobuf.Descriptors.DescriptorPool.SearchFilter.TYPES_ONLY
                if (r7 != r4) goto L63
                boolean r4 = r3 instanceof com.uqm.crashsight.protobuf.Descriptors.Descriptor
                if (r4 != 0) goto L60
                boolean r4 = r3 instanceof com.uqm.crashsight.protobuf.Descriptors.EnumDescriptor
                if (r4 == 0) goto L5e
                goto L60
            L5e:
                r4 = 0
                goto L61
            L60:
                r4 = 1
            L61:
                if (r4 != 0) goto L6d
            L63:
                com.uqm.crashsight.protobuf.Descriptors$DescriptorPool$SearchFilter r4 = com.uqm.crashsight.protobuf.Descriptors.DescriptorPool.SearchFilter.AGGREGATES_ONLY
                if (r7 != r4) goto L33
                boolean r4 = b(r3)
                if (r4 == 0) goto L33
            L6d:
                return r3
            L6e:
                r6 = 0
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.Descriptors.DescriptorPool.a(java.lang.String, com.uqm.crashsight.protobuf.Descriptors$DescriptorPool$SearchFilter):com.uqm.crashsight.protobuf.Descriptors$GenericDescriptor");
        }

        private static boolean b(GenericDescriptor genericDescriptor) {
            return (genericDescriptor instanceof Descriptor) || (genericDescriptor instanceof EnumDescriptor) || (genericDescriptor instanceof b) || (genericDescriptor instanceof ServiceDescriptor);
        }

        final GenericDescriptor a(String str, GenericDescriptor genericDescriptor, SearchFilter searchFilter) throws DescriptorValidationException {
            GenericDescriptor a2;
            String str2;
            byte b2 = 0;
            if (str.startsWith(".")) {
                str2 = str.substring(1);
                a2 = a(str2, searchFilter);
            } else {
                int indexOf = str.indexOf(46);
                String substring = indexOf == -1 ? str : str.substring(0, indexOf);
                StringBuilder sb = new StringBuilder(genericDescriptor.c());
                while (true) {
                    int lastIndexOf = sb.lastIndexOf(".");
                    if (lastIndexOf == -1) {
                        a2 = a(str, searchFilter);
                        str2 = str;
                        break;
                    }
                    int i = lastIndexOf + 1;
                    sb.setLength(i);
                    sb.append(substring);
                    GenericDescriptor a3 = a(sb.toString(), SearchFilter.AGGREGATES_ONLY);
                    if (a3 != null) {
                        if (indexOf != -1) {
                            sb.setLength(i);
                            sb.append(str);
                            a2 = a(sb.toString(), searchFilter);
                        } else {
                            a2 = a3;
                        }
                        str2 = sb.toString();
                    } else {
                        sb.setLength(lastIndexOf);
                    }
                }
            }
            if (a2 != null) {
                return a2;
            }
            if (this.b && searchFilter == SearchFilter.TYPES_ONLY) {
                Descriptors.f6675a.warning("The descriptor for message type \"" + str + "\" can not be found and a placeholder is created for it");
                Descriptor descriptor = new Descriptor(str2);
                this.f6678a.add(descriptor.d());
                return descriptor;
            }
            throw new DescriptorValidationException(genericDescriptor, "\"" + str + "\" is not defined.", b2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        final void a(GenericDescriptor genericDescriptor) throws DescriptorValidationException {
            String b2 = genericDescriptor.b();
            byte b3 = 0;
            if (b2.length() == 0) {
                throw new DescriptorValidationException(genericDescriptor, "Missing name.", b3);
            }
            for (int i = 0; i < b2.length(); i++) {
                char charAt = b2.charAt(i);
                if (('a' > charAt || charAt > 'z') && (('A' > charAt || charAt > 'Z') && charAt != '_' && ('0' > charAt || charAt > '9' || i <= 0))) {
                    throw new DescriptorValidationException(genericDescriptor, "\"" + b2 + "\" is not a valid identifier.", b3);
                }
            }
            String c = genericDescriptor.c();
            GenericDescriptor put = this.c.put(c, genericDescriptor);
            if (put != null) {
                this.c.put(c, put);
                if (genericDescriptor.d() == put.d()) {
                    int lastIndexOf = c.lastIndexOf(46);
                    if (lastIndexOf == -1) {
                        throw new DescriptorValidationException(genericDescriptor, "\"" + c + "\" is already defined.", b3);
                    }
                    throw new DescriptorValidationException(genericDescriptor, "\"" + c.substring(lastIndexOf + 1) + "\" is already defined in \"" + c.substring(0, lastIndexOf) + "\".", b3);
                }
                throw new DescriptorValidationException(genericDescriptor, "\"" + c + "\" is already defined in file \"" + put.d().b() + "\".", b3);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public static final class b extends GenericDescriptor {

            /* renamed from: a, reason: collision with root package name */
            private final String f6681a;
            private final String b;
            private final FileDescriptor c;

            @Override // com.uqm.crashsight.protobuf.Descriptors.GenericDescriptor
            public final Message j() {
                return this.c.a();
            }

            @Override // com.uqm.crashsight.protobuf.Descriptors.GenericDescriptor
            public final String b() {
                return this.f6681a;
            }

            @Override // com.uqm.crashsight.protobuf.Descriptors.GenericDescriptor
            public final String c() {
                return this.b;
            }

            @Override // com.uqm.crashsight.protobuf.Descriptors.GenericDescriptor
            public final FileDescriptor d() {
                return this.c;
            }

            b(String str, String str2, FileDescriptor fileDescriptor) {
                super((byte) 0);
                this.c = fileDescriptor;
                this.b = str2;
                this.f6681a = str;
            }
        }

        final void a(String str, FileDescriptor fileDescriptor) throws DescriptorValidationException {
            String substring;
            int lastIndexOf = str.lastIndexOf(46);
            byte b2 = 0;
            if (lastIndexOf == -1) {
                substring = str;
            } else {
                a(str.substring(0, lastIndexOf), fileDescriptor);
                substring = str.substring(lastIndexOf + 1);
            }
            GenericDescriptor put = this.c.put(str, new b(substring, str, fileDescriptor));
            if (put != null) {
                this.c.put(str, put);
                if (put instanceof b) {
                    return;
                }
                throw new DescriptorValidationException(fileDescriptor, "\"" + substring + "\" is already defined (as something other than a package) in file \"" + put.d().b() + "\".", b2);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private final GenericDescriptor f6680a;
            private final int b;

            a(GenericDescriptor genericDescriptor, int i) {
                this.f6680a = genericDescriptor;
                this.b = i;
            }

            public final int hashCode() {
                return (this.f6680a.hashCode() * GameRequest.TYPE_ALL) + this.b;
            }

            public final boolean equals(Object obj) {
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return this.f6680a == aVar.f6680a && this.b == aVar.b;
            }
        }

        final void a(FieldDescriptor fieldDescriptor) throws DescriptorValidationException {
            a aVar = new a(fieldDescriptor.t(), fieldDescriptor.e());
            FieldDescriptor put = this.d.put(aVar, fieldDescriptor);
            if (put == null) {
                return;
            }
            this.d.put(aVar, put);
            throw new DescriptorValidationException((GenericDescriptor) fieldDescriptor, "Field number " + fieldDescriptor.e() + " has already been used in \"" + fieldDescriptor.t().c() + "\" by field \"" + put.b() + "\".", (byte) 0);
        }

        final void a(EnumValueDescriptor enumValueDescriptor) {
            a aVar = new a(enumValueDescriptor.e(), enumValueDescriptor.a());
            EnumValueDescriptor put = this.e.put(aVar, enumValueDescriptor);
            if (put != null) {
                this.e.put(aVar, put);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class OneofDescriptor extends GenericDescriptor {

        /* renamed from: a, reason: collision with root package name */
        private final int f6690a;
        private DescriptorProtos.OneofDescriptorProto b;
        private final String c;
        private final FileDescriptor d;
        private Descriptor e;
        private int f;
        private FieldDescriptor[] g;

        /* synthetic */ OneofDescriptor(DescriptorProtos.OneofDescriptorProto oneofDescriptorProto, FileDescriptor fileDescriptor, Descriptor descriptor, int i, byte b) throws DescriptorValidationException {
            this(oneofDescriptorProto, fileDescriptor, descriptor, i);
        }

        static /* synthetic */ int a(OneofDescriptor oneofDescriptor, int i) {
            oneofDescriptor.f = 0;
            return 0;
        }

        static /* synthetic */ int b(OneofDescriptor oneofDescriptor) {
            int i = oneofDescriptor.f;
            oneofDescriptor.f = i + 1;
            return i;
        }

        @Override // com.uqm.crashsight.protobuf.Descriptors.GenericDescriptor
        public final /* bridge */ /* synthetic */ Message j() {
            return this.b;
        }

        public final int a() {
            return this.f6690a;
        }

        @Override // com.uqm.crashsight.protobuf.Descriptors.GenericDescriptor
        public final String b() {
            return this.b.f();
        }

        @Override // com.uqm.crashsight.protobuf.Descriptors.GenericDescriptor
        public final FileDescriptor d() {
            return this.d;
        }

        @Override // com.uqm.crashsight.protobuf.Descriptors.GenericDescriptor
        public final String c() {
            return this.c;
        }

        public final Descriptor e() {
            return this.e;
        }

        public final int f() {
            return this.f;
        }

        private OneofDescriptor(DescriptorProtos.OneofDescriptorProto oneofDescriptorProto, FileDescriptor fileDescriptor, Descriptor descriptor, int i) throws DescriptorValidationException {
            super((byte) 0);
            this.b = oneofDescriptorProto;
            this.c = Descriptors.a(fileDescriptor, descriptor, oneofDescriptorProto.f());
            this.d = fileDescriptor;
            this.f6690a = i;
            this.e = descriptor;
            this.f = 0;
        }
    }
}
