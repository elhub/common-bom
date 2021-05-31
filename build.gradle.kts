import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
import org.jfrog.gradle.plugin.artifactory.dsl.PublisherConfig

plugins {
    id("java-platform")
    id("com.github.ben-manes.versions") version "0.38.0"
    id("com.jfrog.artifactory") version "4.21.0"
    id("maven-publish") apply true
}

repositories {
    maven("https://jfrog.elhub.cloud/artifactory/elhub-mvn/")
}

val mavenPubName = "mavenBom"

group = "no.elhub.common"
description = "Bill of materials for common platform modules."

dependencies {

    constraints {
        api(Libs.AssertJ.core)
        api(Libs.Commons.lang3)
        api(Libs.Commons.logging)
        api(Libs.Constretto.core)
        api(Libs.Elhub.Common.date)
        api(Libs.Elhub.Common.jeim)
        api(Libs.Elhub.Common.konfig)
        api(Libs.Google.guava)
        api(Libs.Jackson.dataBind)
        api(Libs.Jackson.dataFormatCsv)
        api(Libs.Jackson.dataFormatYaml)
        api(Libs.Jackson.moduleKotlin)
        api(Libs.JollyDay.jollyday)
        api(Libs.Junit.jupiterEngine)
        api(Libs.Junit.jupiterParams)
        api(Libs.KoTest.runner)
        api(Libs.KoTest.assertions)
        api(Libs.KoTest.property)
        api(Libs.KoTest.Extensions.allure)
        api(Libs.KoTest.Extensions.testcontainers)
        api(Libs.Logback.classic)
        api(Libs.Logback.core)
        api(Libs.Oracle.ojdbc8)
        api(Libs.PicoCli.picocli)
        api(Libs.Slf4j.api)
        api(Libs.Slf4j.simple)
    }

}

fun isNonStable(version: String): Boolean {
    val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.toUpperCase().contains(it) }
    val regex = "^[0-9,.v-]+(-r|-jre)?$".toRegex()
    val isStable = stableKeyword || regex.matches(version)
    return isStable.not()
}

tasks.withType<DependencyUpdatesTask> {
    checkConstraints = true
    rejectVersionIf {
        isNonStable(candidate.version)
    }
}

publishing {
    publications {
        create<MavenPublication>(mavenPubName) {
            from(components["javaPlatform"])
        }
    }
}

// No unit tests
tasks.create("test") {
    // Empty test task
}

tasks.withType<Jar> {
    enabled = false
}

tasks.withType<GenerateModuleMetadata> {
    enabled = false
}

artifactory {
    setContextUrl("https://jfrog.elhub.cloud/artifactory")
    publish(delegateClosureOf<PublisherConfig> {
        repository(delegateClosureOf<groovy.lang.GroovyObject> {
            setProperty("repoKey", project.findProperty("mavenrepo") ?: "elhub-mvn-dev-local")
            setProperty("username", project.findProperty("mavenuser") ?: "nouser")
            setProperty("password", project.findProperty("mavenpass") ?: "nopass")
        })
        defaults(delegateClosureOf<groovy.lang.GroovyObject> {
            invokeMethod("publications", mavenPubName)
            setProperty("publishArtifacts", true)
        })
    })
    resolve(delegateClosureOf<org.jfrog.gradle.plugin.artifactory.dsl.ResolverConfig> {
        setProperty("repoKey", "repo")
    })
}

tasks["publish"].dependsOn(tasks["artifactoryPublish"])
