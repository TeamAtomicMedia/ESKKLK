package uk.co.atomicmedia.eskklk.shared

import android.app.Application
import me.tatarka.inject.annotations.Inject
import software.amazon.lastmile.kotlin.inject.anvil.AppScope
import software.amazon.lastmile.kotlin.inject.anvil.ContributesBinding

@ContributesBinding(AppScope::class)
@Inject
class AndroidAppVersionProvider(
    private val application: Application
) {
    fun provideAppVersion(): String {
        return application.packageManager
            .getPackageInfo(application.packageName, 0)
            .versionName ?: "Unknown"
    }
}