package com.rook.lunchandlearn.main

import com.nhaarman.mockito_kotlin.verify
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import org.mockito.Mockito.*


@RunWith(JUnitPlatform::class)
object MainPresenterTest : Spek({
    given("A MainPresenter") {
        val view = mock(IMain::class.java)
        val presenter = MainPresenter()

        on("view bound") {
            it("sends the Topic data to the view") {
                presenter.takeView(view)
                verify(view, times(1)).showTopics(any())
            }
        }
    }
})