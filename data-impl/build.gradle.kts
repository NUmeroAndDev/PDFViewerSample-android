plugins {
    id("buildlogic.primitive.androidlibrary")
    id("buildlogic.primitive.kotlin")
    id("buildlogic.primitive.hilt")
}

android {
    namespace = "jp.numero.pdfviewersample.data"
}

dependencies {
    implementation(projects.data)
}