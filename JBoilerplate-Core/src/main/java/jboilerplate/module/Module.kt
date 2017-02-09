package jboilerplate.module

import org.springframework.stereotype.Component
import kotlin.reflect.KClass

@Target(AnnotationTarget.CLASS)
@MustBeDocumented
@Component
annotation class Module(
        val depends: Array<KClass<out ModuleBase>> = arrayOf()
)