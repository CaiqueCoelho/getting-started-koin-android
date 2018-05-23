package org.koin.sample

import org.junit.Before
import org.junit.Test
import org.koin.dsl.module.applicationContext
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.inject
import org.koin.test.AutoCloseKoinTest
import org.mockito.Mockito
import org.mockito.Mockito.mock

val MockModule = applicationContext {
    bean { mock(HelloService::class.java) }
}

class HelloMockTest : AutoCloseKoinTest() {

    val service: HelloService by inject()

    @Before
    fun before() {
        startKoin(listOf(MockModule))
    }

    @Test
    fun tesKoinComponents() {
        HelloApplication()

        Mockito.verify(service).hello()
    }
}