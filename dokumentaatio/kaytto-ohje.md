# Käyttöohje

_Huomio: käyttöliittymä ja miinaharavapelin perustoiminnot ovat valmiista miinaharavapohjasta peräisin, minä olen toteuttanut botin ja sen toimintalogiikan._

## Botin käyttö käyttöliittymässä

Ohjelman käynnistettäessä aukeaa näkymä päävalikkoon, josta käyttäjä voi valita pelikentän koon. Kun pelikenttä on valittu, aukeaa pelinäkymä (kuvassa koko intermediate):

<img src="https://github.com/hackinen/Miinaharavaratkaisija/blob/master/dokumentaatio/misc/pelinakyma.png" width="400">

Pelinäkymässä näkyy yläreunassa napit "Help (bot)" ja "Bot game". "Bot game"-napin toiminto on minun toteuttamaani, kaikki muu on valmiista projektipohjasta peräisin. Painamalla "Help (bot)"-napista ehdottaa botti mahdollisia seuraavia siirtoja (mutta ei vielä, koska en ole ehtinyt sitä tehdä). Painamalla "Bot game"-napista alkaa botti ratkaisemaan peliä itsenäisesti. Bottipelin voi aloittaa ainoastaan silloin, kun ei itse ole vielä tehnyt minkäänlaisia muutoksia pelikenttään.

Huom: en ole vielä toteuttanut "Help (bot)"-nappiin sen toiminnallisuutta.

Botin käyttö ei vaadi sen kummempia toimenpiteitä tämän jälkeen käyttäjältä. Käyttäjä voi halutessaan muuttaa bottianimaation nopeutta ikkunan alareunasta löytyvällä sliderilla.
