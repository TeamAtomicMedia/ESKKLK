package uk.co.atomicmedia.eskklk.shared

import software.amazon.lastmile.kotlin.inject.anvil.AppScope
import software.amazon.lastmile.kotlin.inject.anvil.MergeComponent
import software.amazon.lastmile.kotlin.inject.anvil.SingleIn

@MergeComponent(AppScope::class)
@SingleIn(AppScope::class)
abstract class IosAppComponent(
    @get:Provides appVersionProvider: AppVersionProvider,
) : AppComponent

@MergeComponent.CreateComponent
expect fun create(
    appVersionProvider: AppVersionProvider,
): IosAppComponent