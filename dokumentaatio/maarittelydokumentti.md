# Määrittelydokumentti

Opiskelen tietojenkäsittelytieteen kandiohjelmassa ja tämän kurssin aikana on tarkoitus toteuttaa suomen kielellä Java-ohjelma, joka ratkaisee sille annetun miinaharavapelin. Valitsin tämän aiheen, sillä toteutin ohjelmistotekniikan kurssilla [Miinaharavan](https://github.com/hackinen/ot-harjoitustyo), joten sen ratkaisija tuntui luonnolliselta jatkeelta.

Todennäköisesti ohjelmalle tullaan antamaan syötteenä kentän koko ja esimerkiksi miinojen määrä, jonka pohjalta arvotaan pelattava kenttä, jonka jälkeen ratkaisija ratkaisee tämän.

Työn laajuudessa on tarkoitus päästä siihen asti, että ratkaisija kykenee ratkaisemaan minkä tahansa sille annetun miinaharavapelin, mikäli se on ratkaistavissa ilman arvauksia (ja poislukien erittäin suurikokoiset kentät, sillä aikavaativuus voi tulla tässä vastaan).

## Aikavaativuus

Aikavaativuus tulee erittäin todennäköisesti olemaan sen verran suuri, että vaikutuksen alkaa näkemään jo isommissa kentissä. Tämän takia ratkaisijan toiminta tulee hyvin todennäköisesti rajoittumaan pienempiin kenttiin.
