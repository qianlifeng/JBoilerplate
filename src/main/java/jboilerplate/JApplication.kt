package jboilerplate

import jboilerplate.module.ModuleManager

object JApplication {

    /**
     *  Bootstrap JBoilerplate application
     */
    fun start() {
        ModuleManager.initializeModules()
    }
}