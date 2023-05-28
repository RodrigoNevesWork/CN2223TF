// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: contract.proto

package CNcontract;

/**
 * Protobuf type {@code CNcontract.Photos}
 */
public  final class Photos extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:CNcontract.Photos)
    PhotosOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Photos.newBuilder() to construct.
  private Photos(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Photos() {
    photoName_ = "";
    locationName_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Photos();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Photos(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            photoName_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            locationName_ = s;
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return CNcontract.Contract.internal_static_CNcontract_Photos_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return CNcontract.Contract.internal_static_CNcontract_Photos_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            CNcontract.Photos.class, CNcontract.Photos.Builder.class);
  }

  public static final int PHOTONAME_FIELD_NUMBER = 1;
  private volatile java.lang.Object photoName_;
  /**
   * <code>string photoName = 1;</code>
   * @return The photoName.
   */
  public java.lang.String getPhotoName() {
    java.lang.Object ref = photoName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      photoName_ = s;
      return s;
    }
  }
  /**
   * <code>string photoName = 1;</code>
   * @return The bytes for photoName.
   */
  public com.google.protobuf.ByteString
      getPhotoNameBytes() {
    java.lang.Object ref = photoName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      photoName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int LOCATIONNAME_FIELD_NUMBER = 2;
  private volatile java.lang.Object locationName_;
  /**
   * <code>string locationName = 2;</code>
   * @return The locationName.
   */
  public java.lang.String getLocationName() {
    java.lang.Object ref = locationName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      locationName_ = s;
      return s;
    }
  }
  /**
   * <code>string locationName = 2;</code>
   * @return The bytes for locationName.
   */
  public com.google.protobuf.ByteString
      getLocationNameBytes() {
    java.lang.Object ref = locationName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      locationName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (!getPhotoNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, photoName_);
    }
    if (!getLocationNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, locationName_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getPhotoNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, photoName_);
    }
    if (!getLocationNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, locationName_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof CNcontract.Photos)) {
      return super.equals(obj);
    }
    CNcontract.Photos other = (CNcontract.Photos) obj;

    if (!getPhotoName()
        .equals(other.getPhotoName())) return false;
    if (!getLocationName()
        .equals(other.getLocationName())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + PHOTONAME_FIELD_NUMBER;
    hash = (53 * hash) + getPhotoName().hashCode();
    hash = (37 * hash) + LOCATIONNAME_FIELD_NUMBER;
    hash = (53 * hash) + getLocationName().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static CNcontract.Photos parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static CNcontract.Photos parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static CNcontract.Photos parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static CNcontract.Photos parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static CNcontract.Photos parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static CNcontract.Photos parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static CNcontract.Photos parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static CNcontract.Photos parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static CNcontract.Photos parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static CNcontract.Photos parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static CNcontract.Photos parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static CNcontract.Photos parseFrom(
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
  public static Builder newBuilder(CNcontract.Photos prototype) {
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
   * Protobuf type {@code CNcontract.Photos}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:CNcontract.Photos)
      CNcontract.PhotosOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return CNcontract.Contract.internal_static_CNcontract_Photos_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return CNcontract.Contract.internal_static_CNcontract_Photos_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              CNcontract.Photos.class, CNcontract.Photos.Builder.class);
    }

    // Construct using CNcontract.Photos.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      photoName_ = "";

      locationName_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return CNcontract.Contract.internal_static_CNcontract_Photos_descriptor;
    }

    @java.lang.Override
    public CNcontract.Photos getDefaultInstanceForType() {
      return CNcontract.Photos.getDefaultInstance();
    }

    @java.lang.Override
    public CNcontract.Photos build() {
      CNcontract.Photos result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public CNcontract.Photos buildPartial() {
      CNcontract.Photos result = new CNcontract.Photos(this);
      result.photoName_ = photoName_;
      result.locationName_ = locationName_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof CNcontract.Photos) {
        return mergeFrom((CNcontract.Photos)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(CNcontract.Photos other) {
      if (other == CNcontract.Photos.getDefaultInstance()) return this;
      if (!other.getPhotoName().isEmpty()) {
        photoName_ = other.photoName_;
        onChanged();
      }
      if (!other.getLocationName().isEmpty()) {
        locationName_ = other.locationName_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
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
      CNcontract.Photos parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (CNcontract.Photos) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object photoName_ = "";
    /**
     * <code>string photoName = 1;</code>
     * @return The photoName.
     */
    public java.lang.String getPhotoName() {
      java.lang.Object ref = photoName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        photoName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string photoName = 1;</code>
     * @return The bytes for photoName.
     */
    public com.google.protobuf.ByteString
        getPhotoNameBytes() {
      java.lang.Object ref = photoName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        photoName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string photoName = 1;</code>
     * @param value The photoName to set.
     * @return This builder for chaining.
     */
    public Builder setPhotoName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      photoName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string photoName = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearPhotoName() {
      
      photoName_ = getDefaultInstance().getPhotoName();
      onChanged();
      return this;
    }
    /**
     * <code>string photoName = 1;</code>
     * @param value The bytes for photoName to set.
     * @return This builder for chaining.
     */
    public Builder setPhotoNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      photoName_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object locationName_ = "";
    /**
     * <code>string locationName = 2;</code>
     * @return The locationName.
     */
    public java.lang.String getLocationName() {
      java.lang.Object ref = locationName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        locationName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string locationName = 2;</code>
     * @return The bytes for locationName.
     */
    public com.google.protobuf.ByteString
        getLocationNameBytes() {
      java.lang.Object ref = locationName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        locationName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string locationName = 2;</code>
     * @param value The locationName to set.
     * @return This builder for chaining.
     */
    public Builder setLocationName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      locationName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string locationName = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearLocationName() {
      
      locationName_ = getDefaultInstance().getLocationName();
      onChanged();
      return this;
    }
    /**
     * <code>string locationName = 2;</code>
     * @param value The bytes for locationName to set.
     * @return This builder for chaining.
     */
    public Builder setLocationNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      locationName_ = value;
      onChanged();
      return this;
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


    // @@protoc_insertion_point(builder_scope:CNcontract.Photos)
  }

  // @@protoc_insertion_point(class_scope:CNcontract.Photos)
  private static final CNcontract.Photos DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new CNcontract.Photos();
  }

  public static CNcontract.Photos getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Photos>
      PARSER = new com.google.protobuf.AbstractParser<Photos>() {
    @java.lang.Override
    public Photos parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Photos(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Photos> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Photos> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public CNcontract.Photos getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

