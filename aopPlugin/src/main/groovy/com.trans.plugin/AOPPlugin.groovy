package com.trans.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class AOPPlugin implements  Plugin<Project> {

    @Override
    void apply(Project project) {
        println "Hello AOPPlugin privacyTest 1"
    }
}