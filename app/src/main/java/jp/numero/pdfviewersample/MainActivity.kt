package jp.numero.pdfviewersample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.fragment.app.FragmentActivity
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import jp.numero.pdfviewersample.ui.theme.TemplateAppTheme

@AndroidEntryPoint
class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            TemplateAppTheme {
                Surface(
                    color = androidx.compose.ui.graphics.Color.Black
                ) {
                    TemplateAppNavigation(
                        navController = navController,
                    )
                }
            }
        }
    }
}