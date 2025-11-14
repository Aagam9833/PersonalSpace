package com.aagamshah.presentation.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.aagamshah.domain.model.CommentsModel
import com.aagamshah.presentation.extensions.toTimeAgo
import com.aagamshah.presentation.ui.theme.AppTypography

@Composable
fun CommentsBottomSheetComposable(comments: List<CommentsModel>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.6f),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(comments, key = { it.id }) { comment ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(comment.userProfileIcon)
                        .transformations(CircleCropTransformation())
                        .build(),
                    contentDescription = "Profile Icon",
                    modifier = Modifier.size(36.dp)
                )
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = comment.username,
                        style = AppTypography.titleMedium
                    )
                    Text(
                        text = comment.comment,
                        style = AppTypography.bodyMedium
                    )
                }
                Text(
                    text = comment.timestamp.toTimeAgo(),
                    style = AppTypography.bodySmall
                )
            }
        }
    }
}
