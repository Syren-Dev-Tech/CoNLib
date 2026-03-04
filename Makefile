publish-%: SHELL := /bin/bash
publish-%:
	gradle --no-daemon clean build -P$*=true && \
	mkdir -p ./dist/$* && \
	cp build/libs/*.jar ./dist/$*/
	gradle --no-daemon publish -P$*=true && \
	gradle --no-daemon publishToMavenLocal -P$*=true

deps: SHELL := /bin/bash
deps:
	source "${HOME}/.sdkman/bin/sdkman-init.sh" && \
	gradle --refresh-dependencies