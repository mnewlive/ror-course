package com.mandarine.ror.course.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mandarine.ror.course.screens.Medium
import com.mandarine.ror.course.data.MockSessions
import com.mandarine.ror.course.data.Session
import com.mandarine.ror.course.ui.RorTheme

@Composable
fun SessionCard(
    session: Session,
    isFavoriteState: State<Boolean>,
    modifier: Modifier = Modifier,
    onFavoriteToggle: (Boolean) -> Unit = {},
    onClick: () -> Unit = {},
) {
    ClickableCard(
        modifier = modifier
            .fillMaxWidth(),
        onClick = onClick,
    ) {
        Row(
            modifier = Modifier.padding(Medium),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Avatar(
                modifier = Modifier.size(60.dp),
                imageUrl = session.imageUrl,
                contentDescription = session.speaker,
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = Medium),
            ) {
                Text(
                    style = MaterialTheme.typography.h5,
                    text = session.speaker,
                )
                Text(
                    style = MaterialTheme.typography.h5,
                    text = session.timeInterval,
                )
                Text(
                    style = MaterialTheme.typography.subtitle2,
                    text = session.description,
                )
            }

            FavoriteButton(
                isFavoriteState = isFavoriteState,
                onToggle = onFavoriteToggle
            )
        }
    }
}

@Preview
@Composable
private fun SessionCardPreview() {
    val session = MockSessions.first()
    val isFavoriteState = remember { mutableStateOf(false) }
    RorTheme {
        SessionCard(
            session = session,
            isFavoriteState = isFavoriteState,
        )
    }
}

@Preview
@Composable
private fun SessionCardDarkPreview() {
    val isFavoriteState = remember { mutableStateOf(false) }
    RorTheme(isDarkTheme = true) {
        SessionCard(
            session = MockSessions.first(),
            isFavoriteState = isFavoriteState,
        )
    }
}