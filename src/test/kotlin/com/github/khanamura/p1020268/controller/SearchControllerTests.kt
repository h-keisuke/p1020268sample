package com.github.khanamura.p1020268.controller

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.test.web.servlet.setup.MockMvcBuilders.*

@ExtendWith(SpringExtension::class)
@SpringBootTest
@AutoConfigureMockMvc
class SearchControllerTests {

  @Autowired
  private lateinit var mockMvc: MockMvc

  @Test
  fun homeTest() {
    this.mockMvc.perform(get("/"))
      .andExpect(status().isOk)
      .andExpect(xpath("/html/body/section/div/form/h1").string("郵便番号で住所が検索できます。"))
      .andExpect(xpath("/html/body/section/div/form/div/div/input/@name").string("zip"))
      .andExpect(xpath("/html/body/section/div/form/div/div/button").string("検索"))
      .andExpect(model().hasNoErrors<Any>())
  }

  @Test
  fun searchTest() {
    this.mockMvc.perform(post("/").param("zip", "1400011"))
      .andExpect(status().isOk)
      .andExpect(xpath("/html/body/section/div/p/span[1]").string("東京都"))
      .andExpect(xpath("/html/body/section/div/p/span[2]").string("品川区"))
      .andExpect(xpath("/html/body/section/div/p/span[3]").string("東大井"))
      .andExpect(model().hasNoErrors<Any>())
  }
}
