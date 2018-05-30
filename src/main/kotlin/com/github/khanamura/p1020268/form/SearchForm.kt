package com.github.khanamura.p1020268.form

import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

data class SearchForm(
    @field:NotNull
    @field:Size(max = 8, min = 7)
    @field:Pattern(regexp = "[0-9]{3}-?[0-9]{4}")
    val zip: String = ""
)