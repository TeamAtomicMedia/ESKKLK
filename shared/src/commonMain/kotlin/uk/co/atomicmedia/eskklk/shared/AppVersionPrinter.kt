package uk.co.atomicmedia.eskklk.shared

import me.tatarka.inject.annotations.Inject
import software.amazon.lastmile.kotlin.inject.anvil.AppScope
import software.amazon.lastmile.kotlin.inject.anvil.MergeComponent
import software.amazon.lastmile.kotlin.inject.anvil.SingleIn

@Inject
@SingleIn(AppScope::class)
class AppVersionPrinter(
    private val appVersionProvider: AppVersionProvider,
) {
    fun printAppVersion() {
        println("App version: ${appVersionProvider.provideAppVersion()}")
    }
}