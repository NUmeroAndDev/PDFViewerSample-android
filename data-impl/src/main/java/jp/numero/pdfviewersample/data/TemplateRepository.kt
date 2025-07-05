package jp.numero.pdfviewersample.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TemplateRepositoryImpl @Inject constructor(
) : TemplateRepository {

    override suspend fun fetch(): List<String> {
        return emptyList()
    }
}