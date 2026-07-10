publish: publish-neoforge

publish-%: SHELL := /bin/bash
publish-%:
	gradle --no-daemon clean build -P$*=true && \
	mkdir -p ./dist/$* && \
	cp build/libs/*.jar ./dist/$*/
	gradle --no-daemon publish -P$*=true && \
	gradle --no-daemon publishToMavenLocal -P$*=true

TAG_REMOTE ?= origin

deps: SHELL := /bin/bash
deps:
	source "${HOME}/.sdkman/bin/sdkman-init.sh" && \
	gradle --refresh-dependencies

release: SHELL := /bin/bash
release:
	@set -euo pipefail; \
	version="$$(grep -E '^[[:space:]]*mod_version[[:space:]]*=' gradle.properties | head -n1 | cut -d= -f2- | tr -d '[:space:]')"; \
	if [[ -z "$$version" ]]; then \
		echo "Error: mod_version not found in gradle.properties" >&2; \
		exit 1; \
	fi; \
	tag="v$$version"; \
	if git rev-parse "$$tag" >/dev/null 2>&1; then \
		echo "Error: tag '$$tag' already exists" >&2; \
		exit 1; \
	fi; \
	git tag "$$tag"; \
	echo "Created git tag: $$tag"

push-release-tag: SHELL := /bin/bash
push-release-tag:
	@set -euo pipefail; \
	version="$$(grep -E '^[[:space:]]*mod_version[[:space:]]*=' gradle.properties | head -n1 | cut -d= -f2- | tr -d '[:space:]')"; \
	if [[ -z "$$version" ]]; then \
		echo "Error: mod_version not found in gradle.properties" >&2; \
		exit 1; \
	fi; \
	tag="v$$version"; \
	git fetch --tags "$(TAG_REMOTE)"; \
	if [[ -n "$$(git ls-remote --tags "$(TAG_REMOTE)" "refs/tags/$$tag")" ]]; then \
		echo "Error: tag '$$tag' already exists on remote '$(TAG_REMOTE)'" >&2; \
		exit 1; \
	fi; \
	if ! git rev-parse "$$tag" >/dev/null 2>&1; then \
		echo "Error: local tag '$$tag' does not exist. Run 'make release' first." >&2; \
		exit 1; \
	fi; \
	git push "$(TAG_REMOTE)" "$$tag"; \
	echo "Pushed git tag: $$tag to $(TAG_REMOTE)"
