#!/bin/bash

if [ -z "$1" ]; then
	echo "Please provide a password for postgres user wvv-user"
	exit 1
fi
password=$1

docker run -d --network wvv --rm --name postgres \
-e POSTGRES_USER=wvv-user \
-e POSTGRES_PASSWORD="$password" \
-e POSTGRES_DB=wvv  \
-v $HOME/postgres/data:/var/lib/postgresql/data \
postgres:12.2
