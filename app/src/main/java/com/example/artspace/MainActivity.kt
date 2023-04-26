package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtSpace()
                }
            }
        }
    }
}

@Composable
fun ArtSpace() {
    val (pieceNumber, setPieceNumber) = remember { mutableStateOf(1) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ArtImageAndDesc(pieceNumber)
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
        NavButtons(pieceNumber, setPieceNumber)
    }
}
@Composable
fun ArtImageAndDesc(pieceNumber: Int) {

    val imageResource = when (pieceNumber) {
        1 -> R.drawable.mona_lisa
        2 -> R.drawable.girl_with_a_pearl_earring
        3 -> R.drawable.the_starry_night
        4 -> R.drawable.the_kiss
        5 -> R.drawable.the_birth_of_venus
        6 -> R.drawable.whistlers_mother
        7 -> R.drawable.the_arnolfini_portrait
        8 -> R.drawable.the_garden_of_earthly_delights
        9 -> R.drawable.a_sunday_afternoon_on_the_island_of_la_grande_jatte
        10 -> R.drawable.les_demoiselles_davignon
        11 -> R.drawable.the_harvesters
        12 -> R.drawable.le_d_jeuner_sur_lherbe
        13 -> R.drawable.composition_with_red_blue_and_yellow
        14 -> R.drawable.the_family_of_king_philip_iv
        else -> R.drawable.guernica
    }

    val titleResource = when (pieceNumber) {
        1 -> R.string.mona_lisa
        2 -> R.string.girl_with_a_pearl_earring
        3 -> R.string.the_starry_night
        4 -> R.string.the_kiss
        5 -> R.string.the_birth_of_venus
        6 -> R.string.whistlers_mother
        7 -> R.string.the_arnolfini_portrait
        8 -> R.string.the_garden_of_earthly_delights
        9 -> R.string.a_sunday_afternoon_on_the_island_of_la_grande_jatte
        10 -> R.string.les_demoiselles_davignon
        11 -> R.string.the_harvesters
        12 -> R.string.le_d_jeuner_sur_lherbe
        13 -> R.string.composition_with_red_blue_and_yellow
        14 -> R.string.the_family_of_king_philip_iv
        else -> R.string.guernica
    }

    val artistResource = when (pieceNumber) {
        1 -> R.string.mona_lisa_artist
        2 -> R.string.girl_with_a_pearl_earring_artist
        3 -> R.string.the_starry_night_artist
        4 -> R.string.the_kiss_artist
        5 -> R.string.the_birth_of_venus_artist
        6 -> R.string.whistlers_mother_artist
        7 -> R.string.the_arnolfini_portrait_artist
        8 -> R.string.the_garden_of_earthly_delights_artist
        9 -> R.string.a_sunday_afternoon_on_the_island_of_la_grande_jatte_artist
        10 -> R.string.les_demoiselles_davignon_artist
        11 -> R.string.the_harvesters_artist
        12 -> R.string.le_d_jeuner_sur_lherbe_artist
        13 -> R.string.composition_with_red_blue_and_yellow_artist
        14 -> R.string.the_family_of_king_philip_iv_artist
        else -> R.string.guernica_artist
    }

    Column(
        modifier = Modifier
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = pieceNumber.toString()
        )
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = stringResource(id = titleResource),
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .height(110.dp)
                .padding(horizontal = 16.dp)
                .align(Alignment.CenterHorizontally),
            fontSize = 28.sp,
            fontWeight = Normal,
            textAlign = TextAlign.Center
        )
        Text(
            text = stringResource(id = artistResource),
            modifier = Modifier
                .padding(vertical = 28.dp)
                .padding(horizontal = 16.dp)
                .align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.h1,
            fontSize = 18.sp,
            fontWeight = Bold,
            textAlign = TextAlign.Center
        )
    }

}

@Composable
fun NavButtons(pieceNumber: Int, onPieceNumberChanged: (Int) -> Unit) {
    Row() {
        Button(
            onClick = {
                if (pieceNumber > 1) {
                    onPieceNumberChanged(pieceNumber - 1)
                }
            },
            modifier = Modifier
                .padding(36.dp)
                .size(width = 120.dp, height = 60.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Yellow
            )
        ) {
            Text(
                text = stringResource(R.string.previous),
                modifier = Modifier,
                fontSize = 17.sp,
                fontWeight = Bold
            )
        }
        Button(
            onClick = {
                if (pieceNumber < 15) {
                    onPieceNumberChanged(pieceNumber + 1)
                }
            },
            modifier = Modifier
                .padding(36.dp)
                .size(width = 120.dp, height = 60.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Yellow
            )
        ) {
            Text(
                text = stringResource(R.string.next),
                modifier = Modifier,
                fontSize = 17.sp,
                fontWeight = Bold
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpace()
    }
}