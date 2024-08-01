package com.elfeky.speedo_transfer.ui.authentication

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberModalBottomSheetState
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.elfeky.speedo_transfer.R
import com.elfeky.speedo_transfer.ui.theme.BlackFieldColor
import com.elfeky.speedo_transfer.ui.theme.BlackText
import com.elfeky.speedo_transfer.ui.theme.DarkRed
import com.elfeky.speedo_transfer.ui.theme.GreyFields
import com.elfeky.speedo_transfer.ui.theme.RoseBottomGradient
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExtendedSignUp(
    name: String,
    email: String,
    password: String,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    var countryName by remember {
        mutableStateOf("")
    }
    var isBottomSheetVisible by remember { mutableStateOf(false) }
    var state = rememberModalBottomSheetState()


    var date by remember {
        mutableStateOf("")
    }
    var isDatePickerShown by remember {
        mutableStateOf(false)
    }


    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.White,
                        RoseBottomGradient
                    )
                )
            )
            .padding(horizontal = 16.dp, vertical = 36.dp),
        verticalArrangement = Arrangement.Top

    ) {


        Spacer(modifier = modifier.padding(20.dp))

        Text(
            text = "Speedo Transfer",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = BlackText,
            modifier = modifier.fillMaxWidth(),
            textAlign = TextAlign.Center


        )
        Spacer(modifier = modifier.padding(28.dp))

        Text(
            text = "Welcome to Banque Misr!",
            color = BlackText,
            modifier = modifier
                .padding(bottom = 6.dp)
                .fillMaxWidth(),
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            textAlign = TextAlign.Center

        )
        Spacer(modifier = modifier.padding(6.dp))


        Text(
            text = "Let’s Complete your Profile",
            color = BlackFieldColor,
            modifier = modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 16.sp,


            )
        Spacer(modifier = modifier.padding(16.dp))

        Text(text = "Country", color = BlackFieldColor, fontSize = 16.sp)




        OutlinedTextField(
            value = countryName,
            onValueChange = { countryName = it },
            enabled = false,
            readOnly = true,
            colors = OutlinedTextFieldDefaults.colors(disabledBorderColor = GreyFields),
            label = { Text(text = "Select your country", color = GreyFields) },
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
                .clickable {
                    isBottomSheetVisible = true
                },

            trailingIcon = {
                IconButton(onClick = { isBottomSheetVisible = true }) {

                    Icon(
                        painter = painterResource(id = R.drawable.chevron_down_1),
                        contentDescription = "select a country ",
                        modifier = modifier.size(24.dp)
                    )
                }
            }


        )



        Text(
            text = "Date Of Brith",
            color = BlackFieldColor,
            fontSize = 16.sp,
            modifier = modifier.padding(bottom = 4.dp)
        )

        OutlinedTextField(
            value = date,
            enabled = false,
            textStyle = TextStyle(color = GreyFields),
            colors = OutlinedTextFieldDefaults.colors(disabledBorderColor = GreyFields),
            onValueChange = { date = it },
            shape = RoundedCornerShape(7.dp),
            label ={ Text(text = "DD/MM/YYYY" , color = GreyFields)},
            modifier = modifier
                .fillMaxWidth(),
            readOnly = true,

            trailingIcon = {

                IconButton(onClick = { isDatePickerShown = true }) {

                    Icon(
                        painter = painterResource(id = R.drawable.calender),
                        contentDescription = "select a date ",
                        modifier = modifier.size(24.dp)
                    )
                }

            }


        )
        if (isDatePickerShown) {
            DatePickerChooser(onConfirm = {
                var c = Calendar.getInstance()
                c.timeInMillis =
                    it.selectedDateMillis!! // calender class is used to convert from ms to date
                var dateFormatter = SimpleDateFormat("dd-MM-yyyy", Locale.US)

                date = dateFormatter.format(c.time)

                isDatePickerShown = false
            }, onDismiss = {
                isDatePickerShown = false
            })
        }


        val countries = listOf(
            "🇦🇫 Afghanistan",
            "🇦🇱 Albania",
            "🇩🇿 Algeria",
            "🇦🇩 Andorra",
            "🇦🇴 Angola",
            "🇦🇬 Antigua and Barbuda",
            "🇦🇷 Argentina",
            "🇦🇲 Armenia",
            "🇦🇺 Australia",
            "🇦🇹 Austria",
            "🇦🇿 Azerbaijan",
            "🇧🇸 Bahamas",
            "🇧🇭 Bahrain",
            "🇧🇩 Bangladesh",
            "🇧🇧 Barbados",
            "🇧🇾 Belarus",
            "🇧🇪 Belgium",
            "🇧🇿 Belize",
            "🇧🇯 Benin",
            "🇧🇹 Bhutan",
            "🇧🇴 Bolivia",
            "🇧🇦 Bosnia and Herzegovina",
            "🇧🇼 Botswana",
            "🇧🇷 Brazil",
            "🇧🇳 Brunei",
            "🇧🇬 Bulgaria",
            "🇧🇫 Burkina Faso",
            "🇧🇮 Burundi",
            "🇰🇭 Cambodia",
            "🇨🇲 Cameroon",
            "🇨🇦 Canada",
            "🇨🇻 Cape Verde",
            "🇨🇫 Central African Republic",
            "🇹🇩 Chad",
            "🇨🇱 Chile",
            "🇨🇳 China",
            "🇨🇴 Colombia",
            "🇰🇲 Comoros",
            "🇨🇬 Congo",
            "🇨🇷 Costa Rica",
            "🇭🇷 Croatia",
            "🇨🇺 Cuba",
            "🇨🇾 Cyprus",
            "🇨🇿 Czech Republic",
            "🇩🇰 Denmark",
            "🇩🇯 Djibouti",
            "🇩🇲 Dominica",
            "🇩🇴 Dominican Republic",
            "🇪🇨 Ecuador",
            "🇪🇬 Egypt",
            "🇸🇻 El Salvador",
            "🇬🇶 Equatorial Guinea",
            "🇪🇷 Eritrea",
            "🇪🇪 Estonia",
            "🇪🇹 Ethiopia",
            "🇫🇯 Fiji",
            "🇫🇮 Finland",
            "🇫🇷 France",
            "🇬🇦 Gabon",
            "🇬🇲 Gambia",
            "🇬🇪 Georgia",
            "🇩🇪 Germany",
            "🇬🇭 Ghana",
            "🇬🇷 Greece",
            "🇬🇩 Grenada",
            "🇬🇹 Guatemala",
            "🇬🇳 Guinea",
            "🇬🇼 Guinea-Bissau",
            "🇬🇾 Guyana",
            "🇭🇹 Haiti",
            "🇭🇳 Honduras",
            "🇭🇺 Hungary",
            "🇮🇸 Iceland",
            "🇮🇳 India",
            "🇮🇩 Indonesia",
            "🇮🇷 Iran",
            "🇮🇶 Iraq",
            "🇮🇪 Ireland",
            "🇮🇱 Israel",
            "🇮🇹 Italy",
            "🇯🇲 Jamaica",
            "🇯🇵 Japan",
            "🇯🇴 Jordan",
            "🇰🇿 Kazakhstan",
            "🇰🇪 Kenya",
            "🇰🇮 Kiribati",
            "🇰🇵 North Korea",
            "🇰🇷 South Korea",
            "🇰🇼 Kuwait",
            "🇰🇬 Kyrgyzstan",
            "🇱🇦 Laos",
            "🇱🇻 Latvia",
            "🇱🇧 Lebanon",
            "🇱🇸 Lesotho",
            "🇱🇷 Liberia",
            "🇱🇾 Libya",
            "🇱🇮 Liechtenstein",
            "🇱🇹 Lithuania",
            "🇱🇺 Luxembourg",
            "🇲🇬 Madagascar",
            "🇲🇼 Malawi",
            "🇲🇾 Malaysia",
            "🇲🇻 Maldives",
            "🇲🇱 Mali",
            "🇲🇹 Malta",
            "🇲🇭 Marshall Islands",
            "🇲🇷 Mauritania",
            "🇲🇺 Mauritius",
            "🇲🇽 Mexico",
            "🇫🇲 Micronesia",
            "🇲🇩 Moldova",
            "🇲🇨 Monaco",
            "🇲🇳 Mongolia",
            "🇲🇪 Montenegro",
            "🇲🇦 Morocco",
            "🇲🇿 Mozambique",
            "🇲🇲 Myanmar",
            "🇳🇦 Namibia",
            "🇳🇷 Nauru",
            "🇳🇵 Nepal",
            "🇳🇱 Netherlands",
            "🇳🇿 New Zealand",
            "🇳🇮 Nicaragua",
            "🇳🇪 Niger",
            "🇳🇬 Nigeria",
            "🇲🇰 North Macedonia",
            "🇳🇴 Norway",
            "🇴🇲 Oman",
            "🇵🇰 Pakistan",
            "🇵🇼 Palau",
            "🇵🇦 Panama",
            "🇵🇬 Papua New Guinea",
            "🇵🇾 Paraguay",
            "🇵🇪 Peru",
            "🇵🇭 Philippines",
            "🇵🇱 Poland",
            "🇵🇹 Portugal",
            "🇶🇦 Qatar",
            "🇷🇴 Romania",
            "🇷🇺 Russia",
            "🇷🇼 Rwanda",
            "🇰🇳 Saint Kitts and Nevis",
            "🇱🇨 Saint Lucia",
            "🇻🇨 Saint Vincent and the Grenadines",
            "🇼🇸 Samoa",
            "🇸🇲 San Marino",
            "🇸🇹 São Tomé and Príncipe",
            "🇸🇦 Saudi Arabia",
            "🇸🇳 Senegal",
            "🇷🇸 Serbia",
            "🇸🇨 Seychelles",
            "🇸🇱 Sierra Leone",
            "🇸🇬 Singapore",
            "🇸🇰 Slovakia",
            "🇸🇮 Slovenia",
            "🇸🇧 Solomon Islands",
            "🇸🇴 Somalia",
            "🇿🇦 South Africa",
            "🇸🇸 South Sudan",
            "🇪🇸 Spain",
            "🇱🇰 Sri Lanka",
            "🇸🇩 Sudan",
            "🇸🇷 Suriname",
            "🇸🇿 Eswatini",
            "🇸🇪 Sweden",
            "🇨🇭 Switzerland",
            "🇸🇾 Syria",
            "🇹🇯 Tajikistan",
            "🇹🇿 Tanzania",
            "🇹🇭 Thailand",
            "🇹🇱 Timor-Leste",
            "🇹🇬 Togo",
            "🇹🇴 Tonga",
            "🇹🇹 Trinidad and Tobago",
            "🇹🇳 Tunisia",
            "🇹🇷 Turkey",
            "🇹🇲 Turkmenistan",
            "🇹🇻 Tuvalu",
            "🇺🇬 Uganda",
            "🇺🇦 Ukraine",
            "🇦🇪 United Arab Emirates",
            "🇬🇧 United Kingdom",
            "🇺🇸 United States",
            "🇺🇾 Uruguay",
            "🇺🇿 Uzbekistan",
            "🇻🇺 Vanuatu",
            "🇻🇦 Vatican City",
            "🇻🇪 Venezuela",
            "🇻🇳 Vietnam",
            "🇾🇪 Yemen",
            "🇿🇲 Zambia",
            "🇿🇼 Zimbabwe"
        )



        if (isBottomSheetVisible) {
            ModalBottomSheet(

                sheetState = state,
                content = {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        items(countries) { country ->
                            CountryItem(country){
                               countryName = it
                                isBottomSheetVisible = false
                            }
                        }


                    }


                },
                onDismissRequest = { isBottomSheetVisible = false }
            )
        }

        Spacer(modifier = modifier.padding(12.dp))


        Button(
            onClick = {
                navController.navigate("Onboard") {
                    popUpTo("ExtendedSignUp/{name}/{email}/{password}") {
                        inclusive = true
                    }
                }
            },
            shape = RoundedCornerShape(7.dp),
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = DarkRed),
            enabled = date.isNotBlank() && countryName.isNotBlank()

            ) {
            Text(text = "Continue")

        }


    }


}

@Composable
fun CountryItem(country: String , onCardClick:(String)-> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onCardClick(country) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = country,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerChooser(onConfirm: (DatePickerState) -> Unit, onDismiss: () -> Unit) {
    val datePickerState =
        rememberDatePickerState(initialSelectedDateMillis = System.currentTimeMillis())
    DatePickerDialog(onDismissRequest = {},
        confirmButton = {
            TextButton(onClick = { onConfirm(datePickerState) }) {
                Text(text = "Ok")

            }


        },
        dismissButton = {

            TextButton(onClick = { onDismiss() }) {
                Text(text = "Cancel")

            }
        }

    ) {
        DatePicker(state = datePickerState)
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ExtendedSignUpPreview() {
    ExtendedSignUp("", "", "", navController = rememberNavController())
}