package jboilerplate

import jboilerplate.module.Module
import jboilerplate.module.ModuleBase

@Module
class JBoilerplateKernalModule : ModuleBase() {
    override fun initialize() {
        println("ModuleBase A initialized")
    }
}
