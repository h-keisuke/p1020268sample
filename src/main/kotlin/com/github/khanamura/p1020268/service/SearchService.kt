package com.github.khanamura.p1020268.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.github.khanamura.p1020268.domain.Address
import com.github.khanamura.p1020268.domain.SearchResult
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.github.kittinunf.result.flatMap
import org.springframework.stereotype.Service

@Service
class SearchService {

    fun search(zip: String): Result<List<Address>, Exception> {
        val (_, _, result) =
            "http://zipcloud.ibsnet.co.jp/api/search?zipcode=$zip".httpGet().responseString()
        return result.flatMap {
            val objectMapper = ObjectMapper().registerKotlinModule()
            val searchResult = objectMapper.readValue<SearchResult>(it)
            if (searchResult.status == 200) {
                Result.of(searchResult.results)
            } else {
                Result.error(Exception(searchResult.message))
            }
        }
    }
}