# Toteutusdokumentti

## Projektin rakenne

Miinaharavaratkaisija on toteutettu osaksi valmista [miinaharavapohjaa](https://github.com/TiraLabra/minesweeper). Projekti on toteutettu pakkauksen minesweeper.bot alle, missä omaa ohjelmakoodiani ovat luokat MyBot ja BotLogic.

### Pakkausrakenne

Botti on toteutettu projektipohjaan kokonaan pakkauksen minesweeper.bot alle. Lisäksi on luotu pakkaus minesweeper.structures, joka sisältää projektissa käytetyn titorakenteen ListOfPairs. Kaikki muut projektista löytyvät pakkaukset sisältöineen ovat peräisin projektipohjasta. Tein yhden muutoksen projektipohjaan: vaihdoin botin animaationopeudesta vastaavan liukusäätimen maksimiarvoa hieman suuremmaksi.

<img src="https://github.com/hackinen/Miinaharavaratkaisija/blob/master/dokumentaatio/misc/pakkaukset.jpg" width="750">


## Tilanteet, joissa on pakko arvata

Maininnanarvoista on tosiaan se, että miinaharava on luonteeltaan sellainen peli, että erityisesti isoissa kentissä tulee vastaan tilanteita, joita ei edes algoritmikaan voi päätellä. Usen siis joko heti alussa tai kohtalaisen lopussa päädytään tilanteeseen, jossa bottikin joutuu arvaamaan, sillä yhtäkään siirtoa ei voi päätellä varmaksi.

Tällaista arvaustilannetta ei botin toiminnasta välttämättä joka kerta huomaa, ellei tietenkin botti arvaa väärin, jolloin se häviää pelin. Kuitenkin isommissa kentissä botin häviämisprosentti alkaa olemaan jo kohtalaisen suuri.

## Aikavaativuus ja suortuskyky

Botin aikavaativuudeksi jäi _O(n*2^n)_, sillä pahimmassa tapauksessa peliruudukon jokaiselle reunaruudulle (n kappaletta) kokeillaan backtracking-algoritmia, joka käy nämä reunaruudut edelleen läpi etsien siirtoa, joka tarkasteltavaan ruutuun voidaan täydellä varmuudella tehdä. Algoritmi siis lähtien ruudusta k kokeilee rekursiivisesti jokaiselle reunaruudulle, onko tämä sallittua liputtaa tai avata riippuen edellisistä valinnoista. Mikäli päädytään sellaiseen ketjuun, että sallittuja ketjuja tuli ainoastaan silloin, kun k joko liputettiin tai avattiin, voidaan tuo kyseinen siirto tehdä ruudulle k. Mikäli taas päädyttii tilanteeseen, että molemmat ovat sallittuja tai kumpikaan ei ole sallittu, on algoritmin siirryttävä tarkastelemaan jotakin toista reunaruutua aloitusruutuna. Mikäli millekkään aloitusruudulle ei löytynyt varmaa siirtoa, avaa algoritmi viimeiseksi tarkastettavana olleen aloitusruudun, eli "arvaa" tämän.

Tehokkuustestausta voi tarkastella tarkemmin [testausdokumentista](https://github.com/hackinen/Miinaharavaratkaisija/blob/master/dokumentaatio/testausdokumentti.md), jossa bottia on testattu eri kokoisilla kentillä ja (mahdolliseen) ratkaisemiseen kulunut aika listattu taulukkoon.

Kaikenkaikkiaan algoritmi toimii järkevässä ajassa pienillä kentillä, mutta kentän koon kasvaessa kasvaa myös todennäköisyys sellaisille tilanteille, joissa tarkasteltavia reunaruutuja alkaa olla niin paljon, että mikäli varmaa siiroa ei löydy helposti tai erityisesti tarkasteltavien ruutujen alkupäästä, kuluu algoritmilla jo useita minuutteja ratkaisun löytämiseen. Erityisesti jos ollaan päädytty tilanteeseen, jossa on pakko arvata, joudutaan tätä arvausta odottamaan todella kauan.

## Kehitysideoita

Tehokkuutta oltaisiin voitu parantaa jaoittelemalla tarkasteltava kiinnostavien reunaruutujen alue osa-alueisiin sen mukaan, muodostavatko reunaruudut yhtenäisen alueen. Tällöin rekursio suurimmassa kentässä olisi useissa tilanteissa huomattavasti pienempi, eikä siksi veisi huonoimmassa tapauksessa älyttömästi aikaa.

Lisäksi arvaamista oltaisiin voitu parantaa lisämällä ohjelmaan todennäköisyyksiä ylläpitävä toiminto. Tällöin päädyttäessä pattitilanteeseen voisi botti arvata kaikista pienimmällä todennäköisyydellä miinan sisältävän ruudun. Ohjelman tässä muodossa botti ei siis oikeastaan edes "arvaa", vaan avaa aina viimeisenä tarkasteltavan aloitusruudun, jos mitään varmaa siirtoa ei löytynyt.
