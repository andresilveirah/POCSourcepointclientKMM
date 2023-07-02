package com.sourcepoint.sourcepointkmm

import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertTrue

class IosGreetingTest {
    private val coordinator = SourcepointCoordinator(PlatformSpecific())

    @Test
    fun testExample() = runTest {
        assertTrue(coordinator.greet().contains("iOS"), "Check iOS is mentioned")
    }
}