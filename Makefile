FORGE_GRADLE_VERSION=8.8
FABRIC_GRADLE_VERSION=8.8

all: build

build: build-fabric build-forge
clean: clean-fabric clean-forge

clean-fabric: SHELL := /bin/bash
clean-fabric:
	source "${HOME}/.sdkman/bin/sdkman-init.sh" && \
	sdk use gradle ${FABRIC_GRADLE_VERSION} && \
	sdk use java 17.0.17-tem && \
	gradle --refresh-dependencies clean

clean-forge: SHELL := /bin/bash
clean-forge:
	source "${HOME}/.sdkman/bin/sdkman-init.sh" && \
	sdk use gradle ${FORGE_GRADLE_VERSION} && \
	cd forge && \
	gradle --refresh-dependencies clean

build-fabric: SHELL := /bin/bash
build-fabric:
	source "${HOME}/.sdkman/bin/sdkman-init.sh" && \
	sdk use gradle ${FABRIC_GRADLE_VERSION} && \
	sdk use java 17.0.17-tem && \
	gradle clean build -Pfabric=true

build-forge: SHELL := /bin/bash
build-forge:
	source "${HOME}/.sdkman/bin/sdkman-init.sh" && \
	sdk use gradle ${FORGE_GRADLE_VERSION} && \
	cd forge && \
	gradle clean build -Pforge=true