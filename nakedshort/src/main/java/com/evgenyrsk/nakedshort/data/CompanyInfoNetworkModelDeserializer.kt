package com.evgenyrsk.nakedshort.data

/**
 * @author Evgeny Rasskazov
 */
//class CompanyInfoNetworkModelDeserializer() : JsonDeserializer<CompanyInfoNetworkModel> {
//
//    private val gson: Gson = GsonBuilder()
//        .create()
//
//    override fun deserialize(
//        json: JsonElement?,
//        typeOfT: Type?,
//        context: JsonDeserializationContext?
//    ): CompanyInfoNetworkModel? {
//        val jsonObject = json?.asJsonObject ?: return null
//
//        val tickerName = jsonObject.get("namets").asString
//
//        val historicalShortVolJsonArray = jsonObject.get("historicalShortVol").asJsonArray
//        val nakedShortPercent = historicalShortVolJsonArray.get(0).asJsonObject.get("8").asFloat
//
//        val chartDateList = mutableListOf<Date>()
//        val historicalShortVolList = mutableListOf<HistoricalShortVolumeNetworkModel>()
//        historicalShortVolJsonArray.forEach { jsonElement ->
//            val obj = jsonElement.asJsonObject
//            val date = convertDate(obj.get("0").asString)
//            chartDateList.add(date)
//            historicalShortVolList.add(
//                HistoricalShortVolumeNetworkModel(
//                    date = date,
//                    volume = obj.get("5").asString.replace(",", "").toInt(),
//                    shortVolume = obj.get("7").asString.replace(",", "").toInt(),
//                    percentOfVolumeShorted = obj.get("8").asFloat
//                )
//            )
//        }
//
//        val regularDataList = mutableListOf<Int>()
//        jsonObject.get("regularVolArr").asJsonArray.forEach { jsonElement ->
//            regularDataList.add(jsonElement.asInt)
//        }
//
//        val shortDataList = mutableListOf<Int>()
//        jsonObject.get("shortVolArr").asJsonArray.forEach { jsonElement ->
//            shortDataList.add(jsonElement.asInt)
//        }
//
//        return CompanyInfoNetworkModel(
//            ticker = tickerName,
//            nakedShortPercent = nakedShortPercent,
//            dates = chartDateList.reversed(),
//            regularData = regularDataList,
//            shortData =shortDataList
//        )
//    }
//
//    private fun convertDate(dateString: String): Date {
//        val currentDate = Calendar.getInstance()
//
//        val inputDateFormat = SimpleDateFormat("MMM dd", Locale.ENGLISH)
//        val date = Calendar.getInstance().apply {
//            time = inputDateFormat.parse(dateString)
//        }
//
//        // To set proper year for the past date
//        if ((currentDate.get(Calendar.MONTH) - date.get(Calendar.MONTH)) < 0) {
//            date.set(Calendar.YEAR, (currentDate.get(Calendar.YEAR) - 1))
//        } else {
//            date.set(Calendar.YEAR, (currentDate.get(Calendar.YEAR)))
//        }
//        return Date(date.time.time - date.timeZone.rawOffset * 60 * 1000)
//    }
//}
