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
