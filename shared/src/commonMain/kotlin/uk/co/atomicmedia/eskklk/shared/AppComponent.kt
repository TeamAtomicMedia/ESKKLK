package uk.co.atomicmedia.eskklk.shared

import software.amazon.lastmile.kotlin.inject.anvil.AppScope
import software.amazon.lastmile.kotlin.inject.anvil.MergeComponent
import software.amazon.lastmile.kotlin.inject.anvil.SingleIn


interface AppComponent {
    val appVersionPrinter: AppVersionPrinter
}