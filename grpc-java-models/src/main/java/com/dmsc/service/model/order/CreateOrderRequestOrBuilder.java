// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: order_service.proto

// Protobuf Java Version: 3.25.3
package com.dmsc.service.model.order;

public interface CreateOrderRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:orders.CreateOrderRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .orders.OrderProduct products = 1;</code>
   */
  java.util.List<com.dmsc.service.model.order.OrderProduct> 
      getProductsList();
  /**
   * <code>repeated .orders.OrderProduct products = 1;</code>
   */
  com.dmsc.service.model.order.OrderProduct getProducts(int index);
  /**
   * <code>repeated .orders.OrderProduct products = 1;</code>
   */
  int getProductsCount();
  /**
   * <code>repeated .orders.OrderProduct products = 1;</code>
   */
  java.util.List<? extends com.dmsc.service.model.order.OrderProductOrBuilder> 
      getProductsOrBuilderList();
  /**
   * <code>repeated .orders.OrderProduct products = 1;</code>
   */
  com.dmsc.service.model.order.OrderProductOrBuilder getProductsOrBuilder(
      int index);

  /**
   * <code>string user_id = 2;</code>
   * @return The userId.
   */
  java.lang.String getUserId();
  /**
   * <code>string user_id = 2;</code>
   * @return The bytes for userId.
   */
  com.google.protobuf.ByteString
      getUserIdBytes();
}
