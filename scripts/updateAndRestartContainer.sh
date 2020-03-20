

docker stop virus
docker pull
docker run -d -p 50123:50123 --name virus --rm -v $1:/config -e SPRING_PROFILES_ACTIVE=$2 floge77/back-end-wvv