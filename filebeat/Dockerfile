FROM docker.elastic.co/beats/filebeat:8.1.0

COPY config/filebeat.yml /usr/share/filebeat/filebeat.yml

USER root
RUN chown -R root /usr/share/filebeat/
RUN chmod -R go-w /usr/share/filebeat/