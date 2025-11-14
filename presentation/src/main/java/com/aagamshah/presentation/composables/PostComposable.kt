package com.aagamshah.presentation.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.aagamshah.domain.model.Post
import com.aagamshah.presentation.R
import com.aagamshah.presentation.extensions.toTimeAgo
import com.aagamshah.presentation.screens.feedscreen.FeedIntent
import com.aagamshah.presentation.ui.theme.AppTypography

@Composable
fun PostComposable(post: Post, onEvent: (FeedIntent) -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(post.userProfileIcon)
                    .transformations(CircleCropTransformation())
                    .build(),
                contentDescription = "Profile Icon",
                modifier = Modifier
                    .size(36.dp)
            )
            Text(
                text = post.username,
                style = AppTypography.titleMedium
            )
        }
        AsyncImage(
            model = post.imageUrl,
            contentDescription = "Image post",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )
        if (!post.caption.isNullOrBlank()) {
            Text(
                text = post.caption.toString(),
                style = AppTypography.bodyLarge,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Outlined.FavoriteBorder,
                    contentDescription = "Like Icon"
                )
                Spacer(Modifier.width(width = 2.dp))
                Text(
                    text = post.likesCount.toString()
                )
                Spacer(Modifier.width(width = 8.dp))
                Icon(
                    painter = painterResource(R.drawable.ic_comment),
                    contentDescription = "Comment Icon",
                    modifier = Modifier.clickable { onEvent(FeedIntent.ShowCommentsBottomSheet(post.comments)) }
                )
                Spacer(Modifier.width(width = 2.dp))
                Text(
                    text = post.commentsCount.toString()
                )
            }
            Text(
                text = post.timestamp.toTimeAgo(),
                style = AppTypography.bodySmall
            )
        }
    }
}