package jp.numero.pdfviewersample.feature.home

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.fragment.compose.AndroidFragment
import androidx.fragment.compose.rememberFragmentState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.pdf.viewer.fragment.PdfViewerFragment

@Composable
fun Home(
    viewModel: HomeViewModel = hiltViewModel()
) {
    Home(
        modifier = Modifier.fillMaxSize()
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Home(
    modifier: Modifier = Modifier,
) {
    var uri by rememberSaveable { mutableStateOf<Uri?>(null) }
    var fragment by remember { mutableStateOf<PdfViewerFragment?>(null) }
    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.OpenDocument()
    ) {
        if (it != null) {
            fragment?.documentUri = it
            uri = it
        }
    }
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text(text = "PDF Viewer") },
                actions = {
                    if (fragment != null) {
                        IconButton(
                            onClick = {
                                fragment?.isTextSearchActive = true
                            }
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_search),
                                contentDescription = "Find",
                            )
                        }
                        Box {
                            var expanded by rememberSaveable { mutableStateOf(false) }
                            IconButton(onClick = { expanded = true }) {
                                Icon(
                                    painter = painterResource(R.drawable.ic_more),
                                    contentDescription = "More options",
                                )
                            }
                            DropdownMenu(
                                expanded = expanded,
                                onDismissRequest = {
                                    expanded = false
                                }
                            ) {
                                DropdownMenuItem(
                                    text = {
                                        Text("Open other file")
                                    },
                                    onClick = {
                                        expanded = false
                                        launcher.launch(arrayOf("application/pdf"))
                                    }
                                )
                            }
                        }
                    }
                }
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            if (uri == null) {
                Button(
                    onClick = {
                        launcher.launch(arrayOf("application/pdf"))
                    },
                    modifier = Modifier.align(Alignment.Center)
                ) {
                    Text("Select PDF file")
                }
            } else {
                val fragmentState = rememberFragmentState()
                AndroidFragment<PdfViewerFragment>(
                    fragmentState = fragmentState,
                    modifier = Modifier.fillMaxSize(),
                    onUpdate = {
                        fragment = it
                        it.documentUri = uri
                    }
                )
            }
        }
    }
}