package jp.numero.pdfviewersample.feature.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import jp.numero.pdfviewersample.data.TemplateRepository
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: TemplateRepository,
) : ViewModel()