package com.github.khanamura.p1020268.service

import com.github.khanamura.p1020268.domain.SearchResult
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.fail
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest
class SearchServiceTest {

  @Autowired
  lateinit var searchService: SearchService

  @Test
  fun search(){
    val result1 = searchService.search("1400011")
    if(result1 == null){
      fail("result is null")
    }else {
      assertEquals(result1.size, 1)
      assertEquals(result1[0].address1, "東京都")
      assertEquals(result1[0].address2, "品川区")
      assertEquals(result1[0].address3, "東大井")
    }

  }
}