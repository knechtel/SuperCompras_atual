package com.app.supercompras


import androidx.compose.foundation.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.supercompras.ui.theme.SuperComprasTheme
import java.util.IllegalFormatConversionException
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.vector.ImageVector

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperComprasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                  //  ImagemTopo(modifier = Modifier.padding(innerPadding))
                    //Titulo(modifier = Modifier.padding(innerPadding))
                    Icone(
                        modifier = Modifier.padding(innerPadding),
                        icone = Icons.Default.Delete
                    )
                }
            }
        }
    }
}



@Composable
fun Titulo(modifier: Modifier = Modifier) {
    Text(
        text = "Lista de Compras",
        modifier = modifier
    )
}



@Composable
fun ImagemTopo(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.image_topo),
        contentDescription = null,
        modifier =  modifier.size(160.dp)
    )
}

@Composable
fun Icone(icone: ImageVector, modifier: Modifier = Modifier) {
    Icon(icone, contentDescription = "Editar", modifier = modifier)
}

@Preview
@Composable
private fun IconePreview() {
    // Renamed preview function to IconePreview to prevent recursive call to itself
    SuperComprasTheme {
        Icone(
            icone = Icons.Default.Delete
        )
    }

}

@Preview
@Composable
private fun ImagemTopoPreview() {
    SuperComprasTheme {
        ImagemTopo()
    }
}

