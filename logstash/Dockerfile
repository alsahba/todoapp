FROM docker.elastic.co/logstash/logstash:8.1.0
RUN rm -f /usr/share/logstash/pipeline/logstash.conf
ADD config/ /usr/share/logstash/pipeline/