# Testing Infrastructure in Java

This repository is set up for testing with _JUnit_ and test coverage with _Jacoco_, both automated through _Maven_.

You will likely want to explore IDE integration for test execution and coverage in your IDE, but also ensure that tests still execute with Maven in a Continuous Integration environment (e.g. github actions).

The following commands might be useful:
* `mvn clean` reset the build
* `mvn test` execute tests and write a test coverage report in `target/site/jacoco/index.html`
* `mvn site` build and test the project and write results in `target/site/index.html` (includes coverage and test results)

See the comments in `pom.xml` for technical details of this setup.

## Notes
#### Structural testing
Pros:
- Automated process (little manual intervention, saves time)
- Removes redundant code or statements easly
Cons:
- May unintentionally miss some commands, statements, or branches
- Tests are based on the implementation of the code

#### Specification testing
Pros:
- Covers more functionality than most other types of testing
- Can help identify errors missed by other types of testing
- Easily reusable
Cons:
- Time-consuming
- Can be difficult to create test cases that cover all requirements