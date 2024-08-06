## PLAYGROUND

### Sources:
- https://medium.com/@michael.sklyar/shared-protobuf-library-for-java-and-golang-bd9cd3b88a9

### Protobuff
- Install on machine:
```
MacOS:
brew install protobuf
```
- Generate Java:
```
protoc --proto_path=./proto/ --java_out=:service/src/main/java/com/dmsc/service/ ./proto/manage/*.proto  
```
- Generate Go:
```
install go-proto: go get -u github.com/golang/protobuf/{proto,protoc-gen-go}

protoc  \
     --proto_path=./proto/ \
     --go_out=:generated/go/ \
    ./proto/manage/*.proto
```
- Validation:
  - https://github.com/bufbuild/protoc-gen-validate
- Issues:
  - google/protobuf/empty.proto: File not found.
    ```
    curl -OL https://github.com/google/protobuf/releases/download/v3.2.0/protoc-3.2.0-linux-x86_64.zip
    unzip protoc-3.2.0-linux-x86_64.zip -d protoc3
    sudo mv protoc3/bin/* /usr/local/bin/
    sudo mv protoc3/include/* /usr/local/include/
    ```
    - https://google.github.io/proto-lens/installing-protoc.html
  - brew install bufbuild/buf/buf