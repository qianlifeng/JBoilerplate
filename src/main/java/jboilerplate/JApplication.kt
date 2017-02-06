package jboilerplate

import jboilerplate.module.ModuleManager
import org.springframework.context.ApplicationContext

object JApplication {

    /**
     *  启动JBoilerplate程序
     */
    fun start(context: ApplicationContext) {
        ModuleManager.initializeModules(context)
    }
}