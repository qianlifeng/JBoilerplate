package jboilerplate.module

/**
 * This class must be implemented by all module definition classes.
 */
abstract class ModuleBase {
    open fun preInitialize() {}
    open fun initialize() {}
    open fun postInitialize() {}
    open fun shutdown() {}
}


