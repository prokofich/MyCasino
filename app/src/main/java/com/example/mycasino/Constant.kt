package com.example.mycasino

const val APP_PREFERENCES = "APP_PREFERENCES"
const val LAST_DAY = "LAST_DAY"
const val MY_CASH = "MY_CASH"
const val BUBNI = "BUBNI"
const val KRESTI = "KRESTI"
const val CHERVI = "CHERVI"
const val PIKI = "PIKI"
const val RECORD_GUESS_CARD = "RECORD_GUESS_CARD"
const val RECORD_MORELESS_CARD = "RECORD_MORELESS_CARD"
const val ID = "ID"

var listMasti = listOf(BUBNI, KRESTI, CHERVI, PIKI)

var listChervi = listOf("6chervi.png","7chervi.png","8chervi.png",
                        "9chervi.jpg","10chervi.png","waletchervi.png",
                        "damachervi.png","kingchervi.png","tuzchervi.png")

var listBubi = listOf("6bubi.jpg","7bubi.png","8bubi.png",
                      "9bubi.jpg","10bubi.png","waletbubi.jpg",
                      "damabubi.png","kingbubi.png","tuzbubi.png")

var listPiki = listOf("6piki.png","7piki.jpg","8piki.png",
                      "9piki.png","10piki.png","waletpiki.png",
                      "damapiki.jpg","kingpiki.png","tuzpiki.jpg")

var listKresti = listOf("6kresti.jpg","7kresti.jpg","8kresti.png",
                        "9kresti.png","10kresti.png","waletkresti.png",
                        "damakresti.png","kingkresti.png","tuzkresti.png")

var mapAllCard = mapOf<String,Int>("6chervi.png" to 6,"7chervi.png" to 7,"8chervi.png" to 8,
                                   "9chervi.jpg" to 9,"10chervi.png" to 10 ,"waletchervi.png" to 11,
                                   "damachervi.png" to 12,"kingchervi.png" to 13,"tuzchervi.png" to 14,
                                   "6bubi.jpg" to 6,"7bubi.png" to 7,"8bubi.png" to 8,
                                   "9bubi.jpg" to 9,"10bubi.png" to 10,"waletbubi.jpg" to 11,
                                   "damabubi.png" to 12,"kingbubi.png" to 13,"tuzbubi.png" to 14,
                                   "6piki.png" to 6,"7piki.jpg" to 7,"8piki.png" to 8,
                                   "9piki.png" to 9,"10piki.png" to 10 ,"waletpiki.png" to 11,
                                   "damapiki.jpg" to 12,"kingpiki.png" to 13,"tuzpiki.jpg" to 14,
                                   "6kresti.jpg" to 6,"7kresti.jpg" to 7,"8kresti.png" to 8,
                                   "9kresti.png" to 9,"10kresti.png" to 10,"waletkresti.png" to 11,
                                   "damakresti.png" to 12,"kingkresti.png" to 13,"tuzkresti.png" to 14)

var listAllCard = listOf("6chervi.png","7chervi.png","8chervi.png",
                                   "9chervi.jpg" ,"10chervi.png","waletchervi.png",
                                   "damachervi.png","kingchervi.png","tuzchervi.png",
                                   "6bubi.jpg","7bubi.png","8bubi.png",
                                   "9bubi.jpg","10bubi.png","waletbubi.jpg",
                                   "damabubi.png","kingbubi.png","tuzbubi.png",
                                   "6piki.png","7piki.jpg","8piki.png",
                                   "9piki.png","10piki.png","waletpiki.png",
                                   "damapiki.jpg","kingpiki.png","tuzpiki.jpg",
                                   "6kresti.jpg","7kresti.jpg","8kresti.png",
                                   "9kresti.png","10kresti.png","waletkresti.png",
                                   "damakresti.png","kingkresti.png","tuzkresti.png")

//var listNumberCard = listOf(0,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35)


lateinit var MAIN:MainActivity