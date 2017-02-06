package jboilerplate.test.module

import jboilerplate.JApplication
import org.junit.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class MyApplication {

    @Test
    fun test() {
        val context = AnnotationConfigApplicationContext()
        context.scan("jboilerplate.test.module")
        context.refresh()
        JApplication.start(context)
    }
}