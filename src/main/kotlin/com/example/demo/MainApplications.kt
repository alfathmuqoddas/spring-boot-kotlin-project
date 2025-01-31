package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan(basePackages = ["com.example.demo.controller", "com.example.demo.service", "com.example.demo.repository", "com.example.demo.model"])
class Demo

fun main(args: Array<String>) {
	runApplication<Demo>(*args)
}
