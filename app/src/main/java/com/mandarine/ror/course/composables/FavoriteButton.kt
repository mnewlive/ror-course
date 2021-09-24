package com.mandarine.ror.course.composables

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.mandarine.ror.course.R

@Composable
fun FavoriteButton(
    isFavoriteState: State<Boolean>,
    onToggle: (Boolean) -> Unit = {},
) {
    IconButton(
        onClick = {
            onToggle(!isFavoriteState.value)
        }
    ) {
        when (isFavoriteState.value) {
            true -> Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = stringResource(id = R.string.favorite_remove),
                tint = Color.Red,
            )
            false -> Icon(
                imageVector = Icons.Filled.FavoriteBorder,
                contentDescription = stringResource(id = R.string.favorite_add),
                tint = Color.Gray,
            )
        }
    }
}

@Preview
@Composable
private fun FavoriteButtonPreview() {
    val isLikedState = remember { mutableStateOf(false) }
    FavoriteButton(isLikedState) {
        isLikedState.value = it
    }
}