package com.github.khanamura.p1020268.domain

data class SearchResult(
  val message: String?,
  val results: List<Address>,
  val status: Int)

data class Address(
  val address1: String,
  val address2: String,
  val address3: String,
  val kana1: String,
  val kana2: String,
  val kana3: String,
  val prefcode: String,
  val zipcode: String
)