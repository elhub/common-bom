# common-parent

**common-parent** is the maven BOM (bill of materials) for the common Elhub modules. It helps to harmonize the
versions of libraries used in projects and to hide unnecessary POM elements.

## Getting Started

## Dependency Definitions

### Defining dependencies version numbers

All dependencies version numbers are stored in common-parent as properties. Example:
```xml
<properties>
    <apache.commons-collections4.version>4.1</apache.commons-collections4.version>
    <apache.commons-compress.version>1.14</apache.commons-compress.version>
    <apache.commons-configuration2.version>2.1.1</apache.commons-configuration2.version>
</properties>
```
For easier reference and search, all properties are stored in alphabetical order.
Property naming standard allows for easier searching. It consist of:
```xml
<identifier_from_groupId.artifactId.version>
```

### Dependency management

All dependencies in <dependencyManagement> section of POM.xml are stored in alphabetical order, with the <version> element that is referring to the property in property section. As in example:
```xml
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-collections4</artifactId>
    <version>${apache.commons-collections4.version}</version>
</dependency>
```

### Using common-parent

#### Gradle

Add the bom to your dependencies as follows:
```
dependencies {
    implementation(platform("no.elhub.common:common-parent:0.+"))
}
```

#### Maven

Add common-parent as a parent project to your project in your pom.xml. Example:
```xml
<parent>
    <groupId>no.elhub.common</groupId>
    <artifactId>common-parent</artifactId>
    <version>[0.1.0,1.0.0)</version>
</parent>
```

See [Maven Dependency Management](http://maven.apache.org/guides/introduction/introduction-to-dependency-mechanism.html#Dependency_Management)
