package com.example.ejemplo1composeridgs903

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape

private val tarjetas:List<PersonajeTarjeta> =listOf(
    PersonajeTarjeta("Goku","El protagonista de la serie, conocido por su gran poder y personalidad amigable. Originalmente enviado a la Tierra como un infante volador con la misión de conquistarla. Sin embargo, el caer por un barranco le proporcionó un brutal golpe que si bien casi lo mata, este alteró su memoria y anuló todos los instintos violentos de su especie, lo que lo hizo crecer con un corazón puro y bondadoso, pero conservando todos los poderes de su raza. No obstante, en la nueva continuidad de Dragon Ball se establece que él fue enviado por sus padres a la Tierra con el objetivo de sobrevivir a toda costa a la destrucción de su planeta por parte de Freeza. Más tarde, Kakarot, ahora conocido como Son Goku, se convertiría en el príncipe consorte del monte Fry-pan y líder de los Guerreros Z, así como el mayor defensor de la Tierra y del Universo 7, logrando mantenerlos a salvo de la destrucción en innumerables ocasiones, a pesar de no considerarse a sí mismo como un héroe o salvador."),
    PersonajeTarjeta("Vegeta","Príncipe de los Saiyans, inicialmente un villano, pero luego se une a los Z Fighters. A pesar de que a inicios de Dragon Ball Z, Vegeta cumple un papel antagónico, poco después decide rebelarse ante el Imperio de Freeza, volviéndose un aliado clave para los Guerreros Z. Con el paso del tiempo llegaría a cambiar su manera de ser, optando por permanecer y vivir en la Tierra para luchar a su lado contra las inminentes adversidades que superar. Junto con Piccolo, él es de los antiguos enemigos de Goku que ha evolucionando al pasar de ser un villano y antihéroe, a finalmente un héroe a lo largo del transcurso de la historia, convirtiéndose así en el deuteragonista de la serie."),
    PersonajeTarjeta("Freezer","Freezer es el tirano espacial y el principal antagonista de la saga de Freezer."),
    PersonajeTarjeta("Gohan","Son Gohanda en su tiempo en España, o simplemente Gohan en Hispanoamérica, es uno de los personajes principales de los arcos argumentales de Dragon Ball Z, Dragon Ball Super y Dragon Ball GT. Es un mestizo entre saiyano y humano terrícola. Es el primer hijo de Son Goku y Chi-Chi, hermano mayor de Son Goten, esposo de Videl y padre de Pan."),
    PersonajeTarjeta("Krillin","Amigo cercano de Goku y guerrero valiente, es un personaje del manga y anime de Dragon Ball. Es uno de los principales discípulos de Kame-Sen'nin, Guerrero Z, y el mejor amigo de Son Goku. Es junto a Bulma uno de los personajes de apoyo principales de Dragon Ball, Dragon Ball Z y Dragon Ball Super. Aparece en Dragon Ball GT como personaje secundario. En el Arco de Majin Boo, se retira de las artes marciales, optando por formar una familia, como el esposo de la Androide Número 18 y el padre de Marron."),
    PersonajeTarjeta("Majin Buu","También conocido como Boo original, es la forma original y pura de Majin-Boo, y la última forma de Boo que aparece en Dragon Ball Z."),
    PersonajeTarjeta("Bills","Dios de la Destrucción Beerus, conocido también como Beers, o Bills en Hispanoamérica e inicialmente en España[1], es un personaje que fue introducido en la película Dragon Ball Z: La batalla de los dioses, donde es el antagonista principal de la película, y que aparece en el manga y anime de Dragon Ball Super como un personaje principal. Ocupa el puesto de Dios de la Destrucción de todo el Universo 7 siendo el lugar donde se desarrolla la historia de Dragon Ball."),
    PersonajeTarjeta("Jiren","Jiren es un poderoso luchador del Universo 11 y uno de los oponentes más formidables en el torneo."),
    PersonajeTarjeta("Android 18","Es la hermana melliza del Androide Número 17 y una \\\"androide\\\" creada a partir de una base humana por el Dr. Gero con el único fin de destruir a Goku."),
    PersonajeTarjeta("Broly","Broly es un Saiyajin que posee un poder gigantesco e incontrolable, el cual se manifiesta en toda su magnitud cuando se convierte en el Super Saiyajin Legendario. Incluso cuando apenas era un bebé su nivel de poder alcanzaba cifras inmensas que provocaban asombro y preocupación entre los de su raza.")
)
data class PersonajeTarjeta(val title:String, val body:String)


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ejemplo1ComposerIDGS903Theme {
                Tarjeta(tarjetas)
            }
        }
    }
}

@Composable
fun Tarjeta(personajes: List<PersonajeTarjeta>){
    LazyColumn {
        items (personajes) { personaje ->
            MyPersonajes(personaje)
        }
    }
}

@Composable
fun MyPersonajes(personaje: PersonajeTarjeta){
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(contentColor = Color.White)
    ) {
        Row {
            ImagenHeroe()
            Personajes(personaje)
        }
    }
}

@Composable
fun Personaje(name: String, color: Color, style: TextStyle){
   Text(text=name)
}

@Composable
fun Personajes(personaje: PersonajeTarjeta){
    Column{
        Personaje(personaje.title,
            MaterialTheme.colorScheme.primary,
            MaterialTheme.typography.headlineMedium)
        Personaje(personaje.body,
            MaterialTheme.colorScheme.onBackground,
            MaterialTheme.typography.bodyLarge)
    }
}

@Composable
fun ImagenHeroe(){
    Image(
        painter = painterResource(R.drawable.goku),
        contentDescription = "Goku",
        modifier = Modifier
            .padding(16.
            dp)
            .size(100.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.tertiary)
    )
}

@Preview
@Composable
fun GreetingPreview(){
    Tarjeta(tarjetas)

}