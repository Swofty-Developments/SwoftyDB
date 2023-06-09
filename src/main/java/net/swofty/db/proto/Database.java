// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: database.proto

package net.swofty.db.proto;

/**
 * Protobuf type {@code Database}
 */
public final class Database extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Database)
    DatabaseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Database.newBuilder() to construct.
  private Database(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Database() {
    documents_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Database();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return net.swofty.db.proto.SwoftyDB.internal_static_Database_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return net.swofty.db.proto.SwoftyDB.internal_static_Database_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            net.swofty.db.proto.Database.class, net.swofty.db.proto.Database.Builder.class);
  }

  public static final int DOCUMENTS_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private java.util.List<net.swofty.db.proto.Document> documents_;
  /**
   * <code>repeated .Document documents = 1;</code>
   */
  @java.lang.Override
  public java.util.List<net.swofty.db.proto.Document> getDocumentsList() {
    return documents_;
  }
  /**
   * <code>repeated .Document documents = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends net.swofty.db.proto.DocumentOrBuilder> 
      getDocumentsOrBuilderList() {
    return documents_;
  }
  /**
   * <code>repeated .Document documents = 1;</code>
   */
  @java.lang.Override
  public int getDocumentsCount() {
    return documents_.size();
  }
  /**
   * <code>repeated .Document documents = 1;</code>
   */
  @java.lang.Override
  public net.swofty.db.proto.Document getDocuments(int index) {
    return documents_.get(index);
  }
  /**
   * <code>repeated .Document documents = 1;</code>
   */
  @java.lang.Override
  public net.swofty.db.proto.DocumentOrBuilder getDocumentsOrBuilder(
      int index) {
    return documents_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < documents_.size(); i++) {
      output.writeMessage(1, documents_.get(i));
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < documents_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, documents_.get(i));
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof net.swofty.db.proto.Database)) {
      return super.equals(obj);
    }
    net.swofty.db.proto.Database other = (net.swofty.db.proto.Database) obj;

    if (!getDocumentsList()
        .equals(other.getDocumentsList())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getDocumentsCount() > 0) {
      hash = (37 * hash) + DOCUMENTS_FIELD_NUMBER;
      hash = (53 * hash) + getDocumentsList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static net.swofty.db.proto.Database parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static net.swofty.db.proto.Database parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static net.swofty.db.proto.Database parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static net.swofty.db.proto.Database parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static net.swofty.db.proto.Database parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static net.swofty.db.proto.Database parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static net.swofty.db.proto.Database parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static net.swofty.db.proto.Database parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static net.swofty.db.proto.Database parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static net.swofty.db.proto.Database parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static net.swofty.db.proto.Database parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static net.swofty.db.proto.Database parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(net.swofty.db.proto.Database prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code Database}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Database)
      net.swofty.db.proto.DatabaseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return net.swofty.db.proto.SwoftyDB.internal_static_Database_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return net.swofty.db.proto.SwoftyDB.internal_static_Database_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              net.swofty.db.proto.Database.class, net.swofty.db.proto.Database.Builder.class);
    }

    // Construct using net.swofty.db.proto.Database.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      if (documentsBuilder_ == null) {
        documents_ = java.util.Collections.emptyList();
      } else {
        documents_ = null;
        documentsBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return net.swofty.db.proto.SwoftyDB.internal_static_Database_descriptor;
    }

    @java.lang.Override
    public net.swofty.db.proto.Database getDefaultInstanceForType() {
      return net.swofty.db.proto.Database.getDefaultInstance();
    }

    @java.lang.Override
    public net.swofty.db.proto.Database build() {
      net.swofty.db.proto.Database result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public net.swofty.db.proto.Database buildPartial() {
      net.swofty.db.proto.Database result = new net.swofty.db.proto.Database(this);
      buildPartialRepeatedFields(result);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartialRepeatedFields(net.swofty.db.proto.Database result) {
      if (documentsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          documents_ = java.util.Collections.unmodifiableList(documents_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.documents_ = documents_;
      } else {
        result.documents_ = documentsBuilder_.build();
      }
    }

    private void buildPartial0(net.swofty.db.proto.Database result) {
      int from_bitField0_ = bitField0_;
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof net.swofty.db.proto.Database) {
        return mergeFrom((net.swofty.db.proto.Database)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(net.swofty.db.proto.Database other) {
      if (other == net.swofty.db.proto.Database.getDefaultInstance()) return this;
      if (documentsBuilder_ == null) {
        if (!other.documents_.isEmpty()) {
          if (documents_.isEmpty()) {
            documents_ = other.documents_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureDocumentsIsMutable();
            documents_.addAll(other.documents_);
          }
          onChanged();
        }
      } else {
        if (!other.documents_.isEmpty()) {
          if (documentsBuilder_.isEmpty()) {
            documentsBuilder_.dispose();
            documentsBuilder_ = null;
            documents_ = other.documents_;
            bitField0_ = (bitField0_ & ~0x00000001);
            documentsBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getDocumentsFieldBuilder() : null;
          } else {
            documentsBuilder_.addAllMessages(other.documents_);
          }
        }
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              net.swofty.db.proto.Document m =
                  input.readMessage(
                      net.swofty.db.proto.Document.parser(),
                      extensionRegistry);
              if (documentsBuilder_ == null) {
                ensureDocumentsIsMutable();
                documents_.add(m);
              } else {
                documentsBuilder_.addMessage(m);
              }
              break;
            } // case 10
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private java.util.List<net.swofty.db.proto.Document> documents_ =
      java.util.Collections.emptyList();
    private void ensureDocumentsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        documents_ = new java.util.ArrayList<net.swofty.db.proto.Document>(documents_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        net.swofty.db.proto.Document, net.swofty.db.proto.Document.Builder, net.swofty.db.proto.DocumentOrBuilder> documentsBuilder_;

    /**
     * <code>repeated .Document documents = 1;</code>
     */
    public java.util.List<net.swofty.db.proto.Document> getDocumentsList() {
      if (documentsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(documents_);
      } else {
        return documentsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .Document documents = 1;</code>
     */
    public int getDocumentsCount() {
      if (documentsBuilder_ == null) {
        return documents_.size();
      } else {
        return documentsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .Document documents = 1;</code>
     */
    public net.swofty.db.proto.Document getDocuments(int index) {
      if (documentsBuilder_ == null) {
        return documents_.get(index);
      } else {
        return documentsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .Document documents = 1;</code>
     */
    public Builder setDocuments(
        int index, net.swofty.db.proto.Document value) {
      if (documentsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDocumentsIsMutable();
        documents_.set(index, value);
        onChanged();
      } else {
        documentsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .Document documents = 1;</code>
     */
    public Builder setDocuments(
        int index, net.swofty.db.proto.Document.Builder builderForValue) {
      if (documentsBuilder_ == null) {
        ensureDocumentsIsMutable();
        documents_.set(index, builderForValue.build());
        onChanged();
      } else {
        documentsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Document documents = 1;</code>
     */
    public Builder addDocuments(net.swofty.db.proto.Document value) {
      if (documentsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDocumentsIsMutable();
        documents_.add(value);
        onChanged();
      } else {
        documentsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .Document documents = 1;</code>
     */
    public Builder addDocuments(
        int index, net.swofty.db.proto.Document value) {
      if (documentsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDocumentsIsMutable();
        documents_.add(index, value);
        onChanged();
      } else {
        documentsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .Document documents = 1;</code>
     */
    public Builder addDocuments(
        net.swofty.db.proto.Document.Builder builderForValue) {
      if (documentsBuilder_ == null) {
        ensureDocumentsIsMutable();
        documents_.add(builderForValue.build());
        onChanged();
      } else {
        documentsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Document documents = 1;</code>
     */
    public Builder addDocuments(
        int index, net.swofty.db.proto.Document.Builder builderForValue) {
      if (documentsBuilder_ == null) {
        ensureDocumentsIsMutable();
        documents_.add(index, builderForValue.build());
        onChanged();
      } else {
        documentsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Document documents = 1;</code>
     */
    public Builder addAllDocuments(
        java.lang.Iterable<? extends net.swofty.db.proto.Document> values) {
      if (documentsBuilder_ == null) {
        ensureDocumentsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, documents_);
        onChanged();
      } else {
        documentsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .Document documents = 1;</code>
     */
    public Builder clearDocuments() {
      if (documentsBuilder_ == null) {
        documents_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        documentsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .Document documents = 1;</code>
     */
    public Builder removeDocuments(int index) {
      if (documentsBuilder_ == null) {
        ensureDocumentsIsMutable();
        documents_.remove(index);
        onChanged();
      } else {
        documentsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .Document documents = 1;</code>
     */
    public net.swofty.db.proto.Document.Builder getDocumentsBuilder(
        int index) {
      return getDocumentsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .Document documents = 1;</code>
     */
    public net.swofty.db.proto.DocumentOrBuilder getDocumentsOrBuilder(
        int index) {
      if (documentsBuilder_ == null) {
        return documents_.get(index);  } else {
        return documentsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .Document documents = 1;</code>
     */
    public java.util.List<? extends net.swofty.db.proto.DocumentOrBuilder> 
         getDocumentsOrBuilderList() {
      if (documentsBuilder_ != null) {
        return documentsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(documents_);
      }
    }
    /**
     * <code>repeated .Document documents = 1;</code>
     */
    public net.swofty.db.proto.Document.Builder addDocumentsBuilder() {
      return getDocumentsFieldBuilder().addBuilder(
          net.swofty.db.proto.Document.getDefaultInstance());
    }
    /**
     * <code>repeated .Document documents = 1;</code>
     */
    public net.swofty.db.proto.Document.Builder addDocumentsBuilder(
        int index) {
      return getDocumentsFieldBuilder().addBuilder(
          index, net.swofty.db.proto.Document.getDefaultInstance());
    }
    /**
     * <code>repeated .Document documents = 1;</code>
     */
    public java.util.List<net.swofty.db.proto.Document.Builder> 
         getDocumentsBuilderList() {
      return getDocumentsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        net.swofty.db.proto.Document, net.swofty.db.proto.Document.Builder, net.swofty.db.proto.DocumentOrBuilder> 
        getDocumentsFieldBuilder() {
      if (documentsBuilder_ == null) {
        documentsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            net.swofty.db.proto.Document, net.swofty.db.proto.Document.Builder, net.swofty.db.proto.DocumentOrBuilder>(
                documents_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        documents_ = null;
      }
      return documentsBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:Database)
  }

  // @@protoc_insertion_point(class_scope:Database)
  private static final net.swofty.db.proto.Database DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new net.swofty.db.proto.Database();
  }

  public static net.swofty.db.proto.Database getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Database>
      PARSER = new com.google.protobuf.AbstractParser<Database>() {
    @java.lang.Override
    public Database parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<Database> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Database> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public net.swofty.db.proto.Database getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

