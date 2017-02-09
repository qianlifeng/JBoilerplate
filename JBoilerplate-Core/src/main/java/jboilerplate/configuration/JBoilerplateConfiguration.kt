package jboilerplate.configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
open class JBoilerplateConfiguration {

    @Autowired
    lateinit var modules: ModuleConfigurations
}

@Component
open class ModuleConfigurations {
//    lateinit var configuration: JBoilerplateConfiguration
}