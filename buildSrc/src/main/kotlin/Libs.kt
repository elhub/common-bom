object Libs {

    private object Versions {
        const val assertj = "3.19.0"
        const val common_date = "4.1.0"
        const val common_jeim = "5.1.0"
        const val common_konfig = "0.1.0"
        const val commons_lang3 = "3.12.0"
        const val commons_logging = "1.2"
        const val constretto = "2.2.3"
        const val guava ="30.1.1-jre"
        const val jackson = "2.12.3"
        const val jdbc8 = "12.2.0.1"
        const val jollyday = "0.5.10"
        const val junit = "5.7.1"
        const val koTest = "4.4.3"
        const val logback = "1.2.3"
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
            const val date = "no.elhub.common:common-date:${Versions.common_date}"
            const val jeim = "no.elhub.common:common-jeim:${Versions.common_jeim}"
            const val konfig = "no.elhub.common:common-konfig:${Versions.common_konfig}"
        }

    }

    object Google {
        const val guava = "com.google.guava:guava:${Versions.guava}"
    }

    object Jackson {
        const val dataBind = "com.fasterxml.jackson.core:jackson-databind:${Versions.jackson}"
        const val dataFormatCsv = "com.fasterxml.jackson.dataformat:jackson-dataformat-csv:${Versions.jackson}"
        const val dataFormatYaml = "com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:${Versions.jackson}"
        const val moduleKotlin = "com.fasterxml.jackson.module:jackson-module-kotlin:${Versions.jackson}"
    }

    object JollyDay {
        const val jollyday = "de.jollyday:jollyday:${Versions.jollyday}"
    }

    object Junit {
        const val jupiterEngine = "org.junit.jupiter:junit-jupiter-engine:${Versions.junit}"
        const val jupiterParams = "org.junit.jupiter:junit-jupiter-params:${Versions.junit}"
    }

    object KoTest {
        const val runner = "io.kotest:kotest-runner-junit5:${Versions.koTest}"
        const val allure = "io.kotest:kotest-extensions-allure-jvm:${Versions.koTest}"
    }

    object Logback {
        const val classic = "ch.qos.logback:logback-classic:${Versions.logback}"
        const val core = "ch.qos.logback:logback-classic:${Versions.logback}"
    }

    object Oracle {
        const val ojdbc8 = "com.oracle.jdbc:ojdbc8:${Versions.jdbc8}"
    }

    object Slf4j {
        const val api = "org.slf4j:slf4j-api:${Versions.slf4j}"
        const val simple = "org.slf4j:slf4j-simple:${Versions.slf4j}"
    }

}
