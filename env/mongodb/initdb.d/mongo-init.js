// https://github.com/TGITS/docker-compose-examples/blob/main/mongodb-docker-compose-examples/mongodb-single/mongodb/initdb.d/mongo-init.js
db = db.getSiblingDB("product-catalog-service");

db.createUser({
    user: "admin",
    pwd: "password",
    roles: [
        {
            role: 'readWrite',
            db: 'product-catalog-service'
        }
    ],
});
