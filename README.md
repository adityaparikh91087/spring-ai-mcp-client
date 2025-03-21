# Spring AI MCP Client

## Code Quality and Coverage

### JaCoCo Code Coverage
The project uses JaCoCo for code coverage analysis. Coverage reports are automatically generated during the test phase.

To generate coverage reports:
```bash
mvn clean test
```

The JaCoCo report will be available at: `target/site/jacoco/index.html`

### Sonar Analysis
The project is configured to use SonarCloud for code quality analysis.

To run Sonar analysis:
```bash
# Make sure you have SONAR_TOKEN environment variable set
mvn clean verify sonar:sonar
```

The analysis results will be available on SonarCloud: https://sonarcloud.io

### Quality Gates
- Minimum code coverage: 50%
- Coverage reports are automatically integrated with Sonar analysis
- Coverage data is collected during test execution

### Notes
- Make sure to set up SONAR_TOKEN environment variable before running Sonar analysis
- The project is configured to use SonarCloud by default
- Coverage reports are generated in XML format for Sonar integration# spring-ai-mcp-client
