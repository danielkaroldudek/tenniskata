## Tennis Kata written in Java with tests in Spock and build with Gradle

[![CircleCI](https://circleci.com/gh/danielkaroldudek/tenniskata.svg?style=shield)](https://circleci.com/gh/danielkaroldudek/tenniskata)
[![Coverage Status](https://coveralls.io/repos/github/danielkaroldudek/tenniskata/badge.svg?branch=master)](https://coveralls.io/github/danielkaroldudek/tenniskata?branch=master)

### Tennis Kata
This is the solution of Tennis Kata written during [Tydzień z TDD - dzień 4 - Tennis Kata](https://www.youtube.com/watch?v=6nWa20pFSmg).

### Components
* Java 11
* Groove 2.5.11 (for compatibility with spock reports)
* Spock 1.3 (for compatibility with spock reports)
* Spock Reports 1.7.1 (the last version which is supporting Groovy 2.5 - next version will be based on Groovy 3.0)
* Slf4j (needed by Spock Reports)
* Jacoco (code coverage)
* CircleCI configuration (CircleCI is a build server)
* Coveralls Gradle plugin (stores code coverage results)

### Run
#### Execute test cases
* gradle cleanTest test
#### Execute test cases with Jacoco code coverage
* gradle cleanTest test jacocoTestReport
