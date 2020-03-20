#!/bin/bash

if [ -z "$1" ]; then
	echo "Please provide a full path to the spring config dir"
	exit 1
fi
if [ -z "$2" ]; then
	echo "Please provide a name of the spring profile which will be active (may should match with the naming of the application.yml (e.g. application-dev.yml)"
	exit 1
fi

docker run -it -p 50123:50123 --name virus --rm -v $1:/config -e SPRING_PROFILES_ACTIVE=$2 floge77/back-end-wvv
