package com.mandarine.ror.course.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mandarine.ror.course.screens.Small
import com.mandarine.ror.course.data.MockSessions
import com.mandarine.ror.course.data.Session
import com.mandarine.ror.course.ui.RorTheme

private val FavoriteSessionCardSize = 128.dp

@Composable
fun FavoriteSessionCard(
    sessionState: State<Session>,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    ClickableCard(
        modifier = modifier
            .size(FavoriteSessionCardSize),
        onClick = onClick,
    ) {
        Column(modifier = Modifier.padding(Small)) {
            val session = sessionState.value
            Text(
                style = MaterialTheme.typography.h4,
                text = session.timeInterval,
            )
            Text(
                style = MaterialTheme.typography.subtitle2,
                text = session.date,
            )
            Spacer(
                modifier = Modifier.weight(1f),
            )
            Text(
                style = MaterialTheme.typography.h5,
                text = session.speaker,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                style = MaterialTheme.typography.subtitle2,
                text = session.description,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

@Preview
@Composable
private fun FavoriteSessionCardPreview() {
    val sessionState = remember { mutableStateOf(MockSessions.first()) }
    RorTheme {
        FavoriteSessionCard(sessionState = sessionState) {}
    }
}

@Preview
@Composable
private fun FavoriteSessionCardDarkPreview() {
    val sessionState = remember { mutableStateOf(MockSessions.first()) }
    RorTheme(isDarkTheme = true) {
        FavoriteSessionCard(sessionState = sessionState) {}
    }
}