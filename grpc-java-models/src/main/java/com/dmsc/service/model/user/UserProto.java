// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: user_service.proto

// Protobuf Java Version: 3.25.3
package com.dmsc.service.model.user;

public final class UserProto {
  private UserProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_user_User_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_user_User_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_user_UserResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_user_UserResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_user_CreateUser_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_user_CreateUser_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_user_AuthenticateUser_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_user_AuthenticateUser_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\022user_service.proto\022\004user\032\033google/proto" +
      "buf/empty.proto\"S\n\004User\022\n\n\002id\030\001 \001(\t\022\014\n\004n" +
      "ame\030\002 \001(\t\022\r\n\005email\030\003 \001(\t\022\020\n\010username\030\004 \001" +
      "(\t\022\020\n\010password\030\005 \001(\t\"I\n\014UserResponse\022\n\n\002" +
      "id\030\001 \001(\t\022\014\n\004name\030\002 \001(\t\022\r\n\005email\030\003 \001(\t\022\020\n" +
      "\010username\030\004 \001(\t\"M\n\nCreateUser\022\014\n\004name\030\001 " +
      "\001(\t\022\r\n\005email\030\002 \001(\t\022\020\n\010username\030\003 \001(\t\022\020\n\010" +
      "password\030\004 \001(\t\"6\n\020AuthenticateUser\022\020\n\010us" +
      "ername\030\001 \001(\t\022\020\n\010password\030\002 \001(\t2\260\001\n\013UserS" +
      "ervice\022.\n\006Create\022\020.user.CreateUser\032\022.use" +
      "r.UserResponse\0225\n\007GetUser\022\026.google.proto" +
      "buf.Empty\032\022.user.UserResponse\022:\n\014GetUser" +
      "Login\022\026.user.AuthenticateUser\032\022.user.Use" +
      "rResponseB.\n\033com.dmsc.service.model.user" +
      "B\tUserProtoP\001Z\002./b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.EmptyProto.getDescriptor(),
        });
    internal_static_user_User_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_user_User_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_user_User_descriptor,
        new java.lang.String[] { "Id", "Name", "Email", "Username", "Password", });
    internal_static_user_UserResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_user_UserResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_user_UserResponse_descriptor,
        new java.lang.String[] { "Id", "Name", "Email", "Username", });
    internal_static_user_CreateUser_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_user_CreateUser_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_user_CreateUser_descriptor,
        new java.lang.String[] { "Name", "Email", "Username", "Password", });
    internal_static_user_AuthenticateUser_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_user_AuthenticateUser_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_user_AuthenticateUser_descriptor,
        new java.lang.String[] { "Username", "Password", });
    com.google.protobuf.EmptyProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
