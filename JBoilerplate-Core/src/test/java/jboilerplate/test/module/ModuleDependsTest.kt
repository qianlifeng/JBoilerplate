package jboilerplate.test.module

import org.junit.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class MyApplication {

    @Test
    fun test() {
        val context = AnnotationConfigApplicationContext()
        context.scan("jboilerplate")
        context.refresh()
    }
}