package com.mandarine.ror.course.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mandarine.ror.course.CardElevation

@Composable
fun ClickableCard(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    content: @Composable BoxScope.() -> Unit,
) {
    Card(
        elevation = CardElevation,
        modifier = modifier,
    ) {
        Box(
            modifier = Modifier.clickable(onClick = onClick),
            content = content,
        )
    }
}