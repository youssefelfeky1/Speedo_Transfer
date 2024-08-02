import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.elfeky.speedo_transfer.R
import com.elfeky.speedo_transfer.ui.main_screen.transfer.MainTopAppBar
import com.elfeky.speedo_transfer.ui.theme.GrayG0
import com.elfeky.speedo_transfer.ui.theme.GrayG100
import com.elfeky.speedo_transfer.ui.theme.GrayG200
import com.elfeky.speedo_transfer.ui.theme.GrayG40
import com.elfeky.speedo_transfer.ui.theme.RedP300
import com.elfeky.speedo_transfer.ui.theme.RedP50
import com.elfeky.speedo_transfer.util.Constants.ADD_CARDS

@Composable
fun SelectCurrencyScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    var selectedCountry by remember { mutableStateOf<Int?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.White,
                        Color(0xFFFFEAEE)
                    )
                )
            )
            .padding(horizontal = 16.dp, vertical = 44.dp),
        verticalArrangement = Arrangement.Top
    ) {
        MainTopAppBar(title = "Select Currency") {
            navController.popBackStack()
        }
        Spacer(modifier = Modifier.height(42.dp))

        LazyColumn(
            modifier = modifier.padding(horizontal = 16.dp)
        ) {
            items(6) { index ->
                CountrySelectedItem(
                    countryName = "United States",
                    isSelected = selectedCountry == index,
                    onSelect = { selectedCountry = index }
                )
                HorizontalDivider(color = GrayG40)
            }
        }

        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = { navController.navigate(ADD_CARDS) },
            enabled = selectedCountry != null,
            colors = ButtonDefaults.buttonColors(
                containerColor = if (selectedCountry != null) RedP300 else GrayG100
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(6.dp)
        ) {
            Text(
                text = "Get Started",
                color = GrayG0,
                fontSize = 16.sp,
            )
        }
        Spacer(modifier = Modifier.height(100.dp))
    }
}

@Composable
private fun CountrySelectedItem(
    countryName: String,
    isSelected: Boolean,
    onSelect: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clickable { onSelect() }
            .background(if (isSelected) RedP50 else Color.Transparent),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.united_states),
            contentDescription = "Country Flag",
            modifier = Modifier.size(20.dp),
        )
        Text(
            text = countryName,
            style = MaterialTheme.typography.labelSmall,
            color = GrayG200,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(start = 8.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        if (isSelected) {
            Icon(
                painter = painterResource(id = R.drawable.checkcorrect),
                contentDescription = "Selected",
                tint = RedP300,
                modifier = Modifier
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SelectCurrencyScreenPreview() {
    SelectCurrencyScreen(navController = rememberNavController())
}
