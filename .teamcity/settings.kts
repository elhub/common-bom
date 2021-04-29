import jetbrains.buildServer.configs.kotlin.v2019_2.DslContext
import jetbrains.buildServer.configs.kotlin.v2019_2.buildFeatures.SshAgent
import jetbrains.buildServer.configs.kotlin.v2019_2.project
import jetbrains.buildServer.configs.kotlin.v2019_2.sequential
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.VcsTrigger
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs
import jetbrains.buildServer.configs.kotlin.v2019_2.version
import no.elhub.common.build.configuration.AutoRelease
import no.elhub.common.build.configuration.CodeReview
import no.elhub.common.build.configuration.ProjectType
import no.elhub.common.build.configuration.SonarScan

version = "2020.2"

project {

    val projectId = "no.elhub.common:common-bom"

    params {
        param("teamcity.ui.settings.readOnly", "true")
    }

    val buildChain = sequential {

        buildType(
            SonarScan(
                SonarScan.Config(
                    vcsRoot = DslContext.settingsRoot,
                    type = ProjectType.GRADLE,
                    sonarId = projectId,
                    sonarProjectSources = "."
                )
            )
        )

        buildType(
            AutoRelease(
                AutoRelease.Config(
                    vcsRoot = DslContext.settingsRoot,
                    type = ProjectType.GRADLE
                )
            ) {
                triggers {
                    vcs {
                        branchFilter = "+:<default>"
                        quietPeriodMode = VcsTrigger.QuietPeriodMode.USE_DEFAULT
                    }
                }
            }
        )

    }

    buildChain.buildTypes().forEach { buildType(it) }

    buildType(
        CodeReview(
            CodeReview.Config(
                vcsRoot = DslContext.settingsRoot,
                type = ProjectType.GRADLE,
                sonarId = projectId,
                sonarProjectSources = "."
            )
        )
    )

}
