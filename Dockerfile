FROM openjdk:8-jre-alpine

MAINTAINER Jorgiano Vidal "jorgiano.vidal@ifrn.edu.br"

EXPOSE 9000

# Instala 'bash' para executar dist gerada pelo sbt (Simple Build Tool).
# 'shadow' permite modificações de usuário
RUN apk add --no-cache --update \
      bash \
      shadow && \
    rm -rf /var/cache/apk/*

RUN adduser -D www-doele

USER www-doele

ADD --chown=www-doele svc/*SNAPSHOT/bin /home/www-doele/bin
ADD --chown=www-doele svc/*SNAPSHOT/conf /home/www-doele/conf
ADD --chown=www-doele svc/*SNAPSHOT/lib /home/www-doele/lib
ADD --chown=www-doele svc/*SNAPSHOT/share /home/www-doele/share

RUN cd /home/www-doele && chown -R www-doele . && \
    mkdir logs && \
    touch logs/application.log

WORKDIR /home/www-doele

CMD /home/www-doele/bin/www-doele -Dconfig.resource=production.conf
