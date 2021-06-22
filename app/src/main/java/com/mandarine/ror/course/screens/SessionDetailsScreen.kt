package com.mandarine.ror.course.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mandarine.ror.course.Medium
import com.mandarine.ror.course.composables.Avatar
import com.mandarine.ror.course.composables.BackgroundSurface
import com.mandarine.ror.course.composables.DateTimeText
import com.mandarine.ror.course.data.MockSessions
import com.mandarine.ror.course.data.Session
import com.mandarine.ror.course.ui.RorTheme

@Composable
fun SessionDetailsScreen(session: Session) {
    BackgroundSurface {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(Medium),
            contentAlignment = Alignment.Center,
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(Medium),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Avatar(
                    modifier = Modifier.size(234.dp),
                    imageUrl = session.imageUrl,
                    contentDescription = null,
                )
                Text(
                    style = MaterialTheme.typography.h3,
                    text = session.speaker,
                )
                DateTimeText(
                    modifier = Modifier.fillMaxWidth(),
                    text = "${session.date}, ${session.timeInterval}",
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.body1,
                    text = session.description,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SessionDetailsScreenPreview() {
    RorTheme {
        SessionDetailsScreen(session = MockSessions.first())
    }
}

@Preview(showBackground = true)
@Composable
private fun SessionDetailsScreenDarkPreview() {
    RorTheme(isDarkTheme = true) {
        SessionDetailsScreen(session = MockSessions.first())
    }
}