package com.uqm.crashsight.protobuf;

import com.uqm.crashsight.protobuf.AbstractMessage;
import com.uqm.crashsight.protobuf.Message;
import java.io.Serializable;

/* loaded from: classes3.dex */
public abstract class GeneratedMessage extends AbstractMessage implements Serializable {

    /* loaded from: classes3.dex */
    public interface BuilderParent extends AbstractMessage.BuilderParent {
    }

    /* loaded from: classes3.dex */
    public interface ExtendableMessageOrBuilder<MessageType extends ExtendableMessage> extends MessageOrBuilder {
    }

    /* loaded from: classes3.dex */
    public static final class FieldAccessorTable {
    }

    /* loaded from: classes3.dex */
    public static class GeneratedExtension<ContainingType extends Message, Type> extends Extension<ContainingType, Type> {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Message.Builder c();

    protected GeneratedMessage() {
        UnknownFieldSet.b();
    }

    /* loaded from: classes3.dex */
    public static abstract class Builder<BuilderType extends Builder<BuilderType>> extends AbstractMessage.Builder<BuilderType> {

        /* renamed from: a, reason: collision with root package name */
        private BuilderParent f6708a;
        private boolean b;

        @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public /* synthetic */ Object mo11clone() throws CloneNotSupportedException {
            Builder builder = (Builder) r().q();
            builder.c(g());
            return builder;
        }

        protected Builder() {
            this(null);
        }

        private Builder(BuilderParent builderParent) {
            UnknownFieldSet.b();
            this.f6708a = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder
        public final void a_() {
            this.b = true;
        }

        protected final void c() {
            BuilderParent builderParent;
            if (!this.b || (builderParent = this.f6708a) == null) {
                return;
            }
            builderParent.a();
            this.b = false;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage> extends GeneratedMessage implements ExtendableMessageOrBuilder<MessageType> {

        /* loaded from: classes3.dex */
        public class ExtensionWriter {
        }

        protected ExtendableMessage() {
            FieldSet.a();
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<BuilderType> implements ExtendableMessageOrBuilder<MessageType> {
        @Override // com.uqm.crashsight.protobuf.GeneratedMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public /* synthetic */ Object mo11clone() throws CloneNotSupportedException {
            Builder builder = (Builder) r().q();
            builder.c(g());
            return (ExtendableBuilder) builder;
        }

        protected ExtendableBuilder() {
            FieldSet.b();
        }
    }
}
