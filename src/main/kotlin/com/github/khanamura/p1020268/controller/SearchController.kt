package com.github.khanamura.p1020268.controller

import com.github.khanamura.p1020268.form.SearchForm
import com.github.khanamura.p1020268.service.SearchService
import com.github.kittinunf.result.Result
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/")
class SearchController {

    @Autowired
    private lateinit var searchService: SearchService

    @GetMapping
    fun home(model: Model): String {
        val form = SearchForm()
        model.addAttribute(form)
        return "index"
    }

    @PostMapping
    fun search(@Validated form: SearchForm, result: BindingResult, model: Model): String {
        if (result.hasErrors()) return "index"

        val searchResult = searchService.search(form.zip)
        when (searchResult) {
            is Result.Failure -> {
                model.addAttribute("errorMessage", searchResult.error.message)
            }

            is Result.Success -> {
                model.addAttribute("addresses", searchResult.value)
            }
        }

        return "result"
    }
}