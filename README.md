This repository is DEPRECATED.

# common-bom

## About

**common-bom** is the maven BOM (bill of materials) for the common elhub modules. It helps to harmonize the
versions of libraries used in projects and simplify updates. You will need access to a version of these
bom to build any of our Jvm common modules.

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
    <artifactId>common-bom</artifactId>
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

There are no unit tests for common-bom. In order to check whether the dependencies are up to date, however, you can
always run:
```xml
./gradlew dependencyUpdates
```

## Contributing

Contributing, issues and feature requests are welcome. See the
[Contributing](https://github.com/elhub/common-bom/blob/main/CONTRIBUTING.md) file.

## Owners

This project is developed by [Elhub](https://github.com/elhub). For the specific development group responsible for this
code, see the [Codeowners](https://github.com/elhub/common-bom/blob/main/CODEOWNERS) file.
