#!/usr/bin/env bash
set -euo pipefail

# publish.sh - bump version in gradle.properties and run ./gradlew publish
# Usage: ./publish.sh [patch|minor|major]

WORKDIR="$(cd "$(dirname "$0")" && pwd)"
PROPS_FILE="$WORKDIR/gradle.properties"

if [[ ! -f "$PROPS_FILE" ]]; then
  echo "gradle.properties not found in $WORKDIR" >&2
  exit 1
fi

BUMP=${1:-}

function read_version() {
  # Read mod_version line
  grep -E '^mod_version=' "$PROPS_FILE" | cut -d'=' -f2-
}

function write_version() {
  local newver="$1"
  # Replace the mod_version line in-place
  sed -i.bak -E "s/^(mod_version)=.*/\1=${newver}/" "$PROPS_FILE"
}

function bump_version() {
  local ver="$1"
  IFS='.' read -r major minor patch <<< "${ver}"
  # Ensure numeric and default values
  major=${major:-0}
  minor=${minor:-0}
  patch=${patch:-0}

  case "$BUMP" in
    patch)
      patch=$((patch + 1))
      ;;
    minor)
      minor=$((minor + 1))
      patch=0
      ;;
    major)
      major=$((major + 1))
      minor=0
      patch=0
      ;;
    '')
      # no bump requested
      echo "$ver"
      return
      ;;
    *)
      echo "Unknown bump type: $BUMP" >&2
      exit 2
      ;;
  esac

  echo "${major}.${minor}.${patch}"
}

current_ver=$(read_version)
if [[ -z "$current_ver" ]]; then
  echo "mod_version not found or empty in $PROPS_FILE" >&2
  exit 1
fi

if [[ -n "$BUMP" ]]; then
  new_ver=$(bump_version "$current_ver")
  if [[ "$new_ver" != "$current_ver" ]]; then
    echo "Bumping version: $current_ver -> $new_ver"
    write_version "$new_ver"
  else
    echo "No version change (bump type not provided)."
  fi
else
  echo "No bump argument provided; using current version: $current_ver"
fi

echo "Running: ./gradlew publish"
cd "$WORKDIR"
./gradlew publish
