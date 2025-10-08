package com.example.testdos.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testdos.ui.theme.extendedColors
import com.example.testdos.R

@Composable
fun CompactSearchBar(
    text: String,
    onTextChange: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp) // altura compacta
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = CircleShape
            ),
        /*.border(
            width = 1.dp,
            color = MaterialTheme.extendedColors.brand,
            shape = CircleShape
        ),*/
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Buscar",
                tint = MaterialTheme.extendedColors.medium,
                modifier = Modifier.size(20.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))

            BasicTextField(
                value = text,
                onValueChange = onTextChange,
                singleLine = true,
                textStyle = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurface
                ),
                // cursorBrush = SolidColor(MaterialTheme.extendedColors.brand),
                modifier = Modifier
                    .fillMaxWidth(),
                    // .height(48.dp),
                decorationBox = { innerTextField ->
                    if (text.isEmpty()) {
                        Text(
                            text = "Buscar producto...",
                            color = Color.Gray,
                            fontSize = 14.sp
                        )
                    }
                    innerTextField()
                }
            )
        }
    }
}




@Composable
fun ProfileScreen() {
    Scaffold(
        bottomBar = {
            Surface(
                tonalElevation = 3.dp,
                shadowElevation = 6.dp,
                color = MaterialTheme.colorScheme.background
            ) {
                HorizontalDivider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.outlineVariant
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    // 🔹 Encabezado con botón alineado a la derecha
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.TopEnd
                    ) {
                        IconButton(
                            onClick = { /* TODO: acción para cerrar */ },
                            modifier = Modifier
                                // .size(28.dp)
                                .background(
                                    color = MaterialTheme.colorScheme.surface,
                                    // color = Color.Transparent,
                                    shape = CircleShape
                                )
                        ) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Cerrar",
                                tint = MaterialTheme.colorScheme.onSurface,
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Total",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = "$2.450",
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Spacer(modifier = Modifier.height(24.dp))

                        Button(
                            onClick = {  /*TODO*/  },
                            /*modifier = Modifier
                                .fillMaxWidth(),*/
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.extendedColors.brand,
                                contentColor = Color.White,
                                // containerColor = MaterialTheme.colorScheme.primary,
                                // contentColor = Color.White
                            ),
                        ) {
                            Text("Finalizar registro",
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
                    }

                    /*Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = {  *//*TODO*//*  },
                        *//*modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),*//*
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.extendedColors.brand,
                            contentColor = Color.White,
                            // containerColor = MaterialTheme.colorScheme.primary,
                            // contentColor = Color.White
                        ),
                    ) {
                        Text("Finalizar registro",
                            // style = MaterialTheme.typography.titleMedium
                        )
                    }*/
                }
            }
        }

    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = innerPadding.calculateStartPadding(LayoutDirection.Ltr),
                    end = innerPadding.calculateEndPadding(LayoutDirection.Ltr),
                    top = 0.dp, // 👈 eliminás el padding superior
                    bottom = innerPadding.calculateBottomPadding()
                )
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            /*verticalArrangement = Arrangement.spacedBy(16.dp),*/
            // verticalArrangement = Arrangement.spacedBy(8.dp),

        ) {
            /*CompactSearchBar("Buscar producto...", onTextChange = {})*/
            // --- Fila con título a la izquierda y botón a la derecha ---
            Column(
                modifier = Modifier.fillMaxWidth(),
                // verticalAlignment = Alignment.CenterVertically,
                // horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CompactSearchBar("Buscar producto...", onTextChange = {})
                /*Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Registra tus movimientos",
                    style = MaterialTheme.typography.titleMedium
                )*/
            }
            // Spacer(modifier = Modifier.height(8.dp))

            // 🔹 ⬇️ ACA VAN LAS PESTAÑAS (Día / Semana / Mes)
            /*val selectedTabIndex = 0
            TabRow(
                selectedTabIndex = selectedTabIndex,
                containerColor = MaterialTheme.colorScheme.background,
                divider = {}, // 👈 elimina el borde gris inferior
                indicator = { tabPositions ->
                    // 👇 Personalizás el indicador para ocupar el ancho completo
                    Box(
                        modifier = Modifier
                            .tabIndicatorOffset(tabPositions[selectedTabIndex])
                            .height(3.dp) // grosor del indicador
                            .background(
                                color = MaterialTheme.extendedColors.brand,
                                // shape = RoundedCornerShape(topStart = 3.dp, topEnd = 3.dp)
                            )
                    )
                }
            ) {
                Tab(
                    selected = selectedTabIndex == 0,
                    onClick = {},
                    text = {
                        Text(
                            "Día",
                            color = if (selectedTabIndex == 0)
                                MaterialTheme.extendedColors.brand
                            else
                                MaterialTheme.colorScheme.onSurface
                        )
                    }
                )
                Tab(
                    selected = selectedTabIndex == 1,
                    onClick = {},
                    text = {
                        Text(
                            "Semana",
                            color = if (selectedTabIndex == 1)
                                MaterialTheme.extendedColors.brand
                            else
                                MaterialTheme.colorScheme.onSurface
                        )
                    }
                )
                Tab(
                    selected = selectedTabIndex == 2,
                    onClick = {},
                    text = {
                        Text(
                            "Mes",
                            color = if (selectedTabIndex == 2)
                                MaterialTheme.extendedColors.brand
                            else
                                MaterialTheme.colorScheme.onSurface
                        )
                    }
                )
            }*/

            Spacer(modifier = Modifier.height(8.dp))

            // 🔹 Acá tus Cards de productos
            // --- Lista de productos ---
            ProductCard("Fideos", "$850", "Stock: 20")
            ProductCard("Arroz", "$780", "Stock: 15")
            ProductCard("Aceite", "$820", "Stock: 8")
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.background, // fondo de la card
                    contentColor = MaterialTheme.colorScheme.onSurface // color del texto e íconos
                ),
                /*border = BorderStroke(
                    width = 0.1.dp,
                    color = MaterialTheme.colorScheme.outlineVariant // o outline, o un color personalizado
                )*/
                // elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Imagen placeholder
                    Box(
                        modifier = Modifier
                            .size(64.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primary),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Warning,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.error
                        )
                    }

                    // Info del producto
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "Aceite",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = "$820",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.extendedColors.medium
                        )
                        Text(
                            text = "2",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.error
                        )
                    }

                    // Botonera cantidad
                    QuantitySelector()
                }
            }
        }
    }
}

@Composable
fun ProductCard(nombre: String, precio: String, stock: String) {
    // Paleta de colores suaves con opacidad
    val backgroundColors = listOf(
        MaterialTheme.extendedColors.success,
        MaterialTheme.colorScheme.tertiary,
        MaterialTheme.colorScheme.secondary,
        MaterialTheme.extendedColors.warning
    )

    // Elegí uno aleatorio (podés cambiar esto por lógica fija si querés)
    val color = remember { backgroundColors.random() }
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background, // fondo de la card
            contentColor = MaterialTheme.colorScheme.onSurface // color del texto e íconos
        ),
        /*border = BorderStroke(
            width = 0.1.dp,
            color = MaterialTheme.colorScheme.outlineVariant // o outline, o un color personalizado
        )*/
        // elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Ícono dentro de un fondo circular de color suave
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .background(color),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }

            // Info del producto
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = nombre,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = precio,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.extendedColors.medium
                    // color = MaterialTheme.extendedColors.brand
                )
                Text(
                    text = stock,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.extendedColors.medium
                )
            }

            // Botonera cantidad
            QuantitySelector()
        }
    }
}

@Composable
fun QuantitySelector() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        CircleButton(
            icon = R.drawable.remove,
            onClick = { /* TODO: restar */ }
        )

        Text(
            text = "1",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurface
        )

        CircleButton(
            icon = R.drawable.add,
            onClick = { /* TODO: sumar */ }
        )
    }
}

@Composable
private fun CircleButton(
    icon: Int,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(36.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.surface)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = LocalIndication.current, // ✅ usa el ripple actual del theme
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.size(20.dp)
        )
    }
}




