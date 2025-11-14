package com.aagamshah.presentation.extensions

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

fun Long.toTimeAgo(): String {
    val now = System.currentTimeMillis()
    val diff = now - this

    return when {
        diff < 0 -> "In the future"
        diff < 60_000 -> "Just now"
        diff < 60 * 60_000 -> "${diff / 60_000}m ago"
        diff < 24 * 60 * 60_000 -> "${diff / (60 * 60_000)}h ago"
        diff < 48 * 60 * 60_000 -> "Yesterday"
        else -> {
            this.toFormattedDate()
        }
    }
}

fun Long.toFormattedDate(): String {
    val instant = Instant.ofEpochMilli(this)
    val formatter = DateTimeFormatter.ofPattern("dd MMM, yyyy", Locale.getDefault())
        .withZone(ZoneId.systemDefault())
    return formatter.format(instant)
}