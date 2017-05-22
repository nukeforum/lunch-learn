package com.rook.lunchandlearn.main

import com.nhaarman.mockito_kotlin.verify
import com.rook.lunchandlearn.entities.Topic
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import kotlin.test.assertTrue


@RunWith(JUnitPlatform::class)
object MainPresenterTest : Spek({
    given("a MainPresenter") {
        val view = mock(IMain::class.java)
        val presenter = MainPresenter()

        context("on bind") {
            afterEachTest { presenter.dropView(view) }

            it("should tell the view to show topics") {
                presenter.takeView(view)
                verify(view, times(1)).showTopics(any())
            }
        }

        context("adding Topic") {
            afterEachTest {
                presenter.dropView(view)
                presenter.topics.clear()
            }

            beforeEachTest { presenter.takeView(view) }

            it("receives null") {
                presenter.addTopic(null)

                assertTrue { !presenter.topics.contains(null) }
            }

            it("receives empty") {
                presenter.addTopic(Topic(""))

                assertTrue { presenter.topics.filter { it.name == "" }.isEmpty() }
            }

            it("receives a Topic") {
                val topic = Topic("Some Topic")
                presenter.addTopic(topic)

                assertTrue { presenter.topics.contains(topic) }
            }
        }
    }
})