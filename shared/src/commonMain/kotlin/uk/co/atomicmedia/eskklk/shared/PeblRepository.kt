package uk.co.atomicmedia.eskklk.shared

import me.tatarka.inject.annotations.Inject
import software.amazon.lastmile.kotlin.inject.anvil.AppScope
import software.amazon.lastmile.kotlin.inject.anvil.SingleIn

@Inject
@SingleIn(AppScope::class)
class PeblRepository() {
    fun printAppVersion() {
        println("App version")
    }
}