package jboilerplate.data.jpa

import jboilerplate.module.ModuleBase
import org.springframework.stereotype.Component

@Component
class SpringDataJPAModule : ModuleBase() {
    override fun preInitialize() {
        this.configuration.modules.springDataJpa()
    }
}