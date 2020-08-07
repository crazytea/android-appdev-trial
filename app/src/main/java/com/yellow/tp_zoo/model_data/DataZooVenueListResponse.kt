package com.yellow.tp_zoo.model_data

class DataZooVenueListResponse(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<DataZooVenueItem>,
    val sort: String
)
