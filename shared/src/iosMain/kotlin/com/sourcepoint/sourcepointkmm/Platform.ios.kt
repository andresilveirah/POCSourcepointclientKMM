package com.sourcepoint.sourcepointkmm

import com.russhwolf.settings.Settings
import com.russhwolf.settings.NSUserDefaultsSettings
import platform.UIKit.UIDevice
import platform.Foundation.NSUserDefaults

actual abstract class Context
object IosContext : Context()

actual class PlatformSpecific : Platform {
    override val name = UIDevice.currentDevice.systemName()
    override val version: String = UIDevice.currentDevice.systemVersion
    private val delegate: NSUserDefaults = NSUserDefaults()
    override val settings: Settings = NSUserDefaultsSettings(delegate)
}