package com.example.todo.controller.api.todo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class TodoApiController {

    //R
    @GetMapping(path = [""])
    fun read(@RequestParam(required = false) index: Int? ) {

    }

    //C

    //U

    //D
}