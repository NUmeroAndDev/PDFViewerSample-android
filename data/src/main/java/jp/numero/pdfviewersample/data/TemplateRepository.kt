package jp.numero.pdfviewersample.data

interface TemplateRepository {
    suspend fun fetch(): List<String>
}