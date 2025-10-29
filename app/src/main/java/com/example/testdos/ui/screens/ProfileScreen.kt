package com.example.testdos.ui.screens

import androidx.annotation.DrawableRes
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testdos.ui.theme.extendedColors
import com.example.testdos.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Offset


@Composable
fun CardAdornment(@DrawableRes drawable: Int, size: Dp = 48.dp) {
    Image(
        painter = painterResource(id = drawable),
        contentDescription = null,
        modifier = Modifier.size(size)
    )
}
@Composable
fun CompactSearchBar(
    text: String,
    onTextChange: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(44.dp) // altura compacta
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
                    fontSize = 16.sp,
                    color = MaterialTheme.extendedColors.medium
                ),
                // cursorBrush = SolidColor(MaterialTheme.extendedColors.brand),
                modifier = Modifier
                    .fillMaxWidth(),
                    // .height(48.dp),
                decorationBox = { innerTextField ->
                    if (text.isEmpty()) {
                        Text(
                            text = "Buscar",
                            /*color = MaterialTheme.extendedColors.medium,
                            style = MaterialTheme.typography.bodyMedium*/
                            // fontSize = MaterialTheme.typography.bodyMedium
                            // fontSize = 14.sp
                        )
                    }
                    innerTextField()
                }
            )
        }
    }
}

@Composable
fun BottomActionsBar(
    onVerResumen: () -> Unit,
    onCancelar: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)

    ) {

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = onVerResumen,
            enabled = true,
            modifier = Modifier
                .fillMaxWidth(),
               // .height(48.dp),
            contentPadding = PaddingValues(
                vertical = 15.dp     // Ajusta este valor para controlar la altura
            )

        ) {
            Text(
                text = "Continuar",
                fontWeight = FontWeight.Medium,
                style = MaterialTheme.typography.bodyLarge
                // style = MaterialTheme.typography.titleLarge.copy(fontSize = 16.sp)
            )
        }
    }
}



@Composable
fun ProfileScreen() {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val tabs = listOf("Nueva", "Ver todas")
    Scaffold(
        bottomBar = {
            BottomActionsBar(onVerResumen = {}, onCancelar = {})
        }

    ) { innerPadding ->
        // 🎨 Gradiente suave entre background y surface
        val gradientBackground = Brush.radialGradient(
            colors = listOf(
                MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f),
                MaterialTheme.colorScheme.background
            ),
            center = Offset.Zero, // Centro arriba a la izquierda
            radius = 1000f
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                // .background(gradientBackground) // 👈 aplicado acá
                .padding(
                    start = innerPadding.calculateStartPadding(LayoutDirection.Ltr),
                    end = innerPadding.calculateEndPadding(LayoutDirection.Ltr),
                    top = 24.dp, // 👈 eliminás el padding superior
                    // bottom = innerPadding.calculateBottomPadding()
                )
                .verticalScroll(rememberScrollState()),
                // .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            /*verticalArrangement = Arrangement.spacedBy(16.dp),*/
            // verticalArrangement = Arrangement.spacedBy(8.dp),

        ) {
            // ✅ Tabs arriba
            /*ScrollableTabRow(
                selectedTabIndex = selectedTabIndex,
                edgePadding = 0.dp, // saca el padding innecesario del borde
                containerColor = MaterialTheme.colorScheme.background,
                contentColor = MaterialTheme.extendedColors.brand,
                indicator = { tabPositions ->
                    TabRowDefaults.PrimaryIndicator(
                        modifier = Modifier
                            .tabIndicatorOffset(tabPositions[selectedTabIndex]),
                        color = MaterialTheme.extendedColors.brand
                    )
                },
                divider = {} // quita la línea de abajo
            ) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index },
                        selectedContentColor = MaterialTheme.extendedColors.brand,
                        unselectedContentColor = MaterialTheme.extendedColors.medium,
                        text = {
                            Text(
                                text = title,
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    *//*fontWeight = if (selectedTabIndex == index) FontWeight.Medium else FontWeight.Normal,*//*
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 16.sp
                                )
                            )
                        }
                    )
                }
            }*/

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                text = "Registrar ventas",
                // textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
            )


            Column(
                modifier = Modifier.fillMaxWidth(),
                // verticalArrangement = Arrangement.spacedBy(8.dp),
                // horizontalArrangement = Arrangement.SpaceBetween
            ) {

                ProductCard("Teclado mecánico", "$98050", "11 Sep 2025, 10:42", iconRes = 7, icon = R.drawable.closed_box, estado = EstadoProducto.DISPONIBLE)

                ProductCard("Pads", "$12780", "03 Jun 2025, 22:33", iconRes = 6, icon = R.drawable.inventory, estado = EstadoProducto.BAJO_STOCK)

                ProductCard("Joysticks", "$76820", "15 Ene 2025, 12:10", iconRes = 3,  icon = R.drawable.cash_register, estado = EstadoProducto.DISPONIBLE )

                ProductCard("Joysticks", "$76820", "15 Ene 2025, 12:10", iconRes =  0, icon = R.drawable.mascota_dos, estado = EstadoProducto.NUEVO_INGRESO)

                ProductCard("Teclado mecánico", "$98050", "11 Sep 2025, 10:42", iconRes = 5,  icon = R.drawable.closed_box, estado = EstadoProducto.SIN_MOVIMIENTO)

                ProductCard("Pads", "$12780", "03 Jun 2025, 22:33", iconRes = 6, icon = R.drawable.inventory, estado = EstadoProducto.BAJO_STOCK)

                ProductCard("Joysticks", "$76820", "15 Ene 2025, 12:10", iconRes =  0, icon = R.drawable.hand_coins, estado = EstadoProducto.NUEVO_INGRESO)
                /*HorizontalDivider(
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.surface

                )
                ProductCard("Teclado mecánico", "$98050", "11 Sep 2025, 10:42", iconRes = 7, icon = R.drawable.closed_box, estado = EstadoProducto.DISPONIBLE)
                HorizontalDivider(
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.surface

                )
                ProductCard("Pads", "$12780", "03 Jun 2025, 22:33", iconRes = 6, icon = R.drawable.inventory, estado = EstadoProducto.BAJO_STOCK)
                HorizontalDivider(
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.surface

                )
                ProductCard("Joysticks", "$76820", "15 Ene 2025, 12:10", iconRes = 3,  icon = R.drawable.resource_package, estado = EstadoProducto.DISPONIBLE )
                HorizontalDivider(
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.surface

                )
                ProductCard("Joysticks", "$76820", "15 Ene 2025, 12:10", iconRes =  0, icon = R.drawable.closed_box_2, estado = EstadoProducto.NUEVO_INGRESO)
                HorizontalDivider(
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.surface

                )
                ProductCard("Teclado mecánico", "$98050", "11 Sep 2025, 10:42", iconRes = 5,  icon = R.drawable.closed_box, estado = EstadoProducto.SIN_MOVIMIENTO)
                HorizontalDivider(
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.surface

                )
                ProductCard("Pads", "$12780", "03 Jun 2025, 22:33", iconRes = 6, icon = R.drawable.inventory, estado = EstadoProducto.BAJO_STOCK)
                HorizontalDivider(
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.surface

                )
                ProductCard("Joysticks", "$76820", "15 Ene 2025, 12:10", iconRes =  0, icon = R.drawable.closed_box_2, estado = EstadoProducto.NUEVO_INGRESO)
                HorizontalDivider(
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.surface

                )*/

            }
        }
    }
}

/*@Composable
fun AvatarTonal(
    @DrawableRes iconRes: Int,
    colorIndex: Int = 0, // para cambiar color según posición
    modifier: Modifier = Modifier
) {

    val colors = listOf(
        Color(0xFFEF7A8A),
        Color(0xFFE7A4EF),
        Color(0xFF7AE6EC),
        Color(0xFFEFDE7D),
        Color(0xFFEE9ED7),
        Color(0xFFffd1ff),
        Color(0xFFEFC6BA),
        Color(0xFFC7A7EC),
        Color(0xFFEFB7A7),
        Color(0xFFD4AFEA),
        Color(0xFFA7EADE),
        Color(0xFFE3B3E8),
        Color(0xFFD2E1AD)
    )

    val backgroundColor = colors[colorIndex % colors.size]

    // ✅ Tomamos los colores del tema Material 3
    val surface = MaterialTheme.colorScheme.surface
    val surfaceVariant = MaterialTheme.colorScheme.surfaceVariant
    Surface(
        modifier = modifier.size(48.dp),
        shape = CircleShape,

        // shape = RoundedCornerShape(8.dp),
        // color = backgroundColor.copy(alpha = 0.12f), // ✅ efecto tonal como FilledTonalButton
        // color = MaterialTheme.colorScheme.background,
        color = MaterialTheme.colorScheme.surfaceVariant,
        shadowElevation = 0.dp, // no sombra extra
        tonalElevation = 4.dp // ✅ aplica el overlay tonal
       *//* shadowElevation = 0.dp,
        tonalElevation = 0.dp, // ✅ lo desactivamos porque vamos a usar un gradiente propio
        color = Color.Transparent*//* // 👈 IMPORTANTE para que no tape el gradiente
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                *//*.background(
                    brush = Brush.linearGradient( // ✅ Acá se define el degradado
                        listOf(surface, surfaceVariant)
                    ),
                    shape = CircleShape
                )*//*
                *//*.border(
                width = 2.dp,
                    color = MaterialTheme.colorScheme.surfaceVariant,
                // color = backgroundColor,
                    shape = CircleShape
                // shape = RoundedCornerShape(8.dp)

            )*//*
        ) {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                // tint = backgroundColor, // tono sólido
                tint = MaterialTheme.extendedColors.medium,
                modifier = Modifier.size(22.dp)
            )
        }
    }
}*/

@Composable
fun AvatarTonal(
    @DrawableRes iconRes: Int,
    colorIndex: Int = 0,
    estado: EstadoProducto,
    modifier: Modifier = Modifier
) {
    // Elegir ícono según el estado
    val iconToUse = when (estado) {
        EstadoProducto.BAJO_STOCK -> R.drawable.warning_fill
        EstadoProducto.SIN_MOVIMIENTO -> R.drawable.timer_fill
        else -> iconRes
    }

    // Elegir color del icono según el estado
    val iconTint = when (estado) {
        EstadoProducto.BAJO_STOCK -> MaterialTheme.extendedColors.warning
        EstadoProducto.SIN_MOVIMIENTO -> Color(0xFF6477b0) // azul suave
        else -> MaterialTheme.extendedColors.medium
    }

    // Elegir color de fondo según el estado
    val backgroundColor = when (estado) {
        EstadoProducto.BAJO_STOCK -> MaterialTheme.extendedColors.warning.copy(alpha = 0.12f)
        EstadoProducto.SIN_MOVIMIENTO -> Color(0xFF6477b0).copy(alpha = 0.12f) // azul suave con transparencia
        else -> MaterialTheme.colorScheme.surfaceVariant
    }
    /*val backgroundColor = when (estado) {
        EstadoProducto.BAJO_STOCK -> MaterialTheme.colorScheme.surface
        EstadoProducto.SIN_MOVIMIENTO -> MaterialTheme.colorScheme.surface
        else -> MaterialTheme.colorScheme.surfaceVariant
    }*/
    val tonalElevation = when (estado) {
        EstadoProducto.BAJO_STOCK, EstadoProducto.SIN_MOVIMIENTO -> 4.dp
        else -> 0.dp
    }

    Surface(
        modifier = modifier.size(48.dp),
        shape = CircleShape,
        color = backgroundColor,
        shadowElevation = 0.dp,
        tonalElevation = tonalElevation
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            Icon(
                painter = painterResource(id = iconToUse),
                contentDescription = null,
                tint = iconTint,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}


enum class EstadoProducto {
    DISPONIBLE,
    BAJO_STOCK,
    SIN_MOVIMIENTO,
    NUEVO_INGRESO
}

@Composable
fun ProductCard(
    nombre: String,
    precio: String,
    stock: String,
    iconRes: Int,
    @DrawableRes icon: Int,
    estado: EstadoProducto
) {
    val isDisabled = stock == "0"
    val avatarGradients = listOf(
        listOf(Color(0xFF4facfe), Color(0xFF00f2fe)),           // Azul eléctrico
        listOf(Color(0xFF43e97b), Color(0xFF38f9d7)),           // Verde menta
        listOf(Color(0xFFfa709a), Color(0xFFfee140)),           // Rosa → Amarillo
        listOf(Color(0xFFa18cd1), Color(0xFFfbc2eb)),           // Lila pastel
        listOf(Color(0xFFfad0c4), Color(0xFFffd1ff)),           // Rosa claro
        listOf(Color(0xFFff9a9e), Color(0xFFfad0c4)),           // Rosa coral
        listOf(Color(0xFF30cfd0), Color(0xFF330867)),           // Cian → Violeta oscuro
        listOf(Color(0xFFf6d365), Color(0xFFfda085)),           // Naranja cálido
        listOf(Color(0xFF5ee7df), Color(0xFFb490ca)),           // Aqua → Violeta
        listOf(Color(0xFF667eea), Color(0xFF764ba2)),           // Violeta intenso
        listOf(Color(0xFF89f7fe), Color(0xFF66a6ff)),           // Celeste luminoso
        listOf(Color(0xFFf093fb), Color(0xFFf5576c)),           // Magenta → Rojo
        listOf(Color(0xFF84fab0), Color(0xFF8fd3f4)),           // Verde claro → Azul
        listOf(Color(0xFFa1c4fd), Color(0xFFc2e9fb)),           // Azul pastel
        listOf(Color(0xFFd4fc79), Color(0xFF96e6a1)),           // Lima → Verde
        listOf(Color(0xFFfccb90), Color(0xFFd57eeb)),           // Naranja → Violeta
        listOf(Color(0xFFfddb92), Color(0xFFd1fdff)),           // Sol → Agua
        listOf(Color(0xFFe0c3fc), Color(0xFF8ec5fc)),           // Lila suave
    )

    val gradientColors = avatarGradients.random()
    val softGradient = gradientColors.map { it.copy(alpha = 0.75f) }

    /*val tonalColor = MaterialTheme.extendedColors.brand.copy(alpha = 0.60f)*/

    // Colores para los estados
    val estadoColor = when (estado) {
        EstadoProducto.DISPONIBLE -> MaterialTheme.extendedColors.success     // Verde
        EstadoProducto.BAJO_STOCK -> MaterialTheme.extendedColors.warning     // Amarillo
        EstadoProducto.SIN_MOVIMIENTO -> Color(0xFF81ADD0) // Azul suave
        EstadoProducto.NUEVO_INGRESO -> Color(0xFFC086CB)  // Violeta
    }
    Card(
        modifier = Modifier
            .fillMaxWidth(),
            /*.padding( // horizontal = 8.dp,
                vertical = 8.dp), // padding externo*/
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background,
            /*containerColor = Color.Transparent,*/
            contentColor = if (isDisabled)
                MaterialTheme.extendedColors.disabled
            else
                MaterialTheme.colorScheme.onBackground
        )
    ) {
        Column {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    /*.border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        shape = RoundedCornerShape(8.dp)
                    )*/
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                // verticalAlignment = Alignment.Top
                verticalAlignment = Alignment.CenterVertically

            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {

                    AvatarTonal(
                        iconRes = icon,
                        colorIndex = iconRes,
                        estado = estado // <-- le pasamos el estado
                    )
                }
                // Contenido principal
                Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = nombre,
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontWeight = FontWeight.Medium,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        )

                        Text(
                            text = precio,
                            color = if (isDisabled) MaterialTheme.extendedColors.disabled else MaterialTheme.colorScheme.onBackground,
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        )

                    }

                    // 👇 Ahora el chip queda directamente debajo del precio
                    Text(
                        when (estado) {
                            EstadoProducto.DISPONIBLE -> "Disponible"
                            EstadoProducto.BAJO_STOCK -> "Bajo stock"
                            EstadoProducto.SIN_MOVIMIENTO -> "Sin movimiento"
                            EstadoProducto.NUEVO_INGRESO -> "Nuevo ingreso"
                        },
                        color = MaterialTheme.extendedColors.medium,
                        style = MaterialTheme.typography.bodySmall
                    )
                    /*AssistChip(
                        onClick = {},
                        label = {
                            Text(
                                when (estado) {
                                    EstadoProducto.DISPONIBLE -> "Disponible"
                                    EstadoProducto.BAJO_STOCK -> "Bajo stock"
                                    EstadoProducto.SIN_MOVIMIENTO -> "Sin movimiento"
                                    EstadoProducto.NUEVO_INGRESO -> "Nuevo ingreso"
                                },
                                style = MaterialTheme.typography.bodySmall
                            )
                        },
                        shape = CircleShape,
                        modifier = Modifier.height(22.dp),
                        border = null,
                        colors = AssistChipDefaults.assistChipColors(
                            containerColor = estadoColor.copy(alpha = 0.15f),
                            labelColor = estadoColor
                        )
                    )*/

                    /*Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        AssistChip(
                            onClick = {},
                            label = { Text(
                                when (estado) {
                                    EstadoProducto.DISPONIBLE -> "Disponible"
                                    EstadoProducto.BAJO_STOCK -> "Bajo stock"
                                    EstadoProducto.SIN_MOVIMIENTO -> "Sin movimiento"
                                    EstadoProducto.NUEVO_INGRESO -> "Nuevo ingreso"
                                },
                                style = MaterialTheme.typography.bodySmall
                            ) },
                            shape = CircleShape,
                            modifier = Modifier.height(22.dp),
                            border = null,
                            colors = AssistChipDefaults.assistChipColors(
                                containerColor = estadoColor.copy(alpha = 0.15f),
                                labelColor = estadoColor
                            )
                        )
                    }*/
                }
            }
        }
    }
}


@Composable
fun QuantitySelector(isDisabled: Boolean) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        CircleButton(
            icon = R.drawable.remove,
            onClick = { /* Restar cantidad */ },
            enabled = !isDisabled // 👈 DESHABILITADO SI NO HAY STOCK
        )

        Text(
            text = "1",
            style = MaterialTheme.typography.bodyLarge,
            color = if (isDisabled)
                MaterialTheme.extendedColors.disabled
            else
                MaterialTheme.colorScheme.onSurface
        )

        CircleButton(
            icon = R.drawable.add,
            onClick = { /* Sumar cantidad */ },
            enabled = !isDisabled
        )
    }
}

/*@Composable
private fun CircleButton(
    @DrawableRes icon: Int,
    onClick: () -> Unit,
    enabled: Boolean = true
) {
    FilledTonalButton(
        onClick = onClick,
        enabled = enabled,
        shape = CircleShape,
        colors = ButtonDefaults.filledTonalButtonColors(
            containerColor =
                if (enabled) MaterialTheme.extendedColors.brand.copy(alpha = 0.12f)
                else MaterialTheme.extendedColors.disabled.copy(alpha = 0.1f),
            contentColor =
                if (enabled) MaterialTheme.extendedColors.brand
                else MaterialTheme.extendedColors.disabled
        ),
        contentPadding = PaddingValues(0.dp),
        modifier = Modifier.size(32.dp) // 👈 Antes 40dp
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.size(16.dp), // 👈 Antes 20dp
            tint = if (enabled) MaterialTheme.extendedColors.brand else MaterialTheme.extendedColors.disabled
        )
    }
}*/

@Composable
private fun CircleButton(
    @DrawableRes icon: Int,
    onClick: () -> Unit,
    enabled: Boolean = true
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor =
                if (enabled) MaterialTheme.colorScheme.surfaceVariant
                else MaterialTheme.extendedColors.disabled.copy(alpha = 0.1f),
            contentColor =
                if (enabled) MaterialTheme.colorScheme.onSurfaceVariant
                else MaterialTheme.extendedColors.disabled
        ),
        contentPadding = PaddingValues(0.dp),
        modifier = Modifier.size(32.dp) // 👈 Antes 40dp
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.size(16.dp), // 👈 Antes 20dp
            tint = if (enabled) MaterialTheme.colorScheme.onSurfaceVariant else MaterialTheme.extendedColors.disabled
        )
    }
}


