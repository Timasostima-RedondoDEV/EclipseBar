package gui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.darkrockstudios.libraries.mpfilepicker.FilePicker
import structure.Colores
import java.io.File

@Composable
fun Stock() {
    var isOpen by remember { mutableStateOf(false) }
    val changeDialog = { isOpen = !isOpen }

    Surface(color = Colores.color1) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(20.dp)
        ) {
            Column(
                modifier = Modifier
                    .background(Color.White, shape = RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp))
                    .fillMaxWidth()
                    .fillMaxHeight(0.9F)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier.fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Text(text = "Nombre", color = Colores.color4, fontSize = 17.sp)
                    Text(text = "Categoría", color = Colores.color4, fontSize = 17.sp)
                    Text(text = "Stock", color = Colores.color4, fontSize = 17.sp)
                    Text(text = "Precio", color = Colores.color4, fontSize = 17.sp)
                    Spacer(
                        modifier = Modifier.fillMaxWidth(0.2F)
                    )
                }
                LazyColumn {
                    items(100) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .padding(10.dp, 5.dp, 10.dp, 5.dp)
                                .fillMaxWidth()
                                .height(50.dp)
                                .background(Colores.color2, shape = RoundedCornerShape(10.dp))
                        ) {
                            Image(
                                painter = painterResource("prodImgs/Fanta.png"),
                                contentDescription = "Logo producto",
                                modifier = Modifier
                                    .fillMaxWidth(0.05F)
                                    .fillMaxHeight(0.8F)
                            )
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth(0.4F)
                            ) {
                                Text(text = "Fanta")
                                Text(text = "Refrescos")
                                Text(text = "2u")
                                Text(text = "2.20€")
                            }
                            Spacer(
                                modifier = Modifier.width(200.dp)
                            )
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth(0.25F)
                            ) {
                                Button(onClick = {}) {}
                                Button(onClick = {}) {}
                            }
                            Spacer(
                                modifier = Modifier.width(50.dp)
                            )
                        }
                    }
                }
            }

            Button(
                onClick = changeDialog,
                colors = ButtonDefaults.buttonColors(Colores.color4),
                shape = RoundedCornerShape(0.dp, 0.dp, 30.dp, 30.dp),
                elevation = ButtonDefaults.elevation(0.dp, 0.dp, 0.dp, 0.dp, 0.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                Text("Añadir producto", color = Colores.color1)
            }
        }
    }
    if (isOpen) {
        AddProducto(close = changeDialog)
    }
}





@Composable
fun AddProducto(close: () -> Unit) {
    var filePath by remember { mutableStateOf("src/main/resources/prodImgs/Fanta.png") }

    val file = File(filePath)
    val imageBitmap: ImageBitmap = remember(file) {
        loadImageBitmap(file.inputStream())
    }


//    var nombreF by remember { mutableStateOf("prodImgs/Fanta.png") }
    var showFilePicker by remember { mutableStateOf(false) }

    Dialog(onDismissRequest = close) {
        Column(
            modifier = Modifier
                .width(600.dp)
                .height(350.dp)
                .background(Colores.color1)
                .padding(15.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.85F)
            ) {
                Column(
                    verticalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier
                        .fillMaxWidth(0.3F)
                        .fillMaxHeight()
                ) {
                    Image(
//                        painter = painterResource(nombreF),
                        painter = BitmapPainter(image = imageBitmap),
                        contentDescription = "Logo producto",
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .clickable(onClick = { showFilePicker = true })
                            .fillMaxWidth()
                            .fillMaxHeight(0.5F)
                            .background(Color.White)
                    )
                    val tipos = remember { listOf("Refrescos", "Cocteles", "Comida") }
                    var text by remember { mutableStateOf("Refrescos") }
                    val cambiarTipo: (String) -> Unit = { text = it }
                    ComboBox(text, tipos, cambiarTipo)
                    Spacer(modifier = Modifier.height(10.dp))
                }
                Column(
                    verticalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier
                        .fillMaxHeight(0.9F)
                        .padding(start = 40.dp)
                ) {
                    Text("Nombre")
                    Text("Stock")
                    Text("Precio1")
                    Text("Precio2")
                }
                Column(
                    verticalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier
                        .fillMaxHeight(0.9F)
                        .fillMaxWidth(0.7F)
                ) {
                    CustomTextField(
                        "", {},
                        modifier = Modifier
                            .height(50.dp)
                            .fillMaxWidth()
                            .padding(end = 10.dp)
                            .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                    )
                    CustomTextField(
                        "", {},
                        modifier = Modifier
                            .height(50.dp)
                            .fillMaxWidth()
                            .padding(end = 10.dp)
                            .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                    )
                    CustomTextField(
                        "", {},
                        modifier = Modifier
                            .height(50.dp)
                            .fillMaxWidth()
                            .padding(end = 10.dp)
                            .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                    )
                    CustomTextField(
                        "", {},
                        modifier = Modifier
                            .height(50.dp)
                            .fillMaxWidth()
                            .padding(end = 10.dp)
                            .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                    )
                }
            }
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                Boton("Cancelar", funcionLista = close)
                Boton("Añadir", funcionLista = close)
            }
        }
    }

    val fileType = listOf("jpg", "png")
    FilePicker(show = showFilePicker, fileExtensions = fileType) { platformFile ->
        showFilePicker = false
        val nomTemp = platformFile?.path?.split("\\")?.last()
        println(nomTemp)
        File(platformFile?.path ?: "").copyTo(File("src/main/resources/prodImgs/$nomTemp"), true)
        filePath = "src/main/resources/prodImgs/$nomTemp"
//        nombreF = "prodImgs/$nomTemp"
    }
}
