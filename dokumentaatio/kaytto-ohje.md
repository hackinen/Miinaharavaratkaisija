# Käyttöohje

_Huomio: käyttöliittymä ja miinaharavapelin perustoiminnot ovat valmiista miinaharavapohjasta peräisin, minä olen toteuttanut botin toimintalogiikan._

## Botin käyttö käyttöliittymässä

Ohjelman käynnistettäessä aukeaa näkymä päävalikkoon, josta käyttäjä voi valita pelikentän koon. Kun pelikenttä on valittu, aukeaa pelinäkymä (kuvassa koko intermediate):

<img src="https://github.com/hackinen/Miinaharavaratkaisija/blob/master/dokumentaatio/misc/pelinakyma.png" width="400">

Pelinäkymässä näkyy yläreunassa napit "Help (bot)" ja "Bot game". Näiden nappien toiminnot ovat minun toteuttamaani, kaikki muu on valmiista projektipohjasta peräisin. Painamalla "Help (bot)"-napista ehdottaa botti mahdollista seuraavaa siirtoa (tätä voi siis käyttää, kun itse pelaa peliä). Painamalla "Bot game"-napista alkaa botti ratkaisemaan peliä itsenäisesti. Bottipelin voi aloittaa ainoastaan silloin, kun ei itse ole vielä tehnyt minkäänlaisia muutoksia pelikenttään.

Botin käyttö ei vaadi sen kummempia toimenpiteitä tämän jälkeen käyttäjältä. Käyttäjä voi halutessaan muuttaa bottianimaation nopeutta ikkunan alareunasta löytyvällä sliderilla.

### Projektipohjan käyttöohje

Tarkemmin miinaharavapelin käyttöohjeita ja erityisesti gradle-projektin käyttöön liittyviä ohjeita löytyy valmiin projektipohjan omasta [käyttöohjeesta](https://github.com/TiraLabra/minesweeper/blob/master/documentation/Beginners-Guide.md).
