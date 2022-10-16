package com.example.movieandroidtv

import android.os.Bundle
import android.view.View
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.HeaderItem
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ListRowPresenter
import com.example.movieandroidtv.model.Movie
import com.example.movieandroidtv.ui.adapter.CardPresenter

/**
 * @author : Mingaleev D
 * @data : 16/10/2022
 */

class MainFragment : BrowseSupportFragment() {
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    title = getString(R.string.app_name)

    val rowsAdapter = ArrayObjectAdapter(ListRowPresenter())


    (1..5).forEach { categoryId ->
      val categoryTitle = "Category $categoryId"

      val listRowAdapter = ArrayObjectAdapter(CardPresenter())
      listRowAdapter.addAll(0, (1..10).map {
        Movie(
          "Title $it",
          2020,
          "https://loremflickr.com/176/313/cat?lock=$it"
        )

      })

      val header = HeaderItem(categoryId.toLong(), categoryTitle)
      rowsAdapter.add(ListRow(header, listRowAdapter))
    }
    adapter = rowsAdapter
  }
}

