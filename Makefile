FORGE_GRADLE_VERSION=8.8
FABRIC_GRADLE_VERSION=8.8

all: build publish-local

build: build-forge build-neoforge
publish: publish-forge publish-neoforge
publish-local: publish-forge-local publish-neoforge-local

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

publish-forge-local: SHELL := /bin/bash
publish-forge-local:
	source "${HOME}/.sdkman/bin/sdkman-init.sh" && \
	sdk use gradle ${FORGE_GRADLE_VERSION} && \
	gradle publishToMavenLocal -Pforge=true

publish-neoforge-local: SHELL := /bin/bash
publish-neoforge-local:
	source "${HOME}/.sdkman/bin/sdkman-init.sh" && \
	sdk use gradle ${FORGE_GRADLE_VERSION} && \
	gradle publishToMavenLocal -Pneoforge=true

deps: SHELL := /bin/bash
deps:
	source "${HOME}/.sdkman/bin/sdkman-init.sh" && \
	gradle --refresh-dependencies