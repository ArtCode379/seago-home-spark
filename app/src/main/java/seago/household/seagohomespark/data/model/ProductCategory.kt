package seago.household.seagohomespark.data.model

import androidx.annotation.StringRes
import seago.household.seagohomespark.R

enum class ProductCategory(@field:StringRes val titleRes: Int) {
    HOME(R.string.kgugn_category_home),
    STATIONERY(R.string.kgugn_category_stationery),
    ACCESSORIES(R.string.kgugn_category_accessories),
    GIFTS(R.string.kgugn_category_gifts),
}

