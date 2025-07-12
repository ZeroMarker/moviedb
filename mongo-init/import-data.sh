#!/bin/bash
set -e

echo "Waiting for MongoDB to start..."
until mongosh --host localhost --eval "db.adminCommand('ping')" &> /dev/null; do
    sleep 1
done

echo "Importing data..."
mongoimport --host localhost \
  --username root --password rootpassword \
  --authenticationDatabase admin \
  --db movie_db \
  --collection movies \
  --type json \
  --file /docker-entrypoint-initdb.d/movies.json \
  --jsonArray

echo "Data import completed successfully"