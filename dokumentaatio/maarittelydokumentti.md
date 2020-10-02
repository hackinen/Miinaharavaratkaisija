# Määrittelydokumentti

Opiskelen tietojenkäsittelytieteen kandiohjelmassa ja tämän kurssin aikana on tarkoitus toteuttaa suomen/englannin kielellä Java-ohjelma (ohjelma englanniksi, sillä miinaharavapohjan ohjelmakoodi oli englanniksi, mutta dokumentaatio suomeksi), joka ratkaisee sille annetun miinaharavapelin. Valitsin tämän aiheen, sillä toteutin ohjelmistotekniikan kurssilla [Miinaharavan](https://github.com/hackinen/ot-harjoitustyo), joten sen ratkaisija tuntui luonnolliselta jatkeelta.

Projektissa on käytetty valmista [pohjaa](https://github.com/TiraLabra/minesweeper), joten koodin javadociin on merkitty, mitkä osat ohjelmasta on minun tekemää, ja mitkä osat valmista pohjaa.

Ohjelmalle ei anneta syötteenä mitään botin ratkaistessa peliä, vaan peli arpoo botille kentän, ja botti ratkaisee sen. Mikäli käytetään bottia vain vinkkejen antajana, annetaan "periaatteessa" botille syötteenä nykyinen pelitilanne painamalla vinkki-nappulaa, mutta lähtökohtaisesti siis ei ohjelma tarvitse käyttäjältä syötteitä, kun käytetään miinaharavaratkaisijaa.

Työn laajuudessa on tarkoitus päästä siihen asti, että ratkaisija kykenee ratkaisemaan sille annetun (kohtuullisen kokoisen) miinaharavapelin aina siihen asti, kunnes sen on pakko arvata.


## Backtracking-algoritmi ja sen aikavaativuus

Tavallisten helppojen päättelyiden lisäksi on ohjelmassa käytetty rekursiivista backtracking-algoritmia. Algoritmin perusajatuksena on käydä läpi "reunaruutujen" (avaamattomat ruudut, jotka ovat jo avattujen ruutujen reunassa) listaa ja jokaiselle ruudulle suorittaa backtracking-algoritmi niin, että etsitään sellaista liputettujen ja avattujen reunaruutujen yhdistelmää, jonka perusteella voidaan varmasti päätellä, voiko tämän aloitusruudun liputtaa tai avata. Algoritmia suoritetaan niin kauan, kunnes varma siirto löytyy. Jos loppuun päästyä ei varmaa siirtoa ole löytynyt, on pelitilanne sellainen, että botinkin on pakko arvata.

Kuten voi päätellä, algoritmi vie pahimmassa tapauksessa _todella_ paljon aikaa, sillä kun mielenkiitoisia reunaruutuja on _n_ kappaletta ja nämä käydään läpi yllä kuvatulla tavalla, saadaan aikavaativuudeksi _O(n*2^n)_. Ensimmäinen termi _n_ tulee kaikkien reunaruutujen kokeilemisesta backtrackingin aloitusruuduksi ja termi _2^n_ siitä, että jokaista aloitusruutua varten on käytävä läpi _2^n_ yhdistelmää näitä reunaruutuja, sillä jokainen ruutu voidaan joko liputtaa tai avata.

 Aikaavaativuus onkin sen verran suuri, että ei ole mielekästä ruveta ratkomaan todella suuria kenttiä. Miinaharavapelissä olevat kolme eri kokoa kuitenkin ratkeavat, kaksi ensimmäistä vielä järkevästi, mutta viimeisessä saattaa pahan paikan tullen kulua todella paljon aikaa yhden siirron päättelyyn backtracking-algoritmilla.


## Tietorakenteet ja tilavaativuus

Miinaharavaratkaisijassa pärjäsi pitkälti tavalisella taulukolla, mutta algoritmia varten toteutin listaolion _ListOfPairs_. _Pair_ on puolestaan projektipohjasta peräisin oleva Olio, jota ohjelmassa käytetään peliruudukon koordinaattien tallentamiseen.

Tilavaativuuden voidaan karkeasti arvioida olevan luokkaa _O(m)_, missä _m_ on ruutujen lukumäärä pelikentässä, sillä _ListOfPairs_-listalla voi olla enintään m paria. Myöskin muut tietorakenteet (eli tavalliset taulukot) ovat enintään peliruudukon kokoisia.
