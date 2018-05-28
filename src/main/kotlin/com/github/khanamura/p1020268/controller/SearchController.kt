package com.github.khanamura.p1020268.controller

import com.github.khanamura.p1020268.form.SearchForm
import com.github.khanamura.p1020268.service.SearchService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/")
class SearchController {

  lateinit var searchService: SearchService

  @GetMapping
  fun home(model: Model): String {
    val form = SearchForm()
    model.addAttribute(form)
    return "index"
  }

  @PostMapping
  fun search(model: Model): String{

    return "result"
  }
}