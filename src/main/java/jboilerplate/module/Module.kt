package jboilerplate.module

import org.springframework.stereotype.Component
import kotlin.reflect.KClass

@Target(AnnotationTarget.CLASS)
@MustBeDocumented
@Component
annotation class Module(
        /**
         * 该模块依赖的其他模块
         */
        val depends: Array<KClass<out ModuleBase>> = arrayOf()
)