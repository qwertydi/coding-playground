DB_URL=postgresql://admin:playgroundPW1@localhost:5432/playground_db?sslmode=disable

proto:
	rm -f pb/*.go
	rm -f doc/swagger/*.swagger.json
	mkdir -p proto-files
	cp ../proto/* proto-files/
	protoc --proto_path=proto-files --go_out=pb --go_opt=paths=source_relative \
	--go-grpc_out=pb --go-grpc_opt=paths=source_relative \
	proto-files/*.proto
	rm -rf proto-files

.PHONY: proto
