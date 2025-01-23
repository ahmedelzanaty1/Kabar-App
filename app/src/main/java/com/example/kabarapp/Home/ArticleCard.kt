package com.example.kabarapp.Home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.example.kabarapp.Data.Api.Article
import com.example.kabarapp.R

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ArticleCard(
    modifier: Modifier = Modifier,
    article: Article
    , onclick: () -> Unit, onClick: () -> Unit
) {
    Row(modifier = modifier.clickable { onclick() }) {
        GlideImage(
            modifier = Modifier.size(100.dp).clip(
                MaterialTheme.shapes.medium
            ),
            model = article.urlToImage,
            contentDescription = ""
            ,contentScale = androidx.compose.ui.layout.ContentScale.Crop
            , loading = placeholder(
                R.drawable.logo
            )
        )
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = 3.dp)
                .height(100.dp)
        ){
            Text(
                text = article.title,
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(id = R.color.text_title)
                ,maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Row (verticalAlignment = androidx.compose.ui.Alignment.CenterVertically){
                Text(
                    text = article.source.name,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = colorResource(id = R.color.body)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Icon(
                    painter = painterResource(id = R.drawable.ic_time),
                    contentDescription = "",
                    modifier = Modifier.size(18.dp),
                    tint = colorResource(id = R.color.body))
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = article.publishedAt,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = colorResource(id = R.color.body)
                )
            }
        }
    }

}