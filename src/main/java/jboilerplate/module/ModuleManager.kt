package jboilerplate.module

import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.stereotype.Component
import java.util.*

@Component
object ModuleManager : ApplicationContextAware {

    lateinit var context: ApplicationContext

    override fun setApplicationContext(applicationContext: ApplicationContext) {
        context = applicationContext
    }

    fun initializeModules() {
        //Step 1: find all modules and resort by depends modules
        val beansOfType = context.getBeansOfType(ModuleBase::class.java)
        var sortedModules = mutableListOf<ModuleBase>()
        var visitedModules = hashMapOf<String, Boolean>()
        beansOfType.forEach { sortByDependsVisit(it.value, sortedModules, visitedModules) }
        println(sortedModules)
    }

    fun sortByDependsVisit(module: ModuleBase, sortedModules: MutableList<ModuleBase>, visitedModules: HashMap<String, Boolean>) {
        var moduleName = module.javaClass.canonicalName
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