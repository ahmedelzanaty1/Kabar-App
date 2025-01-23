import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kabarapp.ui.theme.KabarAppTheme

fun Modifier.shimmerEffect(): Modifier = composed {
    val transition = rememberInfiniteTransition()
    val alpha = transition.animateFloat(
        initialValue = 0.2f,
        targetValue = 0.9f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000),
            repeatMode = RepeatMode.Reverse
        )
    )
    graphicsLayer(alpha = alpha.value)
}
@Composable
fun Articleshimmer(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(MaterialTheme.shapes.medium)
                .shimmerEffect() // تأكد من تطبيق الشيمر فقط هنا
        )
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .height(100.dp)
        ) {
            // الشيمر فقط في هذا العنصر حيث تحتاجه
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .padding(horizontal = 5.dp)
                    .shimmerEffect()
            )
            // لا داعي لتكرار التأثير هنا في عناصر غير ضرورية
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .padding(horizontal = 5.dp)
                        .height(15.dp)
                        .shimmerEffect()
                )
            }
        }
    }
}


@Preview(
    showBackground = true
)
@Composable
private fun shimmerprev() {
    KabarAppTheme {
        Articleshimmer()
    }
}
