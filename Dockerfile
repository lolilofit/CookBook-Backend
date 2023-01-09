FROM yandex/clickhouse-server:latest
COPY full_dataset.csv /etc/clickhouse-server/full_dataset.csv
COPY bd.sh /docker-entrypoint-initdb.d/bd.sh
EXPOSE 8123