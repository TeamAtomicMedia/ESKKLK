@file:OptIn(ExperimentalTime::class)

package uk.co.atomicmedia.eskklk.shared

import kotlin.time.ExperimentalTime

data class Interest(
    val id: String,
    val name: String,
    val desc: String?,
)
