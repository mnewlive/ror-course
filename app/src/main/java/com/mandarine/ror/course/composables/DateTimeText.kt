package com.mandarine.ror.course.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.mandarine.ror.course.R
import com.mandarine.ror.course.Small

@Composable
fun DateTimeText(
    text: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_calendar_blank),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.width(Small))
        Text(text = text)
    }
}
