package jboilerplate.module

import jboilerplate.JBoilerplateException
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.stereotype.Component
import java.util.*

@Component
open class ModuleManager : ApplicationContextAware {

    private var initialized = false

    lateinit var context: ApplicationContext

    override fun setApplicationContext(applicationContext: ApplicationContext) {
        context = applicationContext
    }

    @Synchronized
    fun initializeModules() {
        if (initialized) throw JBoilerplateException("Module has been initialized, can't initial twice")

        //Step 1: find all modules and resort by depends modules
        val beansOfType = context.getBeansOfType(ModuleBase::class.java)
        val sortedModules = mutableListOf<ModuleBase>()
        val visitedModules = hashMapOf<String, Boolean>()
        beansOfType.forEach { sortByDependsVisit(it.value, sortedModules, visitedModules) }

        //Step 2: execute lifecycle events
        sortedModules.forEach {
            it.preInitialize()
            it.initialize()
            it.postInitialize()
        }

        initialized = true
    }

    fun sortByDependsVisit(module: ModuleBase, sortedModules: MutableList<ModuleBase>, visitedModules: HashMap<String, Boolean>) {
        val moduleName = module.javaClass.canonicalName
        if (visitedModules.containsKey(moduleName)) {
            if (visitedModules[moduleName]!!) { //visited and in-processing
                throw Exception("Found recycle references for module $moduleName")
            }
        } else {
            visitedModules.put(moduleName, true)
            module.depends.forEach { sortByDependsVisit(it, sortedModules, visitedModules) }

            visitedModules.put(moduleName, false)
            sortedModules.add(module)
        }
    }

}