package com.example.kabarapp.OnBoarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kabarapp.R
import com.example.kabarapp.ui.theme.KabarAppTheme

@Composable
fun PagesView(modifier: Modifier = Modifier , pages: Pages) {
    Column (modifier = modifier){
        Image(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(.6F)
            ,painter = painterResource(id = pages.icon)
            , contentDescription = null
        ,contentScale = ContentScale.Crop)
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = pages.title , style = MaterialTheme.typography.
        displaySmall.copy(fontWeight = FontWeight.Bold) ,
            modifier = Modifier.padding(horizontal = 30.dp)
        , color = colorResource(id = R.color.display_small))
        Text(text = pages.description , style = MaterialTheme.typography.
        bodyMedium ,
            modifier = Modifier.padding(horizontal = 30.dp)
            , color = colorResource(id = R.color.text_medium))
    }

}

@Preview
@Composable
private fun OnBoardingPreview() {
    KabarAppTheme {
        PagesView(pages = pages[0])

    }

}