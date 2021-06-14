/** Libs Build Source definitions
 *
 * This instance basically defines all of the dependencies that are referenced in the bill of materials. Each
 * is defined using an object (for the group) and various strings for the artifact.
 *
 * To add a new dependency: add objects and strings to Libs as appropriate. It is then possible to
 * reference the dependency directly in build.gradle.kts using the signature, as follows:
 * ```
 *  api(Libs.group.artifact)
 * ```
 */
object Libs {

    /** Defines the versions for the various dependencies in [Libs]
     */
    private object Versions {
        const val assertj = "3.19.0"
        const val common_date = "4.1.0"
        const val common_jeim = "6.1.1"
        const val common_konfig = "0.3.0"
        const val commons_lang3 = "3.12.0"
        const val commons_logging = "1.2"
        const val constretto = "2.2.3"
        const val guava ="30.1.1-jre"
        const val jackson = "2.12.3"
        const val jdbc8 = "12.2.0.1"
        const val jollyday = "0.5.10"
        const val junit = "5.7.2"
        const val koTest = "4.6.0"
        const val koTestExtensions = "1.0.1"
        const val logback = "1.2.3"
        const val picocli = "4.6.1"
        const val slf4j = "1.7.30"
    }

    object AssertJ {
        const val core = "org.assertj:assertj-core:${Versions.assertj}"
    }

    object Commons {
        const val lang3 = "org.apache.commons:commons-lang3:${Versions.commons_lang3}"
        const val logging = "commons-logging:commons-logging:${Versions.commons_logging}"
    }

    object Constretto {
        const val core=  "org.constretto:constretto-core:${Versions.constretto}"
    }

    object Elhub {

        object Common {
            private const val group = "no.elhub.common"
            const val date = "$group:common-date:${Versions.common_date}"
            const val jeim = "$group:common-jeim:${Versions.common_jeim}"
            const val konfig = "$group:common-konfig:${Versions.common_konfig}"
        }

    }

    object Google {
        const val guava = "com.google.guava:guava:${Versions.guava}"
    }

    object Jackson {
        private const val group = "com.fasterxml.jackson"
        const val dataBind = "$group.core:jackson-databind:${Versions.jackson}"
        const val dataFormatCsv = "$group.dataformat:jackson-dataformat-csv:${Versions.jackson}"
        const val dataFormatYaml = "$group.dataformat:jackson-dataformat-yaml:${Versions.jackson}"
        const val moduleKotlin = "$group.module:jackson-module-kotlin:${Versions.jackson}"
    }

    object JollyDay {
        const val jollyday = "de.jollyday:jollyday:${Versions.jollyday}"
    }

    object Junit {
        private const val group = "org.junit.jupiter"
        const val jupiterEngine = "$group:junit-jupiter-engine:${Versions.junit}"
        const val jupiterParams = "$group:junit-jupiter-params:${Versions.junit}"
    }

    object KoTest {
        private const val group = "io.kotest"
        const val runner = "$group:kotest-runner-junit5:${Versions.koTest}"
        const val assertions = "$group:kotest-assertions-core:${Versions.koTest}"
        const val property = "$group:kotest-property:${Versions.koTest}"

        object Extensions {
            const val allure = "$group.extensions:kotest-extensions-allure:${Versions.koTestExtensions}"
            const val testcontainers = "$group.extensions:kotest-extensions-testcontainers:${Versions.koTestExtensions}" // Version differs from the rest
        }
    }

    object Logback {
        private const val group = "ch.qos.logback"
        const val classic = "$group:logback-classic:${Versions.logback}"
        const val core = "$group:logback-classic:${Versions.logback}"
    }

    object Oracle {
        const val ojdbc8 = "com.oracle.jdbc:ojdbc8:${Versions.jdbc8}"
    }

    object PicoCli {
        const val picocli = "info.picocli:picocli:${Versions.picocli}"
    }

    object Slf4j {
        private const val group = "org.slf4j"
        const val api = "$group:slf4j-api:${Versions.slf4j}"
        const val simple = "$group:slf4j-simple:${Versions.slf4j}"
    }

}
