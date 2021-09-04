package com.mandarine.ror.course.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mandarine.ror.course.R
import com.mandarine.ror.course.composables.*
import com.mandarine.ror.course.data.MockSessions
import com.mandarine.ror.course.data.Session
import com.mandarine.ror.course.ui.RorTheme

val Small = 8.dp
val Medium = 16.dp

val CardElevation = 4.dp

@Composable
fun MainScreen(
    sessions: List<Session> = emptyList(),
    favoriteSessions: List<Session> = emptyList(),
    searchQuery: String = "",
    isError: Boolean = false,
    onReloadClick: () -> Unit = {},
    onSessionClick: (String) -> Unit = {},
    onSessionFavoriteToggle: (Boolean) -> Unit = {},
) {
    BackgroundSurface {
        val searchQueryState = remember { mutableStateOf(searchQuery) }
        LazyColumn(
            contentPadding = PaddingValues(top = Medium, bottom = Medium),
        ) {
            item {
                SearchTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = Medium),
                    text = searchQueryState,
                    onTextChanged = { query ->
                        searchQueryState.value = query
                    }
                )
            }
            if (isError) {
                item {
                    ErrorView(
                        text = stringResource(id = R.string.session_error),
                        onReloadClick = onReloadClick
                    )
                }
                return@LazyColumn
            }
            if (favoriteSessions.isNotEmpty()) {
                item {
                    ListHeader(
                        text = stringResource(id = R.string.favorite)
                    )
                }
                item {
                    LazyRow(
                        contentPadding = PaddingValues(Medium),
                        horizontalArrangement = Arrangement.spacedBy(Small)
                    ) {
                        items(favoriteSessions) { session ->
                            val sessionState = remember { mutableStateOf(session) }
                            FavoriteSessionCard(
                                sessionState = sessionState,
                                onClick = { onSessionClick(session.id) },
                            )
                        }
                    }
                }
            }
            val filteredSessions = sessions.filter { session ->
                val query = searchQueryState.value
                query.isBlank() ||
                        session.speaker.contains(query, ignoreCase = true) ||
                        session.description.contains(query, ignoreCase = true)
            }
            if (filteredSessions.isEmpty()) {
                item {
                    EmptyView(
                        text = stringResource(id = R.string.session_not_found)
                    )
                }
                return@LazyColumn
            }
            item {
                ListHeader(
                    text = stringResource(id = R.string.sessions)
                )
            }
            var prevSessionDate: String? = null
            for (session in filteredSessions) {
                if (prevSessionDate != session.date) {
                    item {
                        ListDateHeader(
                            text = session.date,
                        )
                    }
                    prevSessionDate = session.date
                }
                item {
                    val isFavoriteState = remember { mutableStateOf(false) }
                    SessionCard(
                        modifier = Modifier.padding(
                            start = Medium,
                            top = Medium,
                            end = Medium,
                        ),
                        session = session,
                        isFavoriteState = isFavoriteState,
                        onFavoriteToggle = { onSessionFavoriteToggle(it) },
                        onClick = { onSessionClick(session.id) },
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    RorTheme {
        MainScreen(
            sessions = MockSessions,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MainScreenDarkPreview() {
    RorTheme(isDarkTheme = true) {
        MainScreen(
            sessions = MockSessions,
        )
    }
}