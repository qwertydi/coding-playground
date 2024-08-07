proto:
	rm -f pb/*.go
	rm -f doc/swagger/*.swagger.json
	mkdir -p proto
	cp ../proto/* proto/
	protoc --proto_path=proto --go_out=pb --go_opt=paths=source_relative \
	--go-grpc_out=pb --go-grpc_opt=paths=source_relative \
	proto/*.proto
	rm -rf proto

.PHONY: proto
