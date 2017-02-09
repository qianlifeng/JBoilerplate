package jboilerplate.test.module

import jboilerplate.module.Module
import jboilerplate.module.ModuleBase


@Module
class ModuleBaseA : ModuleBase() {
    override fun initialize() {
        println("ModuleBase A initialized")
    }
}

@Module(depends = arrayOf(ModuleBaseA::class))
class ModuleBaseB : ModuleBase() {
    override fun initialize() {
        println("ModuleBase B initialized")
    }
}

@Module(depends = arrayOf(ModuleBaseB::class))
class ModuleBaseC : ModuleBase() {
    override fun initialize() {
        println("ModuleBase C initialized")
    }
}

@Module
class ModuleBaseD : ModuleBase() {
    override fun initialize() {
        println("ModuleBase D initialized")
    }
}

@Module(depends = arrayOf(ModuleBaseA::class, ModuleBaseD::class))
class Application : ModuleBase() {}