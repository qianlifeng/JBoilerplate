package jboilerplate.data.jpa

import jboilerplate.configuration.ModuleConfigurations

data class SpringDataJPAModuleConfiguration(
        var db: String = "",
        var port: Int = 3306
)

fun ModuleConfigurations.springDataJpa(): SpringDataJPAModuleConfiguration {
    return SpringDataJPAModuleConfiguration()
}