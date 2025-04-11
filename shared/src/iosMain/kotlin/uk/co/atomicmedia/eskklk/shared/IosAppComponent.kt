package uk.co.atomicmedia.eskklk.shared

import me.tatarka.inject.annotations.Provides
import software.amazon.lastmile.kotlin.inject.anvil.AppScope
import software.amazon.lastmile.kotlin.inject.anvil.MergeComponent
import software.amazon.lastmile.kotlin.inject.anvil.SingleIn

@MergeComponent(AppScope::class)
@SingleIn(AppScope::class)
abstract class IosAppComponent(
    @get:Provides val appVersionProvider: AppVersionProvider,
) : AppComponent

@MergeComponent.CreateComponent
expect fun create(
    appVersionProvider: AppVersionProvider,
): IosAppComponent