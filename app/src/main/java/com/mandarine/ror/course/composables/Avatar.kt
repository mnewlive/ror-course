package com.mandarine.ror.course.composables

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.transform.CircleCropTransformation
import com.google.accompanist.coil.rememberCoilPainter
import com.mandarine.ror.course.R
import com.mandarine.ror.course.ui.RorTheme

@Composable
fun Avatar(
    imageUrl: String?,
    modifier: Modifier = Modifier,
    contentDescription: String?,
) {
    val placeholder = R.drawable.ic_avatar_placeholder
    val imagePainter = rememberCoilPainter(
        request = imageUrl,
        previewPlaceholder = placeholder,
        fadeIn = true,
        requestBuilder = {
            placeholder(placeholder)
            fallback(placeholder)
            error(placeholder)
            transformations(CircleCropTransformation())
        },
    )
    Image(
        modifier = modifier,
        painter = imagePainter,
        contentDescription = contentDescription,
    )
}

@Preview
@Composable
private fun AvatarPreview() {
    RorTheme {
        Avatar(
            imageUrl = null,
            contentDescription = null,
        )
    }
}