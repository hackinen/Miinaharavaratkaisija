# Määrittelydokumentti

Opiskelen tietojenkäsittelytieteen kandiohjelmassa ja tämän kurssin aikana on tarkoitus toteuttaa suomen/englannin kielellä Java-ohjelma (ohjelma englanniksi, sillä miinaharavapohjan ohjelmakoodi oli englanniksi, mutta dokumentaatio suomeksi), joka ratkaisee sille annetun miinaharavapelin. Valitsin tämän aiheen, sillä toteutin ohjelmistotekniikan kurssilla [Miinaharavan](https://github.com/hackinen/ot-harjoitustyo), joten sen ratkaisija tuntui luonnolliselta jatkeelta.

Projektissa on käytetty valmista [pohjaa](https://github.com/TiraLabra/minesweeper), joten koodin javadociin on merkitty, mitkä osat ohjelmasta on minun tekemää, ja mitkä osat valmista pohjaa.

Ohjelmalle ei anneta syötteenä mitään botin ratkaistessa peliä, vaan peli arpoo botille kentän, ja botti ratkaisee sen. Mikäli käytetään bottia vain vinkkejen antajana, annetaan "periaatteessa" botille syötteenä nykyinen pelitilanne painamalla vinkki-nappulaa, mutta lähtökohtaisesti siis ei ohjelma tarvitse käyttäjältä syötteitä, kun käytetään miinaharavaratkaisijaa.

Työn laajuudessa on tarkoitus päästä siihen asti, että ratkaisija kykenee ratkaisemaan minkä tahansa sille annetun miinaharavapelin aina siihen asti, kunnes se joutuisi tekemään arvauksen (ja poislukien erittäin suurikokoiset kentät, sillä aikavaativuus voi tulla tässä vastaan).

## Aikavaativuus

Aikavaativuus tulee olemaan luokkaa O(n^2), missä n on ruutujen lukumäärä. Jokainen ruutu tullaan avaamaan kerran, ja jokaisen ruudun avaamista varten tarvitsee pahimmassa tapauksessa käydä läpi n kappaletta ruutuja. Aikaavaativuus onkin sen verran suuri, että ei ole mielekästä ruveta ratkomaan _todella_ suuria kenttiä. Miinaharavapelissä olevat kolme eri kokoa kuitenkin ratkeavat järkevässä ajassa.
