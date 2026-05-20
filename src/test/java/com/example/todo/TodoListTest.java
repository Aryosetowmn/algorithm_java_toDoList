name: security

on:
  push:
    branches: ["main", "master"]
  pull_request:
  schedule:
    - cron: '0 3 * * 1'

permissions:
  actions: read
  contents: read
  security-events: write

jobs:
  codeql:
    runs-on: ubuntu-latest
    steps:
      - name: Checkout
        uses: actions/checkout@v4

      - name: Set up JDK 17
        uses: actions/setup-java@v4
        with:
          distribution: temurin
          java-version: '17'
          cache: maven

      - name: Initialize CodeQL
        uses: github/codeql-action/init@v3
        with:
          languages: java-kotlin

      - name: Build with Maven
        run: mvn -B -DskipTests compile

      - name: Perform CodeQL Analysis
        uses: github/codeql-action/analyze@v3
