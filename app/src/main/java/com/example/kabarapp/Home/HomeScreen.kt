package com.loc.newsapp.presentation.home

import ArticlesList
import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import com.example.kabarapp.Data.Local.Article
import com.example.kabarapp.Home.HomeViewModel
import com.example.kabarapp.R
import com.loc.newsapp.presentation.common.SearchBar


@Composable
fun HomeScreen(articles: LazyPagingItems<Article>, navigateToSearch:() -> Unit , navigateToDetails: (Article) -> Unit) {

    val titles by remember {
        derivedStateOf {
            if (articles.itemCount > 10) {
                articles.itemSnapshotList.items
                    .slice(IntRange(start = 0, endInclusive = 9))
                    .joinToString(separator = " \uD83D\uDFE5 ") { it.title }
            } else {
                ""
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 4.dp)
            .statusBarsPadding()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = null,
            modifier = Modifier
                .width(150.dp)
                .height(30.dp)
                .padding(horizontal = 4.dp)
        )

        Spacer(modifier = Modifier.height(4.dp))

        SearchBar(
            modifier = Modifier
                .padding(horizontal = 4.dp)
                .fillMaxWidth(),
            text = "",
            readOnly = true,
            onValueChange = {},
            onSearch = {},
            onClick = {
                navigateToSearch()
            }
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = titles, modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp)
                .basicMarquee(), fontSize = 12.sp,
            color = colorResource(id = R.color.placeholder)
        )

        Spacer(modifier = Modifier.height(4.dp))

        ArticlesList(
            modifier = Modifier.padding(horizontal = 3.dp),
            articles = articles,
            onClick = {
                navigateToDetails(it)
            }
        )
    }
}