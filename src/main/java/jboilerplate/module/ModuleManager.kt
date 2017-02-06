package jboilerplate.module

import org.springframework.context.ApplicationContext

object ModuleManager {

    fun initializeModules(context: ApplicationContext) {
        val beansOfType = context.getBeansOfType(ModuleBase::class.java)
        beansOfType.forEach { it.value.initialize() }
    }

}