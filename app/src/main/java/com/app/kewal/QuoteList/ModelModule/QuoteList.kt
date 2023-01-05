package com.app.kewal.QuoteList.ModelModule

data class QuoteList(val count: Int = 0,
                     val totalPages: Int = 0,
                     val lastItemIndex: Int = 0,
                     val page: Int = 0,
                     val totalCount: Int = 0,
                     val results: ArrayList<ResultsItem>?)

data class ResultsItem(val authorSlug: String = "",
                       val author: String = "",
                       val length: Int = 0,
                       val dateModified: String = "",
                       val Id: String = "",
                       val content: String = "",
                       val dateAdded: String = "",
                       val tags: List<String>?)