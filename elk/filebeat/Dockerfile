FROM docker.elastic.co/beats/filebeat:8.7.0

COPY filebeat.yml /usr/share/filebeat/filebeat.yml

USER root
RUN mkdir /usr/share/filebeat/dockerlogs
RUN chown -R root /usr/share/filebeat/
RUN chmod -R go-w /usr/share/filebeat/