package com.example.kabarapp.OnBoarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Indicator(modifier: Modifier = Modifier,
              pagesize: Int,
              selectedPage: Int,
              selectedColor: Color = MaterialTheme.colorScheme.primary,
              unselectedColor: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
              ) {
    Row(modifier = Modifier , horizontalArrangement = Arrangement.SpaceBetween) {
        repeat(pagesize){ page ->
            Box(modifier = Modifier.size(12.dp).clip(CircleShape).
            background(if (page == selectedPage) selectedColor else unselectedColor)){


            }

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun indecatorprev() {
    Indicator(pagesize = 3, selectedPage = 1)


}