package com.github.khanamura.p1020268.controller

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.test.web.servlet.setup.MockMvcBuilders.*

@ExtendWith(SpringExtension::class)
@WebMvcTest(SearchController::class)
class SearchControllerTests {

  @Autowired
  private lateinit var mockMvc: MockMvc

  @Test
  fun homeTest() {
    //HTTPCode200が返されること
    this.mockMvc.perform(get("/"))
        .andExpect(status().isOk)
        .andExpect(xpath("/html/body/div/form/h1").string("郵便番号で住所が検索できます。"))
        .andExpect(xpath("/html/body/div/form/input/@name").string("zip"))
        .andExpect(xpath("/html/body/div/form/button").string("検索"))
        .andExpect(model().hasNoErrors<Any>())
  }

  @Test
  fun searchTest() {
    this.mockMvc.perform(post("/").param("zip", "1400000"))
        .andExpect(status().isOk)

  }
}
