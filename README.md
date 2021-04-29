# common-bom

<!-- PROJECT SHIELDS -->
![TeamCity Build](https://teamcity.elhub.cloud/app/rest/builds/buildType:(id:Common_CommonBomAutoRelease_AutoRelease)/statusIcon)
[![Quality Gate Status](https://sonar.elhub.cloud/api/project_badges/measure?project=no.elhub.common%3Acommon-bom&metric=alert_status)](https://sonar.elhub.cloud/dashboard?id=no.elhub.common%3Acommon-bom)
[![Lines of Code](https://sonar.elhub.cloud/api/project_badges/measure?project=no.elhub.common%3Acommon-bom&metric=ncloc)](https://sonar.elhub.cloud/dashboard?id=no.elhub.common%3Acommon-bom)

[![Vulnerabilities](https://sonar.elhub.cloud/api/project_badges/measure?project=no.elhub.common%3Acommon-bom&metric=vulnerabilities)](https://sonar.elhub.cloud/dashboard?id=no.elhub.common%3Acommon-bom)
[![Bugs](https://sonar.elhub.cloud/api/project_badges/measure?project=no.elhub.common%3Acommon-bom&metric=bugs)](https://sonar.elhub.cloud/dashboard?id=no.elhub.common%3Acommon-bom)
[![Code Smells](https://sonar.elhub.cloud/api/project_badges/measure?project=no.elhub.common%3Acommon-bom&metric=code_smells)](https://sonar.elhub.cloud/dashboard?id=no.elhub.common%3Acommon-bom)

## Table of Contents

* [About](#about)
* [Getting Started](#getting-started)
    * [Prerequisites](#prerequisites)
    * [Installation](#installation)
* [Usage](#usage)
* [Testing](#testing)
* [Roadmap](#roadmap)
* [Contributing](#contributing)
* [Owners](#owners)
* [License](#license)


## About

**common-bom** is the maven BOM (bill of materials) for the common elhub modules. It helps to harmonize the
versions of libraries used in projects, and simplify updates.

## Getting Started

### Prerequisites

None.

### Installation

#### Gradle

Add the bom to your dependencies as follows:
```
dependencies {
    implementation(platform("no.elhub.common:common-bom:1.2.3"))
}
```

#### Maven

Add common-parent as a parent project or a bom to your project in your pom.xml. Example:
```xml
<parent>
    <groupId>no.elhub.common</groupId>
    <artifactId>common-parent</artifactId>
    <version>1.2.3</version>
</parent>
```

See [Maven Dependency Management](http://maven.apache.org/guides/introduction/introduction-to-dependency-mechanism.html#Dependency_Management)


## Usage

All dependencies version numbers are stored in const vals in the buildSrc class Libs.Versions. For easier reference
and search, all properties are stored in alphabetical order. The dependencies themselves are defined in the build.gradle.kts
of the project, and refer to the class definitions in Libs.

To use the dependencies, simply add the dependencies into your maven or gradle project as normal, but omit the version numbers.


## Testing

There are no unit tests for common-bom. In order to check whether the dependencies are up to date, however, you can always run:
```xml
./gradlew dependencyUpdates
```

## Roadmap

See the
[open issues](https://jira.elhub.cloud/issues/?jql=project%20%3D%20TD%20AND%20component%20%3D%20common-bom%20AND%20resolution%20%3D%20Unresolved)
for a list of proposed features (and known issues).

## Contributing

Contributing, issues and feature requests are welcome. See the
[Contributing](https://code.elhub.cloud/projects/COM/repos/common-bom/browse/CONTRIBUTING.md) file.

## Owners

This project is developed by [Elhub](https://github.com/elhub). For the specific development group responsible for this
code, see the [Codeowners](https://code.elhub.cloud/projects/COM/repos/common-bom/browse/CODEOWNERS) file.

## License

This project is proprietary.
