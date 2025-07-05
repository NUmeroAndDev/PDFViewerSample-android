plugins {
    id("buildlogic.conventions.featuremodule")
}

android {
    namespace = "jp.numero.pdfviewersample.feature.home"
}

dependencies {
    implementation(libs.androidxPdfViewerFragment)
    implementation(libs.androidxFragmentCompose)
}