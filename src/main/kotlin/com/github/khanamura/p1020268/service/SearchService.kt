package com.github.khanamura.p1020268.service


import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.github.khanamura.p1020268.domain.Address
import com.github.khanamura.p1020268.domain.SearchResult
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import org.springframework.stereotype.Service

@Service
class SearchService {

  fun search(zip: String): List<Address>? {
    val (request, response, result) =
      "http://zipcloud.ibsnet.co.jp/api/search?zipcode=$zip".httpGet().responseString()
    return when (result) {
      is Result.Failure -> {
        null
      }

      is Result.Success -> {
        val data = result.get()
        val objectMapper = ObjectMapper().registerKotlinModule()
        objectMapper.readValue<SearchResult>(data).results
      }
    }
  }
}