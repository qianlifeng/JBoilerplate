package jboilerplate

import jboilerplate.module.ModuleManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
open class JApplication {

    @Autowired
    lateinit var moduleManager: ModuleManager

    /**
     *  Bootstrap JBoilerplate application
     */
    fun start() {
        moduleManager.initializeModules()
    }
}