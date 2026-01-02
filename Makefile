FORGE_GRADLE_VERSION=8.8
FABRIC_GRADLE_VERSION=8.8

all: build-forge build-neoforge
publish: publish-forge publish-neoforge

build-forge: SHELL := /bin/bash
build-forge:
	source "${HOME}/.sdkman/bin/sdkman-init.sh" && \
	sdk use gradle ${FORGE_GRADLE_VERSION} && \
	gradle clean build -Pforge=true && \
	mkdir -p ./dist/forge && \
	cp build/libs/*.jar ./dist/forge/

build-neoforge: SHELL := /bin/bash
build-neoforge:
	source "${HOME}/.sdkman/bin/sdkman-init.sh" && \
	sdk use gradle ${FORGE_GRADLE_VERSION} && \
	gradle clean build -Pneoforge=true && \
	mkdir -p ./dist/neoforge && \
	cp build/libs/*.jar ./dist/neoforge/

publish-forge: SHELL := /bin/bash
publish-forge:
	source "${HOME}/.sdkman/bin/sdkman-init.sh" && \
	sdk use gradle ${FORGE_GRADLE_VERSION} && \
	gradle publish -Pforge=true

publish-neoforge: SHELL := /bin/bash
publish-neoforge:
	source "${HOME}/.sdkman/bin/sdkman-init.sh" && \
	sdk use gradle ${FORGE_GRADLE_VERSION} && \
	gradle publish -Pneoforge=true

prism:
	VERSION=$$(grep 'mod_version=' gradle.properties | cut -d'=' -f2) && \
	cp ./dist/neoforge/scylla-$${VERSION}.jar ${HOME}/.var/app/org.prismlauncher.PrismLauncher/data/PrismLauncher/instances/1.20.1/minecraft/mods/