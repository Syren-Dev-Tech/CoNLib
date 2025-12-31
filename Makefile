FORGE_GRADLE_VERSION=8.8
FABRIC_GRADLE_VERSION=8.8

all: build-forge build-neoforge

build-forge: SHELL := /bin/bash
build-forge:
	source "${HOME}/.sdkman/bin/sdkman-init.sh" && \
	sdk use gradle ${FORGE_GRADLE_VERSION} && \
	sdk use java 17.0.17-tem && \
	gradle clean build -Pforge=true

build-neoforge: SHELL := /bin/bash
build-neoforge:
	source "${HOME}/.sdkman/bin/sdkman-init.sh" && \
	sdk use gradle ${FORGE_GRADLE_VERSION} && \
	sdk use java 17.0.17-tem && \
	gradle clean build -Pneoforge=true