package com.elfeky.speedo_transfer.ui.authentication.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elfeky.speedo_transfer.R
import com.elfeky.speedo_transfer.ui.theme.BlackFieldColor
import com.elfeky.speedo_transfer.ui.theme.GrayG10
import com.elfeky.speedo_transfer.ui.theme.GreyFields
import com.elfeky.speedo_transfer.ui.theme.RedP300
import com.elfeky.speedo_transfer.ui.theme.RedP50

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryTextField(modifier: Modifier = Modifier, onclick: (String) -> Unit) {

    var countryName by remember {
        mutableStateOf("")
    }

    var isBottomSheetVisible by remember { mutableStateOf(false) }
    var state = rememberModalBottomSheetState()


    Text(text = "Country", color = BlackFieldColor, fontSize = 16.sp)
    OutlinedTextField(
        value = countryName,
        onValueChange = { countryName = it },
        enabled = false,
        readOnly = true,
        colors = OutlinedTextFieldDefaults.colors(
            disabledBorderColor = GreyFields,
            disabledContainerColor = GrayG10
        ),
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

    var selectedCountry by remember { mutableStateOf<Int?>(null) }



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
                        CountryItem(
                            country = country,
                            isSelected = selectedCountry == countries.indexOf(country),
                            onSelect = { selectedCountry = countries.indexOf(country) }
                        ) {
                            onclick(it)
                            countryName = it

                        }
                    }


                }


            },
            onDismissRequest = { isBottomSheetVisible = false }
        )
    }


}


@Composable
fun CountryItem(
    country: String,
    isSelected: Boolean,
    onSelect: () -> Unit,
    onCardClick: (String) -> Unit,

    ) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(vertical = 8.dp)
            .background(if (isSelected) RedP50 else Color.Transparent)
            .clickable {
                onCardClick(country)
                onSelect()
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = country,
            style = MaterialTheme.typography.bodyLarge
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



