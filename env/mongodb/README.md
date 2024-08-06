docker volume create --name mongodb-data --opt type=none --opt device=/Users/dcorreia/Development/mongodb/data --opt o=bind
docker volume create --name mongodb-log --opt type=none --opt device=/Users/dcorreia/Development/mongodb/logs --opt o=bind

sudo chown -R 1000:1000 /Users/dcorreia/Development/mongodb/data
sudo chmod -R 755 /Users/dcorreia/Development/mongodb/data
sudo chown -R 1000:1000 /Users/dcorreia/Development/mongodb/log
sudo chmod -R 755 /Users/dcorreia/Development/mongodb/log