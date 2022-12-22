package com.vudang.kotlin.hexagon

import com.google.gson.Gson
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.BootstrapWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestExecutionListeners
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener
import org.springframework.test.context.support.DirtiesContextTestExecutionListener
import org.springframework.transaction.annotation.Transactional

@ActiveProfiles("test")
@SpringBootTest(classes = [TestApplication::class])
@BootstrapWith(SpringBootTestContextBootstrapper::class)
@ContextConfiguration(loader = CustomSpringBootContextLoader::class)
@TestExecutionListeners(
  value =
    [DependencyInjectionTestExecutionListener::class, DirtiesContextTestExecutionListener::class],
  mergeMode = TestExecutionListeners.MergeMode.MERGE_WITH_DEFAULTS
)
@Transactional
abstract class BaseTest {
  companion object {
    val gson = Gson()
  }

  fun loadResource() {}
}
