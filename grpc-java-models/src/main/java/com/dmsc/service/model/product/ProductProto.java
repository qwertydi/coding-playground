// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: product_service.proto

// Protobuf Java Version: 3.25.3
package com.dmsc.service.model.product;

public final class ProductProto {
  private ProductProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_products_Product_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_products_Product_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_products_ProductResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_products_ProductResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_products_ListProducts_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_products_ListProducts_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_products_ItemRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_products_ItemRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_products_CategoryRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_products_CategoryRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_products_ProductStockQuantity_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_products_ProductStockQuantity_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\025product_service.proto\022\010products\032\033googl" +
      "e/protobuf/empty.proto\032\033buf/validate/val" +
      "idate.proto\"\322\001\n\007Product\022W\n\004name\030\001 \001(\tBI\272" +
      "HF\272\001C\n\004name\022)name length must be at leas" +
      "t 5 characters\032\020this.size() >= 5\022\026\n\005pric" +
      "e\030\002 \001(\003B\007\272H\004\"\002(\000\022\034\n\013description\030\003 \001(\tB\007\272" +
      "H\004r\002\020\005\022\031\n\010category\030\004 \001(\tB\007\272H\004r\002\020\001\022\035\n\014ava" +
      "ilability\030\005 \001(\005B\007\272H\004\032\002(\000\"w\n\017ProductRespo" +
      "nse\022\n\n\002id\030\001 \001(\t\022\014\n\004name\030\002 \001(\t\022\r\n\005price\030\003" +
      " \001(\003\022\023\n\013description\030\004 \001(\t\022\020\n\010category\030\005 " +
      "\001(\t\022\024\n\014availability\030\006 \001(\005\";\n\014ListProduct" +
      "s\022+\n\010products\030\001 \003(\0132\031.products.ProductRe" +
      "sponse\"\031\n\013ItemRequest\022\n\n\002id\030\001 \001(\t\",\n\017Cat" +
      "egoryRequest\022\031\n\010category\030\001 \001(\tB\007\272H\004r\002\020\001\"" +
      "\203\001\n\024ProductStockQuantity\022\n\n\002id\030\001 \001(\t\022_\n\010" +
      "quantity\030\002 \001(\005BM\272HJ\272\001G\n\033minimum_whole_sa" +
      "le_quantity\022\035quantity must be 0 or great" +
      "er\032\tthis >= 02\340\002\n\016ProductService\0226\n\004List" +
      "\022\026.google.protobuf.Empty\032\026.products.List" +
      "Products\022C\n\016ListByCategory\022\031.products.Ca" +
      "tegoryRequest\032\026.products.ListProducts\022G\n" +
      "\rIncreaseStock\022\036.products.ProductStockQu" +
      "antity\032\026.google.protobuf.Empty\022G\n\rDecrea" +
      "seStock\022\036.products.ProductStockQuantity\032" +
      "\026.google.protobuf.Empty\022?\n\013ProductById\022\025" +
      ".products.ItemRequest\032\031.products.Product" +
      "Response2\203\001\n\023AdminProductService\0223\n\003Add\022" +
      "\021.products.Product\032\031.products.ProductRes" +
      "ponse\0227\n\006Delete\022\025.products.ItemRequest\032\026" +
      ".google.protobuf.EmptyBV\n\036com.dmsc.servi" +
      "ce.model.productB\014ProductProtoP\001Z$github" +
      ".com/qwertydi/playground/pb/v1b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.EmptyProto.getDescriptor(),
          build.buf.validate.ValidateProto.getDescriptor(),
        });
    internal_static_products_Product_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_products_Product_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_products_Product_descriptor,
        new java.lang.String[] { "Name", "Price", "Description", "Category", "Availability", });
    internal_static_products_ProductResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_products_ProductResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_products_ProductResponse_descriptor,
        new java.lang.String[] { "Id", "Name", "Price", "Description", "Category", "Availability", });
    internal_static_products_ListProducts_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_products_ListProducts_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_products_ListProducts_descriptor,
        new java.lang.String[] { "Products", });
    internal_static_products_ItemRequest_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_products_ItemRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_products_ItemRequest_descriptor,
        new java.lang.String[] { "Id", });
    internal_static_products_CategoryRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_products_CategoryRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_products_CategoryRequest_descriptor,
        new java.lang.String[] { "Category", });
    internal_static_products_ProductStockQuantity_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_products_ProductStockQuantity_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_products_ProductStockQuantity_descriptor,
        new java.lang.String[] { "Id", "Quantity", });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(build.buf.validate.ValidateProto.field);
    com.google.protobuf.Descriptors.FileDescriptor
        .internalUpdateFileDescriptor(descriptor, registry);
    com.google.protobuf.EmptyProto.getDescriptor();
    build.buf.validate.ValidateProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
