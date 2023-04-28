ARG nodeVersion=12.15.0
ARG HOME=/opt/app
ARG PROD_NODE_MODULES_PATH=/tmp/prod_node_modules
ARG WML_NEXUS_REPO_HOST=https://repository.walmart.com

# certs stage
FROM docker.prod.walmart.com/wce/ca-roots:latest as roots

#base layer
FROM hub.docker.prod.walmart.com/library/node:${nodeVersion}-alpine AS base
RUN echo '===== BEGIN INSTALLING BASE ====='

ARG WML_NEXUS_REPO_HOST
RUN echo "${WML_NEXUS_REPO_HOST}/content/repositories/alpine-v38/community" > /etc/apk/repositories
RUN echo "${WML_NEXUS_REPO_HOST}/content/repositories/alpine-v38/main" >> /etc/apk/repositories
RUN apk update && apk add --no-cache tini curl
ENTRYPOINT ["/sbin/tini", "--"]
RUN echo '===== END INSTALLING BASE ====='

#install node modules
FROM base AS install_node_modules
RUN echo '===== BEGIN INSTALLING NODE_MODULES ====='
ARG HOME
ARG WML_NEXUS_REPO_HOST
ARG PROD_NODE_MODULES_PATH
ARG nodePM
ENV NODEJS_ORG_MIRROR ${WML_NEXUS_REPO_HOST}/content/repositories/nodejs/
ENV PHANTOMJS_CDNURL ${WML_NEXUS_REPO_HOST}/content/repositories/PhantomJS
ENV SASS_BINARY_SITE ${WML_NEXUS_REPO_HOST}/content/repositories/pangaea_snapshots/com/walmart/atlas/electrode/node-sass
ENV FSE_BINARY_HOST_MIRROR ${WML_NEXUS_REPO_HOST}/content/repositories/pangaea_snapshots/com/walmart/atlas/electrode/fsevents
ENV CHROMEDRIVER_CDNURL ${WML_NEXUS_REPO_HOST}/repository/googleapis-storage/chromedriver/
ENV PUPPETEER_DOWNLOAD_HOST ${WML_NEXUS_REPO_HOST}/repository/googleapis-storage/
ENV PUPPETEER_SKIP_CHROMIUM_DOWNLOAD 1

# Installs latest Chromium, python, g++, curl
RUN apk update && apk upgrade \
  && apk add --no-cache chromium python make g++ openssl curl \
  && rm -rf /var/cache/* \
  && mkdir /var/cache/apk
RUN apk add --update curl && \
  rm -rf /var/cache/apk/*

ENV CHROME_BIN=/usr/bin/chromium-browser \
  CHROME_PATH=/usr/lib/chromium/ \
  KARMA_BROWSER=chrome

WORKDIR $HOME

COPY --chown=node:node package.json package.json
COPY --chown=node:node package-lock.json package-lock.json
COPY --chown=node:node .npmrc .npmrc
COPY --chown=node:node e2e e2e
COPY --chown=node:node src src
COPY --chown=node:node tsconfig.json tsconfig.json
COPY --chown=node:node .testcaferc.json .testcaferc.json
COPY --chown=node:node mocks mocks
COPY --chown=node:node capabilities.json capabilities.json
RUN ["chmod", "+x", "/opt/app/e2e/e2e.sh"]
RUN npm ci

# set user to node
RUN chown node:node $HOME/
USER node

RUN node -v

FROM hub.docker.prod.walmart.com/testcafe/testcafe

ENV BROWSER_URL=https://esp.online.ui.dev.k8s.nonprod.walmart.com/esp
ENV NODEJS_ORG_MIRROR=https://repository.walmart.com/content/repositories/nodejs/
ENV NODE_EXTRA_CA_CERTS=/etc/ssl/cert.pem

COPY --from=install_node_modules /opt/app /opt/app

COPY --from=roots /usr/local/share/ca-certificates /usr/local/share/ca-certificates
COPY --from=roots /etc/ssl/certs/ca-certificates.crt /etc/ssl/certs/ca-certificates.crt

USER root
RUN rm -f /etc/ssl/cert.pem && ln -s /etc/ssl/certs/ca-certificates.crt /etc/ssl/cert.pem

#Non Root User Configuration
RUN addgroup -S -g 10001 appGrp \
  && adduser -S -D -u 10000 -s /sbin/nologin -h /opt/app/ -G appGrp app\
  && chown -R 10000:10001 /opt/app

USER 10000
WORKDIR /opt/app
ENTRYPOINT [ "./e2e/e2e.sh" ]