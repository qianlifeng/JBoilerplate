package jboilerplate.module

import jboilerplate.configuration.JBoilerplateConfiguration
import org.springframework.beans.factory.NoSuchBeanDefinitionException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware

/**
 * This class must be implemented by all module definition classes.
 */
abstract class ModuleBase : ApplicationContextAware {

    lateinit var context: ApplicationContext

    @Autowired
    lateinit var configuration: JBoilerplateConfiguration

    override fun setApplicationContext(applicationContext: ApplicationContext) {
        context = applicationContext
    }

    val depends: List<ModuleBase>
        get() {
            val list = mutableListOf<ModuleBase>()
            this.javaClass.getAnnotationsByType(Module::class.java).forEach {
                for (module in it.depends) {
                    try {
                        list.add(context.getBean(module.javaObjectType))
                    } catch (e: NoSuchBeanDefinitionException) {
                        throw Exception("No dependency module ${module.java.canonicalName} found for module: ${this.javaClass.canonicalName}")
                    }
                }
            }
            return list
        }

    open fun preInitialize() {
    }

    open fun initialize() {
    }

    open fun postInitialize() {
    }

    open fun shutdown() {
    }
}


